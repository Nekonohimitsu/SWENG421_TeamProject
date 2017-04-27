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
        if (IngredientFactory.getFactory().getIngredient(ingredientName) != null) {
            return new RecipeIngredient(ingredientName, amount, amount_type);
        } else {
            return null;
        }
    }
}
