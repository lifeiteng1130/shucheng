package c.e.c.z.d.k;

/* JADX INFO: compiled from: ModulusPoly.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1551b;

    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f1551b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f1551b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i2];
        this.f1551b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    public c a(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return cVar;
        }
        if (cVar.e()) {
            return this;
        }
        int[] iArr = this.f1551b;
        int[] iArr2 = cVar.f1551b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = this.a.a(iArr2[i2 - length], iArr[i2]);
        }
        return new c(this.a, iArr3);
    }

    public int b(int i2) {
        if (i2 == 0) {
            return c(0);
        }
        if (i2 == 1) {
            int iA = 0;
            for (int i3 : this.f1551b) {
                iA = this.a.a(iA, i3);
            }
            return iA;
        }
        int[] iArr = this.f1551b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            b bVar = this.a;
            iA2 = bVar.a(bVar.d(i2, iA2), this.f1551b[i4]);
        }
        return iA2;
    }

    public int c(int i2) {
        return this.f1551b[(r0.length - 1) - i2];
    }

    public int d() {
        return this.f1551b.length - 1;
    }

    public boolean e() {
        return this.f1551b[0] == 0;
    }

    public c f(int i2) {
        if (i2 == 0) {
            return this.a.f1549d;
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f1551b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.d(this.f1551b[i3], i2);
        }
        return new c(this.a, iArr);
    }

    public c g(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || cVar.e()) {
            return this.a.f1549d;
        }
        int[] iArr = this.f1551b;
        int length = iArr.length;
        int[] iArr2 = cVar.f1551b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                b bVar = this.a;
                iArr3[i5] = bVar.a(iArr3[i5], bVar.d(i3, iArr2[i4]));
            }
        }
        return new c(this.a, iArr3);
    }

    public c h() {
        int length = this.f1551b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.e(0, this.f1551b[i2]);
        }
        return new c(this.a, iArr);
    }

    public c i(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.e() ? this : a(cVar.h());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
