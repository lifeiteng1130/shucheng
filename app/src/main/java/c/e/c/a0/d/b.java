package c.e.c.a0.d;

import c.e.c.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AlignmentPatternFinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f1325g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s f1327i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f1320b = new ArrayList(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f1326h = new int[3];

    public b(c.e.c.v.b bVar, int i2, int i3, int i4, int i5, float f2, s sVar) {
        this.a = bVar;
        this.f1321c = i2;
        this.f1322d = i3;
        this.f1323e = i4;
        this.f1324f = i5;
        this.f1325g = f2;
        this.f1327i = sVar;
    }

    public static float a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final boolean b(int[] iArr) {
        float f2 = this.f1325g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c.e.c.a0.d.a c(int[] r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.a0.d.b.c(int[], int, int):c.e.c.a0.d.a");
    }
}
