package k.a.a.a.k0;

import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ArrayPredictionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends z0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z0[] f8445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f8446e;

    /* JADX WARN: Illegal instructions before constructor call */
    public n(z0[] z0VarArr, int[] iArr) {
        int iX5 = 1;
        for (z0 z0Var : z0VarArr) {
            iX5 = c.b.a.m.f.Y5(iX5, z0Var);
        }
        for (int i2 : iArr) {
            iX5 = c.b.a.m.f.X5(iX5, i2);
        }
        super(c.b.a.m.f.I1(iX5, z0VarArr.length * 2));
        this.f8445d = z0VarArr;
        this.f8446e = iArr;
    }

    @Override // k.a.a.a.k0.z0
    public z0 c(int i2) {
        return this.f8445d[i2];
    }

    @Override // k.a.a.a.k0.z0
    public int d(int i2) {
        return this.f8446e[i2];
    }

    @Override // k.a.a.a.k0.z0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n) || this.f8481c != obj.hashCode()) {
            return false;
        }
        n nVar = (n) obj;
        return Arrays.equals(this.f8446e, nVar.f8446e) && Arrays.equals(this.f8445d, nVar.f8445d);
    }

    @Override // k.a.a.a.k0.z0
    public boolean f() {
        return this.f8446e[0] == Integer.MAX_VALUE;
    }

    @Override // k.a.a.a.k0.z0
    public int h() {
        return this.f8446e.length;
    }

    public String toString() {
        if (f()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sbR = c.a.a.a.a.r("[");
        for (int i2 = 0; i2 < this.f8446e.length; i2++) {
            if (i2 > 0) {
                sbR.append(", ");
            }
            int[] iArr = this.f8446e;
            if (iArr[i2] == Integer.MAX_VALUE) {
                sbR.append("$");
            } else {
                sbR.append(iArr[i2]);
                if (this.f8445d[i2] != null) {
                    sbR.append(' ');
                    sbR.append(this.f8445d[i2].toString());
                } else {
                    sbR.append("null");
                }
            }
        }
        sbR.append("]");
        return sbR.toString();
    }
}
