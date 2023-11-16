package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
TextView textView,textView1;
    @Override
    //La segunda vista de nuestro documento. Lo vamos a haceer con ConstrantLayout (mai 4) y RelativeLayout (main5)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Constrainlayout");

        textView1 = (TextView) findViewById(R.id.textView5);

        // Ahora puedes mostrar el texto en la vista (por ejemplo, en un TextView)
        //TextView textView = findViewById(R.id.textView); // Reemplaza R.id.textView con el ID de tu TextView

        // Obtener el texto pasado desde MainActivity
        Intent intent = getIntent();
        String inform = intent.getStringExtra("Detalle");
        textView1.setText(inform);
    }
}