package alertaspa.com.mx.condominio.db.dto;
/**
 * @author Autogenerado.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
*/
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import mx.org.dao.libs.reflection.Methods;
import mx.org.dao.db.comun.dto.IBaseDto;

@Entity
public class TrVisitasDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_VISITA")
  private Long idVisita;
  @Property(nameInDb = "ID_TIPO_ACCESO")
  private Long idTipoAcceso;
  @Property(nameInDb = "REGISTRO")
  private String registro;
  @Property(nameInDb = "ID_IDENTIFICACION")
  private Long idIdentificacion;
  @Property(nameInDb = "ID_VEHICULO")
  private Long idVehiculo;
  @Property(nameInDb = "ID_CASA")
  private Long idCasa;
  @Property(nameInDb = "ACOMPANANTES")
  private Long acompanantes;
  @Property(nameInDb = "ID_TIPO_VISITANTE")
  private Long idTipoVisitante;
  @Property(nameInDb = "NOMBRE")
  private String nombre;
  @Property(nameInDb = "ID_TIPO_SERVICIO")
  private Long idTipoServicio;
  @Property(nameInDb = "OBSERVACIONES")
  private String observaciones;

  @Generated
  public TrVisitasDto() {
  }

  public TrVisitasDto(Long idVisita) {
    this.idVisita = idVisita;
  }

  public TrVisitasDto(Long idVisita, Long idTipoAcceso, String registro, Long idIdentificacion, Long idVehiculo, Long idCasa, Long acompanantes, Long idTipoVisitante, String nombre, Long idTipoServicio, String observaciones) {
    this.idVisita = idVisita;
    this.idTipoAcceso = idTipoAcceso;
    this.registro = registro;
    this.idIdentificacion = idIdentificacion;
    this.idVehiculo = idVehiculo;
    this.idCasa = idCasa;
    this.acompanantes = acompanantes;
    this.idTipoVisitante = idTipoVisitante;
    this.nombre = nombre;
    this.idTipoServicio = idTipoServicio;
    this.observaciones = observaciones;
  }

  public Long getIdVisita() {
    return idVisita;
  }

  public void setIdVisita(Long idVisita) {
    this.idVisita = idVisita;
  }


  public Long getIdTipoAcceso() {
    return idTipoAcceso;
  }

  public void setIdTipoAcceso(Long idTipoAcceso) {
    this.idTipoAcceso = idTipoAcceso;
  }


  public String getRegistro() {
    return registro;
  }

  public void setRegistro(String registro) {
    this.registro = registro;
  }


  public Long getIdIdentificacion() {
    return idIdentificacion;
  }

  public void setIdIdentificacion(Long idIdentificacion) {
    this.idIdentificacion = idIdentificacion;
  }


  public Long getIdVehiculo() {
    return idVehiculo;
  }

  public void setIdVehiculo(Long idVehiculo) {
    this.idVehiculo = idVehiculo;
  }


  public Long getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(Long idCasa) {
    this.idCasa = idCasa;
  }


  public Long getAcompanantes() {
    return acompanantes;
  }

  public void setAcompanantes(Long acompanantes) {
    this.acompanantes = acompanantes;
  }


  public Long getIdTipoVisitante() {
    return idTipoVisitante;
  }

  public void setIdTipoVisitante(Long idTipoVisitante) {
    this.idTipoVisitante = idTipoVisitante;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public Long getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(Long idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
  }


  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  @Override
  public Long getKey() {
    return this.idVisita;
  }

  @Override
  public void setKey(Long key) {
    this.idVisita= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idVisita", this.idVisita);
    regresar.put("idTipoAcceso", this.idTipoAcceso);
    regresar.put("registro", this.registro);
    regresar.put("idIdentificacion", this.idIdentificacion);
    regresar.put("idVehiculo", this.idVehiculo);
    regresar.put("idCasa", this.idCasa);
    regresar.put("acompanantes", this.acompanantes);
    regresar.put("idTipoVisitante", this.idTipoVisitante);
    regresar.put("nombre", this.nombre);
    regresar.put("idTipoServicio", this.idTipoServicio);
    regresar.put("observaciones", this.observaciones);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdVisita()!= null && getIdVisita()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TrVisitasDto.class;
  }

}

