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
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        // Copy all the json's pre-existing objects
        for(int i = 0; i < users.size(); i++){
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        // Write everything + new stuff back to the json
        if (isJUnitTest()) {
            try(FileWriter file = new FileWriter(USER_FILE_NAME_JUNIT)){
                file.write(jsonUsers.toJSONString());
                file.flush();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else {
            try(FileWriter file = new FileWriter(USER_FILE_NAME)){
                file.write(jsonUsers.toJSONString());
                file.flush();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // json stuff definition
    public static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject(); // Make new json object

        // Populate the object with all info extracted from the json
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_IS_AUTHOR, user.getIsAuthor());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        JSONArray favSongsJSON = new JSONArray();
        for (int i = 0; i < user.getFavoriteSongs().size(); i++) {
            favSongsJSON.add(user.getFavoriteSongs().get(i));
        }
        userDetails.put(USER_FAV_SONGS, favSongsJSON);
        
        //if(user.getIsAuthor())
        //    userDetails.put(USER_MY_SONGS, user.getMySongs());

        return userDetails; // Give it back
    }

    
    public static void saveSongs(){
        
        // Variables
        //Put this back in qhen dataLoader is done
        SongList songList = SongList.getInstance();
        ArrayList<Song> songs = songList.getSongs();
        JSONArray jsonSongs = new JSONArray();

        //Everything should follow the same format as the user one

        for(int i = 0; i < songs.size(); i++){
            jsonSongs.add(getSongJSON(songs.get(i)));
        }

        if (isJUnitTest()) {
            try(FileWriter file = new FileWriter(SONG_FILE_NAME_JUNIT)){ // Write everything + new stuff back to the json
                file.write(jsonSongs.toJSONString());
                file.flush();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else {
            try(FileWriter file = new FileWriter(SONG_FILE_NAME)){ // Write everything + new stuff back to the json
                file.write(jsonSongs.toJSONString());
                file.flush();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // json stuff definition
    public static JSONObject getSongJSON(Song song){
        JSONObject songDetails = new JSONObject(); // Make new json object

        // Populate the object with all info extracted from the json
        songDetails.put(SONG_FILE_NAME, song.getSongFileName());
        songDetails.put(SONG_ID, song.getId().toString());
        songDetails.put(SONG_TITLE, song.getTitle());
        JSONArray jsonMeasures = new JSONArray();
        for (int i = 0; i < song.getMeasures().size(); i++) {
            jsonMeasures.add(getMeasureJSON(song.getMeasures().get(i)));
        }
        songDetails.put(SONG_MEASURES, jsonMeasures);
        songDetails.put(SONG_AUTHOR_ID, song.getAuthorId().toString());
        songDetails.put(SONG_PRIVACY, song.isPrivate());
        songDetails.put(SONG_GENRE, song.getGenre().label);
        songDetails.put(SONG_INSTRUMENTS, song.getInstruments());
        songDetails.put(SONG_TEMPO, song.getTempo());
        JSONArray jsonComments = new JSONArray();
        // for (int i = 0; i < song.getComments().size(); i++){
        //     JSONObject commentDetails = new JSONObject();
        //     commentDetails.put("", song.getComments().get(i));
        //     jsonComments.add(commentDetails);
        // }
        songDetails.put(SONG_COMMENTS,song.getComments());
        
        return songDetails; // Give it back

    }

    public static JSONObject getMeasureJSON(Measure measure) {
        JSONObject measureDetails = new JSONObject();
        int index = 0;

        
        measureDetails.put(MEASURE_NUM, index);
        measureDetails.put(MEASURE_LYRIC, measure.getMeasureLyric());
        JSONArray temp = new JSONArray();
        temp.add(measure.getMeasureChord().toString());
        measureDetails.put(MEASURE_CHORD, temp);
        measureDetails.put(MEASURE_STRINGS, measure.getMeasureStrings());
        JSONArray jsonSheets = new JSONArray();
        for (int i = 0; i < measure.getMeasureSheet().size(); i++) {
            jsonSheets.add(getSheetJSON(measure.getMeasureSheet().get(i)));
        }
        measureDetails.put(MEASURE_SHEETS, jsonSheets);
        JSONArray jsonTabs = new JSONArray();
        for (int i = 0; i < measure.getMeasureTab().size(); i++) {
            jsonTabs.add(getTabJSON(measure.getMeasureTab().get(i)));
        }
        measureDetails.put(MEASURE_TABS, jsonTabs);
        index++;

        return measureDetails;
    }

    public static JSONObject getSheetJSON(Sheet sheets) {
        JSONObject sheetDetails = new JSONObject();

        
        sheetDetails.put(SHEET_INSTRUMENT, sheets.getSheetInstrument().toString());
        JSONArray jsonNotes = new JSONArray();
        for (int i = 0; i < sheets.getSheetNotes().size(); i++) {
            jsonNotes.add(getNotesJSON(sheets.getSheetNotes().get(i)));
        }
        sheetDetails.put(SHEET_NOTES, jsonNotes);

        return sheetDetails;
    }

    public static JSONObject getNotesJSON(Note notes) {
        JSONObject noteDetails = new JSONObject();
        int noteNum = 1;

        noteDetails.put(NOTE_NUM, noteNum);
        noteDetails.put(NOTE_NAME, notes.getNoteName());
        noteDetails.put(NOTE_PITCH, notes.getNotePitch());
        noteDetails.put(NOTE_DURATION, notes.getDuration());
        noteDetails.put(NOTE_START_TIME, notes.getStartTime());
        noteNum++;

        return noteDetails;
    }

    public static JSONObject getTabJSON(Tab tabs) {
        JSONObject tabDetails = new JSONObject();

        
        tabDetails.put(TAB_INSTRUMENT, tabs.getTabInstrument().toString());
        JSONArray jsonTabNotes = new JSONArray();
        for (int i = 0; i < tabs.getTabNotes().size(); i++) {
            jsonTabNotes.add(tabs.getTabNotes().get(i));
        }
        tabDetails.put("tabnote", jsonTabNotes);

        return tabDetails;
    }

    public static JSONObject getTabNoteJSON(TabNote tabNotes) {
        JSONObject tabNoteDetails = new JSONObject();
        int tabNoteNum = 1;

        tabNoteDetails.put(TABNOTE_NUM, tabNoteNum);
        tabNoteDetails.put(TABNOTE_STRING, tabNotes.getTabnoteString());
        tabNoteDetails.put(TABNOTE_FRET, tabNotes.getTabnoteFret());
        tabNoteDetails.put(TABNOTE_NOTE, tabNotes.getTabnoteNote());
        tabNoteNum++;

        return tabNoteDetails;
    }
}
