package utilities;
import java.util.ArrayList;

public class IngredientManager {
    private static IngredientManager instance = null;
    private final ArrayList<Ingredient> ingredientList = new ArrayList<>();
    private final IngredientFactory ingredientFactory = new IngredientFactory();
    
    private IngredientManager() {}
    public static IngredientManager getInstance() {
        if (instance == null) {
            instance = new IngredientManager();
        }
        return instance;
    }
    
    public void updateList(String ingredientName, DataRetriever dr) {
        Ingredient obtainedIngredient = ingredientFactory.getIngredient(ingredientName);
        if (obtainedIngredient != null) {
            ingredientList.add(obtainedIngredient);
        }
        dr.updateRecipes(ingredientList);
    }
}
