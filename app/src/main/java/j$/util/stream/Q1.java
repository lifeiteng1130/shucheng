package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;
import j$.util.stream.AbstractC0496y2;
import j$.util.stream.AbstractC0499z1;
import j$.util.stream.D1;
import j$.util.stream.R1;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Q1 {
    public static void a(A2.e eVar, Double d2) {
        if (i3.a) {
            i3.a(eVar.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        eVar.accept(d2.doubleValue());
    }

    public static void b(A2.f fVar, Integer num) {
        if (i3.a) {
            i3.a(fVar.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        fVar.accept(num.intValue());
    }

    public static void c(A2.g gVar, Long l2) {
        if (i3.a) {
            i3.a(gVar.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        gVar.accept(l2.longValue());
    }

    public static Object[] d(R1.e eVar, j$.util.function.z zVar) {
        if (i3.a) {
            i3.a(eVar.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (eVar.count() >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) zVar.apply((int) eVar.count());
        eVar.i(objArr, 0);
        return objArr;
    }

    public static void e(R1.b bVar, Double[] dArr, int i2) {
        if (i3.a) {
            i3.a(bVar.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) bVar.e();
        for (int i3 = 0; i3 < dArr2.length; i3++) {
            dArr[i2 + i3] = Double.valueOf(dArr2[i3]);
        }
    }

    public static void f(R1.c cVar, Integer[] numArr, int i2) {
        if (i3.a) {
            i3.a(cVar.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) cVar.e();
        for (int i3 = 0; i3 < iArr.length; i3++) {
            numArr[i2 + i3] = Integer.valueOf(iArr[i3]);
        }
    }

    public static void g(R1.d dVar, Long[] lArr, int i2) {
        if (i3.a) {
            i3.a(dVar.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) dVar.e();
        for (int i3 = 0; i3 < jArr.length; i3++) {
            lArr[i2 + i3] = Long.valueOf(jArr[i3]);
        }
    }

    public static void h(R1.b bVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.s) {
            bVar.g((j$.util.function.s) consumer);
        } else {
            if (i3.a) {
                i3.a(bVar.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((Spliterator.a) bVar.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void i(R1.c cVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.y) {
            cVar.g((j$.util.function.y) consumer);
        } else {
            if (i3.a) {
                i3.a(cVar.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((Spliterator.b) cVar.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void j(R1.d dVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.E) {
            dVar.g((j$.util.function.E) consumer);
        } else {
            if (i3.a) {
                i3.a(dVar.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((Spliterator.c) dVar.spliterator()).forEachRemaining(consumer);
        }
    }

    public static R1.b k(R1.b bVar, long j2, long j3, j$.util.function.z zVar) {
        if (j2 == 0 && j3 == bVar.count()) {
            return bVar;
        }
        long j4 = j3 - j2;
        Spliterator.a aVar = (Spliterator.a) bVar.spliterator();
        R1.a.InterfaceC0221a interfaceC0221aJ = S1.j(j4);
        interfaceC0221aJ.m(j4);
        for (int i2 = 0; i2 < j2 && aVar.tryAdvance(new j$.util.function.s() { // from class: j$.util.stream.g0
            @Override // j$.util.function.s
            public final void accept(double d2) {
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar) {
                Objects.requireNonNull(sVar);
                return new C0392f(this, sVar);
            }
        }); i2++) {
        }
        for (int i3 = 0; i3 < j4 && aVar.tryAdvance(interfaceC0221aJ); i3++) {
        }
        interfaceC0221aJ.l();
        return interfaceC0221aJ.a();
    }

    public static R1.c l(R1.c cVar, long j2, long j3, j$.util.function.z zVar) {
        if (j2 == 0 && j3 == cVar.count()) {
            return cVar;
        }
        long j4 = j3 - j2;
        Spliterator.b bVar = (Spliterator.b) cVar.spliterator();
        R1.a.b bVarP = S1.p(j4);
        bVarP.m(j4);
        for (int i2 = 0; i2 < j2 && bVar.tryAdvance(new j$.util.function.y() { // from class: j$.util.stream.h0
            @Override // j$.util.function.y
            public final void accept(int i3) {
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar) {
                Objects.requireNonNull(yVar);
                return new C0395i(this, yVar);
            }
        }); i2++) {
        }
        for (int i3 = 0; i3 < j4 && bVar.tryAdvance(bVarP); i3++) {
        }
        bVarP.l();
        return bVarP.a();
    }

    public static R1.d m(R1.d dVar, long j2, long j3, j$.util.function.z zVar) {
        if (j2 == 0 && j3 == dVar.count()) {
            return dVar;
        }
        long j4 = j3 - j2;
        Spliterator.c cVar = (Spliterator.c) dVar.spliterator();
        R1.a.c cVarQ = S1.q(j4);
        cVarQ.m(j4);
        for (int i2 = 0; i2 < j2 && cVar.tryAdvance(new j$.util.function.E() { // from class: j$.util.stream.i0
            @Override // j$.util.function.E
            public final void accept(long j5) {
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e2) {
                Objects.requireNonNull(e2);
                return new C0396j(this, e2);
            }
        }); i2++) {
        }
        for (int i3 = 0; i3 < j4 && cVar.tryAdvance(cVarQ); i3++) {
        }
        cVarQ.l();
        return cVarQ.a();
    }

    public static R1 n(R1 r1, long j2, long j3, j$.util.function.z zVar) {
        if (j2 == 0 && j3 == r1.count()) {
            return r1;
        }
        Spliterator spliterator = r1.spliterator();
        long j4 = j3 - j2;
        R1.a aVarD = S1.d(j4, zVar);
        aVarD.m(j4);
        for (int i2 = 0; i2 < j2 && spliterator.b(new Consumer() { // from class: j$.util.stream.f0
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        }); i2++) {
        }
        for (int i3 = 0; i3 < j4 && spliterator.b(aVarD); i3++) {
        }
        aVarD.l();
        return aVarD.a();
    }

    public static InterfaceC0471s1 o(Spliterator.a aVar, boolean z) {
        return new AbstractC0460p1.g(aVar, T2.l(aVar), z);
    }

    public static C1 p(Spliterator.b bVar, boolean z) {
        return new AbstractC0499z1.i(bVar, T2.l(bVar), z);
    }

    public static H1 q(Spliterator.c cVar, boolean z) {
        return new D1.g(cVar, T2.l(cVar), z);
    }

    public static g3 r(final j$.util.function.u uVar, final N1 n1) {
        Objects.requireNonNull(uVar);
        Objects.requireNonNull(n1);
        return new O1(U2.DOUBLE_VALUE, n1, new Supplier() { // from class: j$.util.stream.a0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new L1(n1, uVar);
            }
        });
    }

    public static g3 s(final j$.util.function.A a, final N1 n1) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(n1);
        return new O1(U2.INT_VALUE, n1, new Supplier() { // from class: j$.util.stream.c0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new J1(n1, a);
            }
        });
    }

    public static g3 t(final j$.util.function.G g2, final N1 n1) {
        Objects.requireNonNull(g2);
        Objects.requireNonNull(n1);
        return new O1(U2.LONG_VALUE, n1, new Supplier() { // from class: j$.util.stream.d0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new K1(n1, g2);
            }
        });
    }

    public static g3 u(final Predicate predicate, final N1 n1) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(n1);
        return new O1(U2.REFERENCE, n1, new Supplier() { // from class: j$.util.stream.b0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new I1(n1, predicate);
            }
        });
    }

    public static Stream v(Spliterator spliterator, boolean z) {
        Objects.requireNonNull(spliterator);
        return new AbstractC0496y2.k(spliterator, T2.l(spliterator), z);
    }
}
