package e.a.a.g.k.d.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    @NotNull
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f5881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5882c;

    public b(@NotNull String str, @Nullable String str2, int i2) {
        f.c0.c.j.e(str, "key");
        this.a = str;
        this.f5881b = str2;
        this.f5882c = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return f.c0.c.j.a(this.a, bVar.a) && f.c0.c.j.a(this.f5881b, bVar.f5881b) && this.f5882c == bVar.f5882c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.f5881b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f5882c;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("EditEntity(key=");
        sbR.append(this.a);
        sbR.append(", value=");
        sbR.append((Object) this.f5881b);
        sbR.append(", hint=");
        return c.a.a.a.a.n(sbR, this.f5882c, ')');
    }
}
