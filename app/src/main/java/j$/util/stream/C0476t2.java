package j$.util.stream;

import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.t2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0476t2 implements InterfaceC0480u2<Long, j$.util.r, C0476t2>, A2.g {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.D f8272c;

    C0476t2(j$.util.function.D d2) {
        this.f8272c = d2;
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
        if (this.a) {
            this.a = false;
        } else {
            j2 = this.f8272c.applyAsLong(this.f8271b, j2);
        }
        this.f8271b = j2;
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
        return this.a ? j$.util.r.a() : j$.util.r.d(this.f8271b);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        C0476t2 c0476t2 = (C0476t2) interfaceC0480u2;
        if (c0476t2.a) {
            return;
        }
        accept(c0476t2.f8271b);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = true;
        this.f8271b = 0L;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
