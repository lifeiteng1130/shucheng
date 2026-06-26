package io.legado.app.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: TxtTocRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = "txtTocRules")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010&R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\u001eR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lio/legado/app/data/entities/TxtTocRule;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "", "component5", "()Z", "id", "name", "rule", "serialNumber", "enable", "copy", "(JLjava/lang/String;Ljava/lang/String;IZ)Lio/legado/app/data/entities/TxtTocRule;", "toString", TTDownloadField.TT_HASHCODE, "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRule", "setRule", "(Ljava/lang/String;)V", "J", "getId", "setId", "(J)V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getSerialNumber", "setSerialNumber", "(I)V", "getName", "setName", "Z", "getEnable", "setEnable", "(Z)V", "<init>", "(JLjava/lang/String;Ljava/lang/String;IZ)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class TxtTocRule {
    private boolean enable;

    @PrimaryKey
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String rule;
    private int serialNumber;

    public TxtTocRule() {
        this(0L, null, null, 0, false, 31, null);
    }

    public TxtTocRule(long j2, @NotNull String str, @NotNull String str2, int i2, boolean z) {
        j.e(str, "name");
        j.e(str2, "rule");
        this.id = j2;
        this.name = str;
        this.rule = str2;
        this.serialNumber = i2;
        this.enable = z;
    }

    public static /* synthetic */ TxtTocRule copy$default(TxtTocRule txtTocRule, long j2, String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j2 = txtTocRule.id;
        }
        long j3 = j2;
        if ((i3 & 2) != 0) {
            str = txtTocRule.name;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = txtTocRule.rule;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i2 = txtTocRule.serialNumber;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            z = txtTocRule.enable;
        }
        return txtTocRule.copy(j3, str3, str4, i4, z);
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

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRule() {
        return this.rule;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSerialNumber() {
        return this.serialNumber;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final TxtTocRule copy(long id, @NotNull String name, @NotNull String rule, int serialNumber, boolean enable) {
        j.e(name, "name");
        j.e(rule, "rule");
        return new TxtTocRule(id, name, rule, serialNumber, enable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TxtTocRule)) {
            return false;
        }
        TxtTocRule txtTocRule = (TxtTocRule) other;
        return this.id == txtTocRule.id && j.a(this.name, txtTocRule.name) && j.a(this.rule, txtTocRule.rule) && this.serialNumber == txtTocRule.serialNumber && this.enable == txtTocRule.enable;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRule() {
        return this.rule;
    }

    public final int getSerialNumber() {
        return this.serialNumber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        int iM = (a.m(this.rule, a.m(this.name, b.a(this.id) * 31, 31), 31) + this.serialNumber) * 31;
        boolean z = this.enable;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iM + r1;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setId(long j2) {
        this.id = j2;
    }

    public final void setName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setRule(@NotNull String str) {
        j.e(str, "<set-?>");
        this.rule = str;
    }

    public final void setSerialNumber(int i2) {
        this.serialNumber = i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("TxtTocRule(id=");
        sbR.append(this.id);
        sbR.append(", name=");
        sbR.append(this.name);
        sbR.append(", rule=");
        sbR.append(this.rule);
        sbR.append(", serialNumber=");
        sbR.append(this.serialNumber);
        sbR.append(", enable=");
        sbR.append(this.enable);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ TxtTocRule(long j2, String str, String str2, int i2, boolean z, int i3, f fVar) {
        this((i3 & 1) != 0 ? System.currentTimeMillis() : j2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? -1 : i2, (i3 & 16) != 0 ? true : z);
    }
}
