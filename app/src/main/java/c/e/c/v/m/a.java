package c.e.c.v.m;

/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1410b = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f1411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f1413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f1415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f1416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f1417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f1418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f1419k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f1420l;
    public final int m;
    public final int n;
    public final int o;

    static {
        a aVar = new a(67, 64, 1);
        f1411c = aVar;
        f1412d = new a(19, 16, 1);
        f1413e = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f1414f = aVar2;
        f1415g = aVar2;
        f1416h = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.f1417i = new int[i3];
        this.f1418j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f1417i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f1418j[this.f1417i[i7]] = i7;
        }
        this.f1419k = new b(this, new int[]{0});
        this.f1420l = new b(this, new int[]{1});
    }

    public b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f1419k;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    public int b(int i2) {
        if (i2 != 0) {
            return this.f1417i[(this.m - this.f1418j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f1417i;
        int[] iArr2 = this.f1418j;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.m - 1)];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.n));
        sb.append(',');
        return c.a.a.a.a.n(sb, this.m, ')');
    }
}
