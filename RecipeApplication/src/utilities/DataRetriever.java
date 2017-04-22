package utilities;
import application.friendIngredientsPanel;
import application.Client;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Message;
import server.Server;
import server.SendableMessage;

public class DataRetriever extends Thread {
    private static DataRetriever instance = null;
    private ArrayList<friendIngredientsPanel> otherClientPanels = new ArrayList<>();
    private Socket s;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private Client c;
    
    private DataRetriever(Client c) {
        try {
            s = new Socket(InetAddress.getLocalHost(), 5000);
            os = new ObjectOutputStream(s.getOutputStream());//For sending ingredient name
            is = new ObjectInputStream(s.getInputStream());//For Receiving Recipe
            this.c = c;
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DataRetriever getInstance(Client c) {
        if (instance == null) {
            instance = new DataRetriever(c);
        }
        return instance;
    }

    public void shutdown() {
        try {
            os.writeObject(null);
            is.close();
            os.close();
            s.close();
            instance = null;
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addIngredient(RecipeIngredient ri) {
        SendableMessage m = new Message(Server.ADD_INGREDIENT_TITLE, ri);
        try {
            os.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendRecipeListToClient(ArrayList<RecipeIF> recipeList) {
        c.displayRecipeList(recipeList);
    }
    
    private void sendIngredientListToClient(ArrayList<RecipeIngredientIF> ingList) {
        c.displayOthersIngredients(ingList);
    }
    
    @Override
    public void run() {
        while(!s.isClosed()) {
            try {
                SendableMessage incomingObject;
                while ((incomingObject = (SendableMessage)is.readObject()) != null) {
                    int clientID = incomingObject.getMessageSenderID();
                    switch(incomingObject.getMessageTitle()) {
                        case Server.SEND_INGREDIENT_LIST_TITLE:
                            ArrayList<RecipeIngredientIF> ingList = (ArrayList) incomingObject.getMessageContent();
                            sendIngredientListToClient(ingList);
                            break;
                        case Server.SEND_RECIPE_LIST_TITLE:
                            ArrayList<RecipeIF> recipeList = (ArrayList)incomingObject.getMessageContent();
                            sendRecipeListToClient(recipeList);
                            break;
                        case Server.ADD_NEW_CLIENT_TITLE:
                            friendIngredientsPanel p = new friendIngredientsPanel(clientID);
                            otherClientPanels.add(p);
                            c.addPanel(p);
                            break;
                        case Server.REMOVE_CLIENT_TITLE:
                            for (friendIngredientsPanel panel : otherClientPanels) {
                                if (panel.getID() == clientID){
                                    otherClientPanels.remove(panel);
                                    c.removePanel(panel);
                                    break;
                                }
                            }
                            break;
                        case Server.WELCOME_TITLE:
                            ingList = (ArrayList)incomingObject.getMessageContent();
                            p = new friendIngredientsPanel(clientID);
                            otherClientPanels.add(p);
                            c.addPanel(p);
                            p.setIngredientList(ingList);
                            break;
                        default:
                            break;
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
