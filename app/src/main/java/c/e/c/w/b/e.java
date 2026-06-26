package c.e.c.w.b;

import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e[] a = {new e(1, 10, 10, 8, 8, new c(5, new b(1, 3, null), null)), new e(2, 12, 12, 10, 10, new c(7, new b(1, 5, null), null)), new e(3, 14, 14, 12, 12, new c(10, new b(1, 8, null), null)), new e(4, 16, 16, 14, 14, new c(12, new b(1, 12, null), null)), new e(5, 18, 18, 16, 16, new c(14, new b(1, 18, null), null)), new e(6, 20, 20, 18, 18, new c(18, new b(1, 22, null), null)), new e(7, 22, 22, 20, 20, new c(20, new b(1, 30, null), null)), new e(8, 24, 24, 22, 22, new c(24, new b(1, 36, null), null)), new e(9, 26, 26, 24, 24, new c(28, new b(1, 44, null), null)), new e(10, 32, 32, 14, 14, new c(36, new b(1, 62, null), null)), new e(11, 36, 36, 16, 16, new c(42, new b(1, 86, null), null)), new e(12, 40, 40, 18, 18, new c(48, new b(1, 114, null), null)), new e(13, 44, 44, 20, 20, new c(56, new b(1, Token.DOTDOT, null), null)), new e(14, 48, 48, 22, 22, new c(68, new b(1, 174, null), null)), new e(15, 52, 52, 24, 24, new c(42, new b(2, 102, null), null)), new e(16, 64, 64, 14, 14, new c(56, new b(2, 140, null), null)), new e(17, 72, 72, 16, 16, new c(36, new b(4, 92, null), null)), new e(18, 80, 80, 18, 18, new c(48, new b(4, 114, null), null)), new e(19, 88, 88, 20, 20, new c(56, new b(4, Token.DOTDOT, null), null)), new e(20, 96, 96, 22, 22, new c(68, new b(4, 174, null), null)), new e(21, 104, 104, 24, 24, new c(56, new b(6, Token.JSR, null), null)), new e(22, 120, 120, 18, 18, new c(68, new b(6, 175, null), null)), new e(23, Token.TARGET, Token.TARGET, 20, 20, new c(62, new b(8, Token.GENEXPR, null), null)), new e(24, Token.DOTDOT, Token.DOTDOT, 22, 22, new c(62, new b(8, 156, null), new b(2, 155, null), null)), new e(25, 8, 18, 6, 16, new c(7, new b(1, 5, null), null)), new e(26, 8, 32, 6, 14, new c(11, new b(1, 10, null), null)), new e(27, 12, 26, 10, 24, new c(14, new b(1, 16, null), null)), new e(28, 12, 36, 10, 16, new c(18, new b(1, 22, null), null)), new e(29, 16, 36, 14, 16, new c(24, new b(1, 32, null), null)), new e(30, 16, 48, 14, 22, new c(28, new b(1, 49, null), null))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f1436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1437h;

    /* JADX INFO: compiled from: Version.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1438b;

        public b(int i2, int i3, a aVar) {
            this.a = i2;
            this.f1438b = i3;
        }
    }

    public e(int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f1431b = i2;
        this.f1432c = i3;
        this.f1433d = i4;
        this.f1434e = i5;
        this.f1435f = i6;
        this.f1436g = cVar;
        int i7 = cVar.a;
        int i8 = 0;
        for (b bVar : cVar.f1439b) {
            i8 += (bVar.f1438b + i7) * bVar.a;
        }
        this.f1437h = i8;
    }

    public String toString() {
        return String.valueOf(this.f1431b);
    }

    /* JADX INFO: compiled from: Version.java */
    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f1439b;

        public c(int i2, b bVar, a aVar) {
            this.a = i2;
            this.f1439b = new b[]{bVar};
        }

        public c(int i2, b bVar, b bVar2, a aVar) {
            this.a = i2;
            this.f1439b = new b[]{bVar, bVar2};
        }
    }
}
