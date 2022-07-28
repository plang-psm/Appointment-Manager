package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Database Countries class.
 */
public class DBCountries {
    /**
     * This method retrieves all the countries in our database and adds them to an observable list named
     * countriesList.
     *
     * @return Returns countriesList of all countries.
     */
    // Grabs all the countries from the database.
    public static ObservableList<Countries> getAllCountries() {
        ObservableList<Countries> countriesList = FXCollections.observableArrayList();
        try {

            String sql = "SELECT COUNTRY_ID, Country FROM countries";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Country_ID");
                String country = rs.getString("Country");

                Countries countries= new Countries(id, country);
                countriesList.add(countries);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countriesList;
    }
    /**
     * This method retrieves the country mame by country id.
     *
     * @param id Passes the country id.
     * @return Returns country of the country.
     * @return Returns null if no country of the country.
     */
    // Grabs the country name by the country id.
    public static Countries getCountry(int id) {
        try {
            String sql = "SELECT * FROM Countries WHERE Country_Id=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String name = rs.getString("Country");

                Countries country = new Countries(id, name);
                return country;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    /**
     * This method retrieves the country by division id.
     *
     * @param id Passes the division id.
     * @return Returns country of the country by division id.
     * @return Returns null if no country of the country by the division id.
     */
    // Grabs the country name by division id.

    public static Countries getCountryByDiv(int id) {
        try {
            String sql = "SELECT c.* FROM Countries as c INNER JOIN first_level_divisions as d " +
                    "ON c.Country_Id = d.Country_Id AND d.Division_Id = ?";

            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int cId = rs.getInt("Country_ID");
                String name = rs.getString("Country");

                Countries country = new Countries(cId, name);
                return country;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
