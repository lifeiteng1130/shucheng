package j$.util.stream;

import j$.util.function.Supplier;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j$.util.stream.a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0401a2<R> extends AbstractC0488w2<Double, R, C0405b2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.I f8167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Supplier f8168d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0401a2(U2 u2, j$.util.function.p pVar, j$.util.function.I i2, Supplier supplier) {
        super(u2);
        this.f8166b = pVar;
        this.f8167c = i2;
        this.f8168d = supplier;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0405b2(this.f8168d, this.f8167c, this.f8166b);
    }
}
