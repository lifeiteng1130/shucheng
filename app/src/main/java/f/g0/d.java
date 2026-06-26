package f.g0;

import f.c0.b.l;
import f.c0.c.j;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> implements e<T> {
    public final f.c0.b.a<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<T, T> f6137b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, f.c0.c.z.a, j$.util.Iterator {

        @Nullable
        public T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6138b = -2;

        public a() {
        }

        public final void a() {
            T tInvoke;
            if (this.f6138b == -2) {
                tInvoke = d.this.a.invoke();
            } else {
                l<T, T> lVar = d.this.f6137b;
                T t = this.a;
                j.c(t);
                tInvoke = lVar.invoke(t);
            }
            this.a = tInvoke;
            this.f6138b = tInvoke == null ? 0 : 1;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f6138b < 0) {
                a();
            }
            return this.f6138b == 1;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        @NotNull
        public T next() {
            if (this.f6138b < 0) {
                a();
            }
            if (this.f6138b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.a;
            Objects.requireNonNull(t, "null cannot be cast to non-null type T");
            this.f6138b = -1;
            return t;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull f.c0.b.a<? extends T> aVar, @NotNull l<? super T, ? extends T> lVar) {
        j.e(aVar, "getInitialValue");
        j.e(lVar, "getNextValue");
        this.a = aVar;
        this.f6137b = lVar;
    }

    @Override // f.g0.e
    @NotNull
    public java.util.Iterator<T> iterator() {
        return new a();
    }
}
