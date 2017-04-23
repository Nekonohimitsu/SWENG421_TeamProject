package utilities;

import java.util.ArrayList;

public class RecipeWrapper extends Recipe{
    private final RecipeIF recipe;
    private final RecipeIngredientIF ingredient;
    
    public RecipeWrapper(RecipeIF r, RecipeIngredientIF ri) {
        super(r.getName(), r.getDirections(), r.getDesc(), r.getPrepTime(), r.getCookTime(), r.getIngredients());
        recipe = r;
        ingredient = ri;
    }
    
    @Override
    public ArrayList<RecipeIngredientIF> getAddedIngredients() {
        ArrayList<RecipeIngredientIF> addedIngredients = new ArrayList<>();
        if (recipe != null) {
            addedIngredients.addAll(recipe.getAddedIngredients());
        }
        addedIngredients.add(ingredient);
        return addedIngredients;
    }
    
    @Override
    public RecipeIF getBaseRecipe() {
        return recipe;
    }
    
    @Override
    public RecipeIngredientIF getAddedIngredient() {
        return ingredient;
    }
}
