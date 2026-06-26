package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.b.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context a;

    public static class a {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application a;

        static {
            try {
                Object objB = b();
                a = (Application) objB.getClass().getMethod("getApplication", new Class[0]).invoke(objB, new Object[0]);
                d.c("MyApplication", "application get success");
            } catch (Throwable th) {
                d.b("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            return a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                d.b("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (a == null) {
            setContext(null);
        }
        return a;
    }

    public static synchronized void setContext(Context context) {
        if (a == null) {
            if (context != null) {
                a = context.getApplicationContext();
            } else if (a.a() != null) {
                try {
                    a = a.a();
                    if (a != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
