package k.a.a.a.k0;

/* JADX INFO: compiled from: LexerIndexedCustomAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements d0 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f8437b;

    public i0(int i2, d0 d0Var) {
        this.a = i2;
        this.f8437b = d0Var;
    }

    @Override // k.a.a.a.k0.d0
    public boolean a() {
        return true;
    }

    @Override // k.a.a.a.k0.d0
    public void b(k.a.a.a.s sVar) {
        this.f8437b.b(sVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.a == i0Var.a && this.f8437b.equals(i0Var.f8437b);
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.Y5(c.b.a.m.f.X5(0, this.a), this.f8437b), 2);
    }
}
