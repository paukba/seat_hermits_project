package com.model;

import java.util.ArrayList;

/**
 * Represents music in a sheet notation format
 */

public class Sheet implements NotationFormat{
    private ArrayList<Note> notes;
    private Instrument instrument;

    /**
     * Constructs a sheet of music
     * @param notes the notes in the song
     */
    public Sheet(ArrayList<Note> notes) {
        this.notes = notes;
    }

    /**
     * Displays the sheet
     */
    public void displaySheet() {

    }

    /**
     * 
     */
    @Override
    public void displayFormat() {

    }

    public Instrument getSheetInstrument() {
        return instrument;
    }

    public ArrayList<Note> getSheetNotes() {
        return notes;
    }
}
