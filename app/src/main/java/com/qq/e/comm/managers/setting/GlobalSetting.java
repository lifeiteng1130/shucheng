package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class GlobalSetting {
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String TT_SDK_WRAPPER = "TT";
    private static volatile CustomLandingPageListener a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Integer f2809b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f2810c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f2811d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Integer f2812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile Boolean f2813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<String, String> f2814g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile String f2815h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile String f2816i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile String f2817j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile String f2818k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile String f2819l = null;

    public static Integer getChannel() {
        return f2809b;
    }

    public static String getCustomADActivityClassName() {
        return f2815h;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f2818k;
    }

    public static String getCustomPortraitActivityClassName() {
        return f2816i;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f2819l;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f2817j;
    }

    public static Integer getPersonalizedState() {
        return f2812e;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f2814g;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f2813f == null || f2813f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f2810c;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f2811d;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f2813f == null) {
            f2813f = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i2) {
        if (f2809b == null) {
            f2809b = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f2815h = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f2818k = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f2816i = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f2819l = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f2817j = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f2810c = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f2811d = z;
    }

    public static void setPersonalizedState(int i2) {
        f2812e = Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f2814g.putAll(map);
    }
}
