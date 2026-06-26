package k.a.a.a.k0;

/* JADX INFO: compiled from: LexerChannelAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements d0 {
    public final int a;

    public g0(int i2) {
        this.a = i2;
    }

    @Override // k.a.a.a.k0.d0
    public boolean a() {
        return false;
    }

    @Override // k.a.a.a.k0.d0
    public void b(k.a.a.a.s sVar) {
        sVar.setChannel(this.a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof g0) && this.a == ((g0) obj).a;
    }

    public int hashCode() {
        return c.b.a.m.f.I1(c.b.a.m.f.X5(c.b.a.m.f.X5(0, f0.CHANNEL.ordinal()), this.a), 2);
    }

    public String toString() {
        return String.format("channel(%d)", Integer.valueOf(this.a));
    }
}
