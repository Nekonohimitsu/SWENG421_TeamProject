package utilities;

import java.util.ArrayList;
import javafx.application.Application;

public abstract class DataRetrieverAbs implements DataRetrieverIF {
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private final ArrayList<Application> observers = new ArrayList<>();
    
    void updateRecipes(ArrayList<Ingredient> il) {
        //Retrieve list of recipes that match ingredients.
        recipeList = retrieveData();
        notifyClients();
    }
    
    @Override
    public abstract ArrayList<Recipe> retrieveData();
    
    @Override
    public void addObserver(Application client) {
        observers.add(client);
    }
    
    @Override
    public void rmvObserver(Application client) {
        observers.remove(client);
    }
    
    private void notifyClients() {
        for (Application client : observers) {
            client.displayRecipeList(recipeList);
        }
    }
}
