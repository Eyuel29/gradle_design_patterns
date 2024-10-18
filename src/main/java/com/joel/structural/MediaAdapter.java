package com.joel.structural;
import com.joel.structural.MediaPlayer;
import com.joel.structural.MediaTypes;
import com.joel.structural.MkvPlayer;
import com.joel.structural.Mp4Player;
import com.joel.structural.AdvancedMediaPlayer;
import com.joel.structural.AviPlayer;

public class MediaAdapter implements MediaPlayer{
    private AdvancedMediaPlayer advancedMediaPlayer;

    @Override
    public void play(MediaTypes mediatype, String song){
        switch (mediatype) {
            case MP4:
                advancedMediaPlayer = new Mp4Player();
                advancedMediaPlayer.playMp4(mediatype, song);
                break;
            case AVI:
                advancedMediaPlayer = new AviPlayer();
                advancedMediaPlayer.playAvi(mediatype, song);
                break;
            case MKV:
                advancedMediaPlayer = new MkvPlayer();
                advancedMediaPlayer.playMkv(mediatype, song);
                break;
            default:
                System.out.println("Unknown media type!");
                break;
        }
    }

}