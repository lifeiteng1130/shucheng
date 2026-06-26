package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class FocusMeteringControl {
    private static final String TAG = "FocusMeteringControl";
    private ScheduledFuture<?> mAutoCancelHandle;
    private final Camera2CameraControlImpl mCameraControl;
    public final Executor mExecutor;
    private final ScheduledExecutorService mScheduler;
    private volatile boolean mIsActive = false;
    private boolean mIsInAfAutoMode = false;

    @NonNull
    public Integer mCurrentAfState = 0;
    public long mFocusTimeoutCounter = 0;
    public boolean mIsAutoFocusCompleted = false;
    public boolean mIsFocusSuccessful = false;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForFocus = null;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForCancel = null;
    private MeteringRectangle[] mAfRects = new MeteringRectangle[0];
    private MeteringRectangle[] mAeRects = new MeteringRectangle[0];
    private MeteringRectangle[] mAwbRects = new MeteringRectangle[0];
    public MeteringRectangle[] mDefaultAfRects = new MeteringRectangle[0];
    public MeteringRectangle[] mDefaultAeRects = new MeteringRectangle[0];
    public MeteringRectangle[] mDefaultAwbRects = new MeteringRectangle[0];
    public CallbackToFutureAdapter.Completer<FocusMeteringResult> mRunningActionCompleter = null;
    public CallbackToFutureAdapter.Completer<Void> mRunningCancelCompleter = null;

    public FocusMeteringControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor) {
        this.mCameraControl = camera2CameraControlImpl;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
    }

    private void completeActionFuture(boolean z) {
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.set(FocusMeteringResult.create(z));
            this.mRunningActionCompleter = null;
        }
    }

    private void completeCancelFuture() {
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.set(null);
            this.mRunningCancelCompleter = null;
        }
    }

    private void disableAutoCancel() {
        ScheduledFuture<?> scheduledFuture = this.mAutoCancelHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.mAutoCancelHandle = null;
        }
    }

    private void executeMeteringAction(@NonNull final MeteringRectangle[] meteringRectangleArr, @NonNull final MeteringRectangle[] meteringRectangleArr2, @NonNull final MeteringRectangle[] meteringRectangleArr3, FocusMeteringAction focusMeteringAction) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        disableAutoCancel();
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr2;
        this.mAwbRects = meteringRectangleArr3;
        if (shouldTriggerAF()) {
            this.mIsInAfAutoMode = true;
            this.mIsAutoFocusCompleted = false;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfigSynchronous();
            triggerAf(null);
        } else {
            this.mIsInAfAutoMode = false;
            this.mIsAutoFocusCompleted = true;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfigSynchronous();
        }
        this.mCurrentAfState = 0;
        final boolean zIsAfModeSupported = isAfModeSupported();
        Camera2CameraControlImpl.CaptureResultListener captureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: b.a.a.d.s0
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                return this.a.b(zIsAfModeSupported, meteringRectangleArr, meteringRectangleArr2, meteringRectangleArr3, totalCaptureResult);
            }
        };
        this.mSessionListenerForFocus = captureResultListener;
        this.mCameraControl.addCaptureResultListener(captureResultListener);
        if (focusMeteringAction.isAutoCancelEnabled()) {
            final long j2 = this.mFocusTimeoutCounter + 1;
            this.mFocusTimeoutCounter = j2;
            this.mAutoCancelHandle = this.mScheduler.schedule(new Runnable() { // from class: b.a.a.d.p0
                @Override // java.lang.Runnable
                public final void run() {
                    final FocusMeteringControl focusMeteringControl = this.a;
                    final long j3 = j2;
                    focusMeteringControl.mExecutor.execute(new Runnable() { // from class: b.a.a.d.o0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FocusMeteringControl focusMeteringControl2 = focusMeteringControl;
                            if (j3 == focusMeteringControl2.mFocusTimeoutCounter) {
                                focusMeteringControl2.cancelFocusAndMeteringWithoutAsyncResult();
                            }
                        }
                    });
                }
            }, focusMeteringAction.getAutoCancelDurationInMillis(), TimeUnit.MILLISECONDS);
        }
    }

    private void failActionFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningActionCompleter = null;
        }
    }

    private void failCancelFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForCancel);
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningCancelCompleter = null;
        }
    }

    private int getDefaultTemplate() {
        return 1;
    }

    private static PointF getFovAdjustedPoint(@NonNull MeteringPoint meteringPoint, @NonNull Rational rational, @NonNull Rational rational2) {
        if (meteringPoint.getSurfaceAspectRatio() != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        PointF pointF = new PointF(meteringPoint.getX(), meteringPoint.getY());
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float fDoubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                pointF.y = (1.0f / fDoubleValue) * (((float) ((((double) fDoubleValue) - 1.0d) / 2.0d)) + pointF.y);
            } else {
                float fDoubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                pointF.x = (1.0f / fDoubleValue2) * (((float) ((((double) fDoubleValue2) - 1.0d) / 2.0d)) + pointF.x);
            }
        }
        return pointF;
    }

    private static MeteringRectangle getMeteringRect(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        int iWidth = (int) ((pointF.x * rect.width()) + rect.left);
        int iHeight = (int) ((pointF.y * rect.height()) + rect.top);
        int size = ((int) (meteringPoint.getSize() * rect.width())) / 2;
        int size2 = ((int) (meteringPoint.getSize() * rect.height())) / 2;
        Rect rect2 = new Rect(iWidth - size, iHeight - size2, iWidth + size, iHeight + size2);
        rect2.left = rangeLimit(rect2.left, rect.right, rect.left);
        rect2.right = rangeLimit(rect2.right, rect.right, rect.left);
        rect2.top = rangeLimit(rect2.top, rect.bottom, rect.top);
        rect2.bottom = rangeLimit(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    private static int getRegionCount(@Nullable MeteringRectangle[] meteringRectangleArr) {
        if (meteringRectangleArr == null) {
            return 0;
        }
        return meteringRectangleArr.length;
    }

    private static boolean hasEqualRegions(@Nullable MeteringRectangle[] meteringRectangleArr, @Nullable MeteringRectangle[] meteringRectangleArr2) {
        if (getRegionCount(meteringRectangleArr) == 0 && getRegionCount(meteringRectangleArr2) == 0) {
            return true;
        }
        if (getRegionCount(meteringRectangleArr) != getRegionCount(meteringRectangleArr2)) {
            return false;
        }
        if (meteringRectangleArr != null && meteringRectangleArr2 != null) {
            for (int i2 = 0; i2 < meteringRectangleArr.length; i2++) {
                if (!meteringRectangleArr[i2].equals(meteringRectangleArr2[i2])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAfModeSupported() {
        return this.mCameraControl.getSupportedAfMode(1) == 1;
    }

    private static boolean isValid(@NonNull MeteringPoint meteringPoint) {
        return meteringPoint.getX() >= 0.0f && meteringPoint.getX() <= 1.0f && meteringPoint.getY() >= 0.0f && meteringPoint.getY() <= 1.0f;
    }

    private static int rangeLimit(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i4), i3);
    }

    private boolean shouldTriggerAF() {
        return this.mAfRects.length > 0;
    }

    public /* synthetic */ boolean a(int i2, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        CaptureRequest request = totalCaptureResult.getRequest();
        MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AF_REGIONS);
        MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AE_REGIONS);
        MeteringRectangle[] meteringRectangleArr3 = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AWB_REGIONS);
        if (num.intValue() != i2 || !hasEqualRegions(meteringRectangleArr, this.mDefaultAfRects) || !hasEqualRegions(meteringRectangleArr2, this.mDefaultAeRects) || !hasEqualRegions(meteringRectangleArr3, this.mDefaultAwbRects)) {
            return false;
        }
        completeCancelFuture();
        return true;
    }

    public void addFocusMeteringOptions(@NonNull Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.mCameraControl.getSupportedAfMode(this.mIsInAfAutoMode ? 1 : 4)));
        MeteringRectangle[] meteringRectangleArr = this.mAfRects;
        if (meteringRectangleArr.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.mAeRects;
        if (meteringRectangleArr2.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.mAwbRects;
        if (meteringRectangleArr3.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
    }

    public /* synthetic */ boolean b(boolean z, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, MeteringRectangle[] meteringRectangleArr3, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (shouldTriggerAF()) {
            if (!z || num == null) {
                this.mIsFocusSuccessful = true;
                this.mIsAutoFocusCompleted = true;
            } else if (this.mCurrentAfState.intValue() == 3) {
                if (num.intValue() == 4) {
                    this.mIsFocusSuccessful = true;
                    this.mIsAutoFocusCompleted = true;
                } else if (num.intValue() == 5) {
                    this.mIsFocusSuccessful = false;
                    this.mIsAutoFocusCompleted = true;
                }
            }
        }
        if (this.mIsAutoFocusCompleted && totalCaptureResult.getRequest() != null) {
            if (meteringRectangleArr.length == 0) {
                meteringRectangleArr = this.mDefaultAfRects;
            }
            if (meteringRectangleArr2.length == 0) {
                meteringRectangleArr2 = this.mDefaultAeRects;
            }
            if (meteringRectangleArr3.length == 0) {
                meteringRectangleArr3 = this.mDefaultAwbRects;
            }
            CaptureRequest request = totalCaptureResult.getRequest();
            if (hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AF_REGIONS), meteringRectangleArr) && hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AE_REGIONS), meteringRectangleArr2) && hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AWB_REGIONS), meteringRectangleArr3)) {
                completeActionFuture(this.mIsFocusSuccessful);
                return true;
            }
        }
        if (this.mCurrentAfState.equals(num) || num == null) {
            return false;
        }
        this.mCurrentAfState = num;
        return false;
    }

    public void cancelAfAeTrigger(boolean z, boolean z2) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setUseRepeatingSurface(true);
            builder.setTemplateType(getDefaultTemplate());
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (z) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (Build.VERSION.SDK_INT >= 23 && z2) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
        }
    }

    public a<Void> cancelFocusAndMetering() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.q0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final FocusMeteringControl focusMeteringControl = this.a;
                focusMeteringControl.mExecutor.execute(new Runnable() { // from class: b.a.a.d.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        focusMeteringControl.cancelFocusAndMeteringInternal(completer);
                    }
                });
                return "cancelFocusAndMetering";
            }
        });
    }

    public void cancelFocusAndMeteringInternal(@Nullable CallbackToFutureAdapter.Completer<Void> completer) {
        failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        failActionFuture("Cancelled by cancelFocusAndMetering()");
        this.mRunningCancelCompleter = completer;
        disableAutoCancel();
        if (this.mRunningCancelCompleter != null) {
            final int supportedAfMode = this.mCameraControl.getSupportedAfMode(4);
            Camera2CameraControlImpl.CaptureResultListener captureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: b.a.a.d.t0
                @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
                public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                    return this.a.a(supportedAfMode, totalCaptureResult);
                }
            };
            this.mSessionListenerForCancel = captureResultListener;
            this.mCameraControl.addCaptureResultListener(captureResultListener);
        }
        if (shouldTriggerAF()) {
            cancelAfAeTrigger(true, false);
        }
        this.mAfRects = new MeteringRectangle[0];
        this.mAeRects = new MeteringRectangle[0];
        this.mAwbRects = new MeteringRectangle[0];
        this.mIsInAfAutoMode = false;
        this.mCameraControl.updateSessionConfigSynchronous();
    }

    public void cancelFocusAndMeteringWithoutAsyncResult() {
        cancelFocusAndMeteringInternal(null);
    }

    public void setActive(boolean z) {
        if (z == this.mIsActive) {
            return;
        }
        this.mIsActive = z;
        if (this.mIsActive) {
            return;
        }
        cancelFocusAndMeteringWithoutAsyncResult();
    }

    public void setDefaultRequestBuilder(@NonNull CaptureRequest.Builder builder) {
        this.mDefaultAfRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AF_REGIONS);
        this.mDefaultAeRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AE_REGIONS);
        this.mDefaultAwbRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AWB_REGIONS);
    }

    public a<FocusMeteringResult> startFocusAndMetering(@NonNull final FocusMeteringAction focusMeteringAction, @Nullable final Rational rational) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.u0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final FocusMeteringControl focusMeteringControl = this.a;
                final FocusMeteringAction focusMeteringAction2 = focusMeteringAction;
                final Rational rational2 = rational;
                focusMeteringControl.mExecutor.execute(new Runnable() { // from class: b.a.a.d.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        focusMeteringControl.startFocusAndMeteringInternal(completer, focusMeteringAction2, rational2);
                    }
                });
                return "startFocusAndMetering";
            }
        });
    }

    public void startFocusAndMeteringInternal(@NonNull CallbackToFutureAdapter.Completer<FocusMeteringResult> completer, @NonNull FocusMeteringAction focusMeteringAction, @Nullable Rational rational) {
        if (!this.mIsActive) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        if (focusMeteringAction.getMeteringPointsAf().isEmpty() && focusMeteringAction.getMeteringPointsAe().isEmpty() && focusMeteringAction.getMeteringPointsAwb().isEmpty()) {
            completer.setException(new IllegalArgumentException("No AF/AE/AWB MeteringPoints are added."));
            return;
        }
        int iMin = Math.min(focusMeteringAction.getMeteringPointsAf().size(), this.mCameraControl.getMaxAfRegionCount());
        int iMin2 = Math.min(focusMeteringAction.getMeteringPointsAe().size(), this.mCameraControl.getMaxAeRegionCount());
        int iMin3 = Math.min(focusMeteringAction.getMeteringPointsAwb().size(), this.mCameraControl.getMaxAwbRegionCount());
        if (iMin + iMin2 + iMin3 <= 0) {
            completer.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
            return;
        }
        ArrayList<MeteringPoint> arrayList = new ArrayList();
        ArrayList<MeteringPoint> arrayList2 = new ArrayList();
        ArrayList<MeteringPoint> arrayList3 = new ArrayList();
        if (iMin > 0) {
            arrayList.addAll(focusMeteringAction.getMeteringPointsAf().subList(0, iMin));
        }
        if (iMin2 > 0) {
            arrayList2.addAll(focusMeteringAction.getMeteringPointsAe().subList(0, iMin2));
        }
        if (iMin3 > 0) {
            arrayList3.addAll(focusMeteringAction.getMeteringPointsAwb().subList(0, iMin3));
        }
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        Rational rational2 = new Rational(cropSensorRegion.width(), cropSensorRegion.height());
        if (rational == null) {
            rational = rational2;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (MeteringPoint meteringPoint : arrayList) {
            if (isValid(meteringPoint)) {
                MeteringRectangle meteringRect = getMeteringRect(meteringPoint, getFovAdjustedPoint(meteringPoint, rational2, rational), cropSensorRegion);
                if (meteringRect.getWidth() != 0 && meteringRect.getHeight() != 0) {
                    arrayList4.add(meteringRect);
                }
            }
        }
        for (MeteringPoint meteringPoint2 : arrayList2) {
            if (isValid(meteringPoint2)) {
                MeteringRectangle meteringRect2 = getMeteringRect(meteringPoint2, getFovAdjustedPoint(meteringPoint2, rational2, rational), cropSensorRegion);
                if (meteringRect2.getWidth() != 0 && meteringRect2.getHeight() != 0) {
                    arrayList5.add(meteringRect2);
                }
            }
        }
        for (MeteringPoint meteringPoint3 : arrayList3) {
            if (isValid(meteringPoint3)) {
                MeteringRectangle meteringRect3 = getMeteringRect(meteringPoint3, getFovAdjustedPoint(meteringPoint3, rational2, rational), cropSensorRegion);
                if (meteringRect3.getWidth() != 0 && meteringRect3.getHeight() != 0) {
                    arrayList6.add(meteringRect3);
                }
            }
        }
        if (arrayList4.isEmpty() && arrayList5.isEmpty() && arrayList6.isEmpty()) {
            completer.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints are valid."));
            return;
        }
        failActionFuture("Cancelled by another startFocusAndMetering()");
        failCancelFuture("Cancelled by another startFocusAndMetering()");
        disableAutoCancel();
        this.mRunningActionCompleter = completer;
        executeMeteringAction((MeteringRectangle[]) arrayList4.toArray(new MeteringRectangle[0]), (MeteringRectangle[]) arrayList5.toArray(new MeteringRectangle[0]), (MeteringRectangle[]) arrayList6.toArray(new MeteringRectangle[0]), focusMeteringAction);
    }

    public void triggerAePrecapture(@Nullable final CallbackToFutureAdapter.Completer<CameraCaptureResult> completer) {
        if (!this.mIsActive) {
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(getDefaultTemplate());
        builder.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        builder.addImplementationOptions(builder2.build());
        builder.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.FocusMeteringControl.2
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCancelled() {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControl.OperationCanceledException("Camera is closed"));
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.set(cameraCaptureResult);
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                }
            }
        });
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
    }

    public void triggerAf(@Nullable final CallbackToFutureAdapter.Completer<CameraCaptureResult> completer) {
        if (!this.mIsActive) {
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(getDefaultTemplate());
        builder.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        builder.addImplementationOptions(builder2.build());
        builder.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.camera2.internal.FocusMeteringControl.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCancelled() {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControl.OperationCanceledException("Camera is closed"));
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.set(cameraCaptureResult);
                }
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                CallbackToFutureAdapter.Completer completer2 = completer;
                if (completer2 != null) {
                    completer2.setException(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                }
            }
        });
        this.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
    }
}
