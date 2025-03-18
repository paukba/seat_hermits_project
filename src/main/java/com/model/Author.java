package com.model;

import java.util.ArrayList;

public class Author extends User {
    private ArrayList<Song> mySongs;

    public Author(String firstName, String lastName, String email, String userName, String password, ArrayList<Song> favoriteSongs, ArrayList<Song> mySongs) {
        super(firstName, lastName, email, userName, password, favoriteSongs, true);
        this.mySongs = mySongs;
    }

    public void addFavSong(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, boolean privacy, Instrument instrument) {
        Song add = new Song(name, music, lyrics, genre, privacy, instrument);
        mySongs.add(add);
    }

    public void addMySong(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, boolean privacy, Instrument instrument) {
        Song add = new Song(name, music, lyrics, genre, privacy, instrument);
        mySongs.add(add);
    }

    public ArrayList<Song> getMySongs() {
        return mySongs;
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