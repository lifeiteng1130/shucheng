package c.g.a.o;

import androidx.annotation.Nullable;
import c.e.c.e;
import c.e.c.i;
import c.e.c.j;
import c.e.c.p;
import c.e.c.v.h;
import c.g.a.l;
import c.g.a.m;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: MultiFormatAnalyzer.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1591c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1592d = 0.8f;
    public l a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<e, ?> f1590b = m.f1578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f1593e = new j();

    @Override // c.g.a.o.b
    public p a(byte[] bArr, int i2, int i3) {
        String str = String.format("width:%d, height:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        c.g.a.p.a.a();
        String.valueOf(str);
        l lVar = this.a;
        int iMin = (int) (Math.min(i2, i3) * this.f1592d);
        return b(bArr, i2, i3, ((i2 - iMin) / 2) + 0, ((i3 - iMin) / 2) + 0, iMin, iMin);
    }

    @Nullable
    public p b(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        l lVar;
        p pVarC = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f1593e.d(this.f1590b);
            pVarC = c(new c.e.c.l(bArr, i2, i3, i4, i5, i6, i7, false), this.f1591c);
            if (pVarC == null && (lVar = this.a) != null) {
                if (pVarC == null) {
                    Objects.requireNonNull(lVar);
                }
                if (pVarC == null) {
                    Objects.requireNonNull(this.a);
                }
            }
            if (pVarC != null) {
                String str = "Found barcode in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms";
                c.g.a.p.a.a();
                String.valueOf(str);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f1593e.b();
            throw th;
        }
        this.f1593e.b();
        return pVarC;
    }

    public final p c(i iVar, boolean z) {
        p pVarC;
        try {
            j jVar = this.f1593e;
            c.e.c.c cVar = new c.e.c.c(new c.e.c.v.i(iVar));
            if (jVar.f1346b == null) {
                jVar.d(null);
            }
            pVarC = jVar.c(cVar);
        } catch (Exception unused) {
            pVarC = null;
        }
        if (!z || pVarC != null) {
            return pVarC;
        }
        try {
            j jVar2 = this.f1593e;
            c.e.c.c cVar2 = new c.e.c.c(new h(iVar));
            if (jVar2.f1346b == null) {
                jVar2.d(null);
            }
            return jVar2.c(cVar2);
        } catch (Exception unused2) {
            return pVarC;
        }
    }
}
