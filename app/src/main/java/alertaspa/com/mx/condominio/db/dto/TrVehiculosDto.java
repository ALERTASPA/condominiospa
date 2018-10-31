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
public class TrVehiculosDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_VEHICULO")
  private Long idVehiculo;
  @Property(nameInDb = "ID_MODELO")
  private Long idModelo;
  @Property(nameInDb = "PLACA")
  private String placa;
  @Property(nameInDb = "COLOR")
  private String color;
  @Property(nameInDb = "ID_CASA")
  private Long idCasa;

  @Generated
  public TrVehiculosDto() {
  }

  public TrVehiculosDto(Long idVehiculo) {
    this.idVehiculo = idVehiculo;
  }

  public TrVehiculosDto(Long idVehiculo, Long idModelo, String placa, String color, Long idCasa) {
    this.idVehiculo = idVehiculo;
    this.idModelo = idModelo;
    this.placa = placa;
    this.color = color;
    this.idCasa = idCasa;
  }

  public Long getIdVehiculo() {
    return idVehiculo;
  }

  public void setIdVehiculo(Long idVehiculo) {
    this.idVehiculo = idVehiculo;
  }


  public Long getIdModelo() {
    return idModelo;
  }

  public void setIdModelo(Long idModelo) {
    this.idModelo = idModelo;
  }


  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  public Long getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(Long idCasa) {
    this.idCasa = idCasa;
  }

  @Override
  public Long getKey() {
    return this.idVehiculo;
  }

  @Override
  public void setKey(Long key) {
    this.idVehiculo= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idVehiculo", this.idVehiculo);
    regresar.put("idModelo", this.idModelo);
    regresar.put("placa", this.placa);
    regresar.put("color", this.color);
    regresar.put("idCasa", this.idCasa);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdVehiculo()!= null && getIdVehiculo()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TrVehiculosDto.class;
  }

}

