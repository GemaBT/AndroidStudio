package com.example.imagenybottonview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class MiFragmento extends DialogFragment {

    public MiFragmento() {
    }

    public interface OnTerminarLlamadaListener {
        void onTerminarLlamada();
    }

    private OnTerminarLlamadaListener terminarLlamadaListener;

    public void setOnTerminarLlamadaListener(OnTerminarLlamadaListener listener) {
        this.terminarLlamadaListener = listener;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.mi_fragmento, null);

        builder.setView(view)
                .setTitle("Llamada en curso")
                .setPositiveButton("TERMINAR", (dialog, which) -> {
                    // Acciones a realizar al hacer clic en "TERMINAR"
                   terminarLlamadaListener.onTerminarLlamada();
                });

        return builder.create();
    }
}