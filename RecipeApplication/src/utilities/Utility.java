package utilities;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Utility {
    public static DefaultListModel modifyList(JList list, ArrayList info) {
        DefaultListModel lm = new DefaultListModel();
        for (Object o : info) {
            lm.addElement(o);
        }
        list.setModel(lm);
        return lm;
    }
}
