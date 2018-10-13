package alertaspa.com.mx.condominio;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import alertaspa.com.mx.condominio.menus.backing.Menu;
import mx.org.dao.beans.RutasDao;
import mx.org.dao.comun.UtileriasDao;

public class Login extends AppCompatActivity {

    private static final String[] permissions = new String[]{
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        /*checando permisos*/
        for (int i =0; i<permissions.length-1;i++) {
            int permissionCheck = ContextCompat.checkSelfPermission(this,  permissions[i]);
            if (ContextCompat.checkSelfPermission(this,  permissions[i])   != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {

                } //if
            }//if
        }//for
        ActivityCompat.requestPermissions(this, permissions, 101);
        /*fin*/
        setContentView(R.layout.activity_login);
        UtileriasDao.setAppContext(this.getApplicationContext());
        UtileriasDao.setRutasDao(new RutasDao(this.getString(R.string.vistas), this.getString(R.string.sentencias),this.getString(R.string.mensajes),this.getString(R.string.bd_name),this.getString(R.string.trabajo_modelo),this.getString(R.string.modelo_assets)));
        UtileriasDao.copyDatabase();
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
