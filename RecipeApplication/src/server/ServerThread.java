package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.RecipeIF;
import utilities.RecipeIngredientIF;

class ServerThread extends Thread {

    private final Socket s;
    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private final ArrayList<RecipeIngredientIF> ingredientList = new ArrayList<>();
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

    ArrayList<RecipeIngredientIF> getIngredientList() {
        return ingredientList;
    }

    int getClientID() {
        return ID;
    }

    @Override
    public void run() {
        try {
            sendMessage(new Message(Server.ADD_NEW_CLIENT_TITLE, null, this));
            SendableMessage m;
            while ((m = (SendableMessage) is.readObject()) != null) {
                switch (m.getMessageTitle()) {
                    case Server.ADD_INGREDIENT_TITLE:
                        RecipeIngredientIF newIngredient = (RecipeIngredientIF)m.getMessageContent();
                        ingredientList.add(newIngredient);
                        sendMessage(new Message(Server.SEND_INGREDIENT_LIST_TITLE, ingredientList, this));
                        break;
                    case Server.RMV_INGREDIENT_TITLE:
                        RecipeIngredientIF ingredientToRemove = (RecipeIngredientIF)m.getMessageContent();
                        ingredientList.remove(ingredientToRemove);
                        sendMessage(new Message(Server.SEND_INGREDIENT_LIST_TITLE, ingredientList, this));
                    case Server.MODIFY_RECIPE:
                        //Transfer request to server. 
                        sendMessage(new Message(Server.MODIFY_RECIPE, m.getMessageContent(), this));
                    case Server.ADD_FILTER_TITLE:
                        sendMessage(new Message(Server.ADD_FILTER_TITLE, m.getMessageContent(), this));
                        break;
                    default:
                        break;
                }
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
            Server.sendMessage(new Message(Server.SEND_RECIPE_LIST_TITLE, null, this));
        } finally {
            scheduler.done();//Tell scheduler we've sent our message.
        }
    }
}
