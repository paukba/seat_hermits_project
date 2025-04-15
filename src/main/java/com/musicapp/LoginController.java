package com.musicapp;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToLoggedIn() throws IOException {
        App.setRoot("loggedin");
    }

    @FXML
    private void switchToCreateAccount() throws IOException {
        App.setRoot("createaccount");
    }

    
}
