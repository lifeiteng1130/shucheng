package io.legado.app.model.rss;

import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.j;
import io.legado.app.data.entities.RssArticle;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lio/legado/app/model/rss/RssResult;", "", "", "Lio/legado/app/data/entities/RssArticle;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "articles", "nextPageUrl", "copy", "(Ljava/util/List;Ljava/lang/String;)Lio/legado/app/model/rss/RssResult;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getArticles", "Ljava/lang/String;", "getNextPageUrl", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class RssResult {

    @NotNull
    private final List<RssArticle> articles;

    @Nullable
    private final String nextPageUrl;

    public RssResult(@NotNull List<RssArticle> list, @Nullable String str) {
        j.e(list, "articles");
        this.articles = list;
        this.nextPageUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RssResult copy$default(RssResult rssResult, List list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = rssResult.articles;
        }
        if ((i2 & 2) != 0) {
            str = rssResult.nextPageUrl;
        }
        return rssResult.copy(list, str);
    }

    @NotNull
    public final List<RssArticle> component1() {
        return this.articles;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNextPageUrl() {
        return this.nextPageUrl;
    }

    @NotNull
    public final RssResult copy(@NotNull List<RssArticle> articles, @Nullable String nextPageUrl) {
        j.e(articles, "articles");
        return new RssResult(articles, nextPageUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssResult)) {
            return false;
        }
        RssResult rssResult = (RssResult) other;
        return j.a(this.articles, rssResult.articles) && j.a(this.nextPageUrl, rssResult.nextPageUrl);
    }

    @NotNull
    public final List<RssArticle> getArticles() {
        return this.articles;
    }

    @Nullable
    public final String getNextPageUrl() {
        return this.nextPageUrl;
    }

    public int hashCode() {
        int iHashCode = this.articles.hashCode() * 31;
        String str = this.nextPageUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("RssResult(articles=");
        sbR.append(this.articles);
        sbR.append(", nextPageUrl=");
        sbR.append((Object) this.nextPageUrl);
        sbR.append(')');
        return sbR.toString();
    }
}
