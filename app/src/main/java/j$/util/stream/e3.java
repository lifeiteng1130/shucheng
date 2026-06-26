package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class e3<P_IN, P_OUT> extends W2<P_IN, P_OUT, S2<P_OUT>> {
    e3(T1 t1, Spliterator spliterator, boolean z) {
        super(t1, spliterator, z);
    }

    e3(T1 t1, Supplier supplier, boolean z) {
        super(t1, supplier, z);
    }

    @Override // j$.util.Spliterator
    public boolean b(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean zA = a();
        if (zA) {
            S2 s2 = (S2) this.f8150h;
            long j2 = this.f8149g;
            if (s2.f8219c != 0) {
                if (j2 >= s2.count()) {
                    throw new IndexOutOfBoundsException(Long.toString(j2));
                }
                for (int i2 = 0; i2 <= s2.f8219c; i2++) {
                    long[] jArr = s2.f8220d;
                    long j3 = jArr[i2];
                    Object[][] objArr = s2.f8109f;
                    if (j2 < j3 + ((long) objArr[i2].length)) {
                        obj = objArr[i2][(int) (j2 - jArr[i2])];
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j2));
            }
            if (j2 >= s2.f8218b) {
                throw new IndexOutOfBoundsException(Long.toString(j2));
            }
            obj = s2.f8108e[(int) j2];
            consumer.accept(obj);
        }
        return zA;
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(final Consumer consumer) {
        if (this.f8150h != null || this.f8151i) {
            while (b(consumer)) {
            }
            return;
        }
        Objects.requireNonNull(consumer);
        h();
        this.f8144b.t0(new A2() { // from class: j$.util.stream.N0
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

            @Override // j$.util.stream.A2
            public /* synthetic */ void accept(long j2) {
                j$.time.a.b(this);
                throw null;
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                consumer.accept(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer.CC.$default$andThen(this, consumer2);
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

    @Override // j$.util.stream.W2
    void j() {
        final S2 s2 = new S2();
        this.f8150h = s2;
        this.f8147e = this.f8144b.u0(new A2() { // from class: j$.util.stream.g
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

            @Override // j$.util.stream.A2
            public /* synthetic */ void accept(long j2) {
                j$.time.a.b(this);
                throw null;
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                s2.accept(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
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
        this.f8148f = new j$.util.function.q() { // from class: j$.util.stream.G0
            @Override // j$.util.function.q
            public final boolean a() {
                e3 e3Var = this.a;
                return e3Var.f8146d.b(e3Var.f8147e);
            }
        };
    }

    @Override // j$.util.stream.W2
    W2 k(Spliterator spliterator) {
        return new e3(this.f8144b, spliterator, this.a);
    }
}
