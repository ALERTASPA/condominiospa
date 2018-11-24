package alertaspa.com.mx.condominio.casas.backing;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.Utileria;
import alertaspa.com.mx.condominio.databinding.CasasFiltroBinding;
import alertaspa.com.mx.condominio.db.dto.TcCasasDto;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;
import mx.org.dao.db.comun.sql.Entity;
import mx.org.dao.db.reglas.DaoFactory;
import mx.org.dao.libs.adaptadores.UIList;
import mx.org.dao.libs.reflection.Methods;

public class CasasFiltro extends PlantillasFiltro implements AdapterView.OnItemSelectedListener {

  private CasasFiltroBinding binding;
  private String numero;
  private List<String> calles;
  private UIList uiList;

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
      loadCombo();
      doLoad();
    }
    catch (Exception e){
      Log.e("CasasFiltro.OnCreate",e.getMessage());
    }//try-except

  }

  public void doLoad() {
    List<TcCasasDto> casas       = null;
    //codigo herendando plantillas
    try {
      if(calles.size()>0 && this.binding.calles.getSelectedItemId()>0)
        this.attrs.put("condicion", " calle = ".concat("'"+this.calles.get(this.binding.calles.getSelectedItemPosition())+"'"));
      else
        this.attrs.put("condicion", "1=1");
      casas= (List<TcCasasDto>) DaoFactory.getInstance().toEntitySet(TcCasasDto.class, "TcCasasDto","all", this.attrs);
      uiList= new UIList(R.layout.casas_filtro_item, this.binding.casaFiltroLista, casas, this);
    }
    catch (Exception e){
      Log.e("Residentes",e.getMessage());
    }//try-except
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    doLoad();
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {

  }

  public void doAgregar(View view){
    try {
      Utileria.irPagina(this, Casas.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void loadCombo(){
    List<Entity> callesBd = null;
    try{
      callesBd = DaoFactory.getInstance().toEntitySet("TcCasasDto","calles",attrs);
      calles = new ArrayList<>();
      calles.add("Seleccione");
      for (Entity item : callesBd)
        calles.add(item.get("calle").getData$());
      ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, calles);
      this.binding.calles.setAdapter(adaptador);
      this.binding.calles.setOnItemSelectedListener(this);
      this.binding.calles.setSelection(0);//Selecciona el primer elemento
    }
    catch (Exception e){
      Log.e("loadCombo", e.getMessage());
    }
    finally {
      Methods.clean(callesBd);
    } // finally
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();
    loadCombo();
    doLoad();
  }

  @Override
  public ViewDataBinding getBinding() {
    return this.binding;
  }

  @Override
  public void onItemSelectedLista(AdapterView<?> parent, View view, int position, long id) {
    Utileria.toast(this, "posicion: "+position+", idBD: "+id);
  }
}
