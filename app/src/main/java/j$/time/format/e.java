package j$.time.format;

import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.n;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class e {
    private k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f7863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7864c;

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    e(j$.time.temporal.k r10, j$.time.format.b r11) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.e.<init>(j$.time.temporal.k, j$.time.format.b):void");
    }

    void a() {
        this.f7864c--;
    }

    g b() {
        return this.f7863b.c();
    }

    Locale c() {
        return this.f7863b.d();
    }

    k d() {
        return this.a;
    }

    Long e(l lVar) {
        try {
            return Long.valueOf(this.a.l(lVar));
        } catch (j$.time.c e2) {
            if (this.f7864c > 0) {
                return null;
            }
            throw e2;
        }
    }

    Object f(n nVar) {
        Object objN = this.a.n(nVar);
        if (objN != null || this.f7864c != 0) {
            return objN;
        }
        StringBuilder sbA = j$.com.android.tools.r8.a.a("Unable to extract value: ");
        sbA.append(this.a.getClass());
        throw new j$.time.c(sbA.toString());
    }

    void g() {
        this.f7864c++;
    }

    public String toString() {
        return this.a.toString();
    }
}
