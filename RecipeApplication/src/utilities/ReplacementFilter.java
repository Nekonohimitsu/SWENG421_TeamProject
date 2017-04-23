package utilities;

public class ReplacementFilter extends ReplacementFilterAbs {
    public ReplacementFilter(String ingredientToBeReplaced, String ingredientReplacing) {
        super(ingredientToBeReplaced, ingredientReplacing);
    }
    
    public ReplacementFilter(ReplacementFilterIF filter) {
        super(filter);
    }
}
