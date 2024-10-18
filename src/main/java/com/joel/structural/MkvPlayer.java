package com.joel.structural;

public class MkvPlayer extends AdvancedMediaPlayer {
    
    @Override
    public void playMkv(MediaTypes mediatype, String song) {
        System.out.println("Playing MKV media type song " +song+ ".");
    }   
}