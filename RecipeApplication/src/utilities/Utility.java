package utilities;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import server.IngredientFactory;

public class Utility {
    public static DefaultListModel modifyList(JList list, ArrayList info) {
        if (info != null){
            DefaultListModel lm = new DefaultListModel();

            for (Object o : info) {
                lm.addElement(o);
            }
            list.setModel(lm);
            return lm;
        }
        return null;
    }
    
    public static RecipeIngredientIF createRecipeIngredient(String ingredientName, double amount, String amount_type) {
        if (checkIfIngredientExists(ingredientName)) {
            return new RecipeIngredient(ingredientName, amount, amount_type);
        } else {
            return null;
        }
    }
    
    public static boolean checkForRepeatIngredient(RecipeIngredientIF ri, ArrayList<RecipeIngredientIF> ingredients) {
        if (ingredients != null){
            for (RecipeIngredientIF ingredient : ingredients) {
                if (ingredient.getIngredient().toUpperCase().equals(ri.getIngredient().toUpperCase()))
                        return true;
            }
        }
        return false;
    }
    
    public static boolean checkIfIngredientExists(String ingredientName) {
        return IngredientFactory.getFactory().getIngredient(ingredientName) != null;
    }
    
    public static String formatRecipe(RecipeIF r) {
        String ingredients = "";
        // for every ingredient in the recipe, create a list item and store in ingredients
        for (int i = 0; i < r.getIngredients().size(); i++){
            ingredients = ingredients + "<li>" + r.getIngredients().get(i) + "</li>";
        }
        
        return "<html><head><title>Recipe</title><style>body {font-family: \"Verdana\"; font-size: 9px; padding: 5px;}" +
                ".name {font-family: \"Bookman Old Style\"; font-size: 20px;} .time {color: grey;}" +
                ".ingredients {} .directions { font-size: 12px; padding: 5px; background-color: #dbefdc;}</style></head><body>" +
		"<div class=\"name\"><b>" + r.getName() + "</b></div><br>" +
                "<div class=\"time\"><b>Prep Time:</b> " + r.getPrepTime() + "<br><b>Cook Time:</b> " + r.getCookTime() + "</div><br>" +
                "<div><b>Ingredients:</b><ol class=\"ingredients\">" + ingredients + "</ol></div>" +
                "<hr><div align=\"center\"><b>DIRECTIONS</b></div><p class=\"directions\">" + r.getDirections() + "</p>" +
                "</body></html>";
    }
}
