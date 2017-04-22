package utilities;

public abstract class RecipeIngredientAbs implements RecipeIngredientIF{
    private Ingredient ingredient;
    private String amountType;
    private double amount;
    private IngredientFactory factory;
    
    private RecipeIngredientAbs() {}
    public RecipeIngredientAbs(String ingredientName, double amount, String amountType) {
        this.amountType = amountType;
        this.amount = amount;
        this.ingredient = factory.getIngredient(ingredientName);
    }
    
    @Override
    public void setAmount(double amount){
        this.amount = amount;
    }
    @Override
    public void setIngredient(String ingredientName){
        this.ingredient = factory.getIngredient(ingredientName);
    }
    @Override
    public void setAmountType(String amountType){
        this.amountType = amountType;
    }
    @Override
    public double getAmount() {
        return amount;
    }
    @Override
    public String getAmountType() {
        return amountType;
    }
    @Override
    public String getIngredient() {
        return ingredient.getName();
    }
}
