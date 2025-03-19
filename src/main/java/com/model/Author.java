package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Author extends User {
    // private ArrayList<Song> mySongs;
    private ArrayList<UUID> mySongs;

    // public Author(String firstName, String lastName, String email, String userName, String password, ArrayList<Song> favoriteSongs, ArrayList<Song> mySongs) {
    //     super(firstName, lastName, email, userName, password, favoriteSongs, true);
    //     this.mySongs = mySongs;
    // }

    public Author(UUID id, String firstName, String lastName, String email, String userName, String password, ArrayList<UUID> favoriteSongs, ArrayList<UUID> mySongs) {
        super(id, firstName, lastName, email, userName, password, favoriteSongs, true);
        this.mySongs = mySongs;
    }

    // public void addFavSong(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, boolean privacy, Instrument instrument) {
    //     Song add = new Song(name, music, lyrics, genre, privacy, instrument);
    //     mySongs.add(add);
    // }

    // public void addMySong(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, boolean privacy, Instrument instrument) {
    //     Song add = new Song(name, music, lyrics, genre, privacy, instrument);
    //     mySongs.add(add);
    // }

    public void addMySong(UUID song) {
        mySongs.add(song);
    }

    public void editSongTitle(UUID songID, String name) {
        
    }

    public void editSongSheets(UUID songID, ArrayList<Sheet> sheets) {
        
    }

    public void editSongTabs(UUID songID, ArrayList<Tab> tabs) {
        
    }

    public void editSongLyrics(UUID songID, ArrayList<String> lyrics) {
        
    }

    public void editSongPrivacy(UUID songID, boolean privacy) {
        
    }

    public void deleteFavSong(UUID songID) {
        
    }

    public void deleteMySong(UUID songID) {
        
    }

    // public ArrayList<Song> getMySongs(){
    //     return mySongs;
    // }

    public ArrayList<UUID> getMySongs(){
        return this.mySongs;
    }
}
