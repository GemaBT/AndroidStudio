package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
Switch miBoton;
TextView miTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = (Switch) findViewById(R.id.switch1);
        miTexto = (TextView) findViewById(R.id.textView);

        miBoton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Lógica cuando el ToggleButton está activado
                   miTexto.setText("Encendido");
                } else {
                    // Lógica cuando el ToggleButton está desactivado
                   miTexto.setText("Apagado");
                }
            }
        });
    }
}