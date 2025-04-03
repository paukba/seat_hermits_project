package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;

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
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
        Song song = new Song(songID, "Test Song", new ArrayList<>(), authorID, false, Genre.ROC, new ArrayList<>(), 60.0, new ArrayList<>());
        
        assertEquals("Test Song", song.getTitle());
        assertEquals(60.0, song.getTempo(), 0.01);
        assertFalse(song.isPrivate());
        assertEquals(Genre.ROC, song.getGenre());
    }

    @Test
    public void testInvalidSong() {
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
        Song song = new Song(songID, "", new ArrayList<>(), authorID, false, null, new ArrayList<>(), -1, new ArrayList<>());
        
        assertEquals("", song.getTitle());
        assertTrue(song.getGenre() == null);
        assertTrue(song.getTempo() < 0);
    }

    @Test
    public void testDuplicateValidSong() {
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
        Song song1 = new Song(songID, "Duplicate Song", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 75.0, new ArrayList<>());
        Song song2 = new Song(songID, "Duplicate Song", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 75.0, new ArrayList<>());
        
        assertEquals(song1.getId(), song2.getId());
        assertEquals(song1.getTitle(), song2.getTitle());
    }

    @Test
    public void testValidSongEdit() {
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
        Song song = new Song(songID, "Old Title", new ArrayList<>(), authorID, false, Genre.POP, new ArrayList<>(), 100.0, new ArrayList<>());
        
        song.setTitle("New Title");
        assertEquals("New Title", song.getTitle());
    }
    
    @Test
    public void testInvalidSongEdit() {
        UUID songID = UUID.randomUUID();
        UUID authorID = UUID.randomUUID();
        Song song = new Song(songID, "Original Title", new ArrayList<>(), authorID, false, Genre.MET, new ArrayList<>(), 80.0, new ArrayList<>());
        
        song.setTitle(null);
        assertTrue(song.getTitle() == null);
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
