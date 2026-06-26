package f.g0;

import f.c0.b.l;
import f.c0.c.j;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T, R> implements e<R> {
    public final e<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<T, R> f6140b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, f.c0.c.z.a, j$.util.Iterator {

        @NotNull
        public final Iterator<T> a;

        public a() {
            this.a = g.this.a.iterator();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public R next() {
            return (R) g.this.f6140b.invoke(this.a.next());
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull e<? extends T> eVar, @NotNull l<? super T, ? extends R> lVar) {
        j.e(eVar, "sequence");
        j.e(lVar, "transformer");
        this.a = eVar;
        this.f6140b = lVar;
    }

    @Override // f.g0.e
    @NotNull
    public java.util.Iterator<R> iterator() {
        return new a();
    }
}
