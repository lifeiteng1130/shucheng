package io.legado.app.model.webBook;

import androidx.exifinterface.media.ExifInterface;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lio/legado/app/model/webBook/ContentData;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "content", "nextUrl", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lio/legado/app/model/webBook/ContentData;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getNextUrl", "setNextUrl", "(Ljava/lang/Object;)V", "Ljava/lang/String;", "getContent", "setContent", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ContentData<T> {

    @NotNull
    private String content;
    private T nextUrl;

    public ContentData(@NotNull String str, T t) {
        j.e(str, "content");
        this.content = str;
        this.nextUrl = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentData copy$default(ContentData contentData, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = contentData.content;
        }
        if ((i2 & 2) != 0) {
            obj = contentData.nextUrl;
        }
        return contentData.copy(str, obj);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final T component2() {
        return this.nextUrl;
    }

    @NotNull
    public final ContentData<T> copy(@NotNull String content, T nextUrl) {
        j.e(content, "content");
        return new ContentData<>(content, nextUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentData)) {
            return false;
        }
        ContentData contentData = (ContentData) other;
        return j.a(this.content, contentData.content) && j.a(this.nextUrl, contentData.nextUrl);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final T getNextUrl() {
        return this.nextUrl;
    }

    public int hashCode() {
        int iHashCode = this.content.hashCode() * 31;
        T t = this.nextUrl;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public final void setContent(@NotNull String str) {
        j.e(str, "<set-?>");
        this.content = str;
    }

    public final void setNextUrl(T t) {
        this.nextUrl = t;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ContentData(content=");
        sbR.append(this.content);
        sbR.append(", nextUrl=");
        sbR.append(this.nextUrl);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ ContentData(String str, Object obj, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, obj);
    }
}
