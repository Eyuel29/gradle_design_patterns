package com.joel.structural;

public class MkvPlayer implements AdvancedMediaPlayer {
    
    @Override
    public synchronized void playMkv(MediaTypes mediatype, String song) {
        System.out.println("Playing MKV media type song " +song+ ".");
    }

    @Override
    public void playAvi(MediaTypes mediatype, String song) {}
    @Override
    public void playMp4(MediaTypes mediatype, String song) {}   
}