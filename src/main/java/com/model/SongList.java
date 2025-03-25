package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/**
 * The list of the user's songs
 */

public class SongList {
    private static SongList songList;
    private ArrayList<Song> songs;

    /**
     * Constructs a list of songs
     */
    private SongList() {
        songList = this;
        songs = new ArrayList<>();
    }

    /**
     * Gets the current instance
     * @return the current instance
     */
    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    /**
     * Adds a song to the list
     * @param song the chosen song
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Edits a song in the list
     * @param song the chosen song
     * @return the edited version of the song
     */
    public Song editSong(Song song) {
        return new Song("", new ArrayList<Tab>(), new ArrayList<String>(), Genre.ROC, true, null);
    }

    /**
     * Removes a song from the list
     * @param song the chosen song to be removed
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }

    /**
     * Gets the song
     * @param id the song's ID
     * @return check (the song) if true, null otherwise
     */
    public Song getSong(UUID id) {
        Iterator<Song> songIterator = songs.iterator();
        while (songIterator.hasNext()) {
            Song check = songIterator.next();
            if (check.id.equals(id)) {
                return check;
            }
        }
        return null;
    }
    
    /**
     * Gets the list of songs based on an inputted keyword
     * @param keyword the chosen keyword
     * @return the applicable songs
     */
    public ArrayList<Song> getSongs(String keyword) {
        return songs;
    }

    /**
     * Saves the list of songs
     */
    public void saveSongList() {
        
    }
}