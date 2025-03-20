package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class SongList {
    private static SongList songList;
    private ArrayList<Song> songs;

    private SongList() {
        songList = this;
        songs = new ArrayList<>();
    }

    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
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
    
    public ArrayList<Song> getSongs(String keyword) {
        return songs;
    }

    public void saveSongList() {
        
    }
}