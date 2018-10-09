package alertaspa.com.mx.condominio;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;



public class Utileria {


    public static void irPagina(Activity paginaActual, Class paginaDestino) throws Exception{
        Intent intent= null;
        try{
            intent= new Intent();
            intent.setClass(paginaActual, paginaDestino);
            paginaActual.startActivity(intent);
        }//  try
        catch (Exception e){
            throw e;
        }
    }

    public static AlertDialog mensajeConfirmacionDialog(Context contexto, String titulo, String mensaje){
        return mensajeConfirmacionDialog(contexto, titulo, mensaje, null);
    } // mensajeConfirmacion

    public static AlertDialog mensajeConfirmacionDialog(Context contexto, String titulo, String mensaje, DialogInterface.OnClickListener listener){
        AlertDialog regresar= null;
        try{
            regresar= new AlertDialog.Builder(contexto).create();
            regresar.setTitle(titulo);
            regresar.setMessage(mensaje);
            regresar.setCancelable(false); // si se pone como false significa que no puede salir hasta que presione algun boton
            regresar.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", null,  listener );
        } // try
        catch (Exception e){
            Log.e("Utilerias", e.getMessage());
        } // catch
        return regresar;
    } // mensajeConfirmacion

    public static void addNotification(String titulo, String mensaje, int tipoMensaje , Context context, Class clase) {
        NotificationCompat.Builder mBuilder = null;
        NotificationManager mNotifyMgr      = null;
        Intent intent                       = null;
        PendingIntent pendingIntent         = null;
        Bitmap largeIcon                    = null;
        EditText user                       = null;
        try{

            mNotifyMgr    = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            intent        = new Intent(context,  clase);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            largeIcon     = BitmapFactory.decodeResource(context.getResources(), tipoMensaje);

            mBuilder =new NotificationCompat.Builder(context) //test
                    .setContentIntent(pendingIntent)
                    .setLargeIcon(largeIcon) //Para que es?
                    .setSmallIcon( tipoMensaje)
                    .setContentTitle(titulo)
                    .setContentText(mensaje)
                    .setVibrate(new long[] {100, 250, 100, 500})
                    .setAutoCancel(true);

            mNotifyMgr.notify(1, mBuilder.build());
        } // try
        catch (Exception e){
            Log.e("Utileria",e.getMessage());
        } // catch
    } // addNotification
}
