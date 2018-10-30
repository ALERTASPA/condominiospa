package mx.org.dao.comun;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import mx.org.dao.beans.RutasDao;

/**
 * @author Cristobal Herrera Gallegos <cristobal.herrera@inegi.org.mx>.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
 * @date 05/10/2018.
 * @time 04:51 PM
 */

public class UtileriasDao {
  static Context appContext;
  static RutasDao rutasDao;

  public static Context getAppContext() {
    return appContext;
  }

  public static void setAppContext(Context appContext) {
    UtileriasDao.appContext = appContext;
  }

  public static RutasDao getRutasDao() {
    return rutasDao;
  }

  public static void setRutasDao(RutasDao rutasDao) {
    UtileriasDao.rutasDao = rutasDao;
  }

  public static void copyDatabase() {
    copyDatabase(false);
  }

  public static void copyDatabase(boolean override) {
    File baseDatos          = null;
    InputStream in          = null;
    OutputStream out        = null;
    String filename         = null;
    String directorioSalida = null;
    File archivoSalida      = null;
    try{
      filename = rutasDao.getBdName().concat(".sys");
      baseDatos = new File(Environment.getExternalStorageDirectory().toString().concat(rutasDao.getTrabajoBd()));
      if (!baseDatos.exists() || override){
        //	AndroidUtilities.addToast("inicializando la configuracion de system app");
				/*if (!baseDatos.exists())
					AndroidUtilities.makeSystemApp();*/

        //	AndroidUtilities.addToast("finalizando configuracion de system app");
        //in = UtileriasDao.getAppContext().getAssets().open(ERutas.MODELO_ASSETS.getRuta());
        in = UtileriasDao.getAppContext().getAssets().open(rutasDao.getBdAssets().concat(filename));
        directorioSalida = Environment.getExternalStorageDirectory().toString().concat(rutasDao.getTrabajoBd());
        archivoSalida = new File(directorioSalida, filename);
        baseDatos.mkdirs();
        out = new FileOutputStream(archivoSalida);
        copyFile(in, out);
        in.close();
        in = null;
        out.flush();
        out.close();
        out = null;
      } // if
    } // try
    catch(Exception e){
      Log.d("copyDB",e.getMessage());
    } // catch
  }


  public static void copyFile(InputStream in, OutputStream out) throws Exception{
    try{
      byte[] buffer = new byte[1024];
      int read;
      while((read = in.read(buffer)) != -1){
        out.write(buffer, 0, read);
      } // while
    } // try
    catch(Exception e){
      throw e;
    } // catch
  }


}
