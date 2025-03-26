package com.model;

import java.util.ArrayList;

/**
 * Class the represents measures
 */

public class Measure {
    private String lyric;
    private ArrayList<NotationFormat> notations;
    private ArrayList<Note> notes;
    private Chord chord;
    private ArrayList<String> strings;
    private ArrayList<Sheet> sheets;
    private ArrayList<Tab> tabs;

    /**
     * Constructs a measure
     * @param notes the notes in the measure
     * @param chord the chord in the measure
     * @param lyric the lyrics in the measure
     * @param sheets the list of sheets in the measure
     * @param tabs the list of tabs in the measure
     */
    public Measure(ArrayList<Note> notes, Chord chord, String lyric, ArrayList<Sheet> sheets, ArrayList<Tab> tabs) {
        this.lyric = lyric;
        this.chord = chord;
        this.notations = new ArrayList<NotationFormat>();
        this.sheets = sheets;
        this.tabs = tabs;
        if (sheets != null) {}
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
    public void playChord(Chord chord) {

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
    public Chord getMeasureChord() {
        return chord;
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
