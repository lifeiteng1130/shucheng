package j$.util.stream;

/* JADX INFO: renamed from: j$.util.stream.s2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0472s2 extends AbstractC0488w2<Long, j$.util.r, C0476t2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.D f8266b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0472s2(U2 u2, j$.util.function.D d2) {
        super(u2);
        this.f8266b = d2;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0476t2(this.f8266b);
    }
}
