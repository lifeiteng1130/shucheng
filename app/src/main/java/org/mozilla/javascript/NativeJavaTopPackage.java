package org.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes3.dex */
public class NativeJavaTopPackage extends NativeJavaPackage implements Function, IdFunctionCall {
    private static final int Id_getClass = 1;
    private static final long serialVersionUID = -1455787259477709999L;
    private static final String[][] commonPackages = {new String[]{LogType.JAVA_TYPE, "lang", "reflect"}, new String[]{LogType.JAVA_TYPE, "io"}, new String[]{LogType.JAVA_TYPE, "math"}, new String[]{LogType.JAVA_TYPE, "net"}, new String[]{LogType.JAVA_TYPE, "util", "zip"}, new String[]{LogType.JAVA_TYPE, NotificationCompat.MessagingStyle.Message.KEY_TEXT, "resources"}, new String[]{LogType.JAVA_TYPE, "applet"}, new String[]{"javax", "swing"}};
    private static final Object FTAG = "JavaTopPackage";

    public NativeJavaTopPackage(ClassLoader classLoader) {
        super(true, "", classLoader);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeJavaTopPackage nativeJavaTopPackage = new NativeJavaTopPackage(context.getApplicationClassLoader());
        nativeJavaTopPackage.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJavaTopPackage.setParentScope(scriptable);
        for (int i2 = 0; i2 != commonPackages.length; i2++) {
            NativeJavaPackage nativeJavaPackage = nativeJavaTopPackage;
            int i3 = 0;
            while (true) {
                String[][] strArr = commonPackages;
                if (i3 != strArr[i2].length) {
                    NativeJavaPackage nativeJavaPackageForcePackage = nativeJavaPackage.forcePackage(strArr[i2][i3], scriptable);
                    i3++;
                    nativeJavaPackage = nativeJavaPackageForcePackage;
                }
            }
        }
        IdFunctionObject idFunctionObject = new IdFunctionObject(nativeJavaTopPackage, FTAG, 1, "getClass", 1, scriptable);
        String[] topPackageNames = ScriptRuntime.getTopPackageNames();
        Object[] objArr = new NativeJavaPackage[topPackageNames.length];
        for (int i4 = 0; i4 < topPackageNames.length; i4++) {
            objArr[i4] = (NativeJavaPackage) nativeJavaTopPackage.get(topPackageNames[i4], nativeJavaTopPackage);
        }
        ScriptableObject scriptableObject = (ScriptableObject) scriptable;
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
        scriptableObject.defineProperty("Packages", nativeJavaTopPackage, 2);
        for (int i5 = 0; i5 < topPackageNames.length; i5++) {
            scriptableObject.defineProperty(topPackageNames[i5], objArr[i5], 2);
        }
    }

    private Scriptable js_getClass(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length > 0) {
            int i2 = 0;
            if (objArr[0] instanceof Wrapper) {
                String name = ((Wrapper) objArr[0]).unwrap().getClass().getName();
                Scriptable scriptable2 = this;
                while (true) {
                    int iIndexOf = name.indexOf(46, i2);
                    Object obj = scriptable2.get(iIndexOf == -1 ? name.substring(i2) : name.substring(i2, iIndexOf), scriptable2);
                    if (!(obj instanceof Scriptable)) {
                        break;
                    }
                    scriptable2 = (Scriptable) obj;
                    if (iIndexOf == -1) {
                        return scriptable2;
                    }
                    i2 = iIndexOf + 1;
                }
            }
        }
        throw Context.reportRuntimeError0("msg.not.java.obj");
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mozilla.javascript.Scriptable construct(org.mozilla.javascript.Context r3, org.mozilla.javascript.Scriptable r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            int r3 = r5.length
            r0 = 0
            if (r3 == 0) goto L18
            r3 = 0
            r3 = r5[r3]
            boolean r5 = r3 instanceof org.mozilla.javascript.Wrapper
            if (r5 == 0) goto L11
            org.mozilla.javascript.Wrapper r3 = (org.mozilla.javascript.Wrapper) r3
            java.lang.Object r3 = r3.unwrap()
        L11:
            boolean r5 = r3 instanceof java.lang.ClassLoader
            if (r5 == 0) goto L18
            java.lang.ClassLoader r3 = (java.lang.ClassLoader) r3
            goto L19
        L18:
            r3 = r0
        L19:
            if (r3 != 0) goto L21
            java.lang.String r3 = "msg.not.classloader"
            org.mozilla.javascript.Context.reportRuntimeError0(r3)
            return r0
        L21:
            org.mozilla.javascript.NativeJavaPackage r5 = new org.mozilla.javascript.NativeJavaPackage
            r0 = 1
            java.lang.String r1 = ""
            r5.<init>(r0, r1, r3)
            org.mozilla.javascript.ScriptRuntime.setObjectProtoAndParent(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaTopPackage.construct(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_getClass(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
