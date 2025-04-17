package com.musicapp;

import java.io.IOException;

import com.model.UserList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML TextField username;
    @FXML TextField password;

    @FXML
    private void switchToLoggedIn() throws IOException {
        UserList users = UserList.getInstance();
        if (users.login(username.getText(), password.getText()) != null || (username.getText().equals("") && password.getText().equals(""))) {
            App.setRoot("loggedin");
        }
    }

    @FXML
    private void switchToCreateAccount() throws IOException {
        App.setRoot("createaccount");
    }

    
}
