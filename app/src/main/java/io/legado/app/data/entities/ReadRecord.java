package io.legado.app.data.entities;

import androidx.room.Entity;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(primaryKeys = {"deviceId", "bookName"}, tableName = "readRecord")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u001d¨\u0006\""}, d2 = {"Lio/legado/app/data/entities/ReadRecord;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "deviceId", "bookName", "readTime", "copy", "(Ljava/lang/String;Ljava/lang/String;J)Lio/legado/app/data/entities/ReadRecord;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getReadTime", "setReadTime", "(J)V", "Ljava/lang/String;", "getDeviceId", "setDeviceId", "(Ljava/lang/String;)V", "getBookName", "setBookName", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class ReadRecord {

    @NotNull
    private String bookName;

    @NotNull
    private String deviceId;
    private long readTime;

    public ReadRecord() {
        this(null, null, 0L, 7, null);
    }

    public ReadRecord(@NotNull String str, @NotNull String str2, long j2) {
        j.e(str, "deviceId");
        j.e(str2, "bookName");
        this.deviceId = str;
        this.bookName = str2;
        this.readTime = j2;
    }

    public static /* synthetic */ ReadRecord copy$default(ReadRecord readRecord, String str, String str2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = readRecord.deviceId;
        }
        if ((i2 & 2) != 0) {
            str2 = readRecord.bookName;
        }
        if ((i2 & 4) != 0) {
            j2 = readRecord.readTime;
        }
        return readRecord.copy(str, str2, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBookName() {
        return this.bookName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getReadTime() {
        return this.readTime;
    }

    @NotNull
    public final ReadRecord copy(@NotNull String deviceId, @NotNull String bookName, long readTime) {
        j.e(deviceId, "deviceId");
        j.e(bookName, "bookName");
        return new ReadRecord(deviceId, bookName, readTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReadRecord)) {
            return false;
        }
        ReadRecord readRecord = (ReadRecord) other;
        return j.a(this.deviceId, readRecord.deviceId) && j.a(this.bookName, readRecord.bookName) && this.readTime == readRecord.readTime;
    }

    @NotNull
    public final String getBookName() {
        return this.bookName;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getReadTime() {
        return this.readTime;
    }

    public int hashCode() {
        return b.a(this.readTime) + a.m(this.bookName, this.deviceId.hashCode() * 31, 31);
    }

    public final void setBookName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookName = str;
    }

    public final void setDeviceId(@NotNull String str) {
        j.e(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setReadTime(long j2) {
        this.readTime = j2;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("ReadRecord(deviceId=");
        sbR.append(this.deviceId);
        sbR.append(", bookName=");
        sbR.append(this.bookName);
        sbR.append(", readTime=");
        sbR.append(this.readTime);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ ReadRecord(String str, String str2, long j2, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0L : j2);
    }
}
