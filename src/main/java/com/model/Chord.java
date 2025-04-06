package com.model;

import com.musicapp.*;
import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a musical chord that consists of multiple notes
 */

public class Chord {
    private String name;
    private ArrayList<Note> notes;

    /**
     * Constructs a chord
     * @param name the name of the chord
     * @param notes the notes in the chord
     */
    public Chord(String name, ArrayList<Note> notes) {
        this.name = name;
        this.notes = notes;
    }

    /**
     * Plays the intended chord
     * @param notes the notes in the chord
     */
    public void playChord(ArrayList<Note> notes) {
        Iterator<Note> noteIterator = notes.iterator();
        String jFugueArgument = "";
        int voice = 0;
        while (noteIterator.hasNext()) {
            double pitch = noteIterator.next().getNotePitch();
            jFugueArgument += ("V" +voice+ " m" +pitch+ " ");
        }
        Player player = new Player();
        player.play(jFugueArgument);
    }

    /**
     * Gets the name of the chord to display it with
     * @return this.name
     */
    public String getChordName() {
        return this.name;
    }
}