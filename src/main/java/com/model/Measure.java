package com.model;

import java.util.ArrayList;

/**
 * Class the represents measures
 */

public class Measure {
    private double tempo;
    private String lyric;
    private ArrayList<NotationFormat> notations;
    private ArrayList<Note> notes;
    private ArrayList<Chord> chords;
    private ArrayList<String> strings;
    private ArrayList<Sheet> sheets;
    private ArrayList<Tab> tabs;

    /**
     * Constructs a measure
     * @param notes the notes in the measure
     * @param chords the chords in the measure
     * @param lyric the lyrics in the measure
     * @param tempo the tempo of the measure
     */
    public Measure(ArrayList<Note> notes, ArrayList<Chord> chords, String lyric, double tempo, ArrayList<Sheet> sheets, ArrayList<Tab> tabs) {
        this.tempo = tempo;
        this.lyric = lyric;
        this.chords = chords;
        this.notes = notes;
        this.notations = new ArrayList<NotationFormat>();
        this.sheets = sheets;
        this.tabs = tabs;
    }

    /**
     * Plays notes in a measure
     * @param notes the notes in the measure
     */

    // figure out how to implement
    public void playNotes(ArrayList<Note> notes) {

    }

    /**
     * Plays chords in a measure
     * @param chords the chords in the measure
     */

    // figure out how to implement
    public void playChords(ArrayList<Chord> chords) {

    }

    /**
     * Gets the tempo of a measure
     * @return the tempo of the measure
     */
    public double getTempo() {
        return tempo;
    }

    public int getMeasureNum(int index) {
        return index;
    }

    public String getMeasureLyric() {
        return lyric;
    }

    public ArrayList<Chord> getMeasureChord() {
        return chords;
    }

    public ArrayList<String> getMeasureStrings() {
        return this.strings;
    }

    public ArrayList<Sheet> getMeasureSheet() {
        return sheets;
    }

    public ArrayList<Tab> getMeasureTab() {
        return tabs;
    }
}
