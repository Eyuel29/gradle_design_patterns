package com.joel.structural;

public class Mp4Player extends AdvancedMediaPlayer {

    @Override
    public void playMp4(MediaTypes mediatype, String song) {
        System.out.println("Playing MP4 media type song " +song+ ".");
    }
}