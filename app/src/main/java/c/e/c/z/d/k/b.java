package c.e.c.z.d.k;

/* JADX INFO: compiled from: ModulusGF.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b(929, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f1548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f1549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f1550e;

    public b(int i2, int i3) {
        this.f1547b = new int[i2];
        this.f1548c = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f1547b[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f1548c[this.f1547b[i6]] = i6;
        }
        this.f1549d = new c(this, new int[]{0});
        this.f1550e = new c(this, new int[]{1});
    }

    public int a(int i2, int i3) {
        return (i2 + i3) % 929;
    }

    public c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f1549d;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    public int c(int i2) {
        if (i2 != 0) {
            return this.f1547b[(929 - this.f1548c[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int d(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f1547b;
        int[] iArr2 = this.f1548c;
        return iArr[(iArr2[i2] + iArr2[i3]) % 928];
    }

    public int e(int i2, int i3) {
        return ((i2 + 929) - i3) % 929;
    }
}
