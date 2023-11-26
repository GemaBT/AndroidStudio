package com.example.a7_reciclerviewfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView imageToolBar, imageDown;
    TextView textViewToolBar, textViewDown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageToolBar = (ImageView) findViewById(R.id.imageView);
        textViewToolBar = (TextView) findViewById(R.id.textView);

        imageDown = findViewById(R.id.imageView3);
        textViewDown = findViewById(R.id.textView2);

        //textViewToolBar.setText("TU HÉROE FAVORITO");

        RecyclerView miReciclerView = findViewById(R.id.idReciclerView);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Spider Man", R.drawable.spider));
        items.add(new Item("Thor", R.drawable.tor));
        items.add(new Item("Iron Man", R.drawable.iroman));
        items.add(new Item("Hulk", R.drawable.hulk));
        items.add(new Item("Capitana Marvell", R.drawable.capitana));
        items.add(new Item("Capitán América", R.drawable.capitan));
        items.add(new Item("Black Panter", R.drawable.blackpanter));
        items.add(new Item("Spider Man", R.drawable.spider));
        items.add(new Item("Thor", R.drawable.tor));
        items.add(new Item("Iron Man", R.drawable.iroman));
        items.add(new Item("Hulk", R.drawable.hulk));
        items.add(new Item("Capitana Marvell", R.drawable.capitana));
        items.add(new Item("Capitán América", R.drawable.capitan));
        items.add(new Item("Black Panter", R.drawable.blackpanter));


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


    /*
    public void cargarFichero(){
        //JSONObject jsonObject = new JSONObject();


        //image.setImageResource(jsonObject.get);
        //listaJSON.add(jsonObject);


        try {
             BufferedReader reader = new BufferedReader(new FileReader("ruta_del_archivo.json"));
             JSONObject gson = new JSONObject();
             JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

                    // Ahora tienes un array de objetos JSON (jsonArray)
                    // Puedes trabajar con él según tus necesidades

                    // Por ejemplo, puedes imprimir cada objeto JSON del array
                    for (int i = 0; i < jsonArray.size(); i++) {
                        System.out.println(jsonArray.get(i));
                    }

                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
*/
    public void describir (Item elem) {
        //Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
        imageDown.setImageResource(elem.getImage());
        textViewDown.setText(elem.getName());
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("Detalle", elem);
        startActivity(i);
    }


}