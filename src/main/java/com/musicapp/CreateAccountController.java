package com.musicapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*; 

import com.model.DataWriter;
import com.model.UserList;

public class CreateAccountController {
    
    @FXML TextField firstname;
    @FXML TextField lastname;
    @FXML TextField username;
    @FXML TextField password;
    @FXML TextField email;
    @FXML CheckBox isAuthor;

    @FXML
    private void useAccountInfo() throws IOException {
        UserList users = UserList.getInstance();

        // Check to make sure user is unique
        if (users.getUser(username.getText()) == null) {
            // Make it
            users.createAccount(firstname.getText(), lastname.getText(), username.getText(), email.getText(), password.getText(), isAuthor.isSelected());
            DataWriter.saveUsers();

            App.setRoot("loggedin");
        }
        else {
            // username isn't unique

        }
    }

}
