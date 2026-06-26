package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Supplier;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: renamed from: j$.util.stream.j2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0437j2<R, T> extends AbstractC0484v2<R> implements InterfaceC0480u2<T, R, C0437j2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Supplier f8221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BiConsumer f8222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BiConsumer f8223d;

    C0437j2(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f8221b = supplier;
        this.f8222c = biConsumer;
        this.f8223d = biConsumer2;
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
        this.f8222c.accept(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        this.f8223d.accept(this.a, ((C0437j2) interfaceC0480u2).a);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8221b.get();
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
