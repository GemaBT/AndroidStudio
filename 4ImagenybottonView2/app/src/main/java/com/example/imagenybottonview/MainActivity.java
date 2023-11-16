package com.example.imagenybottonview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton miBoton;
    boolean estoyLlamando = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = (ImageButton) findViewById(R.id.idBoton);

        miBoton.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (!estoyLlamando){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(false);
                    builder.setTitle("Me has pulsado")
                            .setMessage("Quieres llamar")
                            .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    miBoton.setImageResource(R.drawable.telefono_2);
                                    estoyLlamando = true;
                                    Toast.makeText(MainActivity.this, "Estoy llamando. Pulsa el botón para colgar", Toast.LENGTH_SHORT).show();
                                    }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Ok Operación cancelada", Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else{
                miBoton.setImageResource(R.drawable.telefono_1);
                estoyLlamando = false;
                }
            }});
    }

    }
