package com.musicapp;

import java.io.IOException;
import java.util.ArrayList;

import com.model.UserList;
import com.model.SongList;
import com.model.Song;
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

            Song buttonSong = songs.getSong(user.getFavoriteSongs().get(i));
            Button newButton = new Button(buttonSong.getTitle());
            buttonList.add(newButton);

            newButton.setLayoutX(23 + 293  * (i % 2));
            newButton.setLayoutY(20 + 74 * (i / 2));
            newButton.setPrefSize(244, 64);
            newButton.setStyle("-fx-background-color: #E7F5FF; -fx-text-fill: #347caf; -fx-font-size: 18");
            newButton.setCursor(Cursor.HAND);

            newButton.setOnAction(event -> {
                try {
                    songs.setCurrentSong(buttonSong);
                    this.switchToPlaySong();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            });

            songpane.getChildren().add(newButton);
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
