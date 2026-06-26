package e.a.a.d;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    @NotNull
    public static final j a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.h0.g f5538b = new f.h0.g("^[\"”“][^\"”“]+[\"”“]$");

    public static final ArrayList<Integer> a(String str, int i2, int i3, int i4, int i5) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayListE = e(str, ".？。！?!~", 0, str.length() - 2, true);
        ArrayList<Integer> arrayListE2 = e(str, ".，、,—…", 0, str.length() - 2, true);
        if (arrayListE.size() < i5 && arrayListE2.size() < i5 * 3) {
            return arrayList;
        }
        int i6 = 0;
        int iMax = i3;
        while (iMax < arrayListE.size()) {
            int i7 = 0;
            while (i6 < arrayListE2.size()) {
                Integer num = arrayListE2.get(i6);
                f.c0.c.j.d(num, "arrayMid[j]");
                int iIntValue = num.intValue();
                Integer num2 = arrayListE.get(iMax);
                f.c0.c.j.d(num2, "arrayEnd[i]");
                if (iIntValue < num2.intValue()) {
                    i7++;
                }
                i6++;
            }
            if (Math.random() * ((double) i4) < (((double) i7) / 2.5d) + 0.8d) {
                arrayList.add(Integer.valueOf(arrayListE.get(iMax).intValue() + i2));
                iMax = Math.max(iMax + i3, iMax);
            }
            iMax++;
        }
        return arrayList;
    }

    public static final boolean b(String str, char c2) {
        return f.h0.k.p(str, c2, 0, false, 6) != -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0221, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02a4  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String c(@org.jetbrains.annotations.NotNull java.lang.String r32, @org.jetbrains.annotations.NotNull java.lang.String r33) {
        /*
            Method dump skipped, instruction units count: 1893
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.j.c(java.lang.String, java.lang.String):java.lang.String");
    }

    public static final int d(String str, String str2, int i2, int i3, boolean z) {
        if (str.length() - i2 < 1) {
            return -1;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        int length = str.length();
        if (i3 > 0) {
            length = Math.min(length, i3);
        }
        while (i2 < length) {
            if (f.h0.k.p(str2, z ? str.charAt(i2) : str.charAt((str.length() - i2) - 1), 0, false, 6) != -1) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final ArrayList<Integer> e(String str, String str2, int i2, int i3, boolean z) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (str.length() - i2 < 1) {
            return arrayList;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        int length = str.length();
        if (i3 > 0) {
            length = Math.min(length, i3);
        }
        while (i2 < length) {
            if (f.h0.k.p(str2, z ? str.charAt(i2) : str.charAt((str.length() - i2) - 1), 0, false, 6) != -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        return arrayList;
    }

    public static final int f(String str, String str2, int i2, int i3) {
        if (str.length() - i2 < 1) {
            return -1;
        }
        int iL = f.h0.k.l(str);
        if (i2 >= iL || iL <= 0) {
            i2 = iL;
        }
        if (i3 <= 0) {
            i3 = 0;
        }
        while (i2 > i3) {
            if (f.h0.k.p(str2, str.charAt(i2), 0, false, 6) != -1) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static final String g(String str) {
        int iD;
        int length = str.length();
        if (length < 3) {
            return str;
        }
        if (b("\"“”", str.charAt(0))) {
            int iD2 = d(str, "\"“”", 1, length - 2, true) + 1;
            if (iD2 <= 1 || b("，：,:", str.charAt(iD2 - 1))) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            String strSubstring = str.substring(0, iD2);
            f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append('\n');
            String strSubstring2 = str.substring(iD2);
            f.c0.c.j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(strSubstring2);
            return sb.toString();
        }
        int i2 = length - 1;
        if (!b("\"“”", str.charAt(i2)) || (iD = i2 - d(str, "\"“”", 1, length - 2, false)) <= 1 || b("，：,:", str.charAt(iD - 1))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring3 = str.substring(0, iD);
        f.c0.c.j.d(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb2.append(strSubstring3);
        sb2.append('\n');
        String strSubstring4 = str.substring(iD);
        f.c0.c.j.d(strSubstring4, "(this as java.lang.String).substring(startIndex)");
        sb2.append(strSubstring4);
        return sb2.toString();
    }
}
