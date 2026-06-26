package j$.util.stream;

/* JADX INFO: renamed from: j$.util.stream.m2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0449m2 extends AbstractC0488w2<Integer, j$.util.q, C0453n2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.x f8235b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0449m2(U2 u2, j$.util.function.x xVar) {
        super(u2);
        this.f8235b = xVar;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0453n2(this.f8235b);
    }
}
