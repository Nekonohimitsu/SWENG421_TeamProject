package server;

abstract class IngredientAbs implements IngredientIF{
    private String name;
    private int ID;
    
    private IngredientAbs() {}
    
    IngredientAbs(int id, String name) {
        this.name = name;
        this.ID = id;
    }

    @Override
    public String getName() { return name; }
    
    @Override
    public int getID() { return ID; }
}
