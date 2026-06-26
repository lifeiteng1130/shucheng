package com.sun.script.javascript;

import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.ClassShutter;

/* JADX INFO: loaded from: classes.dex */
public final class RhinoClassShutter implements ClassShutter {
    private static Map<String, Boolean> protectedClasses;
    private static RhinoClassShutter theInstance;

    private RhinoClassShutter() {
    }

    public static synchronized ClassShutter getInstance() {
        if (theInstance == null) {
            theInstance = new RhinoClassShutter();
            HashMap map = new HashMap();
            protectedClasses = map;
            map.put("java.security.AccessController", Boolean.TRUE);
        }
        return theInstance;
    }

    @Override // org.mozilla.javascript.ClassShutter
    public boolean visibleToScripts(String str) {
        int iLastIndexOf;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && (iLastIndexOf = str.lastIndexOf(".")) != -1) {
            try {
                securityManager.checkPackageAccess(str.substring(0, iLastIndexOf));
            } catch (SecurityException unused) {
                return false;
            }
        }
        return protectedClasses.get(str) == null;
    }
}
