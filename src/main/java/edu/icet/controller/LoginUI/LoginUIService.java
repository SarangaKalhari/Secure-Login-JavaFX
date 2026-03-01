package edu.icet.controller.LoginUI;

public interface LoginUIService {

    boolean isUserRegistered(String email, String password);

    boolean isEmailRegistered(String email);
}
