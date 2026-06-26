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

/* JADX INFO: compiled from: HttpTTS.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = "httpTTS")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lio/legado/app/data/entities/HttpTTS;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "id", "name", "url", "copy", "(JLjava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/HttpTTS;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "setUrl", "(Ljava/lang/String;)V", "J", "getId", "getName", "setName", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class HttpTTS {

    @PrimaryKey
    private final long id;

    @NotNull
    private String name;

    @NotNull
    private String url;

    public HttpTTS() {
        this(0L, null, null, 7, null);
    }

    public HttpTTS(long j2, @NotNull String str, @NotNull String str2) {
        j.e(str, "name");
        j.e(str2, "url");
        this.id = j2;
        this.name = str;
        this.url = str2;
    }

    public static /* synthetic */ HttpTTS copy$default(HttpTTS httpTTS, long j2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = httpTTS.id;
        }
        if ((i2 & 2) != 0) {
            str = httpTTS.name;
        }
        if ((i2 & 4) != 0) {
            str2 = httpTTS.url;
        }
        return httpTTS.copy(j2, str, str2);
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

    @NotNull
    public final HttpTTS copy(long id, @NotNull String name, @NotNull String url) {
        j.e(name, "name");
        j.e(url, "url");
        return new HttpTTS(id, name, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpTTS)) {
            return false;
        }
        HttpTTS httpTTS = (HttpTTS) other;
        return this.id == httpTTS.id && j.a(this.name, httpTTS.name) && j.a(this.url, httpTTS.url);
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode() + a.m(this.name, b.a(this.id) * 31, 31);
    }

    public final void setName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("HttpTTS(id=");
        sbR.append(this.id);
        sbR.append(", name=");
        sbR.append(this.name);
        sbR.append(", url=");
        sbR.append(this.url);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ HttpTTS(long j2, String str, String str2, int i2, f fVar) {
        this((i2 & 1) != 0 ? System.currentTimeMillis() : j2, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }
}
