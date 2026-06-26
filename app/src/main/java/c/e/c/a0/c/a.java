package c.e.c.a0.c;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f1305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f1306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1307d;

    public a(c.e.c.v.b bVar) throws c.e.c.g {
        int i2 = bVar.f1376b;
        if (i2 < 21 || (i2 & 3) != 1) {
            throw c.e.c.g.getFormatInstance();
        }
        this.a = bVar;
    }

    public final int a(int i2, int i3, int i4) {
        return this.f1307d ? this.a.b(i3, i2) : this.a.b(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    public void b() {
        int i2 = 0;
        while (i2 < this.a.a) {
            int i3 = i2 + 1;
            int i4 = i3;
            while (true) {
                c.e.c.v.b bVar = this.a;
                if (i4 < bVar.f1376b) {
                    if (bVar.b(i2, i4) != this.a.b(i4, i2)) {
                        this.a.a(i4, i2);
                        this.a.a(i2, i4);
                    }
                    i4++;
                }
            }
            i2 = i3;
        }
    }

    public g c() throws c.e.c.g {
        g gVar = this.f1306c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            iA2 = a(i2, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i3 = 5; i3 >= 0; i3--) {
            iA3 = a(8, i3, iA3);
        }
        int i4 = this.a.f1376b;
        int i5 = i4 - 7;
        for (int i6 = i4 - 1; i6 >= i5; i6--) {
            iA = a(8, i6, iA);
        }
        for (int i7 = i4 - 8; i7 < i4; i7++) {
            iA = a(i7, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        if (gVarA == null) {
            gVarA = g.a(iA3 ^ 21522, iA ^ 21522);
        }
        this.f1306c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw c.e.c.g.getFormatInstance();
    }

    public j d() throws c.e.c.g {
        j jVar = this.f1305b;
        if (jVar != null) {
            return jVar;
        }
        int i2 = this.a.f1376b;
        int i3 = (i2 - 17) / 4;
        if (i3 <= 6) {
            return j.d(i3);
        }
        int i4 = i2 - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = i2 - 9; i6 >= i4; i6--) {
                iA2 = a(i6, i5, iA2);
            }
        }
        j jVarB = j.b(iA2);
        if (jVarB != null && jVarB.c() == i2) {
            this.f1305b = jVarB;
            return jVarB;
        }
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = i2 - 9; i8 >= i4; i8--) {
                iA = a(i7, i8, iA);
            }
        }
        j jVarB2 = j.b(iA);
        if (jVarB2 == null || jVarB2.c() != i2) {
            throw c.e.c.g.getFormatInstance();
        }
        this.f1305b = jVarB2;
        return jVarB2;
    }

    public void e() {
        if (this.f1306c == null) {
            return;
        }
        c cVar = c.values()[this.f1306c.f1311c];
        c.e.c.v.b bVar = this.a;
        cVar.unmaskBitMatrix(bVar, bVar.f1376b);
    }
}
