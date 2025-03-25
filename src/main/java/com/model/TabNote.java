package com.model;

public class TabNote {
    private Note note;
    private String string;
    private int fret;

    public TabNote(Note note, String string, int fret) {
        this.note = note;
        this.string = string;
        this.fret = fret;
    }

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

    /**
     * Gets the tabnote as a String
     * @return the tab's tabnote
     */
    public String getTabnoteString() {
        return string;
    }

    /**
     * Gets the fret for this tabnote
     * @return
     */
    public int getTabnoteFret() {
        return fret;
    }

    /**
     * Gets the note of this tabnote
     * @return the tabnote's note
     */
    public Note getTabnoteNote() {
        return note;
    }
}
