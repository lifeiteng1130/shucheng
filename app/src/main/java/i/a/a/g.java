package i.a.a;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: DynamicClassLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends ClassLoader {
    public static final String a = b.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f6351b;

    static {
        Class<?> cls = Integer.TYPE;
        f6351b = new Class[]{String.class, byte[].class, cls, cls};
    }

    public g(ClassLoader classLoader) {
        super(classLoader);
    }

    public Class<?> a(String str, byte[] bArr) {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", f6351b);
            declaredMethod.setAccessible(true);
            return (Class) declaredMethod.invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length));
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }

    @Override // java.lang.ClassLoader
    public synchronized Class<?> loadClass(String str, boolean z) {
        if (str.equals(a)) {
            return b.class;
        }
        return super.loadClass(str, z);
    }
}
