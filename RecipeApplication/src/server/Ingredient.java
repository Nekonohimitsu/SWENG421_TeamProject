package server;

import java.io.Serializable;

class Ingredient extends IngredientAbs implements Serializable{
    Ingredient(int id, String name) { 
       super(id, name);
    }
}
