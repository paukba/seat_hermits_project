package com.model;

/**
 * Represents the notes in a tab 
 */

public class TabNote {
    private Note note;
    private String string;
    private int fret;

    /**
     * Constructs a tab note
     * @param note the notes in the tab
     * @param string the strings in the tab
     * @param fret the frets in the tab
     */
    public TabNote(Note note, String string, int fret) {
        this.note = note;
        this.string = string;
        this.fret = fret;
    }

    /**
     * Displays a tab note
     * @return the tab note
     */
    public String displayTabNote() {
        String tabNote = "String " + string + ": ";
        // change '10' to something else later
        for (int i=0; i<10; i++) {
            if (i == (int)note.getStartTime()) {
                tabNote = tabNote + fret;
            } else {
                tabNote = tabNote + "-";
            }
        }

        return tabNote;
    }
}
