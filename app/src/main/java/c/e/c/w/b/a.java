package c.e.c.w.b;

import c.e.c.g;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.e.c.v.b f1424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f1425c;

    public a(c.e.c.v.b bVar) throws g {
        int i2;
        int i3 = bVar.f1376b;
        if (i3 < 8 || i3 > 144 || (i3 & 1) != 0) {
            throw g.getFormatInstance();
        }
        int i4 = bVar.a;
        e[] eVarArr = e.a;
        if ((i3 & 1) != 0 || (i4 & 1) != 0) {
            throw g.getFormatInstance();
        }
        for (e eVar : e.a) {
            int i5 = eVar.f1432c;
            if (i5 == i3 && (i2 = eVar.f1433d) == i4) {
                this.f1425c = eVar;
                if (bVar.f1376b != i5) {
                    throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
                }
                int i6 = eVar.f1434e;
                int i7 = eVar.f1435f;
                int i8 = i5 / i6;
                int i9 = i2 / i7;
                c.e.c.v.b bVar2 = new c.e.c.v.b(i9 * i7, i8 * i6);
                for (int i10 = 0; i10 < i8; i10++) {
                    int i11 = i10 * i6;
                    for (int i12 = 0; i12 < i9; i12++) {
                        int i13 = i12 * i7;
                        for (int i14 = 0; i14 < i6; i14++) {
                            int i15 = ((i6 + 2) * i10) + 1 + i14;
                            int i16 = i11 + i14;
                            for (int i17 = 0; i17 < i7; i17++) {
                                if (bVar.b(((i7 + 2) * i12) + 1 + i17, i15)) {
                                    bVar2.f(i13 + i17, i16);
                                }
                            }
                        }
                    }
                }
                this.a = bVar2;
                this.f1424b = new c.e.c.v.b(bVar2.a, bVar2.f1376b);
                return;
            }
        }
        throw g.getFormatInstance();
    }

    public final boolean a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f1424b.f(i3, i2);
        return this.a.b(i3, i2);
    }

    public final int b(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (a(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (a(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (a(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (a(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return a(i2, i3, i4, i5) ? i16 | 1 : i16;
    }
}
