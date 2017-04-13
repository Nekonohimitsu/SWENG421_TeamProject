
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Troyana
 */
public class DatabaseConnector {
    private static Connection connector = null;
    private DatabaseConnector() {} // Singleton Pattern.
    public static Connection getConnector() {
        if (connector == null) {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log
                (Level.SEVERE, "Unable to connect to database driver", ex);
            }
            try{
                Properties properties = new Properties();
                properties.put("user","Troyana");
                properties.put("password", "WeAreGraduating");
                connector = DriverManager.getConnection("jdbc:derby://localhost:1527/recipe_application", properties);
            } catch(SQLException e){
                System.err.println(e);
            }  
        }
        return connector;
    }
}
