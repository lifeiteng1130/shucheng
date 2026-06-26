package j$.util.stream;

import j$.util.function.C0392f;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class Z1 implements InterfaceC0480u2<Double, j$.util.p, Z1>, A2.e {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f8163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.r f8164c;

    Z1(j$.util.function.r rVar) {
        this.f8164c = rVar;
    }

    @Override // j$.util.stream.A2
    public void accept(double d2) {
        if (this.a) {
            this.a = false;
        } else {
            d2 = this.f8164c.applyAsDouble(this.f8163b, d2);
        }
        this.f8163b = d2;
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

    @Override // j$.util.function.Supplier
    public Object get() {
        return this.a ? j$.util.p.a() : j$.util.p.d(this.f8163b);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        Z1 z1 = (Z1) interfaceC0480u2;
        if (z1.a) {
            return;
        }
        accept(z1.f8163b);
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
        this.a = true;
        this.f8163b = 0.0d;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
