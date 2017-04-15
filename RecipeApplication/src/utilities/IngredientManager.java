//package utilities;
//import java.util.ArrayList;
//
//public class IngredientManager {
//    private static IngredientManager instance = null;
//    private static final ArrayList<Ingredient> ingredientList = new ArrayList<>();
//    private static final IngredientFactory ingredientFactory = new IngredientFactory();
//    
//    private IngredientManager() {}
//    public static IngredientManager getInstance() {
//        if (instance == null) {
//            instance = new IngredientManager();
//            IngredientFactory.refreshIngredientList();
//        }
//        return instance;
//    }
//    
//    public void updateList(String ingredientName, DataRetriever dr) {
//        Ingredient obtainedIngredient = ingredientFactory.getIngredient(ingredientName);
//        if (obtainedIngredient != null) {
//            ingredientList.add(obtainedIngredient);
//        }
//        dr.updateRecipes(ingredientList);
//    }
//}
