package i.a.a;

import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: BeansAccessConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static HashMap<Class<?>, LinkedHashSet<Class<?>>> a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, String>> f6347b = new HashMap<>();

    static {
        a(Object.class, f.class);
        a(Object.class, e.class);
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        synchronized (a) {
            LinkedHashSet<Class<?>> linkedHashSet = a.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                a.put(cls, linkedHashSet);
            }
            linkedHashSet.add(cls2);
        }
    }
}
