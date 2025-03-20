package com.model;

import java.util.ArrayList;

/**
 * Implemented by any class that lets the user choose an instrument
 */

public interface Instrument {
    
    /**
     * Gets the notes to be played
     * @return the song chords
     */
    public ArrayList<Note> getNotes();

    /**
     * Gets the chords to be played
     * @return the song chords
     */
    public ArrayList<Chord> getChord();

    /**
     * Gets the name of the song
     * @return the song name
     */
    public String getName();
}
