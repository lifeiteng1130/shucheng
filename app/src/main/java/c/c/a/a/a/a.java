package c.c.a.a.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static Map<String, Field> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Method> f683b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, Constructor> f684c = new HashMap();

    static {
        new HashMap();
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "HackHelperinit failed", e2);
        }
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strD = d(cls, "clinit", clsArr);
        synchronized (f684c) {
            constructor = f684c.get(strD);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            if (declaredConstructor != null && !declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            if (declaredConstructor != null) {
                synchronized (f684c) {
                    f684c.put(strD, declaredConstructor);
                }
            }
            return declaredConstructor;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field b(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (a) {
            field = a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null && !declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            if (declaredField != null) {
                synchronized (a) {
                    a.put(str2, declaredField);
                }
            }
            return declaredField;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strD = d(cls, str, clsArr);
        synchronized (f683b) {
            method = f683b.get(strD);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null && !declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            if (declaredMethod != null) {
                synchronized (f683b) {
                    f683b.put(strD, declaredMethod);
                }
            }
            return declaredMethod;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static String d(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }
}
