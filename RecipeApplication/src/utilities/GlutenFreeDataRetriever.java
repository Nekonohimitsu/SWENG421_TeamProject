package utilities;

import java.util.ArrayList;

public class GlutenFreeDataRetriever extends DataRetriever {
    public GlutenFreeDataRetriever(DataRetriever filter) {
        super(filter);
    }
    public GlutenFreeDataRetriever() { }
    
    @Override
    public ArrayList<Recipe> retrieveData() {
        ArrayList<Recipe> recipeList = super.retrieveData();
        //Apply filter for GlutenFree only.
        return recipeList;
    }
}
