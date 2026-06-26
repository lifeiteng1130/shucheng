package j$.util.stream;

import j$.util.function.Supplier;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j$.util.stream.o2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0457o2<R> extends AbstractC0488w2<Integer, R, C0461p2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.J f8242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Supplier f8243d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0457o2(U2 u2, j$.util.function.p pVar, j$.util.function.J j2, Supplier supplier) {
        super(u2);
        this.f8241b = pVar;
        this.f8242c = j2;
        this.f8243d = supplier;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0461p2(this.f8243d, this.f8242c, this.f8241b);
    }
}
