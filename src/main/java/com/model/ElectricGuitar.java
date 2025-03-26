package com.model;

import java.util.ArrayList;

/**
 * Implements the instrument interface, represents an electric guitar as an instrument
 */

public class ElectricGuitar implements Instrument {
    private String name;
    private ArrayList<String> strings;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    private static final int NUM_STRINGS = 6;

    /**
     * Constructs an electric guitar
     * @param name 
     * @param strings 
     */
    public ElectricGuitar(String name, ArrayList<String> strings) {
        // may need to be changed
        this.name = name;
        this.strings = strings;
        this.notes = notes;
        this.chords = chords;
    }

    /**
     * Gets the notes in the song
     */
    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
     * Gets the chords in the song
     */
    public ArrayList<Chord> getChord() {
        return chords;
    }

    /**
     * Gets the name of the song
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the amount of strings
     * @return 
     */
    public int getNumStrings() {
        return NUM_STRINGS;
    }
}
