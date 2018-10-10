package alertaspa.com.mx.condominio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import alertaspa.com.mx.condominio.menus.backing.Menu;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        setContentView(R.layout.activity_login);
            Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
          Log.e("Login",e.getMessage());
        }
    }

    public void doirMenu(View view) {
        try {
            Utileria.irPagina(this, Menu.class);
        }//  try
        catch (Exception e) {
            Log.e("LoginNavegar", e.getMessage());
        }

    }
}
