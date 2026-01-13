package edu.icet.controller.SignUP;

import edu.icet.model.dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpUIController {

    private final SignUpImpl sign = new SignUpImpl();
    Stage stage = new Stage();

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtReEnterPassword;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblEmail;


    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        String fname = txtFirstName.getText().trim();
        String lname = txtLastName.getText().trim();
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();
        String rePassword = txtReEnterPassword.getText().trim();

        if (!password.equals(rePassword)) {
            lblPassword.setText("Passwords do not match!");
            return; // stop execution
        }

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            lblPassword.setText("Please fill all fields!");
            return;
        }

        UserDTO user = new UserDTO(fname, lname, email, password);
        int generatedId = sign.addRegister(user);

        if (generatedId != -1) {
            lblPassword.setText("User registered successfully! ID: " + generatedId);
        } else {
            lblPassword.setText("Registration failed!");
        }

        if (isValidEmail(email) && isValidPassword(password)){
            System.out.println("Valid Login..");
        }else if (!isValidEmail(email) && isValidPassword(password)){
            lblEmail.setText("Invalid Email address.");
            System.out.println("Invalid ..");
        } else if (isValidEmail(email) && !isValidPassword(password)) {
            lblPassword.setText("Invalid Password.");

        }else {
            lblEmail.setText("Invalid Email address.");
            lblPassword.setText("Invalid Password.");
        }
    }

    @FXML
    void loginOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginUI.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
