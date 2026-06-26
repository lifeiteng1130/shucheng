package k.a.a.a.k0;

/* JADX INFO: compiled from: LexerPushModeAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements d0 {
    public final int a;

    public m0(int i2) {
        this.a = i2;
    }

    @Override // k.a.a.a.k0.d0
    public boolean a() {
        return false;
    }

    @Override // k.a.a.a.k0.d0
    public void b(k.a.a.a.s sVar) {
        sVar.pushMode(this.a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof m0) && this.a == ((m0) obj).a;
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.X5(c.b.a.m.f.X5(0, f0.PUSH_MODE.ordinal()), this.a), 2);
    }

    public String toString() {
        return String.format("pushMode(%d)", Integer.valueOf(this.a));
    }
}
