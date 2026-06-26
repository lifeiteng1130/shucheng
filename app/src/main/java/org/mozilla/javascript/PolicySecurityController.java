package org.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.lang.ref.SoftReference;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.SecureClassLoader;
import java.util.Map;
import java.util.WeakHashMap;
import k.d.a.c;

/* JADX INFO: loaded from: classes3.dex */
public class PolicySecurityController extends SecurityController {
    private static final byte[] secureCallerImplBytecode = loadBytecode();
    private static final Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> callers = new WeakHashMap();

    public static class Loader extends SecureClassLoader implements GeneratedClassLoader {
        private final CodeSource codeSource;

        public Loader(ClassLoader classLoader, CodeSource codeSource) {
            super(classLoader);
            this.codeSource = codeSource;
        }

        @Override // org.mozilla.javascript.GeneratedClassLoader
        public Class<?> defineClass(String str, byte[] bArr) {
            return defineClass(str, bArr, 0, bArr.length, this.codeSource);
        }

        @Override // org.mozilla.javascript.GeneratedClassLoader
        public void linkClass(Class<?> cls) {
            resolveClass(cls);
        }
    }

    public static abstract class SecureCaller {
        public abstract Object call(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);
    }

    private static byte[] loadBytecode() {
        String name = SecureCaller.class.getName();
        c cVar = new c(a.i(name, "Impl"), name, "<generated>");
        cVar.Q("<init>", "()V", (short) 1);
        cVar.g(0);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, name, "<init>", "()V");
        cVar.c(177);
        cVar.R((short) 1);
        cVar.Q(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        for (int i2 = 1; i2 < 6; i2++) {
            cVar.g(i2);
        }
        cVar.o(185, "org/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, a.i("(", "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;"));
        cVar.c(176);
        cVar.R((short) 6);
        return cVar.S();
    }

    @Override // org.mozilla.javascript.SecurityController
    public Object callWithDomain(Object obj, final Context context, Callable callable, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Map<ClassLoader, SoftReference<SecureCaller>> weakHashMap;
        SecureCaller secureCaller;
        final ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.PolicySecurityController.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return context.getApplicationClassLoader();
            }
        });
        final CodeSource codeSource = (CodeSource) obj;
        Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> map = callers;
        synchronized (map) {
            weakHashMap = map.get(codeSource);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                map.put(codeSource, weakHashMap);
            }
        }
        synchronized (weakHashMap) {
            SoftReference<SecureCaller> softReference = weakHashMap.get(classLoader);
            SecureCaller secureCaller2 = softReference != null ? softReference.get() : null;
            if (secureCaller2 == null) {
                try {
                    secureCaller2 = (SecureCaller) AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: org.mozilla.javascript.PolicySecurityController.3
                        @Override // java.security.PrivilegedExceptionAction
                        public Object run() {
                            return new Loader(classLoader, codeSource).defineClass(SecureCaller.class.getName() + "Impl", PolicySecurityController.secureCallerImplBytecode).newInstance();
                        }
                    });
                    weakHashMap.put(classLoader, new SoftReference<>(secureCaller2));
                } catch (PrivilegedActionException e2) {
                    throw new UndeclaredThrowableException(e2.getCause());
                }
            }
            secureCaller = secureCaller2;
        }
        return secureCaller.call(callable, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.SecurityController
    public GeneratedClassLoader createClassLoader(final ClassLoader classLoader, final Object obj) {
        return (Loader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.PolicySecurityController.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return new Loader(classLoader, (CodeSource) obj);
            }
        });
    }

    @Override // org.mozilla.javascript.SecurityController
    public Object getDynamicSecurityDomain(Object obj) {
        return obj;
    }

    @Override // org.mozilla.javascript.SecurityController
    public Class<?> getStaticSecurityDomainClassInternal() {
        return CodeSource.class;
    }
}
