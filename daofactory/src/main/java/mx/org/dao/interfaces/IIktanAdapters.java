package mx.org.dao.interfaces;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Map;


public interface IIktanAdapters extends OnItemSelectedListener {

  ViewDataBinding getBinding();
  Map<String, Object> getAttrs();
  void onItemSelectedLista(AdapterView<?> parent, View view, int position, long id);

}
