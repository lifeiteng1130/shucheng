package j$.util.stream;

/* JADX INFO: loaded from: classes2.dex */
class Y1 extends AbstractC0488w2<Double, j$.util.p, Z1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.r f8159b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Y1(U2 u2, j$.util.function.r rVar) {
        super(u2);
        this.f8159b = rVar;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new Z1(this.f8159b);
    }
}
