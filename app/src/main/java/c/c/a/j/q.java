package c.c.a.j;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class q extends s {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f774b;

    public q(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f774b = -1;
        this.a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((q) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // c.c.a.j.s, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.f774b == -1) {
            try {
                this.f774b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f774b = 0;
            }
        }
        return this.f774b;
    }
}
