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
    private ArrayList<UUID> favoriteSongsUUIDs;
    private boolean isAuthor = false;

    public User(String firstName, String lastName, String email, String userName, String password, ArrayList<Song> favoriteSongs, boolean isAuthor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAuthor = isAuthor;
        this.favoriteSongs = favoriteSongs;
    }
    
    public void addSong(Song song) {
        favoriteSongs.add(song);
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

    public UUID getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public boolean getIsAuthor() {
        return isAuthor;
    }
}