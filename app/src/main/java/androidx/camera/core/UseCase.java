package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.core.util.Preconditions;
import c.a.a.a.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class UseCase {
    private Size mAttachedResolution;

    @GuardedBy("mCameraLock")
    private CameraInternal mCamera;

    @Nullable
    private UseCaseConfig<?> mCameraConfig;

    @NonNull
    private UseCaseConfig<?> mCurrentConfig;

    @Nullable
    private UseCaseConfig<?> mExtendedConfig;

    @NonNull
    private UseCaseConfig<?> mUseCaseConfig;

    @Nullable
    private Rect mViewPortCropRect;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private final Object mCameraLock = new Object();
    private State mState = State.INACTIVE;
    private SessionConfig mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();

    /* JADX INFO: renamed from: androidx.camera.core.UseCase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$UseCase$State;

        static {
            State.values();
            int[] iArr = new int[2];
            $SwitchMap$androidx$camera$core$UseCase$State = iArr;
            try {
                iArr[State.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$UseCase$State[State.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface EventCallback {
        void onAttach(@NonNull CameraInfo cameraInfo);

        void onDetach();
    }

    public enum State {
        ACTIVE,
        INACTIVE
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StateChangeCallback {
        void onUseCaseActive(@NonNull UseCase useCase);

        void onUseCaseInactive(@NonNull UseCase useCase);

        void onUseCaseReset(@NonNull UseCase useCase);

        void onUseCaseUpdated(@NonNull UseCase useCase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCase(@NonNull UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    private void addStateChangeCallback(@NonNull StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    private void removeStateChangeCallback(@NonNull StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size getAttachedSurfaceResolution() {
        return this.mAttachedResolution;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mCamera;
        }
        return cameraInternal;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraControlInternal getCameraControl() {
        synchronized (this.mCameraLock) {
            CameraInternal cameraInternal = this.mCamera;
            if (cameraInternal == null) {
                return CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
            }
            return cameraInternal.getCameraControlInternal();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getCameraId() {
        return ((CameraInternal) Preconditions.checkNotNull(getCamera(), "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract UseCaseConfig<?> getDefaultConfig(boolean z, @NonNull UseCaseConfigFactory useCaseConfigFactory);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getName() {
        UseCaseConfig<?> useCaseConfig = this.mCurrentConfig;
        StringBuilder sbR = a.r("<UnknownUseCase-");
        sbR.append(hashCode());
        sbR.append(">");
        return useCaseConfig.getTargetName(sbR.toString());
    }

    @IntRange(from = 0, to = 359)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getRelativeRotation(@NonNull CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isCurrentCamera(@NonNull String str) {
        if (getCamera() == null) {
            return false;
        }
        return Objects.equals(str, getCameraId());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> mergeConfigs(@NonNull CameraInfoInternal cameraInfoInternal, @Nullable UseCaseConfig<?> useCaseConfig, @Nullable UseCaseConfig<?> useCaseConfig2) {
        MutableOptionsBundle mutableOptionsBundleCreate;
        if (useCaseConfig2 != null) {
            mutableOptionsBundleCreate = MutableOptionsBundle.from((Config) useCaseConfig2);
            mutableOptionsBundleCreate.removeOption(TargetConfig.OPTION_TARGET_NAME);
        } else {
            mutableOptionsBundleCreate = MutableOptionsBundle.create();
        }
        for (Config.Option<?> option : this.mUseCaseConfig.listOptions()) {
            mutableOptionsBundleCreate.insertOption(option, this.mUseCaseConfig.getOptionPriority(option), this.mUseCaseConfig.retrieveOption(option));
        }
        if (useCaseConfig != null) {
            for (Config.Option<?> option2 : useCaseConfig.listOptions()) {
                if (!option2.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId())) {
                    mutableOptionsBundleCreate.insertOption(option2, useCaseConfig.getOptionPriority(option2), useCaseConfig.retrieveOption(option2));
                }
            }
        }
        if (mutableOptionsBundleCreate.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<Integer> option3 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
            if (mutableOptionsBundleCreate.containsOption(option3)) {
                mutableOptionsBundleCreate.removeOption(option3);
            }
        }
        return onMergeConfig(cameraInfoInternal, getUseCaseConfigBuilder(mutableOptionsBundleCreate));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyReset() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseReset(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyState() {
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 0) {
            Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onUseCaseActive(this);
            }
        } else {
            if (iOrdinal != 1) {
                return;
            }
            Iterator<StateChangeCallback> it2 = this.mStateChangeCallbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onUseCaseInactive(this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyUpdated() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseUpdated(this);
        }
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onAttach(@NonNull CameraInternal cameraInternal, @Nullable UseCaseConfig<?> useCaseConfig, @Nullable UseCaseConfig<?> useCaseConfig2) {
        synchronized (this.mCameraLock) {
            this.mCamera = cameraInternal;
            addStateChangeCallback(cameraInternal);
        }
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
        UseCaseConfig<?> useCaseConfigMergeConfigs = mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        this.mCurrentConfig = useCaseConfigMergeConfigs;
        EventCallback useCaseEventCallback = useCaseConfigMergeConfigs.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onAttach(cameraInternal.getCameraInfoInternal());
        }
        onAttached();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onAttached() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onCameraControlReady() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onDetach(@NonNull CameraInternal cameraInternal) {
        onDetached();
        EventCallback useCaseEventCallback = this.mCurrentConfig.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onDetach();
        }
        synchronized (this.mCameraLock) {
            Preconditions.checkArgument(cameraInternal == this.mCamera);
            removeStateChangeCallback(this.mCamera);
            this.mCamera = null;
        }
        this.mAttachedResolution = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDetached() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        return builder.getUseCaseConfig();
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateAttached() {
        onCameraControlReady();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateDetached() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract Size onSuggestedResolutionUpdated(@NonNull Size size);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean setTargetRotationInternal(int i2) {
        int targetRotation = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (targetRotation != -1 && targetRotation == i2) {
            return false;
        }
        UseCaseConfig.Builder<?, ?, ?> useCaseConfigBuilder = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(useCaseConfigBuilder, i2);
        this.mUseCaseConfig = useCaseConfigBuilder.getUseCaseConfig();
        CameraInternal camera = getCamera();
        if (camera == null) {
            this.mCurrentConfig = this.mUseCaseConfig;
            return true;
        }
        this.mCurrentConfig = mergeConfigs(camera.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setViewPortCropRect(@NonNull Rect rect) {
        this.mViewPortCropRect = rect;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSessionConfig(@NonNull SessionConfig sessionConfig) {
        this.mAttachedSessionConfig = sessionConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSuggestedResolution(@NonNull Size size) {
        this.mAttachedResolution = onSuggestedResolutionUpdated(size);
    }
}
