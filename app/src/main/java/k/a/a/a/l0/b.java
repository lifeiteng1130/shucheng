package k.a.a.a.l0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import k.a.a.a.h0;
import k.a.a.a.i0;
import k.a.a.a.k0.l1;
import k.a.a.a.k0.w;

/* JADX INFO: compiled from: DFA.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final Map<d, d> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f8482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f8484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8485e;

    public b(w wVar, int i2) {
        this.f8484d = wVar;
        this.f8483c = i2;
        boolean z = true;
        if ((wVar instanceof l1) && ((l1) wVar).f8444j) {
            d dVar = new d(new k.a.a.a.k0.c(true));
            dVar.f8488c = new d[0];
            dVar.f8489d = false;
            dVar.f8492g = false;
            this.f8482b = dVar;
        } else {
            z = false;
        }
        this.f8485e = z;
    }

    public final void a(int i2, d dVar) {
        if (!this.f8485e) {
            throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
        }
        if (i2 < 0) {
            return;
        }
        synchronized (this.f8482b) {
            if (i2 >= this.f8482b.f8488c.length) {
                this.f8482b.f8488c = (d[]) Arrays.copyOf(this.f8482b.f8488c, i2 + 1);
            }
            this.f8482b.f8488c[i2] = dVar;
        }
    }

    public String b(h0 h0Var) {
        return this.f8482b == null ? "" : new c(this, h0Var).toString();
    }

    public String toString() {
        return b(i0.f8371b);
    }
}
