package f.c0.c;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements Iterator<T>, f.c0.c.z.a, j$.util.Iterator {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final T[] f6121b;

    public a(@NotNull T[] tArr) {
        j.e(tArr, "array");
        this.f6121b = tArr;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.a < this.f6121b.length;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f6121b;
            int i2 = this.a;
            this.a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
