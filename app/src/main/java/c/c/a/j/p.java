package c.c.a.j;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    @Nullable
    public final Signature[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ArraySet<PublicKey> f771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Signature[] f772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final int[] f773e;

    public p(Signature[] signatureArr, int i2, Signature[] signatureArr2, int[] iArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method methodC = c.c.a.a.a.a.c(Signature.class, "getPublicKey", new Class[0]);
            if (methodC != null && methodC.isAccessible()) {
                try {
                    arraySet.add((PublicKey) methodC.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        this.a = signatureArr;
        this.f770b = i2;
        this.f771c = arraySet;
        this.f772d = signatureArr2;
        this.f773e = iArr;
    }

    public static Signature a(CertificateFactory certificateFactory, Signature signature) throws CertificateException {
        Signature signature2 = new Signature(((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getEncoded());
        int length = signature2.toByteArray().length;
        int length2 = signature.toByteArray().length;
        if (Math.abs(length - length2) <= 2) {
            return signature2;
        }
        throw new CertificateException("Bounced cert length looks fishy; before " + length2 + ", after " + length);
    }

    public static boolean b(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && c.b.a.m.f.M(signatureArr, signatureArr2) && c.b.a.m.f.M(signatureArr2, signatureArr);
    }

    public static boolean c(Signature[] signatureArr, Signature[] signatureArr2) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Signature[] signatureArr3 = new Signature[signatureArr.length];
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            signatureArr3[i2] = a(certificateFactory, signatureArr[i2]);
        }
        Signature[] signatureArr4 = new Signature[signatureArr2.length];
        for (int i3 = 0; i3 < signatureArr2.length; i3++) {
            signatureArr4[i3] = a(certificateFactory, signatureArr2[i3]);
        }
        return b(signatureArr3, signatureArr4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f770b != pVar.f770b || !b(this.a, pVar.a)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f771c;
        if (arraySet != null) {
            if (!arraySet.equals(pVar.f771c)) {
                return false;
            }
        } else if (pVar.f771c != null) {
            return false;
        }
        return Arrays.equals(this.f772d, pVar.f772d) && Arrays.equals(this.f773e, pVar.f773e);
    }

    public final int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.a) * 31) + this.f770b) * 31;
        ArraySet<PublicKey> arraySet = this.f771c;
        return Arrays.hashCode(this.f773e) + ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f772d)) * 31);
    }

    public p(Signature[] signatureArr, int i2, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.a = signatureArr;
        this.f770b = i2;
        this.f771c = null;
        this.f772d = null;
        this.f773e = null;
    }
}
