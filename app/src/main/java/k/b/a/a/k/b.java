package k.b.a.a.k;

/* JADX INFO: compiled from: ImmutableTriple.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<L, M, R> extends d<L, M, R> {
    public static final b<?, ?, ?>[] EMPTY_ARRAY = new b[0];
    public static final b a = of((Object) null, (Object) null, (Object) null);
    private static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    public b(L l2, M m, R r) {
        this.left = l2;
        this.middle = m;
        this.right = r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, M, R> b<L, M, R>[] emptyArray() {
        return (b<L, M, R>[]) EMPTY_ARRAY;
    }

    public static <L, M, R> b<L, M, R> nullTriple() {
        return a;
    }

    public static <L, M, R> b<L, M, R> of(L l2, M m, R r) {
        return new b<>(l2, m, r);
    }

    @Override // k.b.a.a.k.d
    public L getLeft() {
        return this.left;
    }

    @Override // k.b.a.a.k.d
    public M getMiddle() {
        return this.middle;
    }

    @Override // k.b.a.a.k.d
    public R getRight() {
        return this.right;
    }
}
