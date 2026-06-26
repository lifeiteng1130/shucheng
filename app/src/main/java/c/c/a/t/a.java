package c.c.a.t;

import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final c a;

    /* JADX INFO: renamed from: c.c.a.t.a$a, reason: collision with other inner class name */
    public static class C0035a implements c {
        public C0035a(byte b2) {
        }

        public static Object b(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // c.c.a.t.a.c
        public boolean a(Context context) throws IllegalAccessException {
            Object field;
            Object objB = b(context);
            if (objB != null) {
                try {
                    field = FieldUtils.readField(objB, "mWhiteList");
                } catch (Throwable unused) {
                    field = null;
                }
            } else {
                field = null;
            }
            if (!(field instanceof String[])) {
                if (objB == null) {
                    return false;
                }
                FieldUtils.writeField(objB, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) field);
            FieldUtils.writeField(objB, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }
    }

    public static class b extends e {
        public b(byte b2) {
            super((byte) 0);
        }

        @Override // c.c.a.t.a.e, c.c.a.t.a.C0035a, c.c.a.t.a.c
        public final boolean a(Context context) {
            return false;
        }
    }

    public interface c {
        boolean a(Context context);
    }

    public static class d extends C0035a {
        public d(byte b2) {
            super((byte) 0);
        }

        @Override // c.c.a.t.a.C0035a, c.c.a.t.a.c
        public final boolean a(Context context) {
            Object field;
            Object objB = C0035a.b(context);
            if (objB != null) {
                try {
                    field = FieldUtils.readField(objB, "mWhiteList");
                } catch (Throwable unused) {
                    field = null;
                }
            } else {
                field = null;
            }
            if (!(field instanceof List)) {
                return false;
            }
            ((List) field).add(context.getPackageName());
            return true;
        }
    }

    public static class e extends C0035a {
        public e(byte b2) {
            super((byte) 0);
        }

        @Override // c.c.a.t.a.C0035a, c.c.a.t.a.c
        public boolean a(Context context) {
            Object field;
            Object objB = C0035a.b(context);
            if (objB != null) {
                try {
                    field = FieldUtils.readField(objB, "mWhiteListMap");
                } catch (Throwable unused) {
                    field = null;
                }
            } else {
                field = null;
            }
            if (!(field instanceof Map)) {
                return false;
            }
            Map map = (Map) field;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24) {
            a = new C0035a((byte) 0);
            return;
        }
        if (i2 < 26) {
            a = new d((byte) 0);
        } else if (i2 < 28) {
            a = new e((byte) 0);
        } else {
            a = new b((byte) 0);
        }
    }
}
