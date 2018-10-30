package mx.org.dao.db.reglas.transformer;

/**
 * company: INEGI
 * project: Kaanbal
 * date: 09/05/2018
 * time: 11:56 AM
 * author: Mónica Fabiola Montañez Briano <monica.montanez@inegi.org.mx>
 */

import mx.org.dao.db.comun.sql.SourceEntity;
import mx.org.dao.db.comun.sql.Value;

public class TransformSourceEntity extends TransformerSource{

    @Override
    public Object tuple(Object[] data, String[] fields, String[] bdNames) throws Exception {
        SourceEntity regresar = new SourceEntity();
        for (int x=0; x< data.length; x++) {
            regresar.put(fields[x], new Value(fields[x], data[x], bdNames[x]));
        } // for
        return regresar;
    } // tuple
}
