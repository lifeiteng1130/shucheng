package e.a.a.g.d.i.s1.g;

import f.c0.c.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextChar.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @NotNull
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5773e;

    public c(String str, float f2, float f3, boolean z, boolean z2, int i2) {
        z = (i2 & 8) != 0 ? false : z;
        z2 = (i2 & 16) != 0 ? false : z2;
        j.e(str, "charData");
        this.a = str;
        this.f5770b = f2;
        this.f5771c = f3;
        this.f5772d = z;
        this.f5773e = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.a(this.a, cVar.a) && j.a(Float.valueOf(this.f5770b), Float.valueOf(cVar.f5770b)) && j.a(Float.valueOf(this.f5771c), Float.valueOf(cVar.f5771c)) && this.f5772d == cVar.f5772d && this.f5773e == cVar.f5773e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iFloatToIntBits = (Float.floatToIntBits(this.f5771c) + ((Float.floatToIntBits(this.f5770b) + (this.a.hashCode() * 31)) * 31)) * 31;
        boolean z = this.f5772d;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i2 = (iFloatToIntBits + r1) * 31;
        boolean z2 = this.f5773e;
        return i2 + (z2 ? 1 : z2);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("TextChar(charData=");
        sbR.append(this.a);
        sbR.append(", start=");
        sbR.append(this.f5770b);
        sbR.append(", end=");
        sbR.append(this.f5771c);
        sbR.append(", selected=");
        sbR.append(this.f5772d);
        sbR.append(", isImage=");
        sbR.append(this.f5773e);
        sbR.append(')');
        return sbR.toString();
    }
}
