package com.joel.structural;

public class AviPlayer extends AdvancedMediaPlayer {
    @Override
    public void playAvi(MediaTypes mediatype, String song) {
        System.out.println("Playing AVi media type song " +song+ ".");
    }   
}