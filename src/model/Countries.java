package model;

/**
 * Countries model class.
 */
public class Countries {
    private int id;
    private String country;

    /**
     * @param id Passes the country id.
     * @param country Passes the country name.
     */
    public Countries(int id, String country) {
        this.id = id;
        this.country = country;
    }
    /**
     * @return Returns the countries country id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id Passes the country id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return Returns the country name.
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country Passes the country name.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return Returns the country name to string.
     */
    public String toString() {
        return this.getCountry();
    }
}
