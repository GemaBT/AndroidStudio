package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText text;
    Button button;

    @Override
//Usamos el TollBar con CinstrainLayout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("constraintlayout");


        text = (EditText) findViewById(R.id.editText);
        button =(Button) findViewById(R.id.button4);

    }
    public void describir(View vista){
        Intent i = new Intent(this, MainActivity4.class);
        i.putExtra("Detalle", text.getText().toString());
        startActivity(i);
    }
}