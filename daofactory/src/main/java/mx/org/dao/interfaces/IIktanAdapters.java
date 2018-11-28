package mx.org.dao.interfaces;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Map;

import mx.org.dao.db.comun.dto.IBaseDto;


public interface IIktanAdapters extends OnItemSelectedListener {

  ViewDataBinding getBinding();
  Map<String, Object> getAttrs();
  void doSelect(IBaseDto iBaseDto, View view, ViewDataBinding viewDataBinding, Boolean isLongClic);

}
