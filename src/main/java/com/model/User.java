package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    public UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private ArrayList<Song> favoriteSongs;

    public User(String firstName, String lastName, String email, String userName) {

    }
    
    public void addSong(Song song) {

    }

    public ArrayList<Song> getSongs() {
        return new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs(String keyword) {
        return new ArrayList<Song>();
    }

    public ArrayList<Song> getFavoriteSongs() {
        return favoriteSongs;
    }
}