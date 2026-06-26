package c.h.b;

import c.b.a.m.f;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: FieldUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Map<String, Field> a = new HashMap();

    public static Field a(String str, String str2, boolean z) {
        try {
            Class<?> cls = Class.forName(str);
            boolean z2 = false;
            f.E3(true, "The class must not be null", new Object[0]);
            f.E3(!(str2.length() == 0), "The field name must not be blank/empty", new Object[0]);
            try {
                Field declaredField = cls.getDeclaredField(str2);
                Map<Class<?>, Class<?>> map = b.a;
                if (declaredField != null && Modifier.isPublic(declaredField.getModifiers()) && !declaredField.isSynthetic()) {
                    z2 = true;
                }
                if (!z2) {
                    if (!z) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Field b(Class<?> cls, String str, boolean z) {
        Field field;
        Field declaredField;
        f.E3(cls != null, "The class must not be null", new Object[0]);
        f.E3(!(str == null || str.length() == 0), "The field name must not be blank/empty", new Object[0]);
        String str2 = cls.toString() + "#" + str;
        synchronized (a) {
            field = a.get(str2);
        }
        if (field != null) {
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                if (z) {
                    declaredField.setAccessible(true);
                } else {
                    continue;
                }
            }
            synchronized (a) {
                a.put(str2, declaredField);
            }
            return declaredField;
        }
        Field field2 = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c.a(cls, linkedHashSet);
        Iterator it = new ArrayList(linkedHashSet).iterator();
        while (it.hasNext()) {
            try {
                Field field3 = ((Class) it.next()).getField(str);
                f.E3(field2 == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field2 = field3;
            } catch (NoSuchFieldException unused2) {
            }
        }
        synchronized (a) {
            a.put(str2, field2);
        }
        return field2;
    }

    public static Object c(Field field, Object obj, boolean z) {
        f.E3(field != null, "The field must not be null", new Object[0]);
        if (!z || field.isAccessible()) {
            b.a(field);
        } else {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static void d(Object obj, String str, Object obj2) throws IllegalAccessException {
        f.E3(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field fieldB = b(cls, str, true);
        f.E3(fieldB != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        f.E3(fieldB != null, "The field must not be null", new Object[0]);
        if (fieldB.isAccessible()) {
            b.a(fieldB);
        } else {
            fieldB.setAccessible(true);
        }
        fieldB.set(obj, obj2);
    }
}
