package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes.dex */
public class bj extends bp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final bu f4740d = new bu("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bk f4741e = new bk("", (byte) 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f4742f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte f4743h = -126;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte f4744i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte f4745j = 31;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte f4746k = -32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f4747l = 5;
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f4748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f4749c;
    private ao m;
    private short n;
    private bk o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class b {
        public static final byte a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final byte f4750b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final byte f4751c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final byte f4752d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte f4753e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte f4754f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final byte f4755g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final byte f4756h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final byte f4757i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final byte f4758j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final byte f4759k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final byte f4760l = 12;

        private b() {
        }
    }

    public bj(cd cdVar, long j2) {
        super(cdVar);
        this.m = new ao(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.f4748b = new byte[10];
        this.r = new byte[1];
        this.f4749c = new byte[1];
        this.q = j2;
    }

    private int E() throws ce {
        int i2 = 0;
        if (this.f4771g.h() >= 5) {
            byte[] bArrF = this.f4771g.f();
            int iG = this.f4771g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & 127) << i4;
                if ((b2 & 128) != 128) {
                    this.f4771g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & 127) << i5;
                if ((bU & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws ce {
        int i2 = 0;
        long j2 = 0;
        if (this.f4771g.h() >= 10) {
            byte[] bArrF = this.f4771g.f();
            int iG = this.f4771g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j3 |= ((long) (b2 & 127)) << i3;
                if ((b2 & 128) != 128) {
                    this.f4771g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & 127)) << i2;
                if ((bU & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & bw.m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws ce {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f4771g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bq {
        if (i2 < 0) {
            throw new bq(c.a.a.a.a.G("Negative length: ", i2));
        }
        long j2 = this.q;
        if (j2 != -1 && i2 > j2) {
            throw new bq(c.a.a.a.a.G("Length exceeded max allowed: ", i2));
        }
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bp
    public ByteBuffer A() throws bq, ce {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.f4771g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bp
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bp
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bn bnVar) {
        b(f4743h);
        d(((bnVar.f4766b << 5) & (-32)) | 1);
        b(bnVar.f4767c);
        a(bnVar.a);
    }

    @Override // com.umeng.analytics.pro.bp
    public void b() {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bp
    public void c() {
    }

    @Override // com.umeng.analytics.pro.bp
    public void d() {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bp
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bp
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bp
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bn h() throws bq, ce {
        byte bU = u();
        if (bU != -126) {
            StringBuilder sbR = c.a.a.a.a.r("Expected protocol id ");
            sbR.append(Integer.toHexString(-126));
            sbR.append(" but got ");
            sbR.append(Integer.toHexString(bU));
            throw new bq(sbR.toString());
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & f4745j);
        if (b2 != 1) {
            throw new bq(c.a.a.a.a.G("Expected version 1 but got ", b2));
        }
        int iE = E();
        return new bn(z(), (byte) ((bU2 >> 5) & 3), iE);
    }

    @Override // com.umeng.analytics.pro.bp
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bu j() {
        this.m.a(this.n);
        this.n = (short) 0;
        return f4740d;
    }

    @Override // com.umeng.analytics.pro.bp
    public void k() {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bp
    public bk l() throws ce {
        byte bU = u();
        if (bU == 0) {
            return f4741e;
        }
        short s = (short) ((bU & 240) >> 4);
        short sV = s == 0 ? v() : (short) (this.n + s);
        byte b2 = (byte) (bU & bw.m);
        bk bkVar = new bk("", d(b2), sV);
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bkVar.f4762c;
        return bkVar;
    }

    @Override // com.umeng.analytics.pro.bp
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bm n() throws ce {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new bm(d((byte) (bU >> 4)), d((byte) (bU & bw.m)), iE);
    }

    @Override // com.umeng.analytics.pro.bp
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bl p() throws ce {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new bl(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.bp
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bt r() {
        return new bt(p());
    }

    @Override // com.umeng.analytics.pro.bp
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bp
    public boolean t() {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.bp
    public byte u() throws ce {
        if (this.f4771g.h() <= 0) {
            this.f4771g.d(this.f4749c, 0, 1);
            return this.f4749c[0];
        }
        byte b2 = this.f4771g.f()[this.f4771g.g()];
        this.f4771g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.bp
    public short v() {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bp
    public int w() {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bp
    public long x() {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bp
    public double y() throws ce {
        byte[] bArr = new byte[8];
        this.f4771g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bp
    public String z() {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.f4771g.h() < iE) {
                return new String(e(iE), DataUtil.defaultCharset);
            }
            String str = new String(this.f4771g.f(), this.f4771g.g(), iE, DataUtil.defaultCharset);
            this.f4771g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new aw("UTF-8 not supported!");
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements br {
        private final long a;

        public a() {
            this.a = -1L;
        }

        @Override // com.umeng.analytics.pro.br
        public bp a(cd cdVar) {
            return new bj(cdVar, this.a);
        }

        public a(int i2) {
            this.a = i2;
        }
    }

    private void b(int i2) {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i2;
        this.f4771g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) {
        b((byte) i2);
    }

    private byte d(byte b2) throws bq {
        byte b3 = (byte) (b2 & bw.m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return bw.m;
            case 10:
                return bw.f4790l;
            case 11:
                return bw.f4789k;
            case 12:
                return (byte) 12;
            default:
                throw new bq(c.a.a.a.a.G("don't know what type: ", b3));
        }
    }

    private byte e(byte b2) {
        return f4742f[b2];
    }

    private void b(long j2) {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.f4748b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.f4748b;
        bArr[i2] = (byte) j2;
        this.f4771g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bu buVar) {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bk bkVar) {
        if (bkVar.f4761b == 2) {
            this.o = bkVar;
        } else {
            a(bkVar, (byte) -1);
        }
    }

    private void b(byte b2) {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.f4771g.b(bArr);
    }

    private void a(bk bkVar, byte b2) {
        if (b2 == -1) {
            b2 = e(bkVar.f4761b);
        }
        short s = bkVar.f4762c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(bkVar.f4762c);
        }
        this.n = bkVar.f4762c;
    }

    public bj(cd cdVar) {
        this(cdVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bm bmVar) {
        int i2 = bmVar.f4765c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(bmVar.f4764b) | (e(bmVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bl blVar) {
        a(blVar.a, blVar.f4763b);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bt btVar) {
        a(btVar.a, btVar.f4779b);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(boolean z) {
        bk bkVar = this.o;
        if (bkVar != null) {
            a(bkVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(byte b2) {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(short s) {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(int i2) {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(long j2) {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(double d2) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.f4771g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes(DataUtil.defaultCharset);
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new aw("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), iLimit);
    }

    private void a(byte[] bArr, int i2, int i3) {
        b(i3);
        this.f4771g.b(bArr, i2, i3);
    }

    public void a(byte b2, int i2) {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
