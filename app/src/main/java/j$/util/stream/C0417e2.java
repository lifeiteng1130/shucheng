package j$.util.stream;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j$.util.stream.e2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0417e2<T> extends AbstractC0488w2<T, j$.util.o<T>, C0421f2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8192b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0417e2(U2 u2, j$.util.function.p pVar) {
        super(u2);
        this.f8192b = pVar;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0421f2(this.f8192b);
    }
}
