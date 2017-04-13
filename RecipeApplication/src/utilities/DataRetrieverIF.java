package utilities;

import java.util.ArrayList;
import javafx.application.Application;

public interface DataRetrieverIF {
    public abstract ArrayList<Recipe> retrieveData();
    public void addObserver(Application client);
    public void rmvObserver(Application client);
}
