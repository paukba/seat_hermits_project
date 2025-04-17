package com.musicapp;

import java.io.IOException;
import javafx.fxml.FXML;

public class CreateAccountController {
    
    @FXML
    private void createAccount() throws IOException {
        // Make it
        App.setRoot("loggedin");
    }

}
