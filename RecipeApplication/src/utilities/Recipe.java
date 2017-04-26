package utilities;

import java.io.Serializable;

public class Recipe implements Serializable{
    private String name;
    
    public Recipe(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
