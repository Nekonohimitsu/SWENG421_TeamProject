package utilities;

import application.*;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Message;
import server.Server;
import server.SendableMessage;

public class DataRetriever extends Thread {

    private static DataRetriever instance = null;
    private ArrayList<DynamicPanel> otherClientPanels = new ArrayList<>();
    private Socket s;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private final Client c;

    private DataRetriever(Client c) {
        this.c = c;
        try {
            s = new Socket(InetAddress.getLocalHost(), 5000);
            os = new ObjectOutputStream(s.getOutputStream());//For sending ingredient name
            is = new ObjectInputStream(s.getInputStream());//For Receiving Recipe
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
        if (os != null) {
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
    }
    
    public void removeIngredient(RecipeIngredientIF ri) {
        SendableMessage m = new Message(Server.RMV_INGREDIENT_TITLE, ri);
        try {
            os.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addIngredient(RecipeIngredientIF ri) {
        SendableMessage m = new Message(Server.ADD_INGREDIENT_TITLE, ri);
        try {
            os.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendRecipe(RecipeIF r) {
        SendableMessage m = new Message(Server.MODIFY_RECIPE, r);
        try {
            os.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendSearchRequest(String recipeName) {
        SendableMessage m = new Message(Server.SEARCH_RECIPE, recipeName);
        try {
            os.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendFilter(String oldIng, String newIng) {
        String[] content = {oldIng, newIng};
        SendableMessage m = new Message(Server.ADD_FILTER_TITLE, content);
        try {
            os.writeObject(m);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendRecipeListToClient(ArrayList<RecipeIF> recipeList) {
        c.displayRecipeList(recipeList);
    }

    private void updateIngredientListInPanel(int ID, ArrayList<RecipeIngredientIF> il) {
        for (DynamicPanel p : otherClientPanels) {
            if (p.getID() == ID) {
                p.setIngredientList(il);
                break;
            }
        }
    }

    @Override
    public void run() {
        while (!s.isClosed()) {
            try {
                SendableMessage incomingObject;
                while (((incomingObject = (SendableMessage) is.readObject()) != null) && !s.isClosed()) {
                    int clientID = incomingObject.getMessageSenderID();
                    switch (incomingObject.getMessageTitle()) {
                        case Server.SEND_INGREDIENT_LIST_TITLE:
                            ArrayList<RecipeIngredientIF> ingList = (ArrayList) incomingObject.getMessageContent();
                            updateIngredientListInPanel(clientID, ingList);
                            break;
                        case Server.SEND_RECIPE_LIST_TITLE:
                            ArrayList<RecipeIF> recipeList = (ArrayList) incomingObject.getMessageContent();
                            sendRecipeListToClient(recipeList);
                            break;
                        case Server.ADD_NEW_CLIENT_TITLE:
                            DynamicPanel p = new DynamicPanel(clientID);
                            otherClientPanels.add(p);
                            c.addPanel(p);
                            break;
                        case Server.REMOVE_CLIENT_TITLE:
                            for (DynamicPanel panel : otherClientPanels) {
                                if (panel.getID() == clientID) {
                                    otherClientPanels.remove(panel);
                                    c.removePanel(panel);
                                    break;
                                }
                            }
                            break;
                        case Server.WELCOME_TITLE:
                            ingList = (ArrayList) incomingObject.getMessageContent();
                            p = new DynamicPanel(clientID);
                            otherClientPanels.add(p);
                            c.addPanel(p);
                            p.setIngredientList(ingList);
                            break;
                        case Server.MODIFY_RECIPE_RESPONSE:
                            boolean response = (boolean)incomingObject.getMessageContent();
                            synchronized(c) {
                                c.setResponse(response);
                                c.notify();
                            }
                            break;
                        case Server.SEARCH_RECIPE_RESPONSE:
                            RecipeIF result = (RecipeIF)incomingObject.getMessageContent();
                            c.displaySearchResult(result);
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
