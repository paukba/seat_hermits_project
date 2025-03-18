package com.model;

import java.util.UUID;
import java.util.ArrayList;

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

    public Song(String title, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, Boolean privacy, Instrument instrument) {
        this.title = title;
        this.music = new ArrayList<>();
        this.lyrics = new ArrayList<>();
        this.genre = genre;
        this.privacy = privacy;
        instruments = new ArrayList<>();
        instruments.add(instrument);
        
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
