package j$.util.stream;

import j$.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class M1<T> implements A2<T> {
    boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f8056b;

    M1(N1 n1) {
        this.f8056b = !n1.f8059c;
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
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
    }

    @Override // j$.util.stream.A2
    public boolean o() {
        return this.a;
    }
}
