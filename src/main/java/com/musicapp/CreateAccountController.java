package com.musicapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*; 

import com.model.DataWriter;
import com.model.UserList;

public class CreateAccountController {
    
    @FXML Label err1;
    @FXML Label err2;
    
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
        if (users.getUser(username.getText()) != null && users.checkUniqueEmail(email.getText()) != null) {
            err1.setText("Error");
            err2.setText("Error");
        }
        else if (users.checkUniqueEmail(email.getText()) != null) {
            err1.setText("");
            err2.setText("Error");
        }
        else if (users.getUser(username.getText()) != null) {
            err1.setText("Error");
            err2.setText("");
        }
        else {
            err1.setText("");
            err2.setText("");
            
            // Make it
            users.createAccount(firstname.getText(), lastname.getText(), username.getText(), email.getText(), password.getText(), isAuthor.isSelected());
            DataWriter.saveUsers();

            App.setRoot("login");
        }
    }

}
