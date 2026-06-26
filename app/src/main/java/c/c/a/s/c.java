package c.c.a.s;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.b.a.m.f;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static class a implements ComponentCallbacks {
        public final /* synthetic */ Plugin a;

        public a(Plugin plugin) {
            this.a = plugin;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
            this.a.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }
    }

    public static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", f.t(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", f.t(str2));
            jSONObject.putOpt("version_code", f.t(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", f.t(Long.valueOf(j2)));
            jSONObject2.putOpt("message", f.t(str3));
            jSONObject2.putOpt("timestamp", f.t(Long.valueOf(System.currentTimeMillis())));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.c.a.d.b.a().b(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static synchronized boolean b(String str, Plugin plugin, StringBuilder sb) {
        try {
            c.c.a.r.c cVar = new c.c.a.r.c(ZeusLogger.TAG_LOAD, "PluginLoader", "load:".concat(String.valueOf(str)));
            if (!plugin.isInstalled()) {
                sb.append("loadPluginInternal, !plugin.isInstalled();");
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!", str);
                return false;
            }
            long jA = cVar.a("isInstalled");
            if (jA > 20 || jA < 0) {
                sb.append("isInstall cost:");
                sb.append(jA);
                sb.append(";");
            }
            String sourceFile = PluginDirHelper.getSourceFile(plugin.mPkgName, plugin.getVersion());
            if (!new File(sourceFile).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!", str);
                return false;
            }
            long jA2 = cVar.a("getSourceFile");
            if (jA2 > 20 || jA2 < 0) {
                sb.append("getSourceFile cost:");
                sb.append(jA2);
                sb.append(";");
            }
            File file = new File(PluginDirHelper.getNativeLibraryDir(plugin.mPkgName, plugin.getVersion()));
            long jA3 = cVar.a("getNativeLibraryDir");
            if (jA3 > 20 || jA3 < 0) {
                sb.append("getNativeLibraryDir cost:");
                sb.append(jA3);
                sb.append(";");
            }
            File file2 = new File(file.getParentFile(), "dalvik-cache");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            long jA4 = cVar.a("dalvikCacheDir");
            if (jA4 > 20 || jA4 < 0) {
                sb.append("dalvikCacheDirTime cost:");
                sb.append(jA4);
                sb.append(";");
            }
            plugin.mClassLoader = new PluginClassLoader(sourceFile, file2.getPath(), file.getAbsolutePath(), null);
            long jA5 = cVar.a("classloader");
            if (jA5 > 20 || jA5 < 0) {
                sb.append("classloader cost:");
                sb.append(jA5);
                sb.append(";");
            }
            PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(sourceFile, 15);
            long jA6 = cVar.a("getPackageInfo");
            if (jA6 > 20 || jA6 < 0) {
                sb.append("getPackageInfo cost:");
                sb.append(jA6);
                sb.append(";");
            }
            plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
            ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
            plugin.mHostApplicationInfoHookSomeField = applicationInfo;
            applicationInfo.nativeLibraryDir = file.getAbsolutePath();
            plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
            plugin.mHostApplicationInfoHookSomeField.sourceDir = sourceFile;
            if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
                packageArchiveInfo.applicationInfo.sourceDir = sourceFile;
            }
            if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
                packageArchiveInfo.applicationInfo.publicSourceDir = sourceFile;
            }
            long jA7 = cVar.a("setApplication");
            if (jA7 > 20 || jA7 < 0) {
                sb.append("setApplication cost:");
                sb.append(jA7);
                sb.append(";");
            }
            plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo));
            long jA8 = cVar.a("makeResources");
            if (jA8 > 20 || jA8 < 0) {
                sb.append("makeResources cost:");
                sb.append(jA8);
                sb.append(";");
            }
            Zeus.getAppApplication().registerComponentCallbacks(new a(plugin));
            ActivityInfo[] activityInfoArr = packageArchiveInfo.activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (TextUtils.isEmpty(activityInfo.processName) || !activityInfo.processName.contains(":")) {
                        activityInfo.processName = "main";
                    } else {
                        activityInfo.processName = activityInfo.processName.split(":")[1];
                    }
                    plugin.pluginActivities.put(activityInfo.name, activityInfo);
                }
            }
            ServiceInfo[] serviceInfoArr = packageArchiveInfo.services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (TextUtils.isEmpty(serviceInfo.processName) || !serviceInfo.processName.contains(":")) {
                        serviceInfo.processName = "main";
                    } else {
                        serviceInfo.processName = serviceInfo.processName.split(":")[1];
                    }
                    plugin.pluginServices.put(serviceInfo.name, serviceInfo);
                }
            }
            long jA9 = cVar.a("resolveActivityServices");
            if (jA9 > 20 || jA9 < 0) {
                sb.append("resolveActivityServices cost:");
                sb.append(jA9);
                sb.append(";");
            }
            ActivityInfo[] activityInfoArr2 = packageArchiveInfo.receivers;
            if (activityInfoArr2 != null) {
                for (ActivityInfo activityInfo2 : activityInfoArr2) {
                    if (TextUtils.isEmpty(activityInfo2.processName) || !activityInfo2.processName.contains(":")) {
                        activityInfo2.processName = "main";
                    } else {
                        activityInfo2.processName = activityInfo2.processName.split(":")[1];
                    }
                    plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
                }
            }
            long jA10 = cVar.a("resolveReceiver");
            if (jA10 > 20 || jA10 < 0) {
                sb.append("resolveReceiver cost:");
                sb.append(jA10);
                sb.append(";");
            }
            ProviderInfo[] providerInfoArr = packageArchiveInfo.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) {
                        providerInfo.processName = "main";
                    } else {
                        providerInfo.processName = providerInfo.processName.split(":")[1];
                    }
                    plugin.pluginProvider.put(providerInfo.name, providerInfo);
                }
            }
            long jA11 = cVar.a("resolveProvider");
            if (jA11 > 20 || jA11 < 0) {
                sb.append("resolveProvider cost:");
                sb.append(jA11);
                sb.append(";");
            }
            HashMap<String, ProviderInfo> map = plugin.pluginProvider;
            if (map != null && map.size() > 0) {
                ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
            }
            long jA12 = cVar.a("installProvider");
            if (jA12 > 20 || jA12 < 0) {
                sb.append("installProvider cost:");
                sb.append(jA12);
                sb.append(";");
            }
            if (!TextUtils.isEmpty(packageArchiveInfo.applicationInfo.className)) {
                ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageArchiveInfo.applicationInfo.className).newInstance();
                plugin.mApplication = zeusApplication;
                zeusApplication.attach(plugin, Zeus.getAppApplication());
            }
            long jA13 = cVar.a("makeApplication");
            if (jA13 > 20 || jA13 < 0) {
                sb.append("makeApplication cost:");
                sb.append(jA13);
                sb.append(";");
            }
            return true;
        } catch (Throwable th) {
            sb.append("loadPluginInternal ");
            sb.append(th.getMessage());
            sb.append(";");
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", str, th);
            return false;
        }
    }
}
