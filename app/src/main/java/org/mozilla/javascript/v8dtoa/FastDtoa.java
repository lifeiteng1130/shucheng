package org.mozilla.javascript.v8dtoa;

/* JADX INFO: loaded from: classes3.dex */
public class FastDtoa {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int kFastDtoaMaximalLength = 17;
    public static final int kTen4 = 10000;
    public static final int kTen5 = 100000;
    public static final int kTen6 = 1000000;
    public static final int kTen7 = 10000000;
    public static final int kTen8 = 100000000;
    public static final int kTen9 = 1000000000;
    public static final int maximal_target_exponent = -32;
    public static final int minimal_target_exponent = -60;

    public static long biggestPowerTen(int i2, int i3) {
        int i4 = 1000000000;
        int i5 = 1;
        switch (i3) {
            case 30:
            case 31:
            case 32:
                if (1000000000 <= i2) {
                    i5 = 9;
                    break;
                }
            case 27:
            case 28:
            case 29:
                if (100000000 <= i2) {
                    i5 = 8;
                    i4 = kTen8;
                    break;
                }
            case 24:
            case 25:
            case 26:
                if (10000000 <= i2) {
                    i5 = 7;
                    i4 = kTen7;
                    break;
                }
            case 20:
            case 21:
            case 22:
            case 23:
                if (1000000 <= i2) {
                    i5 = 6;
                    i4 = kTen6;
                    break;
                }
            case 17:
            case 18:
            case 19:
                if (100000 <= i2) {
                    i5 = 5;
                    i4 = 100000;
                    break;
                }
            case 14:
            case 15:
            case 16:
                if (10000 <= i2) {
                    i5 = 4;
                    i4 = 10000;
                    break;
                }
            case 10:
            case 11:
            case 12:
            case 13:
                if (1000 <= i2) {
                    i5 = 3;
                    i4 = 1000;
                    break;
                }
            case 7:
            case 8:
            case 9:
                if (100 <= i2) {
                    i5 = 2;
                    i4 = 100;
                    break;
                }
            case 4:
            case 5:
            case 6:
                if (10 <= i2) {
                    i4 = 10;
                    break;
                }
            case 1:
            case 2:
            case 3:
                if (1 <= i2) {
                    i4 = 1;
                    i5 = 0;
                    break;
                }
            case 0:
                i5 = -1;
                i4 = 0;
                break;
            default:
                i4 = 0;
                i5 = 0;
                break;
        }
        return (((long) i4) << 32) | (4294967295L & ((long) i5));
    }

    public static boolean digitGen(DiyFp diyFp, DiyFp diyFp2, DiyFp diyFp3, FastDtoaBuilder fastDtoaBuilder, int i2) {
        DiyFp diyFp4 = new DiyFp(diyFp.f() - 1, diyFp.e());
        DiyFp diyFp5 = new DiyFp(diyFp3.f() + 1, diyFp3.e());
        DiyFp diyFpMinus = DiyFp.minus(diyFp5, diyFp4);
        DiyFp diyFp6 = new DiyFp(1 << (-diyFp2.e()), diyFp2.e());
        int iF = (int) ((diyFp5.f() >>> (-diyFp6.e())) & 4294967295L);
        long jF = diyFp5.f() & (diyFp6.f() - 1);
        long jBiggestPowerTen = biggestPowerTen(iF, 64 - (-diyFp6.e()));
        int i3 = (int) ((jBiggestPowerTen >>> 32) & 4294967295L);
        int i4 = ((int) (jBiggestPowerTen & 4294967295L)) + 1;
        while (i4 > 0) {
            fastDtoaBuilder.append((char) ((iF / i3) + 48));
            iF %= i3;
            i4--;
            long j2 = (((long) iF) << (-diyFp6.e())) + jF;
            if (j2 < diyFpMinus.f()) {
                fastDtoaBuilder.point = (fastDtoaBuilder.end - i2) + i4;
                return roundWeed(fastDtoaBuilder, DiyFp.minus(diyFp5, diyFp2).f(), diyFpMinus.f(), j2, ((long) i3) << (-diyFp6.e()), 1L);
            }
            i3 /= 10;
        }
        long j3 = 1;
        do {
            long j4 = jF * 5;
            j3 *= 5;
            diyFpMinus.setF(diyFpMinus.f() * 5);
            diyFpMinus.setE(diyFpMinus.e() + 1);
            diyFp6.setF(diyFp6.f() >>> 1);
            diyFp6.setE(diyFp6.e() + 1);
            fastDtoaBuilder.append((char) (((int) ((j4 >>> (-diyFp6.e())) & 4294967295L)) + 48));
            jF = j4 & (diyFp6.f() - 1);
            i4--;
        } while (jF >= diyFpMinus.f());
        fastDtoaBuilder.point = (fastDtoaBuilder.end - i2) + i4;
        return roundWeed(fastDtoaBuilder, DiyFp.minus(diyFp5, diyFp2).f() * j3, diyFpMinus.f(), jF, diyFp6.f(), j3);
    }

    public static boolean dtoa(double d2, FastDtoaBuilder fastDtoaBuilder) {
        return grisu3(d2, fastDtoaBuilder);
    }

    public static boolean grisu3(double d2, FastDtoaBuilder fastDtoaBuilder) {
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        DiyFp diyFpAsNormalizedDiyFp = DoubleHelper.asNormalizedDiyFp(jDoubleToLongBits);
        DiyFp diyFp = new DiyFp();
        DiyFp diyFp2 = new DiyFp();
        DoubleHelper.normalizedBoundaries(jDoubleToLongBits, diyFp, diyFp2);
        DiyFp diyFp3 = new DiyFp();
        int cachedPower = CachedPowers.getCachedPower(diyFpAsNormalizedDiyFp.e() + 64, -60, -32, diyFp3);
        return digitGen(DiyFp.times(diyFp, diyFp3), DiyFp.times(diyFpAsNormalizedDiyFp, diyFp3), DiyFp.times(diyFp2, diyFp3), fastDtoaBuilder, cachedPower);
    }

    public static String numberToString(double d2) {
        FastDtoaBuilder fastDtoaBuilder = new FastDtoaBuilder();
        if (numberToString(d2, fastDtoaBuilder)) {
            return fastDtoaBuilder.format();
        }
        return null;
    }

    public static boolean roundWeed(FastDtoaBuilder fastDtoaBuilder, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 - j6;
        long j8 = j2 + j6;
        long j9 = j4;
        while (j9 < j7 && j3 - j9 >= j5) {
            long j10 = j9 + j5;
            if (j10 >= j7 && j7 - j9 < j10 - j7) {
                break;
            }
            fastDtoaBuilder.decreaseLast();
            j9 = j10;
        }
        if (j9 < j8 && j3 - j9 >= j5) {
            long j11 = j9 + j5;
            if (j11 < j8 || j8 - j9 > j11 - j8) {
                return false;
            }
        }
        return 2 * j6 <= j9 && j9 <= j3 - (4 * j6);
    }

    private static boolean uint64_lte(long j2, long j3) {
        if (j2 != j3) {
            if (!(((j2 < 0) ^ (j2 < j3)) ^ (j3 < 0))) {
                return false;
            }
        }
        return true;
    }

    public static boolean numberToString(double d2, FastDtoaBuilder fastDtoaBuilder) {
        fastDtoaBuilder.reset();
        if (d2 < 0.0d) {
            fastDtoaBuilder.append('-');
            d2 = -d2;
        }
        return dtoa(d2, fastDtoaBuilder);
    }
}
