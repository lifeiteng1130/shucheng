package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: DecodedNumeric.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1515c;

    public p(int i2, int i3, int i4) throws c.e.c.g {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw c.e.c.g.getFormatInstance();
        }
        this.f1514b = i3;
        this.f1515c = i4;
    }
}
