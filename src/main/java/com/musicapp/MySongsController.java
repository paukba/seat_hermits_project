package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;
import com.model.SongList;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class MySongsController {
    
    @FXML Label userName;

    @FXML Button songA;

    @FXML AnchorPane songpane;
    

    @FXML
    private void initialize() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        SongList songs = SongList.getInstance();
        userName.setText(user.getUserName());
        
        //getClass().getResource("stylesheet.css");
        //songpane.getStyleClass().add("pane");
        
        ArrayList<Button> buttonList = new ArrayList<Button>();
        for (int i = 0; i < user.getMySongs().size(); i++) {
            
            Button newButton = new Button(songs.getSong(user.getMySongs().get(i)).getTitle());
            buttonList.add(newButton);

            newButton.setLayoutX(23 + 293  * (i % 2));
            newButton.setLayoutY(20 + 74 * (i / 2));
            newButton.setPrefSize(244, 64);
            newButton.setStyle("-fx-background-color:hsl(205, 100.00%, 95.30%); ");
            newButton.setStyle("-fx-text-fill:#347caf; ");
            newButton.setStyle("-fx-background-color: MediumSeaGreen");
            newButton.setStyle("-fx-font-size: 1.5em; ");
            

            newButton.setCursor(Cursor.HAND);
            newButton.setStyle("-fx-background-color: #E7F5FF; -fx-text-fill: #347caf; -fx-font-size: 18");

            songpane.getChildren().add(newButton);
        }
        
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("loggedinauthor");
    }
    
}
