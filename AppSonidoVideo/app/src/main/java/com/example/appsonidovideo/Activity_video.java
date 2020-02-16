package com.example.appsonidovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

public class Activity_video extends AppCompatActivity {

    MediaController mediaController;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView)findViewById(R.id.videoView);
        //String videopath="android.resource://"+getPackageName()+"/"+R.raw.videoddr;


    }



    public void play(View view) {
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoddr);
        videoView.setVideoURI(path);
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    public void play2(View view) {
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.werbung);
        videoView.setVideoURI(path);
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
}