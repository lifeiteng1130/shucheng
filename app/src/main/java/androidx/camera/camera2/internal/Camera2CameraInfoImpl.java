package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.experimental.UseExperimental;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ExperimentalExposureCompensation;
import androidx.camera.core.ExposureState;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@UseExperimental(markerClass = ExperimentalCamera2Interop.class)
public final class Camera2CameraInfoImpl implements CameraInfoInternal {
    private static final String TAG = "Camera2CameraInfo";

    @Nullable
    @GuardedBy("mLock")
    private Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private final String mCameraId;

    @NonNull
    private final Quirks mCameraQuirks;
    private final Object mLock = new Object();

    @Nullable
    @GuardedBy("mLock")
    private RedirectableLiveData<Integer> mRedirectTorchStateLiveData = null;

    @Nullable
    @GuardedBy("mLock")
    private RedirectableLiveData<ZoomState> mRedirectZoomStateLiveData = null;

    @Nullable
    @GuardedBy("mLock")
    private List<Pair<CameraCaptureCallback, Executor>> mCameraCaptureCallbacks = null;
    private final Camera2CameraInfo mCamera2CameraInfo = new Camera2CameraInfo(this);

    public static class RedirectableLiveData<T> extends MediatorLiveData<T> {
        private T mInitialValue;
        private LiveData<T> mLiveDataSource;

        public RedirectableLiveData(T t) {
            this.mInitialValue = t;
        }

        @Override // androidx.view.MediatorLiveData
        public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.view.LiveData
        public T getValue() {
            LiveData<T> liveData = this.mLiveDataSource;
            return liveData == null ? this.mInitialValue : liveData.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void redirectTo(@NonNull LiveData<T> liveData) {
            LiveData<T> liveData2 = this.mLiveDataSource;
            if (liveData2 != null) {
                super.removeSource(liveData2);
            }
            this.mLiveDataSource = liveData;
            super.addSource(liveData, new Observer() { // from class: b.a.a.d.w0
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    this.a.setValue(obj);
                }
            });
        }
    }

    public Camera2CameraInfoImpl(@NonNull String str, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mCameraId = (String) Preconditions.checkNotNull(str);
        this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
        this.mCameraQuirks = CameraQuirks.get(str, cameraCharacteristicsCompat);
    }

    private void logDeviceInfo() {
        logDeviceLevel();
    }

