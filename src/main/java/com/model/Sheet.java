package com.model;

import java.util.ArrayList;

/**
 * Represents a music in a sheet notation format
 * Implements the NotationFormat interface
 */

public class Sheet implements NotationFormat{
    private ArrayList<Note> notes;
    private Instrument instrument;

    /**
     * Constructs a sheet of music with notes and chosen instrument
     * @param notes the notes in the song
     */
    public Sheet(ArrayList<Note> notes, Instrument instrument) {
        this.notes = notes;
        this.instrument = instrument;
    }

    /**
     * Displays the sheet of music
     */
    public void displaySheet() {

    }

    /**
     * Displays the format of a musical notation
     */
    @Override
    public void displayFormat() {

    }

    /**
     * Gets the instrument for a sheet
     * @return the sheet's instrument
     */
    public Instrument getSheetInstrument() {
        return instrument;
    }

    /**
     * Gets the notes for a sheet
     * @return the sheet's notes
     */
    public ArrayList<Note> getSheetNotes() {
        return notes;
    }
}
