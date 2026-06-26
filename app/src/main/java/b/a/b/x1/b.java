package b.a.b.x1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.internal.TargetConfig;

/* JADX INFO: compiled from: TargetConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    @NonNull
    public static Class a(TargetConfig _this) {
        return (Class) _this.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }

    @Nullable
    public static Class b(@Nullable TargetConfig _this, Class cls) {
        return (Class) _this.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, cls);
    }

    @NonNull
    public static String c(TargetConfig _this) {
        return (String) _this.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    @Nullable
    public static String d(@Nullable TargetConfig _this, String str) {
        return (String) _this.retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
    }
}
