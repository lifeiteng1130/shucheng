package c.e.c.y;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends k {
    public static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f1453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f1454d = new StringBuilder(20);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f1455e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, TinkerReport.KEY_LOADED_SUCC_COST_OTHER, TinkerReport.KEY_LOADED_SUCC_COST_3000_LESS, 394, 360, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE};
        f1452b = iArr;
        f1453c = iArr[47];
    }

    public static void h(CharSequence charSequence, int i2, int i3) throws c.e.c.d {
        int iIndexOf = 0;
        int i4 = 1;
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i2) != a[iIndexOf % 47]) {
            throw c.e.c.d.getChecksumInstance();
        }
    }

    public static int i(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int iRound = Math.round((iArr[i5] * 9.0f) / i2);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                for (int i6 = 0; i6 < iRound; i6++) {
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= iRound;
            }
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        r8 = c.e.c.y.d.a[r9];
        r7.append(r8);
        r9 = r6.length;
        r12 = r4;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r10 >= r9) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        r9 = r18.f(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8 != '*') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        r7.deleteCharAt(r7.length() - 1);
        r8 = r6.length;
        r10 = 0;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        if (r10 >= r8) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
    
        if (r9 == r5) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
    
        if (r18.e(r9) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
    
        if (r7.length() < 2) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
    
        r1 = r7.length();
        h(r7, r1 - 2, 20);
        h(r7, r1 - 1, 15);
        r7.setLength(r7.length() - 2);
        r1 = r7.length();
        r5 = new java.lang.StringBuilder(r1);
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
    
        if (r6 >= r1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c1, code lost:
    
        r8 = r7.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c7, code lost:
    
        if (r8 < 'a') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cb, code lost:
    
        if (r8 > 'd') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        if (r6 >= (r1 - 1)) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        r6 = r6 + 1;
        r9 = r7.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dd, code lost:
    
        switch(r8) {
            case 97: goto L79;
            case 98: goto L55;
            case 99: goto L48;
            case 100: goto L43;
            default: goto L42;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
    
        if (r9 < 'A') goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e5, code lost:
    
        if (r9 > 'Z') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
    
        r9 = r9 + ' ';
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
    
        throw c.e.c.g.getFormatInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ef, code lost:
    
        if (r9 < 'A') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f1, code lost:
    
        if (r9 > 'O') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f3, code lost:
    
        r9 = r9 - ' ';
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f6, code lost:
    
        if (r9 != 'Z') goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f8, code lost:
    
        r8 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ff, code lost:
    
        throw c.e.c.g.getFormatInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
    
        if (r9 < 'A') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0104, code lost:
    
        if (r9 > 'E') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
    
        r9 = r9 - '&';
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010b, code lost:
    
        if (r9 < 'F') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010f, code lost:
    
        if (r9 > 'J') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
    
        r9 = r9 - 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0116, code lost:
    
        if (r9 < 'K') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0118, code lost:
    
        if (r9 > 'O') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
    
        r9 = r9 + 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011f, code lost:
    
        if (r9 < 'P') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0123, code lost:
    
        if (r9 > 'S') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0125, code lost:
    
        r9 = r9 + '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x012a, code lost:
    
        if (r9 < 'T') goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012c, code lost:
    
        if (r9 > 'Z') goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012e, code lost:
    
        r8 = 127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0135, code lost:
    
        throw c.e.c.g.getFormatInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0136, code lost:
    
        if (r9 < 'A') goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0138, code lost:
    
        if (r9 > 'Z') goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013a, code lost:
    
        r9 = r9 - '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013c, code lost:
    
        r8 = (char) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0142, code lost:
    
        throw c.e.c.g.getFormatInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0143, code lost:
    
        r5.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x014b, code lost:
    
        throw c.e.c.g.getFormatInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x014c, code lost:
    
        r5.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014f, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0152, code lost:
    
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x017e, code lost:
    
        return new c.e.c.p(r5.toString(), null, new c.e.c.r[]{new c.e.c.r((r2[1] + r2[0]) / 2.0f, r9), new c.e.c.r((r12 / 2.0f) + r4, r9)}, c.e.c.a.CODE_93);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0183, code lost:
    
        throw c.e.c.k.getNotFoundInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0188, code lost:
    
        throw c.e.c.k.getNotFoundInstance();
     */
    @Override // c.e.c.y.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.e.c.p c(int r17, c.e.c.v.a r18, java.util.Map<c.e.c.e, ?> r19) throws c.e.c.k, c.e.c.g, c.e.c.d {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.y.d.c(int, c.e.c.v.a, java.util.Map):c.e.c.p");
    }
}
