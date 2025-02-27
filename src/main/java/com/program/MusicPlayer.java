package com.program;

import com.musicapp.*;
import java.lang.Thread;

import org.jfugue.player.Player;

public class MusicPlayer {
    
    public void playSong() {
        try {
            playLine1();
            Thread.sleep(250);
            playLine2();
            Thread.sleep(250);
            playLine3();
            Thread.sleep(250);
            playLine4();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void playLine1() {
        Player player = new Player();
        player.play("E4 E4 Gb4 G4 D B4");
    }

    private void playLine2() {
        Player player = new Player();
        player.play("B4i A4 G4 A4 G4i A4 ri B4 A4 G4i E4");
    }

    private void playLine3() {
        Player player = new Player();
        player.play("ri E4 Gb4 G4 rs D B4");
    }

    private void playLine4() {
        Player player = new Player();
        player.play("A4 G4 A4 G4i A4 G4i B4 A4 G4i E4");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.playSong();
    }
}
