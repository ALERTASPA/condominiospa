package mx.org.dao.libs.enums;

import mx.org.dao.libs.Constantes;
import mx.org.dao.libs.Constantes;
import mx.org.dao.libs.formato.Cadena;


/**
 * Fecha de creacion 06/04/2018.
 * Creaado por ANDRES.LARA.
 */

public enum ERutas  {

  MOVIL (Constantes.MOVIL, "Ruta para almacenar los archivos en memoria USB"),
  MOVIL_RESPALDOS(Constantes.MOVIL_RESPALDOS, "Ruta para los respaldos de iktan"),
  MOVIL_ENVIOS(Constantes.MOVIL_ENVIOS, "Ruta para los envios USB"),
  MOVIL_FOTOS(Constantes.MOVIL_FOTOS, "Ruta para los envios USB"),
  MOVIL_VERSIONES(Constantes.MOVIL_VERSIONES, "Ruta para las actualizaciones USB"),

  CLAVE_OPERATIVA(Constantes.TRABAJO_CLAVE_OPERATIVA, "Ruta de la clave operativa"),
  TRABAJO_CLAVE_OPERATIVA_RESPALDOS(Constantes.TRABAJO_CLAVE_OPERATIVA_RESPALDOS, "Ruta para los respaldos de iktan en la clave operativa"),
  TRABAJO_MODELO(Constantes.TRABAJO_MODELO, "Ruta para el modelo"),
  LOGS(Constantes.TRABAJO_LOGS, "Ruta para los LOGS"),
  LOGS_IKTAN(Constantes.TRABAJO_LOGS_IKTAN, "Ruta para LOGS de iktan"),
  LOGS_INTERPRETE(Constantes.TRABAJO_LOGS_INTERPRETE, "Ruta para los LOGS del interprete"),
  DESCARGAS(Constantes.IKTAN_DESCARGAS, "Ruta para las descargas de iktan"),

  IKTAN_ENVIOS(Constantes.IKTAN_ENVIOS, "Ruta para los envios de iktan"),
  IKTAN_ENVIOS_ZIP(Constantes.IKTAN_ENVIOS_ZIP, "Ruta para los zips que se enviaran desde iktan"),
  IKTAN_ENVIOS_TEMPORALES(Constantes.IKTAN_ENVIOS_TEMPORALES, "Ruta para los temporales de iktan que generaran los zips"),
  IKTAN_ENVIOS_TEMPORALES_SENTENCIAS (Constantes.IKTAN_ENVIOS_TEMPORALES.concat(Constantes.SENTENCIAS), "Ruta para los archivos .SYS y modelo que seran compactados"),
  IKTAN_ENVIOS_TEMPORALES_WEB (Constantes.IKTAN_ENVIOS_TEMPORALES.concat(Constantes.WEB), "Ruta para los archivos .SYS y modelo que seran compactados"),
  IKTAN_ENVIOS_TEMPORALES_ENVIOS (Constantes.IKTAN_ENVIOS_TEMPORALES.concat(Constantes.ENVIOS_LOCAL), "Ruta para los archivos .SYS y modelo que seran compactados"),


  IKTAN_CIERRES(Constantes.IKTAN_CIERRES, "Ruta archivos de cierre de iktan"),
  IKTAN_CIERRES_TEMPORALES(Constantes.IKTAN_CIERRES_TEMPORALES, "Ruta para los archivos temporales de los cierres de iktan"),

  IKTAN_RECURSOS(Constantes.IKTAN_RECURSOS, "Ruta para los recursos de iktan"),
  IKTAN_RECURSOS_IMAGENES(Constantes.IKTAN_RECURSOS_IMAGENES, "Ruta para las imagenes de iktan"),
  IKTAN_RECURSOS_DOCUMENTOS(Constantes.IKTAN_RECURSOS_DOCUMENTOS, "Ruta para los respaldos de iktan"),
  IKTAN_TRABAJO_MAPAS(Constantes.IKTAN_TRABAJO_MAPAS, "Ruta para el material cartográfico de iktan"),

  IKTAN_ACTUALIZACIONES(Constantes.IKTAN_ACTUALIZACIONES, "Ruta para las actualizaciones de iktan"),
  IKTAN_ACTUALIZACIONES_VERSIONES(Constantes.IKTAN_ACTUALIZACIONES_VERSIONES, "Ruta las versiones de los apk"),
  IKTAN_ACTUALIZACIONES_INSTALADORES(Constantes.IKTAN_ACTUALIZACIONES_INSTALADORES, "Ruta para los instaladores de iktan"),

  IKTAN_FOTOGRAFIAS(Constantes.IKTAN_FOTOGRAFIAS, "Ruta para las fotografias de iktan"),
  IKTAN_FOTOGRAFIAS_ZIP(Constantes.IKTAN_FOTOGRAFIAS_ZIP, "Ruta para los zips de las fotogragias de iktan"),
  IKTAN_FOTOGRAFIAS_TEMPORALES(Constantes.IKTAN_FOTOGRAFIAS_TEMPORALES, "Ruta para los temporales de las fotografias de iktan"),
  IKTAN_TRABAJO(Constantes.IKTAN_TRABAJO, "Ruta base de trabajo iktan");

  private String ruta;
  private String descripcion;


  private ERutas(String ruta, String descripcion) {
    this.ruta = ruta;
    this.descripcion = descripcion;
  }

  public String getRuta() {
    return ruta;
  }
}