package utilities;

import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredientFactory {
    private static final HashMap<String, IngredientIF> ingredientList = new HashMap();
    private static IngredientFactory instance;
    
    private IngredientFactory() { }
    
    public static IngredientFactory getFactory() { 
        if (instance == null) {
            instance = new IngredientFactory();
        }
        return instance;
    }
    
    public void refreshIngredientList() {
        try {
            //Pull ingredients from database. Store them into an array.
            //This occurs once at the start of the program.
            Statement stmt = DatabaseConnector.getConnector().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM APP.INGREDIENTS");
            while (rs.next()) {
                int id = rs.getInt("ingredient_id");
                String name = rs.getString("ingredient_name");
                IngredientIF pulledIngredient = new Ingredient(id, name);
                if (!ingredientList.containsKey(name)) {
                    ingredientList.put(name, pulledIngredient);
                }
            }          
        } catch (SQLException ex) {
            Logger.getLogger(IngredientFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public IngredientIF getIngredient(String ingredientName) {
        if (ingredientList.containsKey(ingredientName)) {
            return ingredientList.get(ingredientName);
        }
        return null;
    }
}
