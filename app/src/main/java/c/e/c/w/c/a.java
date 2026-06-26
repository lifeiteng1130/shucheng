package c.e.c.w.c;

import c.b.a.m.f;
import c.e.c.r;
import c.e.c.v.j;
import h.a.a.a.w;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.e.c.v.l.a f1440b;

    /* JADX INFO: compiled from: Detector.java */
    public static final class b {
        public final r a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f1441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1442c;

        public b(r rVar, r rVar2, int i2, C0052a c0052a) {
            this.a = rVar;
            this.f1441b = rVar2;
            this.f1442c = i2;
        }

        public String toString() {
            return this.a + w.DEFAULT_PATH_SEPARATOR + this.f1441b + Attributes.InternalPrefix + this.f1442c;
        }
    }

    /* JADX INFO: compiled from: Detector.java */
    public static final class c implements Serializable, Comparator<b>, j$.util.Comparator {
        public c() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.f1442c - bVar2.f1442c;
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

        public c(C0052a c0052a) {
        }
    }

    public a(c.e.c.v.b bVar) {
        this.a = bVar;
        this.f1440b = new c.e.c.v.l.a(bVar, 10, bVar.a / 2, bVar.f1376b / 2);
    }

    public static int a(r rVar, r rVar2) {
        return f.R4(f.r1(rVar.a, rVar.f1359b, rVar2.a, rVar2.f1359b));
    }

    public static void b(Map<r, Integer> map, r rVar) {
        Integer num = map.get(rVar);
        map.put(rVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static c.e.c.v.b d(c.e.c.v.b bVar, r rVar, r rVar2, r rVar3, r rVar4, int i2, int i3) {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return c.e.c.v.f.a.a(bVar, i2, i3, j.a(0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, rVar.a, rVar.f1359b, rVar4.a, rVar4.f1359b, rVar3.a, rVar3.f1359b, rVar2.a, rVar2.f1359b));
    }

    public final boolean c(r rVar) {
        float f2 = rVar.a;
        if (f2 < 0.0f) {
            return false;
        }
        c.e.c.v.b bVar = this.a;
        if (f2 >= bVar.a) {
            return false;
        }
        float f3 = rVar.f1359b;
        return f3 > 0.0f && f3 < ((float) bVar.f1376b);
    }

    public final b e(r rVar, r rVar2) {
        a aVar = this;
        int i2 = (int) rVar.a;
        int i3 = (int) rVar.f1359b;
        int i4 = (int) rVar2.a;
        int i5 = (int) rVar2.f1359b;
        boolean z = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z) {
            i3 = i2;
            i2 = i3;
            i5 = i4;
            i4 = i5;
        }
        int iAbs = Math.abs(i4 - i2);
        int iAbs2 = Math.abs(i5 - i3);
        int i6 = (-iAbs) / 2;
        int i7 = i3 < i5 ? 1 : -1;
        int i8 = i2 >= i4 ? -1 : 1;
        boolean zB = aVar.a.b(z ? i3 : i2, z ? i2 : i3);
        int i9 = 0;
        while (i2 != i4) {
            boolean zB2 = aVar.a.b(z ? i3 : i2, z ? i2 : i3);
            if (zB2 != zB) {
                i9++;
                zB = zB2;
            }
            i6 += iAbs2;
            if (i6 > 0) {
                if (i3 == i5) {
                    break;
                }
                i3 += i7;
                i6 -= iAbs;
            }
            i2 += i8;
            aVar = this;
        }
        return new b(rVar, rVar2, i9, null);
    }
}
