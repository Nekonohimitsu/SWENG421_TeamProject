package utilities;
import application.Client;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataRetriever extends Thread {
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private static DataRetriever instance = null;
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
    
    private ArrayList<Recipe> retrieveData(ArrayList<Ingredient> il) {
        //get data
        return recipeList;
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
    
    private void notifyClient() {
        c.displayRecipeList(recipeList);
    }
    
    @Override
    public void run() {
        while(!s.isClosed()) {
            try {
                Recipe r;
                while ((r = (Recipe)is.readObject()) != null) {
                    recipeList.add(r);
                    notifyClient();
                }
            } catch (IOException ex) {
                Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataRetriever.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
