package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import j$.util.stream.S2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class Z2<P_IN> extends W2<P_IN, Double, S2.b> implements Spliterator.a {
    Z2(T1 t1, Spliterator spliterator, boolean z) {
        super(t1, spliterator, z);
    }

    Z2(T1 t1, Supplier supplier, boolean z) {
        super(t1, supplier, z);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return j$.util.s.e(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    public void e(final j$.util.function.s sVar) {
        if (this.f8150h != null || this.f8151i) {
            while (n(sVar)) {
            }
            return;
        }
        Objects.requireNonNull(sVar);
        h();
        this.f8144b.t0(new A2.e() { // from class: j$.util.stream.l0
            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public final void accept(double d2) {
                sVar.accept(d2);
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
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Double d2) {
                Q1.a(this, d2);
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar2) {
                Objects.requireNonNull(sVar2);
                return new C0392f(this, sVar2);
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
        j$.util.s.a(this, consumer);
    }

    @Override // j$.util.stream.W2
    void j() {
        final S2.b bVar = new S2.b();
        this.f8150h = bVar;
        this.f8147e = this.f8144b.u0(new A2.e() { // from class: j$.util.stream.T0
            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public final void accept(double d2) {
                bVar.accept(d2);
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
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Double d2) {
                Q1.a(this, d2);
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar) {
                Objects.requireNonNull(sVar);
                return new C0392f(this, sVar);
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
        this.f8148f = new j$.util.function.q() { // from class: j$.util.stream.y0
            @Override // j$.util.function.q
            public final boolean a() {
                Z2 z2 = this.a;
                return z2.f8146d.b(z2.f8147e);
            }
        };
    }

    @Override // j$.util.stream.W2
    W2 k(Spliterator spliterator) {
        return new Z2(this.f8144b, spliterator, this.a);
    }

    @Override // j$.util.Spliterator.d
    public boolean n(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        boolean zA = a();
        if (zA) {
            S2.b bVar = (S2.b) this.f8150h;
            long j2 = this.f8149g;
            int iV = bVar.v(j2);
            sVar.accept((bVar.f8219c == 0 && iV == 0) ? ((double[]) bVar.f8118e)[(int) j2] : ((double[][]) bVar.f8119f)[iV][(int) (j2 - bVar.f8220d[iV])]);
        }
        return zA;
    }

    @Override // j$.util.stream.W2, j$.util.Spliterator
    public Spliterator.a trySplit() {
        return (Spliterator.a) super.trySplit();
    }
}
