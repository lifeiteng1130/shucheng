package j$.util.stream;

import j$.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
final class P1<P_IN, P_OUT> extends AbstractC0432i1<P_IN, P_OUT, Boolean, P1<P_IN, P_OUT>> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final O1 f8065j;

    P1(O1 o1, T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.f8065j = o1;
    }

    P1(P1 p1, Spliterator spliterator) {
        super(p1, spliterator);
        this.f8065j = p1.f8065j;
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected Object a() {
        T1 t1 = this.f8224b;
        M1 m1 = (M1) this.f8065j.f8062c.get();
        t1.t0(m1, this.f8225c);
        boolean z = m1.f8056b;
        if (z != this.f8065j.f8061b.f8059c) {
            return null;
        }
        l(Boolean.valueOf(z));
        return null;
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected AbstractC0440k1 f(Spliterator spliterator) {
        return new P1(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0432i1
    protected Object k() {
        return Boolean.valueOf(!this.f8065j.f8061b.f8059c);
    }
}
