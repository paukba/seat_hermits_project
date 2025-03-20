package com.model;

import java.util.ArrayList;

public interface Instrument {
    public ArrayList<Note> getNotes();

    public ArrayList<Chord> getChord();

    public String getName();
}
