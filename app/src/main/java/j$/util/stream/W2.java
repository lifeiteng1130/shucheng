package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;
import j$.util.stream.AbstractC0436j1;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
abstract class W2<P_IN, P_OUT, T_BUFFER extends AbstractC0436j1> implements Spliterator<P_OUT> {
    final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T1 f8144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Supplier f8145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Spliterator f8146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    A2 f8147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    j$.util.function.q f8148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f8149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    AbstractC0436j1 f8150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f8151i;

    W2(T1 t1, Spliterator spliterator, boolean z) {
        this.f8144b = t1;
        this.f8145c = null;
        this.f8146d = spliterator;
        this.a = z;
    }

    W2(T1 t1, Supplier supplier, boolean z) {
        this.f8144b = t1;
        this.f8145c = supplier;
        this.f8146d = null;
        this.a = z;
    }

    private boolean f() {
        while (this.f8150h.count() == 0) {
            if (this.f8147e.o() || !this.f8148f.a()) {
                if (this.f8151i) {
                    return false;
                }
                this.f8147e.l();
                this.f8151i = true;
            }
        }
        return true;
    }

    final boolean a() {
        AbstractC0436j1 abstractC0436j1 = this.f8150h;
        if (abstractC0436j1 == null) {
            if (this.f8151i) {
                return false;
            }
            h();
            j();
            this.f8149g = 0L;
            this.f8147e.m(this.f8146d.getExactSizeIfKnown());
            return f();
        }
        long j2 = this.f8149g + 1;
        this.f8149g = j2;
        boolean z = j2 < abstractC0436j1.count();
        if (z) {
            return z;
        }
        this.f8149g = 0L;
        this.f8150h.clear();
        return f();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        h();
        int iW = T2.w(this.f8144b.r0()) & T2.a;
        return (iW & 64) != 0 ? (iW & (-16449)) | (this.f8146d.characteristics() & 16448) : iW;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        h();
        return this.f8146d.estimateSize();
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        if (j$.time.a.h(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        h();
        if (T2.SIZED.n(this.f8144b.r0())) {
            return this.f8146d.getExactSizeIfKnown();
        }
        return -1L;
    }

    final void h() {
        if (this.f8146d == null) {
            this.f8146d = (Spliterator) this.f8145c.get();
            this.f8145c = null;
        }
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i2) {
        return j$.time.a.h(this, i2);
    }

    abstract void j();

    abstract W2 k(Spliterator spliterator);

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.f8146d);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        if (!this.a || this.f8151i) {
            return null;
        }
        h();
        Spliterator spliteratorTrySplit = this.f8146d.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return k(spliteratorTrySplit);
    }
}
