package com.model;

import java.util.ArrayList;

public class SongList {
    private SongList songList;
    private ArrayList<Song> songs;

    private SongList() {
        // this.songList = ?
        this.songs = new ArrayList<>();
    }

    public Song getInstance() {
        return new Song("", new ArrayList<Tab>(), new ArrayList<String>(), Genre.ROC, true, null);
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public Song editSong(Song song) {
        return new Song("", new ArrayList<Tab>(), new ArrayList<String>(), Genre.ROC, true, null);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public ArrayList<Song> getSongs(String keyword) {
        return songs;
    }

    public void saveSongList() {
        
    }
}