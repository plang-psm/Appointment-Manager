package model;

import DBAccess.DBContacts;
import DBAccess.DBCustomers;
import DBAccess.DBUsers;

import java.time.LocalDateTime;

/**
 * Appointments model class.
 */
public class Appointments {

    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int customerId;
    private int userId;
    private int contactId;

    /**
     * @param appointmentId Passes the appointment id.
     * @param title Passes the title.
     * @param description Passes the description.
     * @param location Passes the location.
     * @param type Passes the type.
     * @param startDateTime Passes the startDateTime.
     * @param endDateTime Passes the endDateTime.
     * @param customerId Passes the customer id.
     * @param userId Passes the user id.
     * @param contactId Passes the contact id.
     */
    public Appointments(int appointmentId, String title, String description, String location, String type, LocalDateTime startDateTime,
                        LocalDateTime endDateTime, int customerId, int userId, int contactId) {
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customerId = customerId;
        this.userId = userId;
        this.contactId = contactId;
    }
    /**
     * @return Returns appointment Id.
     */
    public int getAppointmentId() {
        return appointmentId;
    }
    /**
     * @param appointmentId Passes the appointment id.
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    /**
     * @return Returns appointment title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title Passes the title.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return Returns appointment description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description Passes the description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return Returns appointment location.
     */
    public String getLocation() {
        return location;
    }
    /**
     * @return Returns appointment start date time.
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    /**
     * @param startDateTime Passes the start date and time formatted.
     */
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    /**
     * @return Returns appointment end date time.
     */
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    /**
     * @param endDateTime Passes the end date and time formatted.
     */
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    /**
     * @param location Passes the location.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * @return Returns appointment type.
     */
    public String getType() {
        return type;
    }
    /**
     * @param type Passes the type.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return Returns appointment customer id.
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
     * @return Returns appointment user id.
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId Passes the user id.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * @return Returns appointment contact id.
     */
    public int getContactId() {
        return contactId;
    }
    /**
     * @param contactId Passes the contact id.
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
    /**
     * @return Returns the appointment contact's name by contact id.
     */
    public Contacts getContact() {
        return DBContacts.getContactById(contactId);
    }
    /**
     * @return Returns the appointment customer's name by customer id.
     */
    public Customers getCustomer() {
        return DBCustomers.getCustomerById(customerId);
    }
    /**
     * @return Returns the appointment user's name by user id.
     */
    public Users getUser() {
        return DBUsers.getUserById(userId);
    }
}
