package utilities;

import java.util.ArrayList;

public abstract class ReplacementFilterAbs implements ReplacementFilterIF{
    private ReplacementFilterIF filter = null;
    private String ingredientToBeReplaced;
    private String ingredientReplacing;
    
    public ReplacementFilterAbs(String ingredientToBeReplaced, String ingredientReplacing) {
        this.ingredientToBeReplaced = ingredientToBeReplaced;
        this.ingredientReplacing = ingredientReplacing;
    }
    
    public ReplacementFilterAbs(ReplacementFilterIF filter) {
        this.filter = filter;
    }
    
    @Override
    public RecipeIF applyReplacement(RecipeIF r) {
        if (filter != null) r = filter.applyReplacement(r);
        ArrayList<RecipeIngredientIF> ingredientList = r.getIngredients();
        for (RecipeIngredientIF ri : ingredientList) {
            if (ri.getIngredient().equals(ingredientToBeReplaced)) {
                ri.setIngredient(ingredientReplacing);
            }
        }
        return r;
    }
}
