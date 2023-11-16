package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editext;
    private Button mi_Boton;

    private TextView dir1, dir2,dir3;

    private String miUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editext = (EditText) findViewById(R.id.textB);
        mi_Boton =(Button) findViewById(R.id.button1);

        dir1 = (TextView) findViewById(R.id.text2);
        dir2 = (TextView) findViewById(R.id.text3);
        dir3 = (TextView) findViewById(R.id.text4);

        dir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miUrl = getString(R.string.text2);
                click(v);
            }
        });

        dir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miUrl = getString(R.string.text3);
                click(v);
            }
        });

        dir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miUrl = getString(R.string.text4);
                click(v);
            }
        });

    }

    public void click(View view){
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("sitioweb",miUrl);
        startActivity(i);
    }

    public void navegar(View view){
        Intent i = new Intent(this, MainActivity2.class);
        miUrl = "https://" + editext.getText().toString();
        i.putExtra("sitioweb",miUrl);
        startActivity(i);
    }
}








        /*dir3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        // Cambiar el estilo del tipo de letra a negrita cuando pasa el cursor por encima
                        dir3.setTypeface(null, Typeface.BOLD);
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        // Volver al estilo de tipo de letra predeterminado cuando el cursor deja de estar sobre el TextView
                        dir3.setTypeface(null, Typeface.NORMAL);
                        break;
                }
                return false;
            }
        });*/

        /*dir2.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        // Cambiar el estilo del tipo de letra a negrita cuando pasa el cursor por encima
                        dir2.setTypeface(null, Typeface.BOLD);
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        // Volver al estilo de tipo de letra predeterminado cuando el cursor deja de estar sobre el TextView
                        dir2.setTypeface(null, Typeface.NORMAL);
                        break;
                }
                return false;
            }
        });*/

      /*  dir1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dir1.setTypeface(null, Typeface.BOLD);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        dir1.setTypeface(null, Typeface.NORMAL);
                        break;
                }
                return false;
            }
        });*/
