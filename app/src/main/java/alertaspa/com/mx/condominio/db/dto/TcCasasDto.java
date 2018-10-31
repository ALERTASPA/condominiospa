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
public class TcCasasDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_CASA")
  private Long idCasa;
  @Property(nameInDb = "INTERIOR")
  private String interior;
  @Property(nameInDb = "CALLE")
  private String calle;

  @Generated
  public TcCasasDto() {
  }

  public TcCasasDto(Long idCasa) {
    this.idCasa = idCasa;
  }

  public TcCasasDto(Long idCasa, String interior, String calle) {
    this.idCasa = idCasa;
    this.interior = interior;
    this.calle = calle;
  }

  public Long getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(Long idCasa) {
    this.idCasa = idCasa;
  }


  public String getInterior() {
    return interior;
  }

  public void setInterior(String interior) {
    this.interior = interior;
  }


  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  @Override
  public Long getKey() {
    return this.idCasa;
  }

  @Override
  public void setKey(Long key) {
    this.idCasa= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idCasa", this.idCasa);
    regresar.put("interior", this.interior);
    regresar.put("calle", this.calle);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdCasa()!= null && getIdCasa()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TcCasasDto.class;
  }

}

