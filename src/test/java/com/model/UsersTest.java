package com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Assert;
import com.model.*;


/**
 * @author Cooper Murphy
 */
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
    @Test
    public void testValidLogin(){
        UserList userList = UserList.getInstance();
        userList.login("mickyG", "mikeizcool");
        String firstName = userList.getUser("mickyG").getFirstName().toLowerCase();

        assertEquals("mike", firstName);
    }

    @Test
    public void testInValidLogin(){
        UserList userList = UserList.getInstance();
        User mike = userList.login("mickyGOAT", "mikeizcool");
        boolean success = mike.getUserName().equals("mickyG");
        assertFalse(success);
    }

    @Test 
    public void testAddValidUser() {
        UserList userList = UserList.getInstance();
        userList.createAccount("robert", "wattson","robWatts", "robbyw@gmail.com", "wattagecottage", true);
        //userList.logout();
        userList = UserList.getInstance();
        userList.login("robWatts", "wattagecottage");
        String lastName = userList.getUser("robWatts").getLastName().toLowerCase();
        assertEquals("wattson", lastName);
    }

    @Test 
    public void testDuplicateValidUser() {
        UserList userList = UserList.getInstance();
        boolean success = userList.createAccount("robowski", "wattson","robWatts", "robbyw@gmail.com", "wattagecottage", true);
        assertFalse(success);
    }
}