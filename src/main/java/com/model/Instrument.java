package com.model;

import java.util.ArrayList;

public abstract class Instrument {
    private String name;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    private boolean hasStrings;

    public Instrument(ArrayList<Note> notes, ArrayList<Chord> chords) {

    }

    public Note getNote() {
        return new Note(0, 0);
    }

    public Chord getChord() {
        return new Chord(notes);
    }
}
