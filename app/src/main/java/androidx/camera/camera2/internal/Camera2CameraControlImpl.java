package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.experimental.UseExperimental;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.AeFpsRange;
import androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ExperimentalExposureCompensation;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
@UseExperimental(markerClass = ExperimentalCamera2Interop.class)
public class Camera2CameraControlImpl implements CameraControlInternal {
    private static final String TAG = "Camera2CameraControlImp";
    public static final /* synthetic */ int a = 0;
    private final AeFpsRange mAeFpsRange;
    private final AutoFlashAEModeDisabler mAutoFlashAEModeDisabler;
    private final Camera2CameraControl mCamera2CameraControl;
    private final CameraCaptureCallbackSet mCameraCaptureCallbackSet;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private final CameraControlInternal.ControlUpdateCallback mControlUpdateCallback;
    public final Executor mExecutor;
    private final ExposureControl mExposureControl;
    private volatile int mFlashMode;
    private final FocusMeteringControl mFocusMeteringControl;
    private volatile boolean mIsTorchOn;
    private final Object mLock;
    public volatile Rational mPreviewAspectRatio;

    @VisibleForTesting
    public final CameraControlSessionCallback mSessionCallback;
    private final SessionConfig.Builder mSessionConfigBuilder;
    private final TorchControl mTorchControl;

    @GuardedBy("mLock")
    private int mUseCount;
    private final ZoomControl mZoomControl;

    public static final class CameraCaptureCallbackSet extends CameraCaptureCallback {
        public Set<CameraCaptureCallback> mCallbacks = new HashSet();
        public Map<CameraCaptureCallback, Executor> mCallbackExecutors = new ArrayMap();

        public void addCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCallbacks.add(cameraCaptureCallback);
            this.mCallbackExecutors.put(cameraCaptureCallback, executor);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCancelled() {
            for (final CameraCaptureCallback cameraCaptureCallback : this.mCallbacks) {
                try {
                    this.mCallbackExecutors.get(cameraCaptureCallback).execute(new Runnable() { // from class: b.a.a.d.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            cameraCaptureCallback.onCaptureCancelled();
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureCancelled.", e2);
                }
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull final CameraCaptureResult cameraCaptureResult) {
            for (final CameraCaptureCallback cameraCaptureCallback : this.mCallbacks) {
                try {
                    this.mCallbackExecutors.get(cameraCaptureCallback).execute(new Runnable() { // from class: b.a.a.d.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            cameraCaptureCallback.onCaptureCompleted(cameraCaptureResult);
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureCompleted.", e2);
                }
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(@NonNull final CameraCaptureFailure cameraCaptureFailure) {
            for (final CameraCaptureCallback cameraCaptureCallback : this.mCallbacks) {
                try {
                    this.mCallbackExecutors.get(cameraCaptureCallback).execute(new Runnable() { // from class: b.a.a.d.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            cameraCaptureCallback.onCaptureFailed(cameraCaptureFailure);
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureFailed.", e2);
                }
            }
        }

        public void removeCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCallbacks.remove(cameraCaptureCallback);
            this.mCallbackExecutors.remove(cameraCaptureCallback);
        }
    }

    public static final class CameraControlSessionCallback extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        public final Set<CaptureResultListener> mResultListeners = new HashSet();

        public CameraControlSessionCallback(@NonNull Executor executor) {
            this.mExecutor = executor;
        }

        public void addListener(@NonNull CaptureResultListener captureResultListener) {
            this.mResultListeners.add(captureResultListener);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull final TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.g
                @Override // java.lang.Runnable
                public final void run() {
                    Camera2CameraControlImpl.CameraControlSessionCallback cameraControlSessionCallback = this.a;
                    TotalCaptureResult totalCaptureResult2 = totalCaptureResult;
                    Objects.requireNonNull(cameraControlSessionCallback);
                    HashSet hashSet = new HashSet();
                    for (Camera2CameraControlImpl.CaptureResultListener captureResultListener : cameraControlSessionCallback.mResultListeners) {
                        if (captureResultListener.onCaptureResult(totalCaptureResult2)) {
                            hashSet.add(captureResultListener);
                        }
                    }
                    if (hashSet.isEmpty()) {
                        return;
                    }
                    cameraControlSessionCallback.mResultListeners.removeAll(hashSet);
                }
            });
        }

        public void removeListener(@NonNull CaptureResultListener captureResultListener) {
            this.mResultListeners.remove(captureResultListener);
        }
    }

    public interface CaptureResultListener {
        boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult);
    }

    @VisibleForTesting
    public Camera2CameraControlImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull CameraControlInternal.ControlUpdateCallback controlUpdateCallback) {
        this(cameraCharacteristicsCompat, scheduledExecutorService, executor, controlUpdateCallback, new Quirks(new ArrayList()));
    }

    private int getSupportedAeMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return isModeInList(i2, iArr) ? i2 : isModeInList(1, iArr) ? 1 : 0;
    }

    private int getSupportedAwbMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return isModeInList(i2, iArr) ? i2 : isModeInList(1, iArr) ? 1 : 0;
    }

