package e.a.a.h;

import java.net.URL;
import java.util.BitSet;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NetworkUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    @NotNull
    public static final x a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5967b = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f5968c = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    /* JADX INFO: compiled from: NetworkUtils.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<BitSet> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final BitSet invoke() {
            BitSet bitSet = new BitSet(256);
            int i2 = 97;
            while (true) {
                int i3 = i2 + 1;
                bitSet.set(i2);
                if (i2 == 122) {
                    break;
                }
                i2 = i3;
            }
            int i4 = 65;
            while (true) {
                int i5 = i4 + 1;
                bitSet.set(i4);
                if (i4 == 90) {
                    break;
                }
                i4 = i5;
            }
            int i6 = 48;
            while (true) {
                int i7 = i6 + 1;
                bitSet.set(i6);
                if (i6 == 57) {
                    break;
                }
                i6 = i7;
            }
            int i8 = 0;
            while (i8 < 16) {
                char cCharAt = "+-_.$:()!*@&#,[]".charAt(i8);
                i8++;
                bitSet.set(cCharAt);
            }
            return bitSet;
        }
    }

    @NotNull
    public static final String a(@Nullable String str, @NotNull String str2) {
        f.c0.c.j.e(str2, "relativePath");
        if ((str == null || str.length() == 0) || c.b.a.m.f.o3(str2)) {
            return str2;
        }
        try {
            String string = new URL(new URL(f.h0.k.P(str, ",", null, 2)), str2).toString();
            f.c0.c.j.d(string, "parseUrl.toString()");
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    @NotNull
    public static final String b(@Nullable URL url, @NotNull String str) {
        f.c0.c.j.e(str, "relativePath");
        if (url == null) {
            return str;
        }
        try {
            String string = new URL(url, str).toString();
            f.c0.c.j.d(string, "parseUrl.toString()");
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    @Nullable
    public static final String c(@Nullable String str) {
        if (str == null || !f.h0.k.K(str, "http", false, 2)) {
            return null;
        }
        int iQ = f.h0.k.q(str, h.a.a.a.w.DEFAULT_PATH_SEPARATOR, 9, false, 4);
        if (iQ == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iQ);
        f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String d(@Nullable String str) {
        String strC = c(str);
        if (strC == null) {
            return "";
        }
        if (f.h0.k.q(strC, ".", 0, false, 6) == f.h0.k.u(strC, ".", 0, false, 6)) {
            String strSubstring = strC.substring(f.h0.k.u(strC, h.a.a.a.w.DEFAULT_PATH_SEPARATOR, 0, false, 6) + 1);
            f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        String strSubstring2 = strC.substring(f.h0.k.q(strC, ".", 0, false, 6) + 1);
        f.c0.c.j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return strSubstring2;
    }

    public static final boolean e(char c2) {
        if ('0' <= c2 && c2 <= '9') {
            return true;
        }
        if ('A' <= c2 && c2 <= 'F') {
            return true;
        }
        return 'a' <= c2 && c2 <= 'f';
    }
}
