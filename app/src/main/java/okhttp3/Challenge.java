package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.a;
import f.c0.c.j;
import f.x.e;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u001c\u0010\u001dB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001eJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bR'\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\n8G@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\r\u0010\fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00068G@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0013\u0010\u0003\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\t\u0010\b¨\u0006\u001f"}, d2 = {"Lokhttp3/Challenge;", "", "Ljava/nio/charset/Charset;", "charset", "withCharset", "(Ljava/nio/charset/Charset;)Lokhttp3/Challenge;", "", "-deprecated_scheme", "()Ljava/lang/String;", "scheme", "", "-deprecated_authParams", "()Ljava/util/Map;", "authParams", "-deprecated_realm", "realm", "-deprecated_charset", "()Ljava/nio/charset/Charset;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/util/Map;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Challenge {

    @NotNull
    private final Map<String, String> authParams;

    @NotNull
    private final String scheme;

    public Challenge(@NotNull String str, @NotNull Map<String, String> map) {
        String lowerCase;
        j.e(str, "scheme");
        j.e(map, "authParams");
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                j.d(locale, "US");
                lowerCase = key.toLowerCase(locale);
                j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        j.d(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = mapUnmodifiableMap;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}))
    @JvmName(name = "-deprecated_authParams")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m56deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "charset", imports = {}))
    @JvmName(name = "-deprecated_charset")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m57deprecated_charset() {
        return charset();
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}))
    @JvmName(name = "-deprecated_realm")
    @Nullable
    /* JADX INFO: renamed from: -deprecated_realm, reason: not valid java name */
    public final String m58deprecated_realm() {
        return realm();
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name and from getter */
    public final String getScheme() {
        return this.scheme;
    }

    @JvmName(name = "authParams")
    @NotNull
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName(name = "charset")
    @NotNull
    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                j.d(charsetForName, "Charset.forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        j.d(charset, "ISO_8859_1");
        return charset;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Challenge) {
            Challenge challenge = (Challenge) other;
            if (j.a(challenge.scheme, this.scheme) && j.a(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.authParams.hashCode() + c.a.a.a.a.m(this.scheme, 899, 31);
    }

    @JvmName(name = "realm")
    @Nullable
    public final String realm() {
        return this.authParams.get("realm");
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset charset) {
        j.e(charset, "charset");
        Map mapJ = e.J(this.authParams);
        String strName = charset.name();
        j.d(strName, "charset.name()");
        mapJ.put("charset", strName);
        return new Challenge(this.scheme, (Map<String, String>) mapJ);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Challenge(@NotNull String str, @NotNull String str2) {
        j.e(str, "scheme");
        j.e(str2, "realm");
        Map mapSingletonMap = Collections.singletonMap("realm", str2);
        j.d(mapSingletonMap, "singletonMap(\"realm\", realm)");
        this(str, (Map<String, String>) mapSingletonMap);
    }
}
