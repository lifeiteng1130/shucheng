package e.a.a.g.d.i.s1.g;

import androidx.core.app.NotificationCompat;
import f.c0.c.j;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextLine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    @NotNull
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final ArrayList<c> f5774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5780h;

    public d() {
        this(null, null, 0.0f, 0.0f, 0.0f, false, false, false, 255);
    }

    public d(String str, ArrayList arrayList, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, int i2) {
        String str2 = (i2 & 1) != 0 ? "" : null;
        ArrayList<c> arrayList2 = (i2 & 2) != 0 ? new ArrayList<>() : null;
        f2 = (i2 & 4) != 0 ? 0.0f : f2;
        f3 = (i2 & 8) != 0 ? 0.0f : f3;
        f4 = (i2 & 16) != 0 ? 0.0f : f4;
        z = (i2 & 32) != 0 ? false : z;
        z2 = (i2 & 64) != 0 ? false : z2;
        z3 = (i2 & 128) != 0 ? false : z3;
        j.e(str2, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        j.e(arrayList2, "textChars");
        this.a = str2;
        this.f5774b = arrayList2;
        this.f5775c = f2;
        this.f5776d = f3;
        this.f5777e = f4;
        this.f5778f = z;
        this.f5779g = z2;
        this.f5780h = z3;
    }

    @NotNull
    public final c a(int i2) {
        ArrayList<c> arrayList = this.f5774b;
        return (i2 < 0 || i2 > f.x.e.m(arrayList)) ? (c) f.x.e.r(this.f5774b) : arrayList.get(i2);
    }

    public final void b(@NotNull String str) {
        j.e(str, "<set-?>");
        this.a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.a(this.a, dVar.a) && j.a(this.f5774b, dVar.f5774b) && j.a(Float.valueOf(this.f5775c), Float.valueOf(dVar.f5775c)) && j.a(Float.valueOf(this.f5776d), Float.valueOf(dVar.f5776d)) && j.a(Float.valueOf(this.f5777e), Float.valueOf(dVar.f5777e)) && this.f5778f == dVar.f5778f && this.f5779g == dVar.f5779g && this.f5780h == dVar.f5780h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iFloatToIntBits = (Float.floatToIntBits(this.f5777e) + ((Float.floatToIntBits(this.f5776d) + ((Float.floatToIntBits(this.f5775c) + ((this.f5774b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.f5778f;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i2 = (iFloatToIntBits + r1) * 31;
        boolean z2 = this.f5779g;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i3 = (i2 + r12) * 31;
        boolean z3 = this.f5780h;
        return i3 + (z3 ? 1 : z3);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("TextLine(text=");
        sbR.append(this.a);
        sbR.append(", textChars=");
        sbR.append(this.f5774b);
        sbR.append(", lineTop=");
        sbR.append(this.f5775c);
        sbR.append(", lineBase=");
        sbR.append(this.f5776d);
        sbR.append(", lineBottom=");
        sbR.append(this.f5777e);
        sbR.append(", isTitle=");
        sbR.append(this.f5778f);
        sbR.append(", isReadAloud=");
        sbR.append(this.f5779g);
        sbR.append(", isImage=");
        sbR.append(this.f5780h);
        sbR.append(')');
        return sbR.toString();
    }
}
