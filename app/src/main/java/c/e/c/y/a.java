package c.e.c.y;

/* JADX INFO: compiled from: CodaBarReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends k {
    public static final char[] a = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1444b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f1445c = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f1446d = new StringBuilder(20);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f1447e = new int[80];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1448f = 0;

    public static boolean h(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x015c, code lost:
    
        throw c.e.c.k.getNotFoundInstance();
     */
    @Override // c.e.c.y.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.e.c.p c(int r20, c.e.c.v.a r21, java.util.Map<c.e.c.e, ?> r22) throws c.e.c.k {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.y.a.c(int, c.e.c.v.a, java.util.Map):c.e.c.p");
    }

    public final void i(int i2) {
        int[] iArr = this.f1447e;
        int i3 = this.f1448f;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.f1448f = i4;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f1447e = iArr2;
        }
    }

    public final int j(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f1448f) {
            return -1;
        }
        int[] iArr = this.f1447e;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f1444b;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }
}
