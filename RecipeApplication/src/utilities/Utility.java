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
        return (amountType.matches(".*\\bt\\b.*") ||
            amountType.toUpperCase().matches(".*\\bTEASPOON\\b.*") ||
            amountType.toUpperCase().matches(".*\\bTEASPOONS\\b.*") ||
            amountType.toUpperCase().matches(".*\\bTSP\\b.*"));
    }
    
    public static boolean isTablespoon(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.matches(".*\\bT\\b.*") ||
            amountType.toUpperCase().matches(".*\\bTABLESPOON\\b.*") ||
            amountType.toUpperCase().matches(".*\\bTABLESPOONS\\b.*") ||
            amountType.toUpperCase().matches(".*\\bTBSP\\b.*"));
    }
    
    public static boolean isCup(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bC\\b.*") ||
            amountType.toUpperCase().matches(".*\\bCUP\\b.*") ||
            amountType.toUpperCase().matches(".*\\bCUPS\\b.*"));
    }
    
    public static boolean isDash(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bDASH\\b.*") ||
            amountType.toUpperCase().matches(".*\\bDASHES\\b.*"));
    }
    
    public static boolean isPinch(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bPINCH\\b.*") ||
            amountType.toUpperCase().matches(".*\\bPINCHES\\b.*"));
    }
    
    public static boolean isPound(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bPOUND\\b.*") ||
            amountType.toUpperCase().matches(".*\\bPOUNDS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bLB\\b.*") ||
            amountType.toUpperCase().matches(".*\\bLBS\\b.*"));
    }
    
    public static boolean isDozen(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bDOZEN\\b.*"));
    }
    
    public static boolean isGallon(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bGALLON\\b.*") ||
            amountType.toUpperCase().matches(".*\\bGALLONS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bGAL\\b.*") ||
            amountType.toUpperCase().matches(".*\\bGALS\\b.*"));
    }
    
    public static boolean isOunce(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bOUNCE\\b.*") ||
            amountType.toUpperCase().matches(".*\\bOUNCES\\b.*") || 
            amountType.toUpperCase().matches(".*\\bOZ\\b.*") ||
            amountType.toUpperCase().matches(".*\\bOZS\\b.*"));
    }
    
    public static boolean isFluidOunce(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bFLUID OUNCE\\b.*") ||
            amountType.toUpperCase().matches(".*\\bFLUID OUNCES\\b.*") || 
            amountType.toUpperCase().matches(".*\\bFL OZ\\b.*") ||
            amountType.toUpperCase().matches(".*\\bFL OZS\\b.*"));
    }
    
    public static boolean isPint(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bPINT\\b.*") ||
            amountType.toUpperCase().matches(".*\\bPINTS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bPT\\b.*") ||
            amountType.toUpperCase().matches(".*\\bPTS\\b.*"));
    }
    
    public static boolean isQuart(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bQUART\\b.*") ||
            amountType.toUpperCase().matches(".*\\bQUARTS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bQT\\b.*") ||
            amountType.toUpperCase().matches(".*\\bQTS\\b.*"));
    }
    
    public static boolean isGram(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bGRAM\\b.*") ||
            amountType.toUpperCase().matches(".*\\bGRAMS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bG\\b.*") ||
            amountType.toUpperCase().matches(".*\\bGS\\b.*"));
    }
    
    public static boolean isKilogram(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bKILOGRAM\\b.*") ||
            amountType.toUpperCase().matches(".*\\bKILOGRAMS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bKG\\b.*") ||
            amountType.toUpperCase().matches(".*\\bKGS\\b.*"));
    }
    
    public static boolean isLiter(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bLITER\\b.*") ||
            amountType.toUpperCase().matches(".*\\bLITERS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bL\\b.*") ||
            amountType.toUpperCase().matches(".*\\bLS\\b.*"));
    }
    
    public static boolean isMililiter(String amountType) {
        amountType = amountType.replace(".", "");//Remove periods.
        return (amountType.toUpperCase().matches(".*\\bMILILITER\\b.*") ||
            amountType.toUpperCase().matches(".*\\bMILILITERS\\b.*") || 
            amountType.toUpperCase().matches(".*\\bML\\b.*") ||
            amountType.toUpperCase().matches(".*\\bMLS\\b.*"));
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
