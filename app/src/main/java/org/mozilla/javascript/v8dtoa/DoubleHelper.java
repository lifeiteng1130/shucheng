package org.mozilla.javascript.v8dtoa;

/* JADX INFO: loaded from: classes3.dex */
public class DoubleHelper {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int kDenormalExponent = -1074;
    private static final int kExponentBias = 1075;
    public static final long kExponentMask = 9218868437227405312L;
    public static final long kHiddenBit = 4503599627370496L;
    public static final long kSignMask = Long.MIN_VALUE;
    public static final long kSignificandMask = 4503599627370495L;
    private static final int kSignificandSize = 52;

    public static DiyFp asDiyFp(long j2) {
        return new DiyFp(significand(j2), exponent(j2));
    }

    public static DiyFp asNormalizedDiyFp(long j2) {
        long jSignificand = significand(j2);
        int iExponent = exponent(j2);
        while ((kHiddenBit & jSignificand) == 0) {
            jSignificand <<= 1;
            iExponent--;
        }
        return new DiyFp(jSignificand << 11, iExponent - 11);
    }

    public static int exponent(long j2) {
        return isDenormal(j2) ? kDenormalExponent : ((int) (((j2 & kExponentMask) >>> 52) & 4294967295L)) - 1075;
    }

    public static boolean isDenormal(long j2) {
        return (j2 & kExponentMask) == 0;
    }

    public static boolean isInfinite(long j2) {
        return (j2 & kExponentMask) == kExponentMask && (j2 & kSignificandMask) == 0;
    }

    public static boolean isNan(long j2) {
        return (j2 & kExponentMask) == kExponentMask && (j2 & kSignificandMask) != 0;
    }

    public static boolean isSpecial(long j2) {
        return (j2 & kExponentMask) == kExponentMask;
    }

    public static void normalizedBoundaries(long j2, DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFpAsDiyFp = asDiyFp(j2);
        boolean z = diyFpAsDiyFp.f() == kHiddenBit;
        diyFp2.setF((diyFpAsDiyFp.f() << 1) + 1);
        diyFp2.setE(diyFpAsDiyFp.e() - 1);
        diyFp2.normalize();
        if (!z || diyFpAsDiyFp.e() == kDenormalExponent) {
            diyFp.setF((diyFpAsDiyFp.f() << 1) - 1);
            diyFp.setE(diyFpAsDiyFp.e() - 1);
        } else {
            diyFp.setF((diyFpAsDiyFp.f() << 2) - 1);
            diyFp.setE(diyFpAsDiyFp.e() - 2);
        }
        diyFp.setF(diyFp.f() << (diyFp.e() - diyFp2.e()));
        diyFp.setE(diyFp2.e());
    }

    public static int sign(long j2) {
        return (j2 & Long.MIN_VALUE) == 0 ? 1 : -1;
    }

    public static long significand(long j2) {
        long j3 = kSignificandMask & j2;
        return !isDenormal(j2) ? j3 + kHiddenBit : j3;
    }
}
