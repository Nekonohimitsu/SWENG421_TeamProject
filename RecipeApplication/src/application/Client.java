package application;

import server.IngredientFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import utilities.*;

public class Client extends javax.swing.JFrame {

    private static DataRetriever dr;
    private final ArrayList<RecipeIngredientIF> myIngredients = new ArrayList<>();
    private ArrayList<RecipeIF> currentRecipes = new ArrayList<>();
    private boolean serverResponse = false;

    /**
     * Creates new form Application
     */
    public Client() {
        initComponents();
        dr = DataRetriever.getInstance(this);
        dr.start();
        IngredientFactory.getFactory().refreshIngredientList();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dr.shutdown();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        ingredientsPanel = new javax.swing.JPanel();
        selfPanel = new javax.swing.JPanel();
        selfLabel = new javax.swing.JLabel();
        addIngredientTextField = new javax.swing.JTextField();
        addIngredientButton = new javax.swing.JButton();
        myScrollPane = new javax.swing.JScrollPane();
        myIngredientList = new javax.swing.JList<>();
        removeIngLabel = new javax.swing.JLabel();
        friendsPanel = new javax.swing.JPanel();
        friendsLabel = new javax.swing.JLabel();
        friendScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        chooseRecipeLabel = new javax.swing.JLabel();
        recipesScrollPane = new javax.swing.JScrollPane();
        recipeList = new javax.swing.JList<>();
        recipeLabel = new javax.swing.JLabel();
        recipePane = new javax.swing.JScrollPane();
        recipeTextArea = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        modModeLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        Instructions = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Friend Feast");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        ingredientsPanel.setBackground(new java.awt.Color(47, 68, 54));
        ingredientsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ingredientsPanel.setMinimumSize(new java.awt.Dimension(300, 32));
        ingredientsPanel.setPreferredSize(new java.awt.Dimension(300, 674));
        ingredientsPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        selfPanel.setBackground(new java.awt.Color(137, 148, 139));

        selfLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        selfLabel.setForeground(new java.awt.Color(47, 68, 54));
        selfLabel.setText("My Ingredients");

        addIngredientButton.setText("+");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });

        myIngredientList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No ingredients in list..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        myIngredientList.setSelectionBackground(new java.awt.Color(159, 183, 173));
        myIngredientList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myIngredientListMouseClicked(evt);
            }
        });
        myScrollPane.setViewportView(myIngredientList);

        removeIngLabel.setForeground(new java.awt.Color(167, 198, 167));
        removeIngLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        removeIngLabel.setText("double-click to remove");

        javax.swing.GroupLayout selfPanelLayout = new javax.swing.GroupLayout(selfPanel);
        selfPanel.setLayout(selfPanelLayout);
        selfPanelLayout.setHorizontalGroup(
            selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selfPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(selfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(selfPanelLayout.createSequentialGroup()
                        .addComponent(addIngredientTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addIngredientButton))
                    .addComponent(removeIngLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        selfPanelLayout.setVerticalGroup(
            selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selfPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addIngredientTextField)
                    .addComponent(addIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(myScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeIngLabel)
                .addGap(6, 6, 6))
        );

        ingredientsPanel.add(selfPanel);

        friendsPanel.setBackground(new java.awt.Color(137, 148, 139));

        friendsLabel.setBackground(new java.awt.Color(159, 183, 173));
        friendsLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        friendsLabel.setForeground(new java.awt.Color(47, 68, 54));
        friendsLabel.setText("Also in this session:");

        friendScrollPane.setBackground(new java.awt.Color(159, 183, 173));
        friendScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout friendsPanelLayout = new javax.swing.GroupLayout(friendsPanel);
        friendsPanel.setLayout(friendsPanelLayout);
        friendsPanelLayout.setHorizontalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friendScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(friendsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addContainerGap())
        );
        friendsPanelLayout.setVerticalGroup(
            friendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(friendsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friendScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        ingredientsPanel.add(friendsPanel);

        bodyPanel.add(ingredientsPanel, java.awt.BorderLayout.LINE_END);

        mainPanel.setLayout(new java.awt.BorderLayout());

        searchPanel.setBackground(new java.awt.Color(198, 222, 201));

        searchTextField.setText("Enter recipe name");

        searchButton.setBackground(new java.awt.Color(137, 148, 139));
        searchButton.setForeground(new java.awt.Color(218, 240, 218));
        searchButton.setText("Search");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTextField)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(searchPanel, java.awt.BorderLayout.PAGE_START);

        contentPanel.setBackground(new java.awt.Color(198, 222, 201));

        chooseRecipeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chooseRecipeLabel.setForeground(new java.awt.Color(47, 68, 54));
        chooseRecipeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseRecipeLabel.setText("Recipe List");
        chooseRecipeLabel.setToolTipText("");
        chooseRecipeLabel.setAlignmentX(0.5F);

        recipeList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "No recipes in list..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        recipeList.setSelectionBackground(new java.awt.Color(159, 183, 173));
        recipeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeListMouseClicked(evt);
            }
        });
        recipesScrollPane.setViewportView(recipeList);

        recipeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        recipeLabel.setForeground(new java.awt.Color(47, 68, 54));
        recipeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recipeLabel.setText("Recipe");
        recipeLabel.setAlignmentX(0.5F);

        recipeTextArea.setEditable(false);
        recipeTextArea.setColumns(20);
        recipeTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        recipeTextArea.setLineWrap(true);
        recipeTextArea.setRows(5);
        recipeTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        recipePane.setViewportView(recipeTextArea);

        jSeparator1.setForeground(new java.awt.Color(221, 237, 221));

        modModeLabel.setForeground(new java.awt.Color(64, 83, 71));
        modModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modModeLabel.setText("double-click to edit recipe");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(recipePane, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
                    .addComponent(recipeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooseRecipeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recipesScrollPane)
                    .addComponent(modModeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(chooseRecipeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recipesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(modModeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recipeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recipePane, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        bodyPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);

        jMenu.setText("Help");

        Instructions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Instructions.setText("Instructions");
        Instructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsActionPerformed(evt);
            }
        });
        jMenu.add(Instructions);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionsActionPerformed
        // Resource(s) used: https://www.youtube.com/watch?v=dCiAhqjlr5U
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "HelpDoc.txt");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }//GEN-LAST:event_InstructionsActionPerformed

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        String ingredient = addIngredientTextField.getText();
        //amount? amount type?
        addIngredient(ingredient, 1.0, "cup");
    }//GEN-LAST:event_addIngredientButtonActionPerformed

    private void myIngredientListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myIngredientListMouseClicked
        if (evt.getClickCount() > 1) { //Double clicked
            int index = myIngredientList.getSelectedIndex();
            RecipeIngredientIF ri = myIngredients.get(index);
            myIngredients.remove(index);
            Utility.modifyList(myIngredientList, myIngredients);
            dr.removeIngredient(ri);
        }
    }//GEN-LAST:event_myIngredientListMouseClicked

    private void recipeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeListMouseClicked
        if (evt.getClickCount() > 1) {//double clicked
            int index = recipeList.getSelectedIndex();
            RecipeIF selectedRecipe = currentRecipes.get(index);
            ModificationFrame modificationFrame = ModificationFrame.getInstance(selectedRecipe, this);
            modificationFrame.setVisible(true);
        }
    }//GEN-LAST:event_recipeListMouseClicked
    
    private void addIngredient(String ingredientName, double amount, String amount_type) {
        RecipeIngredientIF ri = Utility.createRecipeIngredient(ingredientName, 1.0, "cup");
        if (ri != null) {
            myIngredients.add(ri);
            Utility.modifyList(myIngredientList, myIngredients);
            dr.addIngredient(ri);
        } else {
            JOptionPane.showMessageDialog(null, "Ingredient doesn't exist in our database.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>     
        //</editor-fold>     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    public void displayRecipeList(ArrayList<RecipeIF> rl) {
        currentRecipes = rl;
        Utility.modifyList(recipeList, rl);
    }

    public void addPanel(DynamicPanel p) {
        friendsPanel.setLayout(new java.awt.BorderLayout());
        friendsPanel.add(p);
        friendsPanel.revalidate();
        friendsPanel.repaint();
    }

    public void removePanel(DynamicPanel p) {
        friendsPanel.remove(p);
        friendsPanel.revalidate();
        friendsPanel.repaint();
    }
    
    public boolean storeRecipe(RecipeIF r) {
        dr.sendRecipe(r);
        synchronized(this) {
            try {
                this.wait();
                return serverResponse;
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public void setResponse(boolean response) {
        serverResponse = response;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Instructions;
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JTextField addIngredientTextField;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel chooseRecipeLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane friendScrollPane;
    private javax.swing.JLabel friendsLabel;
    private javax.swing.JPanel friendsPanel;
    private javax.swing.JPanel ingredientsPanel;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel modModeLabel;
    private javax.swing.JList<String> myIngredientList;
    private javax.swing.JScrollPane myScrollPane;
    private javax.swing.JLabel recipeLabel;
    private javax.swing.JList<String> recipeList;
    private javax.swing.JScrollPane recipePane;
    private javax.swing.JTextArea recipeTextArea;
    private javax.swing.JScrollPane recipesScrollPane;
    private javax.swing.JLabel removeIngLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel selfLabel;
    private javax.swing.JPanel selfPanel;
    // End of variables declaration//GEN-END:variables
}
