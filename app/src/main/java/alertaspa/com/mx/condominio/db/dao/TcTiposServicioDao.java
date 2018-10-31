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

import alertaspa.com.mx.condominio.db.dto.TcTiposServicioDto;
import mx.org.dao.db.reglas.DaoSession;

public class TcTiposServicioDao extends AbstractDao<TcTiposServicioDto, Long> {

	public static final String TABLENAME = "TC_TIPOS_SERVICIO";

	public static class Properties {
		public final static Property ID_TIPO_SERVICIO = new Property(0, Long.class, "ID_TIPO_SERVICIO", false, "ID_TIPO_SERVICIO");
		public final static Property DESCRIPCION = new Property(1, String.class, "DESCRIPCION", false, "DESCRIPCION");
	}
	
	public TcTiposServicioDao(DaoConfig config) {
		super(config);
	}

	public TcTiposServicioDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TcTiposServicioDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long idTipoServicio = entity.getIdTipoServicio();
		if (idTipoServicio != null) {
			stmt.bindLong(1, idTipoServicio);
			Bitacora.getInstanceAttrs().put(1, idTipoServicio);
		}
		String descripcion = entity.getDescripcion();
		if (descripcion != null) {
			stmt.bindString(2, descripcion);
			Bitacora.getInstanceAttrs().put(2, descripcion);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TcTiposServicioDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long idTipoServicio = entity.getIdTipoServicio();
		if (idTipoServicio != null) {
			stmt.bindLong(1, idTipoServicio);
			Bitacora.getInstanceAttrs().put(1, idTipoServicio);
		}
		String descripcion = entity.getDescripcion();
		if (descripcion != null) {
			stmt.bindString(2, descripcion);
			Bitacora.getInstanceAttrs().put(2, descripcion);
		}
	}

	@Override
	protected Long updateKeyAfterInsert(TcTiposServicioDto entity, long rowId) {
		return null;
	}

	@Override
	protected Long getKey(TcTiposServicioDto entity) {
		return null;
	}

	@Override
	protected boolean hasKey(TcTiposServicioDto entity) {
		return false;
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TcTiposServicioDto readEntity(Cursor cursor, int offset) {
		TcTiposServicioDto entity = new TcTiposServicioDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TcTiposServicioDto entity, int offset) {
		entity.setIdTipoServicio(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setDescripcion(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
