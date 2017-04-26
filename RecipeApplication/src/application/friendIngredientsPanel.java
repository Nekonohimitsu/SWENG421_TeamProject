
package application;

import java.util.ArrayList;
import javax.swing.JPanel;

public class friendIngredientsPanel extends JPanel{
    private final int clientID;
    private ArrayList<String> ingredientList = new ArrayList<>();
    
    public friendIngredientsPanel(int clientID) {
        this.clientID = clientID;
    }
    public int getID() { return clientID; }
    public void setIngredientList(ArrayList<String> ingredientList) { 
        this.ingredientList = ingredientList;
        System.out.println("Set Ingredient List of Panel.");
        for (String s : ingredientList) System.out.println(s);
    }
}
