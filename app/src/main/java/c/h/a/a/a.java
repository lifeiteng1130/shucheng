package c.h.a.a;

import android.content.Context;
import android.os.Build;
import c.b.a.m.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LoadedApkHuaWei.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final c a;

    /* JADX INFO: compiled from: LoadedApkHuaWei.java */
    public static class b implements c {
        public b(C0054a c0054a) {
        }

        @Override // c.h.a.a.a.c
        public void a(Context context) throws IllegalAccessException {
            Object objB = b(context);
            Object objC = c(objB, "mWhiteList");
            if (!(objC instanceof String[])) {
                if (objB != null) {
                    c.h.b.a.d(objB, "mResourceConfig", null);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(context.getPackageName());
                Collections.addAll(arrayList, (String[]) objC);
                c.h.b.a.d(objB, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public final Object b(Context context) {
            Field fieldA;
            Object objC;
            try {
                Field fieldA2 = c.h.b.a.a("android.app.LoadedApk", "mReceiverResource", true);
                if (fieldA2 == null || (fieldA = c.h.b.a.a("android.app.ContextImpl", "mPackageInfo", true)) == null || (objC = c.h.b.a.c(fieldA, context, true)) == null) {
                    return null;
                }
                return c.h.b.a.c(fieldA2, objC, true);
            } catch (Throwable unused) {
                return null;
            }
        }

        public final Object c(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                Map<String, Field> map = c.h.b.a.a;
                f.E3(obj != null, "target object must not be null", new Object[0]);
                Class<?> cls = obj.getClass();
                Field fieldB = c.h.b.a.b(cls, str, true);
                f.E3(fieldB != null, "Cannot locate field %s on %s", str, cls);
                return c.h.b.a.c(fieldB, obj, false);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: LoadedApkHuaWei.java */
    public interface c {
        void a(Context context);
    }

    /* JADX INFO: compiled from: LoadedApkHuaWei.java */
    public static class d extends b {
        public d(C0054a c0054a) {
            super(null);
        }

        @Override // c.h.a.a.a.b, c.h.a.a.a.c
        public void a(Context context) {
            Object objC = c(b(context), "mWhiteList");
            if (objC instanceof List) {
                ((List) objC).add(context.getPackageName());
            }
        }
    }

    /* JADX INFO: compiled from: LoadedApkHuaWei.java */
    public static class e extends b {
        public e(C0054a c0054a) {
            super(null);
        }

        @Override // c.h.a.a.a.b, c.h.a.a.a.c
        public void a(Context context) {
            Object objC = c(b(context), "mWhiteListMap");
            if (objC instanceof Map) {
                Map map = (Map) objC;
                List arrayList = (List) map.get(0);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(0, arrayList);
                }
                arrayList.add(context.getPackageName());
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            a = new e(null);
        } else if (i2 >= 24) {
            a = new d(null);
        } else {
            a = new b(null);
        }
    }
}
