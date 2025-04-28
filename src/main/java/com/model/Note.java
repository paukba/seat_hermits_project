package com.model;

/**
 * Represents a musical note, which consists of a name, pitch, duration, and start time
 */

public class Note {
    private String name;
    private double pitch;
    private double duration;
    private double startTime;

    /**
     * Constructs a note with its elements
     * @param name the name of the note
     * @param pitch the pitch of the note
     * @param duration the duration of the note
     * @param startTime the time the note starts at
     */
    public Note(String name, double pitch, double duration, double startTime) {
        this.name = name;
        this.pitch = pitch;
        this.duration = duration;
        this.startTime = startTime;
    }

    /**
     * Plays an intended note
     * @param pitch the pitch of the note
     * @param duration the duration of the note
     * @param startTime the time the note starts at
     */
    
    // figure out how to implement
    public void playNote(double pitch, double duration, double startTime) {
        
    }

    /**
     * Gets the duration of a note
     * @return the note's duration
     */
    public double getDuration() {
        return this.duration;
    }
    
    /**
     * Gets the starting time of a note
     * @return the note's start time
     */
    public double getStartTime() {
        return this.startTime;
    }

    public void setStartTime(double time) {
        startTime = time;
    }

    /**
     * Gets the name of a note
     * @return the note's name
     */
    public String getNoteName() {
        return name;
    }

    /**
     * Gets the pitch of a note
     * @return the note's pitch
     */
    public double getNotePitch() {
        return pitch;
    }

}
