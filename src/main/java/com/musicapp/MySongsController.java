package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MySongsController {

    @FXML Label userName;

    @FXML
    private void initialize() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        userName.setText(user.getUserName());
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("loggedinauthor");
    }
    
}
