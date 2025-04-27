package com.musicapp;

import java.io.IOException;
import java.util.ArrayList;

import com.model.UserList;
import com.model.SongList;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.*;

public class HomeController {

    @FXML Label signedIn;
    @FXML Button a;
    @FXML Button b;
    @FXML Button c;
    @FXML Button d;
    @FXML Button e;
    @FXML Button f;

    @FXML AnchorPane songpane;

    @FXML Scene scene;

    @FXML
    private void initialize() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        signedIn.setText("Logged in as: " + user.getUserName());

        SongList songs = SongList.getInstance();
        // Fav-songs
        ArrayList<Button> buttonList = new ArrayList<Button>();
        for (int i = 0; i < user.getFavoriteSongs().size(); i++) {

            buttonList.add(new Button(songs.getSong(user.getFavoriteSongs().get(i)).getTitle()));

            buttonList.get(i).setLayoutX(23 + 293  * (i % 2));
            buttonList.get(i).setLayoutY(20 + 74 * (i / 2));
            buttonList.get(i).setPrefSize(244, 64);
            buttonList.get(i).setStyle("-fx-background-color:hsl(205, 100.00%, 95.30%); ");
            buttonList.get(i).setStyle("-fx-text-fill:#347caf; ");
            buttonList.get(i).setStyle("-fx-background-color: MediumSeaGreen");

            buttonList.get(i).setStyle("-fx-font-size: 1.5em; ");

            songpane.getChildren().add(buttonList.get(i));
        }
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
