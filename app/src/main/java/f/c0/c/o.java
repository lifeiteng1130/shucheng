package f.c0.c;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public final class o implements c {

    @NotNull
    public final Class<?> a;

    public o(@NotNull Class<?> cls, @NotNull String str) {
        j.e(cls, "jClass");
        j.e(str, "moduleName");
        this.a = cls;
    }

    @Override // f.c0.c.c
    @NotNull
    public Class<?> a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof o) && j.a(this.a, ((o) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
