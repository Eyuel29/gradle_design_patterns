package com.joel.structural;
import com.joel.structural.AudioPlayer;
import com.joel.structural.MediaPlayer;
import com.joel.structural.MediaTypes;

public class Main{
    public static void main(String[] args){
        AudioPlayer aufioPlayer = new AudioPlayer();
        aufioPlayer.play(MediaTypes.MP4,"Pendemoneoum");
    }
}