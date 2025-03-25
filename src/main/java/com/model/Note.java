package com.model;

public class Note {
    private String name;
    private double pitch;
    private double duration;
    private double startTime;

    public Note(String name, double pitch, double duration, double startTime) {
        this.name = name;
        this.pitch = pitch;
        this.duration = duration;
    }

    // figure out how to implement
    public void playNote(double pitch, double duration, double startTime) {
        
    }

    public double getDuration() {
        return this.duration;
    }
    
    public double getStartTime() {
        return this.startTime;
    }
}
