package com.umeng.analytics.pro;

import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes.dex */
public class bi extends bp {
    public static final int a = -65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4728b = -2147418112;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bu f4729h = new bu();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4733f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f4734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f4735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f4736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f4737l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements br {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4739c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.br
        public bp a(cd cdVar) {
            bi biVar = new bi(cdVar, this.a, this.f4738b);
            int i2 = this.f4739c;
            if (i2 != 0) {
                biVar.c(i2);
            }
            return biVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.a = false;
            this.f4738b = true;
            this.a = z;
            this.f4738b = z2;
            this.f4739c = i2;
        }
    }

    public bi(cd cdVar) {
        this(cdVar, false, true);
    }

    @Override // com.umeng.analytics.pro.bp
    public ByteBuffer A() throws bq, ce {
        int iW = w();
        d(iW);
        if (this.f4771g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f4771g.f(), this.f4771g.g(), iW);
            this.f4771g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.f4771g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bn bnVar) throws aw {
        if (this.f4731d) {
            a((-2147418112) | bnVar.f4766b);
            a(bnVar.a);
            a(bnVar.f4767c);
        } else {
            a(bnVar.a);
            a(bnVar.f4766b);
            a(bnVar.f4767c);
        }
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bu buVar) {
    }

    public String b(int i2) throws aw {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.f4771g.d(bArr, 0, i2);
            return new String(bArr, DataUtil.defaultCharset);
        } catch (UnsupportedEncodingException unused) {
            throw new aw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bp
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bp
    public void c() {
    }

    public void c(int i2) {
        this.f4732e = i2;
        this.f4733f = true;
    }

    @Override // com.umeng.analytics.pro.bp
    public void d() {
        a((byte) 0);
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
    public bn h() throws bq {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) == -2147418112) {
                return new bn(z(), (byte) (iW & 255), w());
            }
            throw new bq(4, "Bad version in readMessageBegin");
        }
        if (this.f4730c) {
            throw new bq(4, "Missing version in readMessageBegin, old client?");
        }
        return new bn(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.bp
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bu j() {
        return f4729h;
    }

    @Override // com.umeng.analytics.pro.bp
    public void k() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bk l() throws bq {
        byte bU = u();
        return new bk("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.bp
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bm n() {
        return new bm(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.bp
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bl p() {
        return new bl(u(), w());
    }

    @Override // com.umeng.analytics.pro.bp
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bp
    public bt r() {
        return new bt(u(), w());
    }

    @Override // com.umeng.analytics.pro.bp
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bp
    public boolean t() {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.bp
    public byte u() throws bq {
        if (this.f4771g.h() < 1) {
            a(this.m, 0, 1);
            return this.m[0];
        }
        byte b2 = this.f4771g.f()[this.f4771g.g()];
        this.f4771g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.bp
    public short v() throws bq {
        byte[] bArrF = this.n;
        int iG = 0;
        if (this.f4771g.h() >= 2) {
            bArrF = this.f4771g.f();
            iG = this.f4771g.g();
            this.f4771g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & ExifInterface.MARKER) | ((bArrF[iG] & ExifInterface.MARKER) << 8));
    }

    @Override // com.umeng.analytics.pro.bp
    public int w() throws bq {
        byte[] bArrF = this.o;
        int iG = 0;
        if (this.f4771g.h() >= 4) {
            bArrF = this.f4771g.f();
            iG = this.f4771g.g();
            this.f4771g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArrF[iG + 3] & ExifInterface.MARKER) | ((bArrF[iG] & ExifInterface.MARKER) << 24) | ((bArrF[iG + 1] & ExifInterface.MARKER) << 16) | ((bArrF[iG + 2] & ExifInterface.MARKER) << 8);
    }

    @Override // com.umeng.analytics.pro.bp
    public long x() throws bq {
        byte[] bArrF = this.p;
        int iG = 0;
        if (this.f4771g.h() >= 8) {
            bArrF = this.f4771g.f();
            iG = this.f4771g.g();
            this.f4771g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return ((long) (bArrF[iG + 7] & ExifInterface.MARKER)) | (((long) (bArrF[iG] & ExifInterface.MARKER)) << 56) | (((long) (bArrF[iG + 1] & ExifInterface.MARKER)) << 48) | (((long) (bArrF[iG + 2] & ExifInterface.MARKER)) << 40) | (((long) (bArrF[iG + 3] & ExifInterface.MARKER)) << 32) | (((long) (bArrF[iG + 4] & ExifInterface.MARKER)) << 24) | (((long) (bArrF[iG + 5] & ExifInterface.MARKER)) << 16) | (((long) (bArrF[iG + 6] & ExifInterface.MARKER)) << 8);
    }

    @Override // com.umeng.analytics.pro.bp
    public double y() {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.bp
    public String z() throws aw {
        int iW = w();
        if (this.f4771g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.f4771g.f(), this.f4771g.g(), iW, DataUtil.defaultCharset);
            this.f4771g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new aw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public bi(cd cdVar, boolean z, boolean z2) {
        super(cdVar);
        this.f4730c = false;
        this.f4731d = true;
        this.f4733f = false;
        this.f4734i = new byte[1];
        this.f4735j = new byte[2];
        this.f4736k = new byte[4];
        this.f4737l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f4730c = z;
        this.f4731d = z2;
    }

    public void d(int i2) throws bq {
        if (i2 < 0) {
            throw new bq(c.a.a.a.a.G("Negative length: ", i2));
        }
        if (this.f4733f) {
            int i3 = this.f4732e - i2;
            this.f4732e = i3;
            if (i3 < 0) {
                throw new bq(c.a.a.a.a.G("Message length exceeded: ", i2));
            }
        }
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bk bkVar) {
        a(bkVar.f4761b);
        a(bkVar.f4762c);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bm bmVar) {
        a(bmVar.a);
        a(bmVar.f4764b);
        a(bmVar.f4765c);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bl blVar) {
        a(blVar.a);
        a(blVar.f4763b);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(bt btVar) {
        a(btVar.a);
        a(btVar.f4779b);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(byte b2) {
        byte[] bArr = this.f4734i;
        bArr[0] = b2;
        this.f4771g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(short s) {
        byte[] bArr = this.f4735j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f4771g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(int i2) {
        byte[] bArr = this.f4736k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f4771g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(long j2) {
        byte[] bArr = this.f4737l;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f4771g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(double d2) {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(String str) throws aw {
        try {
            byte[] bytes = str.getBytes(DataUtil.defaultCharset);
            a(bytes.length);
            this.f4771g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new aw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bp
    public void a(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.f4771g.b(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), iLimit);
    }

    private int a(byte[] bArr, int i2, int i3) throws bq {
        d(i3);
        return this.f4771g.d(bArr, i2, i3);
    }
}