    private boolean isControlInUse() {
        return getUseCount() > 0;
    }

    private boolean isModeInList(int i2, int[] iArr) {
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ void a(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraCaptureCallbackSet.addCaptureCallback(executor, cameraCaptureCallback);
    }

    public void addCaptureResultListener(@NonNull CaptureResultListener captureResultListener) {
        this.mSessionCallback.addListener(captureResultListener);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(@NonNull Config config) {
        this.mCamera2CameraControl.addCaptureRequestOptions(CaptureRequestOptions.Builder.from(config).build()).addListener(new Runnable() { // from class: b.a.a.d.k
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = Camera2CameraControlImpl.a;
            }
        }, CameraXExecutors.directExecutor());
    }

    public void addSessionCameraCaptureCallback(@NonNull final Executor executor, @NonNull final CameraCaptureCallback cameraCaptureCallback) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.i
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(executor, cameraCaptureCallback);
            }
        });
    }

    public /* synthetic */ void b(boolean z, boolean z2) {
        this.mFocusMeteringControl.cancelAfAeTrigger(z, z2);
    }

    public /* synthetic */ void c() {
        addCaptureResultListener(this.mCamera2CameraControl.getCaptureRequestListener());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void cancelAfAeTrigger(final boolean z, final boolean z2) {
        if (isControlInUse()) {
            this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(z, z2);
                }
            });
        } else {
            Logger.w(TAG, "Camera is not active.");
        }
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public a<Void> cancelFocusAndMetering() {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mFocusMeteringControl.cancelFocusAndMetering());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        this.mCamera2CameraControl.clearCaptureRequestOptions().addListener(new Runnable() { // from class: b.a.a.d.j
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = Camera2CameraControlImpl.a;
            }
        }, CameraXExecutors.directExecutor());
    }

    public /* synthetic */ void d(CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraCaptureCallbackSet.removeCaptureCallback(cameraCaptureCallback);
    }

    public void decrementUseCount() {
        synchronized (this.mLock) {
            int i2 = this.mUseCount;
            if (i2 == 0) {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
            this.mUseCount = i2 - 1;
        }
    }

    public /* synthetic */ void e(CallbackToFutureAdapter.Completer completer) {
        this.mFocusMeteringControl.triggerAePrecapture(completer);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public a<Void> enableTorch(boolean z) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mTorchControl.enableTorch(z));
    }

    public void enableTorchInternal(boolean z) {
        this.mIsTorchOn = z;
        if (!z) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(1)));
            builder2.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
            builder.addImplementationOptions(builder2.build());
            submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
        }
        updateSessionConfigSynchronous();
    }

    public /* synthetic */ void f(CallbackToFutureAdapter.Completer completer) {
        this.mFocusMeteringControl.triggerAf(completer);
    }

    @NonNull
    public Camera2CameraControl getCamera2CameraControl() {
        return this.mCamera2CameraControl;
    }

    @NonNull
    public Rect getCropSensorRegion() {
        return this.mZoomControl.getCropSensorRegion();
    }

    public int getDefaultTemplate() {
        return 1;
    }

    @NonNull
    public ExposureControl getExposureControl() {
        return this.mExposureControl;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.mFlashMode;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public Config getInteropConfig() {
        return this.mCamera2CameraControl.getCamera2ImplConfig();
    }

    public int getMaxAeRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMaxAfRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMaxAwbRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[LOOP:0: B:12:0x006a->B:14:0x0070, LOOP_END] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.camera.core.impl.Config getSessionOptions() {
        /*
            r7 = this;
            androidx.camera.camera2.impl.Camera2ImplConfig$Builder r0 = new androidx.camera.camera2.impl.Camera2ImplConfig$Builder
            r0.<init>()
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_MODE
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.setCaptureRequestOption(r1, r3)
            androidx.camera.camera2.internal.FocusMeteringControl r1 = r7.mFocusMeteringControl
            r1.addFocusMeteringOptions(r0)
            androidx.camera.camera2.internal.compat.workaround.AeFpsRange r1 = r7.mAeFpsRange
            r1.addAeFpsRangeOptions(r0)
            androidx.camera.camera2.internal.ZoomControl r1 = r7.mZoomControl
            r1.addZoomOption(r0)
            boolean r1 = r7.mIsTorchOn
            r3 = 2
            if (r1 == 0) goto L2d
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.FLASH_MODE
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.setCaptureRequestOption(r1, r3)
            goto L33
        L2d:
            int r1 = r7.mFlashMode
            if (r1 == 0) goto L37
            if (r1 == r2) goto L35
        L33:
            r1 = 1
            goto L3d
        L35:
            r1 = 3
            goto L3d
        L37:
            androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler r1 = r7.mAutoFlashAEModeDisabler
            int r1 = r1.getCorrectedAeMode(r3)
        L3d:
            android.hardware.camera2.CaptureRequest$Key r3 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            int r1 = r7.getSupportedAeMode(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.setCaptureRequestOption(r3, r1)
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE
            int r2 = r7.getSupportedAwbMode(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.setCaptureRequestOption(r1, r2)
            androidx.camera.camera2.internal.ExposureControl r1 = r7.mExposureControl
            r1.setCaptureRequestOption(r0)
            androidx.camera.camera2.interop.Camera2CameraControl r1 = r7.mCamera2CameraControl
            androidx.camera.camera2.impl.Camera2ImplConfig r1 = r1.getCamera2ImplConfig()
            java.util.Set r2 = r1.listOptions()
            java.util.Iterator r2 = r2.iterator()
        L6a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L84
            java.lang.Object r3 = r2.next()
            androidx.camera.core.impl.Config$Option r3 = (androidx.camera.core.impl.Config.Option) r3
            androidx.camera.core.impl.MutableConfig r4 = r0.getMutableConfig()
            androidx.camera.core.impl.Config$OptionPriority r5 = androidx.camera.core.impl.Config.OptionPriority.ALWAYS_OVERRIDE
            java.lang.Object r6 = r1.retrieveOption(r3)
            r4.insertOption(r3, r5, r6)
            goto L6a
        L84:
            androidx.camera.camera2.impl.Camera2ImplConfig r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraControlImpl.getSessionOptions():androidx.camera.core.impl.Config");
    }

    public int getSupportedAfMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(i2, iArr)) {
            return i2;
        }
        if (isModeInList(4, iArr)) {
            return 4;
        }
        return isModeInList(1, iArr) ? 1 : 0;
    }

    @NonNull
    public TorchControl getTorchControl() {
        return this.mTorchControl;
    }

    @VisibleForTesting
    public int getUseCount() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mUseCount;
        }
        return i2;
    }

    @NonNull
    public ZoomControl getZoomControl() {
        return this.mZoomControl;
    }

    public void incrementUseCount() {
        synchronized (this.mLock) {
            this.mUseCount++;
        }
    }

    public void removeCaptureResultListener(@NonNull CaptureResultListener captureResultListener) {
        this.mSessionCallback.removeListener(captureResultListener);
    }

    public void removeSessionCameraCaptureCallback(@NonNull final CameraCaptureCallback cameraCaptureCallback) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(cameraCaptureCallback);
            }
        });
    }

    public void setActive(boolean z) {
        this.mFocusMeteringControl.setActive(z);
        this.mZoomControl.setActive(z);
        this.mTorchControl.setActive(z);
        this.mExposureControl.setActive(z);
        this.mCamera2CameraControl.setActive(z);
    }

    public void setDefaultRequestBuilder(@NonNull CaptureRequest.Builder builder) {
        this.mFocusMeteringControl.setDefaultRequestBuilder(builder);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal, androidx.camera.core.CameraControl
    @NonNull
    @ExperimentalExposureCompensation
    public a<Integer> setExposureCompensationIndex(int i2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : this.mExposureControl.setExposureCompensationIndex(i2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i2) {
        if (!isControlInUse()) {
            Logger.w(TAG, "Camera is not active.");
        } else {
            this.mFlashMode = i2;
            updateSessionConfig();
        }
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public a<Void> setLinearZoom(float f2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mZoomControl.setLinearZoom(f2));
    }

    public void setPreviewAspectRatio(@Nullable Rational rational) {
        this.mPreviewAspectRatio = rational;
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public a<Void> setZoomRatio(float f2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mZoomControl.setZoomRatio(f2));
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mFocusMeteringControl.startFocusAndMetering(focusMeteringAction, this.mPreviewAspectRatio));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void submitCaptureRequests(@NonNull final List<CaptureConfig> list) {
        if (isControlInUse()) {
            this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.submitCaptureRequestsInternal(list);
                }
            });
        } else {
            Logger.w(TAG, "Camera is not active.");
        }
    }

    public void submitCaptureRequestsInternal(List<CaptureConfig> list) {
        this.mControlUpdateCallback.onCameraControlCaptureRequests(list);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public a<CameraCaptureResult> triggerAePrecapture() {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.p
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final Camera2CameraControlImpl camera2CameraControlImpl = this.a;
                camera2CameraControlImpl.mExecutor.execute(new Runnable() { // from class: b.a.a.d.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        camera2CameraControlImpl.e(completer);
                    }
                });
                return "triggerAePrecapture";
            }
        }));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public a<CameraCaptureResult> triggerAf() {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final Camera2CameraControlImpl camera2CameraControlImpl = this.a;
                camera2CameraControlImpl.mExecutor.execute(new Runnable() { // from class: b.a.a.d.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        camera2CameraControlImpl.f(completer);
                    }
                });
                return "triggerAf";
            }
        }));
    }

    public void updateSessionConfig() {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.y0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.updateSessionConfigSynchronous();
            }
        });
    }

    public void updateSessionConfigSynchronous() {
        this.mSessionConfigBuilder.setImplementationOptions(getSessionOptions());
        Object captureRequestTag = this.mCamera2CameraControl.getCamera2ImplConfig().getCaptureRequestTag(null);
        if (captureRequestTag != null && (captureRequestTag instanceof Integer)) {
            this.mSessionConfigBuilder.addTag(Camera2CameraControl.TAG_KEY, (Integer) captureRequestTag);
        }
        this.mControlUpdateCallback.onCameraControlUpdateSessionConfig(this.mSessionConfigBuilder.build());
    }

    public Camera2CameraControlImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull CameraControlInternal.ControlUpdateCallback controlUpdateCallback, @NonNull Quirks quirks) {
        this.mLock = new Object();
        SessionConfig.Builder builder = new SessionConfig.Builder();
        this.mSessionConfigBuilder = builder;
        this.mPreviewAspectRatio = null;
        this.mUseCount = 0;
        this.mIsTorchOn = false;
        this.mFlashMode = 2;
        this.mAutoFlashAEModeDisabler = new AutoFlashAEModeDisabler();
        CameraCaptureCallbackSet cameraCaptureCallbackSet = new CameraCaptureCallbackSet();
        this.mCameraCaptureCallbackSet = cameraCaptureCallbackSet;
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
        this.mControlUpdateCallback = controlUpdateCallback;
        this.mExecutor = executor;
        CameraControlSessionCallback cameraControlSessionCallback = new CameraControlSessionCallback(executor);
        this.mSessionCallback = cameraControlSessionCallback;
        builder.setTemplateType(getDefaultTemplate());
        builder.addRepeatingCameraCaptureCallback(CaptureCallbackContainer.create(cameraControlSessionCallback));
        builder.addRepeatingCameraCaptureCallback(cameraCaptureCallbackSet);
        this.mExposureControl = new ExposureControl(this, cameraCharacteristicsCompat, executor);
        this.mFocusMeteringControl = new FocusMeteringControl(this, scheduledExecutorService, executor);
        this.mZoomControl = new ZoomControl(this, cameraCharacteristicsCompat, executor);
        this.mTorchControl = new TorchControl(this, cameraCharacteristicsCompat, executor);
        this.mAeFpsRange = new AeFpsRange(quirks);
        this.mCamera2CameraControl = new Camera2CameraControl(this, executor);
        executor.execute(new Runnable() { // from class: b.a.a.d.h
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
        updateSessionConfig();
    }
}
