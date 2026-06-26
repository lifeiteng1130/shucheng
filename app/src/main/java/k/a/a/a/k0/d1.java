package k.a.a.a.k0;

/* JADX INFO: compiled from: RangeTransition.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends o1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8411d;

    public d1(i iVar, int i2, int i3) {
        super(iVar);
        this.f8410c = i2;
        this.f8411d = i3;
    }

    @Override // k.a.a.a.k0.o1
    public int a() {
        return 2;
    }

    @Override // k.a.a.a.k0.o1
    public k.a.a.a.m0.i c() {
        return k.a.a.a.m0.i.h(this.f8410c, this.f8411d);
    }

    @Override // k.a.a.a.k0.o1
    public boolean d(int i2, int i3, int i4) {
        return i2 >= this.f8410c && i2 <= this.f8411d;
    }

    public String toString() {
        StringBuilder sbAppendCodePoint = new StringBuilder("'").appendCodePoint(this.f8410c);
        sbAppendCodePoint.append("'..'");
        StringBuilder sbAppendCodePoint2 = sbAppendCodePoint.appendCodePoint(this.f8411d);
        sbAppendCodePoint2.append("'");
        return sbAppendCodePoint2.toString();
    }
}
