package alertaspa.com.mx.condominio.plantillas.reglas;

import android.content.Context;
import android.util.Log;

import java.io.File;

import alertaspa.com.mx.condominio.libs.activity.Bloqueo;

public class Hilo  extends Bloqueo {



    public Hilo(Context contexto) {
        this.contexto = contexto;

    }

    @Override
    protected Object doInBackground(Object... objects) {
        int total =0;
        int paso  =1;

        try{
            total=250;
            for (int i =0;i<total;i++) {
                Thread.sleep(30);
                this.progressDialog.setMax(total);
                switch (i) {
                    case 120: paso=2;
                    break;
                    case 240: paso=3;
                        break;

                }
                this.updateDialog("Procesando ... paso 3/"+paso, i);
            }//for

        } // try
        catch(Exception e){
            Log.e("Hilo",e.getMessage());
        } // catch
        return null;
    }

   @Override
    protected boolean isProgressBar(){
        return false;
    } // isProgressBar

    @Override
    protected int getMax() {
        return 250;
    }
}
