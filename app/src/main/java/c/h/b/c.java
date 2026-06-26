package c.h.b;

import java.util.HashSet;

/* JADX INFO: compiled from: ReflectUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final Object[] a = new Object[0];

    public static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    a(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
