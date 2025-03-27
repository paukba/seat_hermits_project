package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a User with account details, favorite songs, and author privileges
 */

public class User {
    public UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    // private ArrayList<Song> favoriteSongs;
    private ArrayList<UUID> favoriteSongs;
    private boolean isAuthor = false;

    // public User(String firstName, String lastName, String email, String userName, String password, ArrayList<Song> favoriteSongs, boolean isAuthor) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.email = email;
    //     this.userName = userName;
    //     this.password = password;
    //     this.isAuthor = isAuthor;
    //     this.favoriteSongs = favoriteSongs;
    // }

    /**
     * Constructs a new User with details
     * @param id the user's unique ID
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param userName the username for the user's account
     * @param email the user's email
     * @param password the password for the user's account
     * @param favoriteSongs the user's favorite songs (as UUIDs)
     * @param isAuthor whether or not the user has author privileges
     */
    public User(UUID id, String firstName, String lastName, String userName, String email, String password, ArrayList<UUID> favoriteSongs, boolean isAuthor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAuthor = isAuthor;
        this.favoriteSongs = favoriteSongs;
    }
    
    /**
     * Adds a new favorite song to the user's list of favorite songs
     * @param song the UUID of the song to be added
     */
    public void addFavSong(UUID song) {
        favoriteSongs.add(song);
    }

    // public ArrayList<Song> getSongs() {
    //     return new ArrayList<Song>();
    // }

    // public ArrayList<Song> getSongs(String keyword) {
    //     return new ArrayList<Song>();
    // }

    // public ArrayList<Song> getFavoriteSongs() {
    //     return favoriteSongs;
    // }

    /**
     * Gets the user's favorite songs
     * @return the list of favorited songs (as UUIDs)
     */
    public ArrayList<UUID> getFavoriteSongs() {
        return favoriteSongs;
    }

    /**
     * Gets the user's unique ID
     * @return the user's unique ID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the user's first name
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the user's last name
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the user's email
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's username
     * @return the user's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets the user's password
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Checks if the user has author privileges
     * @return  true if the user is an author, false otherwise
     */
    public boolean getIsAuthor() {
        return isAuthor;
    }
}