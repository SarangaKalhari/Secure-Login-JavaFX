package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginUIController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label txtInvalidEmail;

    @FXML
    private Label txtInvalidPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        if (isValidEmail(email) && isValidPassword(password)){
            System.out.println("Valid Login..");
        }else if (!isValidEmail(email) && isValidPassword(password)){
            txtInvalidEmail.setText("Invalid Email address.");
            System.out.println("Invalid ..");
        } else if (isValidEmail(email) && !isValidPassword(password)) {
            txtInvalidPassword.setText("Invalid Password.");

        }else {
            txtInvalidEmail.setText("Invalid Email address.");
            txtInvalidPassword.setText("Invalid Password.");
        }


    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }

    private boolean isValidEmail(String email){
        String isGmail = "^[a-zA-Z0-9]+@gmail\\.com$";
        return email.matches(isGmail);
    }

    private boolean isValidPassword(String password){
        String isPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,}$";
        return password.matches(isPassword);
    }
}
