package edu.icet.controller.DashboardUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashBoardController {

    private  final DashboardImpl dashboard = new DashboardImpl();

    @FXML
    private Label lblEmail;

    private

    @FXML
    void handleLogout(ActionEvent event) {

    }

    public void setUserEmail(String email) {
        lblEmail.setText(dashboard.validUser(email));
    }
}
