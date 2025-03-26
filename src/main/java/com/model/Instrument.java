package com.model;

import java.util.ArrayList;

/**
 * Extended by any class that lets the user choose an instrument
 */

public abstract class Instrument {
    private String name;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    
    /**
     * Gets the notes to be played
     * @return the song chords
     */
    public ArrayList<Note> getNotes() {
        return notes;
    };

    /**
     * Gets the chords to be played
     * @return the song chords
     */
    public ArrayList<Chord> getChords() {
        return chords;
    }

    /**
     * Gets the name of the song
     * @return the song name
     */
    public String getName() {
        return name;
    }
}
