package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class f extends e {
    public static final byte[] a;
    public a A;
    public b B;
    public int C;
    public c D;
    public int E;
    public c F;
    public i G;
    public i H;
    public p I;
    public p J;
    public boolean K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f8825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m[] f8826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f8828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f8829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f8830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f8831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m[] f8832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short f8833l;
    public int m;
    public int n;
    public String o;
    public int p;
    public int q;
    public int r;
    public int[] s;
    public int t;
    public c u;
    public int v;
    public int w;
    public a x;
    public a y;
    public a z;

    static {
        byte[] bArr = new byte[220];
        for (int i2 = 0; i2 < 220; i2++) {
            bArr[i2] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i2) - 'A');
        }
        a = bArr;
    }

    public f(int i2) {
        super(327680);
        this.f8824c = 1;
        this.f8825d = new c();
        m[] mVarArr = new m[256];
        this.f8826e = mVarArr;
        this.f8827f = (int) (((double) mVarArr.length) * 0.75d);
        this.f8828g = new m();
        this.f8829h = new m();
        this.f8830i = new m();
        this.f8831j = new m();
        this.K = (i2 & 1) != 0;
        this.L = (i2 & 2) != 0;
    }

    @Override // k.e.a.e
    public final void a(int i2, int i3, String str, String str2, String str3, String[] strArr) {
        this.f8823b = i2;
        this.m = i3;
        this.n = l(str).a;
        this.o = str;
        if (str2 != null) {
            this.p = v(str2);
        }
        this.q = str3 == null ? 0 : l(str3).a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.r = length;
        this.s = new int[length];
        for (int i4 = 0; i4 < this.r; i4++) {
            this.s[i4] = t(strArr[i4]);
        }
    }

    @Override // k.e.a.e
    public final a b(String str, boolean z) {
        c cVar = new c();
        cVar.i(v(str));
        cVar.i(0);
        a aVar = new a(this, true, cVar, cVar, 2);
        if (z) {
            aVar.f8814g = this.x;
            this.x = aVar;
        } else {
            aVar.f8814g = this.y;
            this.y = aVar;
        }
        return aVar;
    }

    @Override // k.e.a.e
    public final o c(int i2, String str, String str2, String str3, String[] strArr) {
        return new p(this, i2, str, str2, str3, strArr, this.K, this.L);
    }

    @Override // k.e.a.e
    public final a d(int i2, s sVar, String str, boolean z) {
        c cVar = new c();
        a.b(i2, sVar, cVar);
        cVar.i(v(str));
        cVar.i(0);
        a aVar = new a(this, true, cVar, cVar, cVar.f8818b - 2);
        if (z) {
            aVar.f8814g = this.z;
            this.z = aVar;
        } else {
            aVar.f8814g = this.A;
            this.A = aVar;
        }
        return aVar;
    }

    public int e(String str, int i2) {
        m mVar = this.f8828g;
        mVar.f8874b = 31;
        mVar.f8875c = i2;
        mVar.f8877e = str;
        mVar.f8880h = (str.hashCode() + 31 + i2) & Integer.MAX_VALUE;
        m mVarO = o(this.f8828g);
        if (mVarO == null) {
            mVarO = s();
        }
        return mVarO.a;
    }

    public m f(double d2) {
        m mVar = this.f8828g;
        mVar.f8874b = 6;
        mVar.f8876d = Double.doubleToRawLongBits(d2);
        mVar.f8880h = Integer.MAX_VALUE & (mVar.f8874b + ((int) d2));
        m mVarO = o(this.f8828g);
        if (mVarO != null) {
            return mVarO;
        }
        c cVar = this.f8825d;
        cVar.e(6);
        cVar.h(this.f8828g.f8876d);
        m mVar2 = new m(this.f8824c, this.f8828g);
        this.f8824c += 2;
        q(mVar2);
        return mVar2;
    }

    public m g(float f2) {
        m mVar = this.f8828g;
        mVar.f8874b = 4;
        mVar.f8875c = Float.floatToRawIntBits(f2);
        mVar.f8880h = Integer.MAX_VALUE & (mVar.f8874b + ((int) f2));
        m mVarO = o(this.f8828g);
        if (mVarO != null) {
            return mVarO;
        }
        c cVar = this.f8825d;
        cVar.e(4);
        cVar.g(this.f8828g.f8875c);
        int i2 = this.f8824c;
        this.f8824c = i2 + 1;
        m mVar2 = new m(i2, this.f8828g);
        q(mVar2);
        return mVar2;
    }

    public m h(int i2) {
        m mVar = this.f8828g;
        mVar.f8874b = 3;
        mVar.f8875c = i2;
        mVar.f8880h = (i2 + 3) & Integer.MAX_VALUE;
        m mVarO = o(mVar);
        if (mVarO != null) {
            return mVarO;
        }
        c cVar = this.f8825d;
        cVar.e(3);
        cVar.g(i2);
        int i3 = this.f8824c;
        this.f8824c = i3 + 1;
        m mVar2 = new m(i3, this.f8828g);
        q(mVar2);
        return mVar2;
    }

    public m i(int i2, String str, String str2, String str3) {
        int i3;
        this.f8831j.a(i2 + 20, str, str2, str3);
        m mVarO = o(this.f8831j);
        if (mVarO != null) {
            return mVarO;
        }
        if (i2 <= 4) {
            i3 = m(str, str2, str3).a;
        } else {
            i3 = n(str, str2, str3, i2 == 9).a;
        }
        c cVar = this.f8825d;
        cVar.a(15, i2);
        cVar.i(i3);
        int i4 = this.f8824c;
        this.f8824c = i4 + 1;
        m mVar = new m(i4, this.f8831j);
        q(mVar);
        return mVar;
    }

    public m j(long j2) {
        m mVar = this.f8828g;
        mVar.f8874b = 5;
        mVar.f8876d = j2;
        mVar.f8880h = (((int) j2) + 5) & Integer.MAX_VALUE;
        m mVarO = o(mVar);
        if (mVarO != null) {
            return mVarO;
        }
        c cVar = this.f8825d;
        cVar.e(5);
        cVar.h(j2);
        m mVar2 = new m(this.f8824c, this.f8828g);
        this.f8824c += 2;
        q(mVar2);
        return mVar2;
    }

    public m k(Object obj) {
        if (obj instanceof Integer) {
            return h(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return h(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return h(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return h(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return h(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return g(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return j(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return f(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            this.f8829h.a(8, str, null, null);
            m mVarO = o(this.f8829h);
            if (mVarO != null) {
                return mVarO;
            }
            this.f8825d.c(8, v(str));
            int i2 = this.f8824c;
            this.f8824c = i2 + 1;
            m mVar = new m(i2, this.f8829h);
            q(mVar);
            return mVar;
        }
        if (!(obj instanceof r)) {
            if (obj instanceof k) {
                k kVar = (k) obj;
                return i(kVar.a, kVar.f8866b, kVar.f8867c, kVar.f8868d);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("value ");
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        r rVar = (r) obj;
        int i3 = rVar.f8917j;
        if (i3 == 10) {
            return l(new String(rVar.f8918k, rVar.f8919l, rVar.m));
        }
        String strE = rVar.e();
        if (i3 != 11) {
            return l(strE);
        }
        this.f8829h.a(16, strE, null, null);
        m mVarO2 = o(this.f8829h);
        if (mVarO2 != null) {
            return mVarO2;
        }
        this.f8825d.c(16, v(strE));
        int i4 = this.f8824c;
        this.f8824c = i4 + 1;
        m mVar2 = new m(i4, this.f8829h);
        q(mVar2);
        return mVar2;
    }

    public m l(String str) {
        this.f8829h.a(7, str, null, null);
        m mVarO = o(this.f8829h);
        if (mVarO != null) {
            return mVarO;
        }
        this.f8825d.c(7, v(str));
        int i2 = this.f8824c;
        this.f8824c = i2 + 1;
        m mVar = new m(i2, this.f8829h);
        q(mVar);
        return mVar;
    }

    public m m(String str, String str2, String str3) {
        this.f8830i.a(9, str, str2, str3);
        m mVarO = o(this.f8830i);
        if (mVarO != null) {
            return mVarO;
        }
        p(9, l(str).a, u(str2, str3));
        int i2 = this.f8824c;
        this.f8824c = i2 + 1;
        m mVar = new m(i2, this.f8830i);
        q(mVar);
        return mVar;
    }

    public m n(String str, String str2, String str3, boolean z) {
        int i2 = z ? 11 : 10;
        this.f8830i.a(i2, str, str2, str3);
        m mVarO = o(this.f8830i);
        if (mVarO != null) {
            return mVarO;
        }
        p(i2, l(str).a, u(str2, str3));
        int i3 = this.f8824c;
        this.f8824c = i3 + 1;
        m mVar = new m(i3, this.f8830i);
        q(mVar);
        return mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k.e.a.m o(k.e.a.m r9) {
        /*
            r8 = this;
            k.e.a.m[] r0 = r8.f8826e
            int r1 = r9.f8880h
            int r2 = r0.length
            int r1 = r1 % r2
            r0 = r0[r1]
        L8:
            if (r0 == 0) goto La8
            int r1 = r0.f8874b
            int r2 = r9.f8874b
            if (r1 != r2) goto La4
            r1 = 1
            if (r2 == r1) goto L9a
            r3 = 12
            r4 = 0
            if (r2 == r3) goto L85
            r3 = 16
            if (r2 == r3) goto L9a
            r3 = 18
            if (r2 == r3) goto L68
            switch(r2) {
                case 3: goto L45;
                case 4: goto L45;
                case 5: goto L4e;
                case 6: goto L4e;
                case 7: goto L9a;
                case 8: goto L9a;
                default: goto L23;
            }
        L23:
            switch(r2) {
                case 30: goto L9a;
                case 31: goto L57;
                case 32: goto L4e;
                default: goto L26;
            }
        L26:
            java.lang.String r2 = r0.f8877e
            java.lang.String r3 = r9.f8877e
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            java.lang.String r2 = r0.f8878f
            java.lang.String r3 = r9.f8878f
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            java.lang.String r2 = r0.f8879g
            java.lang.String r3 = r9.f8879g
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            goto La2
        L45:
            int r2 = r0.f8875c
            int r3 = r9.f8875c
            if (r2 != r3) goto L4c
            goto La2
        L4c:
            r1 = 0
            goto La2
        L4e:
            long r2 = r0.f8876d
            long r5 = r9.f8876d
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L4c
            goto La2
        L57:
            int r2 = r0.f8875c
            int r3 = r9.f8875c
            if (r2 != r3) goto L4c
            java.lang.String r2 = r0.f8877e
            java.lang.String r3 = r9.f8877e
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            goto La2
        L68:
            long r2 = r0.f8876d
            long r5 = r9.f8876d
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L4c
            java.lang.String r2 = r0.f8877e
            java.lang.String r3 = r9.f8877e
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            java.lang.String r2 = r0.f8878f
            java.lang.String r3 = r9.f8878f
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            goto La2
        L85:
            java.lang.String r2 = r0.f8877e
            java.lang.String r3 = r9.f8877e
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            java.lang.String r2 = r0.f8878f
            java.lang.String r3 = r9.f8878f
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L4c
            goto La2
        L9a:
            java.lang.String r1 = r0.f8877e
            java.lang.String r2 = r9.f8877e
            boolean r1 = r1.equals(r2)
        La2:
            if (r1 != 0) goto La8
        La4:
            k.e.a.m r0 = r0.f8881i
            goto L8
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.f.o(k.e.a.m):k.e.a.m");
    }

    public final void p(int i2, int i3, int i4) {
        c cVar = this.f8825d;
        cVar.c(i2, i3);
        cVar.i(i4);
    }

    public final void q(m mVar) {
        if (this.f8824c + this.f8833l > this.f8827f) {
            int length = this.f8826e.length;
            int i2 = (length * 2) + 1;
            m[] mVarArr = new m[i2];
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                m mVar2 = this.f8826e[length];
                while (mVar2 != null) {
                    int i3 = mVar2.f8880h % i2;
                    m mVar3 = mVar2.f8881i;
                    mVar2.f8881i = mVarArr[i3];
                    mVarArr[i3] = mVar2;
                    mVar2 = mVar3;
                }
            }
            this.f8826e = mVarArr;
            this.f8827f = (int) (((double) i2) * 0.75d);
        }
        int i4 = mVar.f8880h;
        m[] mVarArr2 = this.f8826e;
        int length2 = i4 % mVarArr2.length;
        mVar.f8881i = mVarArr2[length2];
        mVarArr2[length2] = mVar;
    }

    public int r(String str) {
        this.f8828g.a(30, str, null, null);
        m mVarO = o(this.f8828g);
        if (mVarO == null) {
            mVarO = s();
        }
        return mVarO.a;
    }

    public final m s() {
        short s = (short) (this.f8833l + 1);
        this.f8833l = s;
        m mVar = new m(s, this.f8828g);
        q(mVar);
        if (this.f8832k == null) {
            this.f8832k = new m[16];
        }
        short s2 = this.f8833l;
        m[] mVarArr = this.f8832k;
        if (s2 == mVarArr.length) {
            m[] mVarArr2 = new m[mVarArr.length * 2];
            System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            this.f8832k = mVarArr2;
        }
        this.f8832k[this.f8833l] = mVar;
        return mVar;
    }

    public int t(String str) {
        return l(str).a;
    }

    public int u(String str, String str2) {
        this.f8829h.a(12, str, str2, null);
        m mVarO = o(this.f8829h);
        if (mVarO == null) {
            p(12, v(str), v(str2));
            int i2 = this.f8824c;
            this.f8824c = i2 + 1;
            mVarO = new m(i2, this.f8829h);
            q(mVarO);
        }
        return mVarO.a;
    }

    public int v(String str) {
        this.f8828g.a(1, str, null, null);
        m mVarO = o(this.f8828g);
        if (mVarO == null) {
            c cVar = this.f8825d;
            cVar.e(1);
            int length = str.length();
            if (length > 65535) {
                throw new IllegalArgumentException();
            }
            int i2 = cVar.f8818b;
            if (i2 + 2 + length > cVar.a.length) {
                cVar.b(length + 2);
            }
            byte[] bArr = cVar.a;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (length >>> 8);
            int i4 = i3 + 1;
            bArr[i3] = (byte) length;
            int i5 = 0;
            while (i5 < length) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < 1 || cCharAt > 127) {
                    cVar.f8818b = i4;
                    cVar.d(str, i5, 65535);
                    break;
                }
                bArr[i4] = (byte) cCharAt;
                i5++;
                i4++;
            }
            cVar.f8818b = i4;
            int i6 = this.f8824c;
            this.f8824c = i6 + 1;
            mVarO = new m(i6, this.f8828g);
            q(mVarO);
        }
        return mVarO.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:235:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0549 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] w() {
        /*
            Method dump skipped, instruction units count: 1740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.f.w():byte[]");
    }
}
