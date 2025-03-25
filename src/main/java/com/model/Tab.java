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
        for (int i = 0; i<tabNotes.size(); i++) {
            tabNotes.get(i).displayTabNote();
            if ((i+1)!=tabNotes.size())
                System.out.print(" ");
        }
    }

    /**
     * 
     */
    @Override
    public void displayFormat() {
        
    }

    public Instrument getTabInstrument() {
        return instrument;
    }

    public ArrayList<TabNote> getTabNotes() {
        return tabNotes;
    }
}
