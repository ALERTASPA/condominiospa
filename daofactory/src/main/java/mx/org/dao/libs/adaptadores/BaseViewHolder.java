package mx.org.dao.libs.adaptadores;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.Map;

import mx.org.dao.db.comun.dto.IBaseDto;
import mx.org.dao.libs.reflection.Methods;


public class BaseViewHolder extends RecyclerView.ViewHolder {

  private ViewDataBinding viewDataBinding;

  public BaseViewHolder(ViewDataBinding viewDataBinding) {
    super(viewDataBinding.getRoot());
    this.viewDataBinding = viewDataBinding;
  }

  public void bind(@NonNull final Object clase , ListAdapter listAdapter) throws Exception{
    bind(clase, clase.getClass().getSimpleName(), null, listAdapter);
  }

  public void bind(@NonNull final Object clase, String name, final RecyclerView recyclerView,  final ListAdapter listAdapter) throws Exception{
    try {
      Methods.execute(this.viewDataBinding, "set" + name, new Class[]{clase.getClass()}, new Object[]{clase});
      /*if (clase instanceof IBaseDto) {
        this.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            buildListener(v, clase, filtro, recyclerView, false);
          } // onClick
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
            buildListener(v, clase, filtro, recyclerView, true);
            return true;
          }
        });
      } // */
      this.viewDataBinding.executePendingBindings();
    } // try
    catch(Exception e){
     throw e;
    }
  }




  /* private void buildListener(View view, @NonNull final Object clase, final IIktanAdapters filtro, RecyclerView recyclerView, Boolean isLongClic){
    String evento= null;
    try {
      if (recyclerView.getTag()!=null) {
        if (((Map) recyclerView.getTag()).containsKey("nameIdKey"))
          filtro.getAttrs().put((String) ((Map) recyclerView.getTag()).get("nameIdKey"), ((IBaseDto) clase).getKey());
        evento= ((Map) recyclerView.getTag()).containsKey("nameEvent")? (String) ((Map) recyclerView.getTag()).get("nameEvent"): "doSelect";
        Methods.execute(filtro, evento, new Class[]{Entity.class, View.class, ViewDataBinding.class, Boolean.class}, new Object[]{(Entity) clase, view, this.viewDataBinding, isLongClic});
      } // if
      else
        Methods.execute(filtro, "doSelect", new Class[]{Entity.class, View.class, ViewDataBinding.class, Boolean.class}, new Object[]{(Entity) clase, view, this.viewDataBinding, isLongClic});
    } // try
    catch(Exception e){
      Error.mensaje(e);
    }
  } // buldListener*/

}