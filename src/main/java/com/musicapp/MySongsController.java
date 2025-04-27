package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;
import com.model.SongList;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
            
            buttonList.add(new Button(songs.getSong(user.getMySongs().get(i)).getTitle()));
            buttonList.get(i).setLayoutX(23 + 293  * (i % 2));
            buttonList.get(i).setLayoutY(20 + 74 * (i / 2));
            buttonList.get(i).setPrefSize(244, 64);
            buttonList.get(i).setStyle("-fx-background-color:hsl(205, 100.00%, 95.30%); ");
            buttonList.get(i).setStyle("-fx-text-fill: #347caf; ");
            //buttonList.get(i).setStyle("-fx-background-color: #00ff00");

            buttonList.get(i).setStyle("-fx-font-size: 1.5em; ");

            songpane.getChildren().add(buttonList.get(i));
        }
        
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("loggedinauthor");
    }
    
}
