package com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Assert;
import com.model.*;

public class UsersTest {
    @Test
    public void testTesting(){
        assertTrue(true);
    }

    @Test
    public void loadSong() {
        SongList songs = SongList.getInstance();
        Song song = songs.getSong(UUID.fromString("df1deded-83af-45f9-979f-e25e52734088"));
        boolean success = (song != null);
        assertTrue(success);
    }

    // @Test
    // public void testInValidLogin(){
    //     UserList library = UserList.getInstance();
    //     boolean success = library.login("bross");
    //     assertFalse(success);
    // }

    // @Test 
    // public void testAddValidUser() {
    //     UserList library = UserList.getInstance();
    //     library.createAccount("jmath", "John","Math", 15, "803-222-3333");
    //     library.logout();
    //     library = UserList.getInstance();
    //     library.login("jmath");
    //     String lastName = library.getCurrentUser().getLastName().toLowerCase();
    //     assertEquals("math", lastName);
    // }

    // @Test 
    // public void testDuplicateValidUser() {
    //     UserList library = UserList.getInstance();
    //     boolean success = library.createAccount("jmath", "Jannet","Math", 15, "803-222-3333");
    //     assertFalse(success);
    // }
}