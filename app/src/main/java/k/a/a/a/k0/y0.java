package k.a.a.a.k0;

/* JADX INFO: compiled from: PredicateTransition.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8479e;

    public y0(i iVar, int i2, int i3, boolean z) {
        super(iVar);
        this.f8477c = i2;
        this.f8478d = i3;
        this.f8479e = z;
    }

    @Override // k.a.a.a.k0.o1
    public int a() {
        return 4;
    }

    @Override // k.a.a.a.k0.o1
    public boolean b() {
        return true;
    }

    @Override // k.a.a.a.k0.o1
    public boolean d(int i2, int i3, int i4) {
        return false;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("pred_");
        sbR.append(this.f8477c);
        sbR.append(":");
        sbR.append(this.f8478d);
        return sbR.toString();
    }
}
