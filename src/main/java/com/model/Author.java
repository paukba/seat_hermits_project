package com.model;

import java.util.ArrayList;

public class Author extends User {
    private ArrayList<Song> mySongs;

    public Author(String firstName, String lastName, String email, String userName, String password, ArrayList<Song> favoriteSongs, ArrayList<Song> mySongs) {
        super(firstName, lastName, email, userName, password, favoriteSongs, true);
        this.mySongs = mySongs;
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