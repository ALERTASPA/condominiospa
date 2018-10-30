package mx.org.dao.beans;

/**
 * @author Cristobal Herrera Gallegos <cristobal.herrera@inegi.org.mx>.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
 * @date 12/10/2018.
 * @time 11:42 PM
 */

public class RutasDao {
  private String vistas;
  private String sentencias;
  private String mensajes;
  private String bdName;
  private String trabajoBd;
  private String bdAssets;

  public RutasDao(String vistas, String sentencias, String mensajes, String bdName, String trabajoBd, String bdAssets) {
    this.vistas = vistas;
    this.sentencias = sentencias;
    this.mensajes = mensajes;
    this.bdName = bdName;
    this.trabajoBd = trabajoBd;
    this.bdAssets = bdAssets;
  }

  public String getBdAssets() {
    return bdAssets;
  }

  public String getVistas() {
    return vistas;
  }

  public String getSentencias() {
    return sentencias;
  }

  public String getMensajes() {
    return mensajes;
  }

  public String getBdName() {
    return bdName;
  }

  public String getTrabajoBd() {
    return trabajoBd;
  }
}
