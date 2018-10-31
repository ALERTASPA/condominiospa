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

import alertaspa.com.mx.condominio.db.dto.TcModelosDto;
import mx.org.dao.db.reglas.DaoSession;

public class TcModelosDao extends AbstractDao<TcModelosDto, Long> {

	public static final String TABLENAME = "TC_MODELOS";

	public static class Properties {
		public final static Property ID_MODELO = new Property(0, Long.class, "ID_MODELO", true, "ID_MODELO");
		public final static Property ID_MARCA = new Property(1, Long.class, "ID_MARCA", false, "ID_MARCA");
		public final static Property DESCRIPCION = new Property(2, String.class, "DESCRIPCION", false, "DESCRIPCION");
	}
	
	public TcModelosDao(DaoConfig config) {
		super(config);
	}

	public TcModelosDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TcModelosDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdModelo();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idMarca = entity.getIdMarca();
		if (idMarca != null) {
			stmt.bindLong(2, idMarca);
			Bitacora.getInstanceAttrs().put(2, idMarca);
		}
		String descripcion = entity.getDescripcion();
		if (descripcion != null) {
			stmt.bindString(3, descripcion);
			Bitacora.getInstanceAttrs().put(3, descripcion);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TcModelosDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdModelo();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idMarca = entity.getIdMarca();
		if (idMarca != null) {
			stmt.bindLong(2, idMarca);
			Bitacora.getInstanceAttrs().put(2, idMarca);
		}
		String descripcion = entity.getDescripcion();
		if (descripcion != null) {
			stmt.bindString(3, descripcion);
			Bitacora.getInstanceAttrs().put(3, descripcion);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TcModelosDto readEntity(Cursor cursor, int offset) {
		TcModelosDto entity = new TcModelosDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TcModelosDto entity, int offset) {
		entity.setIdModelo(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setIdMarca(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
		entity.setDescripcion(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
	}

	@Override
	protected final Long updateKeyAfterInsert(TcModelosDto entity, long rowId) {
		entity.setIdModelo(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TcModelosDto entity) {
		if (entity != null) {
			return entity.getIdModelo();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TcModelosDto entity) {
		return entity.getIdModelo() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
