package io.legado.app.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssReadRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = "rssReadRecords")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lio/legado/app/data/entities/RssReadRecord;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "record", "read", "copy", "(Ljava/lang/String;Z)Lio/legado/app/data/entities/RssReadRecord;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRecord", "Z", "getRead", "<init>", "(Ljava/lang/String;Z)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class RssReadRecord {
    private final boolean read;

    @PrimaryKey
    @NotNull
    private final String record;

    public RssReadRecord(@NotNull String str, boolean z) {
        j.e(str, "record");
        this.record = str;
        this.read = z;
    }

    public static /* synthetic */ RssReadRecord copy$default(RssReadRecord rssReadRecord, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rssReadRecord.record;
        }
        if ((i2 & 2) != 0) {
            z = rssReadRecord.read;
        }
        return rssReadRecord.copy(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRecord() {
        return this.record;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRead() {
        return this.read;
    }

    @NotNull
    public final RssReadRecord copy(@NotNull String record, boolean read) {
        j.e(record, "record");
        return new RssReadRecord(record, read);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssReadRecord)) {
            return false;
        }
        RssReadRecord rssReadRecord = (RssReadRecord) other;
        return j.a(this.record, rssReadRecord.record) && this.read == rssReadRecord.read;
    }

    public final boolean getRead() {
        return this.read;
    }

    @NotNull
    public final String getRecord() {
        return this.record;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.record.hashCode() * 31;
        boolean z = this.read;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("RssReadRecord(record=");
        sbR.append(this.record);
        sbR.append(", read=");
        sbR.append(this.read);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ RssReadRecord(String str, boolean z, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? true : z);
    }
}
