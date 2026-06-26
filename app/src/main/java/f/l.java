package f;

import androidx.exifinterface.media.ExifInterface;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UByte.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class l implements Comparable<l> {
    public final byte a;

    @Override // java.lang.Comparable
    public int compareTo(l lVar) {
        return f.c0.c.j.g(this.a & ExifInterface.MARKER, lVar.a & ExifInterface.MARKER);
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && this.a == ((l) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.a & ExifInterface.MARKER);
    }
}
