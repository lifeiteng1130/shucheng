package j$.util.stream;

/* JADX INFO: renamed from: j$.util.stream.q2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0465q2 extends AbstractC0488w2<Long, Long, C0468r2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.D f8261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f8262c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0465q2(U2 u2, j$.util.function.D d2, long j2) {
        super(u2);
        this.f8261b = d2;
        this.f8262c = j2;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0468r2(this.f8262c, this.f8261b);
    }
}
