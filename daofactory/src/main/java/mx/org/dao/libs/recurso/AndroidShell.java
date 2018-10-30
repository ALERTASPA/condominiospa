package mx.org.dao.libs.recurso;
/**
 * @author andres hernández lara <andres.lara@inegi.org.mx>
 * @company INEGI
 * @proyect IKTAN (Sistema de Seguimiento y Control de proyectos estadísticos)
 * @date 17/05/2018.
 * @time 04:32 PM.
 */


import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AndroidShell{
	private static AndroidShell instance;

	public static AndroidShell getInstance() {
		if (instance == null) {
			if (instance == null)
				instance = new AndroidShell();
		} // if
		return instance;
	}

	public String ejecutarcomando(String Command) throws IOException, InterruptedException {
		Process proc          = null;
		String regresar       = null;
		String line           = null;
		Runtime runtime       = null;
		InputStream is        = null;
		InputStreamReader isr = null;
		BufferedReader br     = null;
		String salida         = "";
		int exitVal           = 0;
		try {
			System.err.println("comando ejecutado: " + Command);
			runtime = Runtime.getRuntime();
			proc = runtime.exec(Command);
			is = proc.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			salida += "<SALIDA>";
			while ((line = br.readLine()) != null){
				salida += line;
				regresar = line;
			} // while
			salida += "</SALIDA>";
			is = proc.getErrorStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			line = null;
			salida += "<ERROR>";
			while ( (line = br.readLine()) != null)
				salida += line;
			salida +="</ERROR>";
			exitVal = proc.waitFor();
			salida += "Process exitValue: " + exitVal;
			Log.d("Shell", "Salida del comando:\n".concat(salida));
		} // try
		catch (Exception e) {
			throw e;
		} // catch
		return regresar;
	}

	public String ejecutarComandoSu(String Command) throws IOException, InterruptedException {
		Process procces = null;
		String regresar = null;
		String line = null;
		Runtime runtime = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String salida = "";
		int exitVal = 0;
		try {
			procces = Runtime.getRuntime().exec("su");
			DataOutputStream dos = new DataOutputStream(procces.getOutputStream());
			dos.writeBytes(Command);
			dos.flush();
			dos.close();

			is = procces.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			salida += "<SALIDA>";
			while ((line = br.readLine()) != null){
				salida += line;
				regresar = line;
			} // while
			salida += "</SALIDA>";
			if (is!= null){
				is = procces.getErrorStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				line = null;
				salida += "<ERROR>";
				while ( (line = br.readLine()) != null)
					salida += line;
				salida +="</ERROR>";
			}
			exitVal = procces.waitFor();
			salida += "Process exitValue: " + exitVal;
		} // try
		catch (Exception e) {
			throw e;
		} // catch
		return regresar;
	}
}