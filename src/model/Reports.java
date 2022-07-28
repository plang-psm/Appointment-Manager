package model;


import DBAccess.DBCountries;
import DBAccess.DBFirstLevelDivisions;
/**
 * Reports model class.
 */
public class Reports{
    private String month;
    private String type;
    private int totals;
    private int division;
    private int country;

    /**
     * @param month Passes the report month.
     * @param type Passes the report type.
     * @param totals Passes the report totals.
     */
    public Reports(String month, String type, int totals) {
        this.month = month;
        this.type = type;
        this.totals = totals;
    }
    /**
     * @param division Passes the report division.
     * @param country Passes the report country.
     * @param totals Passes the report totals.
     */
    public Reports(int division, int country, int totals) {
        this.division = division;
        this.country = country;
        this.totals = totals;
    }
    /**
     * @param month Passes the report month.
     */
    public void setMonth(String month) {
        this.month = month;
    }
    /**
     * @param type Passes the report type.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @param totals Passes the report totals.
     */
    public void setTotals(int totals) {
        this.totals = totals;
    }
    /**
     * @return Returns the report month.
     */
    public String getMonth() {
        return month;
    }
    /**
     * @return Returns the report type.
     */
    public String getType() {
        return type;
    }
    /**
     * @return Returns the report totals.
     */
    public int getTotals() {
        return totals;
    }
    /**
     * @return Returns the report division name.
     */
    public FirstLevelDivisions getDivision() {
        return DBFirstLevelDivisions.getDivision(division);

    }
    /**
     * @return Returns the report country name.
     */
    public Countries getCountry() {
        return DBCountries.getCountry(country);
    }
}
