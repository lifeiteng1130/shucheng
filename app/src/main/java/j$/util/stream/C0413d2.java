package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.Consumer;

/* JADX INFO: Add missing generic type declarations: [T, U] */
/* JADX INFO: renamed from: j$.util.stream.d2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0413d2<T, U> extends AbstractC0484v2<U> implements InterfaceC0480u2<T, U, C0413d2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f8182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BiFunction f8183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8184d;

    C0413d2(Object obj, BiFunction biFunction, j$.util.function.p pVar) {
        this.f8182b = obj;
        this.f8183c = biFunction;
        this.f8184d = pVar;
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
        this.a = this.f8183c.apply(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        this.a = this.f8184d.apply(this.a, ((C0413d2) interfaceC0480u2).a);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8182b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
