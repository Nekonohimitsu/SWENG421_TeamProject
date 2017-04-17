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
            sendMessage(new Message(ADD_NEW_CLIENT_TITLE, null, st));
            st.start();
       }
    }
    private static void removeClient(MessageAbs m) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != m.getMessageSender().getOutputStream()) {
                client.getOutputStream().writeObject(m);
            }
        }
        listOfClients.remove(m.getMessageSender());
        if (listOfClients.isEmpty()) currentID = 0;
    }
    
    private static void sendNewClient(MessageAbs m) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != m.getMessageSender().getOutputStream()) {
                client.getOutputStream().writeObject(m);
                //For each other client, send their information to the new client that just joined.
                MessageAbs welcomeMessage = new Message(WELCOME_TITLE, client.getIngredientList(), client);
                m.getMessageSender().getOutputStream().writeObject(welcomeMessage);
            }
        }
    }
    private static void sendRecipeList(MessageAbs m) throws IOException {
        for (ServerThread client : listOfClients) {
            client.getOutputStream().writeObject(m);
        }
    }
    private static void sendIngredientList(MessageAbs m) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != m.getMessageSender().getOutputStream()) {
                client.getOutputStream().writeObject(m);
            }
        }
    }
    
    static void sendMessage(MessageAbs m) throws IOException {
        switch (m.getMessageTitle()) {
            case SEND_INGREDIENT_LIST_TITLE:
                sendIngredientList(m);
                break;
            case REMOVE_CLIENT_TITLE:
                removeClient(m);
                break;
            case ADD_NEW_CLIENT_TITLE:
                sendNewClient(m);
                break;
            case SEND_RECIPE_LIST_TITLE:
                sendRecipeList(m);
                break;
            default:
                break;
        }
    }
}
