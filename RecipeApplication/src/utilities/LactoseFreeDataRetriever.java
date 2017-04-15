//package utilities;
//
//import application.Client;
//import java.util.ArrayList;
//
//public class LactoseFreeDataRetriever extends DataRetriever {
//    public LactoseFreeDataRetriever(Client c, DataRetriever filter) {
//        super(c, filter);
//    }
//    public LactoseFreeDataRetriever(Client c) { super(c); }
//    
//    @Override
//    public ArrayList<Recipe> retrieveData(ArrayList<Ingredient> il) {
//        ArrayList<Recipe> recipeList = super.retrieveData(il);
//        //Apply filter for LactoseFree only.
//        return recipeList;
//    }
//}
