//package utilities;
//
//import application.Client;
//import java.util.ArrayList;
//
//public class GlutenFreeDataRetriever extends DataRetriever {
//    public GlutenFreeDataRetriever(Client c, DataRetriever filter) {
//        super(c, filter);
//    }
//    public GlutenFreeDataRetriever(Client c) { super(c); }
//    
//    @Override
//    public ArrayList<Recipe> retrieveData(ArrayList<Ingredient> il) {
//        ArrayList<Recipe> recipeList = super.retrieveData(il);
//        //Apply filter for GlutenFree only.
//        return recipeList;
//    }
//}
