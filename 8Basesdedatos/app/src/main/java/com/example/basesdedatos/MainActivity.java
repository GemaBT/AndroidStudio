package com.example.basesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
MyBaseDatos bd;
EditText codigoT, nombreT, descrpciopnT;
TextView textV;
MyBaseDatos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigoT = (EditText) findViewById(R.id.textView);
        nombreT = (EditText) findViewById(R.id.textView2);
        descrpciopnT = (EditText) findViewById(R.id.textView3);

        textV = (TextView) findViewById(R.id.textView4);
        //deleteDatabase("Base de Datos");


    }

    public void pulsarBoton(View view) {
        db = new MyBaseDatos(getApplicationContext(), "Base de datos", null, 1);
        SQLiteDatabase baseD = db.getWritableDatabase();

        String cod = codigoT.getText().toString();
        String nomb = nombreT.getText().toString();
        String desc = descrpciopnT.getText().toString();

        if (!cod.isEmpty() && !nomb.isEmpty() && !desc.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", cod);
            registro.put("nombre", nomb);
            registro.put("descripcion", desc);

            baseD.insert("MiTabla", null, registro);
            baseD.close();
            codigoT.setText("");
            nombreT.setText("");
            descrpciopnT.setText("");
            textV.setText("");
            Toast.makeText(getApplicationContext(), "Registo ok", Toast.LENGTH_LONG).show();
        }
    }

    public void consultar(View view){
        db = new MyBaseDatos(getApplicationContext(), "Base de datos", null, 1);
        SQLiteDatabase baseD = db.getReadableDatabase();

        String cod = codigoT.getText().toString();
        if (!cod.isEmpty()) {
           Cursor fila = baseD.rawQuery("select nombre, descripcion from MiTabla where codigo =" + cod, null);
           if (fila.moveToFirst()){
               nombreT.setText(fila.getString(0));
               descrpciopnT.setText((fila.getString(1)));
               baseD.close();
           } else{
               Toast.makeText(this,"no existe el articulo", Toast.LENGTH_LONG).show();
           }
        }
        else{
           Toast.makeText(this, "Debes introducir un valor en el código", Toast.LENGTH_LONG).show();
        }


    }

    public void mostrarTodo(View view){
        db = new MyBaseDatos(getApplicationContext(), "Base de datos", null, 1);
        SQLiteDatabase baseD = db.getReadableDatabase();



        String registro = "";
            Cursor fila = baseD.rawQuery("select codigo, nombre, descripcion from MiTabla", null);
            Toast.makeText(this, "por aqui", Toast.LENGTH_LONG).show();
            if (fila != null) {
                    if (fila.moveToFirst()) {
                        do {
                            registro = registro + "Codigo: " + (fila.getString(0)) + "Nombre: " + (fila.getString(1)) +
                                    "Descripción: " + (fila.getString(2)+"\n");
                        } while (fila.moveToNext());
                    }

            }
        fila.close();
        baseD.close();
        textV.setText(registro);
     }
    public void limpiar_campos(View view){
        codigoT.setText("");
        nombreT.setText("");
        descrpciopnT.setText("");
        textV.setText("");
    }

    public void vaciarBaseDatos(View view){
         db = new MyBaseDatos(getApplicationContext(), "Base de datos", null, 1);
         SQLiteDatabase baseD = db.getWritableDatabase();
         String tabla = "MiTabla";
         baseD.execSQL("DELETE FROM "+ tabla);
         baseD.close();
        textV.setText("");


    }
}