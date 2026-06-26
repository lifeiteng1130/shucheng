package io.legado.app.data.entities.rule;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media.AudioAttributesCompat;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u007f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0088\u0001\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b$\u0010\u001eJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b)\u0010*R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\u0005\"\u0004\b-\u0010.R$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b/\u0010\u0005\"\u0004\b0\u0010.R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\b1\u0010\u0005\"\u0004\b2\u0010.R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010+\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010.R$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010+\u001a\u0004\b5\u0010\u0005\"\u0004\b6\u0010.R$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b7\u0010\u0005\"\u0004\b8\u0010.R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010+\u001a\u0004\b9\u0010\u0005\"\u0004\b:\u0010.R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\b;\u0010\u0005\"\u0004\b<\u0010.R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b=\u0010\u0005\"\u0004\b>\u0010.R$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010+\u001a\u0004\b?\u0010\u0005\"\u0004\b@\u0010.¨\u0006C"}, d2 = {"Lio/legado/app/data/entities/rule/ExploreRule;", "Lio/legado/app/data/entities/rule/BookListRule;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "bookList", "name", "author", "intro", "kind", "lastChapter", "updateTime", "bookUrl", "coverUrl", "wordCount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/rule/ExploreRule;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAuthor", "setAuthor", "(Ljava/lang/String;)V", "getBookUrl", "setBookUrl", "getCoverUrl", "setCoverUrl", "getUpdateTime", "setUpdateTime", "getName", "setName", "getBookList", "setBookList", "getKind", "setKind", "getWordCount", "setWordCount", "getIntro", "setIntro", "getLastChapter", "setLastChapter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ExploreRule implements BookListRule, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ExploreRule> CREATOR = new Creator();

    @Nullable
    private String author;

    @Nullable
    private String bookList;

    @Nullable
    private String bookUrl;

    @Nullable
    private String coverUrl;

    @Nullable
    private String intro;

    @Nullable
    private String kind;

    @Nullable
    private String lastChapter;

    @Nullable
    private String name;

    @Nullable
    private String updateTime;

    @Nullable
    private String wordCount;

    /* JADX INFO: compiled from: ExploreRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<ExploreRule> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExploreRule createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new ExploreRule(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExploreRule[] newArray(int i2) {
            return new ExploreRule[i2];
        }
    }

    public ExploreRule() {
        this(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
    }

    public ExploreRule(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.bookList = str;
        this.name = str2;
        this.author = str3;
        this.intro = str4;
        this.kind = str5;
        this.lastChapter = str6;
        this.updateTime = str7;
        this.bookUrl = str8;
        this.coverUrl = str9;
        this.wordCount = str10;
    }

    @Nullable
    public final String component1() {
        return getBookList();
    }

    @Nullable
    public final String component10() {
        return getWordCount();
    }

    @Nullable
    public final String component2() {
        return getName();
    }

    @Nullable
    public final String component3() {
        return getAuthor();
    }

    @Nullable
    public final String component4() {
        return getIntro();
    }

    @Nullable
    public final String component5() {
        return getKind();
    }

    @Nullable
    public final String component6() {
        return getLastChapter();
    }

    @Nullable
    public final String component7() {
        return getUpdateTime();
    }

    @Nullable
    public final String component8() {
        return getBookUrl();
    }

    @Nullable
    public final String component9() {
        return getCoverUrl();
    }

    @NotNull
    public final ExploreRule copy(@Nullable String bookList, @Nullable String name, @Nullable String author, @Nullable String intro, @Nullable String kind, @Nullable String lastChapter, @Nullable String updateTime, @Nullable String bookUrl, @Nullable String coverUrl, @Nullable String wordCount) {
        return new ExploreRule(bookList, name, author, intro, kind, lastChapter, updateTime, bookUrl, coverUrl, wordCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExploreRule)) {
            return false;
        }
        ExploreRule exploreRule = (ExploreRule) other;
        return j.a(getBookList(), exploreRule.getBookList()) && j.a(getName(), exploreRule.getName()) && j.a(getAuthor(), exploreRule.getAuthor()) && j.a(getIntro(), exploreRule.getIntro()) && j.a(getKind(), exploreRule.getKind()) && j.a(getLastChapter(), exploreRule.getLastChapter()) && j.a(getUpdateTime(), exploreRule.getUpdateTime()) && j.a(getBookUrl(), exploreRule.getBookUrl()) && j.a(getCoverUrl(), exploreRule.getCoverUrl()) && j.a(getWordCount(), exploreRule.getWordCount());
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getAuthor() {
        return this.author;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getBookList() {
        return this.bookList;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getBookUrl() {
        return this.bookUrl;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getIntro() {
        return this.intro;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getKind() {
        return this.kind;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getLastChapter() {
        return this.lastChapter;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getName() {
        return this.name;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getUpdateTime() {
        return this.updateTime;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    @Nullable
    public String getWordCount() {
        return this.wordCount;
    }

    public int hashCode() {
        return ((((((((((((((((((getBookList() == null ? 0 : getBookList().hashCode()) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getAuthor() == null ? 0 : getAuthor().hashCode())) * 31) + (getIntro() == null ? 0 : getIntro().hashCode())) * 31) + (getKind() == null ? 0 : getKind().hashCode())) * 31) + (getLastChapter() == null ? 0 : getLastChapter().hashCode())) * 31) + (getUpdateTime() == null ? 0 : getUpdateTime().hashCode())) * 31) + (getBookUrl() == null ? 0 : getBookUrl().hashCode())) * 31) + (getCoverUrl() == null ? 0 : getCoverUrl().hashCode())) * 31) + (getWordCount() != null ? getWordCount().hashCode() : 0);
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setAuthor(@Nullable String str) {
        this.author = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setBookList(@Nullable String str) {
        this.bookList = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setBookUrl(@Nullable String str) {
        this.bookUrl = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setCoverUrl(@Nullable String str) {
        this.coverUrl = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setIntro(@Nullable String str) {
        this.intro = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setKind(@Nullable String str) {
        this.kind = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setLastChapter(@Nullable String str) {
        this.lastChapter = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setName(@Nullable String str) {
        this.name = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setUpdateTime(@Nullable String str) {
        this.updateTime = str;
    }

    @Override // io.legado.app.data.entities.rule.BookListRule
    public void setWordCount(@Nullable String str) {
        this.wordCount = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ExploreRule(bookList=");
        sbR.append((Object) getBookList());
        sbR.append(", name=");
        sbR.append((Object) getName());
        sbR.append(", author=");
        sbR.append((Object) getAuthor());
        sbR.append(", intro=");
        sbR.append((Object) getIntro());
        sbR.append(", kind=");
        sbR.append((Object) getKind());
        sbR.append(", lastChapter=");
        sbR.append((Object) getLastChapter());
        sbR.append(", updateTime=");
        sbR.append((Object) getUpdateTime());
        sbR.append(", bookUrl=");
        sbR.append((Object) getBookUrl());
        sbR.append(", coverUrl=");
        sbR.append((Object) getCoverUrl());
        sbR.append(", wordCount=");
        sbR.append((Object) getWordCount());
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.bookList);
        parcel.writeString(this.name);
        parcel.writeString(this.author);
        parcel.writeString(this.intro);
        parcel.writeString(this.kind);
        parcel.writeString(this.lastChapter);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.bookUrl);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.wordCount);
    }

    public /* synthetic */ ExploreRule(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & 512) == 0 ? str10 : null);
    }
}
