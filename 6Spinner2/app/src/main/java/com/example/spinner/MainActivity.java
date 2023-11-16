package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView textView;
    // 1. Datos
    String[] datos = {"Selecciona una opción","Opción 1", "Opción 2", "Opción 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datos);

        // 2. Adaptador
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 3. Configurar el Spinner
        spinner.setAdapter(adapter);

        // 4. Manejar Eventos (opcional)
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Acciones cuando se selecciona un elemento
                String seleccion = (String) parentView.getItemAtPosition(position);
               if (position != 0){
                   textView.setText("Se ha seleccionado la opción " +seleccion);
               }
               else{
                   textView.setText("");
               }
            }

            public void onNothingSelected(AdapterView<?> parentView) {
                // acciones si no se selecciona
            }
        });
    }
}









