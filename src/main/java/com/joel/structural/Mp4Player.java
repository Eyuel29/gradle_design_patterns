package com.joel.structural;

public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public synchronized void playMp4(MediaTypes mediatype, String song) {
        System.out.println("Playing MP4 media type song " +song+ ".");
    }

    @Override
    public void playAvi(MediaTypes mediatype, String song) {}
    @Override
    public void playMkv(MediaTypes mediatype, String song) {}
}