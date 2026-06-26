package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: renamed from: j$.util.stream.v1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C0483v1<P_IN, P_OUT, O> extends AbstractC0432i1<P_IN, P_OUT, O, C0483v1<P_IN, P_OUT, O>> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final C0475t1 f8274j;

    C0483v1(C0475t1 c0475t1, T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.f8274j = c0475t1;
    }

    C0483v1(C0483v1 c0483v1, Spliterator spliterator) {
        super(c0483v1, spliterator);
        this.f8274j = c0483v1.f8274j;
    }

    private void m(Object obj) {
        boolean z;
        AbstractC0440k1 abstractC0440k1 = this;
        while (true) {
            if (abstractC0440k1 != null) {
                AbstractC0440k1 abstractC0440k1C = abstractC0440k1.c();
                if (abstractC0440k1C != null && abstractC0440k1C.f8227e != abstractC0440k1) {
                    z = false;
                    break;
                }
                abstractC0440k1 = abstractC0440k1C;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            l(obj);
        } else {
            j();
        }
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected Object a() {
        T1 t1 = this.f8224b;
        h3 h3Var = (h3) this.f8274j.f8270e.get();
        t1.t0(h3Var, this.f8225c);
        Object obj = h3Var.get();
        if (!this.f8274j.f8267b) {
            if (obj != null) {
                l(obj);
            }
            return null;
        }
        if (obj == null) {
            return null;
        }
        m(obj);
        return obj;
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected AbstractC0440k1 f(Spliterator spliterator) {
        return new C0483v1(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0432i1
    protected Object k() {
        return this.f8274j.f8268c;
    }

    @Override // j$.util.stream.AbstractC0440k1, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (this.f8274j.f8267b) {
            C0483v1 c0483v1 = (C0483v1) this.f8227e;
            C0483v1 c0483v12 = null;
            while (true) {
                if (c0483v1 != c0483v12) {
                    Object objB = c0483v1.b();
                    if (objB != null && this.f8274j.f8269d.test(objB)) {
                        g(objB);
                        m(objB);
                        break;
                    } else {
                        c0483v12 = c0483v1;
                        c0483v1 = (C0483v1) this.f8228f;
                    }
                } else {
                    break;
                }
            }
        }
        this.f8225c = null;
        this.f8228f = null;
        this.f8227e = null;
    }
}
