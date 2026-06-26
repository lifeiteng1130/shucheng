package org.mozilla.javascript;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeMath extends IdScriptableObject {
    private static final int Id_E = 37;
    private static final int Id_LN10 = 39;
    private static final int Id_LN2 = 40;
    private static final int Id_LOG10E = 42;
    private static final int Id_LOG2E = 41;
    private static final int Id_PI = 38;
    private static final int Id_SQRT1_2 = 43;
    private static final int Id_SQRT2 = 44;
    private static final int Id_abs = 2;
    private static final int Id_acos = 3;
    private static final int Id_acosh = 30;
    private static final int Id_asin = 4;
    private static final int Id_asinh = 31;
    private static final int Id_atan = 5;
    private static final int Id_atan2 = 6;
    private static final int Id_atanh = 32;
    private static final int Id_cbrt = 20;
    private static final int Id_ceil = 7;
    private static final int Id_clz32 = 36;
    private static final int Id_cos = 8;
    private static final int Id_cosh = 21;
    private static final int Id_exp = 9;
    private static final int Id_expm1 = 22;
    private static final int Id_floor = 10;
    private static final int Id_fround = 35;
    private static final int Id_hypot = 23;
    private static final int Id_imul = 28;
    private static final int Id_log = 11;
    private static final int Id_log10 = 25;
    private static final int Id_log1p = 24;
    private static final int Id_log2 = 34;
    private static final int Id_max = 12;
    private static final int Id_min = 13;
    private static final int Id_pow = 14;
    private static final int Id_random = 15;
    private static final int Id_round = 16;
    private static final int Id_sign = 33;
    private static final int Id_sin = 17;
    private static final int Id_sinh = 26;
    private static final int Id_sqrt = 18;
    private static final int Id_tan = 19;
    private static final int Id_tanh = 27;
    private static final int Id_toSource = 1;
    private static final int Id_trunc = 29;
    private static final int LAST_METHOD_ID = 36;
    private static final double LOG2E = 1.4426950408889634d;
    private static final int MAX_ID = 44;
    private static final long serialVersionUID = -8838847185801131569L;
    private static final Object MATH_TAG = "Math";
    private static final Double Double32 = Double.valueOf(32.0d);

    private NativeMath() {
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.activatePrototypeMap(44);
        nativeMath.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        if (z) {
            nativeMath.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "Math", nativeMath, 2);
    }

    private static double js_hypot(Object[] objArr) {
        double d2 = 0.0d;
        if (objArr == null) {
            return 0.0d;
        }
        boolean z = false;
        boolean z2 = false;
        for (Object obj : objArr) {
            double number = ScriptRuntime.toNumber(obj);
            if (Double.isNaN(number)) {
                z2 = true;
            } else if (Double.isInfinite(number)) {
                z = true;
            } else {
                d2 = (number * number) + d2;
            }
        }
        if (z) {
            return Double.POSITIVE_INFINITY;
        }
        if (z2) {
            return Double.NaN;
        }
        return Math.sqrt(d2);
    }

    private static int js_imul(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return ScriptRuntime.toInt32(objArr, 1) * ScriptRuntime.toInt32(objArr, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (r22 < 1.0d) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007f, code lost:
    
        if (r22 < 1.0d) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0089, code lost:
    
        if (r24 > 0.0d) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a3, code lost:
    
        if (r24 > 0.0d) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double js_pow(double r22, double r24) {
        /*
            r0 = r24
            boolean r2 = java.lang.Double.isNaN(r24)
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r7 = 0
            if (r2 == 0) goto L12
            r17 = r0
            goto La8
        L12:
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 != 0) goto L1a
            r17 = r3
            goto La8
        L1a:
            r9 = -9223372036854775808
            r11 = 0
            r13 = 1
            r15 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r17 = (r22 > r7 ? 1 : (r22 == r7 ? 0 : -1))
            if (r17 != 0) goto L47
            double r3 = r3 / r22
            int r17 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r17 <= 0) goto L30
            if (r2 <= 0) goto L69
            r5 = r7
            goto L69
        L30:
            long r3 = (long) r0
            double r7 = (double) r3
            int r19 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r19 != 0) goto L42
            long r0 = r3 & r13
            int r3 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r3 == 0) goto L42
            if (r2 <= 0) goto L3f
            goto L40
        L3f:
            r9 = r15
        L40:
            r5 = r9
            goto L69
        L42:
            if (r2 <= 0) goto L69
            r5 = 0
            goto L69
        L47:
            double r7 = java.lang.Math.pow(r22, r24)
            boolean r19 = java.lang.Double.isNaN(r7)
            if (r19 == 0) goto La6
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r21 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r21 != 0) goto L6c
            int r0 = (r22 > r19 ? 1 : (r22 == r19 ? 0 : -1))
            if (r0 < 0) goto L69
            int r0 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r0 >= 0) goto L60
            goto L69
        L60:
            int r0 = (r19 > r22 ? 1 : (r19 == r22 ? 0 : -1))
            if (r0 >= 0) goto La6
            int r0 = (r22 > r3 ? 1 : (r22 == r3 ? 0 : -1))
            if (r0 >= 0) goto La6
            goto L82
        L69:
            r17 = r5
            goto La8
        L6c:
            int r21 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r21 != 0) goto L85
            int r0 = (r22 > r19 ? 1 : (r22 == r19 ? 0 : -1))
            if (r0 < 0) goto L82
            int r0 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r0 >= 0) goto L79
            goto L82
        L79:
            int r0 = (r19 > r22 ? 1 : (r19 == r22 ? 0 : -1))
            if (r0 >= 0) goto La6
            int r0 = (r22 > r3 ? 1 : (r22 == r3 ? 0 : -1))
            if (r0 >= 0) goto La6
            goto L69
        L82:
            r17 = 0
            goto La8
        L85:
            int r3 = (r22 > r5 ? 1 : (r22 == r5 ? 0 : -1))
            if (r3 != 0) goto L8c
            if (r2 <= 0) goto L82
            goto L69
        L8c:
            int r3 = (r22 > r15 ? 1 : (r22 == r15 ? 0 : -1))
            if (r3 != 0) goto La6
            long r3 = (long) r0
            double r7 = (double) r3
            int r19 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r19 != 0) goto La3
            long r0 = r3 & r13
            int r3 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r3 == 0) goto La3
            if (r2 <= 0) goto L9f
            goto La0
        L9f:
            r15 = r9
        La0:
            r17 = r15
            goto La8
        La3:
            if (r2 <= 0) goto L82
            goto L69
        La6:
            r17 = r7
        La8:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.js_pow(double, double):double");
    }

    private static double js_trunc(double d2) {
        return d2 < 0.0d ? Math.ceil(d2) : Math.floor(d2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number;
        double dAtan;
        if (!idFunctionObject.hasTag(MATH_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        int i2 = 0;
        switch (iMethodId) {
            case 1:
                return "Math";
            case 2:
                number = ScriptRuntime.toNumber(objArr, 0);
                if (number != 0.0d) {
                    if (number < 0.0d) {
                        number = -number;
                    }
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = 0.0d;
                return ScriptRuntime.wrapNumber(dAtan);
            case 3:
            case 4:
                double number2 = ScriptRuntime.toNumber(objArr, 0);
                if (!Double.isNaN(number2) && -1.0d <= number2 && number2 <= 1.0d) {
                    number = iMethodId == 3 ? Math.acos(number2) : Math.asin(number2);
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = Double.NaN;
                return ScriptRuntime.wrapNumber(dAtan);
            case 5:
                dAtan = Math.atan(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 6:
                dAtan = Math.atan2(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1));
                return ScriptRuntime.wrapNumber(dAtan);
            case 7:
                dAtan = Math.ceil(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 8:
                double number3 = ScriptRuntime.toNumber(objArr, 0);
                if (!Double.isInfinite(number3)) {
                    number = Math.cos(number3);
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = Double.NaN;
                return ScriptRuntime.wrapNumber(dAtan);
            case 9:
                number = ScriptRuntime.toNumber(objArr, 0);
                if (number != Double.POSITIVE_INFINITY) {
                    if (number != Double.NEGATIVE_INFINITY) {
                        number = Math.exp(number);
                    }
                    dAtan = 0.0d;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = number;
                return ScriptRuntime.wrapNumber(dAtan);
            case 10:
                dAtan = Math.floor(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 11:
                double number4 = ScriptRuntime.toNumber(objArr, 0);
                if (number4 >= 0.0d) {
                    number = Math.log(number4);
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = Double.NaN;
                return ScriptRuntime.wrapNumber(dAtan);
            case 12:
            case 13:
                double dMax = iMethodId != 12 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
                while (true) {
                    if (i2 != objArr.length) {
                        double number5 = ScriptRuntime.toNumber(objArr[i2]);
                        if (Double.isNaN(number5)) {
                            dAtan = number5;
                        } else {
                            dMax = iMethodId == 12 ? Math.max(dMax, number5) : Math.min(dMax, number5);
                            i2++;
                        }
                    } else {
                        dAtan = dMax;
                    }
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 14:
                dAtan = js_pow(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1));
                return ScriptRuntime.wrapNumber(dAtan);
            case 15:
                dAtan = Math.random();
                return ScriptRuntime.wrapNumber(dAtan);
            case 16:
                dAtan = ScriptRuntime.toNumber(objArr, 0);
                if (!Double.isNaN(dAtan) && !Double.isInfinite(dAtan)) {
                    long jRound = Math.round(dAtan);
                    if (jRound != 0) {
                        number = jRound;
                    } else if (dAtan < 0.0d) {
                        number = ScriptRuntime.negativeZero;
                    } else if (dAtan != 0.0d) {
                        dAtan = 0.0d;
                    }
                    dAtan = number;
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 17:
                double number6 = ScriptRuntime.toNumber(objArr, 0);
                if (!Double.isInfinite(number6)) {
                    number = Math.sin(number6);
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = Double.NaN;
                return ScriptRuntime.wrapNumber(dAtan);
            case 18:
                dAtan = Math.sqrt(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 19:
                dAtan = Math.tan(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 20:
                dAtan = Math.cbrt(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 21:
                dAtan = Math.cosh(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 22:
                dAtan = Math.expm1(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 23:
                dAtan = js_hypot(objArr);
                return ScriptRuntime.wrapNumber(dAtan);
            case 24:
                dAtan = Math.log1p(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 25:
                dAtan = Math.log10(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 26:
                dAtan = Math.sinh(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 27:
                dAtan = Math.tanh(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 28:
                dAtan = js_imul(objArr);
                return ScriptRuntime.wrapNumber(dAtan);
            case 29:
                dAtan = js_trunc(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 30:
                double number7 = ScriptRuntime.toNumber(objArr, 0);
                return !Double.isNaN(number7) ? Double.valueOf(Math.log(Math.sqrt((number7 * number7) - 1.0d) + number7)) : ScriptRuntime.NaNobj;
            case 31:
                double number8 = ScriptRuntime.toNumber(objArr, 0);
                return Double.isInfinite(number8) ? Double.valueOf(number8) : !Double.isNaN(number8) ? number8 == 0.0d ? 1.0d / number8 > 0.0d ? ScriptRuntime.zeroObj : ScriptRuntime.negativeZeroObj : Double.valueOf(Math.log(Math.sqrt((number8 * number8) + 1.0d) + number8)) : ScriptRuntime.NaNobj;
            case 32:
                double number9 = ScriptRuntime.toNumber(objArr, 0);
                return (Double.isNaN(number9) || -1.0d > number9 || number9 > 1.0d) ? ScriptRuntime.NaNobj : number9 == 0.0d ? 1.0d / number9 > 0.0d ? ScriptRuntime.zeroObj : ScriptRuntime.negativeZeroObj : Double.valueOf(Math.log((number9 + 1.0d) / (number9 - 1.0d)) * 0.5d);
            case 33:
                double number10 = ScriptRuntime.toNumber(objArr, 0);
                return !Double.isNaN(number10) ? number10 == 0.0d ? 1.0d / number10 > 0.0d ? ScriptRuntime.zeroObj : ScriptRuntime.negativeZeroObj : Double.valueOf(Math.signum(number10)) : ScriptRuntime.NaNobj;
            case 34:
                double number11 = ScriptRuntime.toNumber(objArr, 0);
                if (number11 >= 0.0d) {
                    number = Math.log(number11) * LOG2E;
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = Double.NaN;
                return ScriptRuntime.wrapNumber(dAtan);
            case 35:
                dAtan = (float) ScriptRuntime.toNumber(objArr, 0);
                return ScriptRuntime.wrapNumber(dAtan);
            case 36:
                double number12 = ScriptRuntime.toNumber(objArr, 0);
                if (number12 == 0.0d || Double.isNaN(number12) || Double.isInfinite(number12)) {
                    return Double32;
                }
                return ScriptRuntime.toUint32(number12) == 0 ? Double32 : Double.valueOf(31.0d - Math.floor(Math.log(r0 >>> 0) * LOG2E));
            default:
                throw new IllegalStateException(String.valueOf(iMethodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0297 A[ADDED_TO_REGION] */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Math";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        double d2;
        String str;
        String str2;
        String str3;
        if (i2 > 36) {
            switch (i2) {
                case 37:
                    d2 = 2.718281828459045d;
                    str = ExifInterface.LONGITUDE_EAST;
                    break;
                case 38:
                    d2 = 3.141592653589793d;
                    str = "PI";
                    break;
                case 39:
                    d2 = 2.302585092994046d;
                    str = "LN10";
                    break;
                case 40:
                    d2 = 0.6931471805599453d;
                    str = "LN2";
                    break;
                case 41:
                    d2 = LOG2E;
                    str = "LOG2E";
                    break;
                case 42:
                    d2 = 0.4342944819032518d;
                    str = "LOG10E";
                    break;
                case 43:
                    d2 = 0.7071067811865476d;
                    str = "SQRT1_2";
                    break;
                case 44:
                    d2 = 1.4142135623730951d;
                    str = "SQRT2";
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(i2));
            }
            initPrototypeValue(i2, str, ScriptRuntime.wrapNumber(d2), 7);
            return;
        }
        int i3 = 1;
        switch (i2) {
            case 1:
                str2 = "toSource";
                str3 = str2;
                i3 = 0;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 2:
                str3 = "abs";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 3:
                str3 = "acos";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 4:
                str3 = "asin";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 5:
                str3 = "atan";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 6:
                str3 = "atan2";
                i3 = 2;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 7:
                str3 = "ceil";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 8:
                str3 = "cos";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 9:
                str3 = "exp";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 10:
                str3 = "floor";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 11:
                str3 = "log";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 12:
                str3 = "max";
                i3 = 2;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 13:
                str3 = "min";
                i3 = 2;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 14:
                str3 = "pow";
                i3 = 2;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 15:
                str2 = "random";
                str3 = str2;
                i3 = 0;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 16:
                str3 = "round";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 17:
                str3 = "sin";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 18:
                str3 = "sqrt";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 19:
                str3 = "tan";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 20:
                str3 = "cbrt";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 21:
                str3 = "cosh";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 22:
                str3 = "expm1";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 23:
                str3 = "hypot";
                i3 = 2;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 24:
                str3 = "log1p";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 25:
                str3 = "log10";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 26:
                str3 = "sinh";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 27:
                str3 = "tanh";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 28:
                str3 = "imul";
                i3 = 2;
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 29:
                str3 = "trunc";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 30:
                str3 = "acosh";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 31:
                str3 = "asinh";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 32:
                str3 = "atanh";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 33:
                str3 = "sign";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 34:
                str3 = "log2";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 35:
                str3 = "fround";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            case 36:
                str3 = "clz32";
                initPrototypeMethod(MATH_TAG, i2, str3, i3);
                return;
            default:
                throw new IllegalStateException(String.valueOf(i2));
        }
    }
}
