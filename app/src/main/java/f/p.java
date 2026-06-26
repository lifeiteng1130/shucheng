package f;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ULong.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class p implements Comparable<p> {
    public final long a;

    @Override // java.lang.Comparable
    public int compareTo(p pVar) {
        return ((this.a ^ Long.MIN_VALUE) > (pVar.a ^ Long.MIN_VALUE) ? 1 : ((this.a ^ Long.MIN_VALUE) == (pVar.a ^ Long.MIN_VALUE) ? 0 : -1));
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && this.a == ((p) obj).a;
    }

    public int hashCode() {
        long j2 = this.a;
        return (int) (j2 ^ (j2 >>> 32));
    }

    @NotNull
    public String toString() {
        long j2 = this.a;
        if (j2 >= 0) {
            c.b.a.m.f.N0(10);
            String string = Long.toString(j2, 10);
            f.c0.c.j.d(string, "java.lang.Long.toString(this, checkRadix(radix))");
            return string;
        }
        long j3 = 10;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        c.b.a.m.f.N0(10);
        String string2 = Long.toString(j4, 10);
        f.c0.c.j.d(string2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(string2);
        c.b.a.m.f.N0(10);
        String string3 = Long.toString(j5, 10);
        f.c0.c.j.d(string3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(string3);
        return sb.toString();
    }
}
