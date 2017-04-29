package utilities;

import java.util.ArrayList;

public class RecipeWrapper extends Recipe{
    private RecipeIF recipe;
    private RecipeIngredientIF ingredient;
    
    public RecipeWrapper(RecipeIF r, RecipeIngredientIF ri) {
        super(r.getName(), r.getDirections(), r.getDesc(), r.getPrepTime(), r.getCookTime(), r.getBaseIngredients());
        recipe = r;
        ingredient = ri;
    }
    
    @Override
    public ArrayList<RecipeIngredientIF> getIngredients() {
        ArrayList<RecipeIngredientIF> baseIngredients = getBaseIngredients();
        ArrayList<RecipeIngredientIF> addedIngredients = getAddedIngredients();
        ArrayList<RecipeIngredientIF> ingredients = new ArrayList<>();
        if (baseIngredients != null){
            ingredients.addAll(baseIngredients);
        }
        if (addedIngredients != null){
            ingredients.addAll(addedIngredients);
        }
        return ingredients;
    }
    
    @Override
    public ArrayList<RecipeIngredientIF> getAddedIngredients() {
        ArrayList<RecipeIngredientIF> ingredients = new ArrayList<>();
        if (getBaseRecipe() != null && getBaseRecipe().getAddedIngredients() != null) {
            ingredients.addAll(getBaseRecipe().getAddedIngredients());
        }
        if (recipe != null && ingredient != null) {
            ingredients.add(ingredient);
        }
        return ingredients;
    }
    
    @Override 
    public RecipeIngredientIF getAddedIngredient() {
        return ingredient;
    }
    
    @Override
    public boolean removeIngredient(RecipeIngredientIF ingredient){
        boolean removalResult = super.removeIngredient(ingredient);
         if (!removalResult) {
             removalResult = removeAddedIngredient(ingredient);
         }
         return removalResult;
    }
    
    @Override
    public RecipeIF getBaseRecipe() {
        return recipe;
    }
    
    @Override
    public boolean removeAddedIngredient(RecipeIngredientIF ingredient) {
        if (this.ingredient == null) {
            //base recipe was deleted.
            return false;
        } else if (this.ingredient == ingredient) {
            this.ingredient = null;
            return true;
        } else {
            return recipe.removeAddedIngredient(ingredient);
        }
    }
}
