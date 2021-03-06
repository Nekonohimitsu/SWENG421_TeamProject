package application;

import server.IngredientFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilities.*;

public class Client extends javax.swing.JFrame {

    private static DataRetriever dr;
    private int clientID;
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
        qtyField = new javax.swing.JTextField();
        qtyTypeField = new javax.swing.JTextField();
        selfLabel1 = new javax.swing.JLabel();
        selfLabel2 = new javax.swing.JLabel();
        friendsPane = new javax.swing.JScrollPane();
        friendPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        chooseRecipeLabel = new javax.swing.JLabel();
        recipesScrollPane = new javax.swing.JScrollPane();
        recipeList = new javax.swing.JList<>();
        recipeLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        modModeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeEditorPane = new javax.swing.JEditorPane();
        jMenuBar = new javax.swing.JMenuBar();
        toolMenu = new javax.swing.JMenu();
        modItem = new javax.swing.JMenuItem();
        filterItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        Instructions = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Friend Feast");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(100, 100));

        bodyPanel.setLayout(new java.awt.BorderLayout());

        ingredientsPanel.setBackground(new java.awt.Color(198, 222, 201));
        ingredientsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ingredientsPanel.setMinimumSize(new java.awt.Dimension(300, 32));
        ingredientsPanel.setPreferredSize(new java.awt.Dimension(300, 32));
        ingredientsPanel.setLayout(new javax.swing.BoxLayout(ingredientsPanel, javax.swing.BoxLayout.Y_AXIS));

        selfPanel.setBackground(new java.awt.Color(198, 222, 201));

        selfLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        selfLabel.setText("Qty:");

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

        removeIngLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        removeIngLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        removeIngLabel.setText("double-click to remove");

        qtyTypeField.setText("oz");

        selfLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        selfLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selfLabel1.setText("My Ingredients");
        selfLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        selfLabel1.setPreferredSize(null);

        selfLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        selfLabel2.setText("Name:");

