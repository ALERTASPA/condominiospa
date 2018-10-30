package mx.org.dao.libs.formato;

import android.util.Log;

import java.text.MessageFormat;

/**
 * Created by CRISTOBAL.HERRERA on 05/04/2018.
 */

public final class Error {


  private Error() {
  }

  public static String getPaquete(Object objeto)  {
    return objeto.getClass().getPackage().getName();
  }

  public static String getDominio(Object objeto)  {
    return objeto.getClass().getSimpleName();
  }

  public static String getNombre(Object objeto)  {
    return objeto.getClass().getName();
  }

  public static String getMensaje(Object objeto)  {
    return "[".concat(getNombre(objeto)).concat(".{0}] Error: {1}");
  }

  public static String getMensaje(Object objeto, Object ... valores)  {
    return MessageFormat.format(getMensaje(objeto), valores);
  }

  public static void mensaje(Object objeto, Throwable exception, Object ... valores)  {
    // if (Configuracion.getInstance().getPropiedad("sistema.log.error.".concat(Configuracion.getInstance().getPropiedad("sistema.servidor"))).equals("si")){
    Log.e(getNombre(objeto),exception.getMessage()==null?"":exception.getMessage());
    //} // if
  }

  public static String getMensaje() {
    return "[{0}.{1}] Error: {2}";
  }

  public static void mensaje(Throwable exception, String propio)  {
    Log.e(propio,exception.getMessage()==null?"":exception.getMessage());
    //} // if
  }

  public static void mensaje(Throwable exception)  {
    mensaje(exception, "");
  }

  public static void notificar(Throwable exception, String propio)  {
    Log.getStackTraceString(exception);
    Log.e(propio,exception.getMessage()==null?"":exception.getMessage());
  }

}
