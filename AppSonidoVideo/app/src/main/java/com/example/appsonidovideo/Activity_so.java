package com.example.appsonidovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;


public class Activity_so extends AppCompatActivity implements OnPreparedListener,  MediaController.MediaPlayerControl{

    Button button1, button2;
    MediaPlayer mp;
    MediaController mediaController;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so);


        mp = new MediaPlayer();
        mp.setOnPreparedListener(this);

        mediaController = new MediaController(this);
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(findViewById(R.id.imageViewControls));




        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playCorto();
            }
        });

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playLargo();
            }
        });





    }


    public void playCorto(){

        mp.stop();
        mp = MediaPlayer.create(getApplicationContext(),getResources().getIdentifier("alicates","raw",getPackageName()));
        mp.start();
        mediaController.show();
    }

    public void playLargo(){


        mp.stop();
        mp = MediaPlayer.create(getApplicationContext(),getResources().getIdentifier("einkompliment","raw",getPackageName()));
        mp.start();
        mediaController.show();
    }







    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(findViewById(R.id.imageViewControls));
        handler.post(new Runnable() {
            @Override
            public void run() {
                mediaController.setEnabled(true);
                mediaController.show();
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        mediaController.show();
        return false;
    }


    @Override
    public void start() {
        mp.start();

    }

    @Override
    public void pause() {
        mp.pause();
    }

    @Override
    public int getDuration() {
        return mp.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mp.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mp.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return mp.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return mp.getAudioSessionId();
    }
}
