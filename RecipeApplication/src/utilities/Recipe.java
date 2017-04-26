package utilities;

import java.util.ArrayList;

public class Recipe extends RecipeAbs {
    public Recipe(String name, String directions, ArrayList<RecipeIngredientIF> baseIngredients) {
        super(name, directions, baseIngredients);
    }
    public Recipe(String name, String directions, String prepTime, String cookTime, ArrayList<RecipeIngredientIF> baseIngredients) {
        super (name, directions, prepTime, cookTime, baseIngredients);
    }
    public Recipe(String name, String desc, String directions, String prepTime, String cookTime, ArrayList<RecipeIngredientIF> baseIngredients) {
        super(name, desc, directions, prepTime, cookTime, baseIngredients);
    }
}
