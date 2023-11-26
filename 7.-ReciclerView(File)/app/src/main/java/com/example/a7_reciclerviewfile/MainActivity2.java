package com.example.a7_reciclerviewfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ImageView image;
    TextView text;
    ScrollView scrolltext;
    List<JSONObject> listaJSON = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listaJSON = cargarListaArchivo();
        initViews();
        initValues();
    }


    private List<JSONObject> cargarListaArchivo() {
        List<JSONObject> listaJSON = new ArrayList<>();
        String nombreArchivo = "datos.json";

        try {
            FileInputStream fileInputStream = openFileInput(nombreArchivo);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                stringBuilder.append(linea).append("\n");
            }

            fileInputStream.close();

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                listaJSON.add(jsonObject);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return listaJSON;
    }
    private void initViews(){
        image = findViewById(R.id.imageView2);
        text = findViewById(R.id.textView3);
        scrolltext = findViewById(R.id.scrollView);
    }

    private void initValues(){
        if (getIntent().hasExtra("Detalle")){
            Item item = (Item) getIntent().getExtras().getSerializable("Detalle");
            if (item != null){
                image.setImageResource(item.getImage());
                String nombreBuscado = item.getName();
                for (JSONObject jsonObject : listaJSON) {
                    try {
                        String nombre = jsonObject.getString("nombre");
                        if (nombre.equalsIgnoreCase(nombreBuscado)) {
                            text.setText(jsonObject.getString("descripcion"));
                            // scrolltext.setMovementMethod(new ScrollingMovementMethod());
                            break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}