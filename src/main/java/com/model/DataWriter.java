package com.model;

// Stuff to be included
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.xpath.operations.Variable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    // json files cannot be edited
    // Here we collect all objects from the file, do the new stuff, then completely override everything in the file
    public static void saveUsers(){

        // Variables
        /*
        Below is dependant on DataLoader so put this back when that's done
        */
        UserList userList = UserList.getInstance();
        ArrayList<User> users = DataLoader.getUsers();
        
        // ArrayList<User> users = new ArrayList<User>(); // This is for testing; Delete later
        // users.add(new User("First2", "Last2", "name2@email.sc.edu", "testName2")); // This is for testing; Delete later
        JSONArray jsonUsers = new JSONArray();

        // Copy all the json's pre-existing objects
        for(int i = 0; i < users.size(); i++){
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        // Write everything + new stuff back to the json
        try(FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUsers.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // json stuff definition
    public static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject(); // Make new json object

        // Populate the object with all info extracted from the json
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_TYPE, user.getIsAuthor());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_FAV_SONGS, user.getFavoriteSongs());
        userDetails.put(USER_MY_SONGS, user.getMySongs());

        return userDetails; // Give it back
    }

    /*
    To be implemented later
    */
    public static void saveSongs(){
        
        // Variables
        SongList songList = SongList.getInstance();
        ArrayList<Song> songs = DataLoader.getSongs();
        JSONArray jsonSongs = new JSONArray();

        //Everything should follow the same format as the user one

        for(int i = 0; i < songs.size(); i++){
            jsonSongs.add(getSongJSON(songs.get(i)));
        }

        try(FileWriter file = new FileWriter(USER_FILE_NAME)){ // Write everything + new stuff back to the json
            file.write(jsonSongs.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // json stuff definition
    public static JSONObject getSongJSON(Song song){
        JSONObject songDetails = new JSONObject(); // Make new json object

        // Populate the object with all info extracted from the json
        songDetails.put(SONG_FILE_NAME, song.getSongFileName().toString());
        songDetails.put(SONG_ID, song.getId().toString());
        songDetails.put(SONG_TITLE, song.getTitle().toString());
        songDetails.put(SONG_MEASURES, song.getMeasures().toString());
        songDetails.put(MEASURE_NUM, song.getMeasureNum().toString());
        songDetails.put(MEASURE_LYRIC, song.getMeasureLyric().toString());
        songDetails.put(MEASURE_CHORD, song.getMeasureChord().toString());
        songDetails.put(MEASURE_STRINGS, song.getMeasureStrings().toString());
        songDetails.put(MEASURE_SHEET, song.getMeasureSheet().toString());
        songDetails.put(SHEET_INSTRUMENT, song.getSheetInstrument().toString());
        songDetails.put(SHEET_NOTES, song.getSheetNotes().toString());
        songDetails.put(NOTE_NUM, song.getNoteNum().toString());
        songDetails.put(NOTE_NAME, song.getNoteName().toString());
        songDetails.put(NOTE_PITCH, song.getNotePitch().toString());
        songDetails.put(NOTE_DURATION, song.getNoteDuration().toString());
        songDetails.put(NOTE_START_TIME, song.getNoteStartTime().toString());
        songDetails.put(MEASURE_TAB, song.getMeasureTab().toString());
        songDetails.put(TAB_INSTRUMENT, song.getTabInstrument().toString());
        songDetails.put(TABNOTE_NUM, song.getTabNoteNum().toString());
        songDetails.put(TABNOTE_STRING, song.getTabnoteString().toString());
        songDetails.put(TABNOTE_FRET, song.getTabnoteFret().toString());
        songDetails.put(TABNOTE_NOTE, song.getTabnoteNote().toString());
        songDetails.put(SONG_AUTHOR_ID, song.getSongAuthorId().toString());
        songDetails.put(SONG_PRIVACY, song.getSongPrivacy().toString());
        songDetails.put(SONG_GENRE, song.getSongGenre().toString());
        songDetails.put(SONG_INSTRUMENTS, song.getSongInstruments().toString());
        songDetails.put(SONG_TEMPO, song.getSongTempo().toString());
        songDetails.put(SONG_COMMENTS, song.getSongComments().toString());
        
        return songDetails; // Give it back

    }

    // Stuff for testing
    /*
    public static void main(String[] args){
        DataWriter.saveUsers();
        DataWriter.saveSongs();
    }
    */
}
