package alertaspa.com.mx.condominio.menus.backing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import alertaspa.com.mx.condominio.Entradas;
import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.Utileria;
import alertaspa.com.mx.condominio.casas.backing.Casas;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void doirEntradas(View view) {
        try {
            Utileria.irPagina(this, Entradas.class);
        }//  try
        catch (Exception e) {
            Log.e("LoginNavegar", e.getMessage());
        }

    }

    public void doirCasas(View view) {
        try {
            Utileria.irPagina(this, Casas.class);
        }//  try
        catch (Exception e) {
            Log.e("LoginNavegar", e.getMessage());
        }

    }
}
