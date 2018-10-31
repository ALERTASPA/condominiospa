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
public class TrResidentesDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_RESIDENTE")
  private Long idResidente;
  @Property(nameInDb = "ID_CASA")
  private Long idCasa;
  @Property(nameInDb = "NOMBRE")
  private String nombre;

  @Generated
  public TrResidentesDto() {
  }

  public TrResidentesDto(Long idResidente) {
    this.idResidente = idResidente;
  }

  public TrResidentesDto(Long idResidente, Long idCasa, String nombre) {
    this.idResidente = idResidente;
    this.idCasa = idCasa;
    this.nombre = nombre;
  }

  public Long getIdResidente() {
    return idResidente;
  }

  public void setIdResidente(Long idResidente) {
    this.idResidente = idResidente;
  }


  public Long getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(Long idCasa) {
    this.idCasa = idCasa;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public Long getKey() {
    return this.idResidente;
  }

  @Override
  public void setKey(Long key) {
    this.idResidente= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idResidente", this.idResidente);
    regresar.put("idCasa", this.idCasa);
    regresar.put("nombre", this.nombre);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdResidente()!= null && getIdResidente()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TrResidentesDto.class;
  }

}

