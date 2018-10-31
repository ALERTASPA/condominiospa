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
public class TcTiposAccesoDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_TIPO_ACCESO")
  private Long idTipoAcceso;
  @Property(nameInDb = "DESCRIPCION")
  private String descripcion;

  @Generated
  public TcTiposAccesoDto() {
  }

  public TcTiposAccesoDto(Long idTipoAcceso) {
    this.idTipoAcceso = idTipoAcceso;
  }

  public TcTiposAccesoDto(Long idTipoAcceso, String descripcion) {
    this.idTipoAcceso = idTipoAcceso;
    this.descripcion = descripcion;
  }

  public Long getIdTipoAcceso() {
    return idTipoAcceso;
  }

  public void setIdTipoAcceso(Long idTipoAcceso) {
    this.idTipoAcceso = idTipoAcceso;
  }


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public Long getKey() {
    return this.idTipoAcceso;
  }

  @Override
  public void setKey(Long key) {
    this.idTipoAcceso= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idTipoAcceso", this.idTipoAcceso);
    regresar.put("descripcion", this.descripcion);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdTipoAcceso()!= null && getIdTipoAcceso()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TcTiposAccesoDto.class;
  }

}

