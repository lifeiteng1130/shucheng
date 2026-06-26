package io.legado.app.data.entities.rule;

import android.os.Parcel;
import android.os.Parcelable;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bD\u0010EJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0094\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b%\u0010\u001fJ \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b*\u0010+R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010/R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010,\u001a\u0004\b0\u0010\u0004\"\u0004\b1\u0010/R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010/R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010,\u001a\u0004\b4\u0010\u0004\"\u0004\b5\u0010/R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010,\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u0010/R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010,\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010/R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010,\u001a\u0004\b:\u0010\u0004\"\u0004\b;\u0010/R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010,\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010/R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010,\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u0010/R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u0010/R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010,\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u0010/¨\u0006F"}, d2 = {"Lio/legado/app/data/entities/rule/BookInfoRule;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "init", "name", "author", "intro", "kind", "lastChapter", "updateTime", "coverUrl", "tocUrl", "wordCount", "canReName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/rule/BookInfoRule;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getIntro", "setIntro", "(Ljava/lang/String;)V", "getAuthor", "setAuthor", "getCoverUrl", "setCoverUrl", "getTocUrl", "setTocUrl", "getKind", "setKind", "getUpdateTime", "setUpdateTime", "getLastChapter", "setLastChapter", "getWordCount", "setWordCount", "getCanReName", "setCanReName", "getName", "setName", "getInit", "setInit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class BookInfoRule implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BookInfoRule> CREATOR = new Creator();

    @Nullable
    private String author;

    @Nullable
    private String canReName;

    @Nullable
    private String coverUrl;

    @Nullable
    private String init;

    @Nullable
    private String intro;

    @Nullable
    private String kind;

    @Nullable
    private String lastChapter;

    @Nullable
    private String name;

    @Nullable
    private String tocUrl;

    @Nullable
    private String updateTime;

    @Nullable
    private String wordCount;

    /* JADX INFO: compiled from: BookInfoRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<BookInfoRule> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookInfoRule createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new BookInfoRule(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookInfoRule[] newArray(int i2) {
            return new BookInfoRule[i2];
        }
    }

    public BookInfoRule() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public BookInfoRule(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.init = str;
        this.name = str2;
        this.author = str3;
        this.intro = str4;
        this.kind = str5;
        this.lastChapter = str6;
        this.updateTime = str7;
        this.coverUrl = str8;
        this.tocUrl = str9;
        this.wordCount = str10;
        this.canReName = str11;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInit() {
        return this.init;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getWordCount() {
        return this.wordCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCanReName() {
        return this.canReName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLastChapter() {
        return this.lastChapter;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTocUrl() {
        return this.tocUrl;
    }

    @NotNull
    public final BookInfoRule copy(@Nullable String init, @Nullable String name, @Nullable String author, @Nullable String intro, @Nullable String kind, @Nullable String lastChapter, @Nullable String updateTime, @Nullable String coverUrl, @Nullable String tocUrl, @Nullable String wordCount, @Nullable String canReName) {
        return new BookInfoRule(init, name, author, intro, kind, lastChapter, updateTime, coverUrl, tocUrl, wordCount, canReName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookInfoRule)) {
            return false;
        }
        BookInfoRule bookInfoRule = (BookInfoRule) other;
        return j.a(this.init, bookInfoRule.init) && j.a(this.name, bookInfoRule.name) && j.a(this.author, bookInfoRule.author) && j.a(this.intro, bookInfoRule.intro) && j.a(this.kind, bookInfoRule.kind) && j.a(this.lastChapter, bookInfoRule.lastChapter) && j.a(this.updateTime, bookInfoRule.updateTime) && j.a(this.coverUrl, bookInfoRule.coverUrl) && j.a(this.tocUrl, bookInfoRule.tocUrl) && j.a(this.wordCount, bookInfoRule.wordCount) && j.a(this.canReName, bookInfoRule.canReName);
    }

    @Nullable
    public final String getAuthor() {
        return this.author;
    }

    @Nullable
    public final String getCanReName() {
        return this.canReName;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final String getInit() {
        return this.init;
    }

    @Nullable
    public final String getIntro() {
        return this.intro;
    }

    @Nullable
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    public final String getLastChapter() {
        return this.lastChapter;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTocUrl() {
        return this.tocUrl;
    }

    @Nullable
    public final String getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    public final String getWordCount() {
        return this.wordCount;
    }

    public int hashCode() {
        String str = this.init;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.author;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.intro;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.kind;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.lastChapter;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.updateTime;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.coverUrl;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.tocUrl;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.wordCount;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.canReName;
        return iHashCode10 + (str11 != null ? str11.hashCode() : 0);
    }

    public final void setAuthor(@Nullable String str) {
        this.author = str;
    }

    public final void setCanReName(@Nullable String str) {
        this.canReName = str;
    }

    public final void setCoverUrl(@Nullable String str) {
        this.coverUrl = str;
    }

    public final void setInit(@Nullable String str) {
        this.init = str;
    }

    public final void setIntro(@Nullable String str) {
        this.intro = str;
    }

    public final void setKind(@Nullable String str) {
        this.kind = str;
    }

    public final void setLastChapter(@Nullable String str) {
        this.lastChapter = str;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setTocUrl(@Nullable String str) {
        this.tocUrl = str;
    }

    public final void setUpdateTime(@Nullable String str) {
        this.updateTime = str;
    }

    public final void setWordCount(@Nullable String str) {
        this.wordCount = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("BookInfoRule(init=");
        sbR.append((Object) this.init);
        sbR.append(", name=");
        sbR.append((Object) this.name);
        sbR.append(", author=");
        sbR.append((Object) this.author);
        sbR.append(", intro=");
        sbR.append((Object) this.intro);
        sbR.append(", kind=");
        sbR.append((Object) this.kind);
        sbR.append(", lastChapter=");
        sbR.append((Object) this.lastChapter);
        sbR.append(", updateTime=");
        sbR.append((Object) this.updateTime);
        sbR.append(", coverUrl=");
        sbR.append((Object) this.coverUrl);
        sbR.append(", tocUrl=");
        sbR.append((Object) this.tocUrl);
        sbR.append(", wordCount=");
        sbR.append((Object) this.wordCount);
        sbR.append(", canReName=");
        sbR.append((Object) this.canReName);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.init);
        parcel.writeString(this.name);
        parcel.writeString(this.author);
        parcel.writeString(this.intro);
        parcel.writeString(this.kind);
        parcel.writeString(this.lastChapter);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.tocUrl);
        parcel.writeString(this.wordCount);
        parcel.writeString(this.canReName);
    }

    public /* synthetic */ BookInfoRule(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & 512) != 0 ? null : str10, (i2 & 1024) == 0 ? str11 : null);
    }
}
