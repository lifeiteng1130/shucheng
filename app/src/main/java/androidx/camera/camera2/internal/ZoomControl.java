package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.FloatRange;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import c.e.b.a.a.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private static final String TAG = "ZoomControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;

    @GuardedBy("mCurrentZoomState")
    private final ZoomStateImpl mCurrentZoomState;
    private final Executor mExecutor;

    @NonNull
    public final ZoomImpl mZoomImpl;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;
    private boolean mIsActive = false;
    private Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.ZoomControl.1
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
            ZoomControl.this.mZoomImpl.onCaptureResult(totalCaptureResult);
            return false;
        }
    };

    public interface ZoomImpl {
        void addRequestOption(@NonNull Camera2ImplConfig.Builder builder);

        @NonNull
        Rect getCropSensorRegion();

        float getMaxZoom();

        float getMinZoom();

        void onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult);

        void resetZoom();

        void setZoomRatio(float f2, @NonNull CallbackToFutureAdapter.Completer<Void> completer);
    }

    public ZoomControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        ZoomImpl zoomImplCreateZoomImpl = createZoomImpl(cameraCharacteristicsCompat);
        this.mZoomImpl = zoomImplCreateZoomImpl;
        ZoomStateImpl zoomStateImpl = new ZoomStateImpl(zoomImplCreateZoomImpl.getMaxZoom(), zoomImplCreateZoomImpl.getMinZoom());
        this.mCurrentZoomState = zoomStateImpl;
        zoomStateImpl.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData<>(ImmutableZoomState.create(zoomStateImpl));
        camera2CameraControlImpl.addCaptureResultListener(this.mCaptureResultListener);
    }

    private static ZoomImpl createZoomImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return isAndroidRZoomSupported(cameraCharacteristicsCompat) ? new AndroidRZoomImpl(cameraCharacteristicsCompat) : new CropRegionZoomImpl(cameraCharacteristicsCompat);
    }

    public static ZoomState getDefaultZoomState(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        ZoomImpl zoomImplCreateZoomImpl = createZoomImpl(cameraCharacteristicsCompat);
        ZoomStateImpl zoomStateImpl = new ZoomStateImpl(zoomImplCreateZoomImpl.getMaxZoom(), zoomImplCreateZoomImpl.getMinZoom());
        zoomStateImpl.setZoomRatio(1.0f);
        return ImmutableZoomState.create(zoomStateImpl);
    }

    private static boolean isAndroidRZoomSupported(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return Build.VERSION.SDK_INT >= 30 && cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: submitCameraZoomRatio, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void c(@NonNull CallbackToFutureAdapter.Completer<Void> completer, @NonNull ZoomState zoomState) {
        ZoomState zoomStateCreate;
        if (this.mIsActive) {
            updateLiveData(zoomState);
            this.mZoomImpl.setZoomRatio(zoomState.getZoomRatio(), completer);
            this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
        } else {
            synchronized (this.mCurrentZoomState) {
                this.mCurrentZoomState.setZoomRatio(1.0f);
                zoomStateCreate = ImmutableZoomState.create(this.mCurrentZoomState);
            }
            updateLiveData(zoomStateCreate);
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    private void updateLiveData(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mZoomStateLiveData.setValue(zoomState);
        } else {
            this.mZoomStateLiveData.postValue(zoomState);
        }
    }

    public void addZoomOption(@NonNull Camera2ImplConfig.Builder builder) {
        this.mZoomImpl.addRequestOption(builder);
    }

    public /* synthetic */ Object b(final ZoomState zoomState, final CallbackToFutureAdapter.Completer completer) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.m1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(completer, zoomState);
            }
        });
        return "setLinearZoom";
    }

    public /* synthetic */ Object d(final ZoomState zoomState, final CallbackToFutureAdapter.Completer completer) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.j1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(completer, zoomState);
            }
        });
        return "setZoomRatio";
    }

    @NonNull
    public Rect getCropSensorRegion() {
        return this.mZoomImpl.getCropSensorRegion();
    }

    public LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }

    public void setActive(boolean z) {
        ZoomState zoomStateCreate;
        if (this.mIsActive == z) {
            return;
        }
        this.mIsActive = z;
        if (z) {
            return;
        }
        synchronized (this.mCurrentZoomState) {
            this.mCurrentZoomState.setZoomRatio(1.0f);
            zoomStateCreate = ImmutableZoomState.create(this.mCurrentZoomState);
        }
        updateLiveData(zoomStateCreate);
        this.mZoomImpl.resetZoom();
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
    }

    @NonNull
    public a<Void> setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        final ZoomState zoomStateCreate;
        synchronized (this.mCurrentZoomState) {
            try {
                this.mCurrentZoomState.setLinearZoom(f2);
                zoomStateCreate = ImmutableZoomState.create(this.mCurrentZoomState);
            } catch (IllegalArgumentException e2) {
                return Futures.immediateFailedFuture(e2);
            }
        }
        updateLiveData(zoomStateCreate);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.l1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                this.a.b(zoomStateCreate, completer);
                return "setLinearZoom";
            }
        });
    }

    @NonNull
    public a<Void> setZoomRatio(float f2) {
        final ZoomState zoomStateCreate;
        synchronized (this.mCurrentZoomState) {
            try {
                this.mCurrentZoomState.setZoomRatio(f2);
                zoomStateCreate = ImmutableZoomState.create(this.mCurrentZoomState);
            } catch (IllegalArgumentException e2) {
                return Futures.immediateFailedFuture(e2);
            }
        }
        updateLiveData(zoomStateCreate);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.k1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                this.a.d(zoomStateCreate, completer);
                return "setZoomRatio";
            }
        });
    }
}
