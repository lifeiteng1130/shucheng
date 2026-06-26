package org.mozilla.javascript;

import c.a.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeNumber extends IdScriptableObject {
    private static final int ConstructorId_isFinite = -1;
    private static final int ConstructorId_isInteger = -3;
    private static final int ConstructorId_isNaN = -2;
    private static final int ConstructorId_isSafeInteger = -4;
    private static final int ConstructorId_parseFloat = -5;
    private static final int ConstructorId_parseInt = -6;
    private static final int Id_constructor = 1;
    private static final int Id_toExponential = 7;
    private static final int Id_toFixed = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toPrecision = 8;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 5;
    private static final int MAX_PRECISION = 100;
    private static final int MAX_PROTOTYPE_ID = 8;
    public static final double MAX_SAFE_INTEGER = 9.007199254740991E15d;
    private static final double MIN_SAFE_INTEGER = -9.007199254740991E15d;
    private static final Object NUMBER_TAG = "Number";
    private static final long serialVersionUID = 3504516769741512101L;
    private double doubleValue;

    public NativeNumber(double d2) {
        this.doubleValue = d2;
    }

    private static Object execConstructorCall(int i2, Object[] objArr) {
        switch (i2) {
            case -6:
                return NativeGlobal.js_parseInt(objArr);
            case -5:
                return NativeGlobal.js_parseFloat(objArr);
            case -4:
                return (objArr.length == 0 || Undefined.instance == objArr[0]) ? Boolean.FALSE : objArr[0] instanceof Number ? Boolean.valueOf(isSafeInteger((Number) objArr[0])) : Boolean.FALSE;
            case -3:
                return (objArr.length == 0 || Undefined.instance == objArr[0]) ? Boolean.FALSE : objArr[0] instanceof Number ? Boolean.valueOf(isInteger((Number) objArr[0])) : Boolean.FALSE;
            case -2:
                return (objArr.length == 0 || Undefined.instance == objArr[0]) ? Boolean.FALSE : objArr[0] instanceof Number ? isNaN((Number) objArr[0]) : Boolean.FALSE;
            case -1:
                return (objArr.length == 0 || Undefined.instance == objArr[0]) ? Boolean.FALSE : objArr[0] instanceof Number ? isFinite(objArr[0]) : Boolean.FALSE;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeNumber(0.0d).exportAsJSClass(8, scriptable, z);
    }

    private static boolean isDoubleInteger(Double d2) {
        return (d2.isInfinite() || d2.isNaN() || Math.floor(d2.doubleValue()) != d2.doubleValue()) ? false : true;
    }

    private static boolean isDoubleSafeInteger(Double d2) {
        return isDoubleInteger(d2) && d2.doubleValue() <= 9.007199254740991E15d && d2.doubleValue() >= MIN_SAFE_INTEGER;
    }

    public static Object isFinite(Object obj) {
        Double dValueOf = Double.valueOf(ScriptRuntime.toNumber(obj));
        return ScriptRuntime.wrapBoolean((dValueOf.isInfinite() || dValueOf.isNaN()) ? false : true);
    }

    private static boolean isInteger(Number number) {
        return number instanceof Double ? isDoubleInteger((Double) number) : isDoubleInteger(number.doubleValue());
    }

    private static Boolean isNaN(Number number) {
        return number instanceof Double ? Boolean.valueOf(((Double) number).isNaN()) : Boolean.valueOf(Double.isNaN(number.doubleValue()));
    }

    private static boolean isSafeInteger(Number number) {
        return number instanceof Double ? isDoubleSafeInteger((Double) number) : isDoubleSafeInteger(number.doubleValue());
    }

    private static String num_to(double d2, Object[] objArr, int i2, int i3, int i4, int i5) {
        int int32 = 0;
        if (objArr.length != 0) {
            double integer = ScriptRuntime.toInteger(objArr[0]);
            if (integer < i4 || integer > 100.0d) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessage1("msg.bad.precision", ScriptRuntime.toString(objArr[0])));
            }
            int32 = ScriptRuntime.toInt32(integer);
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, i2, int32 + i5, d2);
        return sb.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NUMBER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            double number = objArr.length >= 1 ? ScriptRuntime.toNumber(objArr[0]) : 0.0d;
            return scriptable2 == null ? new NativeNumber(number) : ScriptRuntime.wrapNumber(number);
        }
        if (iMethodId < 1) {
            return execConstructorCall(iMethodId, objArr);
        }
        if (!(scriptable2 instanceof NativeNumber)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        double d2 = ((NativeNumber) scriptable2).doubleValue;
        int int32 = 10;
        switch (iMethodId) {
            case 2:
            case 3:
                if (objArr.length != 0 && objArr[0] != Undefined.instance) {
                    int32 = ScriptRuntime.toInt32(objArr[0]);
                }
                return ScriptRuntime.numberToString(d2, int32);
            case 4:
                StringBuilder sbR = a.r("(new Number(");
                sbR.append(ScriptRuntime.toString(d2));
                sbR.append("))");
                return sbR.toString();
            case 5:
                return ScriptRuntime.wrapNumber(d2);
            case 6:
                return num_to(d2, objArr, 2, 2, context.version < 200 ? -20 : 0, 0);
            case 7:
                return Double.isNaN(d2) ? "NaN" : Double.isInfinite(d2) ? d2 >= 0.0d ? "Infinity" : "-Infinity" : num_to(d2, objArr, 1, 3, 0, 1);
            case 8:
                return (objArr.length == 0 || objArr[0] == Undefined.instance) ? ScriptRuntime.numberToString(d2, 10) : Double.isNaN(d2) ? "NaN" : Double.isInfinite(d2) ? d2 >= 0.0d ? "Infinity" : "-Infinity" : num_to(d2, objArr, 0, 4, 1, 0);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("NaN", ScriptRuntime.NaNobj, 7);
        idFunctionObject.defineProperty("POSITIVE_INFINITY", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        idFunctionObject.defineProperty("NEGATIVE_INFINITY", ScriptRuntime.wrapNumber(Double.NEGATIVE_INFINITY), 7);
        idFunctionObject.defineProperty("MAX_VALUE", ScriptRuntime.wrapNumber(Double.MAX_VALUE), 7);
        idFunctionObject.defineProperty("MIN_VALUE", ScriptRuntime.wrapNumber(Double.MIN_VALUE), 7);
        idFunctionObject.defineProperty("MAX_SAFE_INTEGER", ScriptRuntime.wrapNumber(9.007199254740991E15d), 7);
        idFunctionObject.defineProperty("MIN_SAFE_INTEGER", ScriptRuntime.wrapNumber(MIN_SAFE_INTEGER), 7);
        Object obj = NUMBER_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "isFinite", 1);
        addIdFunctionProperty(idFunctionObject, obj, -2, "isNaN", 1);
        addIdFunctionProperty(idFunctionObject, obj, -3, "isInteger", 1);
        addIdFunctionProperty(idFunctionObject, obj, -4, "isSafeInteger", 1);
        addIdFunctionProperty(idFunctionObject, obj, -5, "parseFloat", 1);
        addIdFunctionProperty(idFunctionObject, obj, -6, "parseInt", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.length()
            r1 = 3
            r2 = 8
            r3 = 7
            r4 = 116(0x74, float:1.63E-43)
            r5 = 0
            if (r0 == r3) goto L48
            if (r0 == r2) goto L36
            r6 = 11
            if (r0 == r6) goto L23
            r2 = 13
            if (r0 == r2) goto L1f
            r2 = 14
            if (r0 == r2) goto L1c
            goto L5a
        L1c:
            java.lang.String r0 = "toLocaleString"
            goto L5c
        L1f:
            java.lang.String r0 = "toExponential"
            r1 = 7
            goto L5c
        L23:
            char r0 = r8.charAt(r5)
            r1 = 99
            if (r0 != r1) goto L2f
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L5c
        L2f:
            if (r0 != r4) goto L5a
            java.lang.String r0 = "toPrecision"
            r1 = 8
            goto L5c
        L36:
            char r0 = r8.charAt(r1)
            r1 = 111(0x6f, float:1.56E-43)
            if (r0 != r1) goto L42
            r1 = 4
            java.lang.String r0 = "toSource"
            goto L5c
        L42:
            if (r0 != r4) goto L5a
            r1 = 2
            java.lang.String r0 = "toString"
            goto L5c
        L48:
            char r0 = r8.charAt(r5)
            if (r0 != r4) goto L52
            r1 = 6
            java.lang.String r0 = "toFixed"
            goto L5c
        L52:
            r1 = 118(0x76, float:1.65E-43)
            if (r0 != r1) goto L5a
            r1 = 5
            java.lang.String r0 = "valueOf"
            goto L5c
        L5a:
            r0 = 0
            r1 = 0
        L5c:
            if (r0 == 0) goto L67
            if (r0 == r8) goto L67
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L67
            goto L68
        L67:
            r5 = r1
        L68:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeNumber.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Number";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        int i3 = 1;
        switch (i2) {
            case 1:
                str = "constructor";
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 2:
                str = "toString";
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 3:
                str = "toLocaleString";
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 4:
                str2 = "toSource";
                str = str2;
                i3 = 0;
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 5:
                str2 = "valueOf";
                str = str2;
                i3 = 0;
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 6:
                str = "toFixed";
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 7:
                str = "toExponential";
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            case 8:
                str = "toPrecision";
                initPrototypeMethod(NUMBER_TAG, i2, str, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    public String toString() {
        return ScriptRuntime.numberToString(this.doubleValue, 10);
    }

    private static boolean isDoubleInteger(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2) || Math.floor(d2) != d2) ? false : true;
    }

    private static boolean isDoubleSafeInteger(double d2) {
        return isDoubleInteger(d2) && d2 <= 9.007199254740991E15d && d2 >= MIN_SAFE_INTEGER;
    }
}
