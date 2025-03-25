package com.model;

import java.util.ArrayList;

public class Tab implements NotationFormat{
    private ArrayList<TabNote> tabNotes;
    private Instrument instrument;

    public Tab(ArrayList<TabNote> tabNotes) {
        this.tabNotes = tabNotes;
    }

    public void displayTab() {
        for (int i = 0; i<tabNotes.size(); i++) {
            tabNotes.get(i).displayTabNote();
            if ((i+1)!=tabNotes.size())
                System.out.print(" ");
        }
    }

    @Override
    public void displayFormat() {
        
    }
}
