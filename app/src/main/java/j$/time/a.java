package j$.time;

import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.List;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.o;
import j$.util.r;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.v;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class a {
    public static Spliterator A(Collection collection) {
        return collection instanceof j$.util.Collection ? ((j$.util.Collection) collection).spliterator() : collection instanceof LinkedHashSet ? v.m((LinkedHashSet) collection, 17) : collection instanceof SortedSet ? s.d((SortedSet) collection) : collection instanceof Set ? Set.CC.$default$spliterator((java.util.Set) collection) : collection instanceof List ? List.CC.$default$spliterator((java.util.List) collection) : Collection.CC.$default$spliterator(collection);
    }

    public static /* synthetic */ Comparator B(Comparator comparator, Comparator comparator2) {
        return comparator instanceof j$.util.Comparator ? ((j$.util.Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public static void a(A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void b(A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void c(A2 a2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static int d(j$.time.chrono.c cVar, j$.time.chrono.c cVar2) {
        int iS = cVar.c().compareTo(cVar2.c());
        if (iS != 0) {
            return iS;
        }
        int iT = cVar.b().compareTo(cVar2.b());
        return iT == 0 ? cVar.a().compareTo(cVar2.a()) : iT;
    }

    public static void e(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static int f(j$.time.temporal.k kVar, j$.time.temporal.l lVar) {
        q qVarJ = kVar.j(lVar);
        if (!qVarJ.g()) {
            throw new p("Invalid field " + lVar + " for get() method, use getLong() instead");
        }
        long jL = kVar.l(lVar);
        if (qVarJ.h(jL)) {
            return (int) jL;
        }
        throw new c("Invalid value for " + lVar + " (valid values " + qVarJ + "): " + jL);
    }

    public static long g(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static boolean h(Spliterator spliterator, int i2) {
        return (spliterator.characteristics() & i2) == i2;
    }

    public static Object i(j$.time.chrono.c cVar, n nVar) {
        int i2 = m.a;
        if (nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a) {
            return null;
        }
        return nVar == j$.time.temporal.f.a ? cVar.b() : nVar == j$.time.temporal.b.a ? cVar.a() : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(cVar);
    }

    public static Object j(j$.time.temporal.k kVar, n nVar) {
        int i2 = m.a;
        if (nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.b.a || nVar == j$.time.temporal.e.a) {
            return null;
        }
        return nVar.a(kVar);
    }

    public static q k(j$.time.temporal.k kVar, j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            Objects.requireNonNull(lVar, "field");
            return lVar.t(kVar);
        }
        if (kVar.d(lVar)) {
            return lVar.h();
        }
        throw new p("Unsupported field: " + lVar);
    }

    public static long l(j$.time.chrono.c cVar, j jVar) {
        Objects.requireNonNull(jVar, "offset");
        return ((cVar.c().m() * 86400) + ((long) cVar.b().C())) - ((long) jVar.y());
    }

    public static o m(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? o.d(optional.get()) : o.a();
    }

    public static j$.util.p n(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? j$.util.p.d(optionalDouble.getAsDouble()) : j$.util.p.a();
    }

    public static j$.util.q o(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? j$.util.q.d(optionalInt.getAsInt()) : j$.util.q.a();
    }

    public static r p(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? r.d(optionalLong.getAsLong()) : r.a();
    }

    public static Optional q(o oVar) {
        if (oVar == null) {
            return null;
        }
        return oVar.c() ? Optional.of(oVar.b()) : Optional.empty();
    }

    public static OptionalDouble r(j$.util.p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.c() ? OptionalDouble.of(pVar.b()) : OptionalDouble.empty();
    }

    public static OptionalInt s(j$.util.q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.c() ? OptionalInt.of(qVar.b()) : OptionalInt.empty();
    }

    public static OptionalLong t(r rVar) {
        if (rVar == null) {
            return null;
        }
        return rVar.c() ? OptionalLong.of(rVar.b()) : OptionalLong.empty();
    }

    public static boolean u(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void v(java.util.Collection collection, Consumer consumer) {
        if (collection instanceof j$.util.Collection) {
            ((j$.util.Collection) collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static /* synthetic */ long w(long j2, long j3) {
        long j4 = j2 + j3;
        if (((j3 ^ j2) < 0) || ((j2 ^ j4) >= 0)) {
            return j4;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long x(long j2, long j3) {
        long j4 = j2 % j3;
        if (j4 == 0) {
            return 0L;
        }
        return (((j2 ^ j3) >> 63) | 1) > 0 ? j4 : j4 + j3;
    }

    public static /* synthetic */ long y(long j2, long j3) {
        long j4 = j2 / j3;
        return (j2 - (j3 * j4) != 0 && (((j2 ^ j3) >> 63) | 1) < 0) ? j4 - 1 : j4;
    }

    public static /* synthetic */ long z(long j2, long j3) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2);
        if (iNumberOfLeadingZeros > 65) {
            return j2 * j3;
        }
        if (iNumberOfLeadingZeros >= 64) {
            if ((j2 >= 0) | (j3 != Long.MIN_VALUE)) {
                long j4 = j2 * j3;
                if (j2 == 0 || j4 / j2 == j3) {
                    return j4;
                }
            }
        }
        throw new ArithmeticException();
    }
}
