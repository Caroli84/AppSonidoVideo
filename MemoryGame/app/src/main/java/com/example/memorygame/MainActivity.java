package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6, foto, error;
    Integer[] list = {101, 102, 103, 201, 202, 203};
    int imagen101, imagen102, imagen103, imagen201, imagen202, imagen203;
    int firstCard, secondCard, clickedFirst, clickedSecond;
    int cardNumber=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = (ImageView) findViewById(R.id.error);
        error.setVisibility(View.INVISIBLE);

        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);

        img1.setTag("0");
        img2.setTag("1");
        img3.setTag("2");
        img4.setTag("3");
        img5.setTag("4");
        img6.setTag("5");

        frontOfCardResources();

        //barajar caras del array
        Collections.shuffle(Arrays.asList(list));


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carta = Integer.parseInt((String) v.getTag());
                letsPlay(img1, carta);

            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carta = Integer.parseInt((String) v.getTag());
                letsPlay(img2, carta);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carta = Integer.parseInt((String) v.getTag());
                letsPlay(img3, carta);

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carta = Integer.parseInt((String) v.getTag());
                letsPlay(img4, carta);

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carta = Integer.parseInt((String) v.getTag());
                letsPlay(img5, carta);

            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carta = Integer.parseInt((String) v.getTag());
                letsPlay(img6, carta);

            }
        });



        //GIF:
        // cargar el XML con todos los fotogramas que componen el gif
        foto = (ImageView) findViewById(R.id.foto);
        foto.setBackgroundResource(R.drawable.countdown);
        // obtener el background, el cuál ha sido compilado a AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) foto.getBackground();
        // Start con loop
        frameAnimation.start();

    }




    //le paso la posicion-indice en el array parseado y la img que ha clicado
    //a list[carta] de le pasa el indice del array
    private void letsPlay(ImageView imagen, int carta) {

        //Poner la imagen correcta con su ImageView
        if (list[carta] == 101) {
            imagen.setImageResource(imagen101);
        } else if (list[carta] == 102) {
            imagen.setImageResource(imagen102);
        } else if (list[carta] == 103) {
            imagen.setImageResource(imagen103);
        } else if (list[carta] == 201) {
            imagen.setImageResource(imagen201);
        } else if (list[carta] == 202) {
            imagen.setImageResource(imagen202);
        } else if (list[carta] == 203) {
            imagen.setImageResource(imagen203);
        }

        if (cardNumber == 1) {
            firstCard = list[carta];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = carta;

            imagen.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = list[carta];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = carta;

            img1.setEnabled(false);
            img2.setEnabled(false);
            img3.setEnabled(false);
            img4.setEnabled(false);

            img4.setEnabled(false);
            img5.setEnabled(false);
            img6.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() { //funcion para comprobar si son la misma foto, y se pone invisible para que desaparezca
                    calculate();
                }
            }, 1000);
        }
    }


    private void calculate() {

        //Si las imagenes son iguales las quitaria con INVISIBLE
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                img1.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                img2.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                img3.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                img4.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                img5.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                img6.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                img1.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                img2.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                img3.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                img4.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                img5.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                img6.setVisibility(View.INVISIBLE);
            }


        } else {
            img1.setImageResource(R.drawable.memory);
            img2.setImageResource(R.drawable.memory);
            img3.setImageResource(R.drawable.memory);
            img4.setImageResource(R.drawable.memory);
            img5.setImageResource(R.drawable.memory);
            img6.setImageResource(R.drawable.memory);


            Animation animacionError = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.error_prueba);
            error.startAnimation(animacionError);
        }

        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);

        //Mira si el juego ha terminado
        checkEnd();

    }

    private void checkEnd() {
        if (img1.getVisibility() == View.INVISIBLE &&
                img2.getVisibility() == View.INVISIBLE &&
                img3.getVisibility() == View.INVISIBLE &&
                img4.getVisibility() == View.INVISIBLE &&
                img5.getVisibility() == View.INVISIBLE &&
                img6.getVisibility() == View.INVISIBLE) {

            AlertDialog.Builder alertDiaologBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDiaologBuilder.setMessage("GAME OVER :O").setCancelable(false).setPositiveButton("REPETIR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog alertDialog = alertDiaologBuilder.create();
            alertDialog.show();
        }
    }


    private void frontOfCardResources() {
        imagen101 = R.drawable.img101;
        imagen102 = R.drawable.img102;
        imagen103 = R.drawable.img103;
        imagen201 = R.drawable.img201;
        imagen202 = R.drawable.img202;
        imagen203 = R.drawable.img203;

    }

}
