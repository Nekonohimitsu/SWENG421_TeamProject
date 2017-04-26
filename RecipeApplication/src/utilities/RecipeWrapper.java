package utilities;

import java.util.ArrayList;

public class RecipeWrapper extends Recipe{
    private RecipeIF recipe;
    private final RecipeIngredientIF ingredient;
    
    public RecipeWrapper(RecipeIF r, RecipeIngredientIF ri) {
        super(r.getName(), r.getDirections(), r.getDesc(), r.getPrepTime(), r.getCookTime(), r.getBaseIngredients());
        recipe = r;
        ingredient = ri;
    }
    
    @Override
    public ArrayList<RecipeIngredientIF> getIngredients() {
        ArrayList<RecipeIngredientIF> ingredients = new ArrayList<>();
        ingredients.addAll(getBaseIngredients());
        ingredients.addAll(getAddedIngredients());
        return ingredients;
    }
    
    private ArrayList<RecipeIngredientIF> getAddedIngredients() {
        ArrayList<RecipeIngredientIF> addedIngredients = new ArrayList<>();
        if (recipe != null) {
            addedIngredients.add(ingredient);
        }
        return addedIngredients;
    }
    
    @Override
    public boolean removeIngredient(RecipeIngredientIF ingredient){
        boolean removalResult = super.removeIngredient(ingredient);
         if (!removalResult) {
             removalResult = removeAddedIngredient(ingredient);
         }
         return removalResult;
    }
    
    private boolean removeAddedIngredient(RecipeIngredientIF ingredient) {
        if (ingredient == this.ingredient) {
            //Set Current recipe to last recipe.
            return true;
        } else if (this.ingredient != null) {
            return ((RecipeWrapper)recipe).removeAddedIngredient(ingredient);
        } else {
            return false;
        }
    }
}
