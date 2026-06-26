package k.a.a.a.k0;

/* JADX INFO: compiled from: LexerCustomAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements d0 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8425b;

    public h0(int i2, int i3) {
        this.a = i2;
        this.f8425b = i3;
    }

    @Override // k.a.a.a.k0.d0
    public boolean a() {
        return true;
    }

    @Override // k.a.a.a.k0.d0
    public void b(k.a.a.a.s sVar) {
        sVar.action(null, this.a, this.f8425b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.a == h0Var.a && this.f8425b == h0Var.f8425b;
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.X5(c.b.a.m.f.X5(c.b.a.m.f.X5(0, f0.CUSTOM.ordinal()), this.a), this.f8425b), 3);
    }
}
