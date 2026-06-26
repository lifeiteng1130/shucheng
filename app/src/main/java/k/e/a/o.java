package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f8892b;

    public o(int i2) {
        if (i2 != 262144 && i2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.a = i2;
        this.f8892b = null;
    }

    public abstract a a(String str, boolean z);

    public abstract void b(int i2, String str, String str2, String str3);

    public abstract void c(int i2, int i3, Object[] objArr, int i4, Object[] objArr2);

    public abstract void d(int i2, int i3);

    public abstract void e(int i2);

    public abstract a f(int i2, s sVar, String str, boolean z);

    public abstract void g(int i2, int i3);

    public abstract void h(int i2, n nVar);

    public abstract void i(n nVar);

    public abstract void j(Object obj);

    public abstract void k(int i2, n nVar);

    public abstract void l(String str, String str2, String str3, n nVar, n nVar2, int i2);

    public abstract a m(int i2, s sVar, n[] nVarArr, n[] nVarArr2, int[] iArr, String str, boolean z);

    public abstract void n(int i2, int i3);

    public void o(int i2, String str, String str2, String str3) {
        if (this.a >= 327680) {
            p(i2, str, str2, str3, i2 == 185);
            return;
        }
        o oVar = this.f8892b;
        if (oVar != null) {
            oVar.o(i2, str, str2, str3);
        }
    }

    public abstract void p(int i2, String str, String str2, String str3, boolean z);

    public abstract a q(int i2, String str, boolean z);

    public abstract void r(int i2, int i3, n nVar, n... nVarArr);

    public abstract a s(int i2, s sVar, String str, boolean z);

    public abstract void t(int i2, String str);

    public abstract void u(int i2, int i3);
}
