package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Supplier;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: renamed from: j$.util.stream.i2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0433i2<R, T> extends AbstractC0488w2<T, R, C0437j2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BiConsumer f8215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BiConsumer f8216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Supplier f8217d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0433i2(U2 u2, BiConsumer biConsumer, BiConsumer biConsumer2, Supplier supplier) {
        super(u2);
        this.f8215b = biConsumer;
        this.f8216c = biConsumer2;
        this.f8217d = supplier;
    }

    @Override // j$.util.stream.AbstractC0488w2
    public InterfaceC0480u2 a() {
        return new C0437j2(this.f8217d, this.f8216c, this.f8215b);
    }
}
