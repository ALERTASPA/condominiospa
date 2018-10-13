package alertaspa.com.mx.condominio.casas.reglas;

import alertaspa.com.mx.condominio.db.dtos.TcCasasDto;
import mx.org.dao.db.enums.EAccion;
import mx.org.dao.db.reglas.DaoFactory;
import mx.org.dao.db.reglas.IBaseTnx;

public class Transaccion extends IBaseTnx {
  private TcCasasDto tcCasasDto;

  public Transaccion(TcCasasDto tcCasasDto) {
    this.tcCasasDto = tcCasasDto;
  }

  @Override
  protected boolean procesar(EAccion accion) throws Exception {
    boolean regresar= false;
    try{
      switch (accion){
        case AGREGAR:
          DaoFactory.getInstance().insert(this.tcCasasDto);
          break;
        case MODIFICAR:
          DaoFactory.getInstance().update(this.tcCasasDto);
          break;
        case ELIMINAR:
          DaoFactory.getInstance().delete(this.tcCasasDto);
          break;
      }// switch
      regresar= true;
    }// try
    catch(Exception e ){
      throw e;
    }// catch

    return regresar;
  }
}
