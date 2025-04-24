package com.musicapp;

import java.io.IOException;

import javafx.fxml.FXML;

public class CreateSongController {
    
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("loggedinauthor");
    }
    
}
