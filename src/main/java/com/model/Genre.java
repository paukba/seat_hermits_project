package com.model;

public enum Genre {
    ROC("Rock"),
    POP("Pop"),
    MET("Metal"),
    NEW("New Wave"),
    CLA("Classical"),
    TEC("Techno"),
    NUR("Nursery Rhyme"),
    COU("Country");

    public final String label;

    private Genre(String label) {
        this.label = label;
    }
}