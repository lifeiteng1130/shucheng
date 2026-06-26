package org.mozilla.javascript;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VMBridge {
    public static final VMBridge instance = makeInstance();

    private static VMBridge makeInstance() {
        VMBridge vMBridge;
        String[] strArr = {"org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk18.VMBridge_jdk18"};
        for (int i2 = 0; i2 != 2; i2++) {
            Class<?> clsClassOrNull = Kit.classOrNull(strArr[i2]);
            if (clsClassOrNull != null && (vMBridge = (VMBridge) Kit.newInstanceOrNull(clsClassOrNull)) != null) {
                return vMBridge;
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }

    public abstract Context getContext(Object obj);

    public abstract Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr);

    public abstract Object getThreadContextHelper();

    public abstract Object newInterfaceProxy(Object obj, ContextFactory contextFactory, InterfaceAdapter interfaceAdapter, Object obj2, Scriptable scriptable);

    public abstract void setContext(Object obj, Context context);

    public abstract boolean tryToMakeAccessible(AccessibleObject accessibleObject);
}
