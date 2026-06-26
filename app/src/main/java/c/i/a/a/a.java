package c.i.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import javax.script.Invocable;

/* JADX INFO: compiled from: InterfaceImplementor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private Invocable engine;

    /* JADX INFO: renamed from: c.i.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InterfaceImplementor.java */
    public final class C0055a implements InvocationHandler {
        public Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AccessControlContext f1595b;

        /* JADX INFO: renamed from: c.i.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: InterfaceImplementor.java */
        public class C0056a implements PrivilegedExceptionAction<Object> {
            public final /* synthetic */ Method a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object[] f1597b;

            public C0056a(Method method, Object[] objArr) {
                this.a = method;
                this.f1597b = objArr;
            }

            @Override // java.security.PrivilegedExceptionAction
            public Object run() {
                C0055a c0055a = C0055a.this;
                return c0055a.a == null ? a.this.engine.invokeFunction(this.a.getName(), this.f1597b) : a.this.engine.invokeMethod(C0055a.this.a, this.a.getName(), this.f1597b);
            }
        }

        public C0055a(Object obj, AccessControlContext accessControlContext) {
            this.a = obj;
            this.f1595b = accessControlContext;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws PrivilegedActionException {
            return a.this.convertResult(method, AccessController.doPrivileged(new C0056a(method, a.this.convertArguments(method, objArr)), this.f1595b));
        }
    }

    public a(Invocable invocable) {
        this.engine = invocable;
    }

    public Object[] convertArguments(Method method, Object[] objArr) {
        return objArr;
    }

    public Object convertResult(Method method, Object obj) {
        throw null;
    }

    public <T> T getInterface(Object obj, Class<T> cls) {
        if (cls == null || !cls.isInterface()) {
            throw new IllegalArgumentException("interface Class expected");
        }
        if (!isImplemented(obj, cls)) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0055a(obj, AccessController.getContext())));
    }

    public boolean isImplemented(Object obj, Class<?> cls) {
        throw null;
    }
}
