package utilities;

import java.util.ArrayList;

public abstract class RecipeAbs implements RecipeIF{
    private String name;
    private String desc;
    private String directions;
    private int calories;
    private int servingSize;
    private String prepTime;
    private String cookTime;
    private ArrayList<RecipeIngredientIF> baseIngredients = new ArrayList<>();
    
    private RecipeAbs() {}
    public RecipeAbs(String name, String directions, ArrayList<RecipeIngredientIF> baseIngredients) {
        this.name = name;
        this.directions = directions;
        this.baseIngredients = baseIngredients;
    }
    public RecipeAbs(String name, String directions, String prepTime, String cookTime, ArrayList<RecipeIngredientIF> baseIngredients) {
        this.name = name;
        this.prepTime = prepTime;
        this.directions = directions;
        this.cookTime = cookTime;
        this.baseIngredients = baseIngredients;
    }
    public RecipeAbs(String name, String desc, String directions, String prepTime, String cookTime, ArrayList<RecipeIngredientIF> baseIngredients) {
        this.name = name;
        this.desc = desc;
        this.directions = directions;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.baseIngredients = baseIngredients;
    }
    
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDesc() {
        return desc;
    }
    @Override
    public String getDirections() {
        return directions;
    }
    @Override
    public int getCalories() {
        return calories;
    }
    @Override
    public int getServingSize() {
        return servingSize;
    }
    @Override
    public String getPrepTime() {
        return prepTime;
    }
    @Override
    public String getCookTime() {
        return cookTime;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public void setDirections(String directions) {
        this.directions = directions;
    }
    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }
    @Override
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }
    @Override
    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }
    @Override
    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }
    
    @Override
    public RecipeIF addIngredient(RecipeIngredientIF ri){
        return new RecipeWrapper(this, ri);
    }
    
    @Override
    public ArrayList<RecipeIngredientIF> getIngredients() {
        return baseIngredients;
    }
    
    @Override
    public ArrayList<RecipeIngredientIF> getBaseIngredients() {
        return baseIngredients;
    }
    
    @Override
    public String toString() {
        return name + " - Prep Time: " + prepTime + " / CookTime: " + cookTime;
    }
    @Override
    public boolean removeIngredient(RecipeIngredientIF ingredient){
        if (baseIngredients != null){
            return baseIngredients.remove(ingredient);
        }
        return false;
    }
    @Override
    public RecipeIF getBaseRecipe() {
        return null;
    }
    @Override
    public boolean removeAddedIngredient(RecipeIngredientIF ingredient) {
        return false;
    }
    @Override 
    public RecipeIngredientIF getAddedIngredient() {
        return null;
    }
    @Override
    public ArrayList<RecipeIngredientIF> getAddedIngredients() {
        return null;
    }
}
