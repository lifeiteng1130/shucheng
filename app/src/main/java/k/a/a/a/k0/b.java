package k.a.a.a.k0;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: ATNConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z0 f8384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h1 f8386e;

    public b(i iVar, int i2, z0 z0Var) {
        h1 h1Var = h1.a;
        this.a = iVar;
        this.f8383b = i2;
        this.f8384c = z0Var;
        this.f8386e = h1Var;
    }

    public boolean a(b bVar) {
        z0 z0Var;
        z0 z0Var2;
        if (this == bVar) {
            return true;
        }
        return bVar != null && this.a.f8432b == bVar.a.f8432b && this.f8383b == bVar.f8383b && ((z0Var = this.f8384c) == (z0Var2 = bVar.f8384c) || (z0Var != null && z0Var.equals(z0Var2))) && this.f8386e.equals(bVar.f8386e) && c() == bVar.c();
    }

    public final int b() {
        return this.f8385d & (-1073741825);
    }

    public final boolean c() {
        return (this.f8385d & BasicMeasure.EXACTLY) != 0;
    }

    public final void d(boolean z) {
        if (z) {
            this.f8385d |= BasicMeasure.EXACTLY;
        } else {
            this.f8385d &= -1073741825;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return a((b) obj);
        }
        return false;
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.Y5(c.b.a.m.f.Y5(c.b.a.m.f.X5(c.b.a.m.f.X5(7, this.a.f8432b), this.f8383b), this.f8384c), this.f8386e), 4);
    }

    public String toString() {
        StringBuilder sbQ = c.a.a.a.a.q('(');
        sbQ.append(this.a);
        sbQ.append(",");
        sbQ.append(this.f8383b);
        if (this.f8384c != null) {
            sbQ.append(",[");
            sbQ.append(this.f8384c.toString());
            sbQ.append("]");
        }
        h1 h1Var = this.f8386e;
        if (h1Var != null && h1Var != h1.a) {
            sbQ.append(",");
            sbQ.append(this.f8386e);
        }
        if (b() > 0) {
            sbQ.append(",up=");
            sbQ.append(b());
        }
        sbQ.append(')');
        return sbQ.toString();
    }

    public b(i iVar, int i2, z0 z0Var, h1 h1Var) {
        this.a = iVar;
        this.f8383b = i2;
        this.f8384c = z0Var;
        this.f8386e = h1Var;
    }

    public b(b bVar, i iVar) {
        this(bVar, iVar, bVar.f8384c, bVar.f8386e);
    }

    public b(b bVar, i iVar, z0 z0Var, h1 h1Var) {
        this.a = iVar;
        this.f8383b = bVar.f8383b;
        this.f8384c = z0Var;
        this.f8386e = h1Var;
        this.f8385d = bVar.f8385d;
    }
}
