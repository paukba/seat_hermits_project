package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label; 


public class LoginController {

    @FXML Label err1;
    @FXML Label err2;
    
    @FXML TextField username;
    @FXML TextField password;

    @FXML
    private void switchToHome() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.login(username.getText(), password.getText());
        
        err1.setText("");
        err2.setText("");
        if (user != null && users.getUser(username.getText()) != null && users.getUser(username.getText()).getPassword().equals(password.getText())) {
            if (!user.getIsAuthor()) {
                App.setRoot("loggedin");
            }
            else {
                App.setRoot("loggedinauthor");
            }
            
        }
        else if (user != null && users.getUser(username.getText()) != null) {
            err2.setText("Error");
        }
        else if (username.getText().equals("") && password.getText().equals("")) {
            users.login("Guest", "password");
            App.setRoot("loggedinauthor");
        }
        else {
            err1.setText("Error");
            err2.setText("Error");
        }
    }

    @FXML
    private void switchToCreateAccount() throws IOException {
        App.setRoot("createaccount");
    }

    
}
