package com.model;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class DataLoader extends DataConstants {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                boolean isAuthor = (boolean)userJSON.get(USER_IS_AUTHOR);
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String userName = (String)userJSON.get(USER_USER_NAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String password = (String)userJSON.get(USER_PASSWORD);
                JSONArray favSongsJSON = (JSONArray)userJSON.get(USER_FAV_SONGS);
                ArrayList<UUID> favSongIDs = new ArrayList<UUID>();
                for (int j = 0; j < favSongsJSON.size(); j++) {
                    favSongIDs.add(UUID.fromString((String)favSongsJSON.get(j)));
                }

                if (isAuthor) {
                    JSONArray mySongsJSON = (JSONArray)userJSON.get(USER_MY_SONGS);
                    ArrayList<UUID> mySongIDs = new ArrayList<UUID>();
                    for (int j = 0; j < mySongsJSON.size(); j++) {
                        favSongIDs.add(UUID.fromString((String)mySongsJSON.get(j)));
                    }
                    Users.add(new Author(id, firstName, lastName, userName, email, password, favSongIDs, mySongIDs));
                }
                else {
                    Users.add(new User(id, firstName, lastName, userName, email, password, favSongIDs));
                }
            }
            return users;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Instrument> getInstruments() {
        ArrayList<Instrument> instruments = new ArrayList<Instrument>();

        try {
            FileReader reader = new FileReader(INSTRUMENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray instrumentsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < instrumentsJSON.size(); i++) {
                JSONObject instrumentJSON = (JSONObject)instrumentsJSON.get(i);
                String name = (String)instrumentJSON.get(INSTRUMENT_NAME);
                boolean hasStrings = (boolean)instrumentJSON.get(INSTRUMENT_HAS_STRINGS);

                if (hasStrings) {  
                    int numStrings = (int)instrumentJSON.get(INSTRUMENT_NUM_STRINGS);
                    JSONArray stringsJSON = (JSONArray)instrumentJSON.get(INSTRUMENT_STRINGS);
                    instruments.add(new ElectricGuitar(name, numStrings, strings));
                }
                else {
                    /*
                            This is where code to instantiate an instrument w/o strings would be if we had one
                    instruments.add(new Instrument(name, hasStrings));
                    */
                }
            }
            return instruments;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return instruments;
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray songsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < songsJSON.size(); i++) {
                JSONObject songJSON = (JSONObject)songsJSON.get(i);
                UUID id = UUID.fromString((String)songJSON.get(SONG_ID));
                String title = (String)songJSON.get(SONG_TITLE);
                JSONArray measuresJSON = (JSONArray)songJSON.get(SONG_MEASURES);
                ArrayList<Measure> measures = new ArrayList<Measure>();
                for (int j = 0; j < measuresJSON.size(); j++) {
                    JSONObject measureJSON = (JSONObject)measuresJSON.get(j);
                    int measureNum = (int)measureJSON.get(MEASURE_NUM);
                    String measureLyric = (String)measureJSON.get(MEASURE_LYRIC);
                    String measureChord = (String)measureJSON.get(MEASURE_CHORD);
                    JSONArray measureStringsJSON = (JSONArray)measureJSON.get(MEASURE_STRINGS);
                    ArrayList<String> strings = new ArrayList<String>();
                    for (int k = 0; k < measureStringsJSON.size(); k++) {
                        String string = (String)measureStringsJSON.get(k);
                        strings.add(string);
                    }
                    JSONObject sheetJSON = (JSONObject)measureJSON.get(MEASURE_SHEET);
                    String sheetInstrument = (String)sheetJSON.get(SHEET_INSTRUMENT);
                    JSONArray sheetNotesJSON = (JSONArray)sheetJSON.get(SHEET_NOTES);
                    ArrayList<Note> sheeNotes = new ArrayList<Note>();
                    for (int k = 0; k < sheetNotesJSON.size(); k++) {
                        JSONObject sheetNoteJSON = (JSONObject)sheetNotesJSON.get(k);
                        int noteNum = (int)sheetNoteJSON.get(NOTE_NUM);
                        String noteName = (String)sheetNoteJSON.get(NOTE_NAME);
                        double pitch = (double)sheetNoteJSON.get(NOTE_PITCH);
                        double duration = (double)sheetNoteJSON.get(NOTE_DURATION);
                        double startTime = (double)sheetNoteJSON.get(NOTE_START_TIME);
                        sheeNotes.add(new Note(noteName, pitch, duration, startTime));
                    }
                    JSONArray tabJSON = (JSONArray)measureJSON.get(MEASURE_TAB);
                    String tabInstrument = (String)tabJSON.get(0);
                    ArrayList<TabNote> tabNotes = new ArrayList<TabNote>();
                    for (int k = 0; k < tabJSON.size(); k++) {
                        JSONObject tabNoteJSON = (JSONObject)tabJSON.get(k+1);
                        int tabNoteNum = (int)tabNoteJSON.get(TABNOTE_NUM);
                        String tabNoteString = (String)tabNoteJSON.get(TABNOTE_STRING);
                        String tabNoteFret = (String)tabNoteJSON.get(TABNOTE_FRET);
                        int fretNum = Integer.parseInt(tabNoteFret);
                        JSONObject tabNoteNoteJSON = (JSONObject)tabNoteJSON.get(TABNOTE_NOTE);
                        String noteName = (String)tabNoteNoteJSON.get(NOTE_NAME);
                        double pitch = (double)tabNoteNoteJSON.get(NOTE_PITCH);
                        double duration = (double)tabNoteNoteJSON.get(NOTE_DURATION);
                        double startTime = (double)tabNoteNoteJSON.get(NOTE_START_TIME);
                        Note tabNoteNote = new Note(noteName, pitch, duration, startTime);
                        tabNotes.add(new TabNote(tabNoteNote, tabNoteString, fretNum));
                    }
                }
                UUID authorID = UUID.fromString((String)songJSON.get(SONG_AUTHOR_ID));
                boolean privacy = (boolean)songJSON.get(SONG_PRIVACY);
                Genre genre = (Genre)songJSON.get(SONG_GENRE);
                JSONArray instrumentsJSON = (JSONArray)songJSON.get(SONG_INSTRUMENTS);
                ArrayList<Instrument> instruments = new ArrayList<Instrument>();
                for (int j = 0; j < instrumentsJSON.size(); j++) {
                    instruments.add(getInstrument((String)instrumentsJSON.get(j)));
                }
                int tempo = (int)songJSON.get(SONG_TEMPO);
                JSONArray commentsJSON = (JSONArray)songJSON.get(SONG_COMMENTS);
                ArrayList<String> comments = new ArrayList<String>();
                for (int j = 0; j < commentsJSON.size(); j++) {
                    comments.add((String)commentsJSON.get(j));
                }
                songs.add(new Song(id, title, measures, authorID, privacy, genre, instruments, tempo, comments));
            }
            return songs;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }

    public static Instrument getInstrument(String name) {
        ArrayList<Instrument> instruments = getInstruments();
        Iterator<Instrument> instrumentIterator = instruments.iterator();
        while (instrumentIterator.hasNext()) {
            Instrument current = instrumentIterator.next();
            if (current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }
}
