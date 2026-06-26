package com.bytedance.pangle;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Keep;
import c.c.a.f.c;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import java.io.File;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ZeusApplication extends PluginContext {
    public Application mHostApplication;

    public void attach(Plugin plugin, Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        attachBaseContext(application);
        onCreate();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        ApplicationInfo applicationInfo;
        super.attachBaseContext(context);
        Set<File> set = c.a;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Installing application");
        try {
            if (c.f696b) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex VM has multidex support, MultiDex support library is disabled.");
                return;
            }
            try {
                applicationInfo = getApplicationInfo();
            } catch (RuntimeException e2) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDexFailure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } else {
                c.a(applicationInfo, this, new File(this.mPlugin.mHostApplicationInfoHookSomeField.sourceDir), "secondary-dexes", applicationInfo.packageName);
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex install done");
            }
        } catch (Exception e3) {
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDex installation failure", e3);
            throw new RuntimeException("MultiDex installation failed (" + e3.getMessage() + ").");
        }
    }

    public void onCreate() {
    }
}
