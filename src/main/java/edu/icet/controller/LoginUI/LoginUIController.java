package edu.icet.controller.LoginUI;

import edu.icet.controller.DashBoardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginUIController {
    Stage stage = new Stage();




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

        LoginUIImpl loginUI = new LoginUIImpl();

        // Format validations
        if (!isValidEmail(email)) {
            txtInvalidEmail.setText("Invalid Email format");
            txtInvalidPassword.setText("");
            return;
        }

        if (!isValidPassword(password)) {
            txtInvalidPassword.setText("Invalid Password format");
            txtInvalidEmail.setText("");
            return;
        }

        // DB validations
        if (!loginUI.isEmailRegistered(email)) {
            txtInvalidEmail.setText("Email not registered");
            txtInvalidPassword.setText("");
            return;
        }

        if (!loginUI.isUserRegistered(email, password)) {
            txtInvalidPassword.setText("Incorrect Password");
            txtInvalidEmail.setText("");
            return;
        }

        // ===== Login Success =====
        txtInvalidEmail.setText("");
        txtInvalidPassword.setText("");
        System.out.println("Login Successful!");

        openDashboard(email);
    }

    private void openDashboard(String email) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
            Scene scene = new Scene(loader.load());

            // Get the controller created by FXMLLoader
            DashBoardController controller = loader.getController();
            controller.setUserEmail(email); // pass logged email

            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean isValidEmail(String email) {
        String isGmail = "^[a-zA-Z0-9]+@gmail\\.com$";
        return email.matches(isGmail);
    }

    private boolean isValidPassword(String password) {
        String isPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,}$";
        return password.matches(isPassword);
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
