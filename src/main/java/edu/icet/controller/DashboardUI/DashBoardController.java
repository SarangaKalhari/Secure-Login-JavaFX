package edu.icet.controller.DashboardUI;

import edu.icet.controller.LoginUI.LoginUIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {

    private  final DashboardImpl dashboard = new DashboardImpl();

    Stage stage = new Stage();

    @FXML
    private Label lblEmail;


    @FXML
    void handleLogout(ActionEvent event) {

        try {

            stage.setScene(new Scene((FXMLLoader.load(getClass().getResource("/view/LoginUI.fxml")))));

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            stage.setTitle("Login");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUserEmail(String email) {
        lblEmail.setText(dashboard.validUser(email));
    }

    public void dashBoardOnAction(ActionEvent actionEvent) {
        try {
            Scene scene = new Scene((FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));

            // Get the controller created by FXMLLoader

            Stage stage = (Stage) lblEmail.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
