package k.a.a.a.m0;

/* JADX INFO: compiled from: Interval.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static final h a = new h(-1, -2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h[] f8510b = new h[1001];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8512d;

    public h(int i2, int i3) {
        this.f8511c = i2;
        this.f8512d = i3;
    }

    public static h c(int i2, int i3) {
        if (i2 != i3 || i2 < 0 || i2 > 1000) {
            return new h(i2, i3);
        }
        h[] hVarArr = f8510b;
        if (hVarArr[i2] == null) {
            hVarArr[i2] = new h(i2, i2);
        }
        return hVarArr[i2];
    }

    public boolean a(h hVar) {
        return this.f8511c == hVar.f8512d + 1 || this.f8512d == hVar.f8511c - 1;
    }

    public boolean b(h hVar) {
        int i2 = this.f8511c;
        int i3 = hVar.f8511c;
        if (!(i2 < i3 && this.f8512d < i3)) {
            if (!(i2 > hVar.f8512d)) {
                return false;
            }
        }
        return true;
    }

    public h d(h hVar) {
        return c(Math.min(this.f8511c, hVar.f8511c), Math.max(this.f8512d, hVar.f8512d));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f8511c == hVar.f8511c && this.f8512d == hVar.f8512d;
    }

    public int hashCode() {
        return ((713 + this.f8511c) * 31) + this.f8512d;
    }

    public String toString() {
        return this.f8511c + ".." + this.f8512d;
    }
}
