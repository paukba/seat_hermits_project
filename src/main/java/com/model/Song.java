package com.model;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Class for a song
 */

public class Song {
    private String songFileName;
    public UUID id;
    private ArrayList<Tab> music;
    private String title;
    private Author author;
    private boolean privacy;
    private Genre genre;
    private ArrayList<String> lyrics;
    private ArrayList<Instrument> instruments;
    private ArrayList<Measure> measures;
    private ArrayList<NotationFormat> notations;
    private ArrayList<Sheet> sheets;
    private ArrayList<Tab> tabs;
    private ArrayList<String> comments;

    /**
     * Constructs a song
     * @param title the song's title
     * @param music the song's music
     * @param lyrics the song's lyrics
     * @param genre the song's genre
     * @param privacy the song's privacy
     * @param instrument the chosen instrument
     */
    public Song(String title, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, Boolean privacy, Instrument instrument) {
        this.title = title;
        this.music = new ArrayList<>();
        this.lyrics = new ArrayList<>();
        this.genre = genre;
        this.privacy = privacy;
        instruments = new ArrayList<>();
        instruments.add(instrument);
        
    }
    
    /**
     * Gets the file name for the song
     * @return the song file name
     */
    public String getSongFileName(){
        return this.songFileName;
    }

    /**
     * Gets the ID of the song
     * @return the song's ID
     */
    public UUID getId(){
        return this.id;
    }
    
    /**
     * Gets the title of the song
     * @return the song's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the measures for the song
     * @return the song's measures
     */
    public ArrayList<Measure> getMeasures(){
        return this.measures;
    }

    /**
     * Gets the sheets for the song
     * @param instrument the chosen instrument
     * @return the song's sheets
     */
    public ArrayList<Sheet> getSheets(Instrument instrument) {
        return sheets;
    }

    /**
     * Gets the tabs for the song
     * @param instrument the chosen instrument
     * @return the song's tabs
     */
    public ArrayList<Tab> getTabs(Instrument instrument) {
        return tabs;
    }

    /**
     * Gets the lyrics for the song
     * @return the song's lyrics
     */
    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    /**
     * Gets the genre of the song
     * @return the song's genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Gets the instruments in the song ?
     * @return the song's instruments
     */
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    /**
     * Tells if the song is private or not
     * @return true if song is private, false if not
     */
    public boolean isPrivate() {
        return privacy;
    }

    /**
     * Sets the title of the song
     * @param title the chosen title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the sheets for the song
     * @param sheets the chosen sheets
     */
    public void setSheets(ArrayList<Sheet> sheets) {
        this.sheets = sheets;
    }

    /**
     * Sets the tabs for the song
     * @param tabs the chosen tabs
     */
    public void setTabs(ArrayList<Tab> tabs) {
        this.tabs = tabs;
    }

    /**
     * Sets the lyrics for the song
     * @param lyrics the chosen lyrics
     */
    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * Sets the genre of the song
     * @param genre the chosen genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Sets the privacy of the song
     * @param privacy the chosen privacy
     */
    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    /**
     * Plays the song
     * @param song the chosen song
     */
    public void playSong(Song song) {

    }

    /**
     * Adds a comment to the song
     * @param comment the comment being added
     */
    public void addComment(String comment) {
        comments.add(comment);
    }

    /**
     * Removes a comment from the song
     * @param comment the comment being removed
     */
    public void removeComment(String comment) {
        comments.remove(comment);
    }

}
