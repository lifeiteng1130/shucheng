package e.a.a.g.d.i.s1.g;

import android.text.Layout;
import android.text.StaticLayout;
import androidx.core.app.NotificationCompat;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import k.d.a.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextPage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public String f5781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public String f5782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final ArrayList<d> f5783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5787h;

    public e() {
        this(0, null, null, null, 0, 0, 0, 0.0f, 255);
    }

    public e(int i2, String str, String str2, ArrayList arrayList, int i3, int i4, int i5, float f2, int i6) {
        i2 = (i6 & 1) != 0 ? 0 : i2;
        if ((i6 & 2) != 0) {
            str = h.g().getString(R.string.data_loading);
            j.d(str, "appCtx.getString(R.string.data_loading)");
        }
        str2 = (i6 & 4) != 0 ? "" : str2;
        ArrayList<d> arrayList2 = (i6 & 8) != 0 ? new ArrayList<>() : null;
        i3 = (i6 & 16) != 0 ? 0 : i3;
        i4 = (i6 & 32) != 0 ? 0 : i4;
        i5 = (i6 & 64) != 0 ? 0 : i5;
        f2 = (i6 & 128) != 0 ? 0.0f : f2;
        j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        j.e(str2, "title");
        j.e(arrayList2, "textLines");
        this.a = i2;
        this.f5781b = str;
        this.f5782c = str2;
        this.f5783d = arrayList2;
        this.f5784e = i3;
        this.f5785f = i4;
        this.f5786g = i5;
        this.f5787h = f2;
    }

    @NotNull
    public final e a() {
        StaticLayout staticLayout;
        if (this.f5783d.isEmpty()) {
            e.a.a.g.d.i.s1.h.a aVar = e.a.a.g.d.i.s1.h.a.a;
            if (e.a.a.g.d.i.s1.h.a.f5792f > 0) {
                StaticLayout staticLayout2 = new StaticLayout(this.f5781b, e.a.a.g.d.i.s1.h.a.d(), e.a.a.g.d.i.s1.h.a.f5792f, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float height = (e.a.a.g.d.i.s1.h.a.f5793g - staticLayout2.getHeight()) / 2.0f;
                if (height < 0.0f) {
                    height = 0.0f;
                }
                int lineCount = staticLayout2.getLineCount();
                if (lineCount > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        d dVar = new d(null, null, 0.0f, 0.0f, 0.0f, false, false, false, 255);
                        e.a.a.g.d.i.s1.h.a aVar2 = e.a.a.g.d.i.s1.h.a.a;
                        dVar.f5775c = e.a.a.g.d.i.s1.h.a.f5791e + height + staticLayout2.getLineTop(i2);
                        dVar.f5776d = e.a.a.g.d.i.s1.h.a.f5791e + height + staticLayout2.getLineBaseline(i2);
                        dVar.f5777e = e.a.a.g.d.i.s1.h.a.f5791e + height + staticLayout2.getLineBottom(i2);
                        float lineMax = ((e.a.a.g.d.i.s1.h.a.f5792f - staticLayout2.getLineMax(i2)) / 2) + e.a.a.g.d.i.s1.h.a.f5790d;
                        String str = this.f5781b;
                        int lineStart = staticLayout2.getLineStart(i2);
                        int lineEnd = staticLayout2.getLineEnd(i2);
                        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring = str.substring(lineStart, lineEnd);
                        j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        dVar.b(strSubstring);
                        int length = dVar.a.length() - 1;
                        if (length >= 0) {
                            float f2 = lineMax;
                            int i4 = 0;
                            while (true) {
                                int i5 = i4 + 1;
                                String strValueOf = String.valueOf(dVar.a.charAt(i4));
                                e.a.a.g.d.i.s1.h.a aVar3 = e.a.a.g.d.i.s1.h.a.a;
                                float desiredWidth = StaticLayout.getDesiredWidth(strValueOf, e.a.a.g.d.i.s1.h.a.d()) + f2;
                                staticLayout = staticLayout2;
                                dVar.f5774b.add(new c(strValueOf, f2, desiredWidth, false, false, 24));
                                if (i5 > length) {
                                    break;
                                }
                                f2 = desiredWidth;
                                i4 = i5;
                                staticLayout2 = staticLayout;
                            }
                        } else {
                            staticLayout = staticLayout2;
                        }
                        this.f5783d.add(dVar);
                        if (i3 >= lineCount) {
                            break;
                        }
                        i2 = i3;
                        staticLayout2 = staticLayout;
                    }
                }
                e.a.a.g.d.i.s1.h.a aVar4 = e.a.a.g.d.i.s1.h.a.a;
                this.f5787h = e.a.a.g.d.i.s1.h.a.f5793g;
            }
        }
        return this;
    }

    @NotNull
    public final d b(int i2) {
        ArrayList<d> arrayList = this.f5783d;
        return (i2 < 0 || i2 > f.x.e.m(arrayList)) ? (d) f.x.e.r(this.f5783d) : arrayList.get(i2);
    }

    public final int c() {
        return this.f5783d.size();
    }

    @NotNull
    public final String d() {
        int i2;
        DecimalFormat decimalFormat = new DecimalFormat("0.0%");
        int i3 = this.f5785f;
        if (i3 == 0 || ((i2 = this.f5784e) == 0 && this.f5786g == 0)) {
            return "0.0%";
        }
        if (i2 == 0) {
            String str = decimalFormat.format(((double) (this.f5786g + 1.0f)) / ((double) i3));
            j.d(str, "df.format((chapterIndex + 1.0f) / chapterSize.toDouble())");
            return str;
        }
        String str2 = decimalFormat.format((((double) ((1.0f / i3) * (this.a + 1))) / ((double) i2)) + ((double) ((this.f5786g * 1.0f) / i3)));
        if (j.a(str2, "100.0%") && (this.f5786g + 1 != this.f5785f || this.a + 1 != this.f5784e)) {
            str2 = "99.9%";
        }
        j.d(str2, "percent");
        return str2;
    }

    @NotNull
    public final e e() {
        Iterator<T> it = this.f5783d.iterator();
        while (it.hasNext()) {
            ((d) it.next()).f5779g = false;
        }
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && j.a(this.f5781b, eVar.f5781b) && j.a(this.f5782c, eVar.f5782c) && j.a(this.f5783d, eVar.f5783d) && this.f5784e == eVar.f5784e && this.f5785f == eVar.f5785f && this.f5786g == eVar.f5786g && j.a(Float.valueOf(this.f5787h), Float.valueOf(eVar.f5787h));
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f5787h) + ((((((((this.f5783d.hashCode() + c.a.a.a.a.m(this.f5782c, c.a.a.a.a.m(this.f5781b, this.a * 31, 31), 31)) * 31) + this.f5784e) * 31) + this.f5785f) * 31) + this.f5786g) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("TextPage(index=");
        sbR.append(this.a);
        sbR.append(", text=");
        sbR.append(this.f5781b);
        sbR.append(", title=");
        sbR.append(this.f5782c);
        sbR.append(", textLines=");
        sbR.append(this.f5783d);
        sbR.append(", pageSize=");
        sbR.append(this.f5784e);
        sbR.append(", chapterSize=");
        sbR.append(this.f5785f);
        sbR.append(", chapterIndex=");
        sbR.append(this.f5786g);
        sbR.append(", height=");
        sbR.append(this.f5787h);
        sbR.append(')');
        return sbR.toString();
    }
}
