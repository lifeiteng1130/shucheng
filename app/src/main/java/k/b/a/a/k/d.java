package k.b.a.a.k;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: Triple.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<L, M, R> implements Comparable<d<L, M, R>>, Serializable {
    public static final d<?, ?, ?>[] EMPTY_ARRAY = new a[0];
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: Triple.java */
    public static final class a<L, M, R> extends d<L, M, R> {
        private static final long serialVersionUID = 1;

        @Override // k.b.a.a.k.d, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((d) obj);
        }

        @Override // k.b.a.a.k.d
        public L getLeft() {
            return null;
        }

        @Override // k.b.a.a.k.d
        public M getMiddle() {
            return null;
        }

        @Override // k.b.a.a.k.d
        public R getRight() {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, M, R> d<L, M, R>[] emptyArray() {
        return (d<L, M, R>[]) EMPTY_ARRAY;
    }

    public static <L, M, R> d<L, M, R> of(L l2, M m, R r) {
        return new b(l2, m, r);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Objects.equals(getLeft(), dVar.getLeft()) && Objects.equals(getMiddle(), dVar.getMiddle()) && Objects.equals(getRight(), dVar.getRight());
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        return (Objects.hashCode(getLeft()) ^ Objects.hashCode(getMiddle())) ^ Objects.hashCode(getRight());
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("(");
        sbR.append(getLeft());
        sbR.append(",");
        sbR.append(getMiddle());
        sbR.append(",");
        sbR.append(getRight());
        sbR.append(")");
        return sbR.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(d<L, M, R> dVar) {
        k.b.a.a.g.a aVar = new k.b.a.a.g.a();
        aVar.a(getLeft(), dVar.getLeft(), null);
        aVar.a(getMiddle(), dVar.getMiddle(), null);
        aVar.a(getRight(), dVar.getRight(), null);
        return aVar.a;
    }

    public String toString(String str) {
        return String.format(str, getLeft(), getMiddle(), getRight());
    }
}
