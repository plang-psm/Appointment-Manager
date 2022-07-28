package model;

import DBAccess.DBFirstLevelDivisions;

/**
 * Customer model class.
 */
public class Customers {
    private int customerId;
    private String name;
    private String address;
    private String zipcode;
    private String phoneNumber;
    private String country;
    private int divisionId;

    /**
     * @param customerId Passes the customer id.
     * @param name Passes the customer name.
     * @param address Passes the customer address.
     * @param zipcode Passes the customer zipcode.
     * @param phoneNumber Passes the customer phoneNumber.
     * @param country Passes the customer country.
     * @param divisionId Passes the customer division id.
     */
    public Customers(int customerId, String name, String address, String zipcode, String phoneNumber,
                     String country, int divisionId) {

        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.divisionId = divisionId;
    }
    /**
     * @return Returns the customer id.
     */
    public int getCustomerId() {
        return customerId;
    }
    /**
     * @param customerId Passes the customer id.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    /**
     * @return Returns the customer name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name Passes the customer name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Returns the customer address.
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address Passes the customer address.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return Returns the customer zipcode.
     */
    public String getZipcode() {
        return zipcode;
    }
    /**
     * @return Returns the customer country.
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country Passes the customer country.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return Returns the customer division id.
     */
    public int getDivisionId() {
        return divisionId;
    }
    /**
     * @param divisionId Passes the customer division id.
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
    /**
     * @param zipcode Passes the customer zipcode.
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    /**
     * @return Returns the customer phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber Passes the customer phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * @return Returns the customer division name through id.
     */
    public FirstLevelDivisions getDivision() {
        return DBFirstLevelDivisions.getDivision(divisionId);
    }
    /**
     * @return Returns the customer name.
     */
    public String toString() {
        return this.getName();
    }
}
