package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0395i;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import j$.util.stream.S2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class a3<P_IN> extends W2<P_IN, Integer, S2.c> implements Spliterator.b {
    a3(T1 t1, Spliterator spliterator, boolean z) {
        super(t1, spliterator, z);
    }

    a3(T1 t1, Supplier supplier, boolean z) {
        super(t1, supplier, z);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return j$.util.s.f(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(final j$.util.function.y yVar) {
        if (this.f8150h != null || this.f8151i) {
            while (n(yVar)) {
            }
            return;
        }
        Objects.requireNonNull(yVar);
        h();
        this.f8144b.t0(new A2.f() { // from class: j$.util.stream.e
            @Override // j$.util.stream.A2
            public /* synthetic */ void accept(double d2) {
                j$.time.a.c(this);
                throw null;
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public final void accept(int i2) {
                yVar.accept(i2);
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
            public /* synthetic */ void accept(Integer num) {
                Q1.b(this, num);
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar2) {
                Objects.requireNonNull(yVar2);
                return new C0395i(this, yVar2);
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
        j$.util.s.b(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean n(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        boolean zA = a();
        if (zA) {
            S2.c cVar = (S2.c) this.f8150h;
            long j2 = this.f8149g;
            int iV = cVar.v(j2);
            yVar.accept((cVar.f8219c == 0 && iV == 0) ? ((int[]) cVar.f8118e)[(int) j2] : ((int[][]) cVar.f8119f)[iV][(int) (j2 - cVar.f8220d[iV])]);
        }
        return zA;
    }

    @Override // j$.util.stream.W2
    void j() {
        final S2.c cVar = new S2.c();
        this.f8150h = cVar;
        this.f8147e = this.f8144b.u0(new A2.f() { // from class: j$.util.stream.L0
            @Override // j$.util.stream.A2
            public /* synthetic */ void accept(double d2) {
                j$.time.a.c(this);
                throw null;
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public final void accept(int i2) {
                cVar.accept(i2);
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
            public /* synthetic */ void accept(Integer num) {
                Q1.b(this, num);
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar) {
                Objects.requireNonNull(yVar);
                return new C0395i(this, yVar);
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
        this.f8148f = new j$.util.function.q() { // from class: j$.util.stream.z0
            @Override // j$.util.function.q
            public final boolean a() {
                a3 a3Var = this.a;
                return a3Var.f8146d.b(a3Var.f8147e);
            }
        };
    }

    @Override // j$.util.stream.W2
    W2 k(Spliterator spliterator) {
        return new a3(this.f8144b, spliterator, this.a);
    }

    @Override // j$.util.stream.W2, j$.util.Spliterator
    public Spliterator.b trySplit() {
        return (Spliterator.b) super.trySplit();
    }
}
