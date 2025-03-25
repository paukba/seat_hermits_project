package com.model;

import java.util.ArrayList;

/**
 * Class that represents chords
 */

public class Chord {
    private String name;
    private ArrayList<Note> notes;

    /**
     * Constructs a chord
     * @param name the name of the song    ?
     * @param notes the notes in the chord (and song)
     */
    public Chord(String name, ArrayList<Note> notes) {
        this.name = name;
        this.notes = notes;
    }

    /**
     * Plays the intended chord
     * @param notes the notes in the chord (and song)
     */

    // figure out how to implement
    public void playChord(ArrayList<Note> notes) {
        
    }
}
