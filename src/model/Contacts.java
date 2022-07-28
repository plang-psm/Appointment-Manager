package model;

/**
 * Contact model class.
 */
public class Contacts {
    private int id;
    private String name;
    private String email;

    /**
     * @param id Passes the contact id.
     * @param name Passes the contact name.
     * @param email Passes the contact email.
     */
    public Contacts(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    /**
     * @return Returns the contact id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id Passes the contact id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return Returns the contact name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name Passes the contact name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Returns the contact email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email Passes the contact email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return Returns the contact name.
     */
    public String toString() {
        return this.getName();
    }

}
