package k.a.a.a.l0;

import c.b.a.m.f;
import java.util.Arrays;
import k.a.a.a.k0.e0;
import k.a.a.a.k0.h1;

/* JADX INFO: compiled from: DFAState.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k.a.a.a.k0.c f8487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d[] f8488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e0 f8491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a[] f8493h;

    /* JADX INFO: compiled from: DFAState.java */
    public static class a {
        public h1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8494b;

        public a(h1 h1Var, int i2) {
            this.f8494b = i2;
            this.a = h1Var;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("(");
            sbR.append(this.a);
            sbR.append(", ");
            return c.a.a.a.a.o(sbR, this.f8494b, ")");
        }
    }

    public d() {
        this.a = -1;
        this.f8487b = new k.a.a.a.k0.c(true);
        this.f8489d = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.f8487b.equals(((d) obj).f8487b);
        }
        return false;
    }

    public int hashCode() {
        return f.I1(f.X5(7, this.f8487b.hashCode()), 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(":");
        sb.append(this.f8487b);
        if (this.f8489d) {
            sb.append("=>");
            a[] aVarArr = this.f8493h;
            if (aVarArr != null) {
                sb.append(Arrays.toString(aVarArr));
            } else {
                sb.append(this.f8490e);
            }
        }
        return sb.toString();
    }

    public d(k.a.a.a.k0.c cVar) {
        this.a = -1;
        this.f8487b = new k.a.a.a.k0.c(true);
        this.f8489d = false;
        this.f8487b = cVar;
    }
}
