package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents an Author, a User who can create and manage songs
 */

public class Author extends User {
    // private ArrayList<Song> mySongs;
    private ArrayList<UUID> mySongs;

    // public Author(String firstName, String lastName, String email, String userName, String password, ArrayList<Song> favoriteSongs, ArrayList<Song> mySongs) {
    //     super(firstName, lastName, email, userName, password, favoriteSongs, true);
    //     this.mySongs = mySongs;
    // }

    /**
     * Constructs a new Author with details
     * @param id the author's unique ID
     * @param firstName the author's first name
     * @param lastName the author's last name
     * @param email the author's email
     * @param userName the author's user name
     * @param password the password for the author's account
     * @param favoriteSongs the author's favorite songs
     * @param mySongs the author's created songs
     */
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

    /**
     * Adds a song to the author's created songs
     * @param song the UUID of the song being added
     */
    public void addMySong(UUID song) {
        mySongs.add(song);
    }

    /**
     * Edits the title of a created song
     * @param songID the UUID of the song
     * @param name the name of the song
     */
    public void editSongTitle(UUID songID, String name) {
        
    }

    /**
     * Edits the sheet music of a song
     * @param songID the UUID of the song
     * @param sheets the list of sheet music of the song
     */
    public void editSongSheets(UUID songID, ArrayList<Sheet> sheets) {
        
    }

    /**
     * Edits the tablature of a song
     * @param songID the UUID of the song
     * @param tabs the list of tablature of the song
     */
    public void editSongTabs(UUID songID, ArrayList<Tab> tabs) {
        
    }

    /**
     * Edits the lyrics of a song
     * @param songID the UUID of the song
     * @param lyrics the list of lyrics in the song
     */
    public void editSongLyrics(UUID songID, ArrayList<String> lyrics) {
        
    }

    /**
     * Edits the privacy of a song
     * @param songID the UUID of the song
     * @param privacy true if the song is private, false if public
     */
    public void editSongPrivacy(UUID songID, boolean privacy) {
        
    }

    /**
     * Deletes a favorite song
     * @param songID the UUID of the song
     */
    public void deleteFavSong(UUID songID) {
        
    }

    /**
     * Deletes a created song
     * @param songID the UUID of the song
     */
    public void deleteMySong(UUID songID) {
        
    }

    // public ArrayList<Song> getMySongs(){
    //     return mySongs;
    // }

    /**
     * Gets the author's list of created songs
     * @return the list of the author's created songs (as UUIDs)
     */
    public ArrayList<UUID> getMySongs(){
        return this.mySongs;
    }
}