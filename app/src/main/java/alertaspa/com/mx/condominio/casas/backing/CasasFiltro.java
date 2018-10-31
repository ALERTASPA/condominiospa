package alertaspa.com.mx.condominio.casas.backing;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Map;

import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.casas.reglas.CasasAdaptador;
import alertaspa.com.mx.condominio.databinding.CasasFiltroBinding;
import alertaspa.com.mx.condominio.db.dto.TcCasasDto;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;
import mx.org.dao.db.reglas.DaoFactory;

public class CasasFiltro extends PlantillasFiltro {

  private CasasFiltroBinding binding;
  private String numero;

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    try {
      super.onCreate(savedInstanceState);//codigo herendando plantillas
      this.contenido.setLayoutResource(R.layout.casas_filtro);
      this.binding=DataBindingUtil.getBinding(this.bindingPlantilla.contenidoContenido.getViewStub().inflate());
      this.binding.setCasasFiltro(this);
      doLoad();
    }
    catch (Exception e){
      Log.e("CasasFiltro.OnCreate",e.getMessage());
    }//try-except

  }

  public void doLoad() {
    CasasAdaptador casasAdaptador= null;
    List<TcCasasDto> casas       = null;
    //codigo herendando plantillas
    try {
      this.attrs.put("condicion", "1=1");
      casas= (List<TcCasasDto>) DaoFactory.getInstance().toEntitySet(TcCasasDto.class, "TcCasasDto","all", this.attrs);
      casasAdaptador= new CasasAdaptador(casas, this);
      this.binding.casaFiltroLista.setAdapter(casasAdaptador);
    }
    catch (Exception e){
      Log.e("Residentes",e.getMessage());
    }//try-except
  }
}
