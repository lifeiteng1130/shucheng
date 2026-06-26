package f.e0;

import c.b.a.m.f;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Iterable<Integer>, f.c0.c.z.a, Iterable {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6129c;

    public b(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = i2;
        if (i4 > 0) {
            if (i2 < i3) {
                i3 -= f.X3(f.X3(i3, i4) - f.X3(i2, i4), i4);
            }
        } else {
            if (i4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i2 > i3) {
                int i5 = -i4;
                i3 += f.X3(f.X3(i2, i5) - f.X3(i3, i5), i5);
            }
        }
        this.f6128b = i3;
        this.f6129c = i4;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.a != bVar.a || this.f6128b != bVar.f6128b || this.f6129c != bVar.f6129c) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.f6128b) * 31) + this.f6129c;
    }

    public boolean isEmpty() {
        if (this.f6129c > 0) {
            if (this.a > this.f6128b) {
                return true;
            }
        } else if (this.a < this.f6128b) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public Iterator iterator() {
        return new c(this.a, this.f6128b, this.f6129c);
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f6129c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.f6128b);
            sb.append(" step ");
            i2 = this.f6129c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.f6128b);
            sb.append(" step ");
            i2 = -this.f6129c;
        }
        sb.append(i2);
        return sb.toString();
    }
}
