package k.b.a.a;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static final /* synthetic */ int a = 0;

    static {
        Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    }

    public static boolean a(CharSequence charSequence, char... cArr) {
        if (!e(charSequence)) {
            if (!((cArr == null ? 0 : Array.getLength(cArr)) == 0)) {
                int length = charSequence.length();
                int length2 = cArr.length;
                int i2 = length - 1;
                int i3 = length2 - 1;
                for (int i4 = 0; i4 < length; i4++) {
                    char cCharAt = charSequence.charAt(i4);
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (cArr[i5] == cCharAt) {
                            if (!Character.isHighSurrogate(cCharAt) || i5 == i3) {
                                return true;
                            }
                            if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean b(CharSequence charSequence, char... cArr) {
        if (charSequence == null || cArr == null) {
            return true;
        }
        int length = charSequence.length();
        int i2 = length - 1;
        int length2 = cArr.length;
        int i3 = length2 - 1;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = charSequence.charAt(i4);
            for (int i5 = 0; i5 < length2; i5++) {
                if (cArr[i5] == cCharAt) {
                    if (!Character.isHighSurrogate(cCharAt) || i5 == i3) {
                        return false;
                    }
                    if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int c(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return charSequence instanceof String ? ((String) charSequence).indexOf(charSequence2.toString(), i2) : charSequence instanceof StringBuilder ? ((StringBuilder) charSequence).indexOf(charSequence2.toString(), i2) : charSequence instanceof StringBuffer ? ((StringBuffer) charSequence).indexOf(charSequence2.toString(), i2) : charSequence.toString().indexOf(charSequence2.toString(), i2);
    }

    public static boolean d(CharSequence charSequence) {
        int length = charSequence == null ? 0 : charSequence.length();
        if (length == 0) {
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean f(CharSequence charSequence) {
        return !d(charSequence);
    }

    public static String g(Iterable<?> iterable, String str) {
        Iterator<?> it;
        if (iterable == null || (it = iterable.iterator()) == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(str);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String h(String str, String str2) {
        return (e(str) || e(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String i(String str, String str2) {
        return (e(str) || e(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String j(String str, String str2, String str3) {
        if (e(str) || e(str2) || str3 == null) {
            return str;
        }
        int i2 = 0;
        int iC = c(str, str2, 0);
        if (iC == -1) {
            return str;
        }
        int length = str2.length();
        StringBuilder sb = new StringBuilder(str.length() + (Math.max(str3.length() - length, 0) * 16));
        int i3 = -1;
        while (iC != -1) {
            sb.append((CharSequence) str, i2, iC);
            sb.append(str3);
            i2 = iC + length;
            i3--;
            if (i3 == 0) {
                break;
            }
            iC = c(str, str2, i2);
        }
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }

    public static String k(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return i2 > str.length() ? "" : str.substring(i2);
    }

    public static String l(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0) {
            i3 += str.length();
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i3 > str.length()) {
            i3 = str.length();
        }
        if (i2 > i3) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        return str.substring(i2, i3);
    }
}
