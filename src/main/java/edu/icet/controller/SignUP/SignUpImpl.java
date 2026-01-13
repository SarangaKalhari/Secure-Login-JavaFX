package edu.icet.controller.SignUP;

import edu.icet.controller.DB.DBConnection;
import edu.icet.model.dto.UserDTO;

import java.sql.*;

public class SignUpImpl implements SignUpService {

    @Override
    public int addRegister(UserDTO dto) {
        int generatedId = -1;
        String sql = "INSERT INTO register (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, dto.getFirstName());
            ps.setString(2, dto.getLastName());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getPassword());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1); // get auto-generated ID
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }
}
