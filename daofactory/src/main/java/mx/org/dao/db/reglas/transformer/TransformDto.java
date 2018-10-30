package mx.org.dao.db.reglas.transformer;

/**
 * company: INEGI
 * project: Kaanbal
 * date: 08/05/2018
 * time: 12:02 PM
 * author: Mónica Fabiola Montañez Briano <monica.montanez@inegi.org.mx>
 */


import mx.org.dao.libs.formato.Error;
import mx.org.dao.libs.reflection.Methods;
import mx.org.dao.db.comun.dto.IBaseDto;

public class TransformDto extends Transformer{

    public TransformDto(Class<? extends IBaseDto> dto) {
        super(dto);
    }

    @Override
    public Object tuple(Object[] data, String[] fields, String[] bdNames) throws Exception{
        Object regresar = toNewDto();
        for (int x=0; x< data.length; x++) {
            try {
                Methods.setValue(regresar, fields[x], new Object[]{data[x]});
            } // try
            catch (Exception e) {
                Error.mensaje(e);
            } // catch
        }
        return regresar;
    } // tuple
}
