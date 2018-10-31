package mx.org.dao.xml;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import mx.org.dao.comun.UtileriasDao;
import mx.org.dao.daofactory.R;
import mx.org.dao.libs.formato.Error;

/**
 * Created by CRISTOBAL.HERRERA on 05/04/2018.
 */

public final class Modulos {

  private static AssetManager assetMan;
  private static InputStream is;
  private static DocumentBuilderFactory factory;
  private static DocumentBuilder builder;
  private Document documento;
  private Context contexto;

  public Modulos(Context contexto) throws Exception{
    this.contexto = contexto;
  }

  /**
   * Metodo que realiza la carga del Envipe2018.db.xml de acuerdo al parametro recibido
   *
   * @param contexto contexto de la aplicacion
   * @param Archivo  archivo que se abrira
   * @return dom documento en formato dom
   */
  private Document cargarXML(Context contexto, String Archivo) {
    Document regresar= null;
    try {
      assetMan = contexto.getAssets();
      is = assetMan.open(Archivo);
      //DOM (Por ejemplo)
      factory = DocumentBuilderFactory.newInstance();
      builder = factory.newDocumentBuilder();
      regresar = builder.parse(is);
    } // try
    catch (Exception e) {
      Error.mensaje(e);
    } // catch
    return regresar;
  }  //cargarXML

  /**

   */
  public Document toBuild() throws Exception{
    Document regresar= null;
    boolean  inicia  = true;
    try {
      for (String item: getModulos()) {
        if (inicia) {
          this.documento = cargarXML(contexto, item);
          inicia= false;
        } // if
        else {
          regresar= cargarXML(contexto, item);
          loadElements(regresar, "dml", "/base/dml/unit");
        } // else
      } // for
      regresar= this.documento;
    } // try
    catch (Exception e) {
      Error.mensaje(e);
      throw e;
    } // catch
    return regresar;
  } // toBuild

  private List<String> getModulos(){
    List<String> regresar = null;
    try{
      regresar=new ArrayList<>();
      regresar.add(UtileriasDao.getRutasDao().getMensajes());
      regresar.add(UtileriasDao.getRutasDao().getVistas());
      regresar.add(UtileriasDao.getRutasDao().getSentencias());
    } // try
    catch (Exception e) {
      Error.mensaje(e);
      throw e;
    } // catch
    return regresar;
  } // getModulos


  private void loadElements(Document dmls, String key, String children) {
    try {
      XPath xpath   = XPathFactory.newInstance().newXPath();
      NodeList items= (NodeList) xpath.evaluate(children, dmls, XPathConstants.NODESET);
      if (items!= null && items.getLength()> 0) {
        Element first = getFirstElement(key);
        Log.i("Modulos.loadElements","Inicializando "+ items.getLength() + " ".concat(key));
        for (int x= 0; x < items.getLength(); x++) {
          first.appendChild(this.documento.importNode(items.item(x), true));
        } // for x
      } // if
    } // try
    catch (Exception e) {
      Error.mensaje(e);
    } // catch
  } //loadElements

  private Element getFirstElement(String key) {
    Element regresar = null;
    try {
      NodeList items = this.documento.getElementsByTagName(key);
      if (items.getLength() > 0) {
        Log.d("Modulos.getFirstElement","key element [".concat(key).concat("] ").concat(items.item(0).getNodeName()));
        regresar = (Element) items.item(0);
      } // for x
    } // try
    catch (Exception e) {
      Error.mensaje(e);
    } // catch
    return regresar;
  } //getFirstElement

}
