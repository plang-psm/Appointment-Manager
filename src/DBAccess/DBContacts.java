package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database Contacts class.
 */
public class DBContacts {
    /**
     * This method retrieves all the contacts in our database and adds them to an observable list named
     * contList.
     *
     * @return Returns contList of all contacts.
     */
    // Grabs all the contacts from the database.
    public static ObservableList<Contacts> getAllContacts() {
        ObservableList<Contacts> contList = FXCollections.observableArrayList();
        try {

            String sql = "SELECT * FROM contacts";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int contactId = rs.getInt("Contact_ID");
                String name = rs.getString("Contact_Name");
                String email = rs.getString("Email");

                Contacts cont = new Contacts(contactId, name, email);
                contList.add(cont);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contList;
    }
    /**
     * This method retrieves the contact name by contact id and creates a new contact list with the new information.
     *
     * @param id Passes the contact id.
     *
     * @return Returns contact name of the contacts.
     * @return Returns if no contact name from the contacts.
     */
    // Passes the contact name based off the contact ID in the appointment table.
    public static Contacts getContactById(int id) {

        try {
            String sql = "SELECT Contact_Name FROM contacts WHERE Contact_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Contact_Name");

                Contacts contacts = new Contacts(id, name, null);
                return contacts;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return null;

    }
}
