package com.bytedance.pangle.wrapper;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.LifecycleRegistry;
import c.b.a.m.f;
import c.c.a.e;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginFragmentActivityWrapper extends GenerateFragmentActivityWrapper {
    public boolean hasInit = true;

    public class a extends e {
        public a() {
        }

        @Override // c.c.a.e, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (activity == PluginFragmentActivityWrapper.this.mOriginActivity) {
                Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    public PluginFragmentActivityWrapper(Activity activity, PluginContext pluginContext) {
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        this.mOriginActivity = fragmentActivity;
        this.pluginContext = pluginContext;
        if (!fragmentActivity.isDestroyed()) {
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

    @Override // com.bytedance.pangle.wrapper.GenerateFragmentActivityWrapper, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        if (!this.hasInit) {
            try {
                return new LifecycleRegistry(this);
            } catch (Throwable unused) {
            }
        }
        return super.getLifecycle();
    }

    public Activity getOriginActivity() {
        return this.mOriginActivity;
    }
}
