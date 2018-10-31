package alertaspa.com.mx.condominio.plantillas.backing;

import alertaspa.com.mx.condominio.Entradas;
import alertaspa.com.mx.condominio.Login;
import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.Utileria;
import alertaspa.com.mx.condominio.camara.CamaraAccion;
import alertaspa.com.mx.condominio.databinding.PlantillasFiltroBinding;
import alertaspa.com.mx.condominio.plantillas.reglas.Hilo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;

import org.slf4j.helpers.Util;

import java.util.HashMap;
import java.util.Map;

public class PlantillasFiltro extends AppCompatActivity {

  protected PlantillasFiltroBinding bindingPlantilla;
  protected ViewStub contenido;

  protected Map<String,Object> attrs;

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }

    public Map<String, Object> getAttrs() {
      return attrs;
   }


    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try{
    //  setContentView(R.layout.principal_bienvenida);
      this.bindingPlantilla = DataBindingUtil.setContentView(this,R.layout.plantillas_filtro);
      this.contenido= bindingPlantilla.contenidoContenido.getViewStub();
      bindingPlantilla.setPlantillasFiltro(this);
      this.attrs = new HashMap<String,Object>();
      this.attrs.put("titulo","Pagina de ejemplo");
    } // try
    catch (Exception e){
      Log.e("Errores",e.getMessage());
    } // catch

  }

  public void doOpcion1(View view){

  }

  public void doOpcion2(View view) {
      //Progreso
      Hilo hilo = null;
      try {
          hilo = new Hilo(this);
          hilo.execute();
      } catch (Exception e) {
            Log.e("PlantillasFiltro",e.getMessage());
      }//try-except

  }

  public void doOpcion3(View view){

  }

  public void doOpcion4(View view){
        //notificaciones
  }

  public void doOpcion5(View view){
        try {
            Toast.makeText(this,"Opcion1",Toast.LENGTH_LONG).show();
            Utileria.irPagina(this,Login.class);
        } catch (Exception e) {
            Log.e("PlantillasFiltro",e.getMessage());
        }//try-catch
    }

    public void doOpcion6(View view){
        try {
            Utileria.irPagina(this,CamaraAccion.class);
        } catch (Exception e) {
            Log.e("PlantillasFiltro",e.getMessage());
        }//try-catch
    }

    public void doAceptar(View view){
        try {
            Log.d("PlantillasFiltro","doAceptar");
        } catch (Exception e) {
            Log.e("PlantillasFiltro",e.getMessage());
        }//try-catch
    }


  public void doMenuLateral(View view){
    this.bindingPlantilla.lateralDrawerLayout.openDrawer(Gravity.LEFT);
  }

}
