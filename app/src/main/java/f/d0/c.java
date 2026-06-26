package f.d0;

import f.c0.c.f;
import f.c0.c.j;
import java.io.Serializable;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public abstract class c {

    @NotNull
    public static final a Default = new a(null);
    public static final c a = f.a0.b.a.b();

    /* JADX INFO: compiled from: Random.kt */
    public static final class a extends c implements Serializable {

        /* JADX INFO: renamed from: f.d0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Random.kt */
        public static final class C0177a implements Serializable {

            @NotNull
            public static final C0177a INSTANCE = new C0177a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return c.Default;
            }
        }

        public a() {
        }

        private final Object writeReplace() {
            return C0177a.INSTANCE;
        }

        @Override // f.d0.c
        public int nextBits(int i2) {
            return c.a.nextBits(i2);
        }

        @Override // f.d0.c
        public boolean nextBoolean() {
            return c.a.nextBoolean();
        }

        @Override // f.d0.c
        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr) {
            j.e(bArr, "array");
            return c.a.nextBytes(bArr);
        }

        @Override // f.d0.c
        public double nextDouble() {
            return c.a.nextDouble();
        }

        @Override // f.d0.c
        public float nextFloat() {
            return c.a.nextFloat();
        }

        @Override // f.d0.c
        public int nextInt() {
            return c.a.nextInt();
        }

        @Override // f.d0.c
        public long nextLong() {
            return c.a.nextLong();
        }

        public a(f fVar) {
        }

        @Override // f.d0.c
        @NotNull
        public byte[] nextBytes(int i2) {
            return c.a.nextBytes(i2);
        }

        @Override // f.d0.c
        public double nextDouble(double d2) {
            return c.a.nextDouble(d2);
        }

        @Override // f.d0.c
        public int nextInt(int i2) {
            return c.a.nextInt(i2);
        }

        @Override // f.d0.c
        public long nextLong(long j2) {
            return c.a.nextLong(j2);
        }

        @Override // f.d0.c
        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr, int i2, int i3) {
            j.e(bArr, "array");
            return c.a.nextBytes(bArr, i2, i3);
        }

        @Override // f.d0.c
        public double nextDouble(double d2, double d3) {
            return c.a.nextDouble(d2, d3);
        }

        @Override // f.d0.c
        public int nextInt(int i2, int i3) {
            return c.a.nextInt(i2, i3);
        }

        @Override // f.d0.c
        public long nextLong(long j2, long j3) {
            return c.a.nextLong(j2, j3);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(c cVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return cVar.nextBytes(bArr, i2, i3);
    }

    public abstract int nextBits(int i2);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] nextBytes(@org.jetbrains.annotations.NotNull byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "array"
            f.c0.c.j.e(r7, r0)
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r8 >= 0) goto Lb
            goto L15
        Lb:
            if (r0 < r8) goto L15
            int r0 = r7.length
            if (r9 >= 0) goto L11
            goto L15
        L11:
            if (r0 < r9) goto L15
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            java.lang.String r3 = "fromIndex ("
            if (r0 == 0) goto L84
            if (r8 > r9) goto L1d
            goto L1e
        L1d:
            r2 = 0
        L1e:
            if (r2 == 0) goto L5e
            int r0 = r9 - r8
            int r0 = r0 / 4
            r2 = 0
        L25:
            if (r2 >= r0) goto L48
            int r3 = r6.nextInt()
            byte r4 = (byte) r3
            r7[r8] = r4
            int r4 = r8 + 1
            int r5 = r3 >>> 8
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 2
            int r5 = r3 >>> 16
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 3
            int r3 = r3 >>> 24
            byte r3 = (byte) r3
            r7[r4] = r3
            int r8 = r8 + 4
            int r2 = r2 + 1
            goto L25
        L48:
            int r9 = r9 - r8
            int r0 = r9 * 8
            int r0 = r6.nextBits(r0)
        L4f:
            if (r1 >= r9) goto L5d
            int r2 = r8 + r1
            int r3 = r1 * 8
            int r3 = r0 >>> r3
            byte r3 = (byte) r3
            r7[r2] = r3
            int r1 = r1 + 1
            goto L4f
        L5d:
            return r7
        L5e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = ") must be not greater than toIndex ("
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = ")."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L84:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = ") or toIndex ("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ") are out of range: 0.."
            r0.append(r8)
            int r7 = r7.length
            r8 = 46
            java.lang.String r7 = c.a.a.a.a.n(r0, r7, r8)
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f.d0.c.nextBytes(byte[], int, int):byte[]");
    }

    public double nextDouble() {
        return ((((long) nextBits(26)) << 27) + ((long) nextBits(27))) / 9007199254740992L;
    }

    public float nextFloat() {
        return nextBits(24) / 16777216;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d2) {
        return nextDouble(0.0d, d2);
    }

    public int nextInt(int i2) {
        return nextInt(0, i2);
    }

    public long nextLong(long j2) {
        return nextLong(0L, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r2 <= 0) goto L8
            r2 = 1
            goto L9
        L8:
            r2 = 0
        L9:
            if (r2 == 0) goto L56
            double r2 = r9 - r7
            boolean r4 = java.lang.Double.isInfinite(r2)
            if (r4 == 0) goto L44
            boolean r4 = java.lang.Double.isInfinite(r7)
            if (r4 != 0) goto L21
            boolean r4 = java.lang.Double.isNaN(r7)
            if (r4 != 0) goto L21
            r4 = 1
            goto L22
        L21:
            r4 = 0
        L22:
            if (r4 == 0) goto L44
            boolean r4 = java.lang.Double.isInfinite(r9)
            if (r4 != 0) goto L31
            boolean r4 = java.lang.Double.isNaN(r9)
            if (r4 != 0) goto L31
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L44
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r4 = r4 * r0
            double r7 = r7 + r4
            double r7 = r7 + r4
            goto L4b
        L44:
            double r0 = r6.nextDouble()
            double r0 = r0 * r2
            double r7 = r7 + r0
        L4b:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L55
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L55:
            return r7
        L56:
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            java.lang.Double r8 = java.lang.Double.valueOf(r9)
            java.lang.String r7 = c.b.a.m.f.D0(r7, r8)
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f.d0.c.nextDouble(double, double):double");
    }

    public int nextInt(int i2, int i3) {
        int iNextInt;
        int i4;
        int iNextBits;
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(c.b.a.m.f.D0(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
        int i5 = i3 - i2;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                iNextBits = nextBits(c.b.a.m.f.H1(i5));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i4 = iNextInt % i5;
                } while ((i5 - 1) + (iNextInt - i4) < 0);
                iNextBits = i4;
            }
            return i2 + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i2 <= iNextInt2 && i3 > iNextInt2) {
                return iNextInt2;
            }
        }
    }

    public long nextLong(long j2, long j3) {
        long jNextLong;
        long j4;
        long jNextBits;
        int iNextInt;
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(c.b.a.m.f.D0(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
        long j5 = j3 - j2;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i2 = (int) j5;
                int i3 = (int) (j5 >>> 32);
                if (i2 != 0) {
                    iNextInt = nextBits(c.b.a.m.f.H1(i2));
                } else if (i3 == 1) {
                    iNextInt = nextInt();
                } else {
                    jNextBits = (((long) nextBits(c.b.a.m.f.H1(i3))) << 32) + ((long) nextInt());
                }
                jNextBits = ((long) iNextInt) & 4294967295L;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j4 = jNextLong % j5;
                } while ((j5 - 1) + (jNextLong - j4) < 0);
                jNextBits = j4;
            }
            return j2 + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (j2 <= jNextLong2 && j3 > jNextLong2) {
                return jNextLong2;
            }
        }
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        j.e(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    @NotNull
    public byte[] nextBytes(int i2) {
        return nextBytes(new byte[i2]);
    }
}
