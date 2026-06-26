package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import c.a.a.a.a;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.h.n;
import e.a.a.h.v;
import e.a.a.h.x;
import f.c0.c.j;
import f.e;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookChapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"bookUrl"}, entity = Book.class, onDelete = 5, parentColumns = {"bookUrl"})}, indices = {@Index(unique = false, value = {"bookUrl"}), @Index(unique = true, value = {"bookUrl", "index"})}, primaryKeys = {"url", "bookUrl"}, tableName = "chapters")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b]\u0010^J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011J\u0010\u0010\u0018\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0011J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0011J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0011J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0011J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0011J\u0096\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u0011J\u0010\u00101\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b1\u0010\nJ \u00105\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b5\u00106R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u00107\u001a\u0004\b8\u0010\u0011\"\u0004\b9\u0010:R/\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020;8F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b<\u0010=\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010?R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00107\u001a\u0004\bC\u0010\u0011\"\u0004\bD\u0010:R$\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010E\u001a\u0004\bF\u0010\u001d\"\u0004\bG\u0010HR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u00107\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010:R\"\u0010&\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010K\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010NR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00107\u001a\u0004\bO\u0010\u0011\"\u0004\bP\u0010:R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00107\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010:R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u00107\u001a\u0004\bS\u0010\u0011\"\u0004\bT\u0010:R$\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010E\u001a\u0004\bU\u0010\u001d\"\u0004\bV\u0010HR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u00107\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010:R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u00107\u001a\u0004\bY\u0010\u0011\"\u0004\bZ\u0010:R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u00107\u001a\u0004\b[\u0010\u0011\"\u0004\b\\\u0010:¨\u0006_"}, d2 = {"Lio/legado/app/data/entities/BookChapter;", "Landroid/os/Parcelable;", "", "key", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "putVariable", "(Ljava/lang/String;Ljava/lang/String;)V", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getAbsoluteURL", "()Ljava/lang/String;", "getFileName", "getFontName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Long;", "component9", "component10", "component11", "component12", "url", "title", "baseUrl", "bookUrl", "index", "resourceUrl", "tag", "start", "end", "startFragmentId", "endFragmentId", "variable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/BookChapter;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBookUrl", "setBookUrl", "(Ljava/lang/String;)V", "Ljava/util/HashMap;", "variableMap$delegate", "Lf/e;", "getVariableMap", "()Ljava/util/HashMap;", "getVariableMap$annotations", "()V", "variableMap", "getTag", "setTag", "Ljava/lang/Long;", "getEnd", "setEnd", "(Ljava/lang/Long;)V", "getResourceUrl", "setResourceUrl", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getIndex", "setIndex", "(I)V", "getEndFragmentId", "setEndFragmentId", "getUrl", "setUrl", "getStartFragmentId", "setStartFragmentId", "getStart", "setStart", "getBaseUrl", "setBaseUrl", "getTitle", "setTitle", "getVariable", "setVariable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class BookChapter implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BookChapter> CREATOR = new Creator();

    @NotNull
    private String baseUrl;

    @NotNull
    private String bookUrl;

    @Nullable
    private Long end;

    @Nullable
    private String endFragmentId;
    private int index;

    @Nullable
    private String resourceUrl;

    @Nullable
    private Long start;

    @Nullable
    private String startFragmentId;

    @Nullable
    private String tag;

    @NotNull
    private String title;

    @NotNull
    private String url;

    @Nullable
    private String variable;

    /* JADX INFO: renamed from: variableMap$delegate, reason: from kotlin metadata */
    @Ignore
    @NotNull
    private final transient e variableMap;

    /* JADX INFO: compiled from: BookChapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<BookChapter> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookChapter createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new BookChapter(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookChapter[] newArray(int i2) {
            return new BookChapter[i2];
        }
    }

    public BookChapter() {
        this(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
    }

    public BookChapter(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, @Nullable String str5, @Nullable String str6, @Nullable Long l2, @Nullable Long l3, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        j.e(str, "url");
        j.e(str2, "title");
        j.e(str3, "baseUrl");
        j.e(str4, "bookUrl");
        this.url = str;
        this.title = str2;
        this.baseUrl = str3;
        this.bookUrl = str4;
        this.index = i2;
        this.resourceUrl = str5;
        this.tag = str6;
        this.start = l2;
        this.end = l3;
        this.startFragmentId = str7;
        this.endFragmentId = str8;
        this.variable = str9;
        this.variableMap = f.N3(new BookChapter$variableMap$2(this));
    }

    public static /* synthetic */ void getVariableMap$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStartFragmentId() {
        return this.startFragmentId;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEndFragmentId() {
        return this.endFragmentId;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getVariable() {
        return this.variable;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBookUrl() {
        return this.bookUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getStart() {
        return this.start;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getEnd() {
        return this.end;
    }

    @NotNull
    public final BookChapter copy(@NotNull String url, @NotNull String title, @NotNull String baseUrl, @NotNull String bookUrl, int index, @Nullable String resourceUrl, @Nullable String tag, @Nullable Long start, @Nullable Long end, @Nullable String startFragmentId, @Nullable String endFragmentId, @Nullable String variable) {
        j.e(url, "url");
        j.e(title, "title");
        j.e(baseUrl, "baseUrl");
        j.e(bookUrl, "bookUrl");
        return new BookChapter(url, title, baseUrl, bookUrl, index, resourceUrl, tag, start, end, startFragmentId, endFragmentId, variable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof BookChapter) {
            return j.a(((BookChapter) other).url, this.url);
        }
        return false;
    }

    @NotNull
    public final String getAbsoluteURL() {
        List<String> listSplit = AnalyzeUrl.INSTANCE.getSplitUrlRegex().split(this.url, 0);
        x xVar = x.a;
        String strA = x.a(this.baseUrl, listSplit.get(0));
        if (listSplit.size() <= 1) {
            return strA;
        }
        return strA + ',' + listSplit.get(1);
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final String getBookUrl() {
        return this.bookUrl;
    }

    @Nullable
    public final Long getEnd() {
        return this.end;
    }

    @Nullable
    public final String getEndFragmentId() {
        return this.endFragmentId;
    }

    @NotNull
    public final String getFileName() {
        String str = String.format("%05d-%s.nb", Arrays.copyOf(new Object[]{Integer.valueOf(this.index), v.b(this.title)}, 2));
        j.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    @NotNull
    public final String getFontName() {
        String str = String.format("%05d-%s.ttf", Arrays.copyOf(new Object[]{Integer.valueOf(this.index), v.b(this.title)}, 2));
        j.d(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final int getIndex() {
        return this.index;
    }

    @Nullable
    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    @Nullable
    public final Long getStart() {
        return this.start;
    }

    @Nullable
    public final String getStartFragmentId() {
        return this.startFragmentId;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getVariable() {
        return this.variable;
    }

    @NotNull
    public final HashMap<String, String> getVariableMap() {
        return (HashMap) this.variableMap.getValue();
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final void putVariable(@NotNull String key, @NotNull String value) {
        j.e(key, "key");
        j.e(value, ES6Iterator.VALUE_PROPERTY);
        getVariableMap().put(key, value);
        this.variable = n.a().toJson(getVariableMap());
    }

    public final void setBaseUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setBookUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookUrl = str;
    }

    public final void setEnd(@Nullable Long l2) {
        this.end = l2;
    }

    public final void setEndFragmentId(@Nullable String str) {
        this.endFragmentId = str;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final void setResourceUrl(@Nullable String str) {
        this.resourceUrl = str;
    }

    public final void setStart(@Nullable Long l2) {
        this.start = l2;
    }

    public final void setStartFragmentId(@Nullable String str) {
        this.startFragmentId = str;
    }

    public final void setTag(@Nullable String str) {
        this.tag = str;
    }

    public final void setTitle(@NotNull String str) {
        j.e(str, "<set-?>");
        this.title = str;
    }

    public final void setUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.url = str;
    }

    public final void setVariable(@Nullable String str) {
        this.variable = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("BookChapter(url=");
        sbR.append(this.url);
        sbR.append(", title=");
        sbR.append(this.title);
        sbR.append(", baseUrl=");
        sbR.append(this.baseUrl);
        sbR.append(", bookUrl=");
        sbR.append(this.bookUrl);
        sbR.append(", index=");
        sbR.append(this.index);
        sbR.append(", resourceUrl=");
        sbR.append((Object) this.resourceUrl);
        sbR.append(", tag=");
        sbR.append((Object) this.tag);
        sbR.append(", start=");
        sbR.append(this.start);
        sbR.append(", end=");
        sbR.append(this.end);
        sbR.append(", startFragmentId=");
        sbR.append((Object) this.startFragmentId);
        sbR.append(", endFragmentId=");
        sbR.append((Object) this.endFragmentId);
        sbR.append(", variable=");
        sbR.append((Object) this.variable);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.baseUrl);
        parcel.writeString(this.bookUrl);
        parcel.writeInt(this.index);
        parcel.writeString(this.resourceUrl);
        parcel.writeString(this.tag);
        Long l2 = this.start;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Long l3 = this.end;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeString(this.startFragmentId);
        parcel.writeString(this.endFragmentId);
        parcel.writeString(this.variable);
    }

    public /* synthetic */ BookChapter(String str, String str2, String str3, String str4, int i2, String str5, String str6, Long l2, Long l3, String str7, String str8, String str9, int i3, f.c0.c.f fVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) == 0 ? str4 : "", (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? null : str6, (i3 & 128) != 0 ? null : l2, (i3 & 256) != 0 ? null : l3, (i3 & 512) != 0 ? null : str7, (i3 & 1024) != 0 ? null : str8, (i3 & 2048) == 0 ? str9 : null);
    }
}
