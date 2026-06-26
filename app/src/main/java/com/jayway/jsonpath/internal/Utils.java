package com.jayway.jsonpath.internal;

import c.a.a.a.a;
import com.jayway.jsonpath.JsonPathException;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    private Utils() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String concat(CharSequence... charSequenceArr) {
        if (charSequenceArr.length == 0) {
            return "";
        }
        if (charSequenceArr.length == 1) {
            return charSequenceArr[0].toString();
        }
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < charSequenceArr.length; i4++) {
            int length = charSequenceArr[i4].length();
            i2 += length;
            if (i3 != -2 && length > 0) {
                i3 = i3 == -1 ? i4 : -2;
            }
        }
        if (i2 == 0) {
            return "";
        }
        if (i3 > 0) {
            return charSequenceArr[i3].toString();
        }
        StringBuilder sb = new StringBuilder(i2);
        for (CharSequence charSequence : charSequenceArr) {
            sb.append(charSequence);
        }
        return sb.toString();
    }

    public static String escape(String str, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringWriter stringWriter = new StringWriter(length * 2);
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt > 4095) {
                StringBuilder sbR = a.r("\\u");
                sbR.append(hex(cCharAt));
                stringWriter.write(sbR.toString());
            } else if (cCharAt > 255) {
                StringBuilder sbR2 = a.r("\\u0");
                sbR2.append(hex(cCharAt));
                stringWriter.write(sbR2.toString());
            } else if (cCharAt > 127) {
                StringBuilder sbR3 = a.r("\\u00");
                sbR3.append(hex(cCharAt));
                stringWriter.write(sbR3.toString());
            } else if (cCharAt < ' ') {
                switch (cCharAt) {
                    case '\b':
                        stringWriter.write(92);
                        stringWriter.write(98);
                        break;
                    case '\t':
                        stringWriter.write(92);
                        stringWriter.write(116);
                        break;
                    case '\n':
                        stringWriter.write(92);
                        stringWriter.write(110);
                        break;
                    case 11:
                    default:
                        if (cCharAt > 15) {
                            StringBuilder sbR4 = a.r("\\u00");
                            sbR4.append(hex(cCharAt));
                            stringWriter.write(sbR4.toString());
                        } else {
                            StringBuilder sbR5 = a.r("\\u000");
                            sbR5.append(hex(cCharAt));
                            stringWriter.write(sbR5.toString());
                        }
                        break;
                    case '\f':
                        stringWriter.write(92);
                        stringWriter.write(102);
                        break;
                    case '\r':
                        stringWriter.write(92);
                        stringWriter.write(114);
                        break;
                }
            } else if (cCharAt == '\"') {
                stringWriter.write(92);
                stringWriter.write(34);
            } else if (cCharAt == '\'') {
                if (z) {
                    stringWriter.write(92);
                }
                stringWriter.write(39);
            } else if (cCharAt == '/') {
                stringWriter.write(92);
                stringWriter.write(47);
            } else if (cCharAt != '\\') {
                stringWriter.write(cCharAt);
            } else {
                stringWriter.write(92);
                stringWriter.write(92);
            }
        }
        return stringWriter.toString();
    }

    public static String hex(char c2) {
        return Integer.toHexString(c2).toUpperCase();
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return charSequence.toString().indexOf(charSequence2.toString(), i2);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static void isTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String join(String str, String str2, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sbR = a.r(str2);
        sbR.append(it.next());
        sbR.append(str2);
        while (it.hasNext()) {
            sbR.append(str);
            sbR.append(str2);
            sbR.append(it.next());
            sbR.append(str2);
        }
        return sbR.toString();
    }

    public static <T extends CharSequence> T notEmpty(T t, String str, Object... objArr) {
        if (t == null || t.length() == 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    public static <T> T notNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static void onlyOneIsTrue(String str, boolean... zArr) {
        if (!onlyOneIsTrueNonThrow(zArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean onlyOneIsTrueNonThrow(boolean... zArr) {
        int i2 = 0;
        for (boolean z : zArr) {
            if (z && (i2 = i2 + 1) > 1) {
                return false;
            }
        }
        return 1 == i2;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static String unescape(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringWriter stringWriter = new StringWriter(length);
        StringBuilder sb = new StringBuilder(4);
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (z2) {
                sb.append(cCharAt);
                if (sb.length() == 4) {
                    try {
                        stringWriter.write((char) Integer.parseInt(sb.toString(), 16));
                        sb.setLength(0);
                        z = false;
                        z2 = false;
                    } catch (NumberFormatException e2) {
                        throw new JsonPathException("Unable to parse unicode value: " + ((Object) sb), e2);
                    }
                } else {
                    continue;
                }
            } else if (z) {
                if (cCharAt == '\"') {
                    stringWriter.write(34);
                } else if (cCharAt == '\'') {
                    stringWriter.write(39);
                } else if (cCharAt == '\\') {
                    stringWriter.write(92);
                } else if (cCharAt == 'b') {
                    stringWriter.write(8);
                } else if (cCharAt == 'f') {
                    stringWriter.write(12);
                } else if (cCharAt == 'n') {
                    stringWriter.write(10);
                } else if (cCharAt == 'r') {
                    stringWriter.write(13);
                } else if (cCharAt == 't') {
                    stringWriter.write(9);
                } else if (cCharAt != 'u') {
                    stringWriter.write(cCharAt);
                } else {
                    z = false;
                    z2 = true;
                }
                z = false;
            } else if (cCharAt == '\\') {
                z = true;
            } else {
                stringWriter.write(cCharAt);
            }
        }
        if (z) {
            stringWriter.write(92);
        }
        return stringWriter.toString();
    }

    public static String join(String str, Iterable<?> iterable) {
        return join(str, "", iterable);
    }
}
