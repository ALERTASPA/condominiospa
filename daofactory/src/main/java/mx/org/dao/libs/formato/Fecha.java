
package mx.org.dao.libs.formato;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class Fecha {
	
  public static final int FECHA_NOMBRE_MES = 1;
  public static final int FECHA_CORTA = 2;
  public static final int FECHA_NOMBRE_DIA = 3;
  public static final int FECHA_EXTENDIDA = 4;
  public static final int FECHA_MINIMA = 5;
  public static final int FECHA_LARGA = 6;
  public static final int FECHA_HORA = 7;
  public static final int FECHA_HORA_CORTA= 23;
  public static final int HORA_CORTA = 8;
  public static final int HORA_LARGA = 9;
  public static final int FECHA_HORA_EXTENDIDA = 10;
  public static final int FECHA_ESTANDAR = 11;
  public static final int FECHA_MYSQL = 14;
  public static final int HORA_MYSQL = 15;
  public static final int FECHA_HORA_MYSQL = 16;
  public static final int FECHA_ORACLE = 17;
  public static final int HORA_ORACLE = 18;
  public static final int FECHA_HORA_ORACLE = 19;
  public static final int FECHA_HORA_LARGA = 20;
  public static final int DIA_FECHA_HORA = 21;
  public static final int DIA_FECHA_HORA_CORTA = 22;
	public static final int FECHA_ANIO = 24;
	public static final int FECHA_MOVIL = 25;
	public static final int FECHA_JULIANA = 26;
	public static final String SECUENCIA ="yyyyMMddHHmmssSSS";

 
	protected Fecha (){
	
	}
	
  public static String getRegistro() {
    Calendar fecha = Calendar.getInstance();
    return formatear("yyyyMMddHHmmssSSS", fecha.getTime());
  } // getRegistro

  public static Date getRegistroTypeDate() {
    Calendar fecha = Calendar.getInstance();
    return fecha.getTime();
  } // getRegistroTypeDate

  public static String getNombreDiaCorto(int dia) {
    String nombreDia[] = { "DO", "LU", "MA", "MI", "JU", "VI", "SA" };
    return nombreDia[dia - 1];
  } // getNombreDiaCorto

  public static String getNombreMes(int mes) {
    String[] nombreMes = 
    { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", 
      "diciembre" };
    return nombreMes[mes];
  } // getNombreMes

  public static String getNombreMesCorto(int mes) {
    String[] nombreMes = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC" };
    return nombreMes[mes];
  } // getNombreMes

  public static String getNombreDia(int dia) {
    String nombreDia[] = { "domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado" };
    return nombreDia[dia - 1];
  } // getNombreDia

  public static String formatear(int patron, String fecha) {
    if (fecha != null && fecha.length() > 0) {
      int anio = Integer.parseInt(fecha.substring(0, 4));
      int mes = Integer.parseInt(fecha.substring(4, 6)) - 1;
      int dia = Integer.parseInt(fecha.substring(6, 8));
      GregorianCalendar calendario = new GregorianCalendar(anio, mes, dia);
      switch (patron) {			
      case FECHA_NOMBRE_MES: // Fecha en dd/mes/yyyy   26/Noviembre/2003
        fecha = calendario.get(calendario.DATE) + "/" + getNombreMes(calendario.get(calendario.MONTH)) + "/" + fecha.substring(0,4);
        break;
      case FECHA_CORTA: // Fecha en dd/mm/yyyy    26/11/2003
        fecha = fecha.substring(6, 8) + "/" + fecha.substring(4, 6) + "/" + fecha.substring(0, 4);
        break;
      case FECHA_NOMBRE_DIA: // Fecha en:  nombre del dia, dd/mm/yyyy    Miercoles, 26/11/2003
        fecha = 
            getNombreDia(calendario.get(calendario.DAY_OF_WEEK)) + ", " + fecha.substring(6, 8) + "/" + fecha.substring(4, 6) + 
            "/" + fecha.substring(0, 4);
        break;
      case FECHA_EXTENDIDA: // Fecha en:  nombre del dia, dia mes a�o   Miercoles, 26 de Noviembre del 2003
        fecha = 
            getNombreDia(calendario.get(calendario.DAY_OF_WEEK)) + ", " + calendario.get(calendario.DATE) + " de " + getNombreMes(calendario.get(calendario.MONTH)) + 
            " de " + calendario.get(calendario.YEAR);
        break;
      case FECHA_MINIMA: // Fecha en dd/mm/yy   26/11/03
        fecha = fecha.substring(6, 8).concat("/").concat(fecha.substring(4, 6)).concat("/").concat(fecha.substring(2, 4));
        break;
      case FECHA_LARGA: // Fecha en:  dia mes a�o  26 de Noviembre del 2003
        fecha = 
            calendario.get(calendario.DATE) + " de " + getNombreMes(calendario.get(calendario.MONTH)) + " de " + calendario.get(calendario.YEAR);
        break;
      case FECHA_HORA: // Fecha en dd/mmm/yyyy hh:mm:ss  03/12/2007 12:26:00
        fecha = 
            fecha.substring(6, 8).concat("/").concat(fecha.substring(4, 6)).concat("/").concat(
            fecha.substring(0, 4)).concat(" ").concat(fecha.substring(8,10)).concat(":").concat(
            fecha.substring(10,12)).concat(":").concat(fecha.substring(12,14));
        break;
      case FECHA_HORA_CORTA: // Fecha en dd/mmm/yyyy hh:mm:ss  03/12/2007 12:26
        fecha = 
            fecha.substring(6, 8).concat("/").concat(fecha.substring(4, 6)).concat("/").concat(
            fecha.substring(0, 4)).concat(" ").concat(fecha.substring(8,10)).concat(":").concat(
            fecha.substring(10,12));
        break;
      case HORA_CORTA: // Fecha en hh:mm:ss  12:26
        fecha = fecha.substring(8, 10).concat(":").concat(fecha.substring(10, 12));
        break;
      case HORA_LARGA: // Fecha en hh:mm:ss  12:26:00
        fecha = 
            fecha.substring(8, 10).concat(":").concat(fecha.substring(10, 12)).concat(":").concat(fecha.substring(12, 14));
        break;
      case FECHA_HORA_LARGA: // Fecha en yyyyMMddhhmmss 20071203241600
        fecha = fecha.substring(0, 14);
        break;
      case FECHA_ESTANDAR: // Fecha en yyyyMMdd 20071203
        fecha = fecha.substring(0, 8);
        break;
      case FECHA_MYSQL: // Fecha en yyyy-MM-ddd  2008-08-18
        fecha = fecha.substring(0, 4).concat("-").concat(fecha.substring(4, 6)).concat("-").concat(fecha.substring(6, 8));
        break;
      case HORA_MYSQL: // Fecha en hh:mm:ss 02:06:30
        fecha = 
            fecha.substring(8, 10).concat(":").concat(fecha.substring(10, 12)).concat(":").concat(fecha.substring(12, 14));
        break;
      case FECHA_HORA_MYSQL: // Fecha en yyyy-MM-ddd hh:mm:ss 2008-08-18 02:06:30
        fecha = 
            fecha.substring(0, 4).concat("-").concat(fecha.substring(4, 6)).concat("-").concat(
            fecha.substring(6, 8)).concat(" ").concat(fecha.substring(8,10)).concat(":").concat(
            fecha.substring(10,12)).concat(":").concat(fecha.substring(12,14));
        break;
      case FECHA_ORACLE: // Fecha en yyyy-MM-ddd  2008-08-18
        fecha = fecha.substring(0, 4).concat("-").concat(fecha.substring(4, 6)).concat("-").concat(fecha.substring(6, 8));
        break;
      case HORA_ORACLE: // Fecha en hh:mm:ss 02:06:30
        fecha = 
            fecha.substring(8, 10).concat(":").concat(fecha.substring(10, 12)).concat(":").concat(fecha.substring(12, 14));
        break;
      case FECHA_HORA_ORACLE: // Fecha en yyyy-MM-ddd hh:mm:ss 2008-08-18 02:06:30
        fecha = 
            fecha.substring(0, 4).concat("-").concat(fecha.substring(4, 6)).concat("-").concat(
            fecha.substring(6, 8)).concat(" ").concat(fecha.substring(8,10)).concat(":").concat(
            fecha.substring(10,12)).concat(":").concat(fecha.substring(12,14));
        break;
      case FECHA_HORA_EXTENDIDA:
        fecha = getNombreDia(calendario.get(calendario.DAY_OF_WEEK))  + ", " + calendario.get(calendario.DATE) + " de " + getNombreMes(calendario.get(calendario.MONTH)) + 
                " de " + calendario.get(calendario.YEAR)+" "+fecha.substring(8, 10).concat(":").concat(fecha.substring(10, 12)).concat(":").concat(fecha.substring(12, 14));
                
        break;
      case DIA_FECHA_HORA: // Fecha en Dia, dd/mmm/yyyy hh:mm:ss  03/12/2007 12:26:00
        fecha = 
					  getNombreDia(calendario.get(calendario.DAY_OF_WEEK))  + ", " + 
            fecha.substring(6, 8).concat("/").concat(fecha.substring(4, 6)).concat("/").concat(
            fecha.substring(0, 4)).concat(" ").concat(fecha.substring(8,10)).concat(":").concat(
            fecha.substring(10,12)).concat(":").concat(fecha.substring(12,14));
        break;
      case DIA_FECHA_HORA_CORTA: // Fecha en Dia, dd/mmm/yyyy hh:mm:ss  03/12/2007 12:26
        fecha = 
					  getNombreDia(calendario.get(calendario.DAY_OF_WEEK))  + ", " + 
            fecha.substring(6, 8).concat("/").concat(fecha.substring(4, 6)).concat("/").concat(
            fecha.substring(0, 4)).concat(" ").concat(fecha.substring(8,10)).concat(":").concat(
            fecha.substring(10,12));
        break;
			case FECHA_ANIO: // Fecha en Dia, dd/mmm/yyyy hh:mm:ss  03/12/2007 12:26
        fecha = fecha.substring(0, 4);
        break;
	      case FECHA_MOVIL:
	      break;
	      case FECHA_JULIANA:
	      break;
      } // switch 			
    }
    else
      fecha = "";
    return fecha;
  } // formatear

  public static String formatear(String patron, Date fecha) {
    SimpleDateFormat formato = new SimpleDateFormat(patron);
    return formato.format(fecha);
  } // formatear
  
  public static String formatear(int patron, Date fecha) {
    return formatear(patron, formatear("yyyyMMddHHmmssS", fecha));
  } // formatear

  public static String formatear(int patron, Calendar fecha) {
    return formatear(patron, formatear("yyyyMMddHHmmssS", fecha.getTime()));
  } // formatear

  public static String formatear(int patron, Timestamp fecha) {
		Calendar calendar= Calendar.getInstance();
		calendar.setTimeInMillis(fecha.getTime());
    return formatear(patron, calendar);
  } // formatear

	public static String formatear(String patron, Timestamp fecha) {
		Calendar calendar= Calendar.getInstance();
		calendar.setTimeInMillis(fecha.getTime());
    return formatear(patron, calendar);
  } // formatear
  
	public static String formatear(String patron, Calendar fecha) {
    return  formatear(patron, fecha.getTime());
  } // formatear
	
  public static String formatear(int patron) {
    return formatear(patron, formatear("yyyyMMddHHmmssS", Calendar.getInstance().getTime()));
  } // formatear

  public static String getHoy() {
    return formatear(FECHA_CORTA);
  } // getHoy

  public static String getHoyEstandar() {// Fecha en yyyyMMdd 20071203
    return formatear(FECHA_ESTANDAR);
  } // getHoy
  public static String getHoyEstandarLarga() {// Fecha en yyyyMMddhhmmss 20071203241600
    return formatear(FECHA_HORA_LARGA);
  } // getHoy

  public static String getHoyExtendido() {
    return formatear(FECHA_HORA);
  } // getHoy

  public static String getHoyCoreo() {
    return formatear(FECHA_EXTENDIDA);
  } // getHoy

  public static int getDiasEnElMes(int anio, int mes) {
    int dias[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if ((anio % 4 == 0 && !(anio % 100 == 0)) || anio % 400 == 0)
      dias[1] = 29;
    return dias[mes];
  } // getDiasEnElMes

  public static int diasSiguienteMes(int anio, int mes) {
    if (mes + 1 > 11) {
      anio += 1;
      mes = 0;
    }
    else
      mes++;
    return getDiasEnElMes(anio, mes);
  } // siguienteMes

  public static String reversa(String fecha) {
    return fecha.substring(6, 8).concat("/").concat(fecha.substring(4, 6)).concat("/").concat(fecha.substring(0, 4));
  }

  public static String  getFecha(String fecha) {
    return fecha.substring(6, 10).concat(fecha.substring(3, 5)).concat(fecha.substring(0, 2));
  }

  public static int getDiaActual() {
    return Calendar.getInstance().get(Calendar.DATE);
  }

  public static int getMesActual() {
    return Calendar.getInstance().get(Calendar.MONTH) + 1;
  }

  public static int getTrimestreActual() {
    return (Calendar.getInstance().get(Calendar.MONTH)/3)+1;
  }

  public static int getAnioActual() {
    return Calendar.getInstance().get(Calendar.YEAR);
  }

  public static int diferenciasDias(String ayer, String hoy) {
    return diferenciasDias(ayer,hoy,false);    
  }
  
  public static int diferenciasDias(String ayer, String hoy, boolean absolutos) {
    int diasDiferiencia = 0;
    if (ayer != null && (ayer.length() != 8 || ayer.length() != 14)) {
      if (hoy != null && (hoy.length() != 8 || hoy.length() != 14)) {
        if (ayer.length() == 14)
          ayer = ayer.substring(0, 8);
        if (hoy.length() == 14)
          hoy = hoy.substring(0, 8);
        int anioAyer = Integer.parseInt(ayer.substring(0, 4));
        int anioHoy = Integer.parseInt(hoy.substring(0, 4));
        // fecha anterior
        java.util.Calendar fechaAyer = java.util.Calendar.getInstance();
        fechaAyer.set(anioAyer, Integer.parseInt(ayer.substring(4, 6)) - 1, Integer.parseInt(ayer.substring(6, 8)));

        // fecha posterior
        java.util.Calendar fechaHoy = java.util.Calendar.getInstance();
        fechaHoy.set(anioHoy, Integer.parseInt(hoy.substring(4, 6)) - 1, Integer.parseInt(hoy.substring(6, 8)));

        // fecha pivote
        java.util.Calendar pivote = java.util.Calendar.getInstance();
        if (anioAyer < anioHoy) {
          for (int x = anioAyer; x < anioHoy; x++) {
            pivote.set(x, 11, 31); // 31 de Diciembre de los a�os anteriores
            diasDiferiencia += pivote.get(pivote.DAY_OF_YEAR);
          } // for
          diasDiferiencia += fechaHoy.get(fechaHoy.DAY_OF_YEAR);
          diasDiferiencia -= fechaAyer.get(fechaAyer.DAY_OF_YEAR);
        }
        else if (anioHoy < anioAyer) {
          for (int x = anioHoy; x < anioAyer; x++) {
            pivote.set(x, 11, 31); // 31 de Diciembre de los a�os anteriores
            diasDiferiencia += pivote.get(pivote.DAY_OF_YEAR);
          } // for
          diasDiferiencia += fechaAyer.get(fechaAyer.DAY_OF_YEAR);
          diasDiferiencia -= fechaHoy.get(fechaHoy.DAY_OF_YEAR);
        }
        else {
          diasDiferiencia = fechaHoy.get(fechaHoy.DAY_OF_YEAR) - fechaAyer.get(fechaAyer.DAY_OF_YEAR);
        } // if
        fechaAyer = null;
        fechaHoy = null;
        pivote = null;
      } // if hoy
    } // if ayer
    return absolutos?diasDiferiencia:Math.abs(diasDiferiencia);
  } // restar
  
  public static long diferenciaSegundo(long antes, long despues) {
    long regresar = 0;
    long diferencia = despues - antes;
    regresar = diferencia / 1000;
    return regresar;
  }

  public static long diferenciaMinutos(long antes, long despues) {
    long regresar = 0;
    long diferencia = despues - antes;
    regresar = diferencia / 1000 / 60;
    return regresar;
  } // minutos

  public static long diferenciaHoras(long antes, long despues) {
    long regresar = 0;
    long diferencia = despues - antes;
    regresar = diferencia / 1000 / 60 / 60;
    return regresar;
  } // horas

  public static long milisegundos(String hora) {
    Calendar calendario = Calendar.getInstance();
    // formatos permitidos
    // hora= 6  => HHMMSS
    // hora= 8  => HH:MM:SS
    // hora= 14 => YYYYMMDDHHMMSS
    if (hora != null && (hora.length() != 6 || hora.length() != 8 || hora.length() != 14)) {
      if (hora.length() == 14)
        hora = hora.substring(8);
      if (hora.length() == 8)
        hora = hora.substring(0, 2).concat(hora.substring(3, 5)).concat(hora.substring(6, 8));
      calendario.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora.substring(0, 2)));
      calendario.set(Calendar.MINUTE, Integer.parseInt(hora.substring(2, 4)));
      calendario.set(Calendar.SECOND, Integer.parseInt(hora.substring(4, 6)));
    } // if
    return calendario.getTimeInMillis();
  } // milesegundos

  public static long diferenciaHoras(String antes, String despues) {
    return diferenciaHoras(milisegundos(antes), milisegundos(despues));
  } // diferenciaHoras

  public static long diferenciaMinutos(String antes, String despues) {
    return diferenciaMinutos(milisegundos(antes), milisegundos(despues));
  } // diferenciaMinutos

  public static long horas(int dias) {
    return dias * 24;
  } // diferenciaMinutos

  public static String[] meses(int iMes) {
    String[] meses = new String[12];
    String[] nombreMes = 
    { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", 
      "Diciembre" };
    System.arraycopy(nombreMes, 0, meses, 0, iMes);
    return meses;
  }

  public static Calendar getFechaHora(String fecha) {
    // dd/MM/yyyy HH:mm:ss
    // 0123456789012345678
    // yyyyMMddHHmmss
    // 01234567890123
     // yyyyMMddHHmmssS
     // 01234567890123456
    // yyyy-MM-dd HH:mm:ss.S
    // 012345678901234567012
    if (fecha.length() == 6) // yyyyMMdd
      fecha = reversa(fecha);
    else 
      if (fecha.length() == 8) // dd/mm/yy
        fecha = fecha.substring(0, 6).concat("19").concat(fecha.substring(6)).concat(" 00:00:00");
    else 
      if (fecha.length() == 10) // dd/mm/yyyy
        fecha = getFormatoEspaniol(fecha).concat(" 00:00:00");
    else 
      if (fecha.length() == 12) // yyyyMMddHHmm
        fecha= reversa(fecha.substring(0, 8)).concat(" ").concat(fecha.substring(8, 10)).concat(":").concat(fecha.substring(10, 12)).concat(":");
    else 
      if (fecha.length() == 14 || fecha.length() == 15 || fecha.length() == 16 || fecha.length() == 17) // yyyyMMddHHmmss YYYYMMDDHHmmssS
        fecha = reversa(fecha.substring(0, 8)).concat(" ").concat(fecha.substring(8, 10)).concat(":").concat(fecha.substring(10, 12)).concat(":").concat(fecha.substring(12, 14));
      else 
        if (fecha.length() >= 20) // dd/mm/yyyy HH:mm:ss.S
          fecha = getFormatoEspaniol(fecha.substring(0, 10)).concat(fecha.substring(10));
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DATE, Numero.getInteger(fecha.substring(0, 2)));
    calendar.set(Calendar.MONTH, Numero.getInteger(fecha.substring(3, 5)) - 1);
    calendar.set(Calendar.YEAR, Numero.getInteger(fecha.substring(6, 10)));
    calendar.set(Calendar.HOUR_OF_DAY, Numero.getInteger(fecha.substring(11, 13)));
    calendar.set(Calendar.MINUTE, Numero.getInteger(fecha.substring(14, 16)));
    calendar.set(Calendar.SECOND, Numero.getInteger(fecha.substring(17, 19)));
    return calendar;
  }

  private static String getFormatoEspaniol(String fecha) {
    if (fecha.indexOf("/") == 4 || fecha.indexOf("-") == 4)
      return fecha.substring(8, 10).concat("/").concat(fecha.substring(5, 7)).concat("/").concat(fecha.substring(0, 4));
    else
      return fecha;
  }

  public static Calendar getFechaCalendar(String fecha) {
    // DD/MM/YYYY DD-MM-YYYY
    return getFechaHora(fecha.concat(" 00:00:00"));
  }

  public static Calendar getHora(String hora) {
    // HH:MM:SS
    return getFechaHora("01/01/9999 ".concat(hora).concat(hora.length() == 5 ? ":00" : ""));
  } // getHora

  public static String getHoraExtendida() {
    return formatear(HORA_LARGA);
  } // getHoraExtendida  
	
	public static String getFechaDiaAnterior(int patron, Timestamp fecha) {
		Calendar calendar= Calendar.getInstance();		
		calendar.setTimeInMillis(fecha.getTime());
		calendar.add(GregorianCalendar.DATE, -1);			
    return formatear(patron, calendar);
  } // formatear
	
	public static String getFechaHoraAnterior(int patron, Timestamp fecha) {
		Calendar calendar= Calendar.getInstance();		
		calendar.setTimeInMillis(fecha.getTime());
		calendar.add(GregorianCalendar.HOUR, -1);			
    return formatear(patron, calendar);
  } // formatear

  public static int getWorkingDaysBetween(Date startDate, Date endDate, List<Date> holiDays) throws Exception {       
    SimpleDateFormat fechaInicio= new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat fechaFin   = new SimpleDateFormat("dd/MM/yyyy");
    Calendar startCal = Calendar.getInstance();
    Calendar endCal   = Calendar.getInstance();
    int workDays      = 0;
    try {
      startCal.setTime(new java.sql.Date(fechaInicio.parse(formatear(FECHA_CORTA, startDate)).getTime()));            
      endCal.setTime(fechaFin.parse(formatear(FECHA_CORTA, endDate)));
      //Return 1 if start and end are the same
      if (startCal.get(Calendar.DAY_OF_MONTH)== endCal.get(Calendar.DAY_OF_MONTH) && startCal.get(Calendar.MONTH)== endCal.get(Calendar.MONTH) && startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR) )
        return 1;
      if (startCal.getTimeInMillis()> endCal.getTimeInMillis()) {
        startCal.setTime(fechaFin.parse(formatear(FECHA_CORTA, endDate)));
        endCal.setTime(new java.sql.Date(fechaInicio.parse(formatear(FECHA_CORTA, startDate)).getTime()));
      } // if
      do {
        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
          boolean isNotHoliDay= true;
          for (Date date: holiDays) {          
            isNotHoliDay= !((date.getMonth())== startCal.get(Calendar.MONTH) && date.getDate()== startCal.get(Calendar.DATE));
            if(!isNotHoliDay) 
              break;
          } // for
          if(isNotHoliDay)
            ++workDays;
        } // if  
        startCal.add(Calendar.DAY_OF_MONTH, 1); 
        //} while (startCal.get(Calendar.DAY_OF_MONTH)!= endCal.get(Calendar.DAY_OF_MONTH) || (startCal.get(Calendar.MONTH)!= endCal.get(Calendar.MONTH) || startCal.get(Calendar.YEAR) != endCal.get(Calendar.YEAR))); 
      } while (startCal.before(endCal) || startCal.equals(endCal));         
    } // try
    catch (Exception e) {      
      throw e;
    } // catch		
    return workDays;
  }
  
  public static int getWorkingDaysBetween(Date startDate, Date endDate) throws Exception {
    return getWorkingDaysBetween(startDate, endDate, new ArrayList<Date>());
  }  
  
  
  public static int getBetweenDays(Date startDate, Date endDate) {
    Calendar startCal = Calendar.getInstance();
    startCal.setTime(startDate);        
    Calendar endCal = Calendar.getInstance();
    endCal.setTime(endDate);
    //Return 0 if start and end are the same
    if (startCal.get(Calendar.DAY_OF_MONTH) == endCal.get(Calendar.DAY_OF_MONTH) && startCal.get(Calendar.MONTH) == endCal.get(Calendar.MONTH) && startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR))
      return 1;
    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
      startCal.setTime(endDate);
      endCal.setTime(startDate);
    } // if
    return (int)((endCal.getTimeInMillis() - startCal.getTimeInMillis())/ (1000 * 60 * 60 * 24))+ 2;
  }
  
  public static boolean isSunday(Date date){
    Calendar calendar= Calendar.getInstance();
    boolean regresar = false;
    calendar.setTime(date);
    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
      regresar= true;    
    return regresar;
  }
  
  public static boolean isMonday(Date date){
    Calendar calendar= Calendar.getInstance();
    boolean regresar = false;    
    calendar.setTime(date);
    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
      regresar= true;    
    return regresar;
  }
  
  public static Date toAddDays(Long timeInMillis, int days){
    Calendar calendar= Calendar.getInstance();
    calendar.setTimeInMillis(timeInMillis);
    calendar.add(GregorianCalendar.DATE, days);
    return new Date(calendar.getTimeInMillis());
  }
  
  public static Date toAddWorkingDays(Date startDate, int days, List<Date> holiDays){
    Calendar fecha = Calendar.getInstance();
    Date regresar  = null;
    int workDays   = 0;    
    if(days<= 0)
      regresar= startDate;
    else {
      fecha.setTime(startDate);            
      do {
        fecha.add(Calendar.DAY_OF_YEAR, 1); 
        if (fecha.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && fecha.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
          workDays++;
          for (Date date: holiDays) {          
            if ((date.getMonth())== fecha.get(Calendar.MONTH) && date.getDate()== fecha.get(Calendar.DATE)){
              workDays--;
              break;
            }// if
          } // for
        } // if
      } while (workDays< days);
      regresar= fecha.getTime();
    }// else    
    return regresar;
  } // toAddWorkingDays
  
  
  public static Date toAddWorkingDays(Date startDate, int days){	
    return toAddWorkingDays(startDate, days, new ArrayList<Date>());
  } // toAddWorkingDays

	public static final Integer secondOfTheDay(Calendar calendar){
		Integer regresar = null;
		long passed;
		long secondsPassed;
		try{
			long now = calendar.getTimeInMillis();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			passed = now - calendar.getTimeInMillis();
			secondsPassed = passed / 1000;
			regresar = (int)secondsPassed;
		} // try
		catch(Exception e){
			throw e;
		} // catch
		return regresar;
	} // secondOfTheDay

	public static final Integer fechaJuliana(Date date){
		Integer regresar =null;
		try{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			String syear = String.format("%04d",year).substring(2);
			int century = Integer.parseInt(String.valueOf(((year / 100)+1)).substring(1));
			regresar = Integer.parseInt(String.format("%d%s%03d",century,syear,calendar.get(Calendar.DAY_OF_YEAR)));
		} // try
		catch(Exception e){
			throw e;
		} // catch
		return regresar;
	} // fechaJuliana

	public static String epochTime(long time){
		Date date=null;
		DateFormat format = null;
		String regresar = null;
		try{

			date = new Date(time);
			format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			format.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
			regresar = format.format(date);
			System.out.println(regresar);
		} // try
		catch(Exception e){
			Error.mensaje(e);
		} // catch
	return regresar;
	} // epochTime
} // Fecha

