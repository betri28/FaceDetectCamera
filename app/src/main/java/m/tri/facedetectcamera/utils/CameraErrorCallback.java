package m.tri.facedetectcamera.utils;

import android.hardware.Camera;
import android.util.Log;

/**
 * Created by Nguyen on 5/20/2016.
 */

public class CameraErrorCallback implements Camera.ErrorCallback {

    private static final String TAG = "CameraErrorCallback";

    @Override
    public void onError(int error, Camera camera) {
        Log.e(TAG, "Encountered an unexpected camera error: " + error);
    }
}