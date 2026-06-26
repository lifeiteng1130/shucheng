package b.a.b.w1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: compiled from: UseCaseConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v {
    @NonNull
    public static CameraSelector a(UseCaseConfig _this) {
        return (CameraSelector) _this.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    @Nullable
    public static CameraSelector b(@Nullable UseCaseConfig _this, CameraSelector cameraSelector) {
        return (CameraSelector) _this.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    @NonNull
    public static CaptureConfig.OptionUnpacker c(UseCaseConfig _this) {
        return (CaptureConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    @Nullable
    public static CaptureConfig.OptionUnpacker d(@Nullable UseCaseConfig _this, CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    @NonNull
    public static CaptureConfig e(UseCaseConfig _this) {
        return (CaptureConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    @Nullable
    public static CaptureConfig f(@Nullable UseCaseConfig _this, CaptureConfig captureConfig) {
        return (CaptureConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
    }

    @NonNull
    public static SessionConfig g(UseCaseConfig _this) {
        return (SessionConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    @Nullable
    public static SessionConfig h(@Nullable UseCaseConfig _this, SessionConfig sessionConfig) {
        return (SessionConfig) _this.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
    }

    @NonNull
    public static SessionConfig.OptionUnpacker i(UseCaseConfig _this) {
        return (SessionConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
    }

    @Nullable
    public static SessionConfig.OptionUnpacker j(@Nullable UseCaseConfig _this, SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) _this.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
    }

    public static int k(UseCaseConfig _this) {
        return ((Integer) _this.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
    }

    public static int l(UseCaseConfig _this, int i2) {
        return ((Integer) _this.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2))).intValue();
    }
}
