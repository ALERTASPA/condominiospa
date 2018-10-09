package alertaspa.com.mx.condominio.libs.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public abstract class Bloqueo extends AsyncTask<Object, Object, Object> {

    protected ProgressDialog progressDialog;
    private String mensaje;
    private int position;
    protected Context contexto;

    @Override
    protected void onPreExecute() {
        try{
            super.onPreExecute();
            this.mensaje= getMensaje();
            this.progressDialog = new ProgressDialog(contexto);
            this.progressDialog.setProgressStyle(isProgressBar()? ProgressDialog.STYLE_HORIZONTAL:  ProgressDialog.STYLE_SPINNER);
            this.progressDialog.setMessage(this.mensaje);
            this.progressDialog.setMax(getMax());
            this.progressDialog.setCancelable(isCancelable());
            this.progressDialog.setProgress(0);
            this.progressDialog.show();
        } // try
        catch(Exception e){
            Log.e("Bloqueo",e.getMessage());
        } // catch
    } // onPreExecute

    @Override
    protected void onProgressUpdate(Object... values) {
        try{
            this.mensaje= (String)values[0];
            this.progressDialog.setMessage(this.mensaje);
            this.progressDialog.setProgress((int)values[1]);
        } // try
        catch(Exception e){
            Log.e("Bloqueo",e.getMessage());
        } // catch
    } // onProgressUpdate

    @Override
    protected void onPostExecute(Object o) {
        try{
            super.onPostExecute(o);
            this.progressDialog.dismiss();
        } // try
        catch(Exception e){
            Log.e("Bloqueo",e.getMessage());
        } // catch
    }

    @Override
    protected void onCancelled(Object o) {
        try{
            super.onCancelled(o);
            this.progressDialog.dismiss();
        } // try
        catch(Exception e){
            Log.e("Bloqueo",e.getMessage());
        } // catch
    }

    protected String getMensaje(){
        return "Espere por favor...";
    } // getMensaje

    protected int getMax(){
        return 100;
    } // getMax

    protected void updateDialog(String mensaje){
        updateDialog(mensaje, 0);
    } // updateMensaje

    protected void updateDialog(int porcentaje){
        updateDialog(this.mensaje, porcentaje);
    } // updateMensaje

    protected void updateDialog(String mensaje, int porcentaje){
        publishProgress(mensaje, porcentaje);
    } // updateMensaje

    protected boolean isCancelable(){
        return false;
    } // isCancelable

    protected boolean isProgressBar(){
        return false;
    } // isProgressBar
}
