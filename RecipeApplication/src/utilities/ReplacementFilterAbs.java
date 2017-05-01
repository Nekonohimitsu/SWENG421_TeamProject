package utilities;

import java.util.ArrayList;

public abstract class ReplacementFilterAbs implements ReplacementFilterIF{
    private ReplacementFilterIF filter = null;
    private final String ingredientToBeReplaced;
    private final String ingredientReplacing;
    
    public ReplacementFilterAbs(String ingredientToBeReplaced, String ingredientReplacing) {
        this.ingredientToBeReplaced = ingredientToBeReplaced;
        this.ingredientReplacing = ingredientReplacing;
    }
    
    public ReplacementFilterAbs(ReplacementFilterIF filter, String ingredientToBeReplaced, String ingredientReplacing) {
        this.filter = filter;
        this.ingredientToBeReplaced = ingredientToBeReplaced;
        this.ingredientReplacing = ingredientReplacing;
    }
    
    @Override
    public ArrayList<RecipeIF> applyReplacement(ArrayList<RecipeIF> rl) {
        if (filter != null) rl = filter.applyReplacement(rl);
        for (RecipeIF r : rl) {
            r.setDirections(r.getDirections().replaceAll("(?i)" + ingredientToBeReplaced, ingredientReplacing));
            ArrayList<RecipeIngredientIF> ingredientList = r.getIngredients();
            for (RecipeIngredientIF ri : ingredientList) {
                if (ri.getIngredient().toUpperCase().equals(ingredientToBeReplaced.toUpperCase())) {
                    ri.setIngredient(ingredientReplacing);
                }
            }
        }
        return rl;
    }
}
