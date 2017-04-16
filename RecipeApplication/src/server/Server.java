package server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import utilities.Recipe;

public class Server {
    private static final ArrayList<ServerThread> listOfClients = new ArrayList<>();
    private static int currentID = 0;
    public static final String SEND_INGREDIENT_LIST_TITLE = "UpdateIngredientList";
    public static final String ADD_NEW_CLIENT_TITLE = "AddNewClient";
    public static final String REMOVE_CLIENT_TITLE = "RemoveClient";
    public static final String SEND_RECIPE_LIST_TITLE = "UpdateRecipeList";
    public static final String WELCOME_TITLE = "UpdatePanels";
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        while(true) {
            Socket s = ss.accept();
            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
            ServerThread st = new ServerThread(s, is, os, currentID++);
            listOfClients.add(st);
            sendMessage(st, ADD_NEW_CLIENT_TITLE, null);
            st.start();
       }
    }
    private static void removeClient(ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(REMOVE_CLIENT_TITLE);
                client.getOutputStream().writeObject(sendingClient.getClientID());
            }
        }
        listOfClients.remove(sendingClient);
        if (listOfClients.isEmpty()) currentID = 0;
    }
    
    private static void sendNewClient(ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(ADD_NEW_CLIENT_TITLE);
                client.getOutputStream().writeObject(sendingClient.getClientID());
                //For each other client, send their information to the new client that just joined.
                sendingClient.getOutputStream().writeObject(WELCOME_TITLE);
                sendingClient.getOutputStream().writeObject(client.getClientID());
                sendingClient.getOutputStream().writeObject(client.getIngredientList());
            }
        }
    }
    private static void sendRecipeList(ArrayList<Recipe> r) throws IOException {
        for (ServerThread client : listOfClients) {
            client.getOutputStream().writeObject(SEND_RECIPE_LIST_TITLE);
            client.getOutputStream().writeObject(r);
        }
    }
    private static void sendIngredientList(ServerThread sendingClient, ArrayList<String> ingList) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(SEND_INGREDIENT_LIST_TITLE);
                client.getOutputStream().writeObject(sendingClient.getClientID());
                client.getOutputStream().writeObject(ingList);
            }
        }
    }
    
    static void sendMessage(ServerThread sendingClient, String messageTitle, Object messageContent) throws IOException {
        switch (messageTitle) {
            case SEND_INGREDIENT_LIST_TITLE:
                sendIngredientList(sendingClient, (ArrayList)messageContent);
                break;
            case REMOVE_CLIENT_TITLE:
                removeClient(sendingClient);
                break;
            case ADD_NEW_CLIENT_TITLE:
                sendNewClient(sendingClient);
                break;
            case SEND_RECIPE_LIST_TITLE:
                sendRecipeList((ArrayList) messageContent);
                break;
            default:
                break;
        }
    }
}
