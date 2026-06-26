package c.h.b;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MemberUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final Map<Class<?>, Class<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f1594b;

    static {
        Class cls = Byte.TYPE;
        Class cls2 = Short.TYPE;
        Class cls3 = Character.TYPE;
        Class cls4 = Integer.TYPE;
        Class cls5 = Long.TYPE;
        Class cls6 = Float.TYPE;
        Class cls7 = Double.TYPE;
        HashMap map = new HashMap();
        a = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(cls4, Integer.class);
        map.put(cls5, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(cls6, Float.class);
        Class cls8 = Void.TYPE;
        map.put(cls8, cls8);
        f1594b = new HashMap();
        for (Class<?> cls9 : map.keySet()) {
            Class<?> cls10 = a.get(cls9);
            if (!cls9.equals(cls10)) {
                f1594b.put(cls10, cls9);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers())) {
                if ((member.getDeclaringClass().getModifiers() & 7) == 0) {
                    try {
                        accessibleObject.setAccessible(true);
                        return true;
                    } catch (SecurityException unused) {
                    }
                }
            }
        }
        return false;
    }
}
