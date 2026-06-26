package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeBoolean extends IdScriptableObject {
    private static final Object BOOLEAN_TAG = "Boolean";
    private static final int Id_constructor = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 4;
    private static final int MAX_PROTOTYPE_ID = 4;
    private static final long serialVersionUID = -3716996899943880933L;
    private boolean booleanValue;

    public NativeBoolean(boolean z) {
        this.booleanValue = z;
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeBoolean(false).exportAsJSClass(4, scriptable, z);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(BOOLEAN_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            boolean z = false;
            if (objArr.length != 0 && (!(objArr[0] instanceof ScriptableObject) || !((ScriptableObject) objArr[0]).avoidObjectDetection())) {
                z = ScriptRuntime.toBoolean(objArr[0]);
            }
            return scriptable2 == null ? new NativeBoolean(z) : ScriptRuntime.wrapBoolean(z);
        }
        if (!(scriptable2 instanceof NativeBoolean)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        boolean z2 = ((NativeBoolean) scriptable2).booleanValue;
        if (iMethodId == 2) {
            return z2 ? "true" : "false";
        }
        if (iMethodId == 3) {
            return z2 ? "(new Boolean(true))" : "(new Boolean(false))";
        }
        if (iMethodId == 4) {
            return ScriptRuntime.wrapBoolean(z2);
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            r1 = 3
            r2 = 0
            r3 = 7
            if (r0 != r3) goto Ld
            r1 = 4
            java.lang.String r0 = "valueOf"
            goto L2e
        Ld:
            r3 = 8
            if (r0 != r3) goto L24
            char r0 = r5.charAt(r1)
            r3 = 111(0x6f, float:1.56E-43)
            if (r0 != r3) goto L1c
            java.lang.String r0 = "toSource"
            goto L2e
        L1c:
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L2c
            r1 = 2
            java.lang.String r0 = "toString"
            goto L2e
        L24:
            r1 = 11
            if (r0 != r1) goto L2c
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L2e
        L2c:
            r0 = 0
            r1 = 0
        L2e:
            if (r0 == 0) goto L39
            if (r0 == r5) goto L39
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L39
            goto L3a
        L39:
            r2 = r1
        L3a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeBoolean.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Boolean";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return cls == ScriptRuntime.BooleanClass ? ScriptRuntime.wrapBoolean(this.booleanValue) : super.getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3 = 0;
        if (i2 == 1) {
            str = "constructor";
            i3 = 1;
        } else if (i2 == 2) {
            str = "toString";
        } else if (i2 == 3) {
            str = "toSource";
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException(String.valueOf(i2));
            }
            str = "valueOf";
        }
        initPrototypeMethod(BOOLEAN_TAG, i2, str, i3);
    }
}
