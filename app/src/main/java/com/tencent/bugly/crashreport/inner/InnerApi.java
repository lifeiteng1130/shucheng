package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.crashreport.crash.k;
import com.tencent.bugly.proguard.X;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i2, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            X.b("post cocos2d-x fail args null", new Object[0]);
        } else if (i2 != 5 && i2 != 6) {
            X.b("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i2));
        } else {
            X.c("post cocos2d-x crash %s %s", str, str2);
            k.a(Thread.currentThread(), i2, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            X.b("post h5 fail args null", new Object[0]);
        } else {
            X.c("post h5 crash %s %s", str, str2);
            k.a(thread, 8, str, str2, str3, map);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            X.b("post u3d fail args null", new Object[0]);
        }
        X.c("post u3d crash %s %s", str, str2);
        k.a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
