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
public class TcTipoVisitantesDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_TIPO_VISITANTE")
  private Long idTipoVisitante;
  @Property(nameInDb = "DESCRIPCION")
  private String descripcion;

  @Generated
  public TcTipoVisitantesDto() {
  }

  public TcTipoVisitantesDto(Long idTipoVisitante) {
    this.idTipoVisitante = idTipoVisitante;
  }

  public TcTipoVisitantesDto(Long idTipoVisitante, String descripcion) {
    this.idTipoVisitante = idTipoVisitante;
    this.descripcion = descripcion;
  }

  public Long getIdTipoVisitante() {
    return idTipoVisitante;
  }

  public void setIdTipoVisitante(Long idTipoVisitante) {
    this.idTipoVisitante = idTipoVisitante;
  }


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public Long getKey() {
    return this.idTipoVisitante;
  }

  @Override
  public void setKey(Long key) {
    this.idTipoVisitante= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idTipoVisitante", this.idTipoVisitante);
    regresar.put("descripcion", this.descripcion);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdTipoVisitante()!= null && getIdTipoVisitante()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TcTipoVisitantesDto.class;
  }

}

