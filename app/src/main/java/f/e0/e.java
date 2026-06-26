package f.e0;

import c.b.a.m.f;
import f.c0.c.j;
import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final long a(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static final int b(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    @NotNull
    public static final b c(int i2, int i3) {
        return new b(i2, i3, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final int d(@NotNull d dVar, @NotNull f.d0.c cVar) {
        j.e(dVar, "$this$random");
        j.e(cVar, "random");
        try {
            return f.c4(cVar, dVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @NotNull
    public static final b e(@NotNull b bVar, int i2) {
        j.e(bVar, "$this$step");
        boolean z = i2 > 0;
        Integer numValueOf = Integer.valueOf(i2);
        j.e(numValueOf, "step");
        if (z) {
            int i3 = bVar.a;
            int i4 = bVar.f6128b;
            if (bVar.f6129c <= 0) {
                i2 = -i2;
            }
            return new b(i3, i4, i2);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
    }

    @NotNull
    public static final d f(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new d(i2, i3 - 1);
        }
        d dVar = d.f6134e;
        return d.f6133d;
    }
}
