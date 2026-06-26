package com.bytedance.sdk.openadsdk.api.a;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: DistinguishedNameParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f1674g;

    public b(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.f1669b = name.length();
    }

    private String a() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        while (true) {
            i2 = this.f1670c;
            i3 = this.f1669b;
            if (i2 >= i3 || this.f1674g[i2] != ' ') {
                break;
            }
            this.f1670c = i2 + 1;
        }
        if (i2 == i3) {
            return null;
        }
        this.f1671d = i2;
        this.f1670c = i2 + 1;
        while (true) {
            i4 = this.f1670c;
            i5 = this.f1669b;
            if (i4 >= i5) {
                break;
            }
            char[] cArr = this.f1674g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f1670c = i4 + 1;
        }
        if (i4 >= i5) {
            StringBuilder sbR = c.a.a.a.a.r("Unexpected end of DN: ");
            sbR.append(this.a);
            throw new IllegalStateException(sbR.toString());
        }
        this.f1672e = i4;
        if (this.f1674g[i4] == ' ') {
            while (true) {
                i6 = this.f1670c;
                i7 = this.f1669b;
                if (i6 >= i7) {
                    break;
                }
                char[] cArr2 = this.f1674g;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.f1670c = i6 + 1;
            }
            if (this.f1674g[i6] != '=' || i6 == i7) {
                StringBuilder sbR2 = c.a.a.a.a.r("Unexpected end of DN: ");
                sbR2.append(this.a);
                throw new IllegalStateException(sbR2.toString());
            }
        }
        this.f1670c++;
        while (true) {
            int i8 = this.f1670c;
            if (i8 >= this.f1669b || this.f1674g[i8] != ' ') {
                break;
            }
            this.f1670c = i8 + 1;
        }
        int i9 = this.f1672e;
        int i10 = this.f1671d;
        if (i9 - i10 > 4) {
            char[] cArr3 = this.f1674g;
            if (cArr3[i10 + 3] == '.' && ((cArr3[i10] == 'O' || cArr3[i10] == 'o') && ((cArr3[i10 + 1] == 'I' || cArr3[i10 + 1] == 'i') && (cArr3[i10 + 2] == 'D' || cArr3[i10 + 2] == 'd')))) {
                this.f1671d = i10 + 4;
            }
        }
        char[] cArr4 = this.f1674g;
        int i11 = this.f1671d;
        return new String(cArr4, i11, this.f1672e - i11);
    }

    private String b() {
        int i2 = this.f1670c + 1;
        this.f1670c = i2;
        this.f1671d = i2;
        this.f1672e = i2;
        while (true) {
            int i3 = this.f1670c;
            if (i3 == this.f1669b) {
                StringBuilder sbR = c.a.a.a.a.r("Unexpected end of DN: ");
                sbR.append(this.a);
                throw new IllegalStateException(sbR.toString());
            }
            char[] cArr = this.f1674g;
            if (cArr[i3] == '\"') {
                this.f1670c = i3 + 1;
                while (true) {
                    int i4 = this.f1670c;
                    if (i4 >= this.f1669b || this.f1674g[i4] != ' ') {
                        break;
                    }
                    this.f1670c = i4 + 1;
                }
                char[] cArr2 = this.f1674g;
                int i5 = this.f1671d;
                return new String(cArr2, i5, this.f1672e - i5);
            }
            if (cArr[i3] == '\\') {
                cArr[this.f1672e] = e();
            } else {
                cArr[this.f1672e] = cArr[i3];
            }
            this.f1670c++;
            this.f1672e++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r6.f1672e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c() {
        /*
            r6 = this;
            int r0 = r6.f1670c
            int r1 = r0 + 4
            int r2 = r6.f1669b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L9f
            r6.f1671d = r0
            int r0 = r0 + 1
            r6.f1670c = r0
        L10:
            int r0 = r6.f1670c
            int r1 = r6.f1669b
            if (r0 == r1) goto L5f
            char[] r1 = r6.f1674g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L5f
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L5f
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L5f
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.f1672e = r0
            int r0 = r0 + 1
            r6.f1670c = r0
        L37:
            int r0 = r6.f1670c
            int r1 = r6.f1669b
            if (r0 >= r1) goto L61
            char[] r1 = r6.f1674g
            char r1 = r1[r0]
            if (r1 != r4) goto L61
            int r0 = r0 + 1
            r6.f1670c = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r0 + 1
            r6.f1670c = r0
            goto L10
        L5f:
            r6.f1672e = r0
        L61:
            int r0 = r6.f1672e
            int r1 = r6.f1671d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L8c
            r2 = r0 & 1
            if (r2 == 0) goto L8c
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            r4 = 0
            int r1 = r1 + 1
        L74:
            if (r4 >= r2) goto L82
            int r5 = r6.a(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L74
        L82:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f1674g
            int r3 = r6.f1671d
            r1.<init>(r2, r3, r0)
            return r1
        L8c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = c.a.a.a.a.r(r3)
            java.lang.String r2 = r6.a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = c.a.a.a.a.r(r3)
            java.lang.String r2 = r6.a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.a.b.c():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.f1674g;
        r2 = r8.f1671d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.f1672e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String d() {
        /*
            r8 = this;
            int r0 = r8.f1670c
            r8.f1671d = r0
            r8.f1672e = r0
        L6:
            int r0 = r8.f1670c
            int r1 = r8.f1669b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f1674g
            int r2 = r8.f1671d
            int r3 = r8.f1672e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f1674g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f1672e
            int r3 = r2 + 1
            r8.f1672e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f1670c = r0
            goto L6
        L40:
            int r0 = r8.f1672e
            int r2 = r0 + 1
            r8.f1672e = r2
            char r2 = r8.e()
            r1[r0] = r2
            int r0 = r8.f1670c
            int r0 = r0 + 1
            r8.f1670c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f1674g
            int r2 = r8.f1671d
            int r3 = r8.f1672e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f1672e
            r8.f1673f = r2
            int r0 = r0 + 1
            r8.f1670c = r0
            int r0 = r2 + 1
            r8.f1672e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f1670c
            int r1 = r8.f1669b
            if (r0 >= r1) goto L87
            char[] r2 = r8.f1674g
            char r7 = r2[r0]
            if (r7 != r6) goto L87
            int r1 = r8.f1672e
            int r7 = r1 + 1
            r8.f1672e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f1670c = r0
            goto L6e
        L87:
            if (r0 == r1) goto L97
            char[] r1 = r8.f1674g
            char r2 = r1[r0]
            if (r2 == r3) goto L97
            char r2 = r1[r0]
            if (r2 == r4) goto L97
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L97:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f1674g
            int r2 = r8.f1671d
            int r3 = r8.f1673f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.a.b.d():java.lang.String");
    }

    private char e() {
        int i2 = this.f1670c + 1;
        this.f1670c = i2;
        if (i2 == this.f1669b) {
            StringBuilder sbR = c.a.a.a.a.r("Unexpected end of DN: ");
            sbR.append(this.a);
            throw new IllegalStateException(sbR.toString());
        }
        char[] cArr = this.f1674g;
        char c2 = cArr[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return f();
                    }
                    break;
            }
        }
        return cArr[i2];
    }

    private char f() {
        int i2;
        int i3;
        int iA = a(this.f1670c);
        this.f1670c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i3 = iA & 31;
            i2 = 1;
        } else if (iA <= 239) {
            i2 = 2;
            i3 = iA & 15;
        } else {
            i2 = 3;
            i3 = iA & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f1670c + 1;
            this.f1670c = i5;
            if (i5 == this.f1669b || this.f1674g[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f1670c = i6;
            int iA2 = a(i6);
            this.f1670c++;
            if ((iA2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iA2 & 63);
        }
        return (char) i3;
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f1669b) {
            char[] cArr = this.f1674g;
            char c2 = cArr[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    StringBuilder sbR = c.a.a.a.a.r("Malformed DN: ");
                    sbR.append(this.a);
                    throw new IllegalStateException(sbR.toString());
                }
                i3 = c2 - '7';
            }
            char c3 = cArr[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    StringBuilder sbR2 = c.a.a.a.a.r("Malformed DN: ");
                    sbR2.append(this.a);
                    throw new IllegalStateException(sbR2.toString());
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        StringBuilder sbR3 = c.a.a.a.a.r("Malformed DN: ");
        sbR3.append(this.a);
        throw new IllegalStateException(sbR3.toString());
    }

    public String a(String str) {
        String strB;
        this.f1670c = 0;
        this.f1671d = 0;
        this.f1672e = 0;
        this.f1673f = 0;
        this.f1674g = this.a.toCharArray();
        String strA = a();
        if (strA == null) {
            return null;
        }
        do {
            int i2 = this.f1670c;
            if (i2 == this.f1669b) {
                return null;
            }
            char c2 = this.f1674g[i2];
            if (c2 == '\"') {
                strB = b();
            } else if (c2 != '#') {
                strB = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d();
            } else {
                strB = c();
            }
            if (str.equalsIgnoreCase(strA)) {
                return strB;
            }
            int i3 = this.f1670c;
            if (i3 >= this.f1669b) {
                return null;
            }
            char[] cArr = this.f1674g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                StringBuilder sbR = c.a.a.a.a.r("Malformed DN: ");
                sbR.append(this.a);
                throw new IllegalStateException(sbR.toString());
            }
            this.f1670c = i3 + 1;
            strA = a();
        } while (strA != null);
        StringBuilder sbR2 = c.a.a.a.a.r("Malformed DN: ");
        sbR2.append(this.a);
        throw new IllegalStateException(sbR2.toString());
    }
}
