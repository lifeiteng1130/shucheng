package j$.util.stream;

import j$.util.function.Supplier;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes2.dex */
class U1<R> extends AbstractC0488w2<Long, R, V1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.K f8137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Supplier f8138d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    U1(U2 u2, j$.util.function.p pVar, j$.util.function.K k2, Supplier supplier) {
        super(u2);
        this.f8136b = pVar;
        this.f8137c = k2;
        this.f8138d = supplier;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new V1(this.f8138d, this.f8137c, this.f8136b);
    }
}
