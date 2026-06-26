package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: renamed from: j$.util.stream.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C0495y1<S, T> extends CountedCompleter<Void> {
    private Spliterator a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A2 f8288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T1 f8289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8290d;

    C0495y1(T1 t1, Spliterator spliterator, A2 a2) {
        super(null);
        this.f8288b = a2;
        this.f8289c = t1;
        this.a = spliterator;
        this.f8290d = 0L;
    }

    C0495y1(C0495y1 c0495y1, Spliterator spliterator) {
        super(c0495y1);
        this.a = spliterator;
        this.f8288b = c0495y1.f8288b;
        this.f8290d = c0495y1.f8290d;
        this.f8289c = c0495y1.f8289c;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.a;
        long jEstimateSize = spliterator.estimateSize();
        long jH = this.f8290d;
        if (jH == 0) {
            jH = AbstractC0440k1.h(jEstimateSize);
            this.f8290d = jH;
        }
        boolean zN = T2.SHORT_CIRCUIT.n(this.f8289c.r0());
        boolean z = false;
        A2 a2 = this.f8288b;
        C0495y1<S, T> c0495y1 = this;
        while (true) {
            if (zN && a2.o()) {
                break;
            }
            if (jEstimateSize <= jH || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            C0495y1<S, T> c0495y12 = new C0495y1<>(c0495y1, spliteratorTrySplit);
            c0495y1.addToPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
            } else {
                C0495y1<S, T> c0495y13 = c0495y1;
                c0495y1 = c0495y12;
                c0495y12 = c0495y13;
            }
            z = !z;
            c0495y1.fork();
            c0495y1 = c0495y12;
            jEstimateSize = spliterator.estimateSize();
        }
        c0495y1.f8289c.m0(a2, spliterator);
        c0495y1.a = null;
        c0495y1.propagateCompletion();
    }
}
