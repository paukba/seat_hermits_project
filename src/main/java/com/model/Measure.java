package com.model;

import com.musicapp.*;
import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a measure, which consists of notes, chords, lyrics, sheets, and tabs
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
     * Constructs a measure with its elements
     * @param notes the notes in the measure
     * @param chord the chord in the measure
     * @param lyric the lyrics in the measure
     * @param sheets the list of sheet music for the measure
     * @param tabs the list of tablature for the measure
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
     * Plays the notes in a measure
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
     * Plays the chords in a measure
     * @param chord the chord in the measure
     */
    public void playChord(Chord chord) {
        chord.playChord(notes);
    }

    /**
     * Gets the lyric in a measure
     * @return the measure's lyric
     */
    public String getMeasureLyric() {
        return lyric;
    }

    /**
     * Gets the chord of a measure
     * @return the measure's chord
     */
    public Chord getMeasureChord() {
        return chord;
    }

    /**
     * Gets the strings in a measure
     * @return the list of strings in the measure
     */
    public ArrayList<String> getMeasureStrings() {
        return this.strings;
    }

    /**
     * Gets the sheet music for a measure
     * @return the list of sheet music for a measure
     */
    public ArrayList<Sheet> getMeasureSheet() {
        return sheets;
    }

    /**
     * Gets the tablature for a measure
     * @return the list of tabs for the measure
     */
    public ArrayList<Tab> getMeasureTab() {
        return tabs;
    }
}
