package alertaspa.com.mx.condominio;

import alertaspa.com.mx.condominio.beans.Registro;
import alertaspa.com.mx.condominio.databinding.ActivityEntradasBinding;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import alertaspa.com.mx.condominio.menus.backing.Menu;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;
import alertaspa.com.mx.condominio.plantillas.reglas.PruebaProgreso;

public class Entradas extends PlantillasFiltro implements DialogInterface.OnClickListener{ /*Se implementa la clase OnClickListener para poder realizar actividades en base a la respuesta de la alertta*/


    private Registro registro;
    private ActivityEntradasBinding binding;
    private AlertDialog alerta1; //Se declaran a este nivel cuando tenemos mas de una alerta para poder guardar la referencia y comparar en el evento onClic y asi poder ejhecutar las acciones necesarias
    private AlertDialog alerta2;

    public Registro getRegistro() {
        return registro;
    }

  public void setRegistro(Registro registro) {
    this.registro = registro;
  }

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //codigo herendando plantillas
      //prueba

      try {
          this.contenido.setLayoutResource(R.layout.activity_entradas);
          this.binding= DataBindingUtil.getBinding(this.bindingPlantilla.contenidoContenido.getViewStub().inflate());
          this.binding.setEntradas(this);
          //this.bindingPlantilla.plantillaCabecera.
          registro = new Registro("123","B","C","D","D",1,"A");
      }
      catch (Exception e){
        Log.e("Entradas",e.getMessage());
      }//try-except

       /*
       //Codigo sin heredar de plantillas
       try {
          binding = DataBindingUtil.setContentView(this,R.layout.activity_entradas);
          binding.setEntradas(this);
          registro = new Registro("123","B","C","D","D",1,"A");

        }
        catch (Exception e ){
          Log.e("Entradas",e.getMessage());
        }//try-catch*/


    }

    public void doAceptar(View view, String placa){
        //resultado.setText("El resultado es: "+placa.getText()+" "+marca.getText()+" "+color.getText());
        alerta2 = Utileria.mensajeConfirmacionDialog(this,"Entradas","¿Desea guardar la informacion?",this);
        alerta2.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar",null,this); //en listener se coloca la clase de donde se va a ejecutar el metodo onclic
        alerta2.show();
        registro=new Registro(placa,"VW Gol", "Gol","Plata","Condomino",27,"4491802140");
        this.binding.panelPlaca.setError("Longitud erronea");
        //this.binding.entradasModelo.setVisibility(View.GONE);
        //this.binding.entradasEstatus.setEnabled(false);
        this.binding.invalidateAll();
        Toast.makeText(this, this.registro.getPlacas(), Toast.LENGTH_LONG).show();
    }
    public void doNavegar(View view){
        try{
            Utileria.irPagina(this, Menu.class);
        }//  try
        catch (Exception e){
            Log.e("LoginNavegar", e.getMessage());
        }
    }

    @Override
    public void doOpcion1(View view) {
        super.doOpcion1(view);
        //Alerta
        try {
            alerta1 =Utileria.mensajeConfirmacionDialog(this,"Entradas","Mensaje de alerta desde clase entradas",this); //se  recupera el alertDialogo y se pueden asignar x botones
            alerta1.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar",null,this);
            alerta1.show();
        }
        catch (Exception e){
            Log.e("Plantillas filtro",e.getMessage());
        }//try-catch
    }

    @Override
    public void doOpcion2(View view) {
        super.doOpcion2(view);
    }

    @Override
    public void doOpcion3(View view) {
        PruebaProgreso incremento;
        try {
          incremento = new PruebaProgreso(this);
          incremento.execute();
        }
        catch (Exception e){
            Log.e("Entradas",e.getMessage());
        }
    }

    @Override
    public void doOpcion4(View view) {
        try {
            //Notificacione
            Utileria.addNotification("Notificacion","esta es una notificacion",R.drawable.error_vectori,this,this.getClass());
        }
        catch (Exception e){
            Log.e("Entradas",e.getMessage());
        }
    }

    @Override
    public void doOpcion5(View view) {
        super.doOpcion5(view);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        //Metodo que se sobreescribe de la interfaz onClicListener
        if(dialog.equals(alerta1) ){
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    Log.d("Entradas","alerta1 aceptar");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Log.d("Entradas","alerta1 cancelar");
                    break;
            } //switch

        } //if
        else if(dialog.equals(alerta2) ){
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    Log.d("Entradas","alerta2 aceptar");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Log.d("Entradas","alerta2 cancelar");
                    break;
            } //switch

        }// else

    }
}
