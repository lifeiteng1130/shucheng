package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import c.e.b.a.a.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class TorchControl {
    public static final int DEFAULT_TORCH_STATE = 0;
    private static final String TAG = "TorchControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener;
    public CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    public boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState;

    public TorchControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        Camera2CameraControlImpl.CaptureResultListener captureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.TorchControl.1
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
                if (TorchControl.this.mEnableTorchCompleter != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    boolean z = num != null && num.intValue() == 2;
                    TorchControl torchControl = TorchControl.this;
                    if (z == torchControl.mTargetTorchEnabled) {
                        torchControl.mEnableTorchCompleter.set(null);
                        TorchControl.this.mEnableTorchCompleter = null;
                    }
                }
                return false;
            }
        };
        this.mCaptureResultListener = captureResultListener;
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        Boolean bool = (Boolean) cameraCharacteristicsCompat.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        this.mHasFlashUnit = bool != null && bool.booleanValue();
        this.mTorchState = new MutableLiveData<>(0);
        camera2CameraControlImpl.addCaptureResultListener(captureResultListener);
    }

    private <T> void setLiveDataValue(@NonNull MutableLiveData<T> mutableLiveData, T t) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }

    public /* synthetic */ Object a(final boolean z, final CallbackToFutureAdapter.Completer completer) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.h1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.enableTorchInternal(completer, z);
            }
        });
        return "enableTorch: " + z;
    }

    public a<Void> enableTorch(final boolean z) {
        if (this.mHasFlashUnit) {
            setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.i1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.a.a(z, completer);
                }
            });
        }
        Logger.d(TAG, "Unable to enableTorch due to there is no flash unit.");
        return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
    }

    public void enableTorchInternal(@NonNull CallbackToFutureAdapter.Completer<Void> completer, boolean z) {
        if (!this.mIsActive) {
            setLiveDataValue(this.mTorchState, 0);
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        this.mTargetTorchEnabled = z;
        this.mCamera2CameraControlImpl.enableTorchInternal(z);
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableTorchCompleter;
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
        }
        this.mEnableTorchCompleter = completer;
    }

    @NonNull
    public LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    public void setActive(boolean z) {
        if (this.mIsActive == z) {
            return;
        }
        this.mIsActive = z;
        if (z) {
            return;
        }
        if (this.mTargetTorchEnabled) {
            this.mTargetTorchEnabled = false;
            this.mCamera2CameraControlImpl.enableTorchInternal(false);
            setLiveDataValue(this.mTorchState, 0);
        }
        CallbackToFutureAdapter.Completer<Void> completer = this.mEnableTorchCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            this.mEnableTorchCompleter = null;
        }
    }
}
