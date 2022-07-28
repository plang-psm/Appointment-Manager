package controller;

import DBAccess.DBCountries;
import DBAccess.DBCustomers;
import DBAccess.DBFirstLevelDivisions;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Countries;
import model.FirstLevelDivisions;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 *
 * New Customer controller.
 */
public class NewCustomerController implements Initializable {
    @FXML
    private Label addressLbl;

    @FXML
    private TextField addressTxt;

    @FXML
    private Label countryLbl;

    @FXML
    private ComboBox<Countries> countryCombo;

    @FXML
    private Label customerIdLbl;

    @FXML
    private TextField customerIdTxt;

    @FXML
    private Label divisionLbl;

    @FXML
    private ComboBox<FirstLevelDivisions> divisionCombo;

    @FXML
    private Label nameLbl;

    @FXML
    private TextField nameTxt;

    @FXML
    private Label phoneNumberLbl;

    @FXML
    private TextField phoneNumberTxt;

    @FXML
    private Label zipCodeLbl;

    @FXML
    private TextField zipCodeTxt;

    Stage stage;
    Parent scene;

    // List that holds all countries.
    ObservableList<Countries> countryList = DBCountries.getAllCountries();

    /**
     * This method directs user to the customer menu.
     *
     * @param event button.
     */
    // Redirects user to the customer main screen
    @FXML
    public void onActionBackToCustomer(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to leave this page?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/CustomerMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    /**
     * This method grabs the user input, error checks, and saves the data to the database.
     *
     * @param event button.
     */
    // Saves the customer input when the save button is clicked
    @FXML
    public void onActionSaveCustomer(ActionEvent event) throws IOException {

        try {
            // Grabs user input from form
            String name = nameTxt.getText();
            String address = addressTxt.getText();
            String zipcode = zipCodeTxt.getText();
            String phone = phoneNumberTxt.getText();
            Countries country = countryCombo.getValue();
            FirstLevelDivisions division = divisionCombo.getSelectionModel().getSelectedItem();

            if(name.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Customer Name cannot be left blank.");
                alert.showAndWait();
                return;
            }
            if (address.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Address cannot be left blank.");
                alert.showAndWait();
                return;
            }
            if (zipcode.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Postal Code cannot be left blank.");
                alert.showAndWait();
                return;
            }
            if (phone.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Phone Number cannot be left blank.");
                alert.showAndWait();
                return;
            }
            if (country == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Country cannot be left blank.");
                alert.showAndWait();
                return;
            }
            if (division == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Divisions cannot be left blank.");
                alert.showAndWait();
                return;
            }

                // Adds data to the DB
            DBCustomers.addCustomer(name, address, zipcode, phone, country.getCountry(), division.getId());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Customer has been added");
            alert.showAndWait();

            // Redirects user to the customer main screen
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/CustomerMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("New Customer not added. Please complete all fields.");
            alert.showAndWait();
        }
    }

    /**
     * This method changes the selection of the divisions based on the country selected.
     *
     * @param event button.
     */
    // Division combo box items selection is filtered based off the selected Country combo box in the new customer
    // controller form
    @FXML
    public void onActionChangeDivision(ActionEvent event) {
        Countries countrySelected = countryCombo.getSelectionModel().getSelectedItem();
        divisionCombo.setItems(DBFirstLevelDivisions.getFilteredDivisions(countrySelected));

    }

    /**
     * This method sets the country combo box with data.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countryCombo.setItems(countryList);
        divisionCombo.setItems(DBFirstLevelDivisions.getAllFLD());
    }
}
