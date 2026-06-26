package f;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UInt.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class n implements Comparable<n> {
    public final int a;

    @Override // java.lang.Comparable
    public int compareTo(n nVar) {
        return f.c0.c.j.g(this.a ^ Integer.MIN_VALUE, nVar.a ^ Integer.MIN_VALUE);
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && this.a == ((n) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return String.valueOf(((long) this.a) & 4294967295L);
    }
}
