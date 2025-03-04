package com.model;

import java.util.ArrayList;

public class SongList {
    private SongList songList;
    private ArrayList<Song> songs;

    private SongList() {
        
    }

    public Song getInstance() {
        return new Song("", new ArrayList<Tab>(), new ArrayList<String>(), Genre.ROC, true,
               new Instrument(new ArrayList<Note>(), new ArrayList<Chord>()));
    }

    public void addSong(Song song) {

    }

    public Song editSong(Song song) {
        return new Song("", new ArrayList<Tab>(), new ArrayList<String>(), Genre.ROC, true,
               new Instrument(new ArrayList<Note>(), new ArrayList<Chord>()));
    }

    public void removeSong(Song song) {

    }

    public ArrayList<Song> getSongs(String keyword) {
        return songs;
    }

    public void saveSongList() {

    }
}