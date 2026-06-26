package com.uc.crashsdk.a;

import com.uc.crashsdk.JNIBridge;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(String str) {
        com.uc.crashsdk.g.M();
    }

    public static void b(String str) {
        com.uc.crashsdk.g.M();
    }

    public static void c(String str, String str2) {
        if (com.uc.crashsdk.b.f4552d) {
            JNIBridge.nativeLog(5, str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (com.uc.crashsdk.b.f4552d) {
            JNIBridge.nativeLog(6, str, str2);
        }
    }

    public static void a(String str, String str2) {
        com.uc.crashsdk.g.M();
    }

    public static void b(String str, String str2) {
        if (com.uc.crashsdk.b.f4552d) {
            JNIBridge.nativeLog(4, str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (!com.uc.crashsdk.g.M() || th == null) {
        }
    }
}
