package k.a.a.a.k0;

/* JADX INFO: compiled from: SingletonPredictionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class j1 extends z0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z0 f8439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8440e;

    public j1(z0 z0Var, int i2) {
        super(z0Var != null ? c.b.a.m.f.I1(c.b.a.m.f.X5(c.b.a.m.f.Y5(1, z0Var), i2), 2) : c.b.a.m.f.I1(1, 0));
        this.f8439d = z0Var;
        this.f8440e = i2;
    }

    public static j1 i(z0 z0Var, int i2) {
        return (i2 == Integer.MAX_VALUE && z0Var == null) ? z0.a : new j1(z0Var, i2);
    }

    @Override // k.a.a.a.k0.z0
    public z0 c(int i2) {
        return this.f8439d;
    }

    @Override // k.a.a.a.k0.z0
    public int d(int i2) {
        return this.f8440e;
    }

    @Override // k.a.a.a.k0.z0
    public boolean equals(Object obj) {
        z0 z0Var;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j1) || this.f8481c != obj.hashCode()) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return this.f8440e == j1Var.f8440e && (z0Var = this.f8439d) != null && z0Var.equals(j1Var.f8439d);
    }

    @Override // k.a.a.a.k0.z0
    public int h() {
        return 1;
    }

    public String toString() {
        z0 z0Var = this.f8439d;
        String string = z0Var != null ? z0Var.toString() : "";
        if (string.length() == 0) {
            int i2 = this.f8440e;
            return i2 == Integer.MAX_VALUE ? "$" : String.valueOf(i2);
        }
        return String.valueOf(this.f8440e) + " " + string;
    }
}
