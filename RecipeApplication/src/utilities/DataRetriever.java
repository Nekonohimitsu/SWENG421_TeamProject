package utilities;
import application.SpecialPanel;
import application.Client;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

public class DataRetriever extends Thread {
    private static DataRetriever instance = null;
    private ArrayList<SpecialPanel> otherClientPanels = new ArrayList<>();
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
    public void addIngredient(String ingredientName) {
        try {
            Recipe r = new Recipe(ingredientName);
            os.writeObject(r);
        } catch (IOException ex) {
            Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sendRecipeListToClient(ArrayList<Recipe> recipeList) {
        c.displayRecipeList(recipeList);
    }
    
    private void sendIngredientListToClient(ArrayList<String> ingList) {
        c.displayOthersIngredients(ingList);
    }
    
    @Override
    public void run() {
        while(!s.isClosed()) {
            try {
                Object incomingObject;
                while ((incomingObject = is.readObject()) != null) {
                    System.out.println("Recieved Message: " + incomingObject.toString());
                    if (incomingObject.toString().equals(Server.SEND_INGREDIENT_LIST_TITLE)) {
                        //If it is updating ingredient list,
                        //We know it will be the client id next,
                        //Followed by an arraylist of ingredient names.
                        int clientID = (int)is.readObject();
                        ArrayList ingList = (ArrayList)is.readObject();
                        sendIngredientListToClient(ingList);
                    } else if (incomingObject.toString().equals(Server.SEND_RECIPE_LIST_TITLE)) {
                        //If it is update recipe list,
                        //Then next will be a recipe list.
                        ArrayList<Recipe> recipeList = (ArrayList)is.readObject();
                        sendRecipeListToClient(recipeList);
                    } else if (incomingObject.toString().equals(Server.ADD_NEW_CLIENT_TITLE)) {
                        int clientID = (int)is.readObject();
                        SpecialPanel p = new SpecialPanel(clientID);
                        otherClientPanels.add(p);
                        c.addPanel(p);
                    } else if (incomingObject.toString().equals(Server.REMOVE_CLIENT_TITLE)) {
                        int clientID = (int)is.readObject();
                        for (SpecialPanel p : otherClientPanels) {
                            if (p.getID() == clientID){
                                otherClientPanels.remove(p);
                                c.removePanel(p);
                                break;
                            }
                        }
                    }else if (incomingObject.toString().equals(Server.WELCOME_TITLE)) {
                        int clientID = (int)is.readObject();
                        ArrayList<String> ingList = (ArrayList) is.readObject();
                        SpecialPanel p = new SpecialPanel(clientID);
                        otherClientPanels.add(p);
                        c.addPanel(p);
                        p.setIngredientList(ingList);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
