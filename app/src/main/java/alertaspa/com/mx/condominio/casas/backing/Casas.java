package alertaspa.com.mx.condominio.casas.backing;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.casas.reglas.Transaccion;
import alertaspa.com.mx.condominio.databinding.ActivityCasasBinding;
import alertaspa.com.mx.condominio.db.dto.TcCasasDto;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;
import mx.org.dao.db.enums.EAccion;

public class Casas extends PlantillasFiltro {

  private ActivityCasasBinding binding;
  private TcCasasDto tcCasasDto;

  public TcCasasDto getTcCasasDto() {
    return tcCasasDto;
  }

  public void setTcCasasDto(TcCasasDto tcCasasDto) {
    this.tcCasasDto = tcCasasDto;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //codigo herendando plantillas
    try {
      tcCasasDto= new TcCasasDto();
      this.contenido.setLayoutResource(R.layout.activity_casas);
      this.binding=DataBindingUtil.getBinding(this.bindingPlantilla.contenidoContenido.getViewStub().inflate());
      this.binding.setCasas(this);
    }
    catch (Exception e){
      Log.e("Casas",e.getMessage());
    }//try-except
  }

  @Override
  public void doAceptar(View view) {
    Transaccion transaccion= null;
    try{
      transaccion= new Transaccion(this.tcCasasDto);
      if (transaccion.ejecutar(EAccion.AGREGAR))
        Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_LONG).show();
    } // try
    catch (Exception e){
      Log.e("Casas.Doaceptar",e.getMessage());
    }// catch

  }
}
