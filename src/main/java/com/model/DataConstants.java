package com.model;

/**
 * Defines constant values used for data storage and retrieval
 */

public abstract class DataConstants {
    protected static final String USER_FILE_NAME = "json/users.json";
    protected static final String USER_FILE_NAME_JUNIT = "src/test/json/users.json";
    protected static final String USER_ID = "id";
    protected static final String USER_IS_AUTHOR = "isAuthor";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_USER_NAME = "userName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_FAV_SONGS = "favsongs-id";
    protected static final String USER_MY_SONGS = "mysongs-id";

    protected static final String INSTRUMENT_FILE_NAME = "json/instrument.json";
    protected static final String INSTRUMENT_FILE_NAME_JUNIT = "src/test/json/instrument.json";
    protected static final String INSTRUMENT_NAME = "name";
    protected static final String INSTRUMENT_HAS_STRINGS = "hasstrings";
    protected static final String INSTRUMENT_NUM_STRINGS = "numstrings";
    protected static final String INSTRUMENT_STRINGS = "strings";

    protected static final String SONG_FILE_NAME = "json/songs.json";
    protected static final String SONG_FILE_NAME_JUNIT = "src/test/json/songs.json";
    protected static final String SONG_ID = "uuid";
    protected static final String SONG_TITLE = "title";
    protected static final String SONG_MEASURES = "measures";
    protected static final String MEASURE_NUM = "measure";
    protected static final String MEASURE_LYRIC = "lyric";
    protected static final String MEASURE_CHORD = "chord";
    protected static final String MEASURE_STRINGS = "strings";
    protected static final String MEASURE_SHEETS = "sheets";
    protected static final String SHEET_INSTRUMENT = "instrument";
    protected static final String SHEET_NOTES = "notes";
    protected static final String NOTE_NUM = "note";
    protected static final String NOTE_NAME = "name";
    protected static final String NOTE_PITCH = "pitch";
    protected static final String NOTE_DURATION = "duration";
    protected static final String NOTE_START_TIME = "starttime";
    protected static final String MEASURE_TABS = "tabs";
    protected static final String TAB_INSTRUMENT = "instrument";
    protected static final String TABNOTE_NUM = "tabnote";
    protected static final String TABNOTE_STRING = "string";
    protected static final String TABNOTE_FRET = "frett";
    protected static final String TABNOTE_NOTE = "note";
    protected static final String SONG_AUTHOR_ID = "author-id";
    protected static final String SONG_PRIVACY = "privacy";
    protected static final String SONG_GENRE = "genre";
    protected static final String SONG_INSTRUMENTS = "instruments";
    protected static final String SONG_TEMPO = "tempo";
    protected static final String SONG_COMMENTS = "comments";


    public static boolean isJUnitTest() {  
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
		  if (element.getClassName().startsWith("org.junit.")) {
			return true;
		  }           
		}
		return false;
	  }
}
