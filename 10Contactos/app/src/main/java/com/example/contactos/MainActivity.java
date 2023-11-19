package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class    MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;

    private Button bGuardar, bBuscar, bLimpiar;
    private List<JSONObject> listaJSON;
    private String nombreArchivo = "datos.json";

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        editText1 = (EditText) findViewById(R.id.editTextTextMultiLine);
        editText2 = (EditText) findViewById(R.id.editTextTextMultiLine2);

        bGuardar = (Button) findViewById(R.id.button1);
        bBuscar = (Button) findViewById(R.id.button2);
        bLimpiar = (Button) findViewById(R.id.button3);

        listaJSON = cargarListaArchivo();
    }

    /*
     * Abre el archivo datos.json y lo vuelca en una lista de Json.
     */

    private List<JSONObject> cargarListaArchivo() {
        List<JSONObject> listaJSON = new ArrayList<>();
        //String nombreArchivo = "datos.json";

        try {
            FileInputStream fileInputStream = openFileInput(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                JSONObject jsonObject = new JSONObject(linea);
                listaJSON.add(jsonObject);
            }

            fileInputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return listaJSON;
    }

    /*
     * Crea un objeto JSon y lo añade a la lista y lo guardamos en el fichero. Limpiamos los campos.
     */

    public void guardarRegistro(View view) {
        String nombre = editText1.getText().toString();
        String datos = editText2.getText().toString();

        // Crear un nuevo objeto JSON con los valores obtenidos
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre", nombre);
            jsonObject.put("datos", datos);

            try {
                FileOutputStream fileOutputStream = openFileOutput(nombreArchivo, Context.MODE_APPEND);
                fileOutputStream.write(jsonObject.toString().getBytes());
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        listaJSON.add(jsonObject);
        editText1.setText("");
        editText2.setText("");

    }

    /*
    * Botón limpiar que limpia los campos de los Editext.
     */
    public void limpiar(View view) {
        editText1.setText("");
        editText2.setText("");
    }

    public void buscar_JSON(View view) {
        String nombreBuscado = editText1.getText().toString();
        for (JSONObject jsonObject : listaJSON) {
            try {
                String nombre = jsonObject.getString("nombre");

                if (nombre.equalsIgnoreCase(nombreBuscado)) {
                    editText2.setText(jsonObject.getString("datos"));
                    break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}












 /*
  * openFileOutput abre un archivo para escritura en el almacenamiento interno de la aplicación. El modo Context.MODE_APPEND indica que los datos se agregarán al final del archivo si este existe.
  * jsonObject.toString().getBytes() convierte el objeto JSON a una cadena de texto y luego a un array de bytes para poder escribirlo en el archivo.
  * fileOutputStream.write("\n".getBytes()) añade una línea nueva después de cada objeto JSON para separarlos en el archivo si se agregan varios.
  * Este código abrirá (o creará, si no existe) el archivo "datos.json" en el almacenamiento interno de tu aplicación y agregará el objeto JSON al final del archivo.
  */
   /*No le usamos porque al final decidimos guaradrlo en fichero cada vez que añadimos un nuevo objeto JSON a la lista.
    public void guardarDatosFichero (View view){

   // String nombreArchivo = "datos.json";

        try {
            deleteFile(nombreArchivo);
            FileOutputStream fileOutputStream = openFileOutput(nombreArchivo, Context.MODE_APPEND);
            for (JSONObject jsonObject : listaJSON) {
                fileOutputStream.write(jsonObject.toString().getBytes());
                fileOutputStream.write("\n".getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*Comentarios
    Para eliminar un elemento específico de una lista en Java, puedes utilizar el método remove() proporcionando el índice del elemento que deseas eliminar o el propio objeto que deseas quitar de la lista. Aquí te muestro ejemplos de ambos enfoques:

    Tienes una lista llamada listaJson que contiene objetos JSONObject y deseas eliminar un objeto en particular de esta lista.

    // Suponiendo que quieres eliminar el objeto en el índice 2
    int indiceAEliminar = 2;
    listaJson.remove(indiceAEliminar);
    */





