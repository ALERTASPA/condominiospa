package alertaspa.com.mx.condominio.residentes.backing;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.beans.Registro;

import alertaspa.com.mx.condominio.databinding.ActivityResidentesBinding;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;

public class ResidentesFiltro extends PlantillasFiltro {
  private String nombre;
  //private  binding;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //codigo herendando plantillas
    try {
    /*  this.contenido.setLayoutResource(R.layout.activity_residentes_filtro);
      this.binding= DataBindingUtil.getBinding(this.bindingPlantilla.contenidoContenido.getViewStub().inflate());
      this.binding.setResidentesFiltro(this);
      this.nombre="Cris";*/
    }
    catch (Exception e){
      Log.e("Entradas",e.getMessage());
    }//try-except
  }
}
