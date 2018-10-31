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

import alertaspa.com.mx.condominio.db.dto.TrVehiculosDto;
import mx.org.dao.db.reglas.DaoSession;

public class TrVehiculosDao extends AbstractDao<TrVehiculosDto, Long> {

	public static final String TABLENAME = "TR_VEHICULOS";

	public static class Properties {
		public final static Property ID_VEHICULO = new Property(0, Long.class, "ID_VEHICULO", true, "ID_VEHICULO");
		public final static Property ID_MODELO = new Property(1, Long.class, "ID_MODELO", false, "ID_MODELO");
		public final static Property PLACA = new Property(2, String.class, "PLACA", false, "PLACA");
		public final static Property COLOR = new Property(3, String.class, "COLOR", false, "COLOR");
		public final static Property ID_CASA = new Property(4, Long.class, "ID_CASA", false, "ID_CASA");
	}
	
	public TrVehiculosDao(DaoConfig config) {
		super(config);
	}

	public TrVehiculosDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TrVehiculosDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdVehiculo();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idModelo = entity.getIdModelo();
		if (idModelo != null) {
			stmt.bindLong(2, idModelo);
			Bitacora.getInstanceAttrs().put(2, idModelo);
		}
		String placa = entity.getPlaca();
		if (placa != null) {
			stmt.bindString(3, placa);
			Bitacora.getInstanceAttrs().put(3, placa);
		}
		String color = entity.getColor();
		if (color != null) {
			stmt.bindString(4, color);
			Bitacora.getInstanceAttrs().put(4, color);
		}
		Long idCasa = entity.getIdCasa();
		if (idCasa != null) {
			stmt.bindLong(5, idCasa);
			Bitacora.getInstanceAttrs().put(5, idCasa);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TrVehiculosDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdVehiculo();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idModelo = entity.getIdModelo();
		if (idModelo != null) {
			stmt.bindLong(2, idModelo);
			Bitacora.getInstanceAttrs().put(2, idModelo);
		}
		String placa = entity.getPlaca();
		if (placa != null) {
			stmt.bindString(3, placa);
			Bitacora.getInstanceAttrs().put(3, placa);
		}
		String color = entity.getColor();
		if (color != null) {
			stmt.bindString(4, color);
			Bitacora.getInstanceAttrs().put(4, color);
		}
		Long idCasa = entity.getIdCasa();
		if (idCasa != null) {
			stmt.bindLong(5, idCasa);
			Bitacora.getInstanceAttrs().put(5, idCasa);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TrVehiculosDto readEntity(Cursor cursor, int offset) {
		TrVehiculosDto entity = new TrVehiculosDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2),
			cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3),
			cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TrVehiculosDto entity, int offset) {
		entity.setIdVehiculo(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setIdModelo(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
		entity.setPlaca(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
		entity.setColor(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
		entity.setIdCasa(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
	}

	@Override
	protected final Long updateKeyAfterInsert(TrVehiculosDto entity, long rowId) {
		entity.setIdVehiculo(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TrVehiculosDto entity) {
		if (entity != null) {
			return entity.getIdVehiculo();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TrVehiculosDto entity) {
		return entity.getIdVehiculo() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
