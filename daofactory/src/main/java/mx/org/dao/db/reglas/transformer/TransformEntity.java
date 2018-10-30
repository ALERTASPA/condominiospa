package mx.org.dao.db.reglas.transformer;

/**
 * company: INEGI
 * project: Kaanbal
 * date: 08/05/2018
 * time: 12:01 PM
 * author: Mónica Fabiola Montañez Briano <monica.montanez@inegi.org.mx>
 */

import mx.org.dao.db.comun.sql.Entity;
import mx.org.dao.db.comun.sql.Value;

public class TransformEntity extends Transformer{

    @Override
    public Object tuple(Object[] data, String[] fields, String[] bdNames) throws Exception {
        Entity regresar = new Entity();
        for (int x=0; x< data.length; x++) {
            regresar.put(fields[x], new Value(fields[x], data[x], bdNames[x]));
        } // for
        return regresar;
    } // tuple
}
