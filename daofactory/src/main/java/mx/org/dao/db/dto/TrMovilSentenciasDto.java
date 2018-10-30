package mx.org.dao.db.dto;
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
public class TrMovilSentenciasDto implements IBaseDto, Serializable {
  @Id
  @Property(nameInDb = "ID_MOVIL_SENTENCIA")
  private Long idMovilSentencia;
  @Property(nameInDb = "ID_MOVIL_TIPO_ACCION")
  private Long idMovilTipoAccion;
  @Property(nameInDb = "ID_MOVIL_ENVIO_WEB")
  private Long idMovilEnvioWeb;
  @Property(nameInDb = "ID_MOVIL_ESTATUS_ENVIO")
  private Long idMovilEstatusEnvio;
  @Property(nameInDb = "NUM_EMP")
  private String numEmp;
  @Property(nameInDb = "SQL")
  private String sql;
  @Property(nameInDb = "REGISTRO")
  private String registro;
  @Property(nameInDb = "VERSION")
  private String version;
  @Property(nameInDb = "ID_GENERICO")
  private Long idGenerico;

  @Generated
  public TrMovilSentenciasDto() {
  }

  public TrMovilSentenciasDto(Long idMovilSentencia) {
    this.idMovilSentencia = idMovilSentencia;
  }

  public TrMovilSentenciasDto(Long idMovilSentencia, Long idMovilTipoAccion, Long idMovilEnvioWeb, Long idMovilEstatusEnvio, String numEmp, String sql, String registro, String version, Long idGenerico) {
    this.idMovilSentencia = idMovilSentencia;
    this.idMovilTipoAccion = idMovilTipoAccion;
    this.idMovilEnvioWeb = idMovilEnvioWeb;
    this.idMovilEstatusEnvio = idMovilEstatusEnvio;
    this.numEmp = numEmp;
    this.sql = sql;
    this.registro = registro;
    this.version = version;
    this.idGenerico = idGenerico;
  }

  public Long getIdMovilSentencia() {
    return idMovilSentencia;
  }

  public void setIdMovilSentencia(Long idMovilSentencia) {
    this.idMovilSentencia = idMovilSentencia;
  }


  public Long getIdMovilTipoAccion() {
    return idMovilTipoAccion;
  }

  public void setIdMovilTipoAccion(Long idMovilTipoAccion) {
    this.idMovilTipoAccion = idMovilTipoAccion;
  }


  public Long getIdMovilEnvioWeb() {
    return idMovilEnvioWeb;
  }

  public void setIdMovilEnvioWeb(Long idMovilEnvioWeb) {
    this.idMovilEnvioWeb = idMovilEnvioWeb;
  }


  public Long getIdMovilEstatusEnvio() {
    return idMovilEstatusEnvio;
  }

  public void setIdMovilEstatusEnvio(Long idMovilEstatusEnvio) {
    this.idMovilEstatusEnvio = idMovilEstatusEnvio;
  }


  public String getNumEmp() {
    return numEmp;
  }

  public void setNumEmp(String numEmp) {
    this.numEmp = numEmp;
  }


  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }


  public String getRegistro() {
    return registro;
  }

  public void setRegistro(String registro) {
    this.registro = registro;
  }


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  public Long getIdGenerico() {
    return idGenerico;
  }

  public void setIdGenerico(Long idGenerico) {
    this.idGenerico = idGenerico;
  }

  @Override
  public Long getKey() {
    return this.idMovilSentencia;
  }

  @Override
  public void setKey(Long key) {
    this.idMovilSentencia= key;
  }

  @Override
  public Map<String, Object> toMap() {
    Map <String,Object> regresar= new HashMap();
    regresar.put("idMovilSentencia", this.idMovilSentencia);
    regresar.put("idMovilTipoAccion", this.idMovilTipoAccion);
    regresar.put("idMovilEnvioWeb", this.idMovilEnvioWeb);
    regresar.put("idMovilEstatusEnvio", this.idMovilEstatusEnvio);
    regresar.put("numEmp", this.numEmp);
    regresar.put("sql", this.sql);
    regresar.put("registro", this.registro);
    regresar.put("version", this.version);
    regresar.put("idGenerico", this.idGenerico);
    return regresar;
  }

  @Override
  public boolean isValid() {
    return getIdMovilSentencia()!= null && getIdMovilSentencia()!= -1L;
  }

  @Override
  public Object toValue(String name) {
    return Methods.getValue(this, name);
  }

  @Override
  public Class toHbmClass() {
    return  TrMovilSentenciasDto.class;
  }

}

