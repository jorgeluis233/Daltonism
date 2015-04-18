package green.edu.intec.daltonism;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by Jorge on 4/18/2015.
 */
public class BitmapConverter {



    public byte[] getByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    public Bitmap getBitMap(byte[] array){
        Bitmap bmp = BitmapFactory.decodeByteArray(array, 0, array.length);
        return bmp;
    }
}
