package mx.org.dao.db.reglas;

import mx.org.dao.db.enums.EAccion;

public abstract class IBaseTnx {

    protected abstract boolean procesar(EAccion accion) throws Exception;

    public final boolean ejecutar(EAccion accion) throws Exception {
        boolean regresar= false;
        try {
            DaoFactory.getInstance().getMasterSession().getDatabase().beginTransaction();
            regresar= procesar(accion);
            DaoFactory.getInstance().getMasterSession().getDatabase().setTransactionSuccessful();
        } // try
        catch (Exception e) {
            throw e;
        } // catch
        finally {
            DaoFactory.getInstance().getMasterSession().getDatabase().endTransaction();
            DaoFactory.getInstance().getMasterSession().clear();
        } // finally
        return regresar;
    } // ejecutar
}
