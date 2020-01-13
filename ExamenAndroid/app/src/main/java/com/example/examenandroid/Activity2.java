package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private EditText nom;
    private EditText cog;
    private EditText dni;
    private EditText diners;
    private Button enviarDeclaracio;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0;
    String numTelf;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }

        SharedPreferences preferences=getSharedPreferences("formulario", Context.MODE_PRIVATE);

        nom=(EditText)findViewById(R.id.nom);
        nom.setText(preferences.getString("nom",""));

        cog=(EditText)findViewById(R.id.cog);
        cog.setText(preferences.getString("cog",""));

        dni=(EditText)findViewById(R.id.dni);
        dni.setText(preferences.getString("dni",""));

        diners=(EditText)findViewById(R.id.diners);
        diners.setText(preferences.getString("diners",""));



        Button enviarDeclaracio = (Button) findViewById(R.id.enviarDeclaracio);
        enviarDeclaracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                if ( !(diners.getText().toString().isEmpty())) {
                    sendSMSMessage();
                }
                startActivity(intent);


                //onactivityResult

                String name=nom.getText().toString();
                Intent intent2 = new Intent (v.getContext(), Activity3.class);
                intent.putExtra("name",name);
                startActivityForResult(intent,1);






            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(data!=null){ String message=data.getStringExtra("name");
                nom.setText(message); }
            //if(resultCode==RESULT_OK){
            //   int result=data.getIntExtra("result",0);  }


        }
    }


    protected void sendSMSMessage() {
        numTelf = "5554";
        mensaje = "renta 2020: "+nom.getText().toString()+" "+dni.getText().toString()+" ceclara euros: "+diners.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(numTelf, null, mensaje, null, null);
        Toast.makeText(getApplicationContext(), "SMS enviado!", Toast.LENGTH_LONG).show();

    }

    protected void onStart(){
        super.onStart();
        Log.d("ESTATS","Starts_Activity_2");
    }
    protected void onResume(){
        super.onResume();
        Log.d("ESTATS","Resume_Activity_2");

    }

    protected void onPause(){//al salir guarda con el editor las ultimas modificaciones
        super.onPause();
        Log.d("ESTATS","Pause_Activity_2");

        guardar();


    }

    public void guardar(){
        SharedPreferences prefs=getSharedPreferences("formulario",Context.MODE_PRIVATE);//recupero de nuevo lo guardado en "formulario" creando una instancia PREFS que contenga los datos
        SharedPreferences.Editor editor=prefs.edit(); //<--para escribir en el fichero preferencias necesito el editor

        editor.putString("nom",nom.getText().toString());//lo que hayas guardado como "user" en SharedPrefs lo metes en introUSer
        editor.putString("cog",cog.getText().toString());
        editor.putString("dni",dni.getText().toString());
        editor.putString("diners",diners.getText().toString());

        editor.commit();
    }



    protected void onStop(){
        super.onStop();
        Log.d("ESTATS","Stop_Activity_2");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ESTATS","Destroy_Activity_2");
    }

}
