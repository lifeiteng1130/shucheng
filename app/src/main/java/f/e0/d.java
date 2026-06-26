package f.e0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends b implements a<Integer> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final d f6133d = new d(1, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final d f6134e = null;

    public d(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // f.e0.a
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(this.f6128b);
    }

    @Override // f.e0.a
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(this.a);
    }

    @Override // f.e0.b
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.a != dVar.a || this.f6128b != dVar.f6128b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // f.e0.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.a * 31) + this.f6128b;
    }

    @Override // f.e0.b
    public boolean isEmpty() {
        return this.a > this.f6128b;
    }

    @Override // f.e0.b
    @NotNull
    public String toString() {
        return this.a + ".." + this.f6128b;
    }
}
