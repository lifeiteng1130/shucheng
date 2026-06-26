package k.a.a.a.k0;

import java.util.Arrays;

/* JADX INFO: compiled from: LexerActionExecutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0 {
    public final d0[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8412b;

    public e0(d0[] d0VarArr) {
        this.a = d0VarArr;
        int iY5 = 0;
        for (d0 d0Var : d0VarArr) {
            iY5 = c.b.a.m.f.Y5(iY5, d0Var);
        }
        this.f8412b = c.b.a.m.f.I1(iY5, d0VarArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f8412b == e0Var.f8412b && Arrays.equals(this.a, e0Var.a);
    }

    public int hashCode() {
        return this.f8412b;
    }
}
