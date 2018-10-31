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

import alertaspa.com.mx.condominio.db.dto.TrResidentesDto;
import mx.org.dao.db.reglas.DaoSession;

public class TrResidentesDao extends AbstractDao<TrResidentesDto, Long> {

	public static final String TABLENAME = "TR_RESIDENTES";

	public static class Properties {
		public final static Property ID_RESIDENTE = new Property(0, Long.class, "ID_RESIDENTE", true, "ID_RESIDENTE");
		public final static Property ID_CASA = new Property(1, Long.class, "ID_CASA", false, "ID_CASA");
		public final static Property NOMBRE = new Property(2, String.class, "NOMBRE", false, "NOMBRE");
	}
	
	public TrResidentesDao(DaoConfig config) {
		super(config);
	}

	public TrResidentesDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TrResidentesDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdResidente();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idCasa = entity.getIdCasa();
		if (idCasa != null) {
			stmt.bindLong(2, idCasa);
			Bitacora.getInstanceAttrs().put(2, idCasa);
		}
		String nombre = entity.getNombre();
		if (nombre != null) {
			stmt.bindString(3, nombre);
			Bitacora.getInstanceAttrs().put(3, nombre);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TrResidentesDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdResidente();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idCasa = entity.getIdCasa();
		if (idCasa != null) {
			stmt.bindLong(2, idCasa);
			Bitacora.getInstanceAttrs().put(2, idCasa);
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
	public TrResidentesDto readEntity(Cursor cursor, int offset) {
		TrResidentesDto entity = new TrResidentesDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TrResidentesDto entity, int offset) {
		entity.setIdResidente(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setIdCasa(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
		entity.setNombre(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
	}

	@Override
	protected final Long updateKeyAfterInsert(TrResidentesDto entity, long rowId) {
		entity.setIdResidente(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TrResidentesDto entity) {
		if (entity != null) {
			return entity.getIdResidente();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TrResidentesDto entity) {
		return entity.getIdResidente() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
