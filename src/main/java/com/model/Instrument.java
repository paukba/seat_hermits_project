package com.model;

import java.util.ArrayList;

/**
 * Abstract representation of an instrument
 * Extended by any class that lets the user choose an instrument
 */

public abstract class Instrument {
    private String name;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    
    /**
     * Gets the notes to be played by the instrument
     * @return the list of notes
     */
    public ArrayList<Note> getNotes() {
        return notes;
    };

    /**
     * Gets the chords to be played by the instrument
     * @return the list of chords
     */
    public ArrayList<Chord> getChords() {
        return chords;
    }

    /**
     * Gets the name of the instrument
     * @return the instrument name
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
