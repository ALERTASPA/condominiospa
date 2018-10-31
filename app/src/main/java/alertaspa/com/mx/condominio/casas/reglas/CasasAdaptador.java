package alertaspa.com.mx.condominio.casas.reglas;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.databinding.CasasFiltroItemBinding;
import alertaspa.com.mx.condominio.db.dto.TcCasasDto;

public class CasasAdaptador extends BaseAdapter {
  private List<TcCasasDto> casas;
  private Activity activity;

  public CasasAdaptador(List<TcCasasDto> casas, Activity activity) {
    this.casas = casas;
    this.activity = activity;
  }

  @Override
  public int getCount() {
    return this.casas.size();
  }

  @Override
  public Object getItem(int position) {
    return this.casas.get(position);
  }

  @Override
  public long getItemId(int position) {
    return this.casas.get(position).getKey();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View regresar                 = null;
    CasasFiltroItemBinding binding= null;
    try{
      if(convertView == null) {
        convertView = LayoutInflater.from(this.activity).inflate(R.layout.casas_filtro_item, null);
        binding= DataBindingUtil.bind(convertView);
      } // if
      else
        binding= (CasasFiltroItemBinding) convertView.getTag();
      binding.setRow(this.casas.get(position));
      regresar= binding.getRoot();
    } // try
    catch(Exception e){
      Log.e("CasasAdaptador.getView", e.getMessage());
    } // catch
    return regresar;
  }
}
