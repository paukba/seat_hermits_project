package com.model;

public class TabNote {
    private Note note;
    private int string;
    private int fret;

    public TabNote(Note note, int string, int fret) {
        this.note = note;
        this.string = string;
        this.fret = fret;
    }

    public String displayTabNote() {
        return "";
    }
}
