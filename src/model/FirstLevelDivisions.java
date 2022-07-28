package model;

/**
 * First Level Divisions model class.
 */
public class FirstLevelDivisions {

    private int id;
    private String division;
    private int countryId;

    /**
     * @param id Passes the division id.
     * @param division Passes the division name.
     * @param countryId Passes the division country id.
     */
    public FirstLevelDivisions(int id, String division, int countryId) {
        this.id = id;
        this.division = division;
        this.countryId = countryId;
    }
    /**
     * @return Returns the division id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id Passes the division id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return Returns the division name.
     */
    public String getDivision() {
        return division;
    }
    /**
     * @param division Passes the division name.
     */
    public void setDivision(String division) {
        this.division = division;
    }
    /**
     * @return Returns the country id.
     */
    public int getCountryId() {
        return countryId;
    }
    /**
     * @param countryId Passes the division country id.
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    /**
     * @return Returns the division name to string.
     */
    public String toString() {
        return this.getDivision();
    }
}
