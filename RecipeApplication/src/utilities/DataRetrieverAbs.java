//package utilities;
//
//import application.Client;
//import java.util.ArrayList;
//
//public abstract class DataRetrieverAbs extends Thread implements DataRetrieverIF {
//    private static ArrayList<Recipe> recipeList = new ArrayList<>();
//    private final ArrayList<Client> observers = new ArrayList<>();
//    
//    void updateRecipes(ArrayList<Ingredient> il) {
//        //Retrieve list of recipes that match ingredients.
//        System.out.println("Ingredients: ");
//        for(Ingredient i : il) System.out.println(i.toString());
//        recipeList = retrieveData(il);
//        notifyClients();
//    }
//    
//    void setRecipeList(ArrayList<Recipe> rl) { this.recipeList = rl; }
//    ArrayList<Recipe> getRecipeList() { return recipeList; }
//    @Override
//    public abstract ArrayList<Recipe> retrieveData(ArrayList<Ingredient> il);
//    
//    @Override
//    public void addObserver(Client client) {
//        System.out.println("Adding observer.");
//        observers.add(client);
//    }
//    
//    @Override
//    public void rmvObserver(Client client) {
//        observers.remove(client);
//    }
//    
//    private void notifyClients() {
//        for (Client client : observers) {
//            client.displayRecipeList(recipeList);
//        }
//    }
//}
