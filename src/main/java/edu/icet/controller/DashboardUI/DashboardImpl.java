package edu.icet.controller.DashboardUI;

import edu.icet.DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardImpl implements DashBoardService{
    @Override
    public String validUser(String email) {
        String sql = "SELECT first_name, last_name FROM register WHERE email = ?";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email); // set the email parameter

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // For testing, print to console
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);

                return firstName+" "+lastName;

                // TODO: set these values in your dashboard UI labels
                // e.g., lblFirstName.setText(firstName);
                //       lblLastName.setText(lastName);
            } else {
                System.out.println("No user found with email: " + email);
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
