package mx.org.dao.libs.recurso;
/**
 * @author andres hernández lara <andres.lara@inegi.org.mx>
 * @company INEGI
 * @proyect IKTAN (Sistema de Seguimiento y Control de proyectos estadísticos)
 * @date 16/05/2018.
 * @time 01:36 PM.
 */

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import mx.org.dao.comun.UtileriasDao;
import mx.org.dao.libs.formato.Error;

public class Equipo {
	private static Equipo instance;

	private Context contexto;
	private String nombreEquipo;
	private String MAC;

	public String getNombreEquipo() {
		String figura              = null;
		String prefijofinal        = null;
		Date today                 = null;
		SimpleDateFormat formatter = null;
		String datepart            = null;
		Random random              = null;
		String regresar            = null;
		try{
			/*N1 etc*/
			figura = "N";//.concat(Configuracion.getInstance().getPropiedad("POSICION_COODINACION"));
			prefijofinal = "";

			/*date format*/
			today = Calendar.getInstance().getTime();
			formatter = new SimpleDateFormat("MMddhhmmSSS");
			datepart = formatter.format(today);

			/*caracteres finales random*/
			random = new Random();
			prefijofinal+= (char)(random.nextInt(91 - 65) + 65);
			prefijofinal+= (char)(random.nextInt(91 - 65) + 65);

			regresar = figura.concat(datepart).concat(prefijofinal);
		} // try
		catch(Exception e){
			Error.mensaje(e);
		} // catch
		return regresar;
	}

	public String getMAC() {
		List<NetworkInterface> all = null;
		StringBuilder sb = null;
		try {
			all = Collections.list(NetworkInterface.getNetworkInterfaces());
			for (NetworkInterface nif : all) {
				if (!nif.getName().equalsIgnoreCase("wlan0")) continue;
				byte[] macBytes = nif.getHardwareAddress();
				if (macBytes == null) {
					return "";
				} // if
				sb = new StringBuilder();
				for (byte b : macBytes) {
					sb.append(Integer.toHexString(b & 0xFF) + ":");
				} // for
				if (sb.length() > 0) {
					sb.deleteCharAt(sb.length() - 1);
				} // if
				return sb.toString().toUpperCase();
			} // for
		} // try
		catch (Exception e) {
			Error.mensaje(e);
		} // catch
		return "";
	} // MAC

	public Equipo(Context contexto) {
		this.contexto = contexto;
	}

	public static Equipo getInstance() {
		return getInstance(UtileriasDao.getAppContext());
	}

	public static Equipo getInstance(Context contexto) {
		if (instance == null) {
			if (instance == null)
				instance = new Equipo(contexto);
		} // if
		return instance;
	}

	protected String ejecutarcomando(String Command) {
		Process proc = null;
		String regresar = null;
		try {
			System.err.println("comando ejecutado: " + Command);
			Runtime rt = Runtime.getRuntime();
			proc = rt.exec(Command);
			InputStream stderr = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				//System.err.println(line);
				regresar = line;
		} // try
		catch (Exception e) {
			Error.mensaje(e);
		} // catch*/
		return regresar;
	}
}