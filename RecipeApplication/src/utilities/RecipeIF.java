package utilities;

import java.util.ArrayList;

public interface RecipeIF {
    String getName();
    String getDesc();
    String getDirections();
    int getCalories();
    int getServingSize();
    String getPrepTime();
    String getCookTime();
    ArrayList<RecipeIngredientIF> getAddedIngredients();
    ArrayList<RecipeIngredientIF> getIngredients();
    ArrayList<RecipeIngredientIF> getBaseIngredients();
    RecipeIF getBaseRecipe();
    RecipeIngredientIF getAddedIngredient();
    void setName(String name);
    void setDesc(String desc);
    void setDirections(String directions);
    void setCalories(int calories);
    void setServingSize(int servingSize);
    void setPrepTime(String prepTime);
    void setCookTime(String cookTime);
    RecipeIF addIngredient(RecipeIngredientIF ri);
}
