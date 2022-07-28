package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Reports;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database Reports class.
 */
public class DBReports {
    /**
     * This method filters the amount of appointments, type of appointments and the month of the appointments in our
     * database and adds them to an observable list named monthTypeList to display in a table view.
     *
     * @return Returns monthTypeList of appointment total count, type and the month.
     */
    // Generates a report on the total amount of appointments within a given month and the type of appointment.
    public static ObservableList<Reports> getMonthTypeReport() {
        ObservableList<Reports> monthTypeList = FXCollections.observableArrayList();
        try {

            String sql = "SELECT Appointment_ID, Type, monthname(`Start`) AS Month, count(Appointment_ID) AS Totals " +
                    "FROM Appointments GROUP BY Appointment_ID;";

            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String month = rs.getString("Month");
                String type = rs.getString("Type");
                int totals = rs.getInt("Totals");

                Reports a = new Reports(month, type, totals);
                monthTypeList.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return monthTypeList;
    }
    /**
     * This method filters the amount of appointments, division of appointments and the country of the appointments in
     * our database and adds them to an observable list named reportList to display in a table view.
     *
     * @return Returns reportList of appointment total count, division and the country.
     */
    // Generates a report on the total amount of appointments within a given division along with the country of the
    // appointment.
    public static ObservableList<Reports> getDivisionReport() {
        ObservableList<Reports> reportList = FXCollections.observableArrayList();
        try {

            String sql = "SELECT f.Division_Id, f.Country_Id, count(c.Customer_Id) AS Totals FROM " +
                    "first_level_divisions f " +
                    "INNER JOIN Customers c ON c.Division_Id = f.Division_Id GROUP BY f.Division_Id";

            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int division = rs.getInt("Division_Id");
                int country = rs.getInt("Country_Id");
                int totals = rs.getInt("Totals");

                Reports a = new Reports(division, country, totals);
                reportList.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reportList;
    }
}
