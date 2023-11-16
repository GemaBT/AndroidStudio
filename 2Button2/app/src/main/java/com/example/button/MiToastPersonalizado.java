package com.example.button;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MiToastPersonalizado {
    public static void mostrarMensaje(Context context, String message, int durationMillis) {
        // Inflar el diseño personalizado
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);

        // Configurar el mensaje en el diseño
        TextView textView = view.findViewById(R.id.customToastMessage);
        textView.setText(message);

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();

        // Cancelar el Toast después de la duración especificada
       new android.os.Handler().postDelayed(() -> toast.cancel(), durationMillis);
    }
}

