package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML TextField username;
    @FXML TextField password;

    @FXML
    private void switchToHome() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.login(username.getText(), password.getText());
        if (user != null) {
            if (!user.getIsAuthor()) {
                App.setRoot("loggedin");
            }
            else {
                App.setRoot("loggedinauthor");
            }
            
        }
        else if (username.getText().equals("") && password.getText().equals("")) {
            users.login("iamSpider99", "spiderman2099roolz");
            App.setRoot("loggedinauthor");
        }
    }

    @FXML
    private void switchToCreateAccount() throws IOException {
        App.setRoot("createaccount");
    }

    
}
