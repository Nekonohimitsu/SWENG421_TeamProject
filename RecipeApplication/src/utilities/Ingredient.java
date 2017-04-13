package utilities;

public class Ingredient {
    private String name;
    private int id;
    
    private Ingredient() { }
    Ingredient(int id, String name) { 
        this.name = name;
        this.id = id;
    }
    String getName() { return this.name; }
    int getID() { return this.id; }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
