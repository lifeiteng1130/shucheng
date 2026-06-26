package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import j$.util.stream.S2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class b3<P_IN> extends W2<P_IN, Long, S2.d> implements Spliterator.c {
    b3(T1 t1, Spliterator spliterator, boolean z) {
        super(t1, spliterator, z);
    }

    b3(T1 t1, Supplier supplier, boolean z) {
        super(t1, supplier, z);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return j$.util.s.g(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e(final j$.util.function.E e2) {
        if (this.f8150h != null || this.f8151i) {
            while (n(e2)) {
            }
            return;
        }
        Objects.requireNonNull(e2);
        h();
        this.f8144b.t0(new A2.g() { // from class: j$.util.stream.V0
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

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public final void accept(long j2) {
                e2.accept(j2);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Long l2) {
                Q1.c(this, l2);
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e3) {
                Objects.requireNonNull(e3);
                return new C0396j(this, e3);
            }

            @Override // j$.util.stream.A2
            public void l() {
            }

            @Override // j$.util.stream.A2
            public void m(long j2) {
            }

            @Override // j$.util.stream.A2
            public /* synthetic */ boolean o() {
                return false;
            }
        }, this.f8146d);
        this.f8151i = true;
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.s.c(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean n(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        boolean zA = a();
        if (zA) {
            S2.d dVar = (S2.d) this.f8150h;
            long j2 = this.f8149g;
            int iV = dVar.v(j2);
            e2.accept((dVar.f8219c == 0 && iV == 0) ? ((long[]) dVar.f8118e)[(int) j2] : ((long[][]) dVar.f8119f)[iV][(int) (j2 - dVar.f8220d[iV])]);
        }
        return zA;
    }

    @Override // j$.util.stream.W2
    void j() {
        final S2.d dVar = new S2.d();
        this.f8150h = dVar;
        this.f8147e = this.f8144b.u0(new A2.g() { // from class: j$.util.stream.n0
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

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public final void accept(long j2) {
                dVar.accept(j2);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Long l2) {
                Q1.c(this, l2);
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e2) {
                Objects.requireNonNull(e2);
                return new C0396j(this, e2);
            }

            @Override // j$.util.stream.A2
            public void l() {
            }

            @Override // j$.util.stream.A2
            public void m(long j2) {
            }

            @Override // j$.util.stream.A2
            public /* synthetic */ boolean o() {
                return false;
            }
        });
        this.f8148f = new j$.util.function.q() { // from class: j$.util.stream.A0
            @Override // j$.util.function.q
            public final boolean a() {
                b3 b3Var = this.a;
                return b3Var.f8146d.b(b3Var.f8147e);
            }
        };
    }

    @Override // j$.util.stream.W2
    W2 k(Spliterator spliterator) {
        return new b3(this.f8144b, spliterator, this.a);
    }

    @Override // j$.util.stream.W2, j$.util.Spliterator
    public Spliterator.c trySplit() {
        return (Spliterator.c) super.trySplit();
    }
}
