package com.model;

import java.util.UUID;
import java.util.ArrayList;

public class Song {
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
        title = new String();
        music = new ArrayList<>();
        lyrics = new ArrayList<>();
        // genre = new Genre();
        // privacy = 
        // don't understand what to do for instruments
        
    }

    public String getTitle() {
        return title;
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

    }

    public void setTabs(ArrayList<Tab> tabs) {

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

    }

    public void removeComment(String comment) {
    }

}