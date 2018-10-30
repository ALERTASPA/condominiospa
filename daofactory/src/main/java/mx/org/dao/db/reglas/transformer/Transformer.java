package mx.org.dao.db.reglas.transformer;

/**
 * company: INEGI
 * project: Kaanbal
 * date: 08/05/2018
 * time: 10:49 AM
 * author: Mónica Fabiola Montañez Briano <monica.montanez@inegi.org.mx>
 */

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

import mx.org.dao.libs.formato.Cadena;
import mx.org.dao.libs.formato.Cadena;
import mx.org.dao.db.comun.dto.IBaseDto;

public abstract class Transformer <T extends IBaseDto> {
    private Cursor cursor;
    private Class dto;
    private String[] fields;

    public Transformer() {
        this(null);
    }

    public Transformer(Class<? extends IBaseDto> dto) {
        setDto(dto);
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        toFields(cursor.getColumnNames());
    }

    public void setDto(Class dto) {
        this.dto = dto;
    }

    public Class getDto() {
        return dto;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String[] getFields() {
        return fields;
    }

    protected void toFields(String[] columnNames) {
        this.fields = new String[columnNames.length];
        for(int x= 0; x< columnNames.length; x++) {
            this.fields[x] = Cadena.toBeanNameEspecial(columnNames[x]);
        } // for
    } // toFields

    private Object[] toDataArray(){
        Object[] regresar = new Object[this.fields.length];
        for(int x= 0; x< this.fields.length; x++) {
            regresar[x] = getDataByType(x);
        } // for
        return regresar;
    } // toDataArray

    private Object getDataByType(int posicion){
        Object regresar = null;
        switch (cursor.getType(posicion)){
            case Cursor.FIELD_TYPE_NULL:
                regresar = cursor.getString(posicion);
                break;

            case Cursor.FIELD_TYPE_INTEGER:
                regresar = cursor.getLong(posicion);
                break;

            case Cursor.FIELD_TYPE_FLOAT:
                regresar = cursor.getDouble(posicion);
                break;

            case Cursor.FIELD_TYPE_STRING:
                regresar = cursor.getString(posicion);
                break;

            case Cursor.FIELD_TYPE_BLOB:
                regresar = cursor.getBlob(posicion);
                break;
        } // switch
        return regresar;
    } // getDataType

    protected Object toNewDto() throws InstantiationException, IllegalAccessException {
        return getDto()!= null? getDto().newInstance(): null;
    } // toNewDto

    public abstract Object tuple(Object[] data, String[] fields, String[] bdNames) throws Exception;

    public List<T> toList() throws Exception{
        List<T> regresar = null;
        try {
            regresar = new ArrayList<>();
            while (cursor.moveToNext()) {
                regresar.add((T)tuple(toDataArray(), getFields(), cursor.getColumnNames()));
            } // while
        } // try
        catch (Exception e){
            throw e;
        } // catch
        finally {
            cursor.close();
        } // finally
        return regresar;
    } // toList
}
