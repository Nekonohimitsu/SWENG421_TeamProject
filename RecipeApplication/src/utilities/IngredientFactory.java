package utilities;

import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredientFactory {
    private final HashMap<String, Ingredient> ingredientList = new HashMap();
    
    private void refreshIngredientList() {
        try {
            //Pull ingredients from database. Store them into an array. Make this occur every 5min.
            Statement stmt = DatabaseConnector.getConnector().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM APP.INGREDIENTS");
            while (rs.next()) {
                int id = rs.getInt("ingredient_id");
                String name = rs.getString("ingredient_name");
                Ingredient pulledIngredient = new Ingredient(id, name);
                if (!ingredientList.containsKey(name)) {
                    ingredientList.put(name, pulledIngredient);
                }
            }          
        } catch (SQLException ex) {
            Logger.getLogger(IngredientFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Ingredient getIngredient(String ingredientName) {
        if (ingredientList.containsKey(ingredientName)) {
            return ingredientList.get(ingredientName);
        }
        return null;
    }
}
