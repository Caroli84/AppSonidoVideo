package com.example.appsonidovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ImageButton buttonTv = (ImageButton) findViewById(R.id.buttonTv);
        buttonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(), Activity_video.class);
                startActivityForResult(intent2, 0);
            }
        });

        ImageButton buttonSound = (ImageButton) findViewById(R.id.buttonSound);
        buttonSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent (v.getContext(), Activity_so.class);
                startActivityForResult(intent3, 0);
            }
        });


    }
}
