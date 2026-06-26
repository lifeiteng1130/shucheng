package com.sun.script.javascript;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import l.a.b.a;
import org.mozilla.javascript.ClassShutter;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.WrapFactory;

/* JADX INFO: loaded from: classes.dex */
public final class RhinoWrapFactory extends WrapFactory {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static RhinoWrapFactory theInstance;

    public static class RhinoJavaObject extends NativeJavaObject {
        public RhinoJavaObject(Scriptable scriptable, Object obj, Class cls) {
            super(scriptable, null, cls);
            this.javaObject = obj;
        }
    }

    private RhinoWrapFactory() {
    }

    public static synchronized WrapFactory getInstance() {
        if (theInstance == null) {
            theInstance = new RhinoWrapFactory();
        }
        return theInstance;
    }

    @Override // org.mozilla.javascript.WrapFactory
    public Scriptable wrapAsJavaObject(Context context, Scriptable scriptable, Object obj, Class cls) {
        String name;
        SecurityManager securityManager = System.getSecurityManager();
        ClassShutter rhinoClassShutter = RhinoClassShutter.getInstance();
        if (obj instanceof ClassLoader) {
            if (securityManager != null) {
                securityManager.checkPermission(a.a);
            }
            return super.wrapAsJavaObject(context, scriptable, obj, cls);
        }
        if (obj instanceof Class) {
            name = ((Class) obj).getName();
        } else if (obj instanceof Member) {
            Member member = (Member) obj;
            if (securityManager != null && !Modifier.isPublic(member.getModifiers())) {
                return null;
            }
            name = member.getDeclaringClass().getName();
        } else {
            name = null;
        }
        if (name != null) {
            if (rhinoClassShutter.visibleToScripts(name)) {
                return super.wrapAsJavaObject(context, scriptable, obj, cls);
            }
            return null;
        }
        Class<?> superclass = obj.getClass();
        if (rhinoClassShutter.visibleToScripts(superclass.getName())) {
            return super.wrapAsJavaObject(context, scriptable, obj, cls);
        }
        if (cls == null || !cls.isInterface()) {
            do {
                superclass = superclass.getSuperclass();
            } while (!rhinoClassShutter.visibleToScripts(superclass.getName()));
            cls = superclass;
        }
        return new RhinoJavaObject(scriptable, obj, cls);
    }
}
