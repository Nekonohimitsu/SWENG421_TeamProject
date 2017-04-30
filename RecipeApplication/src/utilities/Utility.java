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
    
    public static ArrayList<Integer> searchArrayForIngredientName(RecipeIngredientIF ri, ArrayList<RecipeIngredientIF> ingredients) {
        ArrayList<Integer> indexList = new ArrayList<>();
        if (ingredients != null){
            for (RecipeIngredientIF ingredient : ingredients) {
                if (ingredient.getIngredient().toUpperCase().equals(ri.getIngredient().toUpperCase()))
                        indexList.add(ingredients.indexOf(ingredient));
            }
        }
        return indexList;
    }
    
    public static boolean checkIfIngredientExists(String ingredientName) {
        return IngredientFactory.getFactory().getIngredient(ingredientName) != null;
    }
    
    public static boolean isTeaspoon(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.equals("t") ||
            amountType.toUpperCase().equals("TEASPOON") ||
            amountType.toUpperCase().equals("TEASPOONS") ||
            amountType.toUpperCase().equals("TSP"));
    }
    
    public static boolean isTablespoon(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.equals("T") ||
            amountType.toUpperCase().equals("TABLESPOON") ||
            amountType.toUpperCase().equals("TABLESPOONS") ||
            amountType.toUpperCase().equals("TBSP"));
    }
    
    public static boolean isCup(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("C") ||
            amountType.toUpperCase().equals("CUP") ||
            amountType.toUpperCase().equals("CUPS"));
    }
    
    public static boolean isDash(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("DASH") ||
            amountType.toUpperCase().equals("DASHES"));
    }
    
    public static boolean isPinch(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("PINCH") ||
            amountType.toUpperCase().equals("PINCHES"));
    }
    
    public static boolean isPound(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("POUND") ||
            amountType.toUpperCase().equals("POUNDS") || 
            amountType.toUpperCase().equals("LB") ||
            amountType.toUpperCase().equals("LBS"));
    }
    
    public static boolean isDozen(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("DOZEN"));
    }
    
    public static boolean isGallon(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("GALLON") ||
            amountType.toUpperCase().equals("GALLONS") || 
            amountType.toUpperCase().equals("GAL") ||
            amountType.toUpperCase().equals("GALS"));
    }
    
    public static boolean isOunce(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("OUNCE") ||
            amountType.toUpperCase().equals("OUNCES") || 
            amountType.toUpperCase().equals("OZ") ||
            amountType.toUpperCase().equals("OZS"));
    }
    
    public static boolean isFluidOunce(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("FLUID OUNCE") ||
            amountType.toUpperCase().equals("FLUID OUNCES") || 
            amountType.toUpperCase().equals("FL OZ") ||
            amountType.toUpperCase().equals("FL OZS"));
    }
    
    public static boolean isPint(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("PINT") ||
            amountType.toUpperCase().equals("PINTS") || 
            amountType.toUpperCase().equals("PT") ||
            amountType.toUpperCase().equals("PTS"));
    }
    
    public static boolean isQuart(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("QUART") ||
            amountType.toUpperCase().equals("QUARTS") || 
            amountType.toUpperCase().equals("QT") ||
            amountType.toUpperCase().equals("QTS"));
    }
    
    public static boolean isGram(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("GRAM") ||
            amountType.toUpperCase().equals("GRAMS") || 
            amountType.toUpperCase().equals("G") ||
            amountType.toUpperCase().equals("GS"));
    }
    
    public static boolean isKilogram(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("KILOGRAM") ||
            amountType.toUpperCase().equals("KILOGRAM") || 
            amountType.toUpperCase().equals("KG") ||
            amountType.toUpperCase().equals("KGS"));
    }
    
    public static boolean isLiter(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("LITER") ||
            amountType.toUpperCase().equals("LITERS") || 
            amountType.toUpperCase().equals("L") ||
            amountType.toUpperCase().equals("LS"));
    }
    
    public static boolean isMililiter(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().equals("MILILITER") ||
            amountType.toUpperCase().equals("MILILITERS") || 
            amountType.toUpperCase().equals("ML") ||
            amountType.toUpperCase().equals("MLS"));
    }
    
    public static double convertToCups(String amountType, double amount) {
        double finalAmount;
        if (isTeaspoon(amountType)) {
            finalAmount = amount * 0.0208333;
        } else if (isTablespoon(amountType)) {
            finalAmount = amount * 0.0625;
        } else if (isDash(amountType)) {
            finalAmount = amount * (0.0208333 * (1.0/16.0)); //Dash is 1/16 tsp
        } else if (isPinch(amountType)) {
            finalAmount = amount * (0.0208333 * (1.0/8.0)); //Dash is 1/8 tsp
        } else if (isPound(amountType)) {
            finalAmount = amount * 2.0;
        } else if (isOunce(amountType) || isFluidOunce(amountType)) {
            finalAmount = amount * (1.0/8.0); //8 fl. oz is 1 cup
        } else if (isPint(amountType)) {
            finalAmount = amount * 2.0;
        } else if (isQuart(amountType)) {
            finalAmount = amount * 4.0;
        } else if (isGallon(amountType)) {
            finalAmount = amount * 16.0;
        } else if (isMililiter(amountType)) {
            finalAmount = amount * 0.0042267528399999995;
        } else if (isLiter(amountType)) {
            finalAmount = amount * 4.22675284;
        } else if (isGram(amountType)) {
            finalAmount = amount * (1/236.5882375);
        } else if (isKilogram(amountType)) {
            finalAmount = amount * 0.2365882375;
        } else if (isDozen(amountType)) {
            finalAmount = amount * 12.0;
        } else {
            //If it is cup, or if it is something we can't convert (slices) just return amount.
            finalAmount = amount;
        }
        return finalAmount;
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
