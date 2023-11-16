package com.example.imagenybottonview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

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

public class MainActivity extends AppCompatActivity implements MiFragmento.OnTerminarLlamadaListener {
    ImageButton miBoton;
    boolean estoyLlamando = false;
    DialogFragment miFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = (ImageButton) findViewById(R.id.idBoton);

        miBoton.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo();
            }});
    }

    private void mostrarDialogo() {
        miBoton.setImageResource(R.drawable.telefono_2);
        MiFragmento dialogFragment = new MiFragmento();
        dialogFragment.setOnTerminarLlamadaListener(this);
        dialogFragment.show(getSupportFragmentManager(), "MiDialogFragment");
        dialogFragment.setCancelable(false);
    }

    public void onTerminarLlamada() {
        // Acciones a realizar en la actividad principal al hacer clic en "TERMINAR"
        // Por ejemplo, cambiar la imagen del botón
        miBoton.setImageResource(R.drawable.telefono_1);
    }

    }
