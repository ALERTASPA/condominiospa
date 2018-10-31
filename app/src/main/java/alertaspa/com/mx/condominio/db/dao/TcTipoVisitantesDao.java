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

import alertaspa.com.mx.condominio.db.dto.TcTipoVisitantesDto;
import mx.org.dao.db.reglas.DaoSession;

public class TcTipoVisitantesDao extends AbstractDao<TcTipoVisitantesDto, Long> {

	public static final String TABLENAME = "TC_TIPO_VISITANTES";

	public static class Properties {
		public final static Property ID_TIPO_VISITANTE = new Property(0, Long.class, "ID_TIPO_VISITANTE", true, "ID_TIPO_VISITANTE");
		public final static Property DESCRIPCION = new Property(1, String.class, "DESCRIPCION", false, "DESCRIPCION");
	}
	
	public TcTipoVisitantesDao(DaoConfig config) {
		super(config);
	}

	public TcTipoVisitantesDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TcTipoVisitantesDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdTipoVisitante();
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
	protected final void bindValues(SQLiteStatement stmt, TcTipoVisitantesDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdTipoVisitante();
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
	public TcTipoVisitantesDto readEntity(Cursor cursor, int offset) {
		TcTipoVisitantesDto entity = new TcTipoVisitantesDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TcTipoVisitantesDto entity, int offset) {
		entity.setIdTipoVisitante(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setDescripcion(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
	}

	@Override
	protected final Long updateKeyAfterInsert(TcTipoVisitantesDto entity, long rowId) {
		entity.setIdTipoVisitante(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TcTipoVisitantesDto entity) {
		if (entity != null) {
			return entity.getIdTipoVisitante();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TcTipoVisitantesDto entity) {
		return entity.getIdTipoVisitante() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
