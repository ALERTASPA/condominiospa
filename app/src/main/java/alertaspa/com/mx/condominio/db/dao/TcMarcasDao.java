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

import alertaspa.com.mx.condominio.db.dto.TcMarcasDto;
import mx.org.dao.db.reglas.DaoSession;

public class TcMarcasDao extends AbstractDao<TcMarcasDto, Long> {

	public static final String TABLENAME = "TC_MARCAS";

	public static class Properties {
		public final static Property ID_MARCA = new Property(0, Long.class, "ID_MARCA", true, "ID_MARCA");
		public final static Property DESCRIPCION = new Property(1, String.class, "DESCRIPCION", false, "DESCRIPCION");
	}
	
	public TcMarcasDao(DaoConfig config) {
		super(config);
	}

	public TcMarcasDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TcMarcasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdMarca();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		String descripcion = entity.getDescripcion();
		if (descripcion != null) {
			stmt.bindString(2, descripcion);
			Bitacora.getInstanceAttrs().put(2, descripcion);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TcMarcasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdMarca();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		String descripcion = entity.getDescripcion();
		if (descripcion != null) {
			stmt.bindString(2, descripcion);
			Bitacora.getInstanceAttrs().put(2, descripcion);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TcMarcasDto readEntity(Cursor cursor, int offset) {
		TcMarcasDto entity = new TcMarcasDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TcMarcasDto entity, int offset) {
		entity.setIdMarca(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setDescripcion(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
	}

	@Override
	protected final Long updateKeyAfterInsert(TcMarcasDto entity, long rowId) {
		entity.setIdMarca(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TcMarcasDto entity) {
		if (entity != null) {
			return entity.getIdMarca();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TcMarcasDto entity) {
		return entity.getIdMarca() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
