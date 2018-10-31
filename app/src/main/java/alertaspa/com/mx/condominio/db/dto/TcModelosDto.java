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
public class TcModelosDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_MODELO")
  private Long idModelo;
  @Property(nameInDb = "ID_MARCA")
  private Long idMarca;
  @Property(nameInDb = "DESCRIPCION")
  private String descripcion;

  @Generated
  public TcModelosDto() {
  }

  public TcModelosDto(Long idModelo) {
    this.idModelo = idModelo;
  }

  public TcModelosDto(Long idModelo, Long idMarca, String descripcion) {
    this.idModelo = idModelo;
    this.idMarca = idMarca;
    this.descripcion = descripcion;
  }

  public Long getIdModelo() {
    return idModelo;
  }

  public void setIdModelo(Long idModelo) {
    this.idModelo = idModelo;
  }


  public Long getIdMarca() {
    return idMarca;
  }

  public void setIdMarca(Long idMarca) {
    this.idMarca = idMarca;
  }


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public Long getKey() {
    return this.idModelo;
  }

  @Override
  public void setKey(Long key) {
    this.idModelo= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idModelo", this.idModelo);
    regresar.put("idMarca", this.idMarca);
    regresar.put("descripcion", this.descripcion);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdModelo()!= null && getIdModelo()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TcModelosDto.class;
  }

}

