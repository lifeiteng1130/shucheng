package k.a.a.a.k0;

/* JADX INFO: compiled from: SetTransition.java */
/* JADX INFO: loaded from: classes3.dex */
public class i1 extends o1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.a.a.a.m0.i f8438c;

    public i1(i iVar, k.a.a.a.m0.i iVar2) {
        super(iVar);
        if (iVar2 == null) {
            iVar2 = new k.a.a.a.m0.i(new int[0]);
            iVar2.a(0);
        }
        this.f8438c = iVar2;
    }

    @Override // k.a.a.a.k0.o1
    public int a() {
        return 7;
    }

    @Override // k.a.a.a.k0.o1
    public k.a.a.a.m0.i c() {
        return this.f8438c;
    }

    @Override // k.a.a.a.k0.o1
    public boolean d(int i2, int i3, int i4) {
        return this.f8438c.d(i2);
    }

    public String toString() {
        return this.f8438c.toString();
    }
}
