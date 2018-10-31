package alertaspa.com.mx.condominio;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import alertaspa.com.mx.condominio.databinding.ActivityResidentesBinding;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;

public class Residentes extends PlantillasFiltro {

  private ActivityResidentesBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //codigo herendando plantillas
    try {
      this.contenido.setLayoutResource(R.layout.activity_residentes);
      this.binding=DataBindingUtil.getBinding(this.bindingPlantilla.contenidoContenido.getViewStub().inflate());
      this.binding.setResidentes(this);
    }
    catch (Exception e){
      Log.e("Residentes",e.getMessage());
    }//try-except
  }
}
