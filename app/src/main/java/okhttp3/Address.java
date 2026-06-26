package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.a;
import f.c0.c.j;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010F\u001a\u000209\u0012\u0006\u0010G\u001a\u000202\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\b\u0010-\u001a\u0004\u0018\u00010*\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010!\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010%\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\b#\u0010$J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b'\u0010(J\u0011\u0010-\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b+\u0010,J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00108\u001a\u00020/2\u0006\u00105\u001a\u00020\u0000H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128G@\u0006¢\u0006\f\n\u0004\b\u0016\u0010<\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010=\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010>\u001a\u0004\b\t\u0010\bR\u001b\u0010%\u001a\u0004\u0018\u00010\"8\u0007@\u0006¢\u0006\f\n\u0004\b%\u0010?\u001a\u0004\b%\u0010$R\u0019\u0010\u0005\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b\u0005\u0010@\u001a\u0004\b\u0005\u0010\u0004R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128G@\u0006¢\u0006\f\n\u0004\b\u0019\u0010<\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010A\u001a\u0004\b\r\u0010\fR\u001b\u0010-\u001a\u0004\u0018\u00010*8\u0007@\u0006¢\u0006\f\n\u0004\b-\u0010B\u001a\u0004\b-\u0010,R\u001b\u0010!\u001a\u0004\u0018\u00010\u001e8\u0007@\u0006¢\u0006\f\n\u0004\b!\u0010C\u001a\u0004\b!\u0010 R\u001b\u0010)\u001a\u0004\u0018\u00010&8\u0007@\u0006¢\u0006\f\n\u0004\b)\u0010D\u001a\u0004\b)\u0010(R\u0019\u0010\u001d\u001a\u00020\u001a8\u0007@\u0006¢\u0006\f\n\u0004\b\u001d\u0010E\u001a\u0004\b\u001d\u0010\u001c¨\u0006J"}, d2 = {"Lokhttp3/Address;", "", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Lokhttp3/Authenticator;", "-deprecated_proxyAuthenticator", "()Lokhttp3/Authenticator;", "proxyAuthenticator", "", "Lokhttp3/Protocol;", "-deprecated_protocols", "()Ljava/util/List;", "protocols", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "that", "equalsNonHost$okhttp", "(Lokhttp3/Address;)Z", "equalsNonHost", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "Lokhttp3/Authenticator;", "Lokhttp3/Dns;", "Ljavax/net/ssl/SSLSocketFactory;", "Lokhttp3/HttpUrl;", "Ljavax/net/SocketFactory;", "Lokhttp3/CertificatePinner;", "Ljava/net/Proxy;", "Ljavax/net/ssl/HostnameVerifier;", "Ljava/net/ProxySelector;", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Address {

    @Nullable
    private final CertificatePinner certificatePinner;

    @NotNull
    private final List<ConnectionSpec> connectionSpecs;

    @NotNull
    private final Dns dns;

    @Nullable
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List<Protocol> protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;

    @NotNull
    private final SocketFactory socketFactory;

    @Nullable
    private final SSLSocketFactory sslSocketFactory;

    @NotNull
    private final HttpUrl url;

    public Address(@NotNull String str, int i2, @NotNull Dns dns, @NotNull SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, @NotNull Authenticator authenticator, @Nullable Proxy proxy, @NotNull List<? extends Protocol> list, @NotNull List<ConnectionSpec> list2, @NotNull ProxySelector proxySelector) {
        j.e(str, "uriHost");
        j.e(dns, "dns");
        j.e(socketFactory, "socketFactory");
        j.e(authenticator, "proxyAuthenticator");
        j.e(list, "protocols");
        j.e(list2, "connectionSpecs");
        j.e(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i2).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}))
    @JvmName(name = "-deprecated_certificatePinner")
    @Nullable
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name and from getter */
    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}))
    @JvmName(name = "-deprecated_connectionSpecs")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m35deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}))
    @JvmName(name = "-deprecated_dns")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name and from getter */
    public final Dns getDns() {
        return this.dns;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}))
    @JvmName(name = "-deprecated_hostnameVerifier")
    @Nullable
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name and from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))
    @JvmName(name = "-deprecated_protocols")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m38deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))
    @JvmName(name = "-deprecated_proxy")
    @Nullable
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name and from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}))
    @JvmName(name = "-deprecated_proxyAuthenticator")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name and from getter */
    public final Authenticator getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}))
    @JvmName(name = "-deprecated_proxySelector")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name and from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}))
    @JvmName(name = "-deprecated_socketFactory")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name and from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}))
    @JvmName(name = "-deprecated_sslSocketFactory")
    @Nullable
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name and from getter */
    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Deprecated(level = a.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name and from getter */
    public final HttpUrl getUrl() {
        return this.url;
    }

    @JvmName(name = "certificatePinner")
    @Nullable
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @JvmName(name = "connectionSpecs")
    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName(name = "dns")
    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Address) {
            Address address = (Address) other;
            if (j.a(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(@NotNull Address that) {
        j.e(that, "that");
        return j.a(this.dns, that.dns) && j.a(this.proxyAuthenticator, that.proxyAuthenticator) && j.a(this.protocols, that.protocols) && j.a(this.connectionSpecs, that.connectionSpecs) && j.a(this.proxySelector, that.proxySelector) && j.a(this.proxy, that.proxy) && j.a(this.sslSocketFactory, that.sslSocketFactory) && j.a(this.hostnameVerifier, that.hostnameVerifier) && j.a(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((Objects.hashCode(this.proxy) + ((this.proxySelector.hashCode() + ((this.connectionSpecs.hashCode() + ((this.protocols.hashCode() + ((this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + ((this.url.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @JvmName(name = "hostnameVerifier")
    @Nullable
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName(name = "protocols")
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName(name = "proxy")
    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName(name = "proxyAuthenticator")
    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName(name = "proxySelector")
    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName(name = "socketFactory")
    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName(name = "sslSocketFactory")
    @Nullable
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR;
        Object obj;
        StringBuilder sbR2 = c.a.a.a.a.r("Address{");
        sbR2.append(this.url.host());
        sbR2.append(':');
        sbR2.append(this.url.port());
        sbR2.append(", ");
        if (this.proxy != null) {
            sbR = c.a.a.a.a.r("proxy=");
            obj = this.proxy;
        } else {
            sbR = c.a.a.a.a.r("proxySelector=");
            obj = this.proxySelector;
        }
        sbR.append(obj);
        sbR2.append(sbR.toString());
        sbR2.append("}");
        return sbR2.toString();
    }

    @JvmName(name = "url")
    @NotNull
    public final HttpUrl url() {
        return this.url;
    }
}
