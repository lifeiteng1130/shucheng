package f.h0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    @NotNull
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final f.e0.d f6153b;

    public d(@NotNull String str, @NotNull f.e0.d dVar) {
        f.c0.c.j.e(str, ES6Iterator.VALUE_PROPERTY);
        f.c0.c.j.e(dVar, "range");
        this.a = str;
        this.f6153b = dVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return f.c0.c.j.a(this.a, dVar.a) && f.c0.c.j.a(this.f6153b, dVar.f6153b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        f.e0.d dVar = this.f6153b;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("MatchGroup(value=");
        sbR.append(this.a);
        sbR.append(", range=");
        sbR.append(this.f6153b);
        sbR.append(")");
        return sbR.toString();
    }
}
