package j$.util.stream;

import j$.util.function.C0395i;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j$.util.stream.p2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0461p2<R> extends AbstractC0484v2<R> implements InterfaceC0480u2<Integer, R, C0461p2>, A2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Supplier f8256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.J f8257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8258d;

    C0461p2(Supplier supplier, j$.util.function.J j2, j$.util.function.p pVar) {
        this.f8256b = supplier;
        this.f8257c = j2;
        this.f8258d = pVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2, j$.util.function.y
    public void accept(int i2) {
        this.f8257c.accept(this.a, i2);
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
    public /* synthetic */ void accept(Integer num) {
        Q1.b(this, num);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        this.a = this.f8258d.apply(this.a, ((C0461p2) interfaceC0480u2).a);
    }

    @Override // j$.util.function.y
    public j$.util.function.y k(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8256b.get();
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
