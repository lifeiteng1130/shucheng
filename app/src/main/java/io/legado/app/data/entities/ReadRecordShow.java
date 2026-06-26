package io.legado.app.data.entities;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRecordShow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lio/legado/app/data/entities/ReadRecordShow;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "bookName", "readTime", "copy", "(Ljava/lang/String;J)Lio/legado/app/data/entities/ReadRecordShow;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBookName", "setBookName", "(Ljava/lang/String;)V", "J", "getReadTime", "setReadTime", "(J)V", "<init>", "(Ljava/lang/String;J)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ReadRecordShow {

    @NotNull
    private String bookName;
    private long readTime;

    public ReadRecordShow() {
        this(null, 0L, 3, null);
    }

    public ReadRecordShow(@NotNull String str, long j2) {
        j.e(str, "bookName");
        this.bookName = str;
        this.readTime = j2;
    }

    public static /* synthetic */ ReadRecordShow copy$default(ReadRecordShow readRecordShow, String str, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = readRecordShow.bookName;
        }
        if ((i2 & 2) != 0) {
            j2 = readRecordShow.readTime;
        }
        return readRecordShow.copy(str, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBookName() {
        return this.bookName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getReadTime() {
        return this.readTime;
    }

    @NotNull
    public final ReadRecordShow copy(@NotNull String bookName, long readTime) {
        j.e(bookName, "bookName");
        return new ReadRecordShow(bookName, readTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReadRecordShow)) {
            return false;
        }
        ReadRecordShow readRecordShow = (ReadRecordShow) other;
        return j.a(this.bookName, readRecordShow.bookName) && this.readTime == readRecordShow.readTime;
    }

    @NotNull
    public final String getBookName() {
        return this.bookName;
    }

    public final long getReadTime() {
        return this.readTime;
    }

    public int hashCode() {
        return b.a(this.readTime) + (this.bookName.hashCode() * 31);
    }

    public final void setBookName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookName = str;
    }

    public final void setReadTime(long j2) {
        this.readTime = j2;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ReadRecordShow(bookName=");
        sbR.append(this.bookName);
        sbR.append(", readTime=");
        sbR.append(this.readTime);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ ReadRecordShow(String str, long j2, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0L : j2);
    }
}
