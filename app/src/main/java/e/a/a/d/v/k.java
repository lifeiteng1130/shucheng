package e.a.a.d.v;

import android.annotation.SuppressLint;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SSLHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    @NotNull
    public static final k a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final X509TrustManager f5585b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5586c = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final HostnameVerifier f5587d = new HostnameVerifier() { // from class: e.a.a.d.v.d
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            k kVar = k.a;
            return true;
        }
    };

    /* JADX INFO: compiled from: SSLHelper.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<SSLSocketFactory> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        public final SSLSocketFactory invoke() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                k kVar = k.a;
                sSLContext.init(null, new X509TrustManager[]{k.f5585b}, new SecureRandom());
                return sSLContext.getSocketFactory();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SSLHelper.kt */
    public static final class b implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(@NotNull X509Certificate[] x509CertificateArr, @NotNull String str) {
            f.c0.c.j.e(x509CertificateArr, "chain");
            f.c0.c.j.e(str, "authType");
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(@NotNull X509Certificate[] x509CertificateArr, @NotNull String str) {
            f.c0.c.j.e(x509CertificateArr, "chain");
            f.c0.c.j.e(str, "authType");
        }

        @Override // javax.net.ssl.X509TrustManager
        @NotNull
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    @NotNull
    public static final SSLSocketFactory a() {
        Object value = f5586c.getValue();
        f.c0.c.j.d(value, "<get-unsafeSSLSocketFactory>(...)");
        return (SSLSocketFactory) value;
    }
}
