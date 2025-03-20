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
        return "";
    }
}
