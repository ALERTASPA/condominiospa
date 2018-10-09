package alertaspa.com.mx.condominio.camara;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import alertaspa.com.mx.condominio.R;
import alertaspa.com.mx.condominio.databinding.CamaraAccionBinding;
import alertaspa.com.mx.condominio.plantillas.backing.PlantillasFiltro;

public class CamaraAccion extends PlantillasFiltro {

    private CamaraAccionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            this.contenido.setLayoutResource(R.layout.camara_accion);
            this.binding= DataBindingUtil.getBinding(this.bindingPlantilla.contenidoContenido.getViewStub().inflate());
            this.binding.setCamaraAccion(this);


            ((CamaraAccionBinding)this.binding).cameraView.start();
            ((CamaraAccionBinding)this.binding).cameraView.addCameraKitListener(new CameraKitEventListener() {
                @Override
                public void onEvent(CameraKitEvent cameraKitEvent) {}

                @Override
                public void onError(CameraKitError cameraKitError) {}

                @Override
                public void onImage(CameraKitImage cameraKitImage) {
                    Bitmap result = null;
                    byte[] picture = null;
                    File pictureFile        = null;
                    FileOutputStream fos    = null;

                    try{
                        picture = cameraKitImage.getJpeg();
                        result = BitmapFactory.decodeByteArray(picture, 0, picture.length);
                        pictureFile = getOutputMediaFile(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE);
                        if (pictureFile != null) {
                            fos = new FileOutputStream(pictureFile);
                            fos.write(picture);
                            fos.close();
                            storeImage(result, pictureFile.getAbsolutePath());
                        }
                    } // try
                    catch(Exception e){
                        Log.e("CamaraAccion",e.getMessage());
                    } // catch
                }

                @Override
                public void onVideo(CameraKitVideo cameraKitVideo) {}
            });
        }
        catch (Exception e){
            Log.e("CamaraAccion",e.getMessage());
        }

    }

    public boolean storeImage(Bitmap imageData, String absolutePath) {
        File sdIconStorageDir = null;
        try {
            sdIconStorageDir = new File(absolutePath);
            if(!sdIconStorageDir.exists()) {
                sdIconStorageDir.mkdirs();
            } // if
            String filePath = absolutePath;
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
            imageData.compress(Bitmap.CompressFormat.JPEG, 80, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            Log.e("CamaraAccion",e.getMessage());
            return false;
        }
        return true;
    }

    private File getOutputMediaFile(int type){
        File mediaStorageDir = null;
        File mediaFile   = null;
        String folio     = null;
        try{
            mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory("/DCIM/Camera/"),"Camera");
            if (!mediaStorageDir.exists()){
                if (! mediaStorageDir.mkdirs()){
                    Log.d("CamaraAccion","failed to create directory");
                    return null;
                }
            }
            if (type == MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE){
                mediaFile = new File(mediaStorageDir.getPath() + File.separator +  "foto.jpg");

            } // if
        } // try
        catch(Exception e){
            Log.e("CamaraAccion",e.getMessage());
        } // catch
        return mediaFile;
    }

    @Override
    public void doAceptar(View view){
        try {
            ((CamaraAccionBinding)this.binding).cameraView.captureImage();
        } catch (Exception e) {
            Log.e("PlantillasFiltro",e.getMessage());
        }//try-catch
    }
}
