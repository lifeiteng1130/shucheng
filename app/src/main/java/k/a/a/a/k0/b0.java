package k.a.a.a.k0;

/* JADX INFO: compiled from: LexerATNConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0 f8387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8388g;

    public b0(i iVar, int i2, z0 z0Var) {
        super(iVar, i2, z0Var, h1.a);
        this.f8388g = false;
        this.f8387f = null;
    }

    public static boolean e(b0 b0Var, i iVar) {
        return b0Var.f8388g || ((iVar instanceof w) && ((w) iVar).f8474h);
    }

    @Override // k.a.a.a.k0.b
    public boolean a(b bVar) {
        boolean zEquals = true;
        if (this == bVar) {
            return true;
        }
        if (!(bVar instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) bVar;
        if (this.f8388g != b0Var.f8388g) {
            return false;
        }
        e0 e0Var = this.f8387f;
        e0 e0Var2 = b0Var.f8387f;
        if (e0Var != null) {
            zEquals = e0Var.equals(e0Var2);
        } else if (e0Var2 != null) {
            zEquals = false;
        }
        if (zEquals) {
            return super.a(bVar);
        }
        return false;
    }

    @Override // k.a.a.a.k0.b
    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.Y5(c.b.a.m.f.X5(c.b.a.m.f.Y5(c.b.a.m.f.Y5(c.b.a.m.f.X5(c.b.a.m.f.X5(7, this.a.f8432b), this.f8383b), this.f8384c), this.f8386e), this.f8388g ? 1 : 0), this.f8387f), 6);
    }

    public b0(b0 b0Var, i iVar) {
        super(b0Var, iVar, b0Var.f8384c, b0Var.f8386e);
        this.f8387f = b0Var.f8387f;
        this.f8388g = e(b0Var, iVar);
    }

    public b0(b0 b0Var, i iVar, e0 e0Var) {
        super(b0Var, iVar, b0Var.f8384c, b0Var.f8386e);
        this.f8387f = e0Var;
        this.f8388g = e(b0Var, iVar);
    }

    public b0(b0 b0Var, i iVar, z0 z0Var) {
        super(b0Var, iVar, z0Var, b0Var.f8386e);
        this.f8387f = b0Var.f8387f;
        this.f8388g = e(b0Var, iVar);
    }
}
