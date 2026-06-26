package com.bytedance.pangle.plugin;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.media2.session.SessionCommand;
import c.c.a.n.f;
import c.c.a.q;
import c.c.a.s.a;
import c.c.a.s.b;
import c.c.a.s.c;
import c.c.a.s.d;
import c.c.a.x.e;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private ExecutorService mInstallThreadPool;
    private volatile boolean mIsParsePluginConfig;
    private HashMap<String, Plugin> loadedPlugin = new HashMap<>();
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private c pluginLoader = new c();
    private b pluginInstaller = new b();

    private PluginManager() {
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(PluginDirHelper.getSourceFile(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        deletePackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList<String> arrayList = new ArrayList();
        try {
            Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            for (String str : bundle.keySet()) {
                if (str.startsWith("ZEUS_PLUGIN_")) {
                    arrayList.add(bundle.getString(str));
                }
            }
            try {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (String str2 : arrayList) {
                    try {
                        Plugin plugin = new Plugin(new JSONObject(str2), this.mHandler);
                        concurrentHashMap.put(plugin.mPkgName, plugin);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + plugin.mPkgName);
                    } catch (JSONException e2) {
                        ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str2.trim(), e2);
                    }
                }
                this.mPlugins = concurrentHashMap;
                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
            } catch (Exception e3) {
                ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e3);
            }
            this.mIsParsePluginConfig = true;
        } catch (PackageManager.NameNotFoundException e4) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e4);
        }
    }

    public void asyncInstall(File file) {
        asyncInstall(file, null);
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    public void delete(String str) {
        if (getPlugin(str) != null) {
            e.b().h(str);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager mark deleted : ".concat(String.valueOf(str)));
        }
    }

    public int deletePackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager deletePackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) == null) {
            return 0;
        }
        e.b().h(str);
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager mark deleted : ".concat(String.valueOf(str)));
        return 0;
    }

    public Plugin getPlugin(String str) {
        if (str == null) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (plugin == null) {
            return null;
        }
        plugin.init();
        return plugin;
    }

    public List<Plugin> getPlugins() {
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Iterator<Plugin> it = this.mPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().init();
        }
        return new ArrayList(this.mPlugins.values());
    }

    public void installFromDownloadDir() {
        if (c.c.a.n.c.b(Zeus.getAppApplication())) {
            if (this.mInstallThreadPool == null) {
                int installThreads = q.a().f779c.getInstallThreads();
                Executor executor = f.a;
                this.mInstallThreadPool = Executors.newFixedThreadPool(installThreads, new c.c.a.n.e());
            }
            f.a.execute(new d());
        }
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public boolean loadPlugin(String str) {
        synchronized (this.pluginLoader) {
            Plugin plugin = getInstance().getPlugin(str);
            if (plugin == null) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
                return false;
            }
            if (!plugin.isInstalled()) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                return false;
            }
            if (!plugin.isLoaded()) {
                c.c.a.r.c cVar = new c.c.a.r.c(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                c.a("load_start", SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, plugin.mPkgName, plugin.getVersion(), -1L, null);
                StringBuilder sb = new StringBuilder();
                boolean zB = c.b(str, plugin, sb);
                cVar.b("loadPluginInternal:".concat(String.valueOf(zB)));
                if (zB) {
                    plugin.setLifeCycle(3);
                    c.a("load_finish", 41000, plugin.mPkgName, plugin.getVersion(), System.currentTimeMillis() - cVar.f783d, sb.toString());
                } else {
                    sb.append("plugin:");
                    sb.append(plugin.mPkgName);
                    sb.append(" versionCode:");
                    sb.append(plugin.getVersion());
                    sb.append("load failed;");
                    c.a("load_finish", 42000, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                if (!plugin.isLoaded()) {
                    return false;
                }
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            }
            return true;
        }
    }

    public boolean syncInstall(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new a(file, null).a();
    }

    public void asyncInstall(File file, ZeusPluginListener zeusPluginListener) {
        if (file == null) {
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(22, "asyncInstall apk is null !");
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        } else {
            ExecutorService executorService = this.mInstallThreadPool;
            if (executorService != null) {
                executorService.execute(new a(file, zeusPluginListener));
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        }
    }
}
