package c.c.a.h;

import android.os.Handler;
import android.os.Looper;
import c.c.a.q;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.plugin.PluginProvider;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static final ExecutorService a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<PluginDownloadBean> f732d = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<PluginDownloadBean> f733e = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Long> f734f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<PluginDownloadBean> f735g = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f736h = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f737i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f738j = false;

    public class a implements c.c.a.h.a {
        public a() {
        }

        @Override // c.c.a.h.a
        public final void a() {
            g gVar = g.this;
            Objects.requireNonNull(gVar);
            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins start");
            g.a.execute(new c(gVar));
        }

        @Override // c.c.a.h.a
        public final void b() {
            g gVar = g.this;
            ExecutorService executorService = g.a;
            gVar.b(1800L);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ long a;

        public b(long j2) {
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!c.c.a.h.b.a().f713c) {
                g gVar = g.this;
                Objects.requireNonNull(gVar);
                ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins start");
                g.a.execute(new c(gVar));
            }
            g.this.f736h.postDelayed(this, this.a * 1000);
        }
    }

    public static g a() {
        if (f730b == null) {
            synchronized (g.class) {
                if (f730b == null) {
                    f730b = new g();
                }
            }
        }
        return f730b;
    }

    public static void c(PluginDownloadBean pluginDownloadBean, ZeusPluginListener zeusPluginListener) {
        try {
            Plugin plugin = Zeus.getPlugin(pluginDownloadBean.mPackageName);
            if (f(pluginDownloadBean)) {
                if (zeusPluginListener != null) {
                    zeusPluginListener.onEvent(13, "already download");
                    return;
                }
                return;
            }
            if (plugin != null) {
                plugin.setHostCompatVersion(pluginDownloadBean.mVersionCode, pluginDownloadBean.mClientVersionMin, pluginDownloadBean.mClientVersionMax);
                plugin.setApiCompatVersion(pluginDownloadBean.mVersionCode, pluginDownloadBean.mApiVersionMin, pluginDownloadBean.mApiVersionMax);
            }
            PluginProvider pluginProvider = q.a().f779c.getPluginProvider();
            if (pluginProvider != null && pluginProvider.useLocalPlugin()) {
                PluginManager.getInstance().installFromDownloadDir();
                return;
            }
            if (e.a == null) {
                synchronized (e.class) {
                    if (e.a == null) {
                        e.a = new e();
                    }
                }
            }
            e.a.b(pluginDownloadBean.mUrl, pluginDownloadBean.mPackageName, pluginDownloadBean.mVersionCode, pluginDownloadBean.mMd5, pluginDownloadBean.isWifiOnly, pluginDownloadBean.mBackupUrlList, pluginDownloadBean.mDownloadType, zeusPluginListener);
        } catch (Exception e2) {
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(13, e2.getMessage());
            }
        }
    }

    public static void d(List<PluginDownloadBean> list) {
        for (PluginDownloadBean pluginDownloadBean : list) {
            if (pluginDownloadBean.mDownloadType == 0) {
                c(pluginDownloadBean, null);
            }
        }
    }

    public static boolean e(PluginDownloadBean pluginDownloadBean) {
        if (pluginDownloadBean == null) {
            return false;
        }
        if (pluginDownloadBean.isOffline) {
            Zeus.unInstallPlugin(pluginDownloadBean.mPackageName);
            Zeus.markOfflineFlag(pluginDownloadBean.mPackageName);
            return false;
        }
        if (Zeus.hasOfflineFlag(pluginDownloadBean.mPackageName)) {
            Zeus.clearOfflineFlag(pluginDownloadBean.mPackageName);
        }
        if (!pluginDownloadBean.isRevert) {
            return true;
        }
        if (pluginDownloadBean.mVersionCode < Zeus.getInstalledPluginVersion(pluginDownloadBean.mPackageName)) {
            Zeus.unInstallPlugin(pluginDownloadBean.mPackageName);
        }
        return pluginDownloadBean.mVersionCode != 0;
    }

    public static boolean f(PluginDownloadBean pluginDownloadBean) {
        Plugin plugin = Zeus.getPlugin(pluginDownloadBean.mPackageName);
        if (!(plugin != null && plugin.isVersionInstalled(pluginDownloadBean.mVersionCode)) || !PluginDirHelper.isPackageVersionDirExists(pluginDownloadBean.mPackageName, pluginDownloadBean.mVersionCode)) {
            return false;
        }
        ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "interceptPluginDownload, packageName:" + pluginDownloadBean.mPackageName + " downloadVersionCode:" + pluginDownloadBean.mVersionCode);
        return true;
    }

    public final void b(long j2) {
        if (j2 < 300) {
            return;
        }
        Runnable runnable = this.f737i;
        if (runnable != null) {
            this.f736h.removeCallbacks(runnable);
        }
        b bVar = new b(j2);
        this.f737i = bVar;
        this.f736h.postDelayed(bVar, j2 * 1000);
    }
}
