package com.model;

import java.util.ArrayList;
import java.util.UUID;

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
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setTitle(name);
    }

    public void editSongSheets(String songID, ArrayList<Sheet> sheets) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setSheets(sheets);
    }

    public void editSongTabs(String songID, ArrayList<Tab> tabs) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setTabs(tabs);
    }

    public void editSongLyrics(String songID, ArrayList<String> lyrics) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setLyrics(lyrics);
    }

    public void editSongPrivacy(String songID, boolean privacy) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setPrivacy(privacy);
    }

    public void deleteSong(String songID) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        songList.removeSong(operandSong);
    }
}
