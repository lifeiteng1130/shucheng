package k.a.a.a.k0;

/* JADX INFO: compiled from: LexerTypeAction.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0 implements d0 {
    public final int a;

    public o0(int i2) {
        this.a = i2;
    }

    @Override // k.a.a.a.k0.d0
    public boolean a() {
        return false;
    }

    @Override // k.a.a.a.k0.d0
    public void b(k.a.a.a.s sVar) {
        sVar.setType(this.a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof o0) && this.a == ((o0) obj).a;
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.X5(c.b.a.m.f.X5(0, f0.TYPE.ordinal()), this.a), 2);
    }

    public String toString() {
        return String.format("type(%d)", Integer.valueOf(this.a));
    }
}
