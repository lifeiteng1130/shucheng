package io.legado.app.data.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"key"})}, tableName = "caches")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019R\"\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lio/legado/app/data/entities/Cache;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "key", ES6Iterator.VALUE_PROPERTY, "deadline", "copy", "(Ljava/lang/String;Ljava/lang/String;J)Lio/legado/app/data/entities/Cache;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "setValue", "(Ljava/lang/String;)V", "J", "getDeadline", "setDeadline", "(J)V", "getKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class Cache {
    private long deadline;

    @PrimaryKey
    @NotNull
    private final String key;

    @Nullable
    private String value;

    public Cache() {
        this(null, null, 0L, 7, null);
    }

    public Cache(@NotNull String str, @Nullable String str2, long j2) {
        j.e(str, "key");
        this.key = str;
        this.value = str2;
        this.deadline = j2;
    }

    public static /* synthetic */ Cache copy$default(Cache cache, String str, String str2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cache.key;
        }
        if ((i2 & 2) != 0) {
            str2 = cache.value;
        }
        if ((i2 & 4) != 0) {
            j2 = cache.deadline;
        }
        return cache.copy(str, str2, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDeadline() {
        return this.deadline;
    }

    @NotNull
    public final Cache copy(@NotNull String key, @Nullable String value, long deadline) {
        j.e(key, "key");
        return new Cache(key, value, deadline);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cache)) {
            return false;
        }
        Cache cache = (Cache) other;
        return j.a(this.key, cache.key) && j.a(this.value, cache.value) && this.deadline == cache.deadline;
    }

    public final long getDeadline() {
        return this.deadline;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        String str = this.value;
        return b.a(this.deadline) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final void setDeadline(long j2) {
        this.deadline = j2;
    }

    public final void setValue(@Nullable String str) {
        this.value = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("Cache(key=");
        sbR.append(this.key);
        sbR.append(", value=");
        sbR.append((Object) this.value);
        sbR.append(", deadline=");
        sbR.append(this.deadline);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ Cache(String str, String str2, long j2, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 0L : j2);
    }
}
