package mx.org.dao.db.dao;
/**
 * @author Autogenerado.
 * @company INEGI
 * @proyect Sistema de Seguimiento y Control (IKTAN)
 */
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import mx.org.dao.db.reglas.Bitacora;
import mx.org.dao.db.reglas.DaoSession;
import mx.org.dao.db.reglas.Bitacora;

import mx.org.dao.db.dto.TrMovilSentenciasDto;
import mx.org.dao.db.reglas.DaoSession;

public class TrMovilSentenciasDao extends AbstractDao<TrMovilSentenciasDto, Long> {

	public static final String TABLENAME = "TR_MOVIL_SENTENCIAS";

	public static class Properties {
		public final static Property ID_MOVIL_SENTENCIA = new Property(0, Long.class, "ID_MOVIL_SENTENCIA", true, "ID_MOVIL_SENTENCIA");
		public final static Property ID_MOVIL_TIPO_ACCION = new Property(1, Long.class, "ID_MOVIL_TIPO_ACCION", false, "ID_MOVIL_TIPO_ACCION");
		public final static Property ID_MOVIL_ENVIO_WEB = new Property(2, Long.class, "ID_MOVIL_ENVIO_WEB", false, "ID_MOVIL_ENVIO_WEB");
		public final static Property ID_MOVIL_ESTATUS_ENVIO = new Property(3, Long.class, "ID_MOVIL_ESTATUS_ENVIO", false, "ID_MOVIL_ESTATUS_ENVIO");
		public final static Property NUM_EMP = new Property(4, String.class, "NUM_EMP", false, "NUM_EMP");
		public final static Property SQL = new Property(5, String.class, "SQL", false, "SQL");
		public final static Property REGISTRO = new Property(6, String.class, "REGISTRO", false, "REGISTRO");
		public final static Property VERSION = new Property(7, String.class, "VERSION", false, "VERSION");
		public final static Property ID_GENERICO = new Property(8, Long.class, "ID_GENERICO", false, "ID_GENERICO");
	}
	
	public TrMovilSentenciasDao(DaoConfig config) {
		super(config);
	}

	public TrMovilSentenciasDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TrMovilSentenciasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements);

		Long id = entity.getIdMovilSentencia();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idMovilTipoAccion = entity.getIdMovilTipoAccion();
		if (idMovilTipoAccion != null) {
			stmt.bindLong(2, idMovilTipoAccion);
			Bitacora.getInstanceAttrs().put(2, idMovilTipoAccion);
		}
		Long idMovilEnvioWeb = entity.getIdMovilEnvioWeb();
		if (idMovilEnvioWeb != null) {
			stmt.bindLong(3, idMovilEnvioWeb);
			Bitacora.getInstanceAttrs().put(3, idMovilEnvioWeb);
		}
		Long idMovilEstatusEnvio = entity.getIdMovilEstatusEnvio();
		if (idMovilEstatusEnvio != null) {
			stmt.bindLong(4, idMovilEstatusEnvio);
			Bitacora.getInstanceAttrs().put(4, idMovilEstatusEnvio);
		}
		String numEmp = entity.getNumEmp();
		if (numEmp != null) {
			stmt.bindString(5, numEmp);
			Bitacora.getInstanceAttrs().put(5, numEmp);
		}
		String sql = entity.getSql();
		if (sql != null) {
			stmt.bindString(6, sql);
			Bitacora.getInstanceAttrs().put(6, sql);
		}
		String registro = entity.getRegistro();
		if (registro != null) {
			stmt.bindString(7, registro);
			Bitacora.getInstanceAttrs().put(7, registro);
		}
		String version = entity.getVersion();
		if (version != null) {
			stmt.bindString(8, version);
			Bitacora.getInstanceAttrs().put(8, version);
		}
		Long idGenerico = entity.getIdGenerico();
		if (idGenerico != null) {
			stmt.bindLong(9, idGenerico);
			Bitacora.getInstanceAttrs().put(9, idGenerico);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TrMovilSentenciasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdMovilSentencia();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idMovilTipoAccion = entity.getIdMovilTipoAccion();
		if (idMovilTipoAccion != null) {
			stmt.bindLong(2, idMovilTipoAccion);
			Bitacora.getInstanceAttrs().put(2, idMovilTipoAccion);
		}
		Long idMovilEnvioWeb = entity.getIdMovilEnvioWeb();
		if (idMovilEnvioWeb != null) {
			stmt.bindLong(3, idMovilEnvioWeb);
			Bitacora.getInstanceAttrs().put(3, idMovilEnvioWeb);
		}
		Long idMovilEstatusEnvio = entity.getIdMovilEstatusEnvio();
		if (idMovilEstatusEnvio != null) {
			stmt.bindLong(4, idMovilEstatusEnvio);
			Bitacora.getInstanceAttrs().put(4, idMovilEstatusEnvio);
		}
		String numEmp = entity.getNumEmp();
		if (numEmp != null) {
			stmt.bindString(5, numEmp);
			Bitacora.getInstanceAttrs().put(5, numEmp);
		}
		String sql = entity.getSql();
		if (sql != null) {
			stmt.bindString(6, sql);
			Bitacora.getInstanceAttrs().put(6, sql);
		}
		String registro = entity.getRegistro();
		if (registro != null) {
			stmt.bindString(7, registro);
			Bitacora.getInstanceAttrs().put(7, registro);
		}
		String version = entity.getVersion();
		if (version != null) {
			stmt.bindString(8, version);
			Bitacora.getInstanceAttrs().put(8, version);
		}
		Long idGenerico = entity.getIdGenerico();
		if (idGenerico != null) {
			stmt.bindLong(9, idGenerico);
			Bitacora.getInstanceAttrs().put(9, idGenerico);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TrMovilSentenciasDto readEntity(Cursor cursor, int offset) {
		TrMovilSentenciasDto entity = new TrMovilSentenciasDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2),
			cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3),
			cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4),
			cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5),
			cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6),
			cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7),
			cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TrMovilSentenciasDto entity, int offset) {
		entity.setIdMovilSentencia(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setIdMovilTipoAccion(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
		entity.setIdMovilEnvioWeb(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
		entity.setIdMovilEstatusEnvio(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
		entity.setNumEmp(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
		entity.setSql(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
		entity.setRegistro(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
		entity.setVersion(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
		entity.setIdGenerico(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
	}

	@Override
	protected final Long updateKeyAfterInsert(TrMovilSentenciasDto entity, long rowId) {
		entity.setIdMovilSentencia(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TrMovilSentenciasDto entity) {
		if (entity != null) {
			return entity.getIdMovilSentencia();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TrMovilSentenciasDto entity) {
		return entity.getIdMovilSentencia() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
