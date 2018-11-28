package mx.org.dao.libs.adaptadores;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import mx.org.dao.db.comun.dto.IBaseDto;
import mx.org.dao.interfaces.IIktanAdapters;
import mx.org.dao.libs.reflection.Methods;


public class BaseViewHolder extends RecyclerView.ViewHolder {

  private ViewDataBinding viewDataBinding;

  public BaseViewHolder(ViewDataBinding viewDataBinding) {
    super(viewDataBinding.getRoot());
    this.viewDataBinding = viewDataBinding;
  }

  public void bind(@NonNull final Object clase, String name, final RecyclerView recyclerView, final ListAdapter listAdapter, final IIktanAdapters activity) throws Exception{
    try {
      Methods.execute(this.viewDataBinding, "set" + name, new Class[]{clase.getClass()}, new Object[]{clase});
      this.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          activity.doSelect((IBaseDto) clase, v, viewDataBinding, false);
        } // onClick
      });
      this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
          activity.doSelect((IBaseDto) clase, v, viewDataBinding, true);
          return true;
        }
      });
      this.viewDataBinding.executePendingBindings();
    } // try
    catch(Exception e){
      throw e;
    }
  }



}