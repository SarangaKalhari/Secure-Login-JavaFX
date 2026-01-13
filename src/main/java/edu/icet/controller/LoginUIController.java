package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginUIController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        if (isValidEmail(email)){
            System.out.println("Valid email Address..");
        }else {
            System.out.println("Invalid ..");
        }

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }

    private boolean isValidEmail(String email){
        String isGmail = "^[a-zA-Z0-9]+@gmail\\.com$";
        return email.matches(isGmail);
    }
}
