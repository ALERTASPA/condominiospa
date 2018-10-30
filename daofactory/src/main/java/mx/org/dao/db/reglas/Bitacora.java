package mx.org.dao.db.reglas;

import org.greenrobot.greendao.internal.TableStatements;

import java.util.HashMap;
import java.util.Map;

import mx.org.dao.db.enums.ESql;
import mx.org.dao.db.enums.ETiposBitacoras;
import mx.org.dao.libs.formato.Error;
import mx.org.dao.xml.Dml;

/**
 * @author Cristobal Herrera Gallegos <cristobal.herrera@inegi.org.mx>.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
 * @date 13/07/2018.
 * @time 10:53 AM
 */

public class Bitacora {

  private static Long idGenerico;
  private static ETiposBitacoras tipoBitacora;
  private static ESql tipoSentencia;
  private static String sentencia;
  private static Map<Integer, Object> attrs;
  private static Object mutex;

  static {
    mutex = new Object();
  }

  public static ETiposBitacoras getTipoBitacora() {
    return tipoBitacora;
  }

  public static void setTiposBitacora(ETiposBitacoras tipoBitacora) {
    Bitacora.tipoBitacora = tipoBitacora;
  }

  public static ESql getTipoSentencia() {
    return tipoSentencia;
  }

  public static void setTipoSentencia(ESql tipoSentencia) {
    Bitacora.tipoSentencia = tipoSentencia;
  }

  public static String getSentencia() {
    return sentencia;
  }

  public static Long getIdGenerico() {
    return idGenerico;
  }

  public static Map<Integer, Object> getInstanceAttrs() {
    synchronized (mutex) {
      if (attrs == null) {
        try  {
          attrs = new HashMap<>();
        } // try
        catch (Exception e)  {
          Error.mensaje(e);
        } // catch
      } // if
    }
    return attrs;
  }

  public static ETiposBitacoras especifica(Long idGenerico){
    Bitacora.idGenerico= idGenerico;
    return ETiposBitacoras.ESPECIFICA;
  } //especifica

  public static ETiposBitacoras general(){
    Bitacora.idGenerico= null;
    return ETiposBitacoras.GENERAL;
  } // general

  public static ETiposBitacoras sinBitacora(){
    Bitacora.idGenerico= null;
    return ETiposBitacoras.SIN_BITACORA;
  } // general

  public static void cleanAttrs(){
    if (attrs!=null)
      attrs.clear();
  }

  public static void setStatement(TableStatements statement){
    try {
      switch (Bitacora.getTipoSentencia()) {
        case INSERT:
          sentencia = statement.getInsertStatement().getRawStatement().toString();
          break;
        case UPDATE:
          sentencia = statement.getUpdateStatement().getRawStatement().toString();
          break;
        case DELETE:
          sentencia = statement.getDeleteStatement().getRawStatement().toString();
          break;
        case UPSERT:
          sentencia = statement.getInsertOrReplaceStatement().getRawStatement().toString();
          break;
      } // switch
    } // try
    catch (Exception e)  {
      Error.mensaje(e);
    } // catch
  }




}
