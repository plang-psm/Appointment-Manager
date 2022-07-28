package util;

import javafx.scene.control.Alert;

import java.util.Locale;
import java.util.ResourceBundle;
/** CustomMessages class */
public class CustomMessages {
    /** This method displays error messages. Messages vary based on the message variable passed.
     * @param message Passes the error message.
     */
    // Custom error message.
    public static void errorMessages(String message) {

        ResourceBundle rb = ResourceBundle.getBundle("lang", Locale.getDefault());

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(rb.getString(message));
        alert.showAndWait();
    }

    /** This method displays informative messages. Messages vary based on the message variable passed.
     * @param message Passes the informative message.
     */
    // Custom informative message.
    public static void informMessages(String message) {
        ResourceBundle rb = ResourceBundle.getBundle("lang", Locale.getDefault());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(rb.getString(message));
        alert.showAndWait();
    }
}
