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

import alertaspa.com.mx.condominio.db.dto.TcTiposAccesoDto;
import mx.org.dao.db.reglas.DaoSession;

public class TcTiposAccesoDao extends AbstractDao<TcTiposAccesoDto, Long> {

	public static final String TABLENAME = "TC_TIPOS_ACCESO";

	public static class Properties {
		public final static Property ID_TIPO_ACCESO = new Property(0, Long.class, "ID_TIPO_ACCESO", true, "ID_TIPO_ACCESO");
		public final static Property DESCRIPCION = new Property(1, String.class, "DESCRIPCION", false, "DESCRIPCION");
	}
	
	public TcTiposAccesoDao(DaoConfig config) {
		super(config);
	}

	public TcTiposAccesoDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TcTiposAccesoDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdTipoAcceso();
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
	protected final void bindValues(SQLiteStatement stmt, TcTiposAccesoDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdTipoAcceso();
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
	public TcTiposAccesoDto readEntity(Cursor cursor, int offset) {
		TcTiposAccesoDto entity = new TcTiposAccesoDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TcTiposAccesoDto entity, int offset) {
		entity.setIdTipoAcceso(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setDescripcion(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
	}

	@Override
	protected final Long updateKeyAfterInsert(TcTiposAccesoDto entity, long rowId) {
		entity.setIdTipoAcceso(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TcTiposAccesoDto entity) {
		if (entity != null) {
			return entity.getIdTipoAcceso();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TcTiposAccesoDto entity) {
		return entity.getIdTipoAcceso() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
