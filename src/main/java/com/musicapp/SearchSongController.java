package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;

import javafx.fxml.FXML;

public class SearchSongController {

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
