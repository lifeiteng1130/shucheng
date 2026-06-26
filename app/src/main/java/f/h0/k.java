package f.h0;

import f.c0.c.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k extends j {

    /* JADX INFO: compiled from: Indent.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<String, String> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final String invoke(@NotNull String str) {
            f.c0.c.j.e(str, "line");
            return str;
        }
    }

    /* JADX INFO: compiled from: Indent.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<String, String> {
        public final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // f.c0.b.l
        @NotNull
        public final String invoke(@NotNull String str) {
            f.c0.c.j.e(str, "line");
            return c.a.a.a.a.p(new StringBuilder(), this.$indent, str);
        }
    }

    @NotNull
    public static final String A(@NotNull String str, @NotNull CharSequence charSequence) {
        f.c0.c.j.e(str, "$this$removePrefix");
        f.c0.c.j.e(charSequence, "prefix");
        if (!I(str, charSequence, false, 2)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String B(@NotNull CharSequence charSequence, int i2) {
        f.c0.c.j.e(charSequence, "$this$repeat");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 != 0) {
            if (i2 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length != 0) {
                if (length == 1) {
                    char cCharAt = charSequence.charAt(0);
                    char[] cArr = new char[i2];
                    for (int i4 = 0; i4 < i2; i4++) {
                        cArr[i4] = cCharAt;
                    }
                    return new String(cArr);
                }
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                if (1 <= i2) {
                    while (true) {
                        sb.append(charSequence);
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                String string = sb.toString();
                f.c0.c.j.d(string, "sb.toString()");
                return string;
            }
        }
        return "";
    }

    public static String C(String str, String str2, String str3, boolean z, int i2) {
        int i3 = 0;
        if ((i2 & 4) != 0) {
            z = false;
        }
        f.c0.c.j.e(str, "$this$replace");
        f.c0.c.j.e(str2, "oldValue");
        f.c0.c.j.e(str3, "newValue");
        int iM = m(str, str2, 0, z);
        if (iM < 0) {
            return str;
        }
        int length = str2.length();
        int i4 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i3, iM);
            sb.append(str3);
            i3 = iM + length;
            if (iM >= str.length()) {
                break;
            }
            iM = m(str, str2, iM + i4, z);
        } while (iM > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        f.c0.c.j.d(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static final List<String> D(CharSequence charSequence, String str, boolean z, int i2) {
        int length = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        int iM = m(charSequence, str, 0, z);
        if (iM == -1 || i2 == 1) {
            return c.b.a.m.f.P3(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        int i3 = 10;
        if (z2 && i2 <= 10) {
            i3 = i2;
        }
        ArrayList arrayList = new ArrayList(i3);
        do {
            arrayList.add(charSequence.subSequence(length, iM).toString());
            length = str.length() + iM;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            iM = m(charSequence, str, length, z);
        } while (iM != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List E(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        f.c0.c.j.e(charSequence, "$this$split");
        f.c0.c.j.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return D(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        f.h0.b bVar = new f.h0.b(charSequence, 0, i2, new l(cArr, z));
        f.c0.c.j.e(bVar, "$this$asIterable");
        f.g0.f fVar = new f.g0.f(bVar);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            arrayList.add(L(charSequence, (f.e0.d) it.next()));
        }
        return arrayList;
    }

    public static List F(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3) {
        boolean z2 = (i3 & 2) != 0 ? false : z;
        int i4 = (i3 & 4) != 0 ? 0 : i2;
        f.c0.c.j.e(charSequence, "$this$split");
        f.c0.c.j.e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return D(charSequence, str, z2, i4);
            }
        }
        f.g0.e eVarW = w(charSequence, strArr, 0, z2, i4, 2);
        f.c0.c.j.e(eVarW, "$this$asIterable");
        f.g0.f fVar = new f.g0.f(eVarW);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            arrayList.add(L(charSequence, (f.e0.d) it.next()));
        }
        return arrayList;
    }

    public static final boolean G(@NotNull String str, @NotNull String str2, int i2, boolean z) {
        f.c0.c.j.e(str, "$this$startsWith");
        f.c0.c.j.e(str2, "prefix");
        return !z ? str.startsWith(str2, i2) : x(str, i2, str2, 0, str2.length(), z);
    }

    public static final boolean H(@NotNull String str, @NotNull String str2, boolean z) {
        f.c0.c.j.e(str, "$this$startsWith");
        f.c0.c.j.e(str2, "prefix");
        return !z ? str.startsWith(str2) : x(str, 0, str2, 0, str2.length(), z);
    }

    public static boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2) {
        boolean z2 = (i2 & 2) != 0 ? false : z;
        f.c0.c.j.e(charSequence, "$this$startsWith");
        f.c0.c.j.e(charSequence2, "prefix");
        return (z2 || !(charSequence2 instanceof String)) ? z(charSequence, 0, charSequence2, 0, charSequence2.length(), z2) : K((String) charSequence, (String) charSequence2, false, 2);
    }

    public static /* synthetic */ boolean J(String str, String str2, int i2, boolean z, int i3) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return G(str, str2, i2, z);
    }

    public static /* synthetic */ boolean K(String str, String str2, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return H(str, str2, z);
    }

    @NotNull
    public static final String L(@NotNull CharSequence charSequence, @NotNull f.e0.d dVar) {
        f.c0.c.j.e(charSequence, "$this$substring");
        f.c0.c.j.e(dVar, "range");
        return charSequence.subSequence(dVar.getStart().intValue(), dVar.getEndInclusive().intValue() + 1).toString();
    }

    public static String M(String str, String str2, String str3, int i2) {
        String str4 = (i2 & 2) != 0 ? str : null;
        f.c0.c.j.e(str, "$this$substringAfter");
        f.c0.c.j.e(str2, "delimiter");
        f.c0.c.j.e(str4, "missingDelimiterValue");
        int iQ = q(str, str2, 0, false, 6);
        if (iQ == -1) {
            return str4;
        }
        String strSubstring = str.substring(str2.length() + iQ, str.length());
        f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String N(@NotNull String str, char c2, @NotNull String str2) {
        f.c0.c.j.e(str, "$this$substringAfterLast");
        f.c0.c.j.e(str2, "missingDelimiterValue");
        int iT = t(str, c2, 0, false, 6);
        if (iT == -1) {
            return str2;
        }
        String strSubstring = str.substring(iT + 1, str.length());
        f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String O(String str, String str2, String str3, int i2) {
        String str4 = (i2 & 2) != 0 ? str : null;
        f.c0.c.j.e(str, "$this$substringAfterLast");
        f.c0.c.j.e(str2, "delimiter");
        f.c0.c.j.e(str4, "missingDelimiterValue");
        int iU = u(str, str2, 0, false, 6);
        if (iU == -1) {
            return str4;
        }
        String strSubstring = str.substring(str2.length() + iU, str.length());
        f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String P(String str, String str2, String str3, int i2) {
        String str4 = (i2 & 2) != 0 ? str : null;
        f.c0.c.j.e(str, "$this$substringBefore");
        f.c0.c.j.e(str2, "delimiter");
        f.c0.c.j.e(str4, "missingDelimiterValue");
        int iQ = q(str, str2, 0, false, 6);
        if (iQ == -1) {
            return str4;
        }
        String strSubstring = str.substring(0, iQ);
        f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Integer Q(@org.jetbrains.annotations.NotNull java.lang.String r11) {
        /*
            java.lang.String r0 = "$this$toIntOrNull"
            f.c0.c.j.e(r11, r0)
            f.c0.c.j.e(r11, r0)
            r0 = 10
            c.b.a.m.f.N0(r0)
            int r1 = r11.length()
            r2 = 0
            if (r1 != 0) goto L15
            goto L6d
        L15:
            r3 = 0
            char r4 = r11.charAt(r3)
            r5 = 48
            int r5 = f.c0.c.j.g(r4, r5)
            r6 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r7 = 1
            if (r5 >= 0) goto L37
            if (r1 != r7) goto L29
            goto L6d
        L29:
            r5 = 45
            if (r4 != r5) goto L31
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1
            goto L39
        L31:
            r5 = 43
            if (r4 != r5) goto L6d
            r4 = 1
            goto L38
        L37:
            r4 = 0
        L38:
            r7 = 0
        L39:
            r5 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
            r8 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
        L3f:
            if (r4 >= r1) goto L60
            char r9 = r11.charAt(r4)
            int r9 = java.lang.Character.digit(r9, r0)
            if (r9 >= 0) goto L4c
            goto L6d
        L4c:
            if (r3 >= r8) goto L55
            if (r8 != r5) goto L6d
            int r8 = r6 / 10
            if (r3 >= r8) goto L55
            goto L6d
        L55:
            int r3 = r3 * 10
            int r10 = r6 + r9
            if (r3 >= r10) goto L5c
            goto L6d
        L5c:
            int r3 = r3 - r9
            int r4 = r4 + 1
            goto L3f
        L60:
            if (r7 == 0) goto L67
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            goto L6c
        L67:
            int r11 = -r3
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        L6c:
            r2 = r11
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h0.k.Q(java.lang.String):java.lang.Integer");
    }

    @NotNull
    public static final CharSequence R(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zH3 = c.b.a.m.f.H3(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!zH3) {
                    break;
                }
                length--;
            } else if (zH3) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @NotNull
    public static final String S(@NotNull String str) throws IOException {
        Comparable comparable;
        f.c0.c.j.e(str, "$this$trimIndent");
        f.c0.c.j.e(str, "$this$replaceIndent");
        f.c0.c.j.e("", "newIndent");
        List<String> listV = v(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listV) {
            if (!s((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(c.b.a.m.f.S0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            int length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length2 = str2.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!c.b.a.m.f.H3(str2.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str2.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        f.c0.c.j.e(arrayList2, "$this$minOrNull");
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int size = (listV.size() * 0) + str.length();
        f.c0.b.l<String, String> lVarK = k("");
        int iM = f.x.e.m(listV);
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        for (Object obj2 : listV) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            String str3 = (String) obj2;
            if ((i2 == 0 || i2 == iM) && s(str3)) {
                str3 = null;
            } else {
                f.c0.c.j.e(str3, "$this$drop");
                if (!(iIntValue >= 0)) {
                    throw new IllegalArgumentException(c.a.a.a.a.d("Requested character count ", iIntValue, " is less than zero.").toString());
                }
                int length3 = str3.length();
                if (iIntValue <= length3) {
                    length3 = iIntValue;
                }
                String strSubstring = str3.substring(length3);
                f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                String strInvoke = lVarK.invoke(strSubstring);
                if (strInvoke != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder(size);
        f.x.e.p(arrayList3, sb, "\n", null, null, 0, null, null, 124);
        String string = sb.toString();
        f.c0.c.j.d(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static String T(String str, String str2, int i2) throws IOException {
        String strSubstring;
        String strInvoke;
        String str3 = (i2 & 1) != 0 ? "|" : null;
        f.c0.c.j.e(str, "$this$trimMargin");
        f.c0.c.j.e(str3, "marginPrefix");
        f.c0.c.j.e(str, "$this$replaceIndentByMargin");
        f.c0.c.j.e("", "newIndent");
        f.c0.c.j.e(str3, "marginPrefix");
        if (!(!s(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listV = v(str);
        int size = (listV.size() * 0) + str.length();
        f.c0.b.l<String, String> lVarK = k("");
        int iM = f.x.e.m(listV);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : listV) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                f.x.e.D();
                throw null;
            }
            String str4 = (String) obj;
            if ((i3 == 0 || i3 == iM) && s(str4)) {
                str4 = null;
            } else {
                int length = str4.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    }
                    if (!c.b.a.m.f.H3(str4.charAt(i5))) {
                        break;
                    }
                    i5++;
                }
                if (i5 != -1 && J(str4, str3, i5, false, 4)) {
                    strSubstring = str4.substring(str3.length() + i5);
                    f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                } else {
                    strSubstring = null;
                }
                if (strSubstring != null && (strInvoke = lVarK.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i3 = i4;
        }
        StringBuilder sb = new StringBuilder(size);
        f.x.e.p(arrayList, sb, "\n", null, null, 0, null, null, 124);
        String string = sb.toString();
        f.c0.c.j.d(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final int a(@NotNull String str, @NotNull String str2, boolean z) {
        f.c0.c.j.e(str, "$this$compareTo");
        f.c0.c.j.e(str2, "other");
        return z ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static final boolean b(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        f.c0.c.j.e(charSequence, "$this$contains");
        f.c0.c.j.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (q(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                return true;
            }
        } else if (o(charSequence, charSequence2, 0, charSequence.length(), z, false, 16) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean c(CharSequence charSequence, char c2, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        f.c0.c.j.e(charSequence, "$this$contains");
        return p(charSequence, c2, 0, z, 2) >= 0;
    }

    public static /* synthetic */ boolean d(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(charSequence, charSequence2, z);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final byte[] e(@NotNull String str) {
        f.c0.c.j.e(str, "$this$encodeToByteArray");
        byte[] bytes = str.getBytes(f.h0.a.a);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final boolean f(@NotNull String str, @NotNull String str2, boolean z) {
        f.c0.c.j.e(str, "$this$endsWith");
        f.c0.c.j.e(str2, "suffix");
        return !z ? str.endsWith(str2) : x(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static boolean g(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2) {
        boolean z2 = (i2 & 2) != 0 ? false : z;
        f.c0.c.j.e(charSequence, "$this$endsWith");
        f.c0.c.j.e(charSequence2, "suffix");
        return (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? h((String) charSequence, (String) charSequence2, false, 2) : z(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z2);
    }

    public static /* synthetic */ boolean h(String str, String str2, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return f(str, str2, z);
    }

    public static final boolean i(@Nullable String str, @Nullable String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    @NotNull
    public static final Comparator<String> j(@NotNull x xVar) {
        f.c0.c.j.e(xVar, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        f.c0.c.j.d(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final f.c0.b.l<String, String> k(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    public static final int l(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int m(@NotNull CharSequence charSequence, @NotNull String str, int i2, boolean z) {
        f.c0.c.j.e(charSequence, "$this$indexOf");
        f.c0.c.j.e(str, "string");
        return (z || !(charSequence instanceof String)) ? o(charSequence, str, i2, charSequence.length(), z, false, 16) : ((String) charSequence).indexOf(str, i2);
    }

    public static final int n(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        f.e0.b bVarC;
        if (z2) {
            int iL = l(charSequence);
            if (i2 > iL) {
                i2 = iL;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            bVarC = f.e0.e.c(i2, i3);
        } else {
            if (i2 < 0) {
                i2 = 0;
            }
            int length = charSequence.length();
            if (i3 > length) {
                i3 = length;
            }
            bVarC = new f.e0.d(i2, i3);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int i4 = bVarC.a;
            int i5 = bVarC.f6128b;
            int i6 = bVarC.f6129c;
            if (i6 >= 0) {
                if (i4 > i5) {
                    return -1;
                }
            } else if (i4 < i5) {
                return -1;
            }
            while (!x((String) charSequence2, 0, (String) charSequence, i4, charSequence2.length(), z)) {
                if (i4 == i5) {
                    return -1;
                }
                i4 += i6;
            }
            return i4;
        }
        int i7 = bVarC.a;
        int i8 = bVarC.f6128b;
        int i9 = bVarC.f6129c;
        if (i9 >= 0) {
            if (i7 > i8) {
                return -1;
            }
        } else if (i7 < i8) {
            return -1;
        }
        while (!z(charSequence2, 0, charSequence, i7, charSequence2.length(), z)) {
            if (i7 == i8) {
                return -1;
            }
            i7 += i9;
        }
        return i7;
    }

    public static /* synthetic */ int o(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4) {
        return n(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static int p(CharSequence charSequence, char c2, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        f.c0.c.j.e(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? r(charSequence, new char[]{c2}, i2, z) : ((String) charSequence).indexOf(c2, i2);
    }

    public static /* synthetic */ int q(CharSequence charSequence, String str, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m(charSequence, str, i2, z);
    }

    public static final int r(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i2, boolean z) {
        boolean z2;
        f.c0.c.j.e(charSequence, "$this$indexOfAny");
        f.c0.c.j.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c.b.a.m.f.i5(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int iL = l(charSequence);
        if (i2 > iL) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i2);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (c.b.a.m.f.C1(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return i2;
            }
            if (i2 == iL) {
                return -1;
            }
            i2++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean s(@NotNull CharSequence charSequence) {
        boolean z;
        f.c0.c.j.e(charSequence, "$this$isBlank");
        if (charSequence.length() == 0) {
            return true;
        }
        f.c0.c.j.e(charSequence, "$this$indices");
        f.e0.d dVar = new f.e0.d(0, charSequence.length() - 1);
        if ((dVar instanceof Collection) && ((Collection) dVar).isEmpty()) {
            z = true;
        } else {
            Iterator it = dVar.iterator();
            while (((f.e0.c) it).f6130b) {
                if (!c.b.a.m.f.H3(charSequence.charAt(((f.x.l) it).nextInt()))) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    public static int t(CharSequence charSequence, char c2, int i2, boolean z, int i3) {
        boolean z2;
        if ((i3 & 2) != 0) {
            i2 = l(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        f.c0.c.j.e(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        char[] cArr = {c2};
        f.c0.c.j.e(charSequence, "$this$lastIndexOfAny");
        f.c0.c.j.e(cArr, "chars");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c.b.a.m.f.i5(cArr), i2);
        }
        int iL = l(charSequence);
        if (i2 > iL) {
            i2 = iL;
        }
        while (i2 >= 0) {
            char cCharAt = charSequence.charAt(i2);
            int i4 = 0;
            while (true) {
                if (i4 >= 1) {
                    z2 = false;
                    break;
                }
                if (c.b.a.m.f.C1(cArr[i4], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (z2) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int u(CharSequence charSequence, String str, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = l(charSequence);
        }
        int i4 = i2;
        boolean z2 = (i3 & 4) != 0 ? false : z;
        f.c0.c.j.e(charSequence, "$this$lastIndexOf");
        f.c0.c.j.e(str, "string");
        return (z2 || !(charSequence instanceof String)) ? n(charSequence, str, i4, 0, z2, true) : ((String) charSequence).lastIndexOf(str, i4);
    }

    @NotNull
    public static final List<String> v(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "$this$lines");
        f.c0.c.j.e(charSequence, "$this$lineSequence");
        String[] strArr = {"\r\n", "\n", "\r"};
        f.c0.c.j.e(charSequence, "$this$splitToSequence");
        f.c0.c.j.e(strArr, "delimiters");
        f.g0.e eVarW = w(charSequence, strArr, 0, false, 0, 2);
        n nVar = new n(charSequence);
        f.c0.c.j.e(eVarW, "$this$map");
        f.c0.c.j.e(nVar, "transform");
        return c.b.a.m.f.J5(new f.g0.g(eVarW, nVar));
    }

    public static f.g0.e w(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        if (i3 >= 0) {
            return new f.h0.b(charSequence, i2, i3, new m(f.x.e.b(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static final boolean x(@NotNull String str, int i2, @NotNull String str2, int i3, int i4, boolean z) {
        f.c0.c.j.e(str, "$this$regionMatches");
        f.c0.c.j.e(str2, "other");
        return !z ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z, i2, str2, i3, i4);
    }

    public static final boolean z(@NotNull CharSequence charSequence, int i2, @NotNull CharSequence charSequence2, int i3, int i4, boolean z) {
        f.c0.c.j.e(charSequence, "$this$regionMatchesImpl");
        f.c0.c.j.e(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!c.b.a.m.f.C1(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }
}
