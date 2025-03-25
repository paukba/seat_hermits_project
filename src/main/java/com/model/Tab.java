package com.model;

import java.util.ArrayList;

/**
 * Represents music in a tab notation format
 */

public class Tab implements NotationFormat{
    private ArrayList<TabNote> tabNotes;
    private Instrument instrument;

    /**
     * Constructs a tab of music
     * @param tabNotes the tab notes in the song
     */
    public Tab(ArrayList<TabNote> tabNotes) {
        this.tabNotes = tabNotes;
    }

    /**
     * Displays the tab
     */
    public void displayTab() {

    }

    /**
     * 
     */
    @Override
    public void displayFormat() {
        
    }
}
