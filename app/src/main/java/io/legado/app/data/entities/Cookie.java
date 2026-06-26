package io.legado.app.data.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"url"})}, tableName = "cookies")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lio/legado/app/data/entities/Cookie;", "", "", "component1", "()Ljava/lang/String;", "component2", "url", "cookie", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/Cookie;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCookie", "setCookie", "(Ljava/lang/String;)V", "getUrl", "setUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class Cookie {

    @NotNull
    private String cookie;

    @PrimaryKey
    @NotNull
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public Cookie() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Cookie(@NotNull String str, @NotNull String str2) {
        j.e(str, "url");
        j.e(str2, "cookie");
        this.url = str;
        this.cookie = str2;
    }

    public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cookie.url;
        }
        if ((i2 & 2) != 0) {
            str2 = cookie.cookie;
        }
        return cookie.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    @NotNull
    public final Cookie copy(@NotNull String url, @NotNull String cookie) {
        j.e(url, "url");
        j.e(cookie, "cookie");
        return new Cookie(url, cookie);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) other;
        return j.a(this.url, cookie.url) && j.a(this.cookie, cookie.cookie);
    }

    @NotNull
    public final String getCookie() {
        return this.cookie;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.cookie.hashCode() + (this.url.hashCode() * 31);
    }

    public final void setCookie(@NotNull String str) {
        j.e(str, "<set-?>");
        this.cookie = str;
    }

    public final void setUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("Cookie(url=");
        sbR.append(this.url);
        sbR.append(", cookie=");
        sbR.append(this.cookie);
        sbR.append(')');
        return sbR.toString();
    }

    public /* synthetic */ Cookie(String str, String str2, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }
}
