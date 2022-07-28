package main;


import DBAccess.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Main class
 */
public class Main extends Application {
    /**
     * This method displays the login screen.
     * @param stage hosts a scene.
     */
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        stage.setTitle("Application Manager");
        stage.setScene(new Scene(root));
        stage.show();
    }
    /**
     * This method opens and closes the SQL connection.
     */
    public static void main(String[] args) {
        //Open and close the database connection
        DBConnection.openConnection();
         launch(args);
        DBConnection.closeConnection();
    }
}
