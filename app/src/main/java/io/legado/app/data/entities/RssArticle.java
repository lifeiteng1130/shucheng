package io.legado.app.data.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import c.a.a.a.a;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.h.n;
import f.c0.c.j;
import f.e;
import io.legado.app.model.analyzeRule.RuleDataInterface;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: RssArticle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(primaryKeys = {"origin", "link"}, tableName = "rssArticles")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\"\u001a\u00020\n\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\n\u0012\b\b\u0002\u0010%\u001a\u00020\u0017\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bT\u0010UJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0014J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0014J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0014J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u0010\u0010\u001f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b!\u0010\u0014J\u0088\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\u00172\b\b\u0002\u0010&\u001a\u00020\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010+\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b/\u0010\u0014R$\u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u00100\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u00103R\"\u0010#\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u00103R\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u00103R$\u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u00100\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u00103R$\u0010,\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00100\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u00103R\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u00103R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u00103R$\u0010(\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00100\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u00103R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010B\u001a\u0004\bC\u0010 \"\u0004\bD\u0010ER/\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0F8V@\u0017X\u0097\u0084\u0002¢\u0006\u0012\n\u0004\bG\u0010H\u0012\u0004\bK\u0010L\u001a\u0004\bI\u0010JR$\u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u00100\u001a\u0004\bN\u0010\u0014\"\u0004\bO\u00103R\"\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010P\u001a\u0004\bQ\u0010\u0019\"\u0004\bR\u0010S¨\u0006V"}, d2 = {"Lio/legado/app/data/entities/RssArticle;", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "key", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "putVariable", "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/legado/app/data/entities/RssStar;", "toStar", "()Lio/legado/app/data/entities/RssStar;", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "component6", "component7", "component8", "component9", "component10", "()Z", "component11", "origin", "sort", "title", "order", "link", "pubDate", "description", "content", "image", "read", "variable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lio/legado/app/data/entities/RssArticle;", "toString", "Ljava/lang/String;", "getContent", "setContent", "(Ljava/lang/String;)V", "getSort", "setSort", "getTitle", "setTitle", "getImage", "setImage", "getVariable", "setVariable", "getLink", "setLink", "getOrigin", "setOrigin", "getDescription", "setDescription", "Z", "getRead", "setRead", "(Z)V", "Ljava/util/HashMap;", "variableMap$delegate", "Lf/e;", "getVariableMap", "()Ljava/util/HashMap;", "getVariableMap$annotations", "()V", "variableMap", "getPubDate", "setPubDate", "J", "getOrder", "setOrder", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class RssArticle implements RuleDataInterface {

    @Nullable
    private String content;

    @Nullable
    private String description;

    @Nullable
    private String image;

    @NotNull
    private String link;
    private long order;

    @NotNull
    private String origin;

    @Nullable
    private String pubDate;
    private boolean read;

    @NotNull
    private String sort;

    @NotNull
    private String title;

    @Nullable
    private String variable;

    /* JADX INFO: renamed from: variableMap$delegate, reason: from kotlin metadata */
    @Ignore
    @NotNull
    private final transient e variableMap;

    public RssArticle() {
        this(null, null, null, 0L, null, null, null, null, null, false, null, 2047, null);
    }

    public RssArticle(@NotNull String str, @NotNull String str2, @NotNull String str3, long j2, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, boolean z, @Nullable String str9) {
        j.e(str, "origin");
        j.e(str2, "sort");
        j.e(str3, "title");
        j.e(str4, "link");
        this.origin = str;
        this.sort = str2;
        this.title = str3;
        this.order = j2;
        this.link = str4;
        this.pubDate = str5;
        this.description = str6;
        this.content = str7;
        this.image = str8;
        this.read = z;
        this.variable = str9;
        this.variableMap = f.N3(new RssArticle$variableMap$2(this));
    }

    public static /* synthetic */ void getVariableMap$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getRead() {
        return this.read;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
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
    public final long getOrder() {
        return this.order;
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
    public final RssArticle copy(@NotNull String origin, @NotNull String sort, @NotNull String title, long order, @NotNull String link, @Nullable String pubDate, @Nullable String description, @Nullable String content, @Nullable String image, boolean read, @Nullable String variable) {
        j.e(origin, "origin");
        j.e(sort, "sort");
        j.e(title, "title");
        j.e(link, "link");
        return new RssArticle(origin, sort, title, order, link, pubDate, description, content, image, read, variable);
    }

    public boolean equals(@Nullable Object other) {
        if (other == null || !(other instanceof RssArticle)) {
            return false;
        }
        RssArticle rssArticle = (RssArticle) other;
        return j.a(this.origin, rssArticle.origin) && j.a(this.link, rssArticle.link);
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

    public final long getOrder() {
        return this.order;
    }

    @NotNull
    public final String getOrigin() {
        return this.origin;
    }

    @Nullable
    public final String getPubDate() {
        return this.pubDate;
    }

    public final boolean getRead() {
        return this.read;
    }

    @NotNull
    public final String getSort() {
        return this.sort;
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
        return this.link.hashCode();
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

    public final void setOrder(long j2) {
        this.order = j2;
    }

    public final void setOrigin(@NotNull String str) {
        j.e(str, "<set-?>");
        this.origin = str;
    }

    public final void setPubDate(@Nullable String str) {
        this.pubDate = str;
    }

    public final void setRead(boolean z) {
        this.read = z;
    }

    public final void setSort(@NotNull String str) {
        j.e(str, "<set-?>");
        this.sort = str;
    }

    public final void setTitle(@NotNull String str) {
        j.e(str, "<set-?>");
        this.title = str;
    }

    public final void setVariable(@Nullable String str) {
        this.variable = str;
    }

    @NotNull
    public final RssStar toStar() {
        return new RssStar(this.origin, this.sort, this.title, System.currentTimeMillis(), this.link, this.pubDate, this.description, this.content, this.image, null, 512, null);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("RssArticle(origin=");
        sbR.append(this.origin);
        sbR.append(", sort=");
        sbR.append(this.sort);
        sbR.append(", title=");
        sbR.append(this.title);
        sbR.append(", order=");
        sbR.append(this.order);
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
        sbR.append(", read=");
        sbR.append(this.read);
        sbR.append(", variable=");
        sbR.append((Object) this.variable);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ RssArticle(String str, String str2, String str3, long j2, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, int i2, f.c0.c.f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) == 0 ? str4 : "", (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? false : z, (i2 & 1024) == 0 ? str9 : null);
    }
}
