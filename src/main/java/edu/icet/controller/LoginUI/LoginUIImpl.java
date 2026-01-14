package edu.icet.controller.LoginUI;

import edu.icet.DB.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginUIImpl implements LoginUIService {



    @Override
    public boolean isUserRegistered(String email, String password) {

        String sql = "SELECT id FROM user WHERE email = ? AND password = ?";


        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public boolean isEmailRegistered(String email) {

        String sql = "SELECT id FROM register WHERE email = ?";

        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
