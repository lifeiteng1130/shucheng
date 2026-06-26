package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;
import java.util.Objects;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s {
    public static void a(Spliterator.a aVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.s) {
            aVar.forEachRemaining((j$.util.function.s) consumer);
        } else {
            if (w.a) {
                w.a(aVar.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            aVar.forEachRemaining(new j(consumer));
        }
    }

    public static void b(Spliterator.b bVar, Consumer consumer) {
        if (consumer instanceof y) {
            bVar.forEachRemaining((y) consumer);
        } else {
            if (w.a) {
                w.a(bVar.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            bVar.forEachRemaining(new h(consumer));
        }
    }

    public static void c(Spliterator.c cVar, Consumer consumer) {
        if (consumer instanceof E) {
            cVar.forEachRemaining((E) consumer);
        } else {
            if (w.a) {
                w.a(cVar.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            cVar.forEachRemaining(new g(consumer));
        }
    }

    public static Spliterator d(SortedSet sortedSet) {
        return new u(sortedSet, sortedSet, 21);
    }

    public static boolean e(Spliterator.a aVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.s) {
            return aVar.tryAdvance((j$.util.function.s) consumer);
        }
        if (w.a) {
            w.a(aVar.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return aVar.tryAdvance(new j(consumer));
    }

    public static boolean f(Spliterator.b bVar, Consumer consumer) {
        if (consumer instanceof y) {
            return bVar.tryAdvance((y) consumer);
        }
        if (w.a) {
            w.a(bVar.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return bVar.tryAdvance(new h(consumer));
    }

    public static boolean g(Spliterator.c cVar, Consumer consumer) {
        if (consumer instanceof E) {
            return cVar.tryAdvance((E) consumer);
        }
        if (w.a) {
            w.a(cVar.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return cVar.tryAdvance(new g(consumer));
    }
}
