package c.e.c.a0.d;

import c.e.c.s;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FinderPatternFinder.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1332c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f1334e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f1331b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f1333d = new int[5];

    /* JADX INFO: compiled from: FinderPatternFinder.java */
    public static final class b implements Serializable, Comparator<d>, j$.util.Comparator {
        private final float average;

        public b(float f2, a aVar) {
            this.average = f2;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(d dVar, d dVar2) {
            int iCompare = Integer.compare(dVar2.f1330d, dVar.f1330d);
            return iCompare == 0 ? Float.compare(Math.abs(dVar.f1329c - this.average), Math.abs(dVar2.f1329c - this.average)) : iCompare;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* JADX INFO: compiled from: FinderPatternFinder.java */
    public static final class c implements Serializable, java.util.Comparator<d>, j$.util.Comparator {
        private final float average;

        public c(float f2, a aVar) {
            this.average = f2;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.f1329c - this.average), Math.abs(dVar.f1329c - this.average));
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public e(c.e.c.v.b bVar, s sVar) {
        this.a = bVar;
        this.f1334e = sVar;
    }

    public static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean c(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    public final void b(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    public final int[] d() {
        b(this.f1333d);
        return this.f1333d;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0346 A[LOOP:19: B:201:0x02e1->B:215:0x0346, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(int[] r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.a0.d.e.e(int[], int, int):boolean");
    }

    public final boolean f() {
        int size = this.f1331b.size();
        float fAbs = 0.0f;
        int i2 = 0;
        float f2 = 0.0f;
        for (d dVar : this.f1331b) {
            if (dVar.f1330d >= 2) {
                i2++;
                f2 += dVar.f1329c;
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f3 = f2 / size;
        Iterator<d> it = this.f1331b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().f1329c - f3);
        }
        return fAbs <= f2 * 0.05f;
    }

    public final void g(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
