package utilities;

public class ReplacementFilter extends ReplacementFilterAbs {
    public ReplacementFilter(String ingredientToBeReplaced, String ingredientReplacing) {
        super(ingredientToBeReplaced, ingredientReplacing);
    }
    
    public ReplacementFilter(ReplacementFilterIF filter, String ingredientToBeReplaced, String ingredientReplacing) {
        super(filter, ingredientToBeReplaced, ingredientReplacing);
    }
}
