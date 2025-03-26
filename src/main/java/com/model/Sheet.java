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
     * Displays the format of the music
     */
    @Override
    public void displayFormat() {

    }

    /**
     * Gets the instrument of the sheet
     * @return the sheet instrument
     */
    public Instrument getSheetInstrument() {
        return instrument;
    }

    /**
     * Gets the notes for this sheet
     * @return the sheet's notes
     */
    public ArrayList<Note> getSheetNotes() {
        return notes;
    }
}
