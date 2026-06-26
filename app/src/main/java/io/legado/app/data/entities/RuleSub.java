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

/* JADX INFO: compiled from: RuleSub.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = "ruleSubs")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004JV\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000bJ\u001a\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\"R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010&R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010&R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\u0004R\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010.R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010)\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u00101R\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010+\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010.¨\u00066"}, d2 = {"Lio/legado/app/data/entities/RuleSub;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "component5", "", "component6", "()Z", "component7", "id", "name", "url", "type", "customOrder", "autoUpdate", "update", "copy", "(JLjava/lang/String;Ljava/lang/String;IIZJ)Lio/legado/app/data/entities/RuleSub;", "toString", TTDownloadField.TT_HASHCODE, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAutoUpdate", "setAutoUpdate", "(Z)V", "Ljava/lang/String;", "getUrl", "setUrl", "(Ljava/lang/String;)V", "getName", "setName", "J", "getId", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getType", "setType", "(I)V", "getUpdate", "setUpdate", "(J)V", "getCustomOrder", "setCustomOrder", "<init>", "(JLjava/lang/String;Ljava/lang/String;IIZJ)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class RuleSub {
    private boolean autoUpdate;
    private int customOrder;

    @PrimaryKey
    private final long id;

    @NotNull
    private String name;
    private int type;
    private long update;

    @NotNull
    private String url;

    public RuleSub() {
        this(0L, null, null, 0, 0, false, 0L, 127, null);
    }

    public RuleSub(long j2, @NotNull String str, @NotNull String str2, int i2, int i3, boolean z, long j3) {
        j.e(str, "name");
        j.e(str2, "url");
        this.id = j2;
        this.name = str;
        this.url = str2;
        this.type = i2;
        this.customOrder = i3;
        this.autoUpdate = z;
        this.update = j3;
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
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCustomOrder() {
        return this.customOrder;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getUpdate() {
        return this.update;
    }

    @NotNull
    public final RuleSub copy(long id, @NotNull String name, @NotNull String url, int type, int customOrder, boolean autoUpdate, long update) {
        j.e(name, "name");
        j.e(url, "url");
        return new RuleSub(id, name, url, type, customOrder, autoUpdate, update);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleSub)) {
            return false;
        }
        RuleSub ruleSub = (RuleSub) other;
        return this.id == ruleSub.id && j.a(this.name, ruleSub.name) && j.a(this.url, ruleSub.url) && this.type == ruleSub.type && this.customOrder == ruleSub.customOrder && this.autoUpdate == ruleSub.autoUpdate && this.update == ruleSub.update;
    }

    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    public final int getCustomOrder() {
        return this.customOrder;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUpdate() {
        return this.update;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iM = (((a.m(this.url, a.m(this.name, b.a(this.id) * 31, 31), 31) + this.type) * 31) + this.customOrder) * 31;
        boolean z = this.autoUpdate;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return b.a(this.update) + ((iM + r1) * 31);
    }

    public final void setAutoUpdate(boolean z) {
        this.autoUpdate = z;
    }

    public final void setCustomOrder(int i2) {
        this.customOrder = i2;
    }

    public final void setName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final void setUpdate(long j2) {
        this.update = j2;
    }

    public final void setUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("RuleSub(id=");
        sbR.append(this.id);
        sbR.append(", name=");
        sbR.append(this.name);
        sbR.append(", url=");
        sbR.append(this.url);
        sbR.append(", type=");
        sbR.append(this.type);
        sbR.append(", customOrder=");
        sbR.append(this.customOrder);
        sbR.append(", autoUpdate=");
        sbR.append(this.autoUpdate);
        sbR.append(", update=");
        sbR.append(this.update);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ RuleSub(long j2, String str, String str2, int i2, int i3, boolean z, long j3, int i4, f fVar) {
        this((i4 & 1) != 0 ? System.currentTimeMillis() : j2, (i4 & 2) != 0 ? "" : str, (i4 & 4) == 0 ? str2 : "", (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) == 0 ? z : false, (i4 & 64) != 0 ? System.currentTimeMillis() : j3);
    }
}
