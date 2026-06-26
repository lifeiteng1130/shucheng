package com.bytedance.pangle.service;

import android.app.IntentService;
import android.content.ComponentName;
import androidx.annotation.Keep;
import c.c.a.w.b;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
@Keep
public abstract class PluginIntentService extends IntentService implements b {
    private static final String TAG = "PluginService";

    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            name.hashCode();
            if (name.equals("getForegroundServiceType")) {
                return 0;
            }
            if (!name.equals("stopServiceToken")) {
                return null;
            }
            c.c.a.w.a.a aVarM = c.c.a.w.a.a.m();
            PluginIntentService pluginIntentService = PluginIntentService.this;
            return Boolean.valueOf(aVarM.f(new ComponentName(pluginIntentService, pluginIntentService.getClass().getName())));
        }
    }

    public PluginIntentService(String str) {
        super(str);
    }

    @Override // c.c.a.w.b
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e2);
        }
    }

    public Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new a());
    }
}
