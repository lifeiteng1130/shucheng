package k.b.a.a.k;

import java.util.Map;

/* JADX INFO: compiled from: ImmutablePair.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<L, R> extends c<L, R> {
    public static final a<?, ?>[] EMPTY_ARRAY = new a[0];
    public static final a a = of((Object) null, (Object) null);
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public a(L l2, R r) {
        this.left = l2;
        this.right = r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, R> a<L, R>[] emptyArray() {
        return (a<L, R>[]) EMPTY_ARRAY;
    }

    public static <L, R> c<L, R> left(L l2) {
        return of((Object) l2, (Object) null);
    }

    public static <L, R> a<L, R> nullPair() {
        return a;
    }

    public static <L, R> a<L, R> of(L l2, R r) {
        return new a<>(l2, r);
    }

    public static <L, R> c<L, R> right(R r) {
        return of((Object) null, (Object) r);
    }

    @Override // k.b.a.a.k.c
    public L getLeft() {
        return this.left;
    }

    @Override // k.b.a.a.k.c
    public R getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }

    public static <L, R> a<L, R> of(Map.Entry<L, R> entry) {
        R value;
        L key = null;
        if (entry != null) {
            key = entry.getKey();
            value = entry.getValue();
        } else {
            value = null;
        }
        return new a<>(key, value);
    }
}
