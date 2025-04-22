package com.musicapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML Label signedIn;

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
        App.setRoot("findsong");
    }
    
}
