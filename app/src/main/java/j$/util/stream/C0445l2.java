package j$.util.stream;

import j$.util.function.C0395i;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.l2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0445l2 implements InterfaceC0480u2<Integer, Integer, C0445l2>, A2.f {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f8232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.x f8233c;

    C0445l2(int i2, j$.util.function.x xVar) {
        this.f8232b = i2;
        this.f8233c = xVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2, j$.util.function.y
    public void accept(int i2) {
        this.a = this.f8233c.applyAsInt(this.a, i2);
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
        return Integer.valueOf(this.a);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        accept(((C0445l2) interfaceC0480u2).a);
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
        this.a = this.f8232b;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