    private void logDeviceLevel() {
        int supportedHardwareLevel = getSupportedHardwareLevel();
        Logger.i(TAG, "Device Level: " + (supportedHardwareLevel != 0 ? supportedHardwareLevel != 1 ? supportedHardwareLevel != 2 ? supportedHardwareLevel != 3 ? supportedHardwareLevel != 4 ? a.G("Unknown value: ", supportedHardwareLevel) : "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL" : "INFO_SUPPORTED_HARDWARE_LEVEL_3" : "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY" : "INFO_SUPPORTED_HARDWARE_LEVEL_FULL" : "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED"));
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void addSessionCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.mLock) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
            if (camera2CameraControlImpl != null) {
                camera2CameraControlImpl.addSessionCameraCaptureCallback(executor, cameraCaptureCallback);
                return;
            }
            if (this.mCameraCaptureCallbacks == null) {
                this.mCameraCaptureCallbacks = new ArrayList();
            }
            this.mCameraCaptureCallbacks.add(new Pair<>(cameraCaptureCallback, executor));
        }
    }

    @NonNull
    public Camera2CameraInfo getCamera2CameraInfo() {
        return this.mCamera2CameraInfo;
    }

    @NonNull
    public CameraCharacteristicsCompat getCameraCharacteristicsCompat() {
        return this.mCameraCharacteristicsCompat;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @NonNull
    public String getCameraId() {
        return this.mCameraId;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @NonNull
    public Quirks getCameraQuirks() {
        return this.mCameraQuirks;
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    @ExperimentalExposureCompensation
    public ExposureState getExposureState() {
        synchronized (this.mLock) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
            if (camera2CameraControlImpl == null) {
                return ExposureControl.getDefaultExposureState(this.mCameraCharacteristicsCompat);
            }
            return camera2CameraControlImpl.getExposureControl().getExposureState();
        }
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public String getImplementationType() {
        return getSupportedHardwareLevel() == 2 ? CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY : CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @Nullable
    public Integer getLensFacing() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        Preconditions.checkNotNull(num);
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            return iIntValue != 1 ? null : 1;
        }
        return 0;
    }

    public int getSensorOrientation() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int i2) {
        Integer numValueOf = Integer.valueOf(getSensorOrientation());
        int iSurfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i2);
        Integer lensFacing = getLensFacing();
        return CameraOrientationUtil.getRelativeImageRotation(iSurfaceRotationToDegrees, numValueOf.intValue(), lensFacing != null && 1 == lensFacing.intValue());
    }

    public int getSupportedHardwareLevel() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public LiveData<Integer> getTorchState() {
        synchronized (this.mLock) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
            if (camera2CameraControlImpl == null) {
                if (this.mRedirectTorchStateLiveData == null) {
                    this.mRedirectTorchStateLiveData = new RedirectableLiveData<>(0);
                }
                return this.mRedirectTorchStateLiveData;
            }
            RedirectableLiveData<Integer> redirectableLiveData = this.mRedirectTorchStateLiveData;
            if (redirectableLiveData != null) {
                return redirectableLiveData;
            }
            return camera2CameraControlImpl.getTorchControl().getTorchState();
        }
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public LiveData<ZoomState> getZoomState() {
        synchronized (this.mLock) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
            if (camera2CameraControlImpl == null) {
                if (this.mRedirectZoomStateLiveData == null) {
                    this.mRedirectZoomStateLiveData = new RedirectableLiveData<>(ZoomControl.getDefaultZoomState(this.mCameraCharacteristicsCompat));
                }
                return this.mRedirectZoomStateLiveData;
            }
            RedirectableLiveData<ZoomState> redirectableLiveData = this.mRedirectZoomStateLiveData;
            if (redirectableLiveData != null) {
                return redirectableLiveData;
            }
            return camera2CameraControlImpl.getZoomControl().getZoomState();
        }
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        Boolean bool = (Boolean) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        Preconditions.checkNotNull(bool);
        return bool.booleanValue();
    }

    public void linkWithCameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl) {
        synchronized (this.mLock) {
            this.mCamera2CameraControlImpl = camera2CameraControlImpl;
            RedirectableLiveData<ZoomState> redirectableLiveData = this.mRedirectZoomStateLiveData;
            if (redirectableLiveData != null) {
                redirectableLiveData.redirectTo(camera2CameraControlImpl.getZoomControl().getZoomState());
            }
            RedirectableLiveData<Integer> redirectableLiveData2 = this.mRedirectTorchStateLiveData;
            if (redirectableLiveData2 != null) {
                redirectableLiveData2.redirectTo(this.mCamera2CameraControlImpl.getTorchControl().getTorchState());
            }
            List<Pair<CameraCaptureCallback, Executor>> list = this.mCameraCaptureCallbacks;
            if (list != null) {
                for (Pair<CameraCaptureCallback, Executor> pair : list) {
                    this.mCamera2CameraControlImpl.addSessionCameraCaptureCallback((Executor) pair.second, (CameraCaptureCallback) pair.first);
                }
                this.mCameraCaptureCallbacks = null;
            }
        }
        logDeviceInfo();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void removeSessionCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.mLock) {
            Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
            if (camera2CameraControlImpl != null) {
                camera2CameraControlImpl.removeSessionCameraCaptureCallback(cameraCaptureCallback);
                return;
            }
            List<Pair<CameraCaptureCallback, Executor>> list = this.mCameraCaptureCallbacks;
            if (list == null) {
                return;
            }
            Iterator<Pair<CameraCaptureCallback, Executor>> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().first == cameraCaptureCallback) {
                    it.remove();
                }
            }
        }
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }
}
