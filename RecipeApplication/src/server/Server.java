package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static final ArrayList<ServerThread> listOfClients = new ArrayList<>();
    private static int currentID = 0;
    private final static Scheduler scheduler = new Scheduler();
    public static final String SEND_INGREDIENT_LIST_TITLE = "UpdateIngredientList";
    public static final String ADD_NEW_CLIENT_TITLE = "AddNewClient";
    public static final String REMOVE_CLIENT_TITLE = "RemoveClient";
    public static final String SEND_RECIPE_LIST_TITLE = "UpdateRecipeList";
    public static final String WELCOME_TITLE = "UpdatePanels";

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        while (true) {
            Socket s = ss.accept();
            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
            ServerThread st = new ServerThread(s, is, os, currentID++, scheduler);
            listOfClients.add(st);
            st.start();
        }
    }

    private static void removeClient(SendableMessage m, ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(m);
            }
        }
        listOfClients.remove(sendingClient);
        if (listOfClients.isEmpty()) {
            currentID = 0;
        }
    }

    private static void sendNewClient(SendableMessage m, ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(m);
                //For each other client, send their information to the new client that just joined.
                SendableMessage welcomeMessage = new Message(WELCOME_TITLE, client.getIngredientList(), client);
                sendingClient.getOutputStream().writeObject(welcomeMessage);
            }
        }
    }

    private static void sendRecipeList(SendableMessage m, ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            client.getOutputStream().writeObject(m);
        }
    }

    private static void sendIngredientList(SendableMessage m, ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(m);
            }
        }
    }

    static void sendMessage(SendableMessage m) throws IOException {
        ServerThread sendingClient = getClientViaID(m.getMessageSenderID());
        if (sendingClient != null) {
            switch (m.getMessageTitle()) {
                case SEND_INGREDIENT_LIST_TITLE:
                    sendIngredientList(m, sendingClient);
                    break;
                case REMOVE_CLIENT_TITLE:
                    removeClient(m, sendingClient);
                    break;
                case ADD_NEW_CLIENT_TITLE:
                    sendNewClient(m, sendingClient);
                    break;
                case SEND_RECIPE_LIST_TITLE:
                    sendRecipeList(m, sendingClient);
                    break;
                default:
                    break;
            }
        }
    }

    private static ServerThread getClientViaID(int ID) {
        for (ServerThread client : listOfClients) {
            if (client.getClientID() == ID) {
                return client;
            }
        }
        return null;
    }
}
