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

/* JADX INFO: compiled from: ContentRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\"\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010%R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\"\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010%R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\"\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010%R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\"\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010%R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\"\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010%¨\u00062"}, d2 = {"Lio/legado/app/data/entities/rule/ContentRule;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "content", "nextContentUrl", "webJs", "sourceRegex", "replaceRegex", "imageStyle", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/rule/ContentRule;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getNextContentUrl", "setNextContentUrl", "(Ljava/lang/String;)V", "getImageStyle", "setImageStyle", "getContent", "setContent", "getReplaceRegex", "setReplaceRegex", "getWebJs", "setWebJs", "getSourceRegex", "setSourceRegex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ContentRule implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ContentRule> CREATOR = new Creator();

    @Nullable
    private String content;

    @Nullable
    private String imageStyle;

    @Nullable
    private String nextContentUrl;

    @Nullable
    private String replaceRegex;

    @Nullable
    private String sourceRegex;

    @Nullable
    private String webJs;

    /* JADX INFO: compiled from: ContentRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<ContentRule> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContentRule createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new ContentRule(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContentRule[] newArray(int i2) {
            return new ContentRule[i2];
        }
    }

    public ContentRule() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ContentRule(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.content = str;
        this.nextContentUrl = str2;
        this.webJs = str3;
        this.sourceRegex = str4;
        this.replaceRegex = str5;
        this.imageStyle = str6;
    }

    public static /* synthetic */ ContentRule copy$default(ContentRule contentRule, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = contentRule.content;
        }
        if ((i2 & 2) != 0) {
            str2 = contentRule.nextContentUrl;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = contentRule.webJs;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = contentRule.sourceRegex;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = contentRule.replaceRegex;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = contentRule.imageStyle;
        }
        return contentRule.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNextContentUrl() {
        return this.nextContentUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWebJs() {
        return this.webJs;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSourceRegex() {
        return this.sourceRegex;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReplaceRegex() {
        return this.replaceRegex;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImageStyle() {
        return this.imageStyle;
    }

    @NotNull
    public final ContentRule copy(@Nullable String content, @Nullable String nextContentUrl, @Nullable String webJs, @Nullable String sourceRegex, @Nullable String replaceRegex, @Nullable String imageStyle) {
        return new ContentRule(content, nextContentUrl, webJs, sourceRegex, replaceRegex, imageStyle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentRule)) {
            return false;
        }
        ContentRule contentRule = (ContentRule) other;
        return j.a(this.content, contentRule.content) && j.a(this.nextContentUrl, contentRule.nextContentUrl) && j.a(this.webJs, contentRule.webJs) && j.a(this.sourceRegex, contentRule.sourceRegex) && j.a(this.replaceRegex, contentRule.replaceRegex) && j.a(this.imageStyle, contentRule.imageStyle);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getImageStyle() {
        return this.imageStyle;
    }

    @Nullable
    public final String getNextContentUrl() {
        return this.nextContentUrl;
    }

    @Nullable
    public final String getReplaceRegex() {
        return this.replaceRegex;
    }

    @Nullable
    public final String getSourceRegex() {
        return this.sourceRegex;
    }

    @Nullable
    public final String getWebJs() {
        return this.webJs;
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nextContentUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.webJs;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sourceRegex;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.replaceRegex;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.imageStyle;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setImageStyle(@Nullable String str) {
        this.imageStyle = str;
    }

    public final void setNextContentUrl(@Nullable String str) {
        this.nextContentUrl = str;
    }

    public final void setReplaceRegex(@Nullable String str) {
        this.replaceRegex = str;
    }

    public final void setSourceRegex(@Nullable String str) {
        this.sourceRegex = str;
    }

    public final void setWebJs(@Nullable String str) {
        this.webJs = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ContentRule(content=");
        sbR.append((Object) this.content);
        sbR.append(", nextContentUrl=");
        sbR.append((Object) this.nextContentUrl);
        sbR.append(", webJs=");
        sbR.append((Object) this.webJs);
        sbR.append(", sourceRegex=");
        sbR.append((Object) this.sourceRegex);
        sbR.append(", replaceRegex=");
        sbR.append((Object) this.replaceRegex);
        sbR.append(", imageStyle=");
        sbR.append((Object) this.imageStyle);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.content);
        parcel.writeString(this.nextContentUrl);
        parcel.writeString(this.webJs);
        parcel.writeString(this.sourceRegex);
        parcel.writeString(this.replaceRegex);
        parcel.writeString(this.imageStyle);
    }

    public /* synthetic */ ContentRule(String str, String str2, String str3, String str4, String str5, String str6, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6);
    }
}
