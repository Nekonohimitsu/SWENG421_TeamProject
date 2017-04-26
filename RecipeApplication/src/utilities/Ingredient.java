package utilities;

import java.io.Serializable;

public class Ingredient extends IngredientAbs implements Serializable{
    Ingredient(int id, String name) { 
       super(id, name);
    }
}
