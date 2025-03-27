package com.model;

import java.util.ArrayList;

/**
 * Represents an electric guitar (type of instrument)
 * Extends the Instrument class
 */

public class ElectricGuitar extends Instrument {
    private String name;
    private ArrayList<String> strings;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    private static final int NUM_STRINGS = 6;

    /**
     * Constructs an electric guitar
     * @param name the name of 
     * @param strings the list of string tunings, defaults if null
     */
    public ElectricGuitar(String name, ArrayList<String> strings) {
        // may need to be changed
        this.name = name;
        this.strings = strings;
        if (strings == null) {
            strings = new ArrayList<String>();
            strings.add("E");
            strings.add("A");
            strings.add("D");
            strings.add("G");
            strings.add("B");
            strings.add("e");
        }
    }

    /**
     * Gets the notes to be played
     * @return the list of notes
     */
    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
     * Gets the chords to be played
     * @return the list of chords
     */
    public ArrayList<Chord> getChord() {
        return chords;
    }

    /**
     * Gets the name of the electric guitar
     * @return the name of the electric guitar
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of strings on the electric guitar
     * @return the number of strings
     */
    public int getNumStrings() {
        return NUM_STRINGS;
    }
}
