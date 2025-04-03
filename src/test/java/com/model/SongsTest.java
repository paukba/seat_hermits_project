package com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Testing file for songs
 * @author Benjamin Paukovitz
 */

public class SongsTest {
    
    @Test
    public void testTesting(){
        assertTrue(true);
    }

    @Test
    public void testValidSong() {
        SongList songList = SongList.getInstance();
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
    
        Song song = new Song(songID, "Test Song", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 60.0, new ArrayList<>());
        
        songList.addSong(song);
        Song retrievedSong = songList.getSong(songID);

        assertTrue(retrievedSong != null);
        assertEquals("Test Song", retrievedSong.getTitle());
        assertEquals(60.0, retrievedSong.getTempo(), 0.01);
        assertFalse(retrievedSong.isPrivate());
        assertEquals(Genre.POP, retrievedSong.getGenre());
    }

    @Test
    public void testInvalidSong() {
        SongList songList = SongList.getInstance();
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();

        Song song = new Song(songID, "", new ArrayList<>(), authorID, false, null, new ArrayList<>(), -1, new ArrayList<>());
        
        songList.addSong(song);
        Song retrievedSong = songList.getSong(songID);

        assertTrue(retrievedSong != null);
        assertEquals("", retrievedSong.getTitle());
        assertTrue(retrievedSong.getGenre() == null);
        assertTrue(retrievedSong.getTempo() < 0);

        songList.removeSong(song);
    }

    @Test
    public void testDuplicateValidSong() {
        SongList songList = SongList.getInstance();
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();

        Song song1 = new Song(songID, "Duplicate Song", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 75.0, new ArrayList<>());
        Song song2 = new Song(songID, "Duplicate Song", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 75.0, new ArrayList<>());
        
        songList.addSong(song1);
        songList.addSong(song2);
        Song retrievedSong1 = songList.getSong(songID);
        Song retrievedSong2 = songList.getSong(songID);

        assertEquals(retrievedSong1.getId(), retrievedSong2.getId());
        assertEquals(retrievedSong1.getTitle(), retrievedSong2.getTitle());
    }

    @Test
    public void testValidSongEdit() {
        SongList songList = SongList.getInstance();
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();

        Song song = new Song(songID, "Old Title", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 100.0, new ArrayList<>());
        
        songList.addSong(song);
        Song retrievedSong = songList.getSong(songID);

        retrievedSong.setTitle("New Title");

        assertEquals("New Title", retrievedSong.getTitle());
    }
    
    @Test
    public void testInvalidSongEdit() {
        SongList songList = SongList.getInstance();
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();

        Song song = new Song(songID, "Original Title", new ArrayList<>(), authorID, false, Genre.MET, new ArrayList<>(), 80.0, new ArrayList<>());
        
        songList.addSong(song);

        Song retrievedSong = songList.getSong(songID);

        retrievedSong.setTitle(null);
        
        assertTrue(retrievedSong.getTitle() == null);
    }

    @Test
    public void testSavingSongs() {
        SongList songList = SongList.getInstance();
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
        Song newSong = new Song(songID, "Saved Song", new ArrayList<>(), authorID, false, Genre.NEW, new ArrayList<>(), 50.0, new ArrayList<>());
        
        songList.addSong(newSong);
        songList.saveSongList();

        Song retrievedSong = songList.getSong(songID);
        assertTrue(retrievedSong != null);
        assertEquals("Saved Song", retrievedSong.getTitle());
    }
}
