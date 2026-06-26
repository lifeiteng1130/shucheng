package c.e.c.y;

/* JADX INFO: compiled from: EAN8Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f1458h = new int[4];

    @Override // c.e.c.y.p
    public int k(c.e.c.v.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f1458h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f1375b;
        int i3 = iArr[1];
        for (int i4 = 0; i4 < 4 && i3 < i2; i4++) {
            sb.append((char) (p.i(aVar, iArr2, i3, p.f1471c) + 48));
            for (int i5 : iArr2) {
                i3 += i5;
            }
        }
        int[] iArr3 = p.f1470b;
        int i6 = p.m(aVar, i3, true, iArr3, new int[iArr3.length])[1];
        for (int i7 = 0; i7 < 4 && i6 < i2; i7++) {
            sb.append((char) (p.i(aVar, iArr2, i6, p.f1471c) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // c.e.c.y.p
    public c.e.c.a o() {
        return c.e.c.a.EAN_8;
    }
}
