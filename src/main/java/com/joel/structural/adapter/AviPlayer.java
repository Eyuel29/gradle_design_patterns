package com.joel.structural;

public class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public synchronized void playAvi(MediaTypes mediatype, String song) {
        System.out.println("Playing AVi media type song " +song+ ".");
    }

    @Override
    public void playMkv(MediaTypes mediatype, String song) {}
    @Override
    public void playMp4(MediaTypes mediatype, String song) {}   
}