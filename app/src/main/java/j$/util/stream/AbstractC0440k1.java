package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0440k1;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* JADX INFO: renamed from: j$.util.stream.k1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0440k1<P_IN, P_OUT, R, K extends AbstractC0440k1<P_IN, P_OUT, R, K>> extends CountedCompleter<R> {
    static final int a = ForkJoinPool.getCommonPoolParallelism() << 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final T1 f8224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Spliterator f8225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f8226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected AbstractC0440k1 f8227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected AbstractC0440k1 f8228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f8229g;

    protected AbstractC0440k1(T1 t1, Spliterator spliterator) {
        super(null);
        this.f8224b = t1;
        this.f8225c = spliterator;
        this.f8226d = 0L;
    }

    protected AbstractC0440k1(AbstractC0440k1 abstractC0440k1, Spliterator spliterator) {
        super(abstractC0440k1);
        this.f8225c = spliterator;
        this.f8224b = abstractC0440k1.f8224b;
        this.f8226d = abstractC0440k1.f8226d;
    }

    public static long h(long j2) {
        long j3 = j2 / ((long) a);
        if (j3 > 0) {
            return j3;
        }
        return 1L;
    }

    protected abstract Object a();

    protected Object b() {
        return this.f8229g;
    }

    protected AbstractC0440k1 c() {
        return (AbstractC0440k1) getCompleter();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f8225c;
        long jEstimateSize = spliterator.estimateSize();
        long jH = this.f8226d;
        if (jH == 0) {
            jH = h(jEstimateSize);
            this.f8226d = jH;
        }
        boolean z = false;
        AbstractC0440k1<P_IN, P_OUT, R, K> abstractC0440k1 = this;
        while (jEstimateSize > jH && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            AbstractC0440k1<P_IN, P_OUT, R, K> abstractC0440k1F = abstractC0440k1.f(spliteratorTrySplit);
            abstractC0440k1.f8227e = abstractC0440k1F;
            AbstractC0440k1<P_IN, P_OUT, R, K> abstractC0440k1F2 = abstractC0440k1.f(spliterator);
            abstractC0440k1.f8228f = abstractC0440k1F2;
            abstractC0440k1.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                abstractC0440k1 = abstractC0440k1F;
                abstractC0440k1F = abstractC0440k1F2;
            } else {
                abstractC0440k1 = abstractC0440k1F2;
            }
            z = !z;
            abstractC0440k1F.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        abstractC0440k1.g(abstractC0440k1.a());
        abstractC0440k1.tryComplete();
    }

    protected boolean d() {
        return this.f8227e == null;
    }

    protected boolean e() {
        return c() == null;
    }

    protected abstract AbstractC0440k1 f(Spliterator spliterator);

    protected void g(Object obj) {
        this.f8229g = obj;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f8229g;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.f8225c = null;
        this.f8228f = null;
        this.f8227e = null;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    protected void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
