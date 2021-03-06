
package server;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
