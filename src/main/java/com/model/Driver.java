package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class Driver {
    public static void main(String[] args) {
        //playSong();

        //login();

        createAccount();

    }

    public static void playSong() {
        SongList songList = SongList.getInstance();
        Song song = songList.getSong(UUID.fromString("df1deded-83af-45f9-979f-e25e52734088"));
        ArrayList<Measure> measures = song.getMeasures();
        Iterator<Measure> measureIterator = measures.iterator();
        Measure measure = measureIterator.next();
        measure.playNotes();
    }

    public static void login() {
        UserList userList = UserList.getInstance();
        
        // login correct
        User correctLogin = userList.login("iamSpider99", "spiderman2099roolz");

        if (correctLogin != null) {
            System.out.println(correctLogin.getId() + ": " + correctLogin.getFirstName() + " " + correctLogin.getLastName());
        } else {
            System.out.println("Failed to login");
        }

        // login wrong
        User wrongLogin = userList.login("iamSpider", "spidermanroolz");

        if (wrongLogin != null) {
            System.out.println(wrongLogin.getId() + ": " + wrongLogin.getFirstName() + " " + wrongLogin.getLastName());
        } else {
            System.out.println("Failed to login");
        }
    }

    public static void createAccount() {
        UserList userList = UserList.getInstance();

        // create account correct
        userList.createAccount("mark", "fish", "BUMBUM", "markfish@gmail.com", "markizcool", false);
        userList.saveUserList();
        User newuser = userList.getUser("BUMBUM");
        System.out.println(newuser.getId() + ": " + newuser.getFirstName() + " " + newuser.getLastName());
    }
}
