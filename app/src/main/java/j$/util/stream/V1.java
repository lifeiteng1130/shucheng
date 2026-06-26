package j$.util.stream;

import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes2.dex */
class V1<R> extends AbstractC0484v2<R> implements InterfaceC0480u2<Long, R, V1>, A2.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Supplier f8139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.K f8140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8141d;

    V1(Supplier supplier, j$.util.function.K k2, j$.util.function.p pVar) {
        this.f8139b = supplier;
        this.f8140c = k2;
        this.f8141d = pVar;
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
    public void accept(long j2) {
        this.f8140c.accept(this.a, j2);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.Consumer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l2) {
        Q1.c(this, l2);
    }

    @Override // j$.util.function.E
    public j$.util.function.E f(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        return new C0396j(this, e2);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        this.a = this.f8141d.apply(this.a, ((V1) interfaceC0480u2).a);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8139b.get();
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
