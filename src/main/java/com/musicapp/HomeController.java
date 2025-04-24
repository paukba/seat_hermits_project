package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML Label signedIn;

    @FXML
    private void initialize() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        signedIn.setText("Logged in as: " + user.getUserName());
    }

    @FXML
    private void switchToLogIn() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void switchToSearchAuthor() throws IOException {
        App.setRoot("searchauthor");
    }

    @FXML
    private void switchToFindSong() throws IOException {
        App.setRoot("searchsong");
    }

    @FXML
    private void switchToMySongs() throws IOException {
        App.setRoot("user_mysongs");
    }

    @FXML
    private void switchToCreateSong() throws IOException {
        App.setRoot("createsong");
    }

    @FXML
    private void switchToPlaySong() throws IOException {
        App.setRoot("playsong");
    }
    
}
