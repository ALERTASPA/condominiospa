package alertaspa.com.mx.condominio.db.dto;
/**
 * @author Autogenerado.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
*/
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import mx.org.dao.libs.reflection.Methods;
import mx.org.dao.db.comun.dto.IBaseDto;

@Entity
public class TcTiposServicioDto implements IBaseDto, Serializable {
  @Property(nameInDb = "ID_TIPO_SERVICIO")
  private Long idTipoServicio;
  @Property(nameInDb = "DESCRIPCION")
  private String descripcion;

  @Generated
  public TcTiposServicioDto() {
  }


  public TcTiposServicioDto(Long idTipoServicio, String descripcion) {
    this.idTipoServicio = idTipoServicio;
    this.descripcion = descripcion;
  }

  public Long getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(Long idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
  }


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public Long getKey() {
    return null;
  }

  @Override
  public void setKey(Long key) {

  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idTipoServicio", this.idTipoServicio);
    regresar.put("descripcion", this.descripcion);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return false;
  }


  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TcTiposServicioDto.class;
  }

}

