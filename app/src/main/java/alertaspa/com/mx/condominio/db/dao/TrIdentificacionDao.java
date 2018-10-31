package alertaspa.com.mx.condominio.db.dao;
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

import alertaspa.com.mx.condominio.db.dto.TrIdentificacionDto;
import mx.org.dao.db.reglas.DaoSession;

public class TrIdentificacionDao extends AbstractDao<TrIdentificacionDto, Long> {

	public static final String TABLENAME = "TR_IDENTIFICACION";

	public static class Properties {
		public final static Property ID_IDENTIFICACION = new Property(0, Long.class, "ID_IDENTIFICACION", true, "ID_IDENTIFICACION");
		public final static Property RUTA = new Property(1, String.class, "RUTA", false, "RUTA");
		public final static Property NOMBRE = new Property(2, String.class, "NOMBRE", false, "NOMBRE");
	}
	
	public TrIdentificacionDao(DaoConfig config) {
		super(config);
	}

	public TrIdentificacionDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TrIdentificacionDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdIdentificacion();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		String ruta = entity.getRuta();
		if (ruta != null) {
			stmt.bindString(2, ruta);
			Bitacora.getInstanceAttrs().put(2, ruta);
		}
		String nombre = entity.getNombre();
		if (nombre != null) {
			stmt.bindString(3, nombre);
			Bitacora.getInstanceAttrs().put(3, nombre);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TrIdentificacionDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdIdentificacion();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		String ruta = entity.getRuta();
		if (ruta != null) {
			stmt.bindString(2, ruta);
			Bitacora.getInstanceAttrs().put(2, ruta);
		}
		String nombre = entity.getNombre();
		if (nombre != null) {
			stmt.bindString(3, nombre);
			Bitacora.getInstanceAttrs().put(3, nombre);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TrIdentificacionDto readEntity(Cursor cursor, int offset) {
		TrIdentificacionDto entity = new TrIdentificacionDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TrIdentificacionDto entity, int offset) {
		entity.setIdIdentificacion(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setRuta(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
		entity.setNombre(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
	}

	@Override
	protected final Long updateKeyAfterInsert(TrIdentificacionDto entity, long rowId) {
		entity.setIdIdentificacion(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TrIdentificacionDto entity) {
		if (entity != null) {
			return entity.getIdIdentificacion();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TrIdentificacionDto entity) {
		return entity.getIdIdentificacion() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
