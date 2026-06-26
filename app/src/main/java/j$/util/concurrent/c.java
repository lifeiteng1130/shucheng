package j$.util.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class c {
    private static final Unsafe a;

    static {
        Field fieldB = b();
        fieldB.setAccessible(true);
        try {
            a = (Unsafe) fieldB.get(null);
        } catch (IllegalAccessException e2) {
            throw new Error("Couldn't get the Unsafe", e2);
        }
    }

    public static final int a(Unsafe unsafe, Object obj, long j2, int i2) {
        int intVolatile;
        do {
            intVolatile = unsafe.getIntVolatile(obj, j2);
        } while (!unsafe.compareAndSwapInt(obj, j2, intVolatile, intVolatile + i2));
        return intVolatile;
    }

    private static Field b() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e2) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new Error("Couldn't find the Unsafe", e2);
        }
    }

    public static Unsafe c() {
        return a;
    }
}
