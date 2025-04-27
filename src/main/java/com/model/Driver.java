package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class Driver {
    public static void main(String[] args) {
        //scenario1();

        playSong();

        //login();

        //createAccount();

        //scenario65536();

        //scenario128();

    }

    public static void playSong() {
        SongList songList = SongList.getInstance();
        Song song = songList.getSong(UUID.fromString("47da9c99-abd8-4a92-a43e-df4d28b8495b"));
        ArrayList<Measure> measures = song.getMeasures();
        Iterator<Measure> measureIterator = measures.iterator();
        while (measureIterator.hasNext()) {
            Measure measure = measureIterator.next();
            measure.playNotes();
        }
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

        System.out.println("--------------------------------------------------------");

        // login wrong
        User wrongLogin = userList.login("iamSpider", "spidermanroolz");

        if (wrongLogin != null) {
            System.out.println(wrongLogin.getId() + ": " + wrongLogin.getFirstName() + " " + wrongLogin.getLastName());
        } else {
            System.out.println("Failed to login");
        }
    }

    // public static void createAccount() {
        

    //     // create account correct
    //     userList.createAccount("mark", "fish", "BUMBUM", "markfish@gmail.com", "markizcool", false);
    //     userList.saveUserList();
    //     User newuser = userList.getUser("BUMBUM");
    //     System.out.println(newuser.getId() + ": " + newuser.getFirstName() + " " + newuser.getLastName());

    //     System.out.println("--------------------------------------------------------");

    //     // create account wrong
        
    // }

    public static void scenario1() {
        UserList userList = UserList.getInstance();

        // username already in use
        userList.createAccount("mike", "terrance", "mickyG", "mikey@bethesda.com", "mikeizcool", false);

        // username changed
        userList.createAccount("mike", "terrance", "mike111", "mikey@bethesda.com", "mikeizcool", false);
        userList.saveUserList();

        // login
        User correctLogin = userList.login("mike111", "mikeizcool");

        if (correctLogin != null) {
            System.out.println(correctLogin.getId() + ": " + correctLogin.getFirstName() + " " + correctLogin.getLastName());
        } else {
            System.out.println("Failed to login");
        }


    }

    public static void scenario128() {

        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();
        
        userList.createAccount("Candace", "Rodriguez", "Bearted64", "CandaceJRodriguez@armyspy.com", "", false);
        DataWriter.saveUsers();

        //songList.addSong(new Song(UUID.randomUUID(), "Cool Song Name", new ArrayList<Measure>(), UUID.randomUUID(), true, Genre.MET.label, new ArrayList<Instrument>(), 54.3, new ArrayList<String>()));
        ArrayList<Measure> testMeasures = new ArrayList<Measure>();
        ArrayList<Note> testNotes = new ArrayList<Note>();
        testNotes.add(new Note("Sample Note Name", 34.2, 5.6, 7.2));
        ArrayList<Chord> testChords = new ArrayList<Chord>();
        ArrayList<Sheet> testsSheets = new ArrayList<Sheet>();
        testsSheets.add(new Sheet(testNotes, new ElectricGuitar("Sick Guitar", new ArrayList<String>())));
        ArrayList<Tab> testTabs = new ArrayList<Tab>();
        testMeasures.add(new Measure(testNotes, new Chord("em", testNotes), "Sample lyric", testsSheets, testTabs));

        ArrayList<String> testComments = new ArrayList<String>();
        testComments.add("Sample Comment");
        
        songList.addSong(new Song(UUID.randomUUID(), "I don't know what to call this", testMeasures, UUID.randomUUID(), true, Genre.ROC, null, 0, testComments));
        DataWriter.saveSongs();

        scenario65536(); // Import everything from the first time

    }

    public static void scenario65536() {
        
        UserList userList = UserList.getInstance();
        SongList songList = SongList.getInstance();

        userList.createAccount("Candace", "Rodriguez", "Bearted64", "CandaceJRodriguez@armyspy.com", "", false);
        DataWriter.saveUsers();

        ArrayList<Measure> testMeasures = new ArrayList<Measure>();
        ArrayList<Note> testNotes = new ArrayList<Note>();
        testNotes.add(new Note("Another Note", 17.4, 3.5, 6.9));
        ArrayList<Chord> testChords = new ArrayList<Chord>();
        ArrayList<Sheet> testsSheets = new ArrayList<Sheet>();
        testsSheets.add(new Sheet(testNotes, new ElectricGuitar("Less cool but still pretty good Guitar", new ArrayList<String>())));
        ArrayList<Tab> testTabs = new ArrayList<Tab>();
        TabNote testTabNote = new TabNote(null, null, 0);
        
        testMeasures.add(new Measure(testNotes, new Chord("A", testNotes), "Another Sample lyric", testsSheets, testTabs));

        ArrayList<String> testComments = new ArrayList<String>();
        testComments.add("Pretty neat ;)");

        ArrayList<Instrument> testInstruments = new ArrayList<Instrument>();
        testInstruments.add(new ElectricGuitar("guitar name", null));
        
        songList.addSong(new Song(UUID.randomUUID(), "title title title", testMeasures, UUID.randomUUID(), true, Genre.MET, testInstruments, 0, testComments));
        DataWriter.saveSongs();

    }
}
