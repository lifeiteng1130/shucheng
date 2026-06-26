package org.mozilla.javascript.jdk18;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.InterfaceAdapter;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.VMBridge;

/* JADX INFO: loaded from: classes3.dex */
public class VMBridge_jdk18 extends VMBridge {
    private static final ThreadLocal<Object[]> contextLocal = new ThreadLocal<>();

    @Override // org.mozilla.javascript.VMBridge
    public Context getContext(Object obj) {
        return (Context) ((Object[]) obj)[0];
    }

    @Override // org.mozilla.javascript.VMBridge
    public Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr) {
        try {
            return Proxy.getProxyClass(clsArr[0].getClassLoader(), clsArr).getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // org.mozilla.javascript.VMBridge
    public Object getThreadContextHelper() {
        ThreadLocal<Object[]> threadLocal = contextLocal;
        Object[] objArr = threadLocal.get();
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[1];
        threadLocal.set(objArr2);
        return objArr2;
    }

    @Override // org.mozilla.javascript.VMBridge
    public Object newInterfaceProxy(Object obj, final ContextFactory contextFactory, final InterfaceAdapter interfaceAdapter, final Object obj2, final Scriptable scriptable) {
        try {
            return ((Constructor) obj).newInstance(new InvocationHandler() { // from class: org.mozilla.javascript.jdk18.VMBridge_jdk18.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) {
                    if (method.getDeclaringClass() == Object.class) {
                        String name = method.getName();
                        if (name.equals("equals")) {
                            return Boolean.valueOf(obj3 == objArr[0]);
                        }
                        if (name.equals(TTDownloadField.TT_HASHCODE)) {
                            return Integer.valueOf(obj2.hashCode());
                        }
                        if (name.equals("toString")) {
                            StringBuilder sbR = a.r("Proxy[");
                            sbR.append(obj2.toString());
                            sbR.append("]");
                            return sbR.toString();
                        }
                    }
                    return interfaceAdapter.invoke(contextFactory, obj2, scriptable, obj3, method, objArr);
                }
            });
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        } catch (InvocationTargetException e4) {
            throw Context.throwAsScriptRuntimeEx(e4);
        }
    }

    @Override // org.mozilla.javascript.VMBridge
    public void setContext(Object obj, Context context) {
        ((Object[]) obj)[0] = context;
    }

    @Override // org.mozilla.javascript.VMBridge
    public boolean tryToMakeAccessible(AccessibleObject accessibleObject) {
        if (accessibleObject.isAccessible()) {
            return true;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception unused) {
        }
        return accessibleObject.isAccessible();
    }
}
