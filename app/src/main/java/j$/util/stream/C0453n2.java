package j$.util.stream;

import j$.util.function.C0395i;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.n2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0453n2 implements InterfaceC0480u2<Integer, j$.util.q, C0453n2>, A2.f {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.x f8237c;

    C0453n2(j$.util.function.x xVar) {
        this.f8237c = xVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2, j$.util.function.y
    public void accept(int i2) {
        if (this.a) {
            this.a = false;
        } else {
            i2 = this.f8237c.applyAsInt(this.f8236b, i2);
        }
        this.f8236b = i2;
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

    @Override // j$.util.function.Supplier
    public Object get() {
        return this.a ? j$.util.q.a() : j$.util.q.d(this.f8236b);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        C0453n2 c0453n2 = (C0453n2) interfaceC0480u2;
        if (c0453n2.a) {
            return;
        }
        accept(c0453n2.f8236b);
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
        this.a = true;
        this.f8236b = 0;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
