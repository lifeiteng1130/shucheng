package e.a.a.g.d.l.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    @NotNull
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f5820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5821c;

    public o(@NotNull String str, @Nullable String str2, int i2) {
        f.c0.c.j.e(str, "key");
        this.a = str;
        this.f5820b = str2;
        this.f5821c = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return f.c0.c.j.a(this.a, oVar.a) && f.c0.c.j.a(this.f5820b, oVar.f5820b) && this.f5821c == oVar.f5821c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.f5820b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f5821c;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("EditEntity(key=");
        sbR.append(this.a);
        sbR.append(", value=");
        sbR.append((Object) this.f5820b);
        sbR.append(", hint=");
        return c.a.a.a.a.n(sbR, this.f5821c, ')');
    }
}
