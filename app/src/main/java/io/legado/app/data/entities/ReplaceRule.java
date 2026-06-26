package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.FrameMetricsAggregator;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReplaceRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({"id"})}, tableName = "replace_rules")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0004\bD\u0010EJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\tJn\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b$\u0010\u0011J\u0010\u0010%\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b%\u0010\tJ \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b*\u0010+R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010/R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u00103R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00104\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b5\u00106R$\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u00103R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00104\u001a\u0004\b \u0010\u000b\"\u0004\b9\u00106R\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010:\u001a\u0004\b;\u0010\t\"\u0004\b<\u0010=R$\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00100\u001a\u0004\b>\u0010\u0011\"\u0004\b?\u00103R\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00100\u001a\u0004\b@\u0010\u0011\"\u0004\bA\u00103R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00100\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u00103¨\u0006F"}, d2 = {"Lio/legado/app/data/entities/ReplaceRule;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "isValid", "()Z", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "id", "name", "group", "pattern", "replacement", "scope", "isEnabled", "isRegex", "order", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)Lio/legado/app/data/entities/ReplaceRule;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getId", "setId", "(J)V", "Ljava/lang/String;", "getPattern", "setPattern", "(Ljava/lang/String;)V", "Z", "setEnabled", "(Z)V", "getScope", "setScope", "setRegex", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getOrder", "setOrder", "(I)V", "getGroup", "setGroup", "getReplacement", "setReplacement", "getName", "setName", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ReplaceRule implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ReplaceRule> CREATOR = new Creator();

    @Nullable
    private String group;

    @PrimaryKey(autoGenerate = true)
    private long id;
    private boolean isEnabled;
    private boolean isRegex;

    @NotNull
    private String name;

    @ColumnInfo(name = "sortOrder")
    private int order;

    @NotNull
    private String pattern;

    @NotNull
    private String replacement;

    @Nullable
    private String scope;

    /* JADX INFO: compiled from: ReplaceRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<ReplaceRule> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReplaceRule createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new ReplaceRule(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReplaceRule[] newArray(int i2) {
            return new ReplaceRule[i2];
        }
    }

    public ReplaceRule() {
        this(0L, null, null, null, null, null, false, false, 0, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public ReplaceRule(long j2, @NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z, boolean z2, int i2) {
        j.e(str, "name");
        j.e(str3, "pattern");
        j.e(str4, "replacement");
        this.id = j2;
        this.name = str;
        this.group = str2;
        this.pattern = str3;
        this.replacement = str4;
        this.scope = str5;
        this.isEnabled = z;
        this.isRegex = z2;
        this.order = i2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReplacement() {
        return this.replacement;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsRegex() {
        return this.isRegex;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    @NotNull
    public final ReplaceRule copy(long id, @NotNull String name, @Nullable String group, @NotNull String pattern, @NotNull String replacement, @Nullable String scope, boolean isEnabled, boolean isRegex, int order) {
        j.e(name, "name");
        j.e(pattern, "pattern");
        j.e(replacement, "replacement");
        return new ReplaceRule(id, name, group, pattern, replacement, scope, isEnabled, isRegex, order);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReplaceRule ? ((ReplaceRule) other).id == this.id : super.equals(other);
    }

    @Nullable
    public final String getGroup() {
        return this.group;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getOrder() {
        return this.order;
    }

    @NotNull
    public final String getPattern() {
        return this.pattern;
    }

    @NotNull
    public final String getReplacement() {
        return this.replacement;
    }

    @Nullable
    public final String getScope() {
        return this.scope;
    }

    public int hashCode() {
        return b.a(this.id);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isRegex() {
        return this.isRegex;
    }

    public final boolean isValid() {
        if (TextUtils.isEmpty(this.pattern)) {
            return false;
        }
        if (!this.isRegex) {
            return true;
        }
        try {
            Pattern.compile(this.pattern);
            return true;
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final void setGroup(@Nullable String str) {
        this.group = str;
    }

    public final void setId(long j2) {
        this.id = j2;
    }

    public final void setName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setOrder(int i2) {
        this.order = i2;
    }

    public final void setPattern(@NotNull String str) {
        j.e(str, "<set-?>");
        this.pattern = str;
    }

    public final void setRegex(boolean z) {
        this.isRegex = z;
    }

    public final void setReplacement(@NotNull String str) {
        j.e(str, "<set-?>");
        this.replacement = str;
    }

    public final void setScope(@Nullable String str) {
        this.scope = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ReplaceRule(id=");
        sbR.append(this.id);
        sbR.append(", name=");
        sbR.append(this.name);
        sbR.append(", group=");
        sbR.append((Object) this.group);
        sbR.append(", pattern=");
        sbR.append(this.pattern);
        sbR.append(", replacement=");
        sbR.append(this.replacement);
        sbR.append(", scope=");
        sbR.append((Object) this.scope);
        sbR.append(", isEnabled=");
        sbR.append(this.isEnabled);
        sbR.append(", isRegex=");
        sbR.append(this.isRegex);
        sbR.append(", order=");
        return a.n(sbR, this.order, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.group);
        parcel.writeString(this.pattern);
        parcel.writeString(this.replacement);
        parcel.writeString(this.scope);
        parcel.writeInt(this.isEnabled ? 1 : 0);
        parcel.writeInt(this.isRegex ? 1 : 0);
        parcel.writeInt(this.order);
    }

    public /* synthetic */ ReplaceRule(long j2, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i2, int i3, f fVar) {
        this((i3 & 1) != 0 ? System.currentTimeMillis() : j2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) == 0 ? str4 : "", (i3 & 32) == 0 ? str5 : null, (i3 & 64) != 0 ? true : z, (i3 & 128) == 0 ? z2 : true, (i3 & 256) != 0 ? 0 : i2);
    }
}
