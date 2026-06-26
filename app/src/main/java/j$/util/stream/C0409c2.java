package j$.util.stream;

import j$.util.function.BiFunction;

/* JADX INFO: Add missing generic type declarations: [T, U] */
/* JADX INFO: renamed from: j$.util.stream.c2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0409c2<T, U> extends AbstractC0488w2<T, U, C0413d2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BiFunction f8175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f8176d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0409c2(U2 u2, j$.util.function.p pVar, BiFunction biFunction, Object obj) {
        super(u2);
        this.f8174b = pVar;
        this.f8175c = biFunction;
        this.f8176d = obj;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0413d2(this.f8176d, this.f8175c, this.f8174b);
    }
}
