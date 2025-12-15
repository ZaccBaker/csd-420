package database;

import java.sql.*;
import javafx.scene.control.Alert;

public class Model {
    public static Connection onConnect() {
        final String url = "jdbc:mysql://localhost:3306/databasedb"; 
        final String username = "root";
        final String password = "23156Seoul1997!!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Encountered");
            alert.setHeaderText("JDBC Driver not found.");
            alert.setContentText("DETAILS - " + e);
            alert.show();
            return null;
        }
    }


    public static String[] findRecord(Connection conn, int recordID) { 
        final String query = "SELECT ID,firstname, lastname, favoriteteam FROM fans WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, recordID);
            rs = stmt.executeQuery();
            while (rs.next()){
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String favoriteteam = rs.getString("favoriteteam");
                System.out.println("Data: "
                        + rs.getString("firstname") + ", " + rs.getString("lastname") + ", " + rs.getString("favoriteteam")); // For debugging
                return new String[]{firstname, lastname, favoriteteam};
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Encountered");
            alert.setHeaderText("Failed to prepare SQL statement.");
            alert.setContentText("DETAILS - " + e);
            alert.show();
            return null;
        }
        return null;
    }


    public static void updateRecord(Connection conn, int recordID, String firstname, String lastname, String favoriteteam) {
        final String updateQuery = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE id = ?";
        PreparedStatement stmt = null;
        String[] data = Model.findRecord(conn, recordID);

        try {
            stmt = conn.prepareStatement(updateQuery);

            if (!firstname.isBlank()) {
                stmt.setString(1, firstname);  
            }else {
                stmt.setString(1, data[0]);
            }

            if (!lastname.isBlank()) {
                stmt.setString(2, lastname);
            }else {
                stmt.setString(2, data[1]);
            }

            if (!favoriteteam.isBlank()) {
                stmt.setString(3, favoriteteam);
            }else {
                stmt.setString(3, data[2]);
            }

            stmt.setInt(4, recordID);
            int rowsAffected = stmt.executeUpdate();
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Encountered");
            alert.setHeaderText("Failed to prepare SQL update statement.");
            alert.setContentText("DETAILS - " + e);
            alert.show();
        }
    }


    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Encountered");
            alert.setHeaderText("Failed to close database connection.");
            alert.setContentText("DETAILS - " + e);
            alert.show();
        }
    }
    
}
