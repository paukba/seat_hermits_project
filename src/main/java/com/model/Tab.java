package com.model;

import java.util.ArrayList;

public class Tab implements NotationFormat{
    private ArrayList<TabNote> tabNotes;
    private Instrument instrument;

    public Tab(ArrayList<TabNote> tabNotes) {
        this.tabNotes = tabNotes;
    }

    public void displayTab() {

    }

    @Override
    public void displayFormat() {
        
    }
}
