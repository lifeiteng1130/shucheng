package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.camera.core.FocusMeteringAction;
import c.b.a.m.f;
import c.c.a.h.b.a;
import c.c.a.h.g;
import c.c.a.h.g.a;
import c.c.a.n.b;
import c.c.a.n.c;
import c.c.a.n.d;
import c.c.a.o;
import c.c.a.p;
import c.c.a.q;
import c.c.a.t.a;
import c.c.a.x.e;
import com.android.server.SystemConfig;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.FieldUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            f.w();
            try {
                SystemConfig.getInstance();
            } catch (Throwable unused) {
            }
        }
    }

    public static void clearOfflineFlag(String str) {
        e.b().f(str);
    }

    public static void downloadAndInstall(String str, ZeusPluginListener zeusPluginListener) {
        PluginDownloadBean next;
        g gVarA = g.a();
        synchronized (gVarA) {
            Iterator<PluginDownloadBean> it = gVarA.f735g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (TextUtils.equals(next.mPackageName, str)) {
                        break;
                    }
                }
            }
            if (next == null) {
                Iterator<PluginDownloadBean> it2 = gVarA.f733e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    PluginDownloadBean next2 = it2.next();
                    if (TextUtils.equals(next2.mPackageName, str)) {
                        next = next2;
                        break;
                    }
                }
            }
        }
        if (next != null) {
            next.isWifiOnly = false;
            g.c(next, zeusPluginListener);
        } else {
            zeusPluginListener.onEvent(13, "The plugin was not found in the cache.");
            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "The plugin was not found in the cache.");
        }
    }

    public static Application getAppApplication() {
        return sApplication;
    }

    public static String getHostAbi() {
        return b.a();
    }

    public static int getHostAbiBit() {
        return b.f777c.get(b.a()).intValue();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static Plugin getPlugin(String str) {
        return PluginManager.getInstance().getPlugin(str);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static boolean hasInit() {
        return q.a().f778b;
    }

    public static boolean hasNewPlugin(String str) {
        g gVarA = g.a();
        Objects.requireNonNull(gVarA);
        try {
            Plugin plugin = getPlugin(str);
            if (plugin != null && !plugin.isLoaded()) {
                Long l2 = gVarA.f734f.get(str);
                if (l2 != null && System.currentTimeMillis() - l2.longValue() < FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION) {
                    return false;
                }
                int i2 = c.c.a.b.a;
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasOfflineFlag(String str) {
        return e.b().g(str);
    }

    public static void init(Application application) {
        init(application, new ZeusParam.Builder().build());
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static void markOfflineFlag(String str) {
        e.b().e(str);
    }

    public static void preInit() {
        if (Build.VERSION.SDK_INT == 29) {
            c.c.a.n.f.a.execute(new a());
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        q qVarA = q.a();
        if (qVarA.f780d.isEmpty()) {
            qVarA.f780d = new CopyOnWriteArrayList();
        }
        qVarA.f780d.add(zeusPluginStateListener);
    }

    public static void setAppContext(Application application) {
        sApplication = application;
    }

    public static boolean syncInstallPlugin(String str) {
        c.c.a.g gVarB = c.c.a.v.a.b();
        if (gVarB == null) {
            return false;
        }
        try {
            return gVarB.c(str);
        } catch (RemoteException e2) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e2);
            return false;
        }
    }

    public static boolean unInstallPlugin(String str) {
        ZeusLogger.d("unInstallPlugin");
        return PluginManager.getInstance().deletePackage(str) == 0;
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        q qVarA = q.a();
        List<ZeusPluginStateListener> list = qVarA.f780d;
        if (list == null || !list.contains(zeusPluginStateListener)) {
            return;
        }
        qVarA.f780d.remove(zeusPluginStateListener);
    }

    public static void init(Application application, ZeusParam zeusParam) {
        setAppContext(application);
        q qVarA = q.a();
        synchronized (qVarA) {
            if (qVarA.f778b) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
                return;
            }
            if (application == null) {
                throw new IllegalArgumentException("context must be not null !!!");
            }
            if (zeusParam == null) {
                zeusParam = new ZeusParam.Builder().build();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, use default ZeusParam");
            }
            qVarA.f779c = zeusParam;
            ZeusLogger.setDebug(zeusParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + qVarA.f779c);
            if (!qVarA.f779c.isCloseDefaultReport()) {
                d.b(application, String.valueOf(zeusParam.getAppId()), zeusParam.getChannel(), String.valueOf(zeusParam.getDid().get()));
            }
            c.c.a.d.b bVarA = c.c.a.d.b.a();
            o oVar = new o(qVarA);
            synchronized (bVarA.f690b) {
                bVarA.f690b.add(oVar);
            }
            if (qVarA.f779c.isEnable()) {
                f.w();
                if (Build.VERSION.SDK_INT == 29) {
                    c.c.a.n.f.a.execute(new p(qVarA));
                }
                if (f.o1()) {
                    try {
                        FieldUtils.writeField(c.c.a.n.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                    } catch (Exception e2) {
                        ZeusLogger.e(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e2);
                    }
                }
                q.b();
                ContentProviderManager.getInstance().initSystemContentProviderInfo();
                if (c.b(application)) {
                    if (qVarA.f779c.autoFetch()) {
                        if (c.c.a.h.f.a == null) {
                            synchronized (c.c.a.h.f.class) {
                                if (c.c.a.h.f.a == null) {
                                    c.c.a.h.f.a = new c.c.a.h.f();
                                }
                            }
                        }
                        if (c.b(getAppApplication())) {
                            c.c.a.h.b.a().f714d.add(g.a().new a());
                            getAppApplication().registerActivityLifecycleCallbacks(c.c.a.h.b.a().new a());
                        }
                    }
                    PluginManager.getInstance().installFromDownloadDir();
                }
                a.c cVar = c.c.a.t.a.a;
                try {
                    if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                        c.c.a.t.a.a.a(application.getBaseContext());
                    }
                } catch (Throwable unused) {
                }
            }
            qVarA.f778b = true;
        }
    }
}
