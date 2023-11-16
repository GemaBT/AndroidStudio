

package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup miRadioG;
    ImageView miImagen;
    CheckBox limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miRadioG = (RadioGroup) findViewById(R.id.radioGroup);
        miImagen = (ImageView) findViewById(R.id.imageView);
        limpiar = (CheckBox) findViewById(R.id.checkBox);

        miRadioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.Id1) {
                    // Lógica para el caso Id1
                    miImagen.setImageResource(R.drawable.aire);
                } else if (checkedId == R.id.id2) {
                    // Lógica para el caso Id2
                    miImagen.setImageResource(R.drawable.tierra);
                } else if (checkedId == R.id.id3) {
                    // Lógica para el caso Id3
                    miImagen.setImageResource(R.drawable.agua);
                }
            }
        });

        limpiar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    miRadioG.clearCheck();
                    miImagen.setImageResource(R.drawable.i);
                    limpiar.toggle();
                }
            }
        });
    }
}