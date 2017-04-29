
package ge.mziuri.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/events";
    
    public static final String USERNAME = "postgres";
    
    public static final String PASSWORD = "rame";
    
    public  static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
