package utilities;

import java.util.ArrayList;

public class LactoseFreeDataRetriever extends DataRetriever {
    public LactoseFreeDataRetriever(DataRetriever filter) {
        super(filter);
    }
    public LactoseFreeDataRetriever() { }
    
    @Override
    public ArrayList<Recipe> retrieveData() {
        ArrayList<Recipe> recipeList = super.retrieveData();
        //Apply filter for LactoseFree only.
        return recipeList;
    }
}
