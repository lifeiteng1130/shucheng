package k.a.a.a.k0;

/* JADX INFO: compiled from: AtomTransition.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends o1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8447c;

    public o(i iVar, int i2) {
        super(iVar);
        this.f8447c = i2;
    }

    @Override // k.a.a.a.k0.o1
    public int a() {
        return 5;
    }

    @Override // k.a.a.a.k0.o1
    public k.a.a.a.m0.i c() {
        int i2 = this.f8447c;
        k.a.a.a.m0.i iVar = new k.a.a.a.m0.i(new int[0]);
        iVar.a(i2);
        return iVar;
    }

    @Override // k.a.a.a.k0.o1
    public boolean d(int i2, int i3, int i4) {
        return this.f8447c == i2;
    }

    public String toString() {
        return String.valueOf(this.f8447c);
    }
}
