package mx.org.dao.xml;

import org.w3c.dom.Document;

import mx.org.dao.libs.Constantes;
import mx.org.dao.libs.formato.Cadena;
import mx.org.dao.comun.UtileriasDao;
import mx.org.dao.libs.Constantes;

import mx.org.dao.libs.formato.Cadena;
import mx.org.dao.libs.formato.Error;
import mx.org.dao.libs.formato.Variables;
import java.util.Map;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


/**
 * Created by CRISTOBAL.HERRERA on 01/04/2018.
 */

public class Dml {

  private static final String EXP_INI = "/base/dml/unit[@id='";
  private static final String INS_EXP = "']/insert[@id='";
  private static final String DEL_EXP = "']/delete[@id='";
  private static final String SEL_EXP = "']/select[@id='";
  private static final String MEN_EXP = "']/mensaje[@id='";
  private static final String MEN_TITULO = "']/mensaje[@title='";
  private static final String UPD_EXP = "']/update[@id='";
  private static Dml instance;
  private static Object mutex;
  private Document documento;

  private Dml() throws Exception {
    Modulos modulus= new Modulos(UtileriasDao.getAppContext());
    this.documento= modulus.toBuild();
    modulus= null;
  } // Dml


  static {
    mutex = new Object();
  }

  public static Dml getInstance() {
    synchronized (mutex) {
      if (instance == null) {
        try  {
          instance = new Dml();
        } // try
        catch (Exception e)  {
          Error.mensaje(e);
        } // catch
      } // if
    }
    return instance;
  }


  public String getDelete(String subModulo, String id, Map parametros) throws XPathExpressionException {
    return evaluate(EXP_INI.concat(subModulo).concat(DEL_EXP).concat(id).concat("']"), parametros);
  }

  public String getDelete(String subModulo, String id, String parametros, char token) throws XPathExpressionException {
    Variables variables= new Variables(parametros, token);
    return getDelete(subModulo, id, variables.getMap());
  }

  public String getDelete(String subModulo, String id, String parametros) throws XPathExpressionException {
    return getDelete(subModulo, id, parametros, Constantes.SEPARADOR.charAt(0));
  }

  public String getInsert(String subModulo, String id, Map parametros) throws XPathExpressionException {
    return evaluate(EXP_INI.concat(subModulo).concat(INS_EXP).concat(id).concat("']"), parametros);
  }

  public String getInsert(String subModulo, String id, String parametros, char token) throws XPathExpressionException {
    Variables variables= new Variables(parametros, token);
    return getInsert(subModulo, id, variables.getMap());
  }

  public String getInsert(String subModulo, String id, String parametros) throws XPathExpressionException {
    return getInsert(subModulo, id, parametros, Constantes.SEPARADOR.charAt(0));
  }

  public String getSelect(String subModulo, String id, Map parametros) throws XPathExpressionException {
    return evaluate(EXP_INI.concat(subModulo).concat(SEL_EXP).concat(id).concat("']"), parametros);
  }

  public String getSelect(String subModulo, String id, String parametros, char token) throws XPathExpressionException {
    Variables variables= new Variables(parametros, token);
    return getSelect(subModulo, id, variables.getMap());
  }

  public String getSelect(String subModulo, String id, String parametros) throws XPathExpressionException {
    return getSelect(subModulo, id, parametros, Constantes.SEPARADOR.charAt(0));
  }

  public String getUpdate(String subModulo, String id, Map parametros) throws XPathExpressionException {
    return evaluate(EXP_INI.concat(subModulo).concat(UPD_EXP).concat(id).concat("']"), parametros);
  }

  public String getUpdate(String subModulo, String id, String parametros, char token) throws XPathExpressionException {
    Variables variables= new Variables(parametros, token);
    return getUpdate(subModulo, id, variables.getMap());
  }

  public String getUpdate(String subModulo, String id, String parametros) throws XPathExpressionException {
    return getUpdate(subModulo, id, parametros, Constantes.SEPARADOR.charAt(0));
  }

  private String evaluate(String expresion, Map parametros) throws XPathExpressionException {
    String sql= command(expresion);
    if(sql.length()> 0) {
      sql= Cadena.replaceParams(sql, parametros);
      sql= sql.trim();
    } // if
    return sql;
  }

  public String selectSQL(String subModulo, String id) throws XPathExpressionException {
    return command(EXP_INI.concat(subModulo).concat(SEL_EXP).concat(id).concat("']"));
  }

  private String command(String expresion) throws XPathExpressionException {
    XPathFactory xPFabrica = XPathFactory.newInstance();
    XPath xPath = xPFabrica.newXPath();
    String sql  = xPath.evaluate(expresion, this.documento);
    if(sql== null)
      sql= "";
    return sql;
  }


  public String getMensaje(String subModulo, String id, Map parametros) throws XPathExpressionException {
    return evaluate(EXP_INI.concat(subModulo).concat(MEN_EXP).concat(id).concat("']"), parametros);
  }

  public String getMensaje(String subModulo, String id, String parametros, char token) throws XPathExpressionException {
    Variables variables= new Variables(parametros, token);
    return getMensaje(subModulo, id, variables.getMap());
  }

  public String getMensaje(String subModulo, String id, String parametros) throws XPathExpressionException {
    return getMensaje(subModulo, id, parametros, Constantes.SEPARADOR.charAt(0));
  }


  public String getTituloMensaje(String subModulo, String id, Map parametros) throws XPathExpressionException {
    return evaluate(EXP_INI.concat(subModulo).concat(MEN_TITULO).concat(id).concat("']"), parametros);
  }

  public String getTituloMensaje(String subModulo, String id, String parametros, char token) throws XPathExpressionException {
    Variables variables= new Variables(parametros, token);
    return getTituloMensaje(subModulo, id, variables.getMap());
  }

  public String getTituloMensaje(String subModulo, String id, String parametros) throws XPathExpressionException {
    return getTituloMensaje(subModulo, id, parametros, Constantes.SEPARADOR.charAt(0));
  }

}