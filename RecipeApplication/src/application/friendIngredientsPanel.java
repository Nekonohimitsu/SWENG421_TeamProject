
package application;

import java.util.ArrayList;
import javax.swing.JPanel;
import utilities.RecipeIngredientIF;

public class friendIngredientsPanel extends JPanel{
    private final int clientID;
    private ArrayList<RecipeIngredientIF> ingredientList = new ArrayList<>();
    
    public friendIngredientsPanel(int clientID) {
        this.clientID = clientID;
    }
    public int getID() { return clientID; }
    public void setIngredientList(ArrayList<RecipeIngredientIF> ingredientList) { 
        this.ingredientList = ingredientList;
    }
}
