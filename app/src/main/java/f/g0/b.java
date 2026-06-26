package f.g0;

import f.c0.c.j;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements e<T>, c<T> {
    public final e<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6135b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, f.c0.c.z.a, j$.util.Iterator {

        @NotNull
        public final Iterator<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6136b;

        public a(b bVar) {
            this.a = bVar.a.iterator();
            this.f6136b = bVar.f6135b;
        }

        public final void a() {
            while (this.f6136b > 0 && this.a.hasNext()) {
                this.a.next();
                this.f6136b--;
            }
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            a();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            a();
            return this.a.next();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull e<? extends T> eVar, int i2) {
        j.e(eVar, "sequence");
        this.a = eVar;
        this.f6135b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // f.g0.c
    @NotNull
    public e<T> a(int i2) {
        int i3 = this.f6135b + i2;
        return i3 < 0 ? new b(this, i2) : new b(this.a, i3);
    }

    @Override // f.g0.e
    @NotNull
    public java.util.Iterator<T> iterator() {
        return new a(this);
    }
}
