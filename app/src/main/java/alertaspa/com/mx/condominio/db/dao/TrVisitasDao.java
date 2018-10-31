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

import alertaspa.com.mx.condominio.db.dto.TrVisitasDto;
import mx.org.dao.db.reglas.DaoSession;

public class TrVisitasDao extends AbstractDao<TrVisitasDto, Long> {

	public static final String TABLENAME = "TR_VISITAS";

	public static class Properties {
		public final static Property ID_VISITA = new Property(0, Long.class, "ID_VISITA", true, "ID_VISITA");
		public final static Property ID_TIPO_ACCESO = new Property(1, Long.class, "ID_TIPO_ACCESO", false, "ID_TIPO_ACCESO");
		public final static Property REGISTRO = new Property(2, String.class, "REGISTRO", false, "REGISTRO");
		public final static Property ID_IDENTIFICACION = new Property(3, Long.class, "ID_IDENTIFICACION", false, "ID_IDENTIFICACION");
		public final static Property ID_VEHICULO = new Property(4, Long.class, "ID_VEHICULO", false, "ID_VEHICULO");
		public final static Property ID_CASA = new Property(5, Long.class, "ID_CASA", false, "ID_CASA");
		public final static Property ACOMPANANTES = new Property(6, Long.class, "ACOMPANANTES", false, "ACOMPANANTES");
		public final static Property ID_TIPO_VISITANTE = new Property(7, Long.class, "ID_TIPO_VISITANTE", false, "ID_TIPO_VISITANTE");
		public final static Property NOMBRE = new Property(8, String.class, "NOMBRE", false, "NOMBRE");
		public final static Property ID_TIPO_SERVICIO = new Property(9, Long.class, "ID_TIPO_SERVICIO", false, "ID_TIPO_SERVICIO");
		public final static Property OBSERVACIONES = new Property(10, String.class, "OBSERVACIONES", false, "OBSERVACIONES");
	}
	
	public TrVisitasDao(DaoConfig config) {
		super(config);
	}

	public TrVisitasDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	public static void createTable(Database db, boolean ifNotExists) {
	}

	public static void dropTable(Database db, boolean ifExists) {
	}

	@Override
	protected final void bindValues(DatabaseStatement stmt, TrVisitasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdVisita();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idTipoAcceso = entity.getIdTipoAcceso();
		if (idTipoAcceso != null) {
			stmt.bindLong(2, idTipoAcceso);
			Bitacora.getInstanceAttrs().put(2, idTipoAcceso);
		}
		String registro = entity.getRegistro();
		if (registro != null) {
			stmt.bindString(3, registro);
			Bitacora.getInstanceAttrs().put(3, registro);
		}
		Long idIdentificacion = entity.getIdIdentificacion();
		if (idIdentificacion != null) {
			stmt.bindLong(4, idIdentificacion);
			Bitacora.getInstanceAttrs().put(4, idIdentificacion);
		}
		Long idVehiculo = entity.getIdVehiculo();
		if (idVehiculo != null) {
			stmt.bindLong(5, idVehiculo);
			Bitacora.getInstanceAttrs().put(5, idVehiculo);
		}
		Long idCasa = entity.getIdCasa();
		if (idCasa != null) {
			stmt.bindLong(6, idCasa);
			Bitacora.getInstanceAttrs().put(6, idCasa);
		}
		Long acompanantes = entity.getAcompanantes();
		if (acompanantes != null) {
			stmt.bindLong(7, acompanantes);
			Bitacora.getInstanceAttrs().put(7, acompanantes);
		}
		Long idTipoVisitante = entity.getIdTipoVisitante();
		if (idTipoVisitante != null) {
			stmt.bindLong(8, idTipoVisitante);
			Bitacora.getInstanceAttrs().put(8, idTipoVisitante);
		}
		String nombre = entity.getNombre();
		if (nombre != null) {
			stmt.bindString(9, nombre);
			Bitacora.getInstanceAttrs().put(9, nombre);
		}
		Long idTipoServicio = entity.getIdTipoServicio();
		if (idTipoServicio != null) {
			stmt.bindLong(10, idTipoServicio);
			Bitacora.getInstanceAttrs().put(10, idTipoServicio);
		}
		String observaciones = entity.getObservaciones();
		if (observaciones != null) {
			stmt.bindString(11, observaciones);
			Bitacora.getInstanceAttrs().put(11, observaciones);
		}
	}

