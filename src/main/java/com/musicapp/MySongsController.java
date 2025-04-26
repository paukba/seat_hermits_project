package com.musicapp;

import java.io.IOException;

import com.model.UserList;
import com.model.User;
import com.model.SongList;
import com.model.Song;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MySongsController {

    @FXML Label userName;

    @FXML Button songA;
    

    @FXML
    private void initialize() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        SongList songs = SongList.getInstance();
        userName.setText(user.getUserName());
        
        // This will add the correct song to the first button.
        // Something like the below is an idea for how it iteratively name the buttons
        // when you get there but you'll probably have to initialize each button in this class.
        songA.setText(songs.getSong(user.getMySongs().get(0)).getTitle());

        /*
        for (int i = 0; i < user.getMySongs().size(); i++)
            songA.setText(songs.getSong(user.getMySongs().get(i)).getTitle()); // Actually name the button the song name
        */
        
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("loggedinauthor");
    }
    
}
