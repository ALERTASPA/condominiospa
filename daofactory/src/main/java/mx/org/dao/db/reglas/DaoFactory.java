package mx.org.dao.db.reglas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import org.greenrobot.greendao.AbstractDao;
import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.xpath.XPathExpressionException;

import mx.org.dao.db.reglas.transformer.TransformEntity;
import mx.org.dao.db.reglas.transformer.TransformSourceEntity;
import mx.org.dao.libs.Constantes;
import mx.org.dao.libs.formato.Cadena;
import mx.org.dao.xml.Dml;
import mx.org.dao.comun.UtileriasDao;
import mx.org.dao.daofactory.R;
import mx.org.dao.db.dto.TrMovilSentenciasDto;
import mx.org.dao.db.enums.ESql;
import mx.org.dao.db.enums.ETiposBitacoras;
import mx.org.dao.libs.formato.Error;
import mx.org.dao.libs.formato.Fecha;
import mx.org.dao.db.comun.dto.IBaseDto;
import mx.org.dao.db.comun.sql.Entity;
import mx.org.dao.db.comun.sql.Value;
import mx.org.dao.db.reglas.transformer.TransformDto;
import mx.org.dao.db.reglas.transformer.TransformEntity;
import mx.org.dao.db.reglas.transformer.TransformSourceEntity;
import mx.org.dao.db.reglas.transformer.Transformer;
import mx.org.dao.xml.Dml;
import mx.org.dao.libs.Constantes;
import mx.org.dao.libs.formato.Cadena;

public class DaoFactory<T extends IBaseDto> {
  static SQLiteDatabase database;
  private static DaoFactory instance;
  private static Object mutex;
  private DaoSession masterSession;

  /**
   * Inicialización de variable mutex
   */
  static {
    mutex = new Object();
  }

  /**
   * Contructor default
   */
  private DaoFactory() {
  }

  /**
   * Devuelve la instancia de la clase.
   *
   * #return Instancia de la clase.
   */

  public static DaoFactory getInstance(){
  	try{//UtileriasDao.getAppContext().getString(R.string.mensajes)
     // return DaoFactory.getInstance(Environment.getExternalStorageDirectory().toString().concat("/work/modelo/enco.sys"));
      return DaoFactory.getInstance(Environment.getExternalStorageDirectory().toString().concat(UtileriasDao.getRutasDao().getTrabajoBd()).concat(File.separator).concat(UtileriasDao.getRutasDao().getBdName()).concat(".sys"));
  	} // try
  	catch (Exception e){
  	  Error.mensaje(e);
  	} // catch
		return null;
	} // getInstance

  public static DaoFactory getInstance(String path) {
    try{
      synchronized (mutex) {
        if (instance== null) {
          instance= new DaoFactory();
          instance.getSession(path);
        }
      } // if
    } // try
    catch (Exception e){
      Error.mensaje(e);
      instance= null;
    } // catch
    return instance;
  } // getInstance

  private void getSession(String path) throws Exception{
    DaoMaster.DevOpenHelper masterHelper = new DaoMaster.DevOpenHelper(UtileriasDao.getAppContext(), path, null); //create database db file if not exist
    SQLiteDatabase db = masterHelper.getWritableDatabase();  //get the created database db file
    DaoMaster master = new DaoMaster(db);//create masterDao
    masterSession = master.newSession(); //Creates Session session
  } // getSession

