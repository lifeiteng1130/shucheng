package c.e.c.y;

/* JADX INFO: compiled from: EAN13Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1456h = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f1457i = new int[4];

    @Override // c.e.c.y.p
    public int k(c.e.c.v.a aVar, int[] iArr, StringBuilder sb) throws c.e.c.k {
        int[] iArr2 = this.f1457i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f1375b;
        int i3 = iArr[1];
        int i4 = 0;
        for (int i5 = 0; i5 < 6 && i3 < i2; i5++) {
            int i6 = p.i(aVar, iArr2, i3, p.f1472d);
            sb.append((char) ((i6 % 10) + 48));
            for (int i7 : iArr2) {
                i3 += i7;
            }
            if (i6 >= 10) {
                i4 |= 1 << (5 - i5);
            }
        }
        for (int i8 = 0; i8 < 10; i8++) {
            if (i4 == f1456h[i8]) {
                sb.insert(0, (char) (i8 + 48));
                int[] iArr3 = p.f1470b;
                int i9 = p.m(aVar, i3, true, iArr3, new int[iArr3.length])[1];
                for (int i10 = 0; i10 < 6 && i9 < i2; i10++) {
                    sb.append((char) (p.i(aVar, iArr2, i9, p.f1471c) + 48));
                    for (int i11 : iArr2) {
                        i9 += i11;
                    }
                }
                return i9;
            }
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    @Override // c.e.c.y.p
    public c.e.c.a o() {
        return c.e.c.a.EAN_13;
    }
}