        javax.swing.GroupLayout selfPanelLayout = new javax.swing.GroupLayout(selfPanel);
        selfPanel.setLayout(selfPanelLayout);
        selfPanelLayout.setHorizontalGroup(
            selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selfPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selfPanelLayout.createSequentialGroup()
                        .addComponent(selfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selfPanelLayout.createSequentialGroup()
                        .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeIngLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myScrollPane))
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selfPanelLayout.createSequentialGroup()
                        .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selfLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(selfPanelLayout.createSequentialGroup()
                                .addComponent(selfLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addIngredientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(selfPanelLayout.createSequentialGroup()
                                        .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qtyTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(83, 83, 83))))
        );
        selfPanelLayout.setVerticalGroup(
            selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selfPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(selfLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addIngredientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selfLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addIngredientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(myScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeIngLabel)
                .addContainerGap())
        );

        ingredientsPanel.add(selfPanel);

        friendsPane.setBorder(null);
        friendsPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        friendPanel.setBackground(new java.awt.Color(198, 222, 201));
        friendPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Also in this session"));
        friendPanel.setAutoscrolls(true);
        friendPanel.setLayout(new javax.swing.BoxLayout(friendPanel, javax.swing.BoxLayout.Y_AXIS));
        friendsPane.setViewportView(friendPanel);

        ingredientsPanel.add(friendsPane);

        bodyPanel.add(ingredientsPanel, java.awt.BorderLayout.LINE_START);

        mainPanel.setLayout(new java.awt.BorderLayout());

        searchPanel.setBackground(new java.awt.Color(137, 148, 139));

        searchTextField.setText("Enter recipe name");

        searchButton.setBackground(new java.awt.Color(218, 240, 218));
        searchButton.setForeground(new java.awt.Color(137, 148, 139));
        searchButton.setText("Search");
        searchButton.setToolTipText("");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

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

        contentPanel.setBackground(new java.awt.Color(137, 148, 139));
        contentPanel.setToolTipText("");

        chooseRecipeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jSeparator1.setForeground(new java.awt.Color(221, 237, 221));

        modModeLabel.setForeground(new java.awt.Color(64, 83, 71));
        modModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modModeLabel.setText("double-click to edit recipe");

        recipeEditorPane.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(recipeEditorPane);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recipeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooseRecipeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recipesScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modModeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(chooseRecipeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recipesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(modModeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recipeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        bodyPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);

        toolMenu.setText("Tools");

        modItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        modItem.setText("Add Recipe");
        modItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modItemActionPerformed(evt);
            }
        });
        toolMenu.add(modItem);

        filterItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        filterItem.setText("Filter");
        filterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterItemActionPerformed(evt);
            }
        });
        toolMenu.add(filterItem);

        jMenuBar.add(toolMenu);

        helpMenu.setText("Help");

        Instructions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Instructions.setText("Instructions");
        Instructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsActionPerformed(evt);
            }
        });
        helpMenu.add(Instructions);

        jMenuBar.add(helpMenu);

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

    private void recipeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeListMouseClicked
        int index = recipeList.getSelectedIndex();
        if (index != -1) {
            RecipeIF selectedRecipe = currentRecipes.get(index);
            if (evt.getClickCount() > 1) {//double clicked
                ModificationFrame modificationFrame = ModificationFrame.getInstance(selectedRecipe, this);
                modificationFrame.setVisible(true);
            }  else { //Single click
                recipeEditorPane.setText(Utility.formatRecipe(selectedRecipe));
            }
        }
    }//GEN-LAST:event_recipeListMouseClicked

    private void myIngredientListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myIngredientListMouseClicked
        if (evt.getClickCount() > 1) { //Double clicked
            int index = myIngredientList.getSelectedIndex();
            if (index != -1) {
                RecipeIngredientIF ri = myIngredients.get(index);
                myIngredients.remove(index);
                Utility.modifyList(myIngredientList, myIngredients);
                dr.removeIngredient(ri);
            }
        }
    }//GEN-LAST:event_myIngredientListMouseClicked

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        String ingredient = addIngredientTextField.getText();
        String amountType = qtyTypeField.getText();
        double amount;
        try {
             amount = Double.parseDouble(qtyField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount");
            return;
        }
        addIngredient(ingredient, amount, amountType);
    }//GEN-LAST:event_addIngredientButtonActionPerformed

    private void modItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modItemActionPerformed
        RecipeIF newRecipe = new Recipe("","","","",null);
        ModificationFrame modificationFrame = ModificationFrame.getInstance(newRecipe,this);
        modificationFrame.setVisible(true);
    }//GEN-LAST:event_modItemActionPerformed

    private void filterItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterItemActionPerformed
        FilterFrame filterFrame = FilterFrame.getInstance(this);
        filterFrame.setVisible(true);
    }//GEN-LAST:event_filterItemActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String recipeName = searchTextField.getText();
        dr.sendSearchRequest(recipeName);

    }//GEN-LAST:event_searchButtonActionPerformed
    
    private void addIngredient(String ingredientName, double amount, String amount_type) {
        RecipeIngredientIF ri = Utility.createRecipeIngredient(ingredientName, amount, amount_type);
        if (ri == null) {
            JOptionPane.showMessageDialog(null, "Ingredient doesn't exist in our database.");
        } else if (Utility.searchArrayForIngredientName(ri, myIngredients).size() > 0) {
            JOptionPane.showMessageDialog(null, "You already have that ingredient."
                    + " Please delete it and add the new value if you have more.");
        } else {
            myIngredients.add(ri);
            Utility.modifyList(myIngredientList, myIngredients);
            dr.addIngredient(ri);
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
        friendPanel.add(p);
        friendPanel.revalidate();
        friendPanel.repaint();
    }

    public void removePanel(DynamicPanel p) {
        friendPanel.remove(p);
        friendPanel.revalidate();
        friendPanel.repaint();
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
    
    public void sendFilter(String oldIng, String newIng) {
        dr.sendFilter(oldIng, newIng);
    }
    
    public void setSearchText(String text) {
        searchTextField.setText(text);
    }
    
    public void setClientID(int id) {
        this.clientID = id;
        selfLabel1.setText("Welcome, Client " + clientID + "!");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Instructions;
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JTextField addIngredientTextField;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel chooseRecipeLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JMenuItem filterItem;
    private javax.swing.JPanel friendPanel;
    private javax.swing.JScrollPane friendsPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel ingredientsPanel;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem modItem;
    private javax.swing.JLabel modModeLabel;
    private javax.swing.JList<String> myIngredientList;
    private javax.swing.JScrollPane myScrollPane;
    private javax.swing.JTextField qtyField;
    private javax.swing.JTextField qtyTypeField;
    private javax.swing.JEditorPane recipeEditorPane;
    private javax.swing.JLabel recipeLabel;
    private javax.swing.JList<String> recipeList;
    private javax.swing.JScrollPane recipesScrollPane;
    private javax.swing.JLabel removeIngLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel selfLabel;
    private javax.swing.JLabel selfLabel1;
    private javax.swing.JLabel selfLabel2;
    private javax.swing.JPanel selfPanel;
    private javax.swing.JMenu toolMenu;
    // End of variables declaration//GEN-END:variables
}
