package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Supplier;

/* JADX INFO: Add missing generic type declarations: [T, I] */
/* JADX INFO: renamed from: j$.util.stream.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0429h2<I, T> extends AbstractC0484v2<I> implements InterfaceC0480u2<T, I, C0429h2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Supplier f8210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BiConsumer f8211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8212d;

    C0429h2(Supplier supplier, BiConsumer biConsumer, j$.util.function.p pVar) {
        this.f8210b = supplier;
        this.f8211c = biConsumer;
        this.f8212d = pVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2, j$.util.function.y
    public /* synthetic */ void accept(int i2) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j2) {
        j$.time.a.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.f8211c.accept(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        this.a = this.f8212d.apply(this.a, ((C0429h2) interfaceC0480u2).a);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8210b.get();
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
