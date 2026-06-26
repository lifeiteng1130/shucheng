package j$.util.stream;

import j$.util.function.C0392f;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j$.util.stream.b2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0405b2<R> extends AbstractC0484v2<R> implements InterfaceC0480u2<Double, R, C0405b2>, A2.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Supplier f8170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.I f8171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8172d;

    C0405b2(Supplier supplier, j$.util.function.I i2, j$.util.function.p pVar) {
        this.f8170b = supplier;
        this.f8171c = i2;
        this.f8172d = pVar;
    }

    @Override // j$.util.stream.A2
    public void accept(double d2) {
        this.f8171c.accept(this.a, d2);
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
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.Consumer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d2) {
        Q1.a(this, d2);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        this.a = this.f8172d.apply(this.a, ((C0405b2) interfaceC0480u2).a);
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new C0392f(this, sVar);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8170b.get();
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
