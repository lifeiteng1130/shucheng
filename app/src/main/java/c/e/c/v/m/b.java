package c.e.c.v.m;

import java.util.Objects;

/* JADX INFO: compiled from: GenericGFPoly.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1421b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f1421b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f1421b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i2];
        this.f1421b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    public b a(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e()) {
            return bVar;
        }
        if (bVar.e()) {
            return this;
        }
        int[] iArr = this.f1421b;
        int[] iArr2 = bVar.f1421b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = iArr2[i2 - length] ^ iArr[i2];
        }
        return new b(this.a, iArr3);
    }

    public int b(int i2) {
        if (i2 == 0) {
            return c(0);
        }
        if (i2 != 1) {
            int[] iArr = this.f1421b;
            int iC = iArr[0];
            int length = iArr.length;
            for (int i3 = 1; i3 < length; i3++) {
                iC = this.a.c(i2, iC) ^ this.f1421b[i3];
            }
            return iC;
        }
        int i4 = 0;
        for (int i5 : this.f1421b) {
            a aVar = a.a;
            i4 ^= i5;
        }
        return i4;
    }

    public int c(int i2) {
        return this.f1421b[(r0.length - 1) - i2];
    }

    public int d() {
        return this.f1421b.length - 1;
    }

    public boolean e() {
        return this.f1421b[0] == 0;
    }

    public b f(int i2) {
        if (i2 == 0) {
            return this.a.f1419k;
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f1421b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.c(this.f1421b[i3], i2);
        }
        return new b(this.a, iArr);
    }

    public b g(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e() || bVar.e()) {
            return this.a.f1419k;
        }
        int[] iArr = this.f1421b;
        int length = iArr.length;
        int[] iArr2 = bVar.f1421b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = iArr3[i5] ^ this.a.c(i3, iArr2[i4]);
            }
        }
        return new b(this.a, iArr3);
    }

    public b h(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.a.f1419k;
        }
        int length = this.f1421b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.a.c(this.f1421b[i4], i3);
        }
        return new b(this.a, iArr);
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
                    a aVar = this.a;
                    Objects.requireNonNull(aVar);
                    if (iC == 0) {
                        throw new IllegalArgumentException();
                    }
                    int i2 = aVar.f1418j[iC];
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
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
