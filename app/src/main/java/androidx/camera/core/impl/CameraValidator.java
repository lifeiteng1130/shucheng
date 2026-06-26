package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class CameraValidator {
    private static final String TAG = "CameraValidator";

    public static class CameraIdListIncorrectException extends Exception {
        public CameraIdListIncorrectException(@Nullable String str, @Nullable Throwable th) {
            super(str, th);
        }
    }

    private CameraValidator() {
    }

    public static void validateCameras(@NonNull Context context, @NonNull CameraRepository cameraRepository) {
        PackageManager packageManager = context.getPackageManager();
        StringBuilder sbR = a.r("Verifying camera lens facing on ");
        sbR.append(Build.DEVICE);
        Logger.d(TAG, sbR.toString());
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera")) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras());
            }
            if (packageManager.hasSystemFeature("android.hardware.camera.front")) {
                CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras());
            }
        } catch (IllegalArgumentException e2) {
            StringBuilder sbR2 = a.r("Camera LensFacing verification failed, existing cameras: ");
            sbR2.append(cameraRepository.getCameras());
            Logger.e(TAG, sbR2.toString());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", e2);
        }
    }
}
