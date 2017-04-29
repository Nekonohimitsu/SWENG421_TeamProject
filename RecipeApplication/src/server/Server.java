package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.*;

public class Server {

    private static final ArrayList<ServerThread> listOfClients = new ArrayList<>();
    private static int currentID = 0;
    private final static Scheduler scheduler = new Scheduler();
    private final static Connection connector = DatabaseConnector.getConnector();
    private final static IngredientFactory factory = IngredientFactory.getFactory();
    private static ArrayList<RecipeIF> listOfRecipes = new ArrayList<>();
    private final static HashMap<ServerThread, ArrayList<RecipeIngredientIF>> listOfAllIngredients = new HashMap<>();
    private static ReplacementFilterIF filter = null;
    
    /* Message Titles -
     * These specify message headers that are used for specific commands
     * They make sure the right process is always run when a given header is recieved.
    */
    public static final String SEND_INGREDIENT_LIST_TITLE = "UpdateIngredientList";
    public static final String ADD_NEW_CLIENT_TITLE = "AddNewClient";
    public static final String REMOVE_CLIENT_TITLE = "RemoveClient";
    public static final String SEND_RECIPE_LIST_TITLE = "UpdateRecipeList";
    public static final String WELCOME_TITLE = "UpdatePanels";
    public static final String ADD_INGREDIENT_TITLE = "AddNewIngredient";
    public static final String RMV_INGREDIENT_TITLE = "RemoveIngredient";
    public static final String ADD_FILTER_TITLE = "NewFilterTitle";
    public static final String MODIFY_RECIPE = "ModifyRecipe";
    public static final String MODIFY_RECIPE_RESPONSE = "ModifyRecipeResponse";
    public static final String SEARCH_RECIPE = "SearchForRecipe";
    public static final String SEARCH_RECIPE_RESPONSE = "SearchResult";

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        factory.refreshIngredientList();
        listOfRecipes = getRecipes();
        while (true) {
            Socket s = ss.accept();
            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
            ServerThread st = new ServerThread(s, is, os, currentID++, scheduler);
            listOfClients.add(st);
            st.start();
        }
    }

    private static void removeClient(SendableMessage m, ServerThread sendingClient) throws IOException {
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(m);
            }
        }
        listOfAllIngredients.remove(sendingClient);
        listOfClients.remove(sendingClient);
        if (listOfClients.isEmpty()) {
            currentID = 0;
        }
    }

    private static void sendNewClient(SendableMessage m, ServerThread sendingClient) throws IOException {
        listOfAllIngredients.put(sendingClient, null);
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(m);
                if (listOfClients.size() > 1) {
                    //For each other client, send their information to the new client that just joined.
                    SendableMessage welcomeMessage = new Message(WELCOME_TITLE, client.getIngredientList(), client);
                    sendingClient.getOutputStream().writeObject(welcomeMessage);
                }
            }
        }
    }

    private static void sendRecipeList(SendableMessage m) throws IOException {
        ArrayList<RecipeIF> filteredRecipes = listOfRecipes;
        if (filter != null) filteredRecipes = filter.applyReplacement(listOfRecipes);
        SendableMessage recipeMessage = new Message(m.getMessageTitle(), filteredRecipes);
        for (ServerThread client : listOfClients) {
            client.getOutputStream().reset(); //
            client.getOutputStream().writeObject(recipeMessage);
        }
    }

    private static void sendIngredientList(SendableMessage m, ServerThread sendingClient) throws IOException {
        listOfAllIngredients.put(sendingClient, (ArrayList)m.getMessageContent());
        for (ServerThread client : listOfClients) {
            if (client.getOutputStream() != sendingClient.getOutputStream()) {
                client.getOutputStream().writeObject(m);
            }
        }
    }
    
    private static void checkAndModifyRecipe(SendableMessage m, ServerThread sendingClient) throws IOException {
        RecipeIF newRecipe = (RecipeIF) m.getMessageContent();
        boolean response = true;
        for (RecipeIF r : listOfRecipes) {
            if (r.getName().equals(newRecipe.getName())) {
                response = false;
                break;
            } 
        }
        SendableMessage responseMessage = new Message(MODIFY_RECIPE_RESPONSE, response);
        sendingClient.getOutputStream().writeObject(responseMessage);
        if (response) {
            listOfRecipes.add(newRecipe);
            addRecipeToDatabase(newRecipe);
        }
    }
    
    private static void applyFilter(SendableMessage m) {
        String[] content = (String[])m.getMessageContent();
        String oldIng = content[0];
        String newIng = content[1];
        if (filter == null) {
            filter = new ReplacementFilter(oldIng, newIng);
        } else {
            filter = new ReplacementFilter(filter, oldIng, newIng);
        }
    }
    
    private static void searchForRecipe(SendableMessage m, ServerThread sendingClient) throws IOException {
        String recipeToSearchFor = (String) m.getMessageContent();
        ArrayList<RecipeIF> fullRecipeList = getRecipes();
        RecipeIF recipe = null;
        for (RecipeIF r : fullRecipeList) {
            if (r.getName().equals(recipeToSearchFor)) {
                recipe = r;
                break;
            }
        }
        if (filter != null && recipe != null) recipe = filter.applyReplacement(recipe);
        SendableMessage message = new Message(SEARCH_RECIPE_RESPONSE, recipe);
        sendingClient.getOutputStream().writeObject(message);
    }

    static void sendMessage(SendableMessage m) throws IOException {
        ServerThread sendingClient = getClientViaID(m.getMessageSenderID());
        if (sendingClient != null) {
            switch (m.getMessageTitle()) {
                case SEND_INGREDIENT_LIST_TITLE:
                    sendIngredientList(m, sendingClient);
                    break;
                case REMOVE_CLIENT_TITLE:
                    removeClient(m, sendingClient);
                    break;
                case ADD_NEW_CLIENT_TITLE:
                    sendNewClient(m, sendingClient);
                    break;
                case SEND_RECIPE_LIST_TITLE:
                    sendRecipeList(m);
                    break;
                case MODIFY_RECIPE:
                    checkAndModifyRecipe(m, sendingClient);
                    break;
                case ADD_FILTER_TITLE:
                    applyFilter(m);
                    break;
                case SEARCH_RECIPE:
                    searchForRecipe(m, sendingClient);
                    break;
                default:
                    break;
            }
        }
    }

    private static ServerThread getClientViaID(int ID) {
        for (ServerThread client : listOfClients) {
            if (client.getClientID() == ID) {
                return client;
            }
        }
        return null;
    }
    
    private static ArrayList<RecipeIF> getRecipes() {
    //This is expensive to run (takes a long time - or will when theres more recipes). Only run if really needed.
        ArrayList<RecipeIF> recipeList = new ArrayList<>();
        Statement stmt;
        try {
            stmt = connector.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM APP.RECIPES");
            while (rs.next()) {
                String name = rs.getString("RECIPE_NAME");
                String directions = rs.getString("RECIPE_DIRECTIONS");
                ArrayList<RecipeIngredientIF> ingredients = getIngredientsInRecipe(name);
                int calories = rs.getInt("RECIPE_CALORIES");
                int servingSize = rs.getInt("RECIPE_SERVINGSIZE");
                String cookTime = rs.getString("RECIPE_COOKTIME");
                String prepTime = rs.getString("RECIPE_PREPTIME");
                String desc = rs.getString("RECIPE_DESC");
                RecipeIF r = new Recipe(name,directions ,ingredients);
                r.setCalories(calories);
                r.setCookTime(cookTime);
                r.setDesc(desc);
                r.setPrepTime(prepTime);
                r.setServingSize(servingSize);
                recipeList.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recipeList;
    }
    
    private static ArrayList<RecipeIngredientIF> getIngredientsInRecipe(String recipeName) {
        Statement stmt;
        ArrayList<RecipeIngredientIF> ingredients = new ArrayList<>();
        try {
            stmt = connector.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT i.INGREDIENT_NAME, ri.AMOUNT_TYPE, ri.AMOUNT\n" +
                "FROM APP.RECIPES r\n" +
                "LEFT JOIN APP.RECIPES_INGREDIENTS ri ON r.RECIPE_NAME = ri.RECIPE_NAME\n" +
                "LEFT JOIN APP.INGREDIENTS i ON ri.INGREDIENT_ID = i.INGREDIENT_ID\n" +
                "WHERE r.RECIPE_NAME = '" + recipeName + "'");
            while (rs.next()) {
                String name = rs.getString("INGREDIENT_NAME");
                String amountType = rs.getString("AMOUNT_TYPE");
                double amount = rs.getDouble("AMOUNT");
                ingredients.add(new RecipeIngredient(name, amount, amountType));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredients;
    }
    
    private static void addRecipeToDatabase(RecipeIF r) {
        Statement stmt;
        try {
            stmt = connector.createStatement();
            stmt.executeUpdate("INSERT INTO APP.RECIPES(RECIPE_NAME, "
                    + "RECIPE_DIRECTIONS, RECIPE_CALORIES, RECIPE_SERVINGSIZE, "
                    + "RECIPE_COOKTIME, RECIPE_PREPTIME, RECIPE_DESC) "
                    + "VALUES ('" + r.getName() + "', '" + r.getDirections() + 
                    "', " + r.getCalories() + ", " + r.getServingSize() + ", '" +
                    r.getCookTime() + "', '" + r.getPrepTime() + "', '" + r.getDesc() + "')");
            for (RecipeIngredientIF ri : r.getIngredients()) {
                //Only way to get the ID of the ingredient is through the Ingredient Factory.
                IngredientIF i = factory.getIngredient(ri.getIngredient());
                stmt.executeUpdate("INSERT INTO APP.RECIPES_INGREDIENTS(RECIPE_NAME,"
                        + " INGREDIENT_ID, AMOUNT_TYPE, AMOUNT) VALUES ('" + 
                        r.getName() + "', " + i.getID() + ", '" +
                        ri.getAmountType() + "', " + ri.getAmount() + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
