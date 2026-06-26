package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import c.b.a.m.f;
import c.c.a.g;
import c.c.a.q;
import c.c.a.x.e;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    private Handler mHandler;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    private String mPackageDir;
    public String mPkgName;
    public Resources mResources;
    private int mVersionCode;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final Object installLock = new Object();
    public final Object initializeLock = new Object();

    public class a implements FileFilter {
        public a(Plugin plugin) {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file != null && file.getName().matches("^version-(\\d+)$");
        }
    }

    public class b implements FileFilter {
        public b() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            if (file.getName().matches("^version-(\\d+)$")) {
                e.b().c(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
            }
            return false;
        }
    }

    public class c implements FileFilter {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            if (file != null && !this.a.equals(file.getName()) && !"data".equals(file.getName())) {
                f.H(file.getAbsolutePath());
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                if (file.getName().matches("^version-(\\d+)$")) {
                    e.b().c(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
            }
            return false;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f1616b;

        public d(Plugin plugin, String str, boolean z) {
            this.a = str;
            this.f1616b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<ZeusPluginStateListener> list = q.a().f780d;
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<ZeusPluginStateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onPluginInstallResult(this.a, this.f1616b);
            }
        }
    }

    public Plugin(JSONObject jSONObject, Handler handler) throws JSONException {
        this.mMaxVersionCode = Integer.MAX_VALUE;
        try {
            this.mHandler = handler;
            this.mPkgName = jSONObject.getString("packageName");
            this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
            this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
            this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        } catch (JSONException e2) {
            throw e2;
        }
    }

    private boolean checkValid(File file, String str, int i2) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i2 < this.mMinVersionCode || i2 > this.mMaxVersionCode) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i2), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
            return false;
        }
        if (i2 < this.mVersionCode && isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i2), Integer.valueOf(this.mVersionCode)));
            return false;
        }
        if (file == null || !file.exists()) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i2 == this.mVersionCode && e.b().f812b.getString("MD5_".concat(String.valueOf(str)), "").equals(c.c.a.x.b.a(file))) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same md5 has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i2 + " true");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkVersionValid(int r17, int r18, long r19, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.Plugin.checkVersionValid(int, int, long, boolean):boolean");
    }

    private void deleteIfNeeded() {
        if (c.c.a.n.c.b(Zeus.getAppApplication())) {
            if (e.b().f812b.getBoolean("DELETED__".concat(String.valueOf(this.mPkgName)), false)) {
                e eVarB = e.b();
                String str = this.mPkgName;
                SharedPreferences.Editor editorEdit = eVarB.f812b.edit();
                editorEdit.remove("DELETED__".concat(String.valueOf(str)));
                editorEdit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = PluginDirHelper.getPackageDir(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new b());
        f.H(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i2) {
        if (c.c.a.n.c.b(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = PluginDirHelper.getPackageDir(this.mPkgName);
            }
            new File(this.mPackageDir).listFiles(new c(PluginDirHelper.VERSION_PREFIX.concat(String.valueOf(i2))));
        }
    }

    private int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = PluginDirHelper.getPackageDir(this.mPkgName);
        }
        File[] fileArrListFiles = new File(this.mPackageDir).listFiles(new a(this));
        int i2 = -1;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i3 = Integer.parseInt(file.getName().split("-")[1]);
                if (i3 > i2 && e.b().d(this.mPkgName, i3) && new File(PluginDirHelper.getSourceFile(this.mPkgName, i3)).exists()) {
                    i2 = i3;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i2);
        return i2;
    }

    private void postPluginInstalled(String str, boolean z) {
        this.mHandler.post(new d(this, str, z));
    }

    private void updateInstallStateFromMainProcess() {
        g gVarB;
        try {
            if (c.c.a.n.c.b(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (gVarB = c.c.a.v.a.b()) == null || !gVarB.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(gVarB.b(this.mPkgName));
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + c.c.a.n.c.a(Zeus.getAppApplication()), this.mPkgName, th);
        }
    }

    private void updateToInstalled(int i2) {
        this.mVersionCode = i2;
        this.mLifeCycle = 2;
    }

    public void clearOffline() {
        e.b().f(this.mPkgName);
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i2 = this.mVersionCode;
        return i2 > 0 ? PluginDirHelper.getNativeLibraryDir(this.mPkgName, i2) : PluginDirHelper.getPackageDir(this.mPkgName);
    }

    public String getPackageVersionDir() {
        int i2 = this.mVersionCode;
        return i2 > 0 ? PluginDirHelper.getPackageVersionDir(this.mPkgName, i2) : PluginDirHelper.getPackageDir(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (c.c.a.n.c.b(Zeus.getAppApplication())) {
                int i2 = 0;
                if (!TextUtils.isEmpty(e.b().f812b.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    e eVarB = e.b();
                    String str = this.mPkgName;
                    boolean z2 = !TextUtils.equals(eVarB.f812b.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + eVarB.f812b.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z2);
                    z = z2;
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, q.a().f779c.getHostVersionCode(), z)) {
                    updateToInstalled(installedMaxVer);
                    i2 = installedMaxVer;
                }
                deleteOtherExpiredVer(i2);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                e eVarB2 = e.b();
                String str2 = this.mPkgName;
                SharedPreferences.Editor editorEdit = eVarB2.f812b.edit();
                editorEdit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                editorEdit.apply();
                e eVarB3 = e.b();
                String str3 = this.mPkgName;
                String string = eVarB3.f812b.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor editorEdit2 = eVarB3.f812b.edit();
                editorEdit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                editorEdit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                e eVarB4 = e.b();
                String str4 = this.mPkgName;
                int i3 = this.mApiVersionCode;
                int iA = eVarB4.a(str4);
                if (iA != i3) {
                    SharedPreferences.Editor editorEdit3 = eVarB4.f812b.edit();
                    editorEdit3.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str4)), i3);
                    editorEdit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + iA + " --> " + i3);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[Catch: all -> 0x00c0, TryCatch #1 {all -> 0x00c0, blocks: (B:9:0x0046, B:11:0x004f, B:13:0x0056, B:21:0x006e, B:20:0x0069, B:16:0x0061), top: B:49:0x0046 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean install(java.io.File r11, c.c.a.i$b.c r12) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.Plugin.install(java.io.File, c.c.a.i$b.c):boolean");
    }

    @Deprecated
    public boolean isHostModule() {
        return false;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isOffline() {
        return e.b().g(this.mPkgName);
    }

    public boolean isVersionInstalled(int i2) {
        return e.b().d(this.mPkgName, i2);
    }

    public void markOffline() {
        e.b().e(this.mPkgName);
    }

    public void setApiCompatVersion(int i2, int i3, int i4) {
        e eVarB = e.b();
        String str = this.mPkgName;
        SharedPreferences.Editor editorEdit = eVarB.f812b.edit();
        editorEdit.putInt("API_MIN_" + str + "_" + i2, i3);
        editorEdit.putInt("API_MAX_" + str + "_" + i2, i4);
        editorEdit.apply();
    }

    public void setHostCompatVersion(int i2, int i3, int i4) {
        e eVarB = e.b();
        String str = this.mPkgName;
        SharedPreferences.Editor editorEdit = eVarB.f812b.edit();
        editorEdit.putInt("HOST_MIN_" + str + "_" + i2, i3);
        editorEdit.putInt("HOST_MAX_" + str + "_" + i2, i4);
        editorEdit.apply();
    }

    public void setLifeCycle(int i2) {
        this.mLifeCycle = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Plugin{pkg=");
        sb.append(this.mPkgName);
        sb.append(", ver=");
        sb.append(this.mVersionCode);
        sb.append(", life=");
        return c.a.a.a.a.n(sb, this.mLifeCycle, MessageFormatter.DELIM_STOP);
    }
}
