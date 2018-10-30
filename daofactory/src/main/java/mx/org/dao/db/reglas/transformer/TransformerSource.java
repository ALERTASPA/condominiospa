package mx.org.dao.db.reglas.transformer;

/**
 * company: INEGI
 * project: Kaanbal
 * date: 09/05/2018
 * time: 11:47 AM
 * author: Mónica Fabiola Montañez Briano <monica.montanez@inegi.org.mx>
 */

import mx.org.dao.libs.formato.Cadena;
import mx.org.dao.libs.formato.Cadena;

public abstract class TransformerSource extends Transformer{

    @Override
    public abstract Object tuple(Object[] data, String[] fields, String[] bdNames) throws Exception;

    @Override
    protected void toFields(String[] columnNames) {
        setFields(new String[columnNames.length]);
        for(int x= 0; x< columnNames.length; x++) {
            getFields()[x] = columnNames[x];
            if (getFields()[x].toUpperCase().startsWith("ID_KEY")){
                getFields()[x] = Cadena.toBeanNameEspecial(columnNames[x]);
            }
        } // for
    } // toFields
}
