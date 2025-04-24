package com.musicapp;

import java.io.IOException;

import com.model.User;
import com.model.UserList;

import javafx.fxml.FXML;

public class AuthorProfileController {
    
    @FXML
    private void switchToSearchAuthor() throws IOException {
        App.setRoot("searchauthor");
    }

    @FXML
    private void switchToHome() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        if (user.getIsAuthor()) {
            App.setRoot("loggedinauthor");
        }
        else {
            App.setRoot("loggedin");
        }
    }

}
