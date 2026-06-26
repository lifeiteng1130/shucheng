package f;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UShort.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class s implements Comparable<s> {
    public final short a;

    @Override // java.lang.Comparable
    public int compareTo(s sVar) {
        return f.c0.c.j.g(this.a & 65535, sVar.a & 65535);
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && this.a == ((s) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.a & 65535);
    }
}
