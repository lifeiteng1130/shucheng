package com.uc.crashsdk.export;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class LogType {
    public static final int ANR = 1048576;
    public static final String ANR_TYPE = "anr";
    public static final int JAVA = 16;
    public static final String JAVA_TYPE = "java";
    public static final int NATIVE = 1;
    public static final String NATIVE_TYPE = "jni";
    public static final int UNEXP = 256;
    public static final int UNEXP_ALL = 32512;
    public static final int UNEXP_ANR = 1280;
    public static final int UNEXP_EXIT = 8448;
    public static final int UNEXP_KILL_PROCESS = 4352;
    public static final int UNEXP_KNOWN_REASON = 32000;
    public static final int UNEXP_LOW_MEMORY = 2304;
    public static final int UNEXP_OTHER = 768;
    public static final int UNEXP_RESTART = 16640;
    public static final String UNEXP_TYPE = "unexp";

    public static int addType(int i2, int i3) {
        return (i2 | i3) & 1048849;
    }

    public static boolean isForANR(int i2) {
        return (i2 & 1048576) != 0;
    }

    public static boolean isForJava(int i2) {
        return (i2 & 16) != 0;
    }

    public static boolean isForNative(int i2) {
        return (i2 & 1) != 0;
    }

    public static boolean isForUnexp(int i2) {
        return (i2 & 256) != 0;
    }

    public static int removeType(int i2, int i3) {
        return i2 & (~(i3 & 1048849));
    }
}
