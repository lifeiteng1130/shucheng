package com.bytedance.pangle.wrapper;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.Keep;
import c.b.a.m.f;
import c.c.a.e;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: classes.dex */
@Keep
@SuppressLint({"NewApi"})
public class PluginActivityWrapper extends GenerateActivityWrapper {

    public class a extends e {
        public a() {
        }

        @Override // c.c.a.e, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (activity == PluginActivityWrapper.this.mOriginActivity) {
                Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    public PluginActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        if (!activity.isDestroyed()) {
            Zeus.getAppApplication().registerActivityLifecycleCallbacks(new a());
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        f.E(this, activity);
    }
}
