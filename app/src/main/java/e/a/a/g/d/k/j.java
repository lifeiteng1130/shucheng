package e.a.a.g.d.k;

import androidx.core.app.NotificationCompat;
import androidx.media2.session.MediaConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public String f5812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public String f5813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f5814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5819j;

    public j(int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7, int i8, int i9) {
        i2 = (i9 & 1) != 0 ? 0 : i2;
        i3 = (i9 & 2) != 0 ? 0 : i3;
        str = (i9 & 4) != 0 ? "" : str;
        str2 = (i9 & 8) != 0 ? "" : str2;
        i4 = (i9 & 32) != 0 ? 0 : i4;
        i5 = (i9 & 64) != 0 ? 0 : i5;
        i6 = (i9 & 128) != 0 ? 0 : i6;
        i7 = (i9 & 256) != 0 ? 0 : i7;
        i8 = (i9 & 512) != 0 ? 0 : i8;
        f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        f.c0.c.j.e(str2, "chapterTitle");
        f.c0.c.j.e(str3, MediaConstants.MEDIA_URI_QUERY_QUERY);
        this.a = i2;
        this.f5811b = i3;
        this.f5812c = str;
        this.f5813d = str2;
        this.f5814e = str3;
        this.f5815f = i4;
        this.f5816g = i5;
        this.f5817h = i6;
        this.f5818i = i7;
        this.f5819j = i8;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && this.f5811b == jVar.f5811b && f.c0.c.j.a(this.f5812c, jVar.f5812c) && f.c0.c.j.a(this.f5813d, jVar.f5813d) && f.c0.c.j.a(this.f5814e, jVar.f5814e) && this.f5815f == jVar.f5815f && this.f5816g == jVar.f5816g && this.f5817h == jVar.f5817h && this.f5818i == jVar.f5818i && this.f5819j == jVar.f5819j;
    }

    public int hashCode() {
        return ((((((((c.a.a.a.a.m(this.f5814e, c.a.a.a.a.m(this.f5813d, c.a.a.a.a.m(this.f5812c, ((this.a * 31) + this.f5811b) * 31, 31), 31), 31) + this.f5815f) * 31) + this.f5816g) * 31) + this.f5817h) * 31) + this.f5818i) * 31) + this.f5819j;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("SearchResult(index=");
        sbR.append(this.a);
        sbR.append(", indexWithinChapter=");
        sbR.append(this.f5811b);
        sbR.append(", text=");
        sbR.append(this.f5812c);
        sbR.append(", chapterTitle=");
        sbR.append(this.f5813d);
        sbR.append(", query=");
        sbR.append(this.f5814e);
        sbR.append(", pageSize=");
        sbR.append(this.f5815f);
        sbR.append(", chapterIndex=");
        sbR.append(this.f5816g);
        sbR.append(", pageIndex=");
        sbR.append(this.f5817h);
        sbR.append(", newPosition=");
        sbR.append(this.f5818i);
        sbR.append(", contentPosition=");
        return c.a.a.a.a.n(sbR, this.f5819j, ')');
    }
}
