package database;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.sql.Connection;

public class MyController {

    @FXML
    private TextField recordSearch;

    @FXML
    private Label idLabel;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;
    @FXML
    private Label favoriteteamLabel;
    @FXML
    private TextField firstnameUpdate;
    @FXML
    private TextField lastnameUpdate;
    @FXML
    private TextField favoriteteamUpdate;


    @FXML
    private void onDisplay(ActionEvent event) throws IOException {
        String myText = recordSearch.getText();

        try {
            int recordInput = Integer.parseInt(myText);

            Connection conn = Model.onConnect();
            String[] data = Model.findRecord(conn, recordInput);

            setLabels(data,recordInput);

            Model.closeConnection(conn);

        } catch (Exception e) {
            showAlert(e);
        }
    }


    @FXML
    private void onUpdate(ActionEvent event) throws IOException {
        System.out.println("Update clicked");
        String fnameUpdate = firstnameUpdate.getText();
        String lnameUpdate = lastnameUpdate.getText();
        String teamUpdate = favoriteteamUpdate.getText();
        String recordID = recordSearch.getText();
        try {
            int recordInput = Integer.parseInt(recordID);

            Connection conn = Model.onConnect();
            Model.updateRecord(conn, recordInput, fnameUpdate, lnameUpdate, teamUpdate);
            Model.closeConnection(conn);

        } catch (Exception e) {
            showAlert(e);
        }
    }


    private void setLabels(String[] data, int recordID) {
        idLabel.setText(Integer.toString(recordID));
        firstnameLabel.setText(data[0]);
        lastnameLabel.setText(data[1]);
        favoriteteamLabel.setText(data[2]);
    }


    private void showAlert(Exception e){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Encountered");
        alert.setHeaderText("Invalid record entry. Entry must be a valid number.");
        alert.setContentText("DETAILS - " + e);
        alert.show();
    }

}
