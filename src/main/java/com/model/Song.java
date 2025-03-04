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

    public Song(String name, ArrayList<Tab> music, ArrayList<String> lyrics, Genre genre, Boolean privacy, Instrument instrument) {
        
    }

    public String getTitle() {
<<<<<<< HEAD
        return "";
=======
        return title;
>>>>>>> 72e2139773df94a68cb23fb99ef138afb41b164b
    }

    public ArrayList<Sheet> getSheets(Instrument instrument) {
        return sheets;
    }

    public ArrayList<Tab> getTabs(Instrument instrument) {
        return tabs;
    }

    public ArrayList<String> getLyrics() {
<<<<<<< HEAD
        return new ArrayList<String>();
=======
        return lyrics;
>>>>>>> 72e2139773df94a68cb23fb99ef138afb41b164b
    }

    public Genre getGenre() {
        return genre;
    }

    public ArrayList<Instrument> getInstruments() {
<<<<<<< HEAD
        return new ArrayList<Instrument>();
    }

    public boolean isPrivate() {
        return true;
=======
        return instruments;
    }

    public boolean isPrivate() {
        return privacy;
>>>>>>> 72e2139773df94a68cb23fb99ef138afb41b164b
    }

    public void setTitle(String name) {

    }

    public void setSheets(ArrayList<Sheet> sheets) {

    }

    public void setTabs(ArrayList<Tab> tabs) {

    }

    public void setLyrics(ArrayList<String> lyrics) {

    }

    public void setGenre(Genre genre) {

    }

    public void setPrivacy(boolean privacy) {
        
    }

    public void playSong(Song song) {

    }

    public void addComment(String comment) {

    }

    public void removeComment(String comment) {

    }

}