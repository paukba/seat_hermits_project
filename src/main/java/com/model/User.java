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
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.id = UUID.randomUUID();
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

    public UUID getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean getIsAuthor(){
        return false;
    }

    public ArrayList<Song> getMySongs(){
        return favoriteSongs;
    }
}