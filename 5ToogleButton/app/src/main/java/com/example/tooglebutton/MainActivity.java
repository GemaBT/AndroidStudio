package com.example.tooglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton miBoton;
    ImageView miImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = (ToggleButton) findViewById(R.id.toggleButton);
        miImagen = (ImageView) findViewById(R.id.imageView);

        miBoton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Lógica cuando el ToggleButton está activado
                    miImagen.setImageResource(R.drawable.abierto);
                } else {
                    // Lógica cuando el ToggleButton está desactivado
                    miImagen.setImageResource(R.drawable.cerrado);
                }
            }
        });

    }
}