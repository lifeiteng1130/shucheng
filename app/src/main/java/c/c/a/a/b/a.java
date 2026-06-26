package c.c.a.a.b;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f686c;

    static {
        try {
            a = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            f685b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f686c = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    public static Field a(Class<?> cls, String str) {
        Throwable th;
        Field field;
        Method method = a;
        Field field2 = null;
        if (method != null) {
            try {
                field = (Field) method.invoke(cls, str);
                if (field != null) {
                    try {
                        field.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                field = null;
            }
            field2 = field;
        }
        return field2 != null ? field2 : c.c.a.a.a.a.b(cls, str);
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        Throwable th;
        Method method;
        Method method2 = f685b;
        Method method3 = null;
        if (method2 != null) {
            try {
                method = (Method) method2.invoke(cls, str, clsArr);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                method = null;
            }
            method3 = method;
        }
        return method3 != null ? method3 : c.c.a.a.a.a.c(cls, str, clsArr);
    }
}
