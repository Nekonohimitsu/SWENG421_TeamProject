package application;

import java.util.ArrayList;
import utilities.RecipeIngredientIF;

public class DynamicPanel extends javax.swing.JPanel {

    private int ID;
    private ArrayList<RecipeIngredientIF> ingredientList = new ArrayList<>();

    private DynamicPanel() {
    }

    public DynamicPanel(int ID) {
        System.out.println("ID: " + ID);
        this.ID = ID;
        initComponents();
    }

    public int getID() {
        return this.ID;
    }

    public void setIngredientList(ArrayList<RecipeIngredientIF> il) {
        this.ingredientList = il;
        String list = "";
        for (RecipeIngredientIF r : ingredientList)
            list += r.toString() + "\n";
        friendIngTextArea.setText(list);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendIngTextArea = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Friend");

        friendIngTextArea.setEditable(false);
        friendIngTextArea.setColumns(20);
        friendIngTextArea.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friendIngTextArea.setRows(5);
        jScrollPane1.setViewportView(friendIngTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea friendIngTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
