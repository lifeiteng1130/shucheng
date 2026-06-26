package i.a.b.k;

import com.uc.crashsdk.export.LogType;
import i.a.b.m.k;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import okio.internal.BufferKt;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: JSONParserBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static boolean[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean[] f6369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean[] f6370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean[] f6371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean[] f6372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public char f6373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f6375h = new a(15);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f6376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6379l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;

    /* JADX INFO: compiled from: JSONParserBase.java */
    public static class a {
        public char[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6380b = -1;

        public a(int i2) {
            this.a = new char[i2];
        }

        public void a(char c2) {
            int i2 = this.f6380b + 1;
            this.f6380b = i2;
            char[] cArr = this.a;
            if (cArr.length <= i2) {
                char[] cArr2 = new char[(cArr.length * 2) + 1];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.a = cArr2;
            }
            this.a[this.f6380b] = c2;
        }

        public String toString() {
            return new String(this.a, 0, this.f6380b + 1);
        }
    }

    static {
        boolean[] zArr = new boolean[126];
        a = zArr;
        boolean[] zArr2 = new boolean[126];
        f6369b = zArr2;
        boolean[] zArr3 = new boolean[126];
        f6370c = zArr3;
        boolean[] zArr4 = new boolean[126];
        f6371d = zArr4;
        boolean[] zArr5 = new boolean[126];
        f6372e = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public b(int i2) {
        this.m = (i2 & 4) > 0;
        this.n = (i2 & 2) > 0;
        this.o = (i2 & 1) > 0;
        this.s = (i2 & 8) > 0;
        this.u = (i2 & 16) > 0;
        this.f6379l = (i2 & 32) > 0;
        this.p = (i2 & 64) > 0;
        this.t = (i2 & 128) > 0;
        this.q = (i2 & LogType.UNEXP_OTHER) != 768;
        this.r = (i2 & 512) == 0;
        this.v = (i2 & 1024) > 0;
    }

    public void a() throws g {
        int length = this.f6377j.length();
        if (length == 1) {
            return;
        }
        if (length == 2) {
            if (this.f6377j.equals("00")) {
                throw new g(this.f6378k, 6, this.f6377j);
            }
            return;
        }
        char cCharAt = this.f6377j.charAt(0);
        char cCharAt2 = this.f6377j.charAt(1);
        if (cCharAt != '-') {
            if (cCharAt == '0' && cCharAt2 >= '0' && cCharAt2 <= '9') {
                throw new g(this.f6378k, 6, this.f6377j);
            }
            return;
        }
        char cCharAt3 = this.f6377j.charAt(2);
        if (cCharAt2 == '0' && cCharAt3 >= '0' && cCharAt3 <= '9') {
            throw new g(this.f6378k, 6, this.f6377j);
        }
    }

    public Number b() throws g {
        if (!this.f6379l) {
            a();
        }
        return !this.t ? Float.valueOf(Float.parseFloat(this.f6377j)) : this.f6377j.length() > 18 ? new BigDecimal(this.f6377j) : Double.valueOf(Double.parseDouble(this.f6377j));
    }

    public <T> T c(k<T> kVar) throws g {
        this.f6378k = -1;
        try {
            e();
            T t = (T) g(kVar);
            if (this.q) {
                if (!this.r) {
                    s();
                }
                if (this.f6373f != 26) {
                    throw new g(this.f6378k - 1, 1, Character.valueOf(this.f6373f));
                }
            }
            this.f6377j = null;
            this.f6376i = null;
            return t;
        } catch (IOException e2) {
            throw new g(this.f6378k, e2);
        }
    }

    public Number d(String str) throws g {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int length = str.length();
        boolean z3 = false;
        if (str.charAt(0) == '-') {
            i2 = 20;
            if (!this.f6379l && length >= 3 && str.charAt(1) == '0') {
                throw new g(this.f6378k, 6, str);
            }
            i3 = 1;
            z = true;
        } else {
            if (!this.f6379l && length >= 2 && str.charAt(0) == '0') {
                throw new g(this.f6378k, 6, str);
            }
            i2 = 19;
            i3 = 0;
            z = false;
        }
        if (length < i2) {
            z2 = false;
        } else {
            if (length > i2) {
                return new BigInteger(str, 10);
            }
            length--;
            z2 = true;
        }
        long jCharAt = 0;
        while (i3 < length) {
            jCharAt = (jCharAt * 10) + ((long) ('0' - str.charAt(i3)));
            i3++;
        }
        if (z2) {
            if (jCharAt <= BufferKt.OVERFLOW_ZONE) {
                if (jCharAt >= BufferKt.OVERFLOW_ZONE) {
                    z3 = z ? true : true;
                }
            }
            if (z3) {
                return new BigInteger(str, 10);
            }
            jCharAt = (jCharAt * 10) + ((long) ('0' - str.charAt(i3)));
        }
        if (z) {
            return (!this.u || jCharAt < -2147483648L) ? Long.valueOf(jCharAt) : Integer.valueOf((int) jCharAt);
        }
        long j2 = -jCharAt;
        return (!this.u || j2 > 2147483647L) ? Long.valueOf(j2) : Integer.valueOf((int) j2);
    }

    public abstract void e();

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (r5 == ':') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (r5 == ']') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        if (r5 == '}') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        if (r4 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        if (r7.p == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        throw new i.a.b.k.g(r7.f6378k, 0, java.lang.Character.valueOf(r7.f6373f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
    
        return r8.convert(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
    
        throw new i.a.b.k.g(r7.f6378k, 0, java.lang.Character.valueOf(r7.f6373f));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T f(i.a.b.m.k<T> r8) throws i.a.b.k.g {
        /*
            r7 = this;
            java.lang.Object r0 = r8.createArray()
            char r1 = r7.f6373f
            r2 = 91
            if (r1 != r2) goto Lad
            r7.e()
            char r1 = r7.f6373f
            r2 = 44
            r3 = 0
            if (r1 != r2) goto L27
            boolean r1 = r7.p
            if (r1 == 0) goto L19
            goto L27
        L19:
            i.a.b.k.g r8 = new i.a.b.k.g
            int r0 = r7.f6378k
            char r1 = r7.f6373f
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L27:
            r1 = 1
        L28:
            r4 = 0
        L29:
            char r5 = r7.f6373f
            r6 = 9
            if (r5 == r6) goto La8
            r6 = 10
            if (r5 == r6) goto La8
            r6 = 13
            if (r5 == r6) goto La8
            r6 = 26
            if (r5 == r6) goto L9c
            r6 = 32
            if (r5 == r6) goto La8
            if (r5 == r2) goto L82
            r6 = 58
            if (r5 == r6) goto L74
            r6 = 93
            if (r5 == r6) goto L57
            r4 = 125(0x7d, float:1.75E-43)
            if (r5 == r4) goto L74
            boolean[] r4 = i.a.b.k.b.f6369b
            java.lang.Object r4 = r7.h(r8, r4)
            r8.addValue(r0, r4)
            goto L28
        L57:
            if (r4 == 0) goto L6c
            boolean r1 = r7.p
            if (r1 == 0) goto L5e
            goto L6c
        L5e:
            i.a.b.k.g r8 = new i.a.b.k.g
            int r0 = r7.f6378k
            char r1 = r7.f6373f
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L6c:
            r7.e()
            java.lang.Object r8 = r8.convert(r0)
            return r8
        L74:
            i.a.b.k.g r8 = new i.a.b.k.g
            int r0 = r7.f6378k
            char r1 = r7.f6373f
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L82:
            if (r4 == 0) goto L97
            boolean r4 = r7.p
            if (r4 == 0) goto L89
            goto L97
        L89:
            i.a.b.k.g r8 = new i.a.b.k.g
            int r0 = r7.f6378k
            char r1 = r7.f6373f
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L97:
            r7.e()
            r4 = 1
            goto L29
        L9c:
            i.a.b.k.g r8 = new i.a.b.k.g
            int r0 = r7.f6378k
            int r0 = r0 - r1
            r1 = 3
            java.lang.String r2 = "EOF"
            r8.<init>(r0, r1, r2)
            throw r8
        La8:
            r7.e()
            goto L29
        Lad:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.b.k.b.f(i.a.b.m.k):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ba, code lost:
    
        throw new i.a.b.k.g(r3.f6378k, 0, java.lang.Character.valueOf(r3.f6373f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fd, code lost:
    
        r0 = k(i.a.b.k.b.f6372e);
        r3.f6376i = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0109, code lost:
    
        return r4.convert(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T g(i.a.b.m.k<T> r4) throws i.a.b.k.g {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.b.k.b.g(i.a.b.m.k):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00da, code lost:
    
        throw new i.a.b.k.g(r2.f6378k, 0, java.lang.Character.valueOf(r2.f6373f));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(i.a.b.m.k<?> r3, boolean[] r4) throws i.a.b.k.g {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.b.k.b.h(i.a.b.m.k, boolean[]):java.lang.Object");
    }

    public abstract void i(boolean[] zArr);

    public abstract void j();

    public abstract Object k(boolean[] zArr);

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:
    
        throw new i.a.b.k.g(r12.f6378k, 0, java.lang.Character.valueOf(r12.f6373f));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T l(i.a.b.m.k<T> r13) throws i.a.b.k.g {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.b.k.b.l(i.a.b.m.k):java.lang.Object");
    }

    public abstract void m();

    public abstract void n();

    public void o() throws g {
        char c2 = this.f6373f;
        while (true) {
            e();
            char c3 = this.f6373f;
            if (c3 == '\"' || c3 == '\'') {
                if (c2 == c3) {
                    e();
                    this.f6377j = this.f6375h.toString();
                    return;
                }
                this.f6375h.a(c3);
            } else if (c3 == '\\') {
                e();
                char c4 = this.f6373f;
                if (c4 == '\"') {
                    this.f6375h.a('\"');
                } else if (c4 == '\'') {
                    this.f6375h.a('\'');
                } else if (c4 == '/') {
                    this.f6375h.a(Attributes.InternalPrefix);
                } else if (c4 == '\\') {
                    this.f6375h.a('\\');
                } else if (c4 == 'b') {
                    this.f6375h.a('\b');
                } else if (c4 == 'f') {
                    this.f6375h.a('\f');
                } else if (c4 == 'n') {
                    this.f6375h.a('\n');
                } else if (c4 == 'r') {
                    this.f6375h.a('\r');
                } else if (c4 == 'x') {
                    this.f6375h.a(p(2));
                } else if (c4 == 't') {
                    this.f6375h.a('\t');
                } else if (c4 == 'u') {
                    this.f6375h.a(p(4));
                }
            } else if (c3 != 127) {
                switch (c3) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                        if (!this.s) {
                            throw new g(this.f6378k, 0, Character.valueOf(this.f6373f));
                        }
                        continue;
                        break;
                    case 26:
                        throw new g(this.f6378k - 1, 3, null);
                }
                this.f6375h.a(c3);
            } else if (this.s) {
                continue;
            } else {
                if (this.v) {
                    throw new g(this.f6378k, 0, Character.valueOf(this.f6373f));
                }
                this.f6375h.a(c3);
            }
        }
    }

    public char p(int i2) throws g {
        int i3;
        int i4;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = i5 * 16;
            e();
            char c2 = this.f6373f;
            if (c2 > '9' || c2 < '0') {
                if (c2 <= 'F' && c2 >= 'A') {
                    i3 = c2 - 'A';
                } else {
                    if (c2 < 'a' || c2 > 'f') {
                        if (c2 == 26) {
                            throw new g(this.f6378k, 3, "EOF");
                        }
                        throw new g(this.f6378k, 4, Character.valueOf(this.f6373f));
                    }
                    i3 = c2 - 'a';
                }
                i4 = i3 + 10;
            } else {
                i4 = c2 - '0';
            }
            i5 = i4 + i7;
        }
        return (char) i5;
    }

    public void q() {
        while (true) {
            char c2 = this.f6373f;
            if (c2 < '0' || c2 > '9') {
                return;
            } else {
                m();
            }
        }
    }

    public void r(boolean[] zArr) {
        while (true) {
            char c2 = this.f6373f;
            if (c2 == 26) {
                return;
            }
            if (c2 >= 0 && c2 < '~' && zArr[c2]) {
                return;
            } else {
                m();
            }
        }
    }

    public void s() {
        while (true) {
            char c2 = this.f6373f;
            if (c2 > ' ' || c2 == 26) {
                return;
            } else {
                m();
            }
        }
    }
}
