package j$.util.stream;

/* JADX INFO: renamed from: j$.util.stream.k2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0441k2 extends AbstractC0488w2<Integer, Integer, C0445l2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.x f8230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f8231c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0441k2(U2 u2, j$.util.function.x xVar, int i2) {
        super(u2);
        this.f8230b = xVar;
        this.f8231c = i2;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0445l2(this.f8231c, this.f8230b);
    }
}
