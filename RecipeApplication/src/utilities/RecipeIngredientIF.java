package utilities;

import java.io.Serializable;

public interface RecipeIngredientIF extends Serializable {
    void setAmount(double amount);
    void setIngredient(String ingredientName);
    void setAmountType(String amountType);
    double getAmount();
    String getAmountType();
    String getIngredient();
    @Override
    String toString();
}
