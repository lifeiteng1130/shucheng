package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.stream.R1;
import java.util.Objects;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: renamed from: j$.util.stream.x1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C0491x1<S, T> extends CountedCompleter<Void> {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T1 f8280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Spliterator f8281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f8282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap f8283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final A2 f8284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final C0491x1 f8285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private R1 f8286h;

    protected C0491x1(T1 t1, Spliterator spliterator, A2 a2) {
        super(null);
        this.f8280b = t1;
        this.f8281c = spliterator;
        this.f8282d = AbstractC0440k1.h(spliterator.estimateSize());
        this.f8283e = new ConcurrentHashMap(Math.max(16, AbstractC0440k1.a << 1));
        this.f8284f = a2;
        this.f8285g = null;
    }

    C0491x1(C0491x1 c0491x1, Spliterator spliterator, C0491x1 c0491x12) {
        super(c0491x1);
        this.f8280b = c0491x1.f8280b;
        this.f8281c = spliterator;
        this.f8282d = c0491x1.f8282d;
        this.f8283e = c0491x1.f8283e;
        this.f8284f = c0491x1.f8284f;
        this.f8285g = c0491x12;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f8281c;
        long j2 = this.f8282d;
        boolean z = false;
        C0491x1<S, T> c0491x1 = this;
        while (spliterator.estimateSize() > j2 && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            C0491x1<S, T> c0491x12 = new C0491x1<>(c0491x1, spliteratorTrySplit, c0491x1.f8285g);
            C0491x1<S, T> c0491x13 = new C0491x1<>(c0491x1, spliterator, c0491x12);
            c0491x1.addToPendingCount(1);
            c0491x13.addToPendingCount(1);
            c0491x1.f8283e.put(c0491x12, c0491x13);
            if (c0491x1.f8285g != null) {
                c0491x12.addToPendingCount(1);
                if (c0491x1.f8283e.replace(c0491x1.f8285g, c0491x1, c0491x12)) {
                    c0491x1.addToPendingCount(-1);
                } else {
                    c0491x12.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = spliteratorTrySplit;
                c0491x1 = c0491x12;
                c0491x12 = c0491x13;
            } else {
                c0491x1 = c0491x13;
            }
            z = !z;
            c0491x12.fork();
        }
        if (c0491x1.getPendingCount() > 0) {
            C0497z c0497z = new j$.util.function.z() { // from class: j$.util.stream.z
                @Override // j$.util.function.z
                public final Object apply(int i2) {
                    int i3 = C0491x1.a;
                    return new Object[i2];
                }
            };
            T1 t1 = c0491x1.f8280b;
            R1.a aVarS0 = t1.s0(t1.p0(spliterator), c0497z);
            AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) c0491x1.f8280b;
            Objects.requireNonNull(abstractC0428h1);
            Objects.requireNonNull(aVarS0);
            abstractC0428h1.m0(abstractC0428h1.u0(aVarS0), spliterator);
            c0491x1.f8286h = aVarS0.a();
            c0491x1.f8281c = null;
        }
        c0491x1.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        R1 r1 = this.f8286h;
        if (r1 != null) {
            r1.forEach(this.f8284f);
            this.f8286h = null;
        } else {
            Spliterator spliterator = this.f8281c;
            if (spliterator != null) {
                T1 t1 = this.f8280b;
                A2 a2 = this.f8284f;
                AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) t1;
                Objects.requireNonNull(abstractC0428h1);
                Objects.requireNonNull(a2);
                abstractC0428h1.m0(abstractC0428h1.u0(a2), spliterator);
                this.f8281c = null;
            }
        }
        C0491x1 c0491x1 = (C0491x1) this.f8283e.remove(this);
        if (c0491x1 != null) {
            c0491x1.tryComplete();
        }
    }
}
