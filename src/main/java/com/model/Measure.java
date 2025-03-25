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
     * @param sheets the list of sheets in the measure
     * @param tabs the list of tabs in the measure
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

    /**
     * Gets the lyrics from that measure
     * @return the measure's lyric as a String
     */
    public String getMeasureLyric() {
        return lyric;
    }

    /**
     * Gets the chord of the measure
     * @return the measure's chord
     */
    public ArrayList<Chord> getMeasureChord() {
        return chords;
    }

    /**
     * Gets the strings from the measure
     * @return the measure's strings as a list of Strings
     */
    public ArrayList<String> getMeasureStrings() {
        return this.strings;
    }

    /**
     * Gets the sheets of the measure
     * @return the measure's sheets
     */
    public ArrayList<Sheet> getMeasureSheet() {
        return sheets;
    }

    /**
     * Gets the tabs of the measure
     * @return the measure's list of tabs
     */
    public ArrayList<Tab> getMeasureTab() {
        return tabs;
    }
}
