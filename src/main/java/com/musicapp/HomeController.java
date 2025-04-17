package com.musicapp;

import java.io.IOException;

import javafx.fxml.FXML;

public class HomeController {

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
