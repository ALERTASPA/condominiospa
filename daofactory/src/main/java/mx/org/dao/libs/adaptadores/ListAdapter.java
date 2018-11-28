package mx.org.dao.libs.adaptadores;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;
import mx.org.dao.db.comun.dto.IBaseDto;
import mx.org.dao.interfaces.IIktanAdapters;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AdapterView.OnItemSelectedListener {

  private List<? extends IBaseDto> lista;
  private int itemXml;
  private RecyclerView recyclerView;
  private IIktanAdapters activity;

  public ListAdapter(List<? extends IBaseDto> lista, int itemXml, RecyclerView recyclerView,IIktanAdapters activity) {
    this.lista = lista;
    this.itemXml = itemXml;
    this.recyclerView = recyclerView;
    this.activity = activity;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding bindingItem   = null;
    LayoutInflater inflater       = null;
    BaseViewHolder regresar       = null;
    try {
      inflater = LayoutInflater.from(parent.getContext());
      bindingItem = DataBindingUtil.inflate(inflater, itemXml, parent, false);
      regresar= new BaseViewHolder(bindingItem);
    } //try
    catch (Exception e){
      Log.e("onCreateViewHolder", e.getMessage());
    }
    return regresar;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    IBaseDto item               = null;
    BaseViewHolder holderItem   = null;
    try {
      item = (IBaseDto) this.lista.get(position);
      holderItem = (BaseViewHolder) viewHolder;
      holderItem.bind(item, "Row", this.recyclerView, this, this.activity);
    } // try
    catch (Exception e){
      Log.e("onBindViewHolder", e.getMessage());
    }
  }

  @Override
  public int getItemCount() {
    int regresar=0;
    try{
      regresar= this.lista.size();
    }
    catch (Exception e){
      Log.e("getItemCount", e.getMessage());
    }
    return regresar;
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    this.activity.onItemSelected(parent, view, position, id);
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {

  }

  @Override
  public long getItemId(int position) {
    return this.lista.get(position).getKey();
  }
}
