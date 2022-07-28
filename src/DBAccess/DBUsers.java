package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database Users class.
 */

public class DBUsers {

    // Holds the users log in username.
    public static ObservableList<String> userLogIn = FXCollections.observableArrayList();

    /**
     * This method retrieves all the users in our database and adds them to an observable list named
     * usersList.
     *
     * @return Returns usersList of all users.
     */
    // Returns all data from users.
    public static ObservableList<Users> getAllUsers() {
        ObservableList<Users> usersList = FXCollections.observableArrayList();
        try{

            String sql = "SELECT * FROM users";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("User_ID");
                String username = rs.getString("User_Name");
                String password = rs.getString("Password");

                Users user = new Users(id, username, password);
                usersList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return usersList;
    }

    /**
     * This method validates users log in username and password from our database.
     *
     * @return Returns true if the users input matches a valid username and password.
     * @return Returns false if the users input does not match a valid username and password.
     */
    public static boolean vLogin(String username, String password) throws SQLException {
        try {
            String sql = "SELECT User_Name, Password FROM users WHERE User_Name=? AND Password=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method retrieves the user by the username.
     *
     * @param name passes the username.
     * @return Returns the user user-id, name, password.
     * @return Returns null if no user.
     */
    // Returns our user by the user's username.
    public static Users getUsername(String name) {
        try {
            String sql = "SELECT * FROM users WHERE User_Name=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("User_id");
                String pw = rs.getString("Password");

                Users user = new Users(id, name, pw);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * This method retrieves the username by the user id.
     *
     * @param id passes the user id.
     * @return Returns the user username.
     * @return Returns null if no user.
     */
    // Returns our user by the user's id.
    public static Users getUserById(int id) {

        try {
            String sql = "SELECT User_Name FROM users WHERE User_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("User_Name");

                Users user = new Users(id, name, null);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return null;

    }
    /**
     * This method retrieves the user that is logged in.
     *
     * @return Returns the user username.
     * @return Returns null if no user username.
     */
    // Returns the user's username.
    public static String getLoggedUser() {
        for(String user : userLogIn) {
            return user;
        }
        return null;
    }

    /**
     * This method retrieves and holds the user's username that is logged in.
     *
     * @param username passes the user's username.
     * @return Returns true if the user's username is valid.
     * @return Returns false if the user's username is not valid.
     */
    // Holds the user's username and adds it to our userLogIn array list.
    public static boolean holdUsername(String username) {
        try {
            userLogIn.clear();

            String sql = "SELECT User_Name FROM users WHERE User_Name=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                userLogIn.add(username);
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
