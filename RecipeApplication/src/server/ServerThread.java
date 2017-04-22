package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Recipe;

class ServerThread extends Thread {

    private final Socket s;
    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private final ArrayList<String> ingredientList = new ArrayList<>();
    private final int ID;
    private final Scheduler scheduler;

    ServerThread(Socket s, ObjectInputStream is, ObjectOutputStream os, int clientID, Scheduler scheduler) {
        this.s = s;
        this.is = is;
        this.os = os;
        this.ID = clientID;
        this.scheduler = scheduler;
    }

    ObjectOutputStream getOutputStream() {
        return os;
    }

    ArrayList<String> getIngredientList() {
        return ingredientList;
    }

    int getClientID() {
        return ID;
    }

    @Override
    public void run() {
        try {
            sendMessage(new Message(Server.ADD_NEW_CLIENT_TITLE, null, this));
            Recipe r = new Recipe("Foo.");
            ArrayList<Recipe> rl = new ArrayList<>();
            rl.add(r);
            Recipe r2;
            ingredientList.add("Maybe.");
            ingredientList.add("This...");
            ingredientList.add("Works!?");
            while ((r2 = (Recipe) is.readObject()) != null) {
                sendMessage(new Message(Server.SEND_RECIPE_LIST_TITLE, rl, this));
                sendMessage(new Message(Server.SEND_INGREDIENT_LIST_TITLE, ingredientList, this));
            }
            sendMessage(new Message(Server.REMOVE_CLIENT_TITLE, null, this));
            is.close();
            os.close();
            s.close();
        } catch (IOException | ClassNotFoundException | InterruptedException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendMessage(SendableMessage m) throws InterruptedException, IOException {
        scheduler.enter();
        try {
            //It's our turn if we're here.
            Server.sendMessage(m);
        } finally {
            scheduler.done();//Tell scheduler we've sent our message.
        }
    }
}
