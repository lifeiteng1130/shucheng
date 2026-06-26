package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.ApkVerifier;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginProvider;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.umeng.analytics.pro.ai;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: TTPluginManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CountDownLatch f1725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<String, TTPluginListener> f1726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap<String, Handler> f1727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile DexClassLoader f1728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile f f1729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1730h;

    /* JADX INFO: compiled from: TTPluginManager.java */
    public static class a {
        private static final c a = new c();
    }

    /* JADX INFO: compiled from: TTPluginManager.java */
    public static final class b implements TTAdEvent {
        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            if (i2 == 1) {
                d dVarA = f.a(bundle.getString("config"));
                if (dVarA == null || TextUtils.isEmpty(dVarA.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin update received with invalid config");
                    return;
                }
                boolean z = bundle.getBoolean("success");
                TTPluginListener tTPluginListener = (TTPluginListener) f.f1726d.get(dVarA.mPackageName);
                if (!z) {
                    if (tTPluginListener != null) {
                        tTPluginListener.onPluginListener(1001, null, null, null);
                    }
                    com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin update failed");
                    return;
                }
                StringBuilder sbR = c.a.a.a.a.r("plugin update received: ");
                sbR.append(dVarA.mPackageName);
                com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", sbR.toString());
                if (dVarA.isRevert) {
                    Zeus.unInstallPlugin(dVarA.mPackageName);
                } else if (f.b(dVarA, tTPluginListener)) {
                    bundle.putBoolean("installed", true);
                }
            }
        }
    }

    static {
        StringBuilder sbR = c.a.a.a.a.r(ES6Iterator.NEXT_METHOD);
        String str = File.separator;
        sbR.append(str);
        a = sbR.toString();
        f1724b = c.a.a.a.a.i(str, "conf");
        f1725c = new CountDownLatch(1);
        f1726d = new HashMap<>();
        f1727e = new HashMap<>();
        f1729g = null;
    }

    private f(Context context) {
        e.a(context);
        c(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AssetManager assets = context.getAssets();
        try {
            String strA = com.bytedance.sdk.openadsdk.api.plugin.b.a(PluginConstants.getSign());
            File fileF = f(context);
            File file = new File(fileF, (strA + "-4011-4011") + ".apk");
            if (!a(assets.open(strA), file)) {
                throw new IOException("Select nested failed");
            }
            com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "Select nested");
            return a(file, PluginConstants.getSign());
        } catch (Throwable th) {
            if (th instanceof FileNotFoundException) {
                e.a(1, th.getMessage(), System.currentTimeMillis() - jCurrentTimeMillis);
                return null;
            }
            e.a(2, th.getMessage(), System.currentTimeMillis() - jCurrentTimeMillis);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<PluginDownloadBean> e(Context context) {
        File[] fileArrListFiles = g(context).listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str != null && str.endsWith(".conf");
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            d dVarA = a(c(file));
            if (dVarA != null && dVarA.f1719b.exists()) {
                arrayList.add(dVarA);
            }
        }
        return arrayList;
    }

    private static File f(Context context) {
        return new File(h(context), a);
    }

    private static File g(Context context) {
        return new File(h(context), f1724b);
    }

    private static File h(Context context) {
        return new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle");
    }

    private void c(final Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ZeusParam zeusParamBuild = new ZeusParam.Builder().autoFetch(true).closeDefaultReport(true).reporter(new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.3
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    e.a(str, jSONObject);
                }
            }).verifyWith(new ApkVerifier() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.2
                @Override // com.bytedance.pangle.ApkVerifier
                public boolean verify(File file) {
                    d dVarB = f.b(file);
                    return dVarB != null ? a.a.a(dVarB.a, file) : a.a.a(f.this.f1730h, file);
                }
            }).pluginProvider(new PluginProvider() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
                @Override // com.bytedance.pangle.plugin.PluginProvider
                public File provideBuiltInPlugin() {
                    if (Zeus.isPluginInstalled(TTAdConstant.BUILT_IN_PLUGIN_NAME)) {
                        return null;
                    }
                    return f.this.d(context);
                }

                @Override // com.bytedance.pangle.plugin.PluginProvider
                public List<PluginDownloadBean> providePluginConfig() {
                    return f.e(context);
                }

                @Override // com.bytedance.pangle.plugin.PluginProvider
                public boolean useLocalPlugin() {
                    return true;
                }
            }).withCheckPermission(false).build();
            PluginDirHelper.setPluginDir(f(context));
            Zeus.init((Application) context, zeusParamBuild);
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginInstallResult(String str, boolean z) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Plugin install result: [" + str + "]," + z);
                    if (!TTAdConstant.BUILT_IN_PLUGIN_NAME.equals(str)) {
                        f.b(z, str, (TTPluginListener) f.f1726d.get(str));
                        return;
                    }
                    if (z && Zeus.loadPlugin(str)) {
                        DexClassLoader unused = f.f1728f = Zeus.getPlugin(str).mClassLoader;
                    }
                    f.f1725c.countDown();
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Unexpected error for init zeus.", th);
            e.a(4, th.getMessage(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        File file2 = new File(g(TTAppContextHolder.getContext()), c.a.a.a.a.p(new StringBuilder(), b(file.getName()), ".conf"));
        if (file2.exists()) {
            return a(c(file2));
        }
        return null;
    }

    public static f a(Context context) {
        if (f1729g == null) {
            synchronized (f.class) {
                if (f1729g == null) {
                    f1729g = new f(context);
                }
            }
        }
        return f1729g;
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(".");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(d dVar, TTPluginListener tTPluginListener) {
        File file;
        if (dVar != null && (file = dVar.f1719b) != null) {
            boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(file.getAbsolutePath());
            b(zSyncInstallPlugin, dVar.mPackageName, tTPluginListener);
            return zSyncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin config is null");
        return false;
    }

    public DexClassLoader a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (!Zeus.isPluginInstalled(TTAdConstant.BUILT_IN_PLUGIN_NAME)) {
                f1725c.await(60000L, TimeUnit.MILLISECONDS);
            }
            if (!Zeus.isPluginLoaded(TTAdConstant.BUILT_IN_PLUGIN_NAME) && Zeus.loadPlugin(TTAdConstant.BUILT_IN_PLUGIN_NAME)) {
                f1728f = Zeus.getPlugin(TTAdConstant.BUILT_IN_PLUGIN_NAME).mClassLoader;
            }
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Unexpected error for load plugin.", e2);
            e.a(3, e2.getMessage(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
        return f1728f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, String str, TTPluginListener tTPluginListener) {
        Plugin plugin;
        StringBuilder sbT = c.a.a.a.a.t("Install dl plugin ", str);
        sbT.append(z ? " success" : " failed");
        sbT.append(", need notify: ");
        sbT.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", sbT.toString());
        HashMap<String, Handler> map = f1727e;
        Handler handler = map.get(str);
        if (tTPluginListener == null || handler == null) {
            return;
        }
        if (z && Zeus.loadPlugin(str) && (plugin = Zeus.getPlugin(str)) != null) {
            a(plugin, tTPluginListener);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            tTPluginListener.onPluginListener(1001, null, null, null);
        }
        f1726d.remove(str);
        map.remove(str);
    }

    private static String c(File file) throws Throwable {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (file != null && file.exists()) {
            try {
                fileReader = new FileReader(file);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[1024];
                    while (true) {
                        int i2 = fileReader.read(cArr);
                        if (i2 == -1) {
                            break;
                        }
                        sb.append(cArr, 0, i2);
                    }
                    String string = sb.toString();
                    try {
                        fileReader.close();
                    } catch (IOException unused) {
                    }
                    return string;
                } catch (Exception unused2) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private File a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Selected plugin with empty sign");
            return null;
        }
        this.f1730h = str;
        return file;
    }

    public Bundle a(String str, Bundle bundle) {
        Plugin plugin;
        if (Zeus.isPluginInstalled(str) && (plugin = Zeus.getPlugin(str)) != null) {
            bundle.putString("plugin_version", a(plugin.getVersion()));
        }
        g.a(str, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public void a(final TTPluginListener tTPluginListener) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        StringBuilder sbR = c.a.a.a.a.r("Find plugin:");
        sbR.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", sbR.toString());
        if (plugin != null) {
            a(plugin, tTPluginListener);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            f1726d.put(strPackageName, tTPluginListener);
            f1727e.put(strPackageName, handler);
        }
    }

    public static d a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.mPackageName = jSONObject.optString(ai.o);
        dVar.mVersionCode = jSONObject.optInt("version_code");
        dVar.mUrl = jSONObject.optString("download_url");
        dVar.mMd5 = jSONObject.optString("md5");
        dVar.mApiVersionMin = jSONObject.optInt("min_version");
        dVar.mApiVersionMax = jSONObject.optInt("max_version");
        dVar.a = jSONObject.optString("sign");
        dVar.isRevert = jSONObject.optBoolean("is_revert");
        dVar.f1719b = new File(jSONObject.optString("plugin_file"));
        return dVar;
    }

    private static boolean a(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 > 0) {
                            fileOutputStream2.write(bArr, 0, i2);
                        } else {
                            a(inputStream);
                            a(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "copy failed");
                        return false;
                    } finally {
                        a(inputStream);
                        a(fileOutputStream);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Plugin plugin, TTPluginListener tTPluginListener) {
        Bundle bundle = new Bundle();
        Bundle bundleConfig = tTPluginListener.config();
        bundleConfig.putString("plugin_version", a(plugin.getVersion()));
        bundle.putBundle(plugin.mPkgName, bundleConfig);
        bundle.putInt("action", 0);
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    private static String a(int i2) {
        char[] charArray = String.valueOf(i2).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            sb.append(charArray[i3]);
            if (i3 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
