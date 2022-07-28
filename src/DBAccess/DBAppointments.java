package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Database Appointments class
 */
public class DBAppointments {

    /**
     * This method retrieves all the appointments in our database and adds them to an observable list named
     * appointmentList.
     *
     * @return Returns appointmentList of all appointments.
     */

    // Grabs all appointments from the database.
    public static ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> appointmentList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT Appointment_ID, Title, Description, Location, Type, Start, End," +
                    " Customer_ID, User_ID, Contact_ID" +
                    " FROM appointments";

            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime startDateTime = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime endDateTime = rs.getTimestamp("End").toLocalDateTime();
                int customerId = rs.getInt("Customer_ID");
                int userId = rs.getInt("User_ID");
                int contactId = rs.getInt("Contact_ID");

                Appointments a = new Appointments(appointmentId, title, description, location, type, startDateTime,
                        endDateTime, customerId, userId, contactId);
                appointmentList.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appointmentList;

    }

    /**
     * This method adds a new appointment to our database.
     *
     * @param title Passes the appointment title.
     * @param description Passes the appointment description.
     * @param location Passes the appointment location.
     * @param type Passes the appointment type.
     * @param startDateTime passes the appointment startDateTime.
     * @param endDateTime Passes the appointment endDateTime.
     * @param customerId Passes the appointment customer id.
     * @param userId Passes the appointment user id.
     * @param contactId Passes the appointment contact id.
     */

    // Adds appointments to the database.
    public static void addAppointment(String title, String description, String location, String type, LocalDateTime startDateTime,
                                      LocalDateTime endDateTime, int customerId, int userId, int contactId) {
        try {
            // Grab the user for last created by and last updated by
            String userAdmin = DBUsers.getLoggedUser();

            String sql =
                    "INSERT into Appointments(Title, Description, Location, Type, Start, End, " +
                            "Created_By, Last_Updated_By, Customer_Id, User_Id, Contact_Id, Create_Date, Last_Update)" +
                            "VALUES(?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW())";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, location);
            ps.setString(4, type);
            ps.setTimestamp(5, Timestamp.valueOf(startDateTime));
            ps.setTimestamp(6, Timestamp.valueOf(endDateTime));
            ps.setString(7, userAdmin);
            ps.setString(8, userAdmin);
            ps.setInt(9, customerId);
            ps.setInt(10, userId);
            ps.setInt(11, contactId);

            ps.executeUpdate();
            System.out.println("Successful add");

        } catch (Exception e) {
            System.out.println("Not successful add");
        }
    }
    /**
     * This method updates any changes made to an appointment to our database.
     *
     * @param appointmentId Passes the appointment id.
     * @param title Passes the appointment title.
     * @param description Passes the appointment description.
     * @param location Passes the appointment location.
     * @param type Passes the appointment type.
     * @param startDateTime Passes the appointment startDateTime.
     * @param endDateTime Passes the appointment endDateTime.
     * @param customerId Passes the appointment customer id.
     * @param userId Passes the appointment user id.
     * @param contactId Passes the appointment contact id.
     */
    // Updates appointments to the database.
    public static void updateAppointments(int appointmentId, String title, String description, String location,
                                          String type, LocalDateTime startDateTime, LocalDateTime endDateTime, int customerId,
                                          int userId, int contactId) {

        try {
            // Grab the user for last created by and last updated by
            String userAdmin = DBUsers.getLoggedUser();

            String sql =
                    "UPDATE Appointments SET Title=?, Description=?, Location=?, Type=?," +
                            "Start=?, End=?, Last_Updated_By=?, Customer_Id=?, User_Id=?, Contact_Id=?," +
                            "Last_Update=NOW() WHERE Appointment_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, location);
            ps.setString(4, type);
            ps.setTimestamp(5, Timestamp.valueOf(startDateTime));
            ps.setTimestamp(6, Timestamp.valueOf(endDateTime));
            ps.setString(7, userAdmin);
            ps.setInt(8, customerId);
            ps.setInt(9, userId);
            ps.setInt(10, contactId);
            ps.setInt(11, appointmentId);

            ps.executeUpdate();
            System.out.println("Successful update");

        } catch (Exception e) {
            System.out.println("Not successful update");
        }
    }
    /**
     * This method deletes an appointment by id from our database.
     *
     * @param id Passes the appointment id.
     */
    // Deletes appointments by id from the database.
    public static void deleteAppointment(int id) {

        try {
            String sql =
                    "DELETE FROM Appointments WHERE Appointment_Id=? ";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Successful delete");

        } catch (Exception e) {
            System.out.println("Not successful delete");
        }
    }

    /**
     * This method validates adding appointments to prevent overlapping appointments by boolean.
     *
     * @param startDateTime Passes the appointment start date time.
     * @param endDateTime Passes the appointment end date time.
     *
     * @return Returns true if no appointment with that time exist.
     * @return Returns false if an appointment with that time exist.
     */
    // Prevents scheduling an overlapped appointment.
    public static boolean validateApptTime(LocalDateTime startDateTime, LocalDateTime endDateTime, int id) {
        for (Appointments appointments : DBAppointments.getAllAppointments()) {
            if
            ((
                    ((appointments.getStartDateTime().isAfter(startDateTime) || appointments.getStartDateTime().isEqual(startDateTime))
                            && appointments.getStartDateTime().isBefore(endDateTime))
                            ||
                            (appointments.getEndDateTime().isAfter(startDateTime) && (appointments.getEndDateTime().isBefore(endDateTime) ||
                                    appointments.getEndDateTime().isEqual(endDateTime)))
                            ||
                            ((appointments.getStartDateTime().isBefore(startDateTime) || appointments.getStartDateTime().isEqual(startDateTime)) &&
                                    appointments.getEndDateTime().isAfter(endDateTime) || appointments.getEndDateTime().isEqual(endDateTime))
            ) && (appointments.getAppointmentId() == id)) return false;
            else if
            ((
                    ((appointments.getStartDateTime().isAfter(startDateTime) || appointments.getStartDateTime().isEqual(startDateTime))
                            && appointments.getStartDateTime().isBefore(endDateTime))
                            ||
                            (appointments.getEndDateTime().isAfter(startDateTime) && (appointments.getEndDateTime().isBefore(endDateTime) ||
                                    appointments.getEndDateTime().isEqual(endDateTime)))
                            ||
                            ((appointments.getStartDateTime().isBefore(startDateTime) || appointments.getStartDateTime().isEqual(startDateTime)) &&
                                    appointments.getEndDateTime().isAfter(endDateTime) || appointments.getEndDateTime().isEqual(endDateTime))
            )) return true;
        }
        return false;

    }

    /**
     * This method prevents appointments from being scheduled on the weekend by boolean.
     *
     * @param startDateTime Passes the appointment start date time.
     * @param endDateTime Passes the appointment end date time.
     *
     * @return Returns true if appointment is scheduled on the weekend.
     * @return Returns false if appointment is not scheduled on the weekend.
     */
    // Prevents from scheduling appointment on a weekend.
    public static boolean daysWithoutWeekends(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime.getDayOfWeek() == DayOfWeek.SATURDAY || endDateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if there is any upcoming appointments within 15 minutes by boolean.
     *
     * @return Returns true if appointment is scheduled in 15 minutes and displays appointment information in a window.
     * @return Returns false if appointment is not scheduled in 15 minutes.
     */
    // Checks to see if an appointment is within 15 minutes of local time.
    public static boolean loginAppointmentCheck() {
        try {
            for (Appointments appointments : DBAppointments.getAllAppointments()) {

                LocalTime appointmentTime = appointments.getStartDateTime().toLocalTime();
                LocalTime currentTime = LocalTime.now();
                long timeDifference = ChronoUnit.MINUTES.between(appointmentTime, currentTime);

                long interval = (timeDifference + -1) * -1;

                if (appointments.getStartDateTime().toLocalDate().equals(LocalDate.now())) {
                    if (interval > 0 && interval <= 15) {
                        int id = appointments.getAppointmentId();
                        LocalDate date = appointments.getStartDateTime().toLocalDate();
                        LocalTime time = appointments.getStartDateTime().toLocalTime();

                        ResourceBundle rb = ResourceBundle.getBundle("lang", Locale.getDefault());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText(
                                (rb.getString("aptmessageb") + "\n" +
                                        (rb.getString("aptIdmessage") + id + " " +
                                                (rb.getString("datemessage") + date + " " +
                                                        (rb.getString("timemessage") + time )))));
                        alert.showAndWait();
                        return true;
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }
}

