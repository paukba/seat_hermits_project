package com.musicapp;

import java.io.IOException;
import java.util.UUID;

import com.model.UserList;
import com.model.User;
import com.model.SongList;
import com.model.Song;

import javafx.fxml.FXML;

public class SearchSongController {

    @FXML
    private void switchToHome() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        if (user.getIsAuthor()) {
            App.setRoot("loggedinauthor");
        }
        else {
            App.setRoot("loggedin");
        }
    }

    @FXML
    private void hotCrossBuns() throws IOException {
        SongList songs = SongList.getInstance();
        songs.setCurrentSong(songs.getSong(UUID.fromString("b502b509-6c49-4f92-9cda-35de5cda7e0e")));
        App.setRoot("playsong");
    }

    @FXML
    private void jingleBells() throws IOException {
        SongList songs = SongList.getInstance();
        songs.setCurrentSong(songs.getSong(UUID.fromString("47da9c99-abd8-4a92-a43e-df4d28b8495b")));
        App.setRoot("playsong");
    }
    
}
