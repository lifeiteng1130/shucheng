package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0432i1;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j$.util.stream.i1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0432i1<P_IN, P_OUT, R, K extends AbstractC0432i1<P_IN, P_OUT, R, K>> extends AbstractC0440k1<P_IN, P_OUT, R, K> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final AtomicReference f8213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected volatile boolean f8214i;

    protected AbstractC0432i1(T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.f8213h = new AtomicReference(null);
    }

    protected AbstractC0432i1(AbstractC0432i1 abstractC0432i1, Spliterator spliterator) {
        super(abstractC0432i1, spliterator);
        this.f8213h = abstractC0432i1.f8213h;
    }

    @Override // j$.util.stream.AbstractC0440k1
    public Object b() {
        if (!e()) {
            return super.b();
        }
        Object obj = this.f8213h.get();
        return obj == null ? k() : obj;
    }

    @Override // j$.util.stream.AbstractC0440k1, java.util.concurrent.CountedCompleter
    public void compute() {
        Object objK;
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f8225c;
        long jEstimateSize = spliterator.estimateSize();
        long jH = this.f8226d;
        if (jH == 0) {
            jH = AbstractC0440k1.h(jEstimateSize);
            this.f8226d = jH;
        }
        boolean z = false;
        AtomicReference atomicReference = this.f8213h;
        AbstractC0432i1<P_IN, P_OUT, R, K> abstractC0432i1 = this;
        while (true) {
            objK = atomicReference.get();
            if (objK != null) {
                break;
            }
            boolean z2 = abstractC0432i1.f8214i;
            if (!z2) {
                AbstractC0440k1 abstractC0440k1C = abstractC0432i1.c();
                while (true) {
                    AbstractC0432i1 abstractC0432i12 = (AbstractC0432i1) abstractC0440k1C;
                    if (z2 || abstractC0432i12 == null) {
                        break;
                    }
                    z2 = abstractC0432i12.f8214i;
                    abstractC0440k1C = abstractC0432i12.c();
                }
            }
            if (z2) {
                objK = abstractC0432i1.k();
                break;
            }
            if (jEstimateSize <= jH || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            AbstractC0432i1<P_IN, P_OUT, R, K> abstractC0432i13 = (AbstractC0432i1) abstractC0432i1.f(spliteratorTrySplit);
            abstractC0432i1.f8227e = abstractC0432i13;
            AbstractC0432i1<P_IN, P_OUT, R, K> abstractC0432i14 = (AbstractC0432i1) abstractC0432i1.f(spliterator);
            abstractC0432i1.f8228f = abstractC0432i14;
            abstractC0432i1.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                abstractC0432i1 = abstractC0432i13;
                abstractC0432i13 = abstractC0432i14;
            } else {
                abstractC0432i1 = abstractC0432i14;
            }
            z = !z;
            abstractC0432i13.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        objK = abstractC0432i1.a();
        abstractC0432i1.g(objK);
        abstractC0432i1.tryComplete();
    }

    @Override // j$.util.stream.AbstractC0440k1
    protected void g(Object obj) {
        if (!e()) {
            super.g(obj);
        } else if (obj != null) {
            this.f8213h.compareAndSet(null, obj);
        }
    }

    @Override // j$.util.stream.AbstractC0440k1, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return b();
    }

    protected void i() {
        this.f8214i = true;
    }

    protected void j() {
        AbstractC0432i1<P_IN, P_OUT, R, K> abstractC0432i1 = this;
        for (AbstractC0432i1<P_IN, P_OUT, R, K> abstractC0432i12 = (AbstractC0432i1) c(); abstractC0432i12 != null; abstractC0432i12 = (AbstractC0432i1) abstractC0432i12.c()) {
            if (abstractC0432i12.f8227e == abstractC0432i1) {
                AbstractC0432i1 abstractC0432i13 = (AbstractC0432i1) abstractC0432i12.f8228f;
                if (!abstractC0432i13.f8214i) {
                    abstractC0432i13.i();
                }
            }
            abstractC0432i1 = abstractC0432i12;
        }
    }

    protected abstract Object k();

    protected void l(Object obj) {
        if (obj != null) {
            this.f8213h.compareAndSet(null, obj);
        }
    }
}
