package e.a.a.g.f;

import f.c0.c.j;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FilePicker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f5838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public String[] f5839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public String[] f5840d;

    public d() {
        this(0, null, null, null, 15);
    }

    public d(int i2, String str, String[] strArr, String[] strArr2, int i3) {
        i2 = (i3 & 1) != 0 ? 0 : i2;
        str = (i3 & 2) != 0 ? null : str;
        strArr = (i3 & 4) != 0 ? new String[0] : strArr;
        strArr2 = (i3 & 8) != 0 ? null : strArr2;
        j.e(strArr, "allowExtensions");
        this.a = i2;
        this.f5838b = str;
        this.f5839c = strArr;
        this.f5840d = strArr2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && j.a(this.f5838b, dVar.f5838b) && j.a(this.f5839c, dVar.f5839c) && j.a(this.f5840d, dVar.f5840d);
    }

    public int hashCode() {
        int i2 = this.a * 31;
        String str = this.f5838b;
        int iHashCode = (((i2 + (str == null ? 0 : str.hashCode())) * 31) + Arrays.hashCode(this.f5839c)) * 31;
        String[] strArr = this.f5840d;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("FilePickerParam(mode=");
        sbR.append(this.a);
        sbR.append(", title=");
        sbR.append((Object) this.f5838b);
        sbR.append(", allowExtensions=");
        sbR.append(Arrays.toString(this.f5839c));
        sbR.append(", otherActions=");
        sbR.append(Arrays.toString(this.f5840d));
        sbR.append(')');
        return sbR.toString();
    }

    public d(int i2, @Nullable String str, @NotNull String[] strArr, @Nullable String[] strArr2) {
        j.e(strArr, "allowExtensions");
        this.a = i2;
        this.f5838b = str;
        this.f5839c = strArr;
        this.f5840d = strArr2;
    }
}
