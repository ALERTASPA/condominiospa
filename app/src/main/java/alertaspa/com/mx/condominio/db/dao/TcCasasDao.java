package alertaspa.com.mx.condominio.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import mx.org.dao.db.reglas.Bitacora;

import alertaspa.com.mx.condominio.db.dto.TcCasasDto;
import mx.org.dao.db.reglas.DaoSession;

public class TcCasasDao extends AbstractDao<TcCasasDto, Long> {

	public static final String TABLENAME = "TC_CASAS";

	public static class Properties {
		public final static Property ID_CASA = new Property(0, Long.class, "ID_CASA", true, "ID_CASA");
		public final static Property INTERIOR = new Property(1, String.class, "INTERIOR", false, "INTERIOR");
		public final static Property CALLE = new Property(2, String.class, "CALLE", false, "CALLE");
	}
	
	public TcCasasDao(DaoConfig config) {
		super(config);
	}

	public TcCasasDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TcCasasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdCasa();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		String interior = entity.getInterior();
		if (interior != null) {
			stmt.bindString(2, interior);
			Bitacora.getInstanceAttrs().put(2, interior);
		}
		String calle = entity.getCalle();
		if (calle != null) {
			stmt.bindString(3, calle);
			Bitacora.getInstanceAttrs().put(3, calle);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TcCasasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdCasa();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		String interior = entity.getInterior();
		if (interior != null) {
			stmt.bindString(2, interior);
			Bitacora.getInstanceAttrs().put(2, interior);
		}
		String calle = entity.getCalle();
		if (calle != null) {
			stmt.bindString(3, calle);
			Bitacora.getInstanceAttrs().put(3, calle);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TcCasasDto readEntity(Cursor cursor, int offset) {
		TcCasasDto entity = new TcCasasDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TcCasasDto entity, int offset) {
		entity.setIdCasa(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setInterior(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
		entity.setCalle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
	}

	@Override
	protected final Long updateKeyAfterInsert(TcCasasDto entity, long rowId) {
		entity.setIdCasa(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TcCasasDto entity) {
		if (entity != null) {
			return entity.getIdCasa();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TcCasasDto entity) {
		return entity.getIdCasa() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
