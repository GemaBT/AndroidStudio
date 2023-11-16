package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView textView, textViewDown;
    ImageView imageDown;
    @Override
    //Usamos el TollBar con RelativeLayout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Relativelayout");
        imageDown = findViewById(R.id.imageView3);
        textViewDown = findViewById(R.id.textView2);

        //textViewToolBar.setText("TU HÉROE FAVORITO");

        RecyclerView miReciclerView = findViewById(R.id.idReciclerView);

        List<Item> items = new ArrayList<>();
        items.add(new Item("SpiderMan", R.drawable.spider));
        items.add(new Item("Tor", R.drawable.tor));
        items.add(new Item("IronMan", R.drawable.iroman));
        items.add(new Item("Hulk", R.drawable.hulk));
        items.add(new Item("Capitana Marvell", R.drawable.capitana));
        items.add(new Item("Capitan América", R.drawable.capitan));
        items.add(new Item("BlackPanter", R.drawable.blackpanter));


        miReciclerView.setLayoutManager(new LinearLayoutManager(this));
        //miReciclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
        //para el evneto
        miReciclerView.setAdapter(new MyAdapter(getApplicationContext(), items, new MyAdapter.OnClickListener() {
            @Override
            public void pulsar(Item item) {
                describir(item);
            }
        }));
    }

    public void describir (Item elem) {
        //Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
        imageDown.setImageResource(elem.getImage());
        textViewDown.setText(elem.getName());
        Intent i = new Intent(this, MainActivity5.class);
        i.putExtra("Detalle", elem);
        startActivity(i);
    }


}