	@Override
	protected final void bindValues(SQLiteStatement stmt, TrVisitasDto entity) {
		stmt.clearBindings();
		Bitacora.setStatement(statements); 

		Long id = entity.getIdVisita();
		if (id != null) {
			stmt.bindLong(1, id);
			Bitacora.getInstanceAttrs().put(1, id);
		}
		Long idTipoAcceso = entity.getIdTipoAcceso();
		if (idTipoAcceso != null) {
			stmt.bindLong(2, idTipoAcceso);
			Bitacora.getInstanceAttrs().put(2, idTipoAcceso);
		}
		String registro = entity.getRegistro();
		if (registro != null) {
			stmt.bindString(3, registro);
			Bitacora.getInstanceAttrs().put(3, registro);
		}
		Long idIdentificacion = entity.getIdIdentificacion();
		if (idIdentificacion != null) {
			stmt.bindLong(4, idIdentificacion);
			Bitacora.getInstanceAttrs().put(4, idIdentificacion);
		}
		Long idVehiculo = entity.getIdVehiculo();
		if (idVehiculo != null) {
			stmt.bindLong(5, idVehiculo);
			Bitacora.getInstanceAttrs().put(5, idVehiculo);
		}
		Long idCasa = entity.getIdCasa();
		if (idCasa != null) {
			stmt.bindLong(6, idCasa);
			Bitacora.getInstanceAttrs().put(6, idCasa);
		}
		Long acompanantes = entity.getAcompanantes();
		if (acompanantes != null) {
			stmt.bindLong(7, acompanantes);
			Bitacora.getInstanceAttrs().put(7, acompanantes);
		}
		Long idTipoVisitante = entity.getIdTipoVisitante();
		if (idTipoVisitante != null) {
			stmt.bindLong(8, idTipoVisitante);
			Bitacora.getInstanceAttrs().put(8, idTipoVisitante);
		}
		String nombre = entity.getNombre();
		if (nombre != null) {
			stmt.bindString(9, nombre);
			Bitacora.getInstanceAttrs().put(9, nombre);
		}
		Long idTipoServicio = entity.getIdTipoServicio();
		if (idTipoServicio != null) {
			stmt.bindLong(10, idTipoServicio);
			Bitacora.getInstanceAttrs().put(10, idTipoServicio);
		}
		String observaciones = entity.getObservaciones();
		if (observaciones != null) {
			stmt.bindString(11, observaciones);
			Bitacora.getInstanceAttrs().put(11, observaciones);
		}
	}

	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	@Override
	public TrVisitasDto readEntity(Cursor cursor, int offset) {
		TrVisitasDto entity = new TrVisitasDto(
			cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0),
			cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1),
			cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2),
			cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3),
			cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4),
			cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5),
			cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6),
			cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7),
			cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8),
			cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9),
			cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10)
		);
		return entity;
	}

	@Override
	public void readEntity(Cursor cursor, TrVisitasDto entity, int offset) {
		entity.setIdVisita(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
		entity.setIdTipoAcceso(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
		entity.setRegistro(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
		entity.setIdIdentificacion(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
		entity.setIdVehiculo(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
		entity.setIdCasa(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
		entity.setAcompanantes(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
		entity.setIdTipoVisitante(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
		entity.setNombre(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
		entity.setIdTipoServicio(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
		entity.setObservaciones(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
	}

	@Override
	protected final Long updateKeyAfterInsert(TrVisitasDto entity, long rowId) {
		entity.setIdVisita(rowId);
		return rowId;
	}

	@Override
	public Long getKey(TrVisitasDto entity) {
		if (entity != null) {
			return entity.getIdVisita();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasKey(TrVisitasDto entity) {
		return entity.getIdVisita() != null;
	}

	@Override
	protected final boolean isEntityUpdateable() {
		return true;
	}

}
