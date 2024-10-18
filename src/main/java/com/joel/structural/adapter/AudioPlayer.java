package com.joel.structural;
import com.joel.structural.MediaAdapter;
import com.joel.structural.MediaPlayer;
import com.joel.structural.MediaTypes;

public class AudioPlayer implements MediaPlayer{
    private MediaAdapter mediaAdapter;
    
    public AudioPlayer() {
        mediaAdapter = new MediaAdapter();
    }

    @Override
    public void play(MediaTypes mediatype, String song) {
        if (mediatype.equals(MediaTypes.MP3)) {
            System.out.println("Playing Mp3 media type song " +song+ ".");
        } else {
            mediaAdapter.play(mediatype, song);
        }
    }
}