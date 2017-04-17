package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Recipe;

class ServerThread extends Thread{
    private final Socket s;
    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private final ArrayList<String> ingredientList = new ArrayList<>();
    private final int ID;
    
    ServerThread(Socket s, ObjectInputStream is, ObjectOutputStream os, int clientID) {
        this.s = s;
        this.is = is;
        this.os = os;
        this.ID = clientID;
    }
    
    ObjectOutputStream getOutputStream() { return os; }
    ArrayList<String> getIngredientList() { return ingredientList; }
    int getClientID() { return ID; }
    
    @Override
    public void run() {
        try {
            Recipe r = new Recipe("Foo.");
            ArrayList<Recipe> rl = new ArrayList<>();
            rl.add(r);
            Recipe r2;
            ingredientList.add("Maybe.");
            ingredientList.add("This...");
            ingredientList.add("Works!?");
            while ((r2 = (Recipe)is.readObject()) != null) {
                Server.sendMessage(new Message(Server.SEND_RECIPE_LIST_TITLE, rl, this));
                Server.sendMessage(new Message(Server.SEND_INGREDIENT_LIST_TITLE, ingredientList, this));
            }
            Server.sendMessage(new Message(Server.REMOVE_CLIENT_TITLE, null, this));
            is.close();
            os.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
