package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashBoardController {

    @FXML
    private Label lblEmail;

    private

    @FXML
    void handleLogout(ActionEvent event) {

    }

    public void setUserEmail(String email) {
        lblEmail.setText(email);
    }
}
