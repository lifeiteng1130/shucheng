package b.a.b.w1;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.ImageOutputConfig;
import java.util.List;

/* JADX INFO: compiled from: ImageOutputConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t {
    @NonNull
    public static Size a(ImageOutputConfig _this) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
    }

    @Nullable
    public static Size b(@Nullable ImageOutputConfig _this, Size size) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
    }

    @NonNull
    public static Size c(ImageOutputConfig _this) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
    }

    @Nullable
    public static Size d(@Nullable ImageOutputConfig _this, Size size) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
    }

    @NonNull
    public static List e(ImageOutputConfig _this) {
        return (List) _this.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
    }

    @Nullable
    public static List f(@Nullable ImageOutputConfig _this, List list) {
        return (List) _this.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
    }

    public static int g(ImageOutputConfig _this) {
        return ((Integer) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
    }

    @NonNull
    public static Size h(ImageOutputConfig _this) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
    }

    @Nullable
    public static Size i(@Nullable ImageOutputConfig _this, Size size) {
        return (Size) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
    }

    public static int j(ImageOutputConfig _this) {
        return ((Integer) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
    }

    public static int k(ImageOutputConfig _this, int i2) {
        return ((Integer) _this.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2))).intValue();
    }

    public static boolean l(ImageOutputConfig _this) {
        return _this.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }
}
