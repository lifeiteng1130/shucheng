package g.b.g2;

import g.b.g2.u;
import g.b.r0;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.PublishedApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public class t<T extends u & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;
    public T[] a;

    @PublishedApi
    public final void a(@NotNull T t) {
        r0.c cVar = (r0.c) t;
        cVar.a(this);
        T[] tArr = this.a;
        if (tArr == null) {
            tArr = (T[]) new u[4];
            this.a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, this._size * 2);
            f.c0.c.j.d(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((u[]) objArrCopyOf);
            this.a = tArr;
        }
        int i2 = this._size;
        this._size = i2 + 1;
        tArr[i2] = t;
        cVar.f6295b = i2;
        f(i2);
    }

    @PublishedApi
    @Nullable
    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final boolean c() {
        return this._size == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[SYNTHETIC] */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T d(int r8) {
        /*
            r7 = this;
            T extends g.b.g2.u & java.lang.Comparable<? super T>[] r0 = r7.a
            f.c0.c.j.c(r0)
            int r1 = r7._size
            r2 = -1
            int r1 = r1 + r2
            r7._size = r1
            int r1 = r7._size
            if (r8 >= r1) goto L72
            int r1 = r7._size
            r7.g(r8, r1)
            int r1 = r8 + (-1)
            int r1 = r1 / 2
            if (r8 <= 0) goto L33
            r3 = r0[r8]
            f.c0.c.j.c(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            f.c0.c.j.c(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L33
            r7.g(r8, r1)
            r7.f(r1)
            goto L72
        L33:
            int r1 = r8 * 2
            int r1 = r1 + 1
            int r3 = r7._size
            if (r1 < r3) goto L3c
            goto L72
        L3c:
            T extends g.b.g2.u & java.lang.Comparable<? super T>[] r3 = r7.a
            f.c0.c.j.c(r3)
            int r4 = r1 + 1
            int r5 = r7._size
            if (r4 >= r5) goto L5a
            r5 = r3[r4]
            f.c0.c.j.c(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            r6 = r3[r1]
            f.c0.c.j.c(r6)
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L5a
            r1 = r4
        L5a:
            r4 = r3[r8]
            f.c0.c.j.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r3 = r3[r1]
            f.c0.c.j.c(r3)
            int r3 = r4.compareTo(r3)
            if (r3 > 0) goto L6d
            goto L72
        L6d:
            r7.g(r8, r1)
            r8 = r1
            goto L33
        L72:
            int r8 = r7._size
            r8 = r0[r8]
            f.c0.c.j.c(r8)
            r1 = 0
            r8.a(r1)
            r8.d(r2)
            int r2 = r7._size
            r0[r2] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.g2.t.d(int):g.b.g2.u");
    }

    @Nullable
    public final T e() {
        T t;
        synchronized (this) {
            t = this._size > 0 ? (T) d(0) : null;
        }
        return t;
    }

    public final void f(int i2) {
        while (i2 > 0) {
            T[] tArr = this.a;
            f.c0.c.j.c(tArr);
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            f.c0.c.j.c(t);
            T t2 = tArr[i2];
            f.c0.c.j.c(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            g(i2, i3);
            i2 = i3;
        }
    }

    public final void g(int i2, int i3) {
        T[] tArr = this.a;
        f.c0.c.j.c(tArr);
        T t = tArr[i3];
        f.c0.c.j.c(t);
        T t2 = tArr[i2];
        f.c0.c.j.c(t2);
        tArr[i2] = t;
        tArr[i3] = t2;
        t.d(i2);
        t2.d(i3);
    }
}
