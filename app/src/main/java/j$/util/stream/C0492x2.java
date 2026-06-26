package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0480u2;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: renamed from: j$.util.stream.x2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C0492x2<P_IN, P_OUT, R, S extends InterfaceC0480u2<P_OUT, R, S>> extends AbstractC0440k1<P_IN, P_OUT, S, C0492x2<P_IN, P_OUT, R, S>> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AbstractC0488w2 f8287h;

    C0492x2(AbstractC0488w2 abstractC0488w2, T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.f8287h = abstractC0488w2;
    }

    C0492x2(C0492x2 c0492x2, Spliterator spliterator) {
        super(c0492x2, spliterator);
        this.f8287h = c0492x2.f8287h;
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected Object a() {
        T1 t1 = this.f8224b;
        InterfaceC0480u2 interfaceC0480u2A = this.f8287h.a();
        t1.t0(interfaceC0480u2A, this.f8225c);
        return interfaceC0480u2A;
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected AbstractC0440k1 f(Spliterator spliterator) {
        return new C0492x2(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0440k1, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (!d()) {
            InterfaceC0480u2 interfaceC0480u2 = (InterfaceC0480u2) ((C0492x2) this.f8227e).b();
            interfaceC0480u2.h((InterfaceC0480u2) ((C0492x2) this.f8228f).b());
            g(interfaceC0480u2);
        }
        this.f8225c = null;
        this.f8228f = null;
        this.f8227e = null;
    }
}
