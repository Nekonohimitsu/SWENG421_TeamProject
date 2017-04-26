package utilities;

import java.io.Serializable;
import java.util.ArrayList;

public interface RecipeIF extends Serializable {
    String getName();
    String getDesc();
    String getDirections();
    int getCalories();
    int getServingSize();
    String getPrepTime();
    String getCookTime();
    ArrayList<RecipeIngredientIF> getIngredients();
    ArrayList<RecipeIngredientIF> getBaseIngredients();
    void setName(String name);
    void setDesc(String desc);
    void setDirections(String directions);
    void setCalories(int calories);
    void setServingSize(int servingSize);
    void setPrepTime(String prepTime);
    void setCookTime(String cookTime);
    RecipeIF getBaseRecipe();
    boolean removeAddedIngredient(RecipeIngredientIF ingredient);
    RecipeIngredientIF getAddedIngredient();
    ArrayList<RecipeIngredientIF> getAddedIngredients();
    RecipeIF addIngredient(RecipeIngredientIF ri);
    boolean removeIngredient(RecipeIngredientIF ingredientName);
    @Override
    String toString();
}
