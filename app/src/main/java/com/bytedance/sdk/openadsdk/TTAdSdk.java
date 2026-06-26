package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.b.d;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import com.umeng.analytics.pro.n;

/* JADX INFO: loaded from: classes.dex */
public final class TTAdSdk {
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    private static final TTInitializer a = new g();

    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static TTAdManager getAdManager() {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.getAdManager();
        }
        return null;
    }

    @Deprecated
    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        d.a("Please call init(final Context context, final TTAdConfig config, final InitCallback callback), this method will be deprecated");
        if (Looper.getMainLooper() != Looper.myLooper()) {
            d.a("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        a(context, "Context is null, please check.");
        a(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        if (tTAdConfig.isDebug()) {
            d.a();
        }
        tTAdConfig.setExtra(TTAdConstant.PANGLE_INIT_START_TIME, Long.valueOf(SystemClock.elapsedRealtime()));
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.init(context, tTAdConfig);
        }
        return null;
    }

    public static boolean isInitSuccess() {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.isInitSuccess();
        }
        return false;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        TTAdManager adManager;
        if (tTAdConfig == null || (adManager = a.getAdManager()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    public static void updatePaid(boolean z) {
        TTAdManager adManager = a.getAdManager();
        if (adManager == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            d.a("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        a(context, "Context is null, please check.");
        a(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        if (tTAdConfig.isDebug()) {
            d.a();
        }
        tTAdConfig.setExtra(TTAdConstant.PANGLE_INIT_START_TIME, Long.valueOf(SystemClock.elapsedRealtime()));
        TTInitializer tTInitializer = a;
        if (tTInitializer == null) {
            initCallback.fail(n.a.f4927d, "Load initializer failed");
        } else {
            tTInitializer.init(context, tTAdConfig, initCallback);
        }
    }
}
