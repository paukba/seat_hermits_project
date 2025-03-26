package com.model;

import java.util.ArrayList;

/**
 * Implements the NotationFormat interface, represents music in a sheet notation format
 */

public class Sheet implements NotationFormat{
    private ArrayList<Note> notes;
    private Instrument instrument;

    /**
     * Constructs a sheet of music
     * @param notes the notes in the song
     */
    public Sheet(ArrayList<Note> notes) {

    }

    /**
     * Displays the sheet of music
     */
    public void displaySheet() {

    }

    /**
     * Displays the format of the music
     */
    @Override
    public void displayFormat() {

    }
}
