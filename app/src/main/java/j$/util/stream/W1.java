package j$.util.stream;

/* JADX INFO: loaded from: classes2.dex */
class W1 extends AbstractC0488w2<Double, Double, X1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.r f8142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ double f8143c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    W1(U2 u2, j$.util.function.r rVar, double d2) {
        super(u2);
        this.f8142b = rVar;
        this.f8143c = d2;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new X1(this.f8143c, this.f8142b);
    }
}
