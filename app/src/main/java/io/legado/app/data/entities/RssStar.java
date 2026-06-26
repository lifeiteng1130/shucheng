package io.legado.app.data.entities;

import androidx.media.AudioAttributesCompat;
import androidx.room.Entity;
import androidx.room.Ignore;
import c.a.a.a.a;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import e.a.a.h.n;
import f.c0.c.j;
import f.e;
import io.legado.app.model.analyzeRule.RuleDataInterface;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: RssStar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(primaryKeys = {"origin", "link"}, tableName = "rssStars")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bM\u0010NJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\fJ~\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\fJ\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\f\"\u0004\b/\u00100R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010-\u001a\u0004\b1\u0010\f\"\u0004\b2\u00100R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010-\u001a\u0004\b3\u0010\f\"\u0004\b4\u00100R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00105\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u00108R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010-\u001a\u0004\b9\u0010\f\"\u0004\b:\u00100R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010-\u001a\u0004\b;\u0010\f\"\u0004\b<\u00100R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010-\u001a\u0004\b=\u0010\f\"\u0004\b>\u00100R/\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020?8V@\u0017X\u0097\u0084\u0002¢\u0006\u0012\n\u0004\b@\u0010A\u0012\u0004\bD\u0010E\u001a\u0004\bB\u0010CR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010-\u001a\u0004\bG\u0010\f\"\u0004\bH\u00100R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010-\u001a\u0004\bI\u0010\f\"\u0004\bJ\u00100R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010-\u001a\u0004\bK\u0010\f\"\u0004\bL\u00100¨\u0006O"}, d2 = {"Lio/legado/app/data/entities/RssStar;", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "", "key", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "putVariable", "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/legado/app/data/entities/RssArticle;", "toRssArticle", "()Lio/legado/app/data/entities/RssArticle;", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "component6", "component7", "component8", "component9", "component10", "origin", "sort", "title", "starTime", "link", "pubDate", "description", "content", "image", "variable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/RssStar;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getLink", "setLink", "getImage", "setImage", "J", "getStarTime", "setStarTime", "(J)V", "getVariable", "setVariable", "getOrigin", "setOrigin", "getSort", "setSort", "Ljava/util/HashMap;", "variableMap$delegate", "Lf/e;", "getVariableMap", "()Ljava/util/HashMap;", "getVariableMap$annotations", "()V", "variableMap", "getPubDate", "setPubDate", "getDescription", "setDescription", "getContent", "setContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class RssStar implements RuleDataInterface {

    @Nullable
    private String content;

    @Nullable
    private String description;

    @Nullable
    private String image;

    @NotNull
    private String link;

    @NotNull
    private String origin;

    @Nullable
    private String pubDate;

    @NotNull
    private String sort;
    private long starTime;

    @NotNull
    private String title;

    @Nullable
    private String variable;

    /* JADX INFO: renamed from: variableMap$delegate, reason: from kotlin metadata */
    @Ignore
    @NotNull
    private final transient e variableMap;

    public RssStar() {
        this(null, null, null, 0L, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
    }

    public RssStar(@NotNull String str, @NotNull String str2, @NotNull String str3, long j2, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        j.e(str, "origin");
        j.e(str2, "sort");
        j.e(str3, "title");
        j.e(str4, "link");
        this.origin = str;
        this.sort = str2;
        this.title = str3;
        this.starTime = j2;
        this.link = str4;
        this.pubDate = str5;
        this.description = str6;
        this.content = str7;
        this.image = str8;
        this.variable = str9;
        this.variableMap = f.N3(new RssStar$variableMap$2(this));
    }

    public static /* synthetic */ void getVariableMap$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVariable() {
        return this.variable;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStarTime() {
        return this.starTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPubDate() {
        return this.pubDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final RssStar copy(@NotNull String origin, @NotNull String sort, @NotNull String title, long starTime, @NotNull String link, @Nullable String pubDate, @Nullable String description, @Nullable String content, @Nullable String image, @Nullable String variable) {
        j.e(origin, "origin");
        j.e(sort, "sort");
        j.e(title, "title");
        j.e(link, "link");
        return new RssStar(origin, sort, title, starTime, link, pubDate, description, content, image, variable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssStar)) {
            return false;
        }
        RssStar rssStar = (RssStar) other;
        return j.a(this.origin, rssStar.origin) && j.a(this.sort, rssStar.sort) && j.a(this.title, rssStar.title) && this.starTime == rssStar.starTime && j.a(this.link, rssStar.link) && j.a(this.pubDate, rssStar.pubDate) && j.a(this.description, rssStar.description) && j.a(this.content, rssStar.content) && j.a(this.image, rssStar.image) && j.a(this.variable, rssStar.variable);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    @NotNull
    public final String getOrigin() {
        return this.origin;
    }

    @Nullable
    public final String getPubDate() {
        return this.pubDate;
    }

    @NotNull
    public final String getSort() {
        return this.sort;
    }

    public final long getStarTime() {
        return this.starTime;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getVariable() {
        return this.variable;
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    @NotNull
    public HashMap<String, String> getVariableMap() {
        return (HashMap) this.variableMap.getValue();
    }

    public int hashCode() {
        int iM = a.m(this.link, (b.a(this.starTime) + a.m(this.title, a.m(this.sort, this.origin.hashCode() * 31, 31), 31)) * 31, 31);
        String str = this.pubDate;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.content;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.variable;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    public void putVariable(@NotNull String key, @NotNull String value) {
        j.e(key, "key");
        j.e(value, ES6Iterator.VALUE_PROPERTY);
        getVariableMap().put(key, value);
        this.variable = n.a().toJson(getVariableMap());
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setImage(@Nullable String str) {
        this.image = str;
    }

    public final void setLink(@NotNull String str) {
        j.e(str, "<set-?>");
        this.link = str;
    }

    public final void setOrigin(@NotNull String str) {
        j.e(str, "<set-?>");
        this.origin = str;
    }

    public final void setPubDate(@Nullable String str) {
        this.pubDate = str;
    }

    public final void setSort(@NotNull String str) {
        j.e(str, "<set-?>");
        this.sort = str;
    }

    public final void setStarTime(long j2) {
        this.starTime = j2;
    }

    public final void setTitle(@NotNull String str) {
        j.e(str, "<set-?>");
        this.title = str;
    }

    public final void setVariable(@Nullable String str) {
        this.variable = str;
    }

    @NotNull
    public final RssArticle toRssArticle() {
        return new RssArticle(this.origin, this.sort, this.title, 0L, this.link, this.pubDate, this.description, this.content, this.image, false, null, 1544, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("RssStar(origin=");
        sbR.append(this.origin);
        sbR.append(", sort=");
        sbR.append(this.sort);
        sbR.append(", title=");
        sbR.append(this.title);
        sbR.append(", starTime=");
        sbR.append(this.starTime);
        sbR.append(", link=");
        sbR.append(this.link);
        sbR.append(", pubDate=");
        sbR.append((Object) this.pubDate);
        sbR.append(", description=");
        sbR.append((Object) this.description);
        sbR.append(", content=");
        sbR.append((Object) this.content);
        sbR.append(", image=");
        sbR.append((Object) this.image);
        sbR.append(", variable=");
        sbR.append((Object) this.variable);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ RssStar(String str, String str2, String str3, long j2, String str4, String str5, String str6, String str7, String str8, String str9, int i2, f.c0.c.f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) == 0 ? str4 : "", (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) == 0 ? str9 : null);
    }
}
