package com.model;

import java.util.ArrayList;

public class Measure {
    private double tempo;
    private String lyric;
    private ArrayList<NotationFormat> notations;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;

    public Measure(ArrayList<Note> notes, ArrayList<Chord> chords, String lyric, double tempo) {
        this.tempo = tempo;
        this.lyric = lyric;
        this.chords = chords;
        this.notes = notes;
        this.notations = new ArrayList<NotationFormat>();
    }

    // figure out how to implement
    public void playNotes(ArrayList<Note> notes) {

    }

    // figure out how to implement
    public void playChords(ArrayList<Chord> chords) {

    }

    public double getTempo() {
        return tempo;
    }
}
