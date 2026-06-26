package f.e0;

import f.x.l;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends l {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6132d;

    public c(int i2, int i3, int i4) {
        this.f6132d = i4;
        this.a = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f6130b = z;
        this.f6131c = z ? i2 : i3;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.f6130b;
    }

    @Override // f.x.l
    public int nextInt() {
        int i2 = this.f6131c;
        if (i2 != this.a) {
            this.f6131c = this.f6132d + i2;
        } else {
            if (!this.f6130b) {
                throw new NoSuchElementException();
            }
            this.f6130b = false;
        }
        return i2;
    }
}
