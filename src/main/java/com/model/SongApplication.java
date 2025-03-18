package com.model;

import java.util.ArrayList;

import javafx.scene.control.Tab;

public class SongApplication {
    private SongList songList;
    private UserList userLiser;
    private User user;

    public SongApplication() {

    }

    public ArrayList<Song> findSongs() {
        return new ArrayList<Song>();
    }

    public ArrayList<Song> findSongs(String keyword) {
        return new ArrayList<Song>();
    }

    public User createAccount(String firstName, String lastName, String email, String userName, String password, boolean isAuthor) {
        if (isAuthor)
            return new Author(firstName, lastName, email, userName, password, new ArrayList<Song>(), new ArrayList<Song>());
        else
            return new User(firstName, lastName, email, userName, password, new ArrayList<Song>(), false);
    }

    public User login(String userName, String password) {
        return UserList.getInstance().login(userName, password);
    }

    public ArrayList<Song> getFavoriteSongs() {
        return new ArrayList<Song>();
    }

    public ArrayList<Song> getMySongs() {
        return new ArrayList<Song>();
    }

    public void addSong(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, boolean privacy, ArrayList<Instrument> instruments) {

    }

    public void editSongTitle(String songID, String name) {

    }

    public void editSongSheets(String songID, ArrayList<Sheet> sheets) {
        
    }

    public void editSongTabs(String songID, ArrayList<Tab> tabs) {
        
    }

    public void editSongLyrics(String songID, ArrayList<String> lyrics) {
        
    }

    public void editSongPrivacy(String songID, boolean privacy) {
        
    }

    public void deleteSong(String songID) {
        
    }
}
