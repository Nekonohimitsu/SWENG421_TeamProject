package utilities;

public class Ingredient {
    private String name;
    private int id;
    
    private Ingredient() { }
    public Ingredient(int id, String name) { 
        this.name = name;
        this.id = id;
    }
    public String getName() { return this.name; }
    public int getID() { return this.id; }
}
