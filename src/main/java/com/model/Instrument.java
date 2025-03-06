package com.model;

import java.util.ArrayList;

public abstract class Instrument {
    private String name;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    private boolean hasStrings;

    public Instrument(String name, ArrayList<Note> notes, ArrayList<Chord> chords) {
        this.name = name;
        this.notes = notes;
        this.chords = chords;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public ArrayList<Chord> getChord() {
        return chords;
    }

    public String getName() {
        return name;
    }
}
