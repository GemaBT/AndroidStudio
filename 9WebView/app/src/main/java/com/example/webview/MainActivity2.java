package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    WebView miVewview;
    private Button miBoton;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        miVewview = (WebView) findViewById(R.id.webV);
        miBoton = (Button) findViewById(R.id.button2);

        url = getIntent().getStringExtra("sitioweb");
        miVewview.setWebViewClient(new WebViewClient());
        //miVewview.setWebChromeClient(new WebChromeClient());
        //miVewview.loadUrl("https://" + url);
        miVewview.loadUrl(url);
    }

    public void cerrar(View view){
        finish();
    }
}







        /*miVewview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    // Verificar si el WebView tiene el foco
                    if (view.hasFocus()) {
                        // Tu lógica para manejar el evento de la tecla Intro aquí
                        // Por ejemplo, puedes realizar una acción específica cuando se presiona la tecla Intro
                        // Por ejemplo, para navegar hacia adelante o atrás en la historia del WebView:
                        if (miVewview.canGoBack()) {
                            miVewview.goBack();
                        } else {
                            miVewview.goForward();
                        }
                        return true; // Indicar que el evento ha sido manejado
                    }
                }
                return super.shouldOverrideKeyEvent(view, event);
            }
        });*/

