package mx.org.dao.db.enums;

/**
 * @author Cristobal Herrera Gallegos <cristobal.herrera@inegi.org.mx>.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
 * @date 24/07/2018.
 * @time 10:19 AM
 */

public enum EEtapaDesarrollo {

  DESARROLLO (1l, "DS", "DESARROLLO"),
  PRUEBAS    (2l, "PU", "PRUEBAS"),
  CAPACITACION(3L, "CA", "CAPACITACION"),
  PRODUCCION  (4L, "PO", "PRODUCCION");

  private Long idKey;
  private String acronimo;
  private String etapa;

  EEtapaDesarrollo(Long idKey, String acronimo, String etapa) {
    this.idKey = idKey;
    this.acronimo = acronimo;
    this.etapa = etapa;
  }

  public Long getIdKey() {
    return idKey;
  }

  public String getAcronimo() {
    return acronimo;
  }

	public String getEtapa() {
		return etapa;
	}
}