  /**
   * Realiza una consulta a la tabla de la base de datos mapeada por la instancia "Class<IBaseDto>",
   * localizando un idKey dentro de ella y regresando ese registro.
   *
   * #param dto -> Clase dto que hace referencia a la tabla en la que se va a buscar
   * #param key -> Id a buscar en la tabla
   * #return T <IBaseDto> que contiene el registro obtenido. Si T == null el registro no se encontró.
   * #throws Exception
   */
  public T findById(Class<IBaseDto> dto, Long key) throws Exception {
    T regresar = null;
    try {
      regresar = (T) masterSession.getDao(dto).load(key);
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } // findById

  /**
   * Obtiene el valor del campo definido por "name" de una consulta sql.
   *
   * #param sql -> Sentencia sql que realizara consulta a la base de datos.
   * #param name -> Nombre del campo de la tabla, del que se extraerá el valor.
   * #return Value que contiene el valor del campo obtenido.
   * #throws Exception
   */
  public Value toField(String sql, String name) throws Exception {
    Value regresar = null;
    Entity entity = null;
    Object[] resultado = null;
    try {
      entity = (Entity) toEntity(sql);
      if (entity != null) {
        if (name != null) {
          if (entity.containsKey(name))
            regresar = entity.get(name);
          else
            throw new RuntimeException("El nombre del campo '".concat(name).concat("' no existe."));
        }  // if
        else {
          resultado = entity.values().toArray();
          regresar = (Value) resultado[0];
        } // else
      } // if
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  } // toField

  /**
   * Obtiene el valor del campo definido en la consulta sql, la cual devuelve un solo campo (el primero de la consulta).
   *
   * #param: sql -> Sentencia sql con un solo campo seleccionado.
   * #return: Value que contiene el valor del campo obtenido.
   * #throws: Exception
   */
  public Value toField(String sql) throws Exception {
    String name = null;
    return toField(sql, name);
  } // toField

  /**
   * Obtiene el valor del campo del registro devuelto por la consulta contenida en archivo xml, definida por el unit
   * "modulo" y el select por default (row) y que coincide con las condiciones descritas en "params". La consulta devolverá
   * el primer campo del select.
   *
   * #param: modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param: params -> Map que contiene los parametros a evaluar en la consulta.
   * #return: Value que contiene el valor del campo obtenido.
   * #throws: Exception
   */
  public Value toField(String modulo, Map<String, Object> params) throws Exception {
    return toField(modulo, Constantes.DML_SELECT, params, null);
  } // toField

  /**
   * Obtiene el valor del campo definido por "name" del registro devuelto por la consulta contenida en archivo xml,
   * definida por el unit "modulo" y el select por default (row) y que coincide con las condiciones descritas en
   * "params".
   *
   * #param: modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param: params -> Map que contiene los parametros a evaluar en la consulta.
   * #param: name -> Nombre del campo de la tabla, del que se extraerá el valor.
   * #return: Value que contiene el valor del campo obtenido.
   * #throws: Exception
   */
  public Value toField(String modulo, Map<String, Object> params, String name) throws Exception {
    return toField(modulo, Constantes.DML_SELECT, params, name);
  } // toField

  /**
   * Obtiene el valor del campo del registro devuelto por la consulta contenida en archivo xml, definida por el unit
   * "modulo" y select "idXml" y que coincide con las condiciones descritas en "params". La consulta devolverá
   * el primer campo del select.
   *
   * #param: modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param: idXml -> Id del select contenido en el unit definido por "modulo".
   * #param: params -> Map que contiene los parametros a evaluar en la consulta.
   * #return: Value que contiene el valor del campo obtenido.
   * #throws: Exception
   */
  public Value toField(String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toField(modulo, idXml, params, null);
  } // toField

  /**
   * Obtiene el valor del campo definido por "name" del registro devuelto por la consulta contenida en archivo xml,
   * definida por el unit "modulo" y select "idXml" y que coincide con las condiciones descritas en "params".
   *
   * #param: modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param: idXml -> Id del select contenido en el unit definido por "modulo".
   * #param: params -> Map que contiene los parametros a evaluar en la consulta.
   * #param: name -> Nombre del campo de la tabla, del que se extraerá el valor.
   * #return: Value que contiene el valor del campo obtenido.
   * #throws: Exception
   */
  public Value toField(String modulo, String idXml, Map<String, Object> params, String name) throws Exception {
    return toField(Dml.getInstance().getSelect(modulo, idXml, params), name);
  } // toField

  /**
   * Obtiene el registro definido por consulta sql.
   * Los nombres de los campos son renombrados a notación dromedario.
   *
   * #param sql -> Sentencia select de sql.
   * #return Entity que contiene el registro obtenido.
   * #throws Exception
   */
  public T toEntity(String sql) throws Exception {
    T regresar = null;
    List list = null;
    try {
      list = toRecordsEntity(sql, new TransformEntity());
      if (list != null && list.size() > 0) {
        regresar = (T) list.get(0);
      } // if
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  } // toEntity

  /**
   * Obtiene el registro devuelto por la consulta contenida en archivo xml, definida por el unit "modulo" y el select
   * por default (row) y que coincide con las condiciones descritas en "params". Los nombres de de los campos son
   * renombrados a notación dromedario.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return Entity que contiene el registro obtenido.
   * #throws Exception
   */
  public T toEntity(String modulo, Map<String, Object> params) throws Exception {
    return toEntity(modulo, Constantes.DML_SELECT, params);
  } // toEntity

  /**
   * Obtiene el registro devuelto por la consulta contenida en archivo xml, definida por el unit "modulo" y el select
   * "idXml" y que coincide con las condiciones descritas en "params". Los nombres de los campos son renombrados por
   * hibernate a notación dromedario.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return Entity que contiene el registro obtenido.
   * #throws Exception
   */
  public T toEntity(String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toEntity(Dml.getInstance().getSelect(modulo, idXml, params));
  } // toEntity

  /**
   * Obtiene el primer registro de la base de datoa definido por una instancia Class<IBaseDto>. y una consulta sql. Los
   * nombres de los campos son renombrados a notación dromedario.
   *
   * #param dto -> Instancia de IBaseDto que define el registro a obtener
   * #param sql -> String con consulta sql que define los parametros de busqueda
   * #return IBaseDto que contiene el registro obtenido.
   * #throws Exception
   */
  public T toEntity(Class<IBaseDto> dto, String sql) throws Exception {
    T regresar = null;
    List list = null;
    try {
      list = toRecordsEntity(sql, new TransformDto(dto));
      if (list != null && list.size() > 0) {
        regresar = (T) list.get(0);
      } // if
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  } // toEntity

  /**
   * Obtiene el registro definido por una instancia Class<IBaseDto>. La consulta esta contenida en los archivos xml y se
   * define por un unit modulo, select con id="row" y los parametros params. Los nombres de los campos son renombrados
   * a notación dromedario.
   *
   * #param dto -> Instancia de IBaseDto que define el registro a obtener
   * #param modulo -> String que define el nombre del unit en archivo xml
   * #param params -> HashMap que contiene los parametros de búsqueda
   * #return IBaseDto que contiene el registro obtenido.
   * #throws Exception
   */
  public T toEntity(Class<IBaseDto> dto, String modulo, Map<String, Object> params) throws Exception {
    return toEntity(dto, modulo, Constantes.DML_SELECT, params);
  } // toEntitySet

  /**
   * Obtiene el registro definido por una instancia Class<IBaseDto>. La consulta esta contenida en los archivos xml y se
   * define por un unit modulo y select idXml y los parametros params. Los nombres de los campos son renombrados a notación dromedario.
   *
   * #param dto -> Instancia de IBaseDto que define el registro a obtener
   * #param modulo -> String que define el nombre del unit en archivo xml
   * #param idXml -> String que define el nombre del select en archivo xml
   * #param params -> HashMap que contiene los parametros de búsqueda
   * #return IBaseDto que contiene el registro obtenido.
   * #throws Exception
   */
  public T toEntity(Class<IBaseDto> dto, String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toEntity(dto, Dml.getInstance().getSelect(modulo, idXml, params));
  } // toEntitySet

  /**
   * Obtiene los registros devueltos por una consulta sql. Los nombres de los campos son renombrados a
   * notación dromedario.
   *
   * #param sql -> Sentencia select de sql.
   * #return List<T> donde el genetico T=Entity que contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toEntitySet(String sql) throws Exception {
    List<T> regresar = null;
    try {
      regresar = toRecordsEntity(sql, new TransformEntity());
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  } // toEntityset

  /**
   * Obtiene los registros devueltos por la consulta contenida en archivo xml, definida por el unit "modulo" y el
   * select "row" y que coincide con las condiciones descritas en "params". Los campos son renombrados a
   * notación dromedario.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return List<T> donde el genetico T=Entity que contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toEntitySet(String modulo, Map<String, Object> params) throws Exception {
    return toEntitySet(modulo, Constantes.DML_SELECT, params);
  } // toEntitySet

  /**
   * Obtiene los registros devueltos por la consulta contenida en archivo xml, definida por el unit "modulo" y el
   * select "idXml" y que coincide con las condiciones descritas en "params". Los campos son renombrados a
   * notación dromedario.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return List<T> donde el genetico T=Entity que contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toEntitySet(String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toEntitySet(Dml.getInstance().getSelect(modulo, idXml, params));
  } // toEntitySet

  /**
   * Obtiene los registros devueltos por una consulta sql y los vacía en una intancia de tipo Class<IBaseDto>. Los
   * nombres de los campos son renombrados a notación dromedario y deben coincidir con los del Dto.
   *
   * #param dto -> Instancia de IBaseDto que define los registros a obtener
   * #param sql -> String con consulta sql que define los parametros de busqueda
   * #return List<T> donde el genérico T=IBaseDto contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toEntitySet(Class<IBaseDto> dto, String sql) throws Exception {
    List<T> regresar = null;
    try {
      regresar = toRecordsEntity(sql, new TransformDto(dto));
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  }

  /**
   * Obtiene los registros devueltos por una consulta contenida en archivo xml, definida por el unit "modulo" y el
   * select "row" y que coincide con las condiciones descritas en "params" y los vacía en una intancia de tipo Class<IBaseDto>. Los
   * nombres de los campos son renombrados a notación dromedario y deben coincidir con los del Dto.
   *
   * #param dto -> Instancia de IBaseDto que define los registros a obtener
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return List<T> donde el genérico T=IBaseDto contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toEntitySet(Class<IBaseDto> dto, String modulo, Map<String, Object> params) throws Exception {
    return toEntitySet(dto, modulo, Constantes.DML_SELECT, params);
  } // toEntitySet

  /**
   * Obtiene los registros devueltos por una consulta contenida en archivo xml, definida por el unit "modulo" y el
   * select "idXml" y que coincide con las condiciones descritas en "params" y los vacía en una intancia de tipo Class<IBaseDto>. Los
   * nombres de los campos son renombrados a notación dromedario y deben coincidir con los del Dto.
   *
   * #param dto -> Instancia de IBaseDto que define los registros a obtener
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return List<T> donde el genérico T=IBaseDto contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toEntitySet(Class<IBaseDto> dto, String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toEntitySet(dto, Dml.getInstance().getSelect(modulo, idXml, params));
  } // toEntitySet

  /**
   * Obtiene el registro definido por consulta sql.
   * Los nombres de los campos son devueltos tal cual se encuentran en la base de datos.
   *
   * #param sql -> Sentencia select de sql.
   * #return SourceEntity que contiene el registro obtenido.
   * #throws Exception
   */
  public T toSourceEntity(String sql) throws Exception {
    T regresar = null;
    List list = null;
    try {
      list = toRecordsEntity(sql, new TransformSourceEntity());
      if (list != null && list.size() > 0) {
        regresar = (T) list.get(0);
      } // if
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  } // toEntity

  /**
   * Obtiene el registro devuelto por la consulta contenida en archivo xml, definida por el unit "modulo" y el select
   * por default (row) y que coincide con las condiciones descritas en "params". Los nombres de de los campos son
   * devueltos tal cual se encuentran en la base de datos.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return SourceEntity que contiene el registro obtenido.
   * #throws Exception
   */
  public T toSourceEntity(String modulo, Map<String, Object> params) throws Exception {
    return toSourceEntity(modulo, Constantes.DML_SELECT, params);
  } // toEntity

  /**
   * Obtiene el registro devuelto por la consulta contenida en archivo xml, definida por el unit "modulo" y el select
   * "idXml" y que coincide con las condiciones descritas en "params". Los nombres de los campos son devueltos tal cual
   * se encuentran en la base de datos.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return SourceEntity que contiene el registro obtenido.
   * #throws Exception
   */
  public T toSourceEntity(String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toSourceEntity(Dml.getInstance().getSelect(modulo, idXml, params));
  } // toEntity

  /**
   * Obtiene los registros definidos por una consulta sql.
   * Los nombres de los campos son devueltos tal cual se encuentran en la base de datos.
   *
   * #param sql -> Sentencia select de sql.
   * #return List<SourceEntity> que contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toSourceEntitySet(String sql) throws Exception {
    List<T> regresar = null;
    try {
      regresar = toRecordsEntity(sql, new TransformSourceEntity());
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    return regresar;
  } // toEntityset

  /**
   * Obtiene los registros definidos por una consulta sql contenida en archivo xml, definida por el unit "modulo" y el select
   * "row" y que coincide con las condiciones descritas en "params".
   * Los nombres de los campos son devueltos tal cual se encuentran en la base de datos.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return List<SourceEntity> que contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toSourceEntitySet(String modulo, Map<String, Object> params) throws Exception {
    return toSourceEntitySet(modulo, Constantes.DML_SELECT, params);
  } // toEntitySet

  /**
   * Obtiene los registros definidos por una consulta sql contenida en archivo xml, definida por el unit "modulo" y el select
   * "idXml" y que coincide con las condiciones descritas en "params".
   * Los nombres de los campos son devueltos tal cual se encuentran en la base de datos.
   *
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return List<SourceEntity> que contiene los registros obtenidos.
   * #throws Exception
   */
  public List<T> toSourceEntitySet(String modulo, String idXml, Map<String, Object> params) throws Exception {
    return toSourceEntitySet(Dml.getInstance().getSelect(modulo, idXml, params));
  } // toEntitySet

  private List<T> toRecordsEntity(String sql, Transformer transformer) throws Exception {
    List<T> regresar = null;
    Cursor cursor = null;
    try {
      cursor = this.masterSession.getDatabase().rawQuery(sql, null);
      if (cursor != null) {
        transformer.setCursor(cursor);
        regresar = transformer.toList();
      } // if
    } // try
    catch (Exception e) {
      throw e;
    } //  catch
    finally {
      if (cursor != null)
        cursor.close();
    } // finally
    return regresar;
  } // toRecordsEntity

	private String getId(String semilla) {
		Integer dia          = null;
		Integer segundo      = null;
		String  milisegundos = null;
		String fecha         = null;
		Date fechaHoy    = null;
		String diaCalculado  = null;
		String regresar      = null;
		Calendar calendar    = null;
		try{
			calendar     = Calendar.getInstance();
			fecha        =  Fecha.formatear(Fecha.SECUENCIA, calendar);
			fechaHoy     = calendar.getTime();
			dia          = calendar.get(Calendar.DAY_OF_YEAR);
			segundo      = Fecha.secondOfTheDay(calendar);
			milisegundos = fecha.substring(fecha.length()-3, fecha.length());
			if (dia< 100)
				diaCalculado= "7"+ Cadena.rellenaConCerosI(Integer.toString(dia), 2);
			else
				diaCalculado = Integer.toString(dia);
			regresar       = diaCalculado +
			 Cadena.rellenaConCerosI(semilla, 5)+
			  Cadena.rellenaConCerosI(String.valueOf(segundo),5).substring(1,5) +
			  Cadena.rellenaConCerosI(milisegundos, 3);
			regresar= Fecha.getRegistro().substring(2, 17);
		} // try
		catch(Exception e){
			Error.mensaje(e);
			throw e;
		} // catch
		return regresar;
	} // getId


	private String getId() {
		return getId("173");
	}
  /**
   * Inserta un registro a la base de datos a partir de una instancia de un Dto
   *
   * #param dto -> Dto a insertar
   * #return Valor Long con el idKey del registro agregado. Si valor=-1 el registro no se insertó
   * #throws Exception
   */
  public Long insert(T dto) throws Exception {
    return insert(dto, ETiposBitacoras.SIN_BITACORA);
  } // insert

  /**
   * Inserta un registro a la base de datos a partir de una instancia de un Dto
   *
   * #param dto -> Dto a insertar
   * #param bitacora -> Tipo de bitacora
   * #return Valor Long con el idKey del registro agregado. Si valor=-1 el registro no se insertó
   * #throws Exception
   */
  public Long insert(T dto, ETiposBitacoras bitacora) throws Exception {
    Long regresar = -1L;
    Long idKey = -1L;
    try {
      Bitacora.setTiposBitacora(bitacora);
      Bitacora.setTipoSentencia(ESql.INSERT);
      idKey= Long.valueOf(getId());
      dto.setKey(idKey);
      masterSession.getDao(dto).insert(dto);
      dto.setKey(idKey); // GreenDao setea un idKey autoincremental en el insert, se vuelve a setear el idKey generado con la semilla
      regresar= idKey;
      insertarBitacora();
    } // try
    catch (Exception e) {
      Bitacora.cleanAttrs();
      throw e;
    } // catch
    return regresar;
  } // insert

  /**
   * Inserta o reemplaza un registro a la base de datos a partir de una instancia de un Dto
   *
   * #param dto -> Dto a insertar
   * #return Valor Long con el idKey del registro agregado. Si valor=-1 el registro no se insertó
   * #throws Exception
   */
  private Long insertOrUpdate(T dto) throws Exception {
    return insertOrUpdate(dto, ETiposBitacoras.SIN_BITACORA);
  } // insert

  /**
   * Inserta o reemplaza un registro a la base de datos a partir de una instancia de un Dto
   *
   * #param dto -> Dto a insertar
   * #param bitacora -> Tipo de bitacora
   * #return Valor Long con el idKey del registro agregado. Si valor=-1 el registro no se insertó
   * #throws Exception
   */
  private Long insertOrUpdate(T dto, ETiposBitacoras bitacora) throws Exception {
    Long regresar = -1L;
    try {
      Bitacora.setTiposBitacora(bitacora);
      Bitacora.setTipoSentencia(ESql.UPSERT);
      regresar = masterSession.getDao(dto).insertOrReplace(dto);
      insertarBitacora();
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } // insert

  /**
   * Modifica un registro a la base de datos a partir de una instancia de IBaseDto
   *
   * #param dto -> Dto a modificar
   * #return Valor Long de 1L en caso de una modificación exitosa. Si valor=-1 el registro no se modificó
   * #throws Exception
   */
  public Long update(T dto) throws Exception {
    return update(dto, ETiposBitacoras.SIN_BITACORA);
  } // insert

  /**
   * Modifica un registro a la base de datos a partir de una instancia de IBaseDto
   *
   * #param dto -> Dto a modificar
   * #param bitacora -> Tipo de bitacora
   * #return Valor Long de 1L en caso de una modificación exitosa. Si valor=-1 el registro no se modificó
   * #throws Exception
   */
  public Long update(T dto , ETiposBitacoras bitacora) throws Exception {
    return update(dto, dto.toMap(), bitacora);

    /*Long regresar = -1L;
    try {
      Bitacora.setTiposBitacora(bitacora);
      Bitacora.setTipoSentencia(ESql.UPDATE);
      masterSession.getDao(dto).update(dto);
      regresar= 1L;
      insertarBitacora();
    } // try
    catch (Exception e) {
      Bitacora.cleanAttrs();
      throw e;
    } // catch
    return regresar;*/
  } // insert

  /**
   * Modifica un registro a la base de datos a partir de una instancia IBaseDto y un mapa en el cual se indican los
   * campos y valores a modificar del registro
   *
   * #param dto -> Dto a modificar
   * #param fieldsDto -> Map<String,Object> que contiene los campos a modificar con su correspondite nuevo valor.
   * #return Valor Long de 1L en caso de una modificación exitosa. Si valor=-1 el registro no se modificó
   * #throws Exception
   */
  public Long update(T dto, Map<String, Object> fieldsDto) throws Exception {
    return update(dto.toHbmClass(), dto.getKey(), fieldsDto);
  } // update

  /**
   * Modifica un registro a la base de datos a partir de una instancia IBaseDto y un mapa en el cual se indican los
   * campos y valores a modificar del registro
   *
   * #param dto -> Dto a modificar
   * #param bitacora -> Tipo de bitacora
   * #param fieldsDto -> Map<String,Object> que contiene los campos a modificar con su correspondite nuevo valor.
   * #return Valor Long de 1L en caso de una modificación exitosa. Si valor=-1 el registro no se modificó
   * #throws Exception
   */
  public Long update(T dto, Map<String, Object> fieldsDto, ETiposBitacoras bitacora) throws Exception {
    return update(dto.toHbmClass(), dto.getKey(), fieldsDto, bitacora);
  } // update

  /**
   * Modifica un registro a la base de datos a partir de una instancia Class del dto que mapea a la tabla de la base de
   * datos, el idKey del registro a modificar y un mapa en el cual se indican los campos y valores a modificar del
   * registro
   *
   * #param dto -> Dto a modificar
   * #param key -> Valor del idKey del registro a modificar
   * #param fieldsDto -> Map<String,Object> que contiene los campos a modificar con su correspondite nuevo valor.
   * #return Valor Long de 1L en caso de una modificación exitosa. Si valor=-1 el registro no se modificó
   * #throws Exception
   */
  public Long update(Class<IBaseDto> dto, Long key, Map<String, Object> fieldsDto) throws Exception {
    return  update(dto, key, fieldsDto,  ETiposBitacoras.SIN_BITACORA);
  } // update

  /**
   * Modifica un registro a la base de datos a partir de una instancia Class del dto que mapea a la tabla de la base de
   * datos, el idKey del registro a modificar y un mapa en el cual se indican los campos y valores a modificar del
   * registro
   *
   * #param dto -> Dto a modificar
   * #param key -> Valor del idKey del registro a modificar
   * #param fieldsDto -> Map<String,Object> que contiene los campos a modificar con su correspondite nuevo valor.
   * #param bitacora -> Tipo de bitacora
   * #return Valor Long de 1L en caso de una modificación exitosa. Si valor=-1 el registro no se modificó
   * #throws Exception
   */
  public Long update(Class<IBaseDto> dto, Long key, Map<String, Object> fieldsDto, ETiposBitacoras bitacora) throws Exception {
    Long regresar = -1L;
    String sql    = null;
    AbstractDao dao= null;
    try {
      dao= masterSession.getDao(dto);
      sql= getSentenciaUpdateParcial(Arrays.asList(dao.getAllColumns()),fieldsDto, dao.getTablename(), Arrays.asList(dao.getPkColumns()), key);
      regresar= execute(sql, bitacora, ESql.UPDATE);
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } // update

  /**
   * Elimina un registro a la base de datos a partir de una instancia de un Dto
   *
   * #param dto -> Dto a eliminar
   * #return Valor Long de 1L en caso de una eliminación exitosa. Si valor=-1 el registro no se eliminó.
   * #throws Exception
   */
  public Long delete(T dto) throws Exception {
    return delete(dto.toHbmClass(), dto.getKey());
  } // delete

  /**
   * Elimina un registro a la base de datos a partir de una instancia de un Dto
   *
   * #param dto -> Dto a eliminar
   * #param bitacora -> Tipo de bitacora
   * #return Valor Long de 1L en caso de una eliminación exitosa. Si valor=-1 el registro no se eliminó.
   * #throws Exception
   */
  public Long delete(T dto, ETiposBitacoras bitacora) throws Exception {
    return delete(dto.toHbmClass(), dto.getKey(), bitacora);
  } // delete

  /**
   * Elimina un registro a la base de datos indicando el dto que mapea a a la base de datos y el campo llave del
   * registro a eliminar
   *
   * #param dto -> Instancia de Class que indica el dto que mapea la tabla a modificar
   * #param key -> idKey del registro a eliminar
   * #return Valor Long de 1L en caso de una eliminación exitosa. Si valor=-1 el registro no se eliminó.
   * #throws Exception
   */
  public Long delete(Class<IBaseDto> dto, Long key) throws Exception{
    return delete(dto, key, ETiposBitacoras.SIN_BITACORA);
  } // delete

  /**
   * Elimina un registro a la base de datos indicando el dto que mapea a a la base de datos y el campo llave del
   * registro a eliminar
   *
   * #param dto -> Instancia de Class que indica el dto que mapea la tabla a modificar
   * #param key -> idKey del registro a eliminar
   * #param bitacora -> Tipo de bitacora
   * #return Valor Long de 1L en caso de una eliminación exitosa. Si valor=-1 el registro no se eliminó.
   * #throws Exception
   */
  public Long delete(Class<IBaseDto> dto, Long key, ETiposBitacoras bitacora) throws Exception{
    Long regresar  = -1L;
    AbstractDao dao= null;
    try {
      Bitacora.setTiposBitacora(bitacora);
      Bitacora.setTipoSentencia(ESql.DELETE);
      dao= this.masterSession.getDao(dto);
      dao.deleteByKey(key);
      regresar = 1L;
      if(key!= null)
        insertarBitacora("delete from ".concat(dao.getTablename()).concat(" where ").concat(dao.getPkColumns()[0]).concat("= ").concat(key.toString()));
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } // delete

  public DaoSession getMasterSession() {
    return this.masterSession;
  } // getMasterSession

  /**
   * Ejecuta un query libre en la base de datos que pudiera afectar varios registros.
   *
   * #param sql -> Sentencia sql que puede ser de tipo update o delete.
   * #return Long con la cantidad de registros afectados.
   * #throws Exception
   */
  public Long execute(String sql) throws Exception{
    return execute(sql, ETiposBitacoras.SIN_BITACORA, ESql.SELECT);
  } // execute

  /**
   * Ejecuta un query libre en la base de datos que pudiera afectar varios registros.
   *
   * #param sql -> Sentencia sql que puede ser de tipo update o delete.
   * #param bitacora -> Tipo de bitacora
   * #return Long con la cantidad de registros afectados.
   * #throws Exception
   */
  public Long execute(String sql, ETiposBitacoras bitacora, ESql accion) throws Exception{
    Long regresar = -1L;
    try {
      Bitacora.setTiposBitacora(bitacora);
      Bitacora.setTipoSentencia(accion);
      this.masterSession.getDatabase().execSQL(sql);
      regresar = toRegistrosAfectados(this.masterSession);
      insertarBitacora(sql);
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } // execute

  /**
   * Ejecuta un query libre en la base de datos que pudiera afectar varios registros.
   *
   * #param action -> Enumerado con el tipo de sentencia a ejecutar (solo se permite INSERT, UPDATE ó DELETE)
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return Long con la cantidad de registros afectados.
   * #throws Exception
   */
  public Long execute(ESql action, String modulo, String idXml, Map<String, Object> params) throws Exception{
    return execute(action, modulo, idXml, params, ETiposBitacoras.SIN_BITACORA);
  } // execute

  /**
   * Ejecuta un query libre en la base de datos que pudiera afectar varios registros.
   *
   * #param action -> Enumerado con el tipo de sentencia a ejecutar (solo se permite INSERT, UPDATE ó DELETE)
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param bitacora -> Tipo de bitacora
   * #param params -> Map que contiene los parametros a evaluar en la consulta.
   * #return Long con la cantidad de registros afectados.
   * #throws Exception
   */
  public Long execute(ESql action, String modulo, String idXml, Map<String, Object> params, ETiposBitacoras bitacora) throws Exception{
    if (action.equals(ESql.INSERT) || action.equals(ESql.UPDATE) || action.equals(ESql.DELETE))
      return execute(getDML(modulo,idXml,params,action), bitacora, action);
    else
      throw new Exception("Tipo de sentencia no soportado por este método");
  } // execute

  /**
   * Obtiene la cantidad total de registros afectados del último query ejecutado.
   *
   * #param session -> Sesión actual de GreenDao.
   * #return Long con la cantidad de registros afectados.
   * #throws Exception
   */
  private Long toRegistrosAfectados(DaoSession session) throws Exception{
    Long regresar = -1L;
    Cursor cursor = null;
    String sql    = null;
    try{
      sql = Dml.getInstance().getSelect("GreenDao","registros", new HashMap());
      cursor = session.getDatabase().rawQuery(sql,null);
      if (cursor.moveToFirst())
        regresar = cursor.getLong(0);
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    finally {
      if (cursor != null)
        cursor.close();
    } // finally
    return regresar;
  } // toRegistrosAfectados

  /**
   * Obtiene la sentencia sql contenida en archivo xml, definida por el unit "modulo" y el select
   * "idXml" y que coincide con las condiciones descritas en "params".
   *
   * #param kind -> Enumerado con el tipo de sentencia a ejecutar
   * #param modulo -> Id unit del proceso que contiene la consulta en archivo xml.
   * #param idXml -> Id del select contenido en el unit definido por "modulo".
   * #param params -> Map que contiene los parametros a evaluar en la sentencia.
   * #throws XPathExpressionException
   */
  public String getDML(String modulo, String idXml, Map<String, Object> params, ESql kind) throws XPathExpressionException {
    switch (kind) {
      case DELETE:
        return Dml.getInstance().getDelete(modulo, idXml, params);
      case INSERT:
        return Dml.getInstance().getInsert(modulo, idXml, params);
      case SELECT:
        return Dml.getInstance().getSelect(modulo, idXml, params);
      case UPDATE:
        return Dml.getInstance().getUpdate(modulo, idXml, params);
    } // switch
    return null;
  } // getDML

  /**
   * Cierra la conexion a la base de datos y limpia la instancia
   */
  public void disconnect(){
    getMasterSession().getDatabase().close();
    this.instance= null;
  }


  private String getSentencia() throws Exception {
    String regresar = null;
    Integer contador= 1;
    String valor    = null;
    try{
      regresar= Bitacora.getSentencia().replace("SQLiteProgram: ",""); //trae la setencia y le quita la basura del greenDao
      while (regresar.contains("?")){
        if (Bitacora.getInstanceAttrs().containsKey(contador)) {
          if (Bitacora.getInstanceAttrs().get(contador) instanceof Number)
            valor = Bitacora.getInstanceAttrs().get(contador).toString();
          else
            valor = Cadena.comillas((String) Bitacora.getInstanceAttrs().get(contador));
        } // if
        else
          valor = "null"; // si la sentencia contiene WHERE se queda con un valor null la condición, solo ocurre si se usa el metodo insertOrUpdate
        regresar= regresar.replaceFirst("\\?", valor);
        contador++;
      } // while
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } //getSentencia


  private void insertarBitacora() throws Exception {
    insertarBitacora(getSentencia());
  } //insertarBitacora

  private void insertarBitacora(String sql) throws Exception {
    TrMovilSentenciasDto dto= null;
    try{
      if(!ETiposBitacoras.SIN_BITACORA.equals(Bitacora.getTipoBitacora())) {
        dto = new TrMovilSentenciasDto();
        dto.setSql(sql);
        dto.setIdMovilTipoAccion(Bitacora.getTipoSentencia().getKey());
        dto.setIdMovilEstatusEnvio(1L);
        //dto.setNumEmp(AndroidBase.getAutentifica().getEmpleado().getNumEmpleado());
        dto.setRegistro(Fecha.getRegistro());
        //dto.setVersion(AndroidBase.getAutentifica().getDatosInstalacion().getVersionIktan());
        if (Bitacora.getTipoBitacora().equals(ETiposBitacoras.ESPECIFICA))
          dto.setIdGenerico(Bitacora.getIdGenerico());
        DaoFactory.getInstance().insert(dto, ETiposBitacoras.SIN_BITACORA);
      } // if
      Bitacora.cleanAttrs();
    } // try
    catch (Exception e) {
      throw e;
    } // catch
  } // insertarBitacora

  private String getSentenciaUpdateParcial(List<String> campos, Map<String, Object> fieldsDto, String tabla, List<String> campoKey, Long idKey) throws Exception {
    String regresar              = null;
    StringBuilder sql            = null;
    Object valor                 = null;
    Map<String, String> camposDto= null;
    try{
      camposDto= new HashMap<>();
      for(String item: campos)
        camposDto.put(Cadena.toBeanNameEspecial(item), item);
      sql= new StringBuilder();
      sql.append("update ");
      sql.append(tabla);
      sql.append(" set ");
      for (String campo : fieldsDto.keySet()) {
        if(camposDto.containsKey(campo)) {
          sql.append(camposDto.get(campo));
          sql.append("=");
          valor= fieldsDto.get(campo);
          sql.append(valor instanceof Number? valor.toString(): Cadena.comillas((String)valor));
          sql.append(", ");
        } // if
      } // for
      sql.delete(sql.lastIndexOf(","), sql.length());// quita la ultima coma
      sql.append(" where ");
      sql.append(campoKey.get(0));
      sql.append("= ");
      sql.append(idKey);
      regresar= sql.toString();
    } // try
    catch (Exception e) {
      throw e;
    } // catch
    return regresar;
  } //getSentencia

}