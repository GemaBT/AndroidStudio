package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    TextView textView, text;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Relativelayout");



        image = findViewById(R.id.imageView3);
        text = findViewById(R.id.textView5);
        initValues();
    }


    private void initValues() {
        if (getIntent().hasExtra("Detalle")) {
            Item item = (Item) getIntent().getExtras().getSerializable("Detalle");
            if (item != null) {
                image.setImageResource(item.getImage());
                text.setText(item.getName());
            }
        }
    }
}
