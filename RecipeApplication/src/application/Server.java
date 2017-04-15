package application;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import utilities.Recipe;

public class Server {
    private static ArrayList<ObjectOutputStream> listOfClients = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        while(true) {
            Socket s = ss.accept();
            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
            listOfClients.add(os);
            ServerThread st = new ServerThread(s, is, os);
            st.start();
       }
    }
    public static void removeClient(ObjectOutputStream clientOS) {
        listOfClients.remove(clientOS);
    }
    public static void notifyClients(Recipe r) throws IOException {
        for (ObjectOutputStream clientOS : listOfClients) {
            clientOS.writeObject(r);
        }
    }
}
