package mx.org.dao.db.enums;

/**
 *@company INEGI
 *@project IKTAN (Sistema de Seguimiento y Control de proyectos estad�sticos)
 *@date 8/02/2018
 *@time 10:45:48 AM 
 *@author Jorge Alberto Vazquez Serafin <jorge.vazquezser@inegi.gob.mx>
 */

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ESql {
  
  INSERT ("inse"),
  DELETE ("dele"),
  UPDATE ("upda"),
  UPSERT ("upse"),
  SELECT ("sele");

  private static final Map<String, ESql> lookup = new HashMap<>();
  private String init;
  private Long idAccion;

  private ESql(String init) {
    this.init = init;
  }    
  
  static {
    for (ESql item: EnumSet.allOf(ESql.class)) 
      lookup.put(item.getInit(), item);    
  } // static

  public Long getKey(){
		return this.ordinal() + 1L;
	}

  public String getInit() {
    return init;
  }
   
  public static ESql fromInit(String init) {
    return lookup.get(init);
  } 
}
