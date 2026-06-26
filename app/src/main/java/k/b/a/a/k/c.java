package k.b.a.a.k;

import j$.util.Map;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c<L, R> implements Map.Entry<L, R>, Comparable<c<L, R>>, Serializable, Map.Entry {
    public static final c<?, ?>[] EMPTY_ARRAY = new a[0];
    private static final long serialVersionUID = 4954918890077093841L;

    /* JADX INFO: compiled from: Pair.java */
    public static final class a<L, R> extends c<L, R> {
        private static final long serialVersionUID = 1;

        @Override // k.b.a.a.k.c, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((c) obj);
        }

        @Override // k.b.a.a.k.c
        public L getLeft() {
            return null;
        }

        @Override // k.b.a.a.k.c
        public R getRight() {
            return null;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public R setValue(R r) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, R> c<L, R>[] emptyArray() {
        return (c<L, R>[]) EMPTY_ARRAY;
    }

    public static <L, R> c<L, R> of(L l2, R r) {
        return k.b.a.a.k.a.of((Object) l2, (Object) r);
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public final L getKey() {
        return getLeft();
    }

    public abstract L getLeft();

    public abstract R getRight();

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public R getValue() {
        return getRight();
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("(");
        sbR.append(getLeft());
        sbR.append(',');
        sbR.append(getRight());
        sbR.append(')');
        return sbR.toString();
    }

    public static <L, R> c<L, R> of(Map.Entry<L, R> entry) {
        return k.b.a.a.k.a.of((Map.Entry) entry);
    }

    @Override // java.lang.Comparable
    public int compareTo(c<L, R> cVar) {
        k.b.a.a.g.a aVar = new k.b.a.a.g.a();
        aVar.a(getLeft(), cVar.getLeft(), null);
        aVar.a(getRight(), cVar.getRight(), null);
        return aVar.a;
    }

    public String toString(String str) {
        return String.format(str, getLeft(), getRight());
    }
}
