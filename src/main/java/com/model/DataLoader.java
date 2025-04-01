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
                    users.add(new Author(id, firstName, lastName, userName, email, password, favSongIDs, mySongIDs));
                }
                else {
                    users.add(new User(id, firstName, lastName, userName, email, password, favSongIDs, false));
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
                    ArrayList<String> strings = new ArrayList<String>();
                    if (stringsJSON != null) {
                        for (int j = 0; j < stringsJSON.size(); j++) {
                            strings.add((String)stringsJSON.get(j));
                        }
                    }
                    instruments.add(new ElectricGuitar(name, strings));
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
            if (DataConstants.isJUnitTest()) {
                reader = new FileReader(SONG_FILE_NAME_JUNIT);
            }
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
                    int measureNum = (int)(long)measureJSON.get(MEASURE_NUM);
                    String measureLyric = (String)measureJSON.get(MEASURE_LYRIC);
                    JSONArray measureChordJSON = (JSONArray)measureJSON.get(MEASURE_CHORD);
                    ArrayList<Note> chordNotes = new ArrayList<Note>();
                    if (measureChordJSON != null) {
                        for (int k = 0; k < measureChordJSON.size(); k++) {
                            JSONObject sheetNoteJSON = (JSONObject)measureChordJSON.get(k);
                            int noteNum = (int)(long)sheetNoteJSON.get(NOTE_NUM);
                            String noteName = (String)sheetNoteJSON.get(NOTE_NAME);
                            double pitch = (double)sheetNoteJSON.get(NOTE_PITCH);
                            double duration = (double)sheetNoteJSON.get(NOTE_DURATION);
                            double startTime = (double)sheetNoteJSON.get(NOTE_START_TIME);
                            chordNotes.add(new Note(noteName, pitch, duration, startTime));
                        }
                    }
                    Chord chord = new Chord(null, chordNotes);
                    JSONArray measureStringsJSON = (JSONArray)measureJSON.get(MEASURE_STRINGS);
                    ArrayList<String> strings = new ArrayList<String>();
                    if (measureStringsJSON != null) {
                        for (int k = 0; k < measureStringsJSON.size(); k++) {
                            String string = (String)measureStringsJSON.get(k);
                            strings.add(string);
                        }
                    }
                    JSONArray sheetsJSON = (JSONArray)measureJSON.get(MEASURE_SHEETS);
                    ArrayList<Sheet> sheets = new ArrayList<Sheet>();
                    if (sheetsJSON != null) {
                        for (int k = 0; k < sheetsJSON.size(); k++) {
                            JSONObject sheetJSON = (JSONObject)sheetsJSON.get(k);
                            String sheetInstrumentName = (String)sheetJSON.get(SHEET_INSTRUMENT);
                            Instrument instrument = new ElectricGuitar(sheetInstrumentName, null); //default instrument type for now
                            JSONArray sheetNotesJSON = (JSONArray)sheetJSON.get(SHEET_NOTES);
                            ArrayList<Note> sheetNotes = new ArrayList<Note>();
                            if (sheetNotesJSON != null) {
                                for (int l = 0; l < sheetNotesJSON.size(); l++) {
                                    JSONObject sheetNoteJSON = (JSONObject)sheetNotesJSON.get(l);
                                    int noteNum = (int)(long)sheetNoteJSON.get(NOTE_NUM);
                                    String noteName = (String)sheetNoteJSON.get(NOTE_NAME);
                                    double pitch = (double)sheetNoteJSON.get(NOTE_PITCH);
                                    double duration = (double)sheetNoteJSON.get(NOTE_DURATION);
                                    double startTime = (double)sheetNoteJSON.get(NOTE_START_TIME);
                                    sheetNotes.add(new Note(noteName, pitch, duration, startTime));
                                }
                            }
                            sheets.add(new Sheet(sheetNotes, instrument));
                        }
                    }
                    JSONArray tabsJSON = (JSONArray)measureJSON.get(MEASURE_TABS);
                    ArrayList<Tab> tabs = new ArrayList<Tab>();
                    if (tabsJSON != null) {
                        for (int k = 0; k < tabsJSON.size(); k++) {
                            JSONObject tabJSON = (JSONObject)tabsJSON.get(k);
                            String tabInstrument = (String)tabJSON.get(0);
                            ArrayList<TabNote> tabNotes = new ArrayList<TabNote>();
                            if (tabJSON != null) {
                                for (int l = 0; l < tabJSON.size(); l++) {
                                    JSONObject tabNoteJSON = (JSONObject)tabJSON.get(l+1);
                                    int tabNoteNum = (int)(long)tabNoteJSON.get(TABNOTE_NUM);
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
                            tabs.add(new Tab(tabNotes));
                        }
                    }
                    
                    measures.add(new Measure(null, chord, measureLyric, sheets, tabs));
                }
                UUID authorID = UUID.fromString((String)songJSON.get(SONG_AUTHOR_ID));
                boolean privacy = (boolean)songJSON.get(SONG_PRIVACY);
                Genre genre = Genre.valueOf((String)songJSON.get(SONG_GENRE));
                JSONArray instrumentsJSON = (JSONArray)songJSON.get(SONG_INSTRUMENTS);
                ArrayList<Instrument> instruments = new ArrayList<Instrument>();
                if (instrumentsJSON != null) {
                    for (int j = 0; j < instrumentsJSON.size(); j++) {
                        instruments.add(getInstrument((String)instrumentsJSON.get(j)));
                    }
                }
                double tempo = (double)songJSON.get(SONG_TEMPO);
                JSONArray commentsJSON = (JSONArray)songJSON.get(SONG_COMMENTS);
                ArrayList<String> comments = new ArrayList<String>();
                if (commentsJSON != null) {
                    for (int j = 0; j < commentsJSON.size(); j++) {
                        comments.add((String)commentsJSON.get(j));
                    }
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
