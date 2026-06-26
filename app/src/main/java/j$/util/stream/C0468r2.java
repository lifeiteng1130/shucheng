package j$.util.stream;

import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.r2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0468r2 implements InterfaceC0480u2<Long, Long, C0468r2>, A2.g {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f8264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.D f8265c;

    C0468r2(long j2, j$.util.function.D d2) {
        this.f8264b = j2;
        this.f8265c = d2;
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
        this.a = this.f8265c.applyAsLong(this.a, j2);
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

    @Override // j$.util.function.Supplier
    public Object get() {
        return Long.valueOf(this.a);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        accept(((C0468r2) interfaceC0480u2).a);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = this.f8264b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
