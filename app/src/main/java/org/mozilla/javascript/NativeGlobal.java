package org.mozilla.javascript;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import okio.Utf8;
import org.mozilla.javascript.xml.XMLLib;

/* JADX INFO: loaded from: classes3.dex */
public class NativeGlobal implements Serializable, IdFunctionCall {
    private static final Object FTAG = "Global";
    private static final int INVALID_UTF8 = Integer.MAX_VALUE;
    private static final int Id_decodeURI = 1;
    private static final int Id_decodeURIComponent = 2;
    private static final int Id_encodeURI = 3;
    private static final int Id_encodeURIComponent = 4;
    private static final int Id_escape = 5;
    private static final int Id_eval = 6;
    private static final int Id_isFinite = 7;
    private static final int Id_isNaN = 8;
    private static final int Id_isXMLName = 9;
    private static final int Id_new_CommonError = 14;
    private static final int Id_parseFloat = 10;
    private static final int Id_parseInt = 11;
    private static final int Id_unescape = 12;
    private static final int Id_uneval = 13;
    private static final int LAST_SCOPE_FUNCTION_ID = 13;
    private static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    public static final long serialVersionUID = 6080442165748707530L;

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable) {
        return ScriptRuntime.constructError(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[PHI: r6 r8
  0x0040: PHI (r6v5 int) = (r6v1 int), (r6v2 int) binds: [B:16:0x003e, B:62:0x00d8] A[DONT_GENERATE, DONT_INLINE]
  0x0040: PHI (r8v22 int) = (r8v2 int), (r8v10 int) binds: [B:16:0x003e, B:62:0x00d8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String decode(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.decode(java.lang.String, boolean):java.lang.String");
    }

    private static String encode(String str, boolean z) {
        int length = str.length();
        StringBuilder sb = null;
        byte[] bArr = null;
        int i2 = 0;
        while (i2 != length) {
            char cCharAt = str.charAt(i2);
            sb = sb;
            if (!encodeUnescaped(cCharAt, z)) {
                if (sb == null) {
                    StringBuilder sb2 = new StringBuilder(length + 3);
                    sb2.append(str);
                    sb2.setLength(i2);
                    bArr = new byte[6];
                    sb = sb2;
                }
                if (56320 <= cCharAt && cCharAt <= 57343) {
                    throw uriError();
                }
                int i3 = cCharAt;
                if (cCharAt >= 55296) {
                    i3 = cCharAt;
                    if (56319 >= cCharAt) {
                        i2++;
                        if (i2 == length) {
                            throw uriError();
                        }
                        char cCharAt2 = str.charAt(i2);
                        if (56320 > cCharAt2 || cCharAt2 > 57343) {
                            throw uriError();
                        }
                        i3 = 65536 + (cCharAt2 - Utf8.LOG_SURROGATE_HEADER) + ((cCharAt - 55296) << 10);
                    }
                }
                int iOneUcs4ToUtf8Char = oneUcs4ToUtf8Char(bArr, i3);
                for (int i4 = 0; i4 < iOneUcs4ToUtf8Char; i4++) {
                    int i5 = bArr[i4] & ExifInterface.MARKER;
                    sb.append('%');
                    sb.append(toHexChar(i5 >>> 4));
                    sb.append(toHexChar(i5 & 15));
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i2++;
            sb = sb;
        }
        return sb == null ? str : sb.toString();
    }

    private static boolean encodeUnescaped(char c2, boolean z) {
        if (('A' > c2 || c2 > 'Z') && (('a' > c2 || c2 > 'z') && (('0' > c2 || c2 > '9') && "-_.!~*'()".indexOf(c2) < 0))) {
            return z && URI_DECODE_RESERVED.indexOf(c2) >= 0;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0051 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void init(org.mozilla.javascript.Context r16, org.mozilla.javascript.Scriptable r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.init(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, boolean):void");
    }

    public static boolean isEvalFunction(Object obj) {
        if (!(obj instanceof IdFunctionObject)) {
            return false;
        }
        IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
        return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r11 & (-8)) == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object js_escape(java.lang.Object[] r11) {
        /*
            r0 = 0
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r11, r0)
            int r2 = r11.length
            r3 = 1
            if (r2 <= r3) goto L27
            r11 = r11[r3]
            double r4 = org.mozilla.javascript.ScriptRuntime.toNumber(r11)
            boolean r11 = java.lang.Double.isNaN(r4)
            if (r11 != 0) goto L20
            int r11 = (int) r4
            double r6 = (double) r11
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 != 0) goto L20
            r2 = r11 & (-8)
            if (r2 != 0) goto L20
            goto L28
        L20:
            java.lang.String r11 = "msg.bad.esc.mask"
            org.mozilla.javascript.EvaluatorException r11 = org.mozilla.javascript.Context.reportRuntimeError0(r11)
            throw r11
        L27:
            r11 = 7
        L28:
            r2 = 0
            int r4 = r1.length()
        L2d:
            if (r0 == r4) goto Lbf
            char r5 = r1.charAt(r0)
            r6 = 43
            if (r11 == 0) goto L74
            r7 = 48
            if (r5 < r7) goto L3f
            r7 = 57
            if (r5 <= r7) goto L6d
        L3f:
            r7 = 65
            if (r5 < r7) goto L47
            r7 = 90
            if (r5 <= r7) goto L6d
        L47:
            r7 = 97
            if (r5 < r7) goto L4f
            r7 = 122(0x7a, float:1.71E-43)
            if (r5 <= r7) goto L6d
        L4f:
            r7 = 64
            if (r5 == r7) goto L6d
            r7 = 42
            if (r5 == r7) goto L6d
            r7 = 95
            if (r5 == r7) goto L6d
            r7 = 45
            if (r5 == r7) goto L6d
            r7 = 46
            if (r5 == r7) goto L6d
            r7 = r11 & 4
            if (r7 == 0) goto L74
            r7 = 47
            if (r5 == r7) goto L6d
            if (r5 != r6) goto L74
        L6d:
            if (r2 == 0) goto Lbb
            char r5 = (char) r5
            r2.append(r5)
            goto Lbb
        L74:
            if (r2 != 0) goto L83
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r7 = r4 + 3
            r2.<init>(r7)
            r2.append(r1)
            r2.setLength(r0)
        L83:
            r7 = 256(0x100, float:3.59E-43)
            r8 = 2
            r9 = 37
            r10 = 4
            if (r5 >= r7) goto L99
            r7 = 32
            if (r5 != r7) goto L95
            if (r11 != r8) goto L95
            r2.append(r6)
            goto Lbb
        L95:
            r2.append(r9)
            goto La2
        L99:
            r2.append(r9)
            r6 = 117(0x75, float:1.64E-43)
            r2.append(r6)
            r8 = 4
        La2:
            int r8 = r8 - r3
            int r8 = r8 * 4
        La5:
            if (r8 < 0) goto Lbb
            int r6 = r5 >> r8
            r6 = r6 & 15
            r7 = 10
            if (r6 >= r7) goto Lb2
            int r6 = r6 + 48
            goto Lb4
        Lb2:
            int r6 = r6 + 55
        Lb4:
            char r6 = (char) r6
            r2.append(r6)
            int r8 = r8 + (-4)
            goto La5
        Lbb:
            int r0 = r0 + 1
            goto L2d
        Lbf:
            if (r2 != 0) goto Lc2
            goto Lc6
        Lc2:
            java.lang.String r1 = r2.toString()
        Lc6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_escape(java.lang.Object[]):java.lang.Object");
    }

    private static Object js_eval(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        return ScriptRuntime.evalSpecial(context, topLevelScope, topLevelScope, objArr, "eval code", 1);
    }

    public static Object js_parseFloat(Object[] objArr) {
        int i2;
        if (objArr.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        boolean z = false;
        String string = ScriptRuntime.toString(objArr[0]);
        int length = string.length();
        for (int i3 = 0; i3 != length; i3++) {
            char cCharAt = string.charAt(i3);
            if (!ScriptRuntime.isStrWhiteSpaceChar(cCharAt)) {
                if (cCharAt == '+' || cCharAt == '-') {
                    int i4 = i3 + 1;
                    if (i4 == length) {
                        return ScriptRuntime.NaNobj;
                    }
                    i2 = i4;
                    cCharAt = string.charAt(i4);
                } else {
                    i2 = i3;
                }
                if (cCharAt == 'I') {
                    if (i2 + 8 > length || !string.regionMatches(i2, "Infinity", 0, 8)) {
                        return ScriptRuntime.NaNobj;
                    }
                    return ScriptRuntime.wrapNumber(string.charAt(i3) == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                int i5 = -1;
                int i6 = -1;
                while (true) {
                    if (i2 < length) {
                        char cCharAt2 = string.charAt(i2);
                        if (cCharAt2 != '+') {
                            if (cCharAt2 == 'E' || cCharAt2 == 'e') {
                                if (i5 == -1 && i2 != length - 1) {
                                    i5 = i2;
                                    i2++;
                                }
                            } else if (cCharAt2 != '-') {
                                if (cCharAt2 != '.') {
                                    switch (cCharAt2) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            if (i5 != -1) {
                                                z = true;
                                            }
                                            break;
                                    }
                                    i2++;
                                } else if (i6 == -1) {
                                    i6 = i2;
                                    i2++;
                                }
                            }
                        }
                        if (i5 == i2 - 1) {
                            if (i2 == length - 1) {
                                i2--;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                if (i5 == -1 || z) {
                    i5 = i2;
                }
                try {
                    return Double.valueOf(string.substring(i3, i5));
                } catch (NumberFormatException unused) {
                    return ScriptRuntime.NaNobj;
                }
            }
        }
        return ScriptRuntime.NaNobj;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[PHI: r0
  0x002e: PHI (r0v1 boolean) = (r0v0 boolean), (r0v3 boolean) binds: [B:13:0x0025, B:17:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object js_parseInt(java.lang.Object[] r11) {
        /*
            r0 = 0
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r11, r0)
            r2 = 1
            int r11 = org.mozilla.javascript.ScriptRuntime.toInt32(r11, r2)
            int r3 = r1.length()
            if (r3 != 0) goto L13
            java.lang.Double r11 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r11
        L13:
            r4 = 0
        L14:
            char r5 = r1.charAt(r4)
            boolean r6 = org.mozilla.javascript.ScriptRuntime.isStrWhiteSpaceChar(r5)
            if (r6 != 0) goto L1f
            goto L23
        L1f:
            int r4 = r4 + 1
            if (r4 < r3) goto L14
        L23:
            r6 = 43
            if (r5 == r6) goto L2e
            r6 = 45
            if (r5 != r6) goto L2c
            r0 = 1
        L2c:
            if (r0 == 0) goto L30
        L2e:
            int r4 = r4 + 1
        L30:
            r5 = 88
            r6 = 120(0x78, float:1.68E-43)
            r7 = 16
            r8 = -1
            r9 = 48
            if (r11 != 0) goto L3d
            r11 = -1
            goto L5d
        L3d:
            r10 = 2
            if (r11 < r10) goto La0
            r10 = 36
            if (r11 <= r10) goto L45
            goto La0
        L45:
            if (r11 != r7) goto L5d
            int r10 = r3 - r4
            if (r10 <= r2) goto L5d
            char r10 = r1.charAt(r4)
            if (r10 != r9) goto L5d
            int r10 = r4 + 1
            char r10 = r1.charAt(r10)
            if (r10 == r6) goto L5b
            if (r10 != r5) goto L5d
        L5b:
            int r4 = r4 + 2
        L5d:
            if (r11 != r8) goto L93
            r11 = 10
            int r3 = r3 - r4
            if (r3 <= r2) goto L90
            char r2 = r1.charAt(r4)
            if (r2 != r9) goto L90
            int r2 = r4 + 1
            char r3 = r1.charAt(r2)
            if (r3 == r6) goto L8d
            if (r3 != r5) goto L75
            goto L8d
        L75:
            if (r9 > r3) goto L90
            r5 = 57
            if (r3 > r5) goto L90
            org.mozilla.javascript.Context r3 = org.mozilla.javascript.Context.getCurrentContext()
            if (r3 == 0) goto L89
            int r3 = r3.getLanguageVersion()
            r5 = 150(0x96, float:2.1E-43)
            if (r3 >= r5) goto L90
        L89:
            r7 = 8
            r4 = r2
            goto L94
        L8d:
            int r4 = r4 + 2
            goto L94
        L90:
            r7 = 10
            goto L94
        L93:
            r7 = r11
        L94:
            double r1 = org.mozilla.javascript.ScriptRuntime.stringPrefixToNumber(r1, r4, r7)
            if (r0 == 0) goto L9b
            double r1 = -r1
        L9b:
            java.lang.Number r11 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r1)
            return r11
        La0:
            java.lang.Double r11 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_parseInt(java.lang.Object[]):java.lang.Object");
    }

    private static Object js_unescape(Object[] objArr) {
        int i2;
        int i3;
        String string = ScriptRuntime.toString(objArr, 0);
        int iIndexOf = string.indexOf(37);
        if (iIndexOf < 0) {
            return string;
        }
        int length = string.length();
        char[] charArray = string.toCharArray();
        int i4 = iIndexOf;
        while (iIndexOf != length) {
            char c2 = charArray[iIndexOf];
            iIndexOf++;
            if (c2 == '%' && iIndexOf != length) {
                if (charArray[iIndexOf] == 'u') {
                    i3 = iIndexOf + 1;
                    i2 = iIndexOf + 5;
                } else {
                    i2 = iIndexOf + 2;
                    i3 = iIndexOf;
                }
                if (i2 <= length) {
                    int iXDigitToInt = 0;
                    while (i3 != i2) {
                        iXDigitToInt = Kit.xDigitToInt(charArray[i3], iXDigitToInt);
                        i3++;
                    }
                    if (iXDigitToInt >= 0) {
                        c2 = (char) iXDigitToInt;
                        iIndexOf = i2;
                    }
                }
            }
            charArray[i4] = c2;
            i4++;
        }
        return new String(charArray, 0, i4);
    }

    private static int oneUcs4ToUtf8Char(byte[] bArr, int i2) {
        if ((i2 & (-128)) == 0) {
            bArr[0] = (byte) i2;
            return 1;
        }
        int i3 = i2 >>> 11;
        int i4 = 2;
        while (i3 != 0) {
            i3 >>>= 5;
            i4++;
        }
        int i5 = i4;
        while (true) {
            i5--;
            if (i5 <= 0) {
                bArr[0] = (byte) ((256 - (1 << (8 - i4))) + i2);
                return i4;
            }
            bArr[i5] = (byte) ((i2 & 63) | 128);
            i2 >>>= 6;
        }
    }

    private static char toHexChar(int i2) {
        if ((i2 >> 4) != 0) {
            Kit.codeBug();
        }
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 65);
    }

    private static int unHex(char c2) {
        char c3 = 'A';
        if ('A' > c2 || c2 > 'F') {
            c3 = 'a';
            if ('a' > c2 || c2 > 'f') {
                if ('0' > c2 || c2 > '9') {
                    return -1;
                }
                return c2 - '0';
            }
        }
        return (c2 - c3) + 10;
    }

    private static int unHex(char c2, char c3) {
        int iUnHex = unHex(c2);
        int iUnHex2 = unHex(c3);
        if (iUnHex < 0 || iUnHex2 < 0) {
            return -1;
        }
        return (iUnHex << 4) | iUnHex2;
    }

    private static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessage0("msg.bad.uri"));
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG)) {
            int iMethodId = idFunctionObject.methodId();
            switch (iMethodId) {
                case 1:
                case 2:
                    return decode(ScriptRuntime.toString(objArr, 0), iMethodId == 1);
                case 3:
                case 4:
                    return encode(ScriptRuntime.toString(objArr, 0), iMethodId == 3);
                case 5:
                    return js_escape(objArr);
                case 6:
                    return js_eval(context, scriptable, objArr);
                case 7:
                    return objArr.length < 1 ? Boolean.FALSE : NativeNumber.isFinite(objArr[0]);
                case 8:
                    return ScriptRuntime.wrapBoolean(objArr.length >= 1 ? Double.isNaN(ScriptRuntime.toNumber(objArr[0])) : true);
                case 9:
                    return ScriptRuntime.wrapBoolean(XMLLib.extractFromScope(scriptable).isXMLName(context, objArr.length == 0 ? Undefined.instance : objArr[0]));
                case 10:
                    return js_parseFloat(objArr);
                case 11:
                    return js_parseInt(objArr);
                case 12:
                    return js_unescape(objArr);
                case 13:
                    return ScriptRuntime.uneval(context, scriptable, objArr.length != 0 ? objArr[0] : Undefined.instance);
                case 14:
                    return NativeError.make(context, scriptable, idFunctionObject, objArr);
            }
        }
        throw idFunctionObject.unknown();
    }

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable, String str3, int i2, int i3, String str4) {
        return ScriptRuntime.constructError(str, str2, str3, i2, str4, i3);
    }
}
