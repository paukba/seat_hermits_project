package com.musicapp;

import java.io.IOException;

import com.model.User;
import com.model.UserList;

import javafx.fxml.FXML;

public class PlaySongController {
    
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

    @FXML
    private void play() throws IOException {

    }

    @FXML
    private void pause() throws IOException {
        
    }

    @FXML
    private void favorite() throws IOException {
        
    }

}
