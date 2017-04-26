package utilities;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import server.IngredientFactory;

public class Utility {
    public static DefaultListModel modifyList(JList list, ArrayList info) {
        DefaultListModel lm = new DefaultListModel();
        for (Object o : info) {
            lm.addElement(o);
        }
        list.setModel(lm);
        return lm;
    }
    
    public static RecipeIngredientIF createRecipeIngredient(String ingredientName, double amount, String amount_type) {
        if (IngredientFactory.getFactory().getIngredient(ingredientName) != null) {
            return new RecipeIngredient(ingredientName, amount, amount_type);
        } else {
            return null;
        }
    }
}
