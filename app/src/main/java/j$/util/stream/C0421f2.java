package j$.util.stream;

import j$.util.function.Consumer;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j$.util.stream.f2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0421f2<T> implements InterfaceC0480u2<T, j$.util.o<T>, C0421f2> {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f8193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.util.function.p f8194c;

    C0421f2(j$.util.function.p pVar) {
        this.f8194c = pVar;
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
        if (this.a) {
            this.a = false;
        } else {
            obj = this.f8194c.apply(this.f8193b, obj);
        }
        this.f8193b = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.Supplier
    public Object get() {
        return this.a ? j$.util.o.a() : j$.util.o.d(this.f8193b);
    }

    @Override // j$.util.stream.InterfaceC0480u2
    public void h(InterfaceC0480u2 interfaceC0480u2) {
        C0421f2 c0421f2 = (C0421f2) interfaceC0480u2;
        if (c0421f2.a) {
            return;
        }
        accept(c0421f2.f8193b);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
        this.a = true;
        this.f8193b = null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
