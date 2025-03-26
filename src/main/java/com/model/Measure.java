package com.model;

import com.musicapp.*;
import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.Iterator;

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
        this.notes = notes;
        this.lyric = lyric;
        this.chord = chord;
        this.notations = new ArrayList<NotationFormat>();
        this.sheets = sheets;
        this.tabs = tabs;
        if (sheets != null && notes == null) {
            Iterator<Sheet> sheeIterator = sheets.iterator();
            this.notes = sheeIterator.next().getSheetNotes();
        }
        else if (tabs != null && notes == null) {
            Iterator<Tab> tabIterator = tabs.iterator();
            ArrayList<TabNote> tabNotes = tabIterator.next().getTabNotes();
            notes = new ArrayList<Note>();
            Iterator<TabNote> tabNoteIterator = tabNotes.iterator();
            while (tabNoteIterator.hasNext()) {
                notes.add(tabNoteIterator.next().getTabnoteNote());
            }
        }
    }

    /**
     * Plays notes in a measure
     * @param notes the notes in the measure
     */

    // figure out how to implement
    public void playNotes() {
        String jFugueArgument = "";
        int maxTime = 0;
        int voice = 0;
        ArrayList<Note> buffer = new ArrayList<Note>();
        Iterator<Note> notesIterator = notes.iterator();
        while (notesIterator.hasNext()) {
            Note note = notesIterator.next();
            if ((int) note.getStartTime() > maxTime) {
                maxTime = (int) note.getStartTime();
            }
            buffer.add(note);
        }
        while (!buffer.isEmpty()) {
            jFugueArgument += ("V" +voice+ " ");
            for (int time = 0; time <= maxTime; time++) {
                Iterator<Note> bufferIterator = buffer.iterator();
                boolean found = false;
                while (bufferIterator.hasNext()) {
                    found = false;
                    Note note = bufferIterator.next();
                    if ((int) note.getStartTime() == time) {
                        jFugueArgument += ("m" +note.getNotePitch()+ " ");
                        buffer.remove(note);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    jFugueArgument += "r ";
                }
            }
            voice++;
        }
        Player player = new Player();
        player.play(jFugueArgument);
    }

    /**
     * Plays chords in a measure
     * @param chords the chord in the measure
     */
    public void playChord(Chord chord) {
        chord.playChord(notes);
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
