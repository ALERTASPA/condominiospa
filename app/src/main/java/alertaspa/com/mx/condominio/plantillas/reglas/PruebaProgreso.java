package alertaspa.com.mx.condominio.plantillas.reglas;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.Utileria;
import alertaspa.com.mx.condominio.libs.activity.Bloqueo;
import alertaspa.com.mx.condominio.menus.backing.Menu;

public class PruebaProgreso extends Bloqueo {
  public PruebaProgreso(Context actividad){
    this.contexto = actividad;
  }

  @Override
  protected Object doInBackground(Object... objects) {
    int total;
    int paso;
    paso = 1;
    total=70;
    try{
    for (int i =0;i<total;i++) {
      Thread.sleep(30);
      this.progressDialog.setMax(total);
      switch (i) {
        case 30: paso=2;
          break;
        case 60: paso=3;
          break;

      }
      this.updateDialog("Procesando ... paso 3/"+paso, i);
    }//for
    } // try
    catch(Exception e){
      Log.e("Hilo",e.getMessage());
    } // catch
    return null;
  }

  @Override
  protected void onPostExecute(Object o) {
    AlertDialog prueba1;

    super.onPostExecute(o);
    prueba1 = Utileria.mensajeConfirmacionDialog(contexto,"Prueba de mensaje", "Esta es una prueba del tipo de confirmación");
    prueba1.show();
    Utileria.addNotification("Para qué sirve?", "Prueba de notificación 2",R.drawable.fatal_vectori,contexto, Menu.class);
  }

  @Override
  protected boolean isProgressBar(){
    return true;
  } // isProgressBar

}
