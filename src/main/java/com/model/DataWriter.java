package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.UUID;

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
        
        //ArrayList<User> users = new ArrayList<User>(); // This is for testing; Delete later
        //ArrayList<UUID> tempFavSongs = new ArrayList<UUID>();
        //users.add(new User(UUID.randomUUID(), "First2", "Last2", "name2@email.sc.edu", "testName2", "verystrongpassword", tempFavSongs, false)); // This is for testing; Delete later
        //UUID id, String firstName, String lastName, String email, String userName, String password, ArrayList<UUID> favoriteSongs, boolean isAuthor
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
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_FAV_SONGS, user.getFavoriteSongs());
        //if(user.getIsAuthor())
        //    userDetails.put(USER_MY_SONGS, user.getMySongs());

        return userDetails; // Give it back
    }

    
    public static void saveSongs(){
        
        // Variables
        //Put this back in qhen dataLoader is done
        SongList songList = SongList.getInstance();
        ArrayList<Song> songs = DataLoader.getSongs();
        
        
        //ArrayList<Song> songs = new ArrayList<Song>();
        /*
        ArrayList<Measure> testMeasures = new ArrayList<Measure>();
        ArrayList<Note> testNotes = new ArrayList<Note>();
        testNotes.add(new Note("Sample Note Name", 34.2, 5.6, 7.2));
        ArrayList<Chord> testChords = new ArrayList<Chord>();
        ArrayList<Sheet> testsSheets = new ArrayList<Sheet>();
        testsSheets.add(new Sheet(testNotes));
        ArrayList<Tab> testTabs = new ArrayList<Tab>();
        testMeasures.add(new Measure(testNotes, testChords, "Sample lyric", 0.34, testsSheets, testTabs));

        ArrayList<String> testComments = new ArrayList<String>();
        testComments.add("Sample Comment");
        
        songs.add(new Song(UUID.randomUUID(), "I don't know what to call this", testMeasures, UUID.randomUUID(), true, Genre.ROC, null, 0, testComments));
        */
        JSONArray jsonSongs = new JSONArray();

        //Everything should follow the same format as the user one

        for(int i = 0; i < songs.size(); i++){
            jsonSongs.add(getSongJSON(songs.get(i)));
        }

        try(FileWriter file = new FileWriter(SONG_FILE_NAME)){ // Write everything + new stuff back to the json
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
        songDetails.put(SONG_FILE_NAME, song.getSongFileName());
        songDetails.put(SONG_ID, song.getId().toString());
        songDetails.put(SONG_TITLE, song.getTitle());
        songDetails.put(SONG_MEASURES, getMeasureJSON(song.getMeasures()));
        songDetails.put(SONG_AUTHOR_ID, song.getAuthorId().toString());
        songDetails.put(SONG_PRIVACY, song.isPrivate());
        songDetails.put(SONG_GENRE, song.getGenre().label);
        songDetails.put(SONG_INSTRUMENTS, song.getInstruments());
        songDetails.put(SONG_TEMPO, song.getTempo());
        songDetails.put(SONG_COMMENTS, song.getComments());
        
        return songDetails; // Give it back

    }

    public static JSONObject getMeasureJSON(ArrayList<Measure> measures) {
        JSONObject measureDetails = new JSONObject();
        int index = 0;

        for (Measure i : measures) {
            measureDetails.put(MEASURE_NUM, index);
            measureDetails.put(MEASURE_LYRIC, i.getMeasureLyric());
            measureDetails.put(MEASURE_CHORD, i.getMeasureChord());
            measureDetails.put(MEASURE_STRINGS, i.getMeasureStrings());
            measureDetails.put(MEASURE_SHEET, getSheetJSON(i.getMeasureSheet()));
            measureDetails.put(MEASURE_TAB, getTabJSON(i.getMeasureTab()));
            index++;
        }

        return measureDetails;
    }

    public static JSONObject getSheetJSON(ArrayList<Sheet> sheets) {
        JSONObject sheetDetails = new JSONObject();

        for (Sheet j : sheets) {
            sheetDetails.put(SHEET_INSTRUMENT, j.getSheetInstrument());
            sheetDetails.put(SHEET_NOTES, getNotesJSON(j.getSheetNotes()));
        }

        return sheetDetails;
    }

    public static JSONObject getNotesJSON(ArrayList<Note> notes) {
        JSONObject noteDetails = new JSONObject();
        int noteNum = 1;

        for (Note k : notes) {
            noteDetails.put(NOTE_NUM, noteNum);
            noteDetails.put(NOTE_NAME, k.getNoteName());
            noteDetails.put(NOTE_PITCH, k.getNotePitch());
            noteDetails.put(NOTE_DURATION, k.getDuration());
            noteDetails.put(NOTE_START_TIME, k.getStartTime());
            noteNum++;
        }

        return noteDetails;
    }

    public static JSONObject getTabJSON(ArrayList<Tab> tabs) {
        JSONObject tabDetails = new JSONObject();

        for (Tab j : tabs) {
            tabDetails.put(TAB_INSTRUMENT, j.getTabInstrument());
            tabDetails.put("tabnote", getTabNoteJSON(j.getTabNotes()));
        }

        return tabDetails;
    }

    public static JSONObject getTabNoteJSON(ArrayList<TabNote> tabNotes) {
        JSONObject tabNoteDetails = new JSONObject();
        int tabNoteNum = 1;

        for (TabNote k : tabNotes) {
            tabNoteDetails.put(TABNOTE_NUM, tabNoteNum);
            tabNoteDetails.put(TABNOTE_STRING, k.getTabnoteString());
            tabNoteDetails.put(TABNOTE_FRET, k.getTabnoteFret());
            tabNoteDetails.put(TABNOTE_NOTE, k.getTabnoteNote());
            tabNoteNum++;
        }

        return tabNoteDetails;
    }

    // Stuff for testing
    /*
    public static void main(String[] args){
        //DataWriter.saveUsers();
        DataWriter.saveSongs();
    }
    */
}
