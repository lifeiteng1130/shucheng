package io.legado.app.data.entities;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookProgress.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JN\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b \u0010\bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lio/legado/app/data/entities/BookProgress;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "", "component5", "()J", "component6", "name", "author", "durChapterIndex", "durChapterPos", "durChapterTime", "durChapterTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;)Lio/legado/app/data/entities/BookProgress;", "toString", TTDownloadField.TT_HASHCODE, "other", "", "equals", "(Ljava/lang/Object;)Z", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getDurChapterIndex", "J", "getDurChapterTime", "getDurChapterPos", "Ljava/lang/String;", "getAuthor", "getName", "getDurChapterTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class BookProgress {

    @NotNull
    private final String author;
    private final int durChapterIndex;
    private final int durChapterPos;
    private final long durChapterTime;

    @Nullable
    private final String durChapterTitle;

    @NotNull
    private final String name;

    public BookProgress(@NotNull String str, @NotNull String str2, int i2, int i3, long j2, @Nullable String str3) {
        j.e(str, "name");
        j.e(str2, "author");
        this.name = str;
        this.author = str2;
        this.durChapterIndex = i2;
        this.durChapterPos = i3;
        this.durChapterTime = j2;
        this.durChapterTitle = str3;
    }

    public static /* synthetic */ BookProgress copy$default(BookProgress bookProgress, String str, String str2, int i2, int i3, long j2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = bookProgress.name;
        }
        if ((i4 & 2) != 0) {
            str2 = bookProgress.author;
        }
        String str4 = str2;
        if ((i4 & 4) != 0) {
            i2 = bookProgress.durChapterIndex;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = bookProgress.durChapterPos;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            j2 = bookProgress.durChapterTime;
        }
        long j3 = j2;
        if ((i4 & 32) != 0) {
            str3 = bookProgress.durChapterTitle;
        }
        return bookProgress.copy(str, str4, i5, i6, j3, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDurChapterIndex() {
        return this.durChapterIndex;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDurChapterPos() {
        return this.durChapterPos;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDurChapterTime() {
        return this.durChapterTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDurChapterTitle() {
        return this.durChapterTitle;
    }

    @NotNull
    public final BookProgress copy(@NotNull String name, @NotNull String author, int durChapterIndex, int durChapterPos, long durChapterTime, @Nullable String durChapterTitle) {
        j.e(name, "name");
        j.e(author, "author");
        return new BookProgress(name, author, durChapterIndex, durChapterPos, durChapterTime, durChapterTitle);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookProgress)) {
            return false;
        }
        BookProgress bookProgress = (BookProgress) other;
        return j.a(this.name, bookProgress.name) && j.a(this.author, bookProgress.author) && this.durChapterIndex == bookProgress.durChapterIndex && this.durChapterPos == bookProgress.durChapterPos && this.durChapterTime == bookProgress.durChapterTime && j.a(this.durChapterTitle, bookProgress.durChapterTitle);
    }

    @NotNull
    public final String getAuthor() {
        return this.author;
    }

    public final int getDurChapterIndex() {
        return this.durChapterIndex;
    }

    public final int getDurChapterPos() {
        return this.durChapterPos;
    }

    public final long getDurChapterTime() {
        return this.durChapterTime;
    }

    @Nullable
    public final String getDurChapterTitle() {
        return this.durChapterTitle;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iA = (b.a(this.durChapterTime) + ((((a.m(this.author, this.name.hashCode() * 31, 31) + this.durChapterIndex) * 31) + this.durChapterPos) * 31)) * 31;
        String str = this.durChapterTitle;
        return iA + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("BookProgress(name=");
        sbR.append(this.name);
        sbR.append(", author=");
        sbR.append(this.author);
        sbR.append(", durChapterIndex=");
        sbR.append(this.durChapterIndex);
        sbR.append(", durChapterPos=");
        sbR.append(this.durChapterPos);
        sbR.append(", durChapterTime=");
        sbR.append(this.durChapterTime);
        sbR.append(", durChapterTitle=");
        sbR.append((Object) this.durChapterTitle);
        sbR.append(')');
        return sbR.toString();
    }
}
