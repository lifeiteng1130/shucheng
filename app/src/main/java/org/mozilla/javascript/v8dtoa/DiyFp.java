package org.mozilla.javascript.v8dtoa;

import c.a.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class DiyFp {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int kSignificandSize = 64;
    public static final long kUint64MSB = Long.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8942f;

    public DiyFp() {
        this.f8942f = 0L;
        this.f8941e = 0;
    }

    public static DiyFp minus(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f8942f, diyFp.f8941e);
        diyFp3.subtract(diyFp2);
        return diyFp3;
    }

    public static DiyFp times(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f8942f, diyFp.f8941e);
        diyFp3.multiply(diyFp2);
        return diyFp3;
    }

    private static boolean uint64_gte(long j2, long j3) {
        if (j2 != j3) {
            if (!(((j2 < 0) ^ (j2 > j3)) ^ (j3 < 0))) {
                return false;
            }
        }
        return true;
    }

    public int e() {
        return this.f8941e;
    }

    public long f() {
        return this.f8942f;
    }

    public void multiply(DiyFp diyFp) {
        long j2 = this.f8942f;
        long j3 = j2 >>> 32;
        long j4 = j2 & 4294967295L;
        long j5 = diyFp.f8942f;
        long j6 = j5 >>> 32;
        long j7 = j5 & 4294967295L;
        long j8 = j3 * j6;
        long j9 = j6 * j4;
        long j10 = j3 * j7;
        long j11 = j8 + (j10 >>> 32) + (j9 >>> 32) + ((((((j4 * j7) >>> 32) + (j10 & 4294967295L)) + (4294967295L & j9)) + 2147483648L) >>> 32);
        this.f8941e = diyFp.f8941e + 64 + this.f8941e;
        this.f8942f = j11;
    }

    public void normalize() {
        long j2 = this.f8942f;
        int i2 = this.f8941e;
        while (((-18014398509481984L) & j2) == 0) {
            j2 <<= 10;
            i2 -= 10;
        }
        while ((Long.MIN_VALUE & j2) == 0) {
            j2 <<= 1;
            i2--;
        }
        this.f8942f = j2;
        this.f8941e = i2;
    }

    public void setE(int i2) {
        this.f8941e = i2;
    }

    public void setF(long j2) {
        this.f8942f = j2;
    }

    public void subtract(DiyFp diyFp) {
        this.f8942f -= diyFp.f8942f;
    }

    public String toString() {
        StringBuilder sbR = a.r("[DiyFp f:");
        sbR.append(this.f8942f);
        sbR.append(", e:");
        return a.o(sbR, this.f8941e, "]");
    }

    public DiyFp(long j2, int i2) {
        this.f8942f = j2;
        this.f8941e = i2;
    }

    public static DiyFp normalize(DiyFp diyFp) {
        DiyFp diyFp2 = new DiyFp(diyFp.f8942f, diyFp.f8941e);
        diyFp2.normalize();
        return diyFp2;
    }
}
