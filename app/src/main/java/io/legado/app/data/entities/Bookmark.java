package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.FrameMetricsAggregator;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Bookmark.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"time"})}, tableName = "bookmarks")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007Jj\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001d\u0010\fJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b#\u0010\fJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b(\u0010)R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0007R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010/R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010*\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u00102R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010*\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u00102R\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010*\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u00102R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u00107\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010:R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010*\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u00102R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010,\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010/R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010*\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u00102¨\u0006C"}, d2 = {"Lio/legado/app/data/entities/Bookmark;", "Landroid/os/Parcelable;", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()I", "component6", "component7", "component8", "component9", "time", "bookUrl", "bookName", "bookAuthor", "chapterIndex", "chapterPos", "chapterName", "bookText", "content", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/Bookmark;", "toString", TTDownloadField.TT_HASHCODE, "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBookAuthor", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getChapterPos", "setChapterPos", "(I)V", "getBookText", "setBookText", "(Ljava/lang/String;)V", "getBookName", "setBookName", "getChapterName", "setChapterName", "J", "getTime", "setTime", "(J)V", "getBookUrl", "setBookUrl", "getChapterIndex", "setChapterIndex", "getContent", "setContent", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class Bookmark implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Bookmark> CREATOR = new Creator();

    @NotNull
    private final String bookAuthor;

    @NotNull
    private String bookName;

    @NotNull
    private String bookText;

    @NotNull
    private String bookUrl;
    private int chapterIndex;

    @NotNull
    private String chapterName;
    private int chapterPos;

    @NotNull
    private String content;

    @PrimaryKey
    private long time;

    /* JADX INFO: compiled from: Bookmark.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<Bookmark> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Bookmark createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new Bookmark(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Bookmark[] newArray(int i2) {
            return new Bookmark[i2];
        }
    }

    public Bookmark() {
        this(0L, null, null, null, 0, 0, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public Bookmark(long j2, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, int i3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        j.e(str, "bookUrl");
        j.e(str2, "bookName");
        j.e(str3, "bookAuthor");
        j.e(str4, "chapterName");
        j.e(str5, "bookText");
        j.e(str6, "content");
        this.time = j2;
        this.bookUrl = str;
        this.bookName = str2;
        this.bookAuthor = str3;
        this.chapterIndex = i2;
        this.chapterPos = i3;
        this.chapterName = str4;
        this.bookText = str5;
        this.content = str6;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBookUrl() {
        return this.bookUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBookName() {
        return this.bookName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBookAuthor() {
        return this.bookAuthor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getChapterIndex() {
        return this.chapterIndex;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getChapterPos() {
        return this.chapterPos;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getChapterName() {
        return this.chapterName;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBookText() {
        return this.bookText;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final Bookmark copy(long time, @NotNull String bookUrl, @NotNull String bookName, @NotNull String bookAuthor, int chapterIndex, int chapterPos, @NotNull String chapterName, @NotNull String bookText, @NotNull String content) {
        j.e(bookUrl, "bookUrl");
        j.e(bookName, "bookName");
        j.e(bookAuthor, "bookAuthor");
        j.e(chapterName, "chapterName");
        j.e(bookText, "bookText");
        j.e(content, "content");
        return new Bookmark(time, bookUrl, bookName, bookAuthor, chapterIndex, chapterPos, chapterName, bookText, content);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Bookmark)) {
            return false;
        }
        Bookmark bookmark = (Bookmark) other;
        return this.time == bookmark.time && j.a(this.bookUrl, bookmark.bookUrl) && j.a(this.bookName, bookmark.bookName) && j.a(this.bookAuthor, bookmark.bookAuthor) && this.chapterIndex == bookmark.chapterIndex && this.chapterPos == bookmark.chapterPos && j.a(this.chapterName, bookmark.chapterName) && j.a(this.bookText, bookmark.bookText) && j.a(this.content, bookmark.content);
    }

    @NotNull
    public final String getBookAuthor() {
        return this.bookAuthor;
    }

    @NotNull
    public final String getBookName() {
        return this.bookName;
    }

    @NotNull
    public final String getBookText() {
        return this.bookText;
    }

    @NotNull
    public final String getBookUrl() {
        return this.bookUrl;
    }

    public final int getChapterIndex() {
        return this.chapterIndex;
    }

    @NotNull
    public final String getChapterName() {
        return this.chapterName;
    }

    public final int getChapterPos() {
        return this.chapterPos;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return this.content.hashCode() + a.m(this.bookText, a.m(this.chapterName, (((a.m(this.bookAuthor, a.m(this.bookName, a.m(this.bookUrl, b.a(this.time) * 31, 31), 31), 31) + this.chapterIndex) * 31) + this.chapterPos) * 31, 31), 31);
    }

    public final void setBookName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookName = str;
    }

    public final void setBookText(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookText = str;
    }

    public final void setBookUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookUrl = str;
    }

    public final void setChapterIndex(int i2) {
        this.chapterIndex = i2;
    }

    public final void setChapterName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.chapterName = str;
    }

    public final void setChapterPos(int i2) {
        this.chapterPos = i2;
    }

    public final void setContent(@NotNull String str) {
        j.e(str, "<set-?>");
        this.content = str;
    }

    public final void setTime(long j2) {
        this.time = j2;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("Bookmark(time=");
        sbR.append(this.time);
        sbR.append(", bookUrl=");
        sbR.append(this.bookUrl);
        sbR.append(", bookName=");
        sbR.append(this.bookName);
        sbR.append(", bookAuthor=");
        sbR.append(this.bookAuthor);
        sbR.append(", chapterIndex=");
        sbR.append(this.chapterIndex);
        sbR.append(", chapterPos=");
        sbR.append(this.chapterPos);
        sbR.append(", chapterName=");
        sbR.append(this.chapterName);
        sbR.append(", bookText=");
        sbR.append(this.bookText);
        sbR.append(", content=");
        sbR.append(this.content);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeLong(this.time);
        parcel.writeString(this.bookUrl);
        parcel.writeString(this.bookName);
        parcel.writeString(this.bookAuthor);
        parcel.writeInt(this.chapterIndex);
        parcel.writeInt(this.chapterPos);
        parcel.writeString(this.chapterName);
        parcel.writeString(this.bookText);
        parcel.writeString(this.content);
    }

    public /* synthetic */ Bookmark(long j2, String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, int i4, f fVar) {
        this((i4 & 1) != 0 ? System.currentTimeMillis() : j2, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) == 0 ? i3 : 0, (i4 & 64) != 0 ? "" : str4, (i4 & 128) != 0 ? "" : str5, (i4 & 256) == 0 ? str6 : "");
    }
}
