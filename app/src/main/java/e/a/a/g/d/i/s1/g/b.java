package e.a.a.g.d.i.s1.g;

import f.c0.c.j;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextChapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f5766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f5767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<e> f5768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5769e;

    public b(int i2, @NotNull String str, @NotNull String str2, @NotNull List<e> list, int i3) {
        j.e(str, "title");
        j.e(str2, "url");
        j.e(list, com.umeng.analytics.pro.c.t);
        this.a = i2;
        this.f5766b = str;
        this.f5767c = str2;
        this.f5768d = list;
        this.f5769e = i3;
    }

    public final int a(int i2) {
        int length = 0;
        for (e eVar : this.f5768d) {
            length += eVar.f5781b.length();
            if (length > i2) {
                return eVar.a;
            }
        }
        return f.x.e.m(this.f5768d);
    }

    public final int b() {
        return this.f5768d.size();
    }

    public final int c(int i2) {
        int iMin = Math.min(i2, this.f5768d.size());
        int i3 = 0;
        if (iMin <= 0) {
            return 0;
        }
        int length = 0;
        while (true) {
            int i4 = i3 + 1;
            length += this.f5768d.get(i3).f5781b.length();
            if (i4 >= iMin) {
                return length;
            }
            i3 = i4;
        }
    }

    @Nullable
    public final e d(int i2) {
        return (e) f.x.e.n(this.f5768d, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && j.a(this.f5766b, bVar.f5766b) && j.a(this.f5767c, bVar.f5767c) && j.a(this.f5768d, bVar.f5768d) && this.f5769e == bVar.f5769e;
    }

    public int hashCode() {
        return ((this.f5768d.hashCode() + c.a.a.a.a.m(this.f5767c, c.a.a.a.a.m(this.f5766b, this.a * 31, 31), 31)) * 31) + this.f5769e;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("TextChapter(position=");
        sbR.append(this.a);
        sbR.append(", title=");
        sbR.append(this.f5766b);
        sbR.append(", url=");
        sbR.append(this.f5767c);
        sbR.append(", pages=");
        sbR.append(this.f5768d);
        sbR.append(", chaptersSize=");
        return c.a.a.a.a.n(sbR, this.f5769e, ')');
    }
}
