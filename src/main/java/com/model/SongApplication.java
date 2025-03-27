package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Acts as the central application for managing user accounts and songs
 * Provides functionality to create, search, edit, delete songs, and handles user authentication
 */

public class SongApplication {
    private SongList songList;
    private UserList userLiser;
    private User user;

    /**
     * Initializes a new instance of SongApplication
     */
    public SongApplication() {

    }

    /**
     * Retrieves a list of available songs
     * @return the list of songs
     */
    public ArrayList<Song> findSongs() {
        return new ArrayList<Song>();
    }

    /**
     * Searches for songs based on a keyword
     * @param keyword the chosen keyword
     * @return the list of songs that have the keyword
     */
    public ArrayList<Song> findSongs(String keyword) {
        return new ArrayList<Song>();
    }

    // public User createAccount(String firstName, String lastName, String email, String userName, String password, boolean isAuthor) {
    //     UUID id = UUID.randomUUID();
    //     if (isAuthor)
    //         return new Author(id, firstName, lastName, email, userName, password, new ArrayList<Song>(), new ArrayList<Song>());
    //     else
    //         return new User(id, firstName, lastName, email, userName, password, new ArrayList<Song>(), false);
    // }

    /**
     * Creates a new user account
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param email the user's email
     * @param userName the username for the user's account
     * @param password the password for the user's account
     * @param isAuthor whether or not the user has author privileges
     * @return either a new User or Author object
     */
    public User createAccount(String firstName, String lastName, String email, String userName, String password, boolean isAuthor) {
        UUID id = UUID.randomUUID();
        if (isAuthor)
            return new Author(id, firstName, lastName, email, userName, password, new ArrayList<UUID>(), new ArrayList<UUID>());
        else
            return new User(id, firstName, lastName, email, userName, password, new ArrayList<UUID>(), false);
    }

    /**
     * Allows a user to log in
     * @param userName the user's username
     * @param password the user's password
     * @return the User if successful, null otherwise
     */
    public User login(String userName, String password) {
        return UserList.getInstance().login(userName, password);
    }

    /**
     * Gets a list of the user's favorite songs
     * @return the list of favorite songs
     */
    public ArrayList<Song> getFavoriteSongs() {
        return new ArrayList<Song>();
    }

    /**
     * Gets a list of created songs
     * @return the list of created songs
     */
    public ArrayList<Song> getMySongs() {
        return new ArrayList<Song>();
    }

    /**
     * Adds a new song to the application
     * @param name the title of the song
     * @param music the list of musical notation
     * @param lyrics the list of lyrics in the song
     * @param genre the genre of the song
     * @param privacy whether the song is public or private
     * @param instruments the list of instruments in the song
     */
    public void addSong(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, boolean privacy, ArrayList<Instrument> instruments) {

    }

    /**
     * Edits the title of a song
     * @param songID the UUID of the song
     * @param name the new name of the song
     */
    public void editSongTitle(String songID, String name) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setTitle(name);
    }

    /**
     * Edits the sheet music of a song
     * @param songID the UUID of the song
     * @param sheets the new sheet music
     */
    public void editSongSheets(String songID, ArrayList<Sheet> sheets) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setSheets(sheets);
    }

    /**
     * Edits the tablature of a song
     * @param songID the UUID of the song
     * @param tabs the new tabs
     */
    public void editSongTabs(String songID, ArrayList<Tab> tabs) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setTabs(tabs);
    }

    /**
     * Edits the lyrics of a song
     * @param songID the UUID of the song
     * @param lyrics the new lyrics of the song
     */
    public void editSongLyrics(String songID, ArrayList<String> lyrics) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setLyrics(lyrics);
    }

    /**
     * Edits the privacy of a song
     * @param songID the UUID of the song
     * @param privacy the new privacy of the song
     */
    public void editSongPrivacy(String songID, boolean privacy) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        operandSong.setPrivacy(privacy);
    }

    /**
     * Deletes a song from the application
     * @param songID the UUID of the chosen song
     */
    public void deleteSong(String songID) {
        UUID id = UUID.fromString(songID);
        songList = SongList.getInstance();
        Song operandSong = songList.getSong(id);
        songList.removeSong(operandSong);
    }
}
