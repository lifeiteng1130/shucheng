package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public class NativeCallSite extends IdScriptableObject {
    private static final String CALLSITE_TAG = "CallSite";
    private static final int Id_constructor = 1;
    private static final int Id_getColumnNumber = 9;
    private static final int Id_getEvalOrigin = 10;
    private static final int Id_getFileName = 7;
    private static final int Id_getFunction = 4;
    private static final int Id_getFunctionName = 5;
    private static final int Id_getLineNumber = 8;
    private static final int Id_getMethodName = 6;
    private static final int Id_getThis = 2;
    private static final int Id_getTypeName = 3;
    private static final int Id_isConstructor = 14;
    private static final int Id_isEval = 12;
    private static final int Id_isNative = 13;
    private static final int Id_isToplevel = 11;
    private static final int Id_toString = 15;
    private static final int MAX_PROTOTYPE_ID = 15;
    private static final long serialVersionUID = 2688372752566593594L;
    private ScriptStackElement element;

    private NativeCallSite() {
    }

    private static Object getFileName(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        if (scriptStackElement == null) {
            return null;
        }
        return scriptStackElement.fileName;
    }

    private static Object getFunctionName(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        if (scriptStackElement == null) {
            return null;
        }
        return scriptStackElement.functionName;
    }

    private static Object getLineNumber(Scriptable scriptable) {
        int i2;
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        ScriptStackElement scriptStackElement = ((NativeCallSite) scriptable).element;
        return (scriptStackElement == null || (i2 = scriptStackElement.lineNumber) < 0) ? Undefined.instance : Integer.valueOf(i2);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeCallSite().exportAsJSClass(15, scriptable, z);
    }

    private static Object js_toString(Scriptable scriptable) {
        while (scriptable != null && !(scriptable instanceof NativeCallSite)) {
            scriptable = scriptable.getPrototype();
        }
        if (scriptable == null) {
            return Scriptable.NOT_FOUND;
        }
        StringBuilder sb = new StringBuilder();
        ((NativeCallSite) scriptable).element.renderJavaStyle(sb);
        return sb.toString();
    }

    public static NativeCallSite make(Scriptable scriptable, Scriptable scriptable2) {
        NativeCallSite nativeCallSite = new NativeCallSite();
        Scriptable scriptable3 = (Scriptable) scriptable2.get("prototype", scriptable2);
        nativeCallSite.setParentScope(scriptable);
        nativeCallSite.setPrototype(scriptable3);
        return nativeCallSite;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CALLSITE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return make(scriptable, idFunctionObject);
            case 2:
            case 3:
            case 4:
            case 9:
                return Undefined.instance;
            case 5:
                return getFunctionName(scriptable2);
            case 6:
                return null;
            case 7:
                return getFileName(scriptable2);
            case 8:
                return getLineNumber(scriptable2);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return Boolean.FALSE;
            case 15:
                return js_toString(scriptable2);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.length()
            r1 = 116(0x74, float:1.63E-43)
            r2 = 4
            r3 = 105(0x69, float:1.47E-43)
            r4 = 3
            r5 = 0
            switch(r0) {
                case 6: goto L8a;
                case 7: goto L86;
                case 8: goto L74;
                case 9: goto Le;
                case 10: goto L6f;
                case 11: goto L4f;
                case 12: goto Le;
                case 13: goto L27;
                case 14: goto Le;
                case 15: goto L10;
                default: goto Le;
            }
        Le:
            goto L8f
        L10:
            char r0 = r7.charAt(r4)
            r1 = 67
            if (r0 != r1) goto L1e
            r2 = 9
            java.lang.String r0 = "getColumnNumber"
            goto L91
        L1e:
            r1 = 70
            if (r0 != r1) goto L8f
            r2 = 5
            java.lang.String r0 = "getFunctionName"
            goto L91
        L27:
            char r0 = r7.charAt(r4)
            r1 = 69
            if (r0 == r1) goto L4a
            r1 = 111(0x6f, float:1.56E-43)
            if (r0 == r1) goto L45
            r1 = 76
            if (r0 == r1) goto L40
            r1 = 77
            if (r0 == r1) goto L3c
            goto L8f
        L3c:
            r2 = 6
            java.lang.String r0 = "getMethodName"
            goto L91
        L40:
            r2 = 8
            java.lang.String r0 = "getLineNumber"
            goto L91
        L45:
            r2 = 14
            java.lang.String r0 = "isConstructor"
            goto L91
        L4a:
            r2 = 10
            java.lang.String r0 = "getEvalOrigin"
            goto L91
        L4f:
            char r0 = r7.charAt(r2)
            if (r0 == r3) goto L6b
            r3 = 121(0x79, float:1.7E-43)
            if (r0 == r3) goto L67
            if (r0 == r1) goto L63
            r1 = 117(0x75, float:1.64E-43)
            if (r0 == r1) goto L60
            goto L8f
        L60:
            java.lang.String r0 = "getFunction"
            goto L91
        L63:
            r2 = 1
            java.lang.String r0 = "constructor"
            goto L91
        L67:
            java.lang.String r0 = "getTypeName"
            r2 = 3
            goto L91
        L6b:
            r2 = 7
            java.lang.String r0 = "getFileName"
            goto L91
        L6f:
            r2 = 11
            java.lang.String r0 = "isToplevel"
            goto L91
        L74:
            char r0 = r7.charAt(r5)
            if (r0 != r3) goto L7f
            r2 = 13
            java.lang.String r0 = "isNative"
            goto L91
        L7f:
            if (r0 != r1) goto L8f
            r2 = 15
            java.lang.String r0 = "toString"
            goto L91
        L86:
            r2 = 2
            java.lang.String r0 = "getThis"
            goto L91
        L8a:
            r2 = 12
            java.lang.String r0 = "isEval"
            goto L91
        L8f:
            r0 = 0
            r2 = 0
        L91:
            if (r0 == 0) goto L9c
            if (r0 == r7) goto L9c
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L9c
            goto L9d
        L9c:
            r5 = r2
        L9d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeCallSite.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CALLSITE_TAG;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        switch (i2) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "getThis";
                break;
            case 3:
                str = "getTypeName";
                break;
            case 4:
                str = "getFunction";
                break;
            case 5:
                str = "getFunctionName";
                break;
            case 6:
                str = "getMethodName";
                break;
            case 7:
                str = "getFileName";
                break;
            case 8:
                str = "getLineNumber";
                break;
            case 9:
                str = "getColumnNumber";
                break;
            case 10:
                str = "getEvalOrigin";
                break;
            case 11:
                str = "isToplevel";
                break;
            case 12:
                str = "isEval";
                break;
            case 13:
                str = "isNative";
                break;
            case 14:
                str = "isConstructor";
                break;
            case 15:
                str = "toString";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
        initPrototypeMethod(CALLSITE_TAG, i2, str, 0);
    }

    public void setElement(ScriptStackElement scriptStackElement) {
        this.element = scriptStackElement;
    }

    public String toString() {
        ScriptStackElement scriptStackElement = this.element;
        return scriptStackElement == null ? "" : scriptStackElement.toString();
    }
}
