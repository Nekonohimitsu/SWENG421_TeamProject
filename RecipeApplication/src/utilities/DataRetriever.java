package utilities;
import java.util.ArrayList;

public class DataRetriever extends DataRetrieverAbs {
    private DataRetriever dr = null;
    
    public DataRetriever(DataRetriever filter) {
        dr = filter;
    }
    public DataRetriever() { }
    
    @Override
    public ArrayList<Recipe> retrieveData() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        if (dr != null) recipeList = dr.retrieveData();
        //Get data from database
        //Check with other obtained data, find only the inner set.
        return recipeList;
    }
}
