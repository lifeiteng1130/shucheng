package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public class DefiningClassLoader extends ClassLoader implements GeneratedClassLoader {
    private final ClassLoader parentLoader;

    public DefiningClassLoader() {
        this.parentLoader = getClass().getClassLoader();
    }

    @Override // org.mozilla.javascript.GeneratedClassLoader
    public Class<?> defineClass(String str, byte[] bArr) {
        return super.defineClass(str, bArr, 0, bArr.length, SecurityUtilities.getProtectionDomain(getClass()));
    }

    @Override // org.mozilla.javascript.GeneratedClassLoader
    public void linkClass(Class<?> cls) {
        resolveClass(cls);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass == null) {
            ClassLoader classLoader = this.parentLoader;
            clsFindLoadedClass = classLoader != null ? classLoader.loadClass(str) : findSystemClass(str);
        }
        if (z) {
            resolveClass(clsFindLoadedClass);
        }
        return clsFindLoadedClass;
    }

    public DefiningClassLoader(ClassLoader classLoader) {
        this.parentLoader = classLoader;
    }
}
