package com.efs.sdk.base.a.h;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            d.a("efs.util.pkg", "get version name error", th);
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static String b(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (Throwable th) {
            d.a("efs.util.pkg", "get version name error", th);
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
