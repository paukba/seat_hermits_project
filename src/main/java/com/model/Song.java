package com.model;

import java.util.UUID;
import java.util.ArrayList;

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
    
    public String getSongFileName(){
        return this.songFileName;
    }

    public UUID getId(){
        return this.id;
    }
    
    public String getTitle() {
        return title;
    }

    public ArrayList<Measure> getMeasures(){
        return this.measures;
    }

    

    public ArrayList<Sheet> getSheets(Instrument instrument) {
        return sheets;
    }

    public ArrayList<Tab> getTabs(Instrument instrument) {
        return tabs;
    }

    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    public Genre getGenre() {
        return genre;
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public boolean isPrivate() {
        return privacy;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSheets(ArrayList<Sheet> sheets) {
        this.sheets = sheets;
    }

    public void setTabs(ArrayList<Tab> tabs) {
        this.tabs = tabs;
    }

    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public void playSong(Song song) {

    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void removeComment(String comment) {
        comments.remove(comment);
    }

}
