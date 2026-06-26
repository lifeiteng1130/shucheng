package f.x;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m implements Iterator<Long>, f.c0.c.z.a, j$.util.Iterator {
    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public abstract long nextLong();

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator, j$.util.Iterator
    @NotNull
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
