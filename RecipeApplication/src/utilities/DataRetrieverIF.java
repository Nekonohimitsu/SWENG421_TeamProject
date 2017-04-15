package utilities;

import application.Client;
import java.util.ArrayList;

interface DataRetrieverIF {
    abstract ArrayList<Recipe> retrieveData(ArrayList<Ingredient> il);
    void addObserver(Client client);
    void rmvObserver(Client client);
}
