package DBAccess;

//import java.sql.Connection;
//import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Database Connection class.
 */
public class DBConnection {

    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcURL = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "USER";
    private static final String password = "PASS";

    public static Connection connection;

    /**
     * This method opens connection to the database.
     */
    // Opens connection to the database.
    public static void openConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * This method closes connection to the database.
     */
    // Closes connection to the database.
    public static void closeConnection(){
        try {
            connection.close();

            System.out.println("Connection Closed");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
