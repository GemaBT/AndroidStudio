package com.example.mynuevoproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
ImageView image;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
        initValues();
    }

    private void initViews(){
        image = findViewById(R.id.imageView2);
        text = findViewById(R.id.textView3);
    }

    private void initValues(){
        if (getIntent().hasExtra("Detalle")){
            Item item = (Item) getIntent().getExtras().getSerializable("Detalle");
            if (item != null){
                image.setImageResource(item.getImage());
                text.setText(item.getName());
            }
        }
    }

   /* public void anterior(View view){
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
    }*/
}