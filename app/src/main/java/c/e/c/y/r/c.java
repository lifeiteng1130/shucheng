package c.e.c.y.r;

import c.e.c.r;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r[] f1486c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.a = i2;
        this.f1485b = iArr;
        float f2 = i5;
        this.f1486c = new r[]{new r(i3, f2), new r(i4, f2)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
