package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import dalvik.system.DexClassLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTPluginSdkInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements TTInitializer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile TTInitializer f1734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Bundle f1733c = new Bundle();
    public static ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new a());

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.a.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        f.a(context);
        if (this.f1734b != null) {
            this.f1734b.init(context, adConfig, initCallback);
        } else {
            a(context, adConfig, initCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.f1734b != null) {
            return this.f1734b.isInitSuccess();
        }
        return false;
    }

    public static void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        f1733c.putBundle(str, bundle);
    }

    /* JADX INFO: compiled from: TTPluginSdkInitializer.java */
    public static class a implements ThreadFactory {
        private final ThreadGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f1738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f1739c;

        public a() {
            this.f1738b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.f1739c = "tt_pangle_thread_pl_init";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.f1739c + this.f1738b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        public a(String str) {
            this.f1738b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.f1739c = str;
        }
    }

    public void a(final Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback) {
        a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.1
            @Override // java.lang.Runnable
            public void run() {
                TTInitializer tTInitializerA = g.this.a(context, adConfig);
                if (tTInitializerA == null) {
                    initCallback.fail(4201, "No initializer");
                    return;
                }
                tTInitializerA.init(context, adConfig, initCallback);
                com.bytedance.sdk.openadsdk.api.plugin.a.a.a(g.this.f1734b.getAdManager());
                e.a();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager init(Context context, AdConfig adConfig) {
        throw new RuntimeException("Please use init(Context context, AdConfig config, TTAdSdk.InitCallback callback)!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTInitializer a(Context context, AdConfig adConfig) {
        if (this.f1734b == null) {
            synchronized (this) {
                if (this.f1734b == null) {
                    e.a(adConfig);
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Create initializer");
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.f1734b = a(context);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("duration", Long.valueOf(jCurrentTimeMillis2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.f1734b;
    }

    private static TTInitializer a(Context context) {
        DexClassLoader dexClassLoaderA;
        try {
            dexClassLoaderA = f.a(context).a();
        } catch (Throwable th) {
            e.a(6, th.getMessage(), 0L);
            com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Create initializer failed: " + th);
        }
        if (dexClassLoaderA == null) {
            e.a(6, "Load plugin failed", 0L);
            com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Load plugin failed");
            return null;
        }
        Class<?> clsLoadClass = dexClassLoaderA.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new f.b());
        bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, f1733c);
        TTInitializer tTInitializer = (TTInitializer) clsLoadClass.getDeclaredMethod("getInstance", Bundle.class).invoke(null, bundle);
        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Create initializer success");
        return tTInitializer;
    }
}
