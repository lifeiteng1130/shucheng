package k.a.a.a.k0;

/* JADX INFO: compiled from: ActionTransition.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends o1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8442d;

    public l(i iVar, int i2, int i3, boolean z) {
        super(iVar);
        this.f8441c = i2;
        this.f8442d = i3;
    }

    @Override // k.a.a.a.k0.o1
    public int a() {
        return 6;
    }

    @Override // k.a.a.a.k0.o1
    public boolean d(int i2, int i3, int i4) {
        return false;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("action_");
        sbR.append(this.f8441c);
        sbR.append(":");
        sbR.append(this.f8442d);
        return sbR.toString();
    }
}
