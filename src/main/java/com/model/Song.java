package com.model;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Represents a song, which consists of a title, author, genre, tempo, 
 * measures, and notation formats (can also include sheet music, tabs, and lyrics)
 */

public class Song {
    private String songFileName;
    public UUID id;
    private ArrayList<Tab> music;
    private String title;
    private Author author;
    private UUID authorID;
    private boolean privacy;
    private Genre genre;
    private double tempo;
    private ArrayList<String> lyrics;
    private ArrayList<Instrument> instruments;
    private ArrayList<Measure> measures;
    private ArrayList<NotationFormat> notations;
    private ArrayList<Sheet> sheets;
    private ArrayList<Tab> tabs;
    private ArrayList<String> comments;

    /**
     * Constructs a song with its information
     * @param id the UUID of the song
     * @param title the title of the song
     * @param measures the list of measures for the song
     * @param authorID the UUID of the song's author
     * @param privacy the privacy of the song (public or private)
     * @param genre the genre of the song
     * @param instruments the list of instruments in the song
     * @param tempo the tempo of the song
     * @param comments the list of comments on the song
     */
    public Song(UUID id, String title, ArrayList<Measure> measures, UUID authorID, Boolean privacy, Genre genre, ArrayList<Instrument> instruments, double tempo, ArrayList<String> comments) {
        this.id = id;
        this.title = title;
        this.measures = measures;
        this.authorID = authorID;
        this.privacy = privacy;
        this.genre = genre;
        this.instruments = instruments;
        this.tempo = tempo;
        this.comments = comments;
        
    }
    
    /**
     * Gets the file name of a song
     * @return the song's file name
     */
    public String getSongFileName(){
        return this.songFileName;
    }

    /**
     * Gets the unique ID of a song
     * @return the UUID of the song
     */
    public UUID getId(){
        return this.id;
    }
    
    /**
     * Gets the title of a song
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the measures for a song
     * @return the list of measures in the song
     */
    public ArrayList<Measure> getMeasures(){
        return this.measures;
    }

    /**
     * Gets the sheet music for an instrument
     * @param instrument the chosen instrument
     * @return the list of sheets for the chosen instrument
     */
    public ArrayList<Sheet> getSheets(Instrument instrument) {
        return sheets;
    }

    /**
     * Gets the tablature for a song
     * @param instrument the chosen instrument
     * @return the list of tabs for the chosen instrument
     */
    public ArrayList<Tab> getTabs(Instrument instrument) {
        return tabs;
    }

    /**
     * Gets the lyrics for a song
     * @return the lyrics of the song
     */
    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    /**
     * Gets the genre of a song
     * @return the genre of the song
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Gets the instruments in a song
     * @return the instruments in the song
     */
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    /**
     * Checks if a song is private or not
     * @return true if the song is private, false if not
     */
    public boolean isPrivate() {
        return privacy;
    }

    /**
     * Sets the title of a song
     * @param title the chosen title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the sheet music for a song
     * @param sheets the chosen sheet music for the song
     */
    public void setSheets(ArrayList<Sheet> sheets) {
        this.sheets = sheets;
    }

    /**
     * Sets the tablature for a song
     * @param tabs the chosen tabs for the song
     */
    public void setTabs(ArrayList<Tab> tabs) {
        this.tabs = tabs;
    }

    /**
     * Sets the lyrics for a song
     * @param lyrics the chosen lyrics for the song
     */
    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * Sets the genre of a song
     * @param genre the chosen genre of the song
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Sets the privacy of a song
     * @param privacy the chosen privacy of the song
     */
    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    /**
     * Plays a song
     * @param song the chosen song
     */
    public void playSong(Song song) {

    }

    /**
     * Adds a comment to a song
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

    /**
     * Gets the unique ID of the author of a song
     * @return the UUID of the author
     */
    public UUID getAuthorId() {
        return id;
    }

    /**
     * Gets the tempo of a song
     * @return the tempo of the song
     */
    public double getTempo() {
        return tempo;
    }

    /**
     * Gets the list of comments for a song
     * @return the list of comments
     */
    public ArrayList<String> getComments() {
        return comments;
    }

}
