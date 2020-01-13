package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        //SharedPreferences preferences=getSharedPreferences("formulario", Context.MODE_PRIVATE);
        //name=(EditText)findViewById(R.id.nom);
        //name.setText(preferences.getString("nom",""));


        //

        Intent intent=getIntent();
        String nom=intent.getStringExtra("name");

        name=(TextView) findViewById(R.id.name);
        name.setText("mensaje recibido: "+nom);



    }



}
