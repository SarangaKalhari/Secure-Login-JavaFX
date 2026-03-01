package edu.icet.controller.SignUP;
import edu.icet.DB.DBConnection;

import edu.icet.model.dto.Login;
import edu.icet.model.dto.UserDTO;

import java.sql.*;

public class SignUpImpl implements SignUpService {
    @Override
    public int addRegister(UserDTO dto) {
        int generatedId = -1;
        String sql = "INSERT INTO register (first_name, last_name, email, password) VALUES (?, ?, ?, SHA2(?, 256))";

        try {
            Connection connection = DBConnection.getInstance().getConnection(); // singleton connection

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, dto.getFirstName());
                ps.setString(2, dto.getLastName());
                ps.setString(3, dto.getEmail());
                ps.setString(4, dto.getPassword());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            generatedId = rs.getInt(1);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    @Override
    public void addEmailPassword (Login login){
        int generatedId = -1;
        String sql = "INSERT INTO user (email, password) VALUES (?, ?)";

        // Use try-with-resources for PreparedStatement (and optionally Connection)
        try {
            // Get connection from DBConnection
            Connection connection = DBConnection.getInstance().getConnection();

            // Check if connection is closed
            if (connection == null || connection.isClosed()) {
                System.out.println("Connection is closed! Reconnecting...");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/user_registration",
                        "root", "1234"
                );
            }

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, login.getEmail());
                ps.setString(2, login.getPassword());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            generatedId = rs.getInt(1);
                            System.out.println("Inserted user ID: " + generatedId);
                        }
                    }
                } else {
                    System.out.println("No rows affected. Insert failed.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

