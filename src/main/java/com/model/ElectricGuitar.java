package com.model;

import java.util.ArrayList;

public class ElectricGuitar implements Instrument {
    private String name;
    private ArrayList<String> strings;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    private static final int NUM_STRINGS = 6;

    public ElectricGuitar(String name, ArrayList<String> strings) {
        // may need to be changed
        this.name = name;
        this.strings = strings;
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

    public int getNumStrings() {
        return NUM_STRINGS;
    }
}
