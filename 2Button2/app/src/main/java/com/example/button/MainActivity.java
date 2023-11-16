package com.example.button;

import static com.example.button.MiToastPersonalizado.mostrarMensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button miBoton;
    MiToastPersonalizado toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = (Button)findViewById(R.id.boton);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.mostrarMensaje(MainActivity.this, "Me hicieron clic", 3000);
                //Toast.makeText(MainActivity.this, "Me hicieron clic", Toast.LENGTH_SHORT).show();
            }
        });
    }
}