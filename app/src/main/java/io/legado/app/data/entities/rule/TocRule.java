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

/* JADX INFO: compiled from: TocRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b/\u00100J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\"\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010%R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\"\u001a\u0004\b\r\u0010\u0004\"\u0004\b(\u0010%R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\"\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010%R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\"\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010%R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\"\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010%¨\u00061"}, d2 = {"Lio/legado/app/data/entities/rule/TocRule;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "chapterList", "chapterName", "chapterUrl", "isVip", "updateTime", "nextTocUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/rule/TocRule;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getChapterUrl", "setChapterUrl", "(Ljava/lang/String;)V", "getChapterName", "setChapterName", "setVip", "getUpdateTime", "setUpdateTime", "getNextTocUrl", "setNextTocUrl", "getChapterList", "setChapterList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class TocRule implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TocRule> CREATOR = new Creator();

    @Nullable
    private String chapterList;

    @Nullable
    private String chapterName;

    @Nullable
    private String chapterUrl;

    @Nullable
    private String isVip;

    @Nullable
    private String nextTocUrl;

    @Nullable
    private String updateTime;

    /* JADX INFO: compiled from: TocRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<TocRule> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TocRule createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new TocRule(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TocRule[] newArray(int i2) {
            return new TocRule[i2];
        }
    }

    public TocRule() {
        this(null, null, null, null, null, null, 63, null);
    }

    public TocRule(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.chapterList = str;
        this.chapterName = str2;
        this.chapterUrl = str3;
        this.isVip = str4;
        this.updateTime = str5;
        this.nextTocUrl = str6;
    }

    public static /* synthetic */ TocRule copy$default(TocRule tocRule, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tocRule.chapterList;
        }
        if ((i2 & 2) != 0) {
            str2 = tocRule.chapterName;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = tocRule.chapterUrl;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = tocRule.isVip;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = tocRule.updateTime;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = tocRule.nextTocUrl;
        }
        return tocRule.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChapterList() {
        return this.chapterList;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChapterName() {
        return this.chapterName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChapterUrl() {
        return this.chapterUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNextTocUrl() {
        return this.nextTocUrl;
    }

    @NotNull
    public final TocRule copy(@Nullable String chapterList, @Nullable String chapterName, @Nullable String chapterUrl, @Nullable String isVip, @Nullable String updateTime, @Nullable String nextTocUrl) {
        return new TocRule(chapterList, chapterName, chapterUrl, isVip, updateTime, nextTocUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TocRule)) {
            return false;
        }
        TocRule tocRule = (TocRule) other;
        return j.a(this.chapterList, tocRule.chapterList) && j.a(this.chapterName, tocRule.chapterName) && j.a(this.chapterUrl, tocRule.chapterUrl) && j.a(this.isVip, tocRule.isVip) && j.a(this.updateTime, tocRule.updateTime) && j.a(this.nextTocUrl, tocRule.nextTocUrl);
    }

    @Nullable
    public final String getChapterList() {
        return this.chapterList;
    }

    @Nullable
    public final String getChapterName() {
        return this.chapterName;
    }

    @Nullable
    public final String getChapterUrl() {
        return this.chapterUrl;
    }

    @Nullable
    public final String getNextTocUrl() {
        return this.nextTocUrl;
    }

    @Nullable
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        String str = this.chapterList;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.chapterName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.chapterUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.isVip;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.updateTime;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.nextTocUrl;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    @Nullable
    public final String isVip() {
        return this.isVip;
    }

    public final void setChapterList(@Nullable String str) {
        this.chapterList = str;
    }

    public final void setChapterName(@Nullable String str) {
        this.chapterName = str;
    }

    public final void setChapterUrl(@Nullable String str) {
        this.chapterUrl = str;
    }

    public final void setNextTocUrl(@Nullable String str) {
        this.nextTocUrl = str;
    }

    public final void setUpdateTime(@Nullable String str) {
        this.updateTime = str;
    }

    public final void setVip(@Nullable String str) {
        this.isVip = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("TocRule(chapterList=");
        sbR.append((Object) this.chapterList);
        sbR.append(", chapterName=");
        sbR.append((Object) this.chapterName);
        sbR.append(", chapterUrl=");
        sbR.append((Object) this.chapterUrl);
        sbR.append(", isVip=");
        sbR.append((Object) this.isVip);
        sbR.append(", updateTime=");
        sbR.append((Object) this.updateTime);
        sbR.append(", nextTocUrl=");
        sbR.append((Object) this.nextTocUrl);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.chapterList);
        parcel.writeString(this.chapterName);
        parcel.writeString(this.chapterUrl);
        parcel.writeString(this.isVip);
        parcel.writeString(this.updateTime);
        parcel.writeString(this.nextTocUrl);
    }

    public /* synthetic */ TocRule(String str, String str2, String str3, String str4, String str5, String str6, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6);
    }
}
