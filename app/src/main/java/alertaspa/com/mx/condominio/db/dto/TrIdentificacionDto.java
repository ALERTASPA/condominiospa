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
public class TrIdentificacionDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_IDENTIFICACION")
  private Long idIdentificacion;
  @Property(nameInDb = "RUTA")
  private String ruta;
  @Property(nameInDb = "NOMBRE")
  private String nombre;

  @Generated
  public TrIdentificacionDto() {
  }

  public TrIdentificacionDto(Long idIdentificacion) {
    this.idIdentificacion = idIdentificacion;
  }

  public TrIdentificacionDto(Long idIdentificacion, String ruta, String nombre) {
    this.idIdentificacion = idIdentificacion;
    this.ruta = ruta;
    this.nombre = nombre;
  }

  public Long getIdIdentificacion() {
    return idIdentificacion;
  }

  public void setIdIdentificacion(Long idIdentificacion) {
    this.idIdentificacion = idIdentificacion;
  }


  public String getRuta() {
    return ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public Long getKey() {
    return this.idIdentificacion;
  }

  @Override
  public void setKey(Long key) {
    this.idIdentificacion= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idIdentificacion", this.idIdentificacion);
    regresar.put("ruta", this.ruta);
    regresar.put("nombre", this.nombre);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdIdentificacion()!= null && getIdIdentificacion()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TrIdentificacionDto.class;
  }

}

