package utilities;

public interface RecipeIngredientIF {
    void setAmount(double amount);
    void setIngredient(String ingredientName);
    void setAmountType(String amountType);
    double getAmount();
    String getAmountType();
    String getIngredient();
}
