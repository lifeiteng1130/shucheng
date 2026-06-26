package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j1 extends u implements m0, a1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k1 f6261d;

    @Override // g.b.a1
    @Nullable
    public p1 a() {
        return null;
    }

    @Override // g.b.m0
    public void e() {
        Object objB;
        k1 k1Var = this.f6261d;
        if (k1Var == null) {
            f.c0.c.j.m("job");
            throw null;
        }
        do {
            objB = k1Var.B();
            if (!(objB instanceof j1)) {
                if (!(objB instanceof a1) || ((a1) objB).a() == null) {
                    return;
                }
                j();
                return;
            }
            if (objB != this) {
                return;
            }
        } while (!k1.a.compareAndSet(k1Var, objB, l1.f6277g));
    }

    @Override // g.b.a1
    public boolean isActive() {
        return true;
    }

    @NotNull
    public final k1 l() {
        k1 k1Var = this.f6261d;
        if (k1Var != null) {
            return k1Var;
        }
        f.c0.c.j.m("job");
        throw null;
    }

    @Override // g.b.g2.j
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(c.b.a.m.f.v2(this));
        sb.append("[job@");
        k1 k1Var = this.f6261d;
        if (k1Var == null) {
            f.c0.c.j.m("job");
            throw null;
        }
        sb.append(c.b.a.m.f.v2(k1Var));
        sb.append(']');
        return sb.toString();
    }
}
