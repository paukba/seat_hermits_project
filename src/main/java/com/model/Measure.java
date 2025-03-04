package com.model;

import java.util.ArrayList;

public class Measure {
    private double tempo;
    private String lyric;
    private ArrayList<NotationFormat> notations;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;

    public Measure(ArrayList<Note> notes, ArrayList<Chord> chords) {
    
    }

    public void playNotes(ArrayList<Note> notes) {

    }

    public void playChords(ArrayList<Chord> chords) {

    }

    public double getTempo() {
        return 0;
    }
}
