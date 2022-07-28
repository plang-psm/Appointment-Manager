package model;
/**
 * User model class.
 */
public class Users {

    private int id;
    private String username;
    private String password;

    /**
     * @param id passes the user id.
     * @param username passes the username.
     * @param password passes the user password.
     */
    public Users(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    /**
     * @return Returns the user id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id Passes the user id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return Returns the user username.
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username Passes the user username.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return Returns the user password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password Passes the user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return Returns the username to string.
     */
    public String toString() {
        return this.getUsername();
    }
}
