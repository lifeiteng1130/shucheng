package k.b.a.a;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: Range.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> implements Serializable {
    private static final long serialVersionUID = 1;
    public transient int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f8540b;
    private final Comparator<T> comparator;
    private final T maximum;
    private final T minimum;

    /* JADX INFO: compiled from: Range.java */
    public enum a implements Comparator, j$.util.Comparator {
        INSTANCE;

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public d(T t, T t2, java.util.Comparator<T> comparator) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t + ", element2=" + t2);
        }
        if (comparator == null) {
            this.comparator = a.INSTANCE;
        } else {
            this.comparator = comparator;
        }
        if (this.comparator.compare(t, t2) < 1) {
            this.minimum = t;
            this.maximum = t2;
        } else {
            this.minimum = t2;
            this.maximum = t;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lk/b/a/a/d<TT;>; */
    public static d between(Comparable comparable, Comparable comparable2) {
        return between(comparable, comparable2, null);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lk/b/a/a/d<TT;>; */
    public static d is(Comparable comparable) {
        return between(comparable, comparable, null);
    }

    public boolean contains(T t) {
        return t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1;
    }

    public boolean containsRange(d<T> dVar) {
        return dVar != null && contains(dVar.minimum) && contains(dVar.maximum);
    }

    public int elementCompareTo(T t) {
        c.b.a.m.f.e4(t, "Element is null", new Object[0]);
        if (isAfter(t)) {
            return -1;
        }
        return isBefore(t) ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != d.class) {
            return false;
        }
        d dVar = (d) obj;
        return this.minimum.equals(dVar.minimum) && this.maximum.equals(dVar.maximum);
    }

    public T fit(T t) {
        c.b.a.m.f.e4(t, "element", new Object[0]);
        return isAfter(t) ? this.minimum : isBefore(t) ? this.maximum : t;
    }

    public java.util.Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i2 = this.a;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = this.maximum.hashCode() + ((this.minimum.hashCode() + ((d.class.hashCode() + 629) * 37)) * 37);
        this.a = iHashCode;
        return iHashCode;
    }

    public d<T> intersectionWith(d<T> dVar) {
        if (!isOverlappedBy(dVar)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", dVar));
        }
        if (equals(dVar)) {
            return this;
        }
        return between(getComparator().compare(this.minimum, dVar.minimum) < 0 ? dVar.minimum : this.minimum, getComparator().compare(this.maximum, dVar.maximum) < 0 ? this.maximum : dVar.maximum, getComparator());
    }

    public boolean isAfter(T t) {
        return t != null && this.comparator.compare(t, this.minimum) < 0;
    }

    public boolean isAfterRange(d<T> dVar) {
        if (dVar == null) {
            return false;
        }
        return isAfter(dVar.maximum);
    }

    public boolean isBefore(T t) {
        return t != null && this.comparator.compare(t, this.maximum) > 0;
    }

    public boolean isBeforeRange(d<T> dVar) {
        if (dVar == null) {
            return false;
        }
        return isBefore(dVar.minimum);
    }

    public boolean isEndedBy(T t) {
        return t != null && this.comparator.compare(t, this.maximum) == 0;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == a.INSTANCE;
    }

    public boolean isOverlappedBy(d<T> dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.contains(this.minimum) || dVar.contains(this.maximum) || contains(dVar.minimum);
    }

    public boolean isStartedBy(T t) {
        return t != null && this.comparator.compare(t, this.minimum) == 0;
    }

    public String toString() {
        if (this.f8540b == null) {
            StringBuilder sbR = c.a.a.a.a.r("[");
            sbR.append(this.minimum);
            sbR.append("..");
            sbR.append(this.maximum);
            sbR.append("]");
            this.f8540b = sbR.toString();
        }
        return this.f8540b;
    }

    public static <T> d<T> between(T t, T t2, java.util.Comparator<T> comparator) {
        return new d<>(t, t2, comparator);
    }

    public static <T> d<T> is(T t, java.util.Comparator<T> comparator) {
        return between(t, t, comparator);
    }

    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }
}
