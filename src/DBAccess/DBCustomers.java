package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database Customers class.
 */
public class DBCustomers {

    // Holds a list of all of our customers.
    public static ObservableList<Customers> customerList = FXCollections.observableArrayList();

    /**
     * This method retrieves all the customers in our database and adds them to an observable list named
     * customerList.
     *
     * @return Returns customerList of all customers.
     */
    // Grabs all customers from the database.
    public static ObservableList<Customers> getAllCustomers() {
        customerList = FXCollections.observableArrayList();

        try{

            String sql = "SELECT cs.Customer_ID, cs.Customer_Name, cs.Address, cs.Postal_Code, cs.Phone," +
                    "cs.Division_ID,\n" +
                    "c.Country_ID, c.Country, f.Country_ID, f.Division_ID \n" +
                    "FROM Customers cs\n" +
                    "INNER JOIN first_level_divisions f ON cs.Division_ID = f.Division_ID\n" +
                    "INNER JOIN countries c ON f.Country_ID = c.Country_ID";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int customerId = rs.getInt("Customer_ID");
                String name = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String zipcode = rs.getString("Postal_code");
                String phoneNumber = rs.getString("Phone");
                String country = rs.getString("Country");
                int divisionId = rs.getInt("Division_ID");

                Customers c = new Customers(customerId, name, address, zipcode, phoneNumber, country, divisionId);
                customerList.add(c);
            } return customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method adds a new customer to our database.
     *
     * @param name Passes the customer name.
     * @param address Passes the customer address.
     * @param zipcode Passes the customer zipcode.
     * @param phone Passes the customer phone.
     * @param country Passes the customer country.
     * @param division Passes the customer division.
     */
    // Adds customer to the database.
    public static void addCustomer (String name, String address, String zipcode, String phone,
                                    String country, int division ) {

        try {
            // Grab the user for last created by and last updated by
            String userAdmin = DBUsers.getLoggedUser();

            String sql =
                    "INSERT into Customers(Customer_Name, Address, Postal_Code, Phone, Created_By," +
                        "Last_Updated_By, Division_ID, Create_date, Last_Update)" +
                    "VALUES (?,?,?,?,?,?,?, NOW(), NOW())";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, zipcode);
            ps.setString(4, phone);
            ps.setString(5, userAdmin);
            ps.setString(6, userAdmin);
            ps.setInt(7, division);

            ps.executeUpdate();
            System.out.println("Successful add");

        } catch (Exception e) {
            System.out.println("Not successful add");
        }
    }
    /**
     * This method updates any changes made to a customer to our database.
     *
     * @param name Passes the customer name.
     * @param address Passes the customer address.
     * @param zipcode Passes the customer zipcode.
     * @param phone Passes the customer phone.
     * @param country Passes the customer country.
     * @param division Passes the customer division.
     */
    // Updates the customer from the database.
    public static void updateCustomer (int id, String name, String address, String zipcode, String phone,
                                    String country, int division ) {

        try {
            // Grab the user for last created by and last updated by
            String userAdmin = DBUsers.getLoggedUser();

            String sql =
                    "UPDATE Customers SET Customer_Name=?, Address=?, Postal_Code=?, Phone=?," +
                            "Last_Update=NOW(), Last_Updated_By=?, Division_ID=? WHERE Customer_ID=?";

            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, zipcode);
            ps.setString(4, phone);
            ps.setString(5, userAdmin);
            ps.setInt(6, division);
            ps.setInt(7, id);

            ps.executeUpdate();
            System.out.println("Successful update");

        } catch (Exception e) {
            System.out.println("Not successful update");
        }
    }

    /**
     * This method deletes a customer by id from our database.
     *
     * @param id Passes the customer id.
     */
    // Deletes customer from the database.
    public static void deleteCustomer (int id) {

        try {
            String sql =
                    "DELETE FROM Customers WHERE Customer_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Successful delete");

        } catch (Exception e) {
            System.out.println("Not successful delete");
        }
    }

    /**
     * This method deletes a appointments associated to a customer being deleted by id from our database.
     *
     * @param id Passes the customer id.
     */
    // Deletes customers appointments that is being deleted from the database.
    public static void deleteCustomerAppointments (int id) {

        try {
            String sql =
                    "DELETE FROM Appointments WHERE Customer_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Successful delete");

        } catch (Exception e) {
            System.out.println("Not successful delete");
        }
    }

    /**
     * This method grabs the customer name by the customer id.
     *
     * @param id Passes the customer id.
     * @return Returns customers name of the customer.
     * @return Returns null if no customers name of the customer.
     */
    // Grabs the customer name by its customer id.
    public static Customers getCustomerById(int id) {

        try {
            String sql = "SELECT Customer_Name FROM Customers WHERE Customer_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Customer_Name");

                Customers customers = new Customers(id, name, null, null, null, null, 0);
                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return null;

    }
}
