package mx.org.dao.libs.adaptadores;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import mx.org.dao.comun.UtileriasDao;
import mx.org.dao.db.comun.dto.IBaseDto;
import mx.org.dao.db.comun.sql.Entity;
import mx.org.dao.interfaces.IIktanAdapters;
import mx.org.dao.libs.reflection.Methods;


public class UIList {
  private IIktanAdapters activity;
  private String idRecyclerView;
  private int idXmlItem;
  private RecyclerView recyclerView;
  private ListAdapter adapter= null;
  private List<? extends IBaseDto> lista;


  public UIList(int idXmlItem, RecyclerView recyclerView, List<? extends IBaseDto> lista, IIktanAdapters activity) throws Exception{
    this.idXmlItem = idXmlItem;
    this.recyclerView = recyclerView;
    this.lista = lista;
    this.activity = activity;
    build();
  }

  private void build() throws Exception {
    try {
      initLista();
      adapter= new ListAdapter(this.lista, this.idXmlItem, this.recyclerView, this.activity);
      this.recyclerView.setAdapter(adapter);
    } // try
    catch(Exception e){
      Log.e("build", e.getMessage());
      throw e;
    } // catch
  } // build

  public void initLista() throws Exception{
    try{
      //this.recyclerView= (RecyclerView) Methods.getAttributeValue(this.activity.getBinding(), this.idRecyclerView);
      this.recyclerView.setLayoutManager(new LinearLayoutManager(UtileriasDao.getAppContext()));
      this.recyclerView.setItemAnimator(new DefaultItemAnimator());
      this.recyclerView.addItemDecoration(new DividerItemDecoration(UtileriasDao.getAppContext(), LinearLayoutManager.VERTICAL));
    } // try
    catch (Exception e){
      Log.e("initLista", e.getMessage());
      throw e;
    } // catch
  } // initLista
  

  public void update() throws Exception{
    this.adapter.notifyDataSetChanged();
  }
  

}
