package io.legado.app.model.webBook;

import androidx.exifinterface.media.ExifInterface;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import io.legado.app.data.entities.BookChapter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChapterData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lio/legado/app/model/webBook/ChapterData;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "Lio/legado/app/data/entities/BookChapter;", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/Object;", "chapterList", "nextUrl", "copy", "(Ljava/util/List;Ljava/lang/Object;)Lio/legado/app/model/webBook/ChapterData;", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getChapterList", "setChapterList", "(Ljava/util/List;)V", "Ljava/lang/Object;", "getNextUrl", "setNextUrl", "(Ljava/lang/Object;)V", "<init>", "(Ljava/util/List;Ljava/lang/Object;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ChapterData<T> {

    @Nullable
    private List<BookChapter> chapterList;
    private T nextUrl;

    public ChapterData(@Nullable List<BookChapter> list, T t) {
        this.chapterList = list;
        this.nextUrl = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChapterData copy$default(ChapterData chapterData, List list, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            list = chapterData.chapterList;
        }
        if ((i2 & 2) != 0) {
            obj = chapterData.nextUrl;
        }
        return chapterData.copy(list, obj);
    }

    @Nullable
    public final List<BookChapter> component1() {
        return this.chapterList;
    }

    public final T component2() {
        return this.nextUrl;
    }

    @NotNull
    public final ChapterData<T> copy(@Nullable List<BookChapter> chapterList, T nextUrl) {
        return new ChapterData<>(chapterList, nextUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChapterData)) {
            return false;
        }
        ChapterData chapterData = (ChapterData) other;
        return j.a(this.chapterList, chapterData.chapterList) && j.a(this.nextUrl, chapterData.nextUrl);
    }

    @Nullable
    public final List<BookChapter> getChapterList() {
        return this.chapterList;
    }

    public final T getNextUrl() {
        return this.nextUrl;
    }

    public int hashCode() {
        List<BookChapter> list = this.chapterList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        T t = this.nextUrl;
        return iHashCode + (t != null ? t.hashCode() : 0);
    }

    public final void setChapterList(@Nullable List<BookChapter> list) {
        this.chapterList = list;
    }

    public final void setNextUrl(T t) {
        this.nextUrl = t;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ChapterData(chapterList=");
        sbR.append(this.chapterList);
        sbR.append(", nextUrl=");
        sbR.append(this.nextUrl);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ ChapterData(List list, Object obj, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : list, obj);
    }
}
