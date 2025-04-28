package com.musicapp;

import java.io.IOException;
import com.model.Driver;

import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

import com.model.User;
import com.model.UserList;
import com.model.Song;
import com.model.SongList;
import com.model.TabNote;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;

public class PlaySongController {

    Boombox player = new Boombox();
    static SongList songs = SongList.getInstance();
    static Song currentSong = songs.getCurrentSong();
    static boolean moveCursor;

    @FXML AnchorPane main;
    @FXML static AnchorPane box;
    @FXML Label songTitle;
    @FXML static Line cursor;

    @FXML
    private void initialize() throws IOException {
        songTitle.setText(" " + currentSong.getTitle());

        box = new AnchorPane();
        box.setPrefSize(1800, 180);
        for (int i = 0; i < 6; i++) {
            Line line = new Line();
            line.setLayoutY((i * 28) + 20);
            line.setStartX(0);
            line.setEndX(2000);
            box.getChildren().add(line);
        }

        // for (int i = 0; i < currentSong.getTotalTime(); i++) {
        //     for (int j = 0; j < 6; j++) {
        //         Rectangle rect = new Rectangle();
        //         rect.setLayoutX(i*30 + 30);
        //         rect.setLayoutY(j*28 + 10);
        //         rect.setWidth(20);
        //         rect.setHeight(20);
        //         rect.setFill(Color.DODGERBLUE);
        //         box.getChildren().add(rect);
        //     }
        // }

        ArrayList<TabNote> displayNotes = currentSong.getTabDisplay();
        Iterator<TabNote> noteIterator = displayNotes.iterator();
        while (noteIterator.hasNext()) {
            TabNote note = noteIterator.next();
            int x = (int) note.getTabnoteNote().getStartTime();
            int y = 0;
            switch (note.getTabnoteString()) {
                case "b":
                    y = 1;
                    break;
                case "g":
                    y = 2;
                    break;
                case "d":
                    y = 3;
                    break;
                case "a":
                    y = 4;
                    break;
                case "e":
                    y = 5;
                    break;
                default:
                    break;
            }
            Rectangle rect = new Rectangle();
            rect.setLayoutX(x*30 + 30);
            rect.setLayoutY(y*28 + 10);
            rect.setWidth(20);
            rect.setHeight(20);
            rect.setFill(Color.DODGERBLUE);
            box.getChildren().add(rect);

            Label label = new Label();
            label.setLayoutX(x*30 + 30);
            label.setLayoutY(y*28 + 10);
            label.setPrefHeight(20);
            label.setPrefWidth(20);
            label.setText(Integer.toString(note.getTabnoteFret()));
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.WHITE);
            box.getChildren().add(label);
        }

        cursor = new Line();
        cursor.setLayoutX(30);
        cursor.setStartY(0);
        cursor.setEndY(180);
        box.getChildren().add(cursor);

        for (int i = 0; i < currentSong.getTotalTime(); i++) {}


        ScrollPane scroll = new ScrollPane();
        scroll.setLayoutX(0);
        scroll.setLayoutY(100);
        scroll.setPrefSize(600, 200);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setContent(box);

        main.getChildren().add(scroll);
    }
    
    @FXML
    private void switchToHome() throws IOException {
        if (!Boombox.playing) {
            UserList users = UserList.getInstance();
            User user = users.getCurrentUser();
            if (user.getIsAuthor()) {
                App.setRoot("loggedinauthor");
            }
            else {
                App.setRoot("loggedin");
            }
        }
    }

    @FXML
    private void play() throws IOException {
        if (!Boombox.playing) {
            player = new Boombox();
            player.start();
            new Timer().start();
        }
        // while (Boombox.playing) {
        //     if (moveCursor) {
        //         moveCursor();
        //     }
        // }
    }

    @FXML
    private void pause() throws IOException {
        player.interrupt();
    }

    @FXML
    private void favorite() throws IOException {
        UserList users = UserList.getInstance();
        User user = users.getCurrentUser();
        user.addFavSong(currentSong.getId());
    }

    @FXML
    private static void moveCursor() {
        box.getChildren().remove(cursor);
        cursor.setLayoutX(cursor.getLayoutX()+30);
        box.getChildren().add(cursor);
    }



    static class Boombox extends Thread {

        public static boolean playing;

        public void run() {
            SongList songs = SongList.getInstance();
            Song currentSong = songs.getCurrentSong();
            playing = true;
            new Player().play(Driver.playSong(currentSong.getId()));
            playing = false;
        }
    }

    static class Timer extends Thread {
        @FXML
        public void run() {
            for (int i = 0; i < currentSong.getTotalTime()+1; i++) {
                try {
                    if (i == 0) {
                        sleep(250);
                    }
                    else {
                        sleep(500);
                    }
                    PlaySongController.moveCursor = true;
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
