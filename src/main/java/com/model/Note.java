package com.model;

/**
 * Class that represents notes
 */

public class Note {
    private String name;
    private double pitch;
    private double duration;
    private double startTime;

    /**
     * Constructs a note
     * @param name
     * @param pitch the pitch of the note
     * @param duration the duration of the note
     * @param startTime the time the note starts at
     */
    public Note(String name, double pitch, double duration, double startTime) {
        this.name = name;
        this.pitch = pitch;
        this.duration = duration;
    }

    /**
     * Plays the intended note
     * @param pitch the pitch of the note
     * @param duration the duration of the note
     * @param startTime the time the note starts at
     */
    
    // figure out how to implement
    public void playNote(double pitch, double duration, double startTime) {
        
    }

    public double getDuration() {
        return this.duration;
    }
    
    public double getStartTime() {
        return this.startTime;
    }

    public String getNoteName() {
        return name;
    }

    public double getNotePitch() {
        return pitch;
    }

}
