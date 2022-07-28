package DBAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;
import model.FirstLevelDivisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database First Level Divisions class.
 */
public class DBFirstLevelDivisions {

    /**
     * This method retrieves all the divisions from our database and adds them to an observable list named
     * fldList.
     *
     * @return Returns fldList of all divisions.
     */
    // Grabs all divisions from the database.
    public static ObservableList<FirstLevelDivisions> getAllFLD() {
        ObservableList<FirstLevelDivisions> fldList = FXCollections.observableArrayList();
        try {

            String sql = "SELECT * FROM first_level_divisions";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryId = rs.getInt("COUNTRY_ID");

                FirstLevelDivisions fld = new FirstLevelDivisions(id, division, countryId);
                fldList.add(fld);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fldList;
    }

    /**
     * This method retrieves a filtered version of divisions from our database and adds them to an observable list named
     * divisionList.
     *
     * @param countrySelected passes the country selected by user.
     * @return Returns divisionList of filtered divisions.
     */
    // Grabs filtered divisions by country from the database.
    public static ObservableList<FirstLevelDivisions> getFilteredDivisions(Countries countrySelected) {
        ObservableList<FirstLevelDivisions> divisionList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM first_level_divisions WHERE COUNTRY_ID=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, countrySelected.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryId = rs.getInt("COUNTRy_ID");

                FirstLevelDivisions fld = new FirstLevelDivisions(id, division, countryId);
                divisionList.add(fld);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divisionList;
    }

    /**
     * This method retrieves the division name by the division id.
     *
     * @param id passes the division id.
     * @return Returns fld of division's name by the division's id.
     * @return Returns null if there is no fld of division's name by the division's id.
     */
    // Grabs the division name by division id from the database.
    public static FirstLevelDivisions getDivision(int id) {
        try {
            String sql = "SELECT * FROM first_level_divisions WHERE Division_ID=?";
            PreparedStatement ps = DBConnection.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String division = rs.getString("Division");
                int countryId = rs.getInt("COUNTRY_ID");

                FirstLevelDivisions fld = new FirstLevelDivisions(id, division, countryId);
                return fld;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


