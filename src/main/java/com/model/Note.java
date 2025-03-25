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
        this.startTime = startTime;
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

    /**
     * Gets the duration of the note
     * @return the note's duration
     */
    public double getDuration() {
        return this.duration;
    }
    
    /**
     * Gets the starting time of the note
     * @return note's startTime
     */
    public double getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the name of this note
     * @return the note's name
     */
    public String getNoteName() {
        return name;
    }

    /**
     * Gets the pitch of this note
     * @return the note's pitch
     */
    public double getNotePitch() {
        return pitch;
    }

}
