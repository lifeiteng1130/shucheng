package c.e.c.v;

import java.util.Arrays;

/* JADX INFO: compiled from: BitMatrix.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Cloneable {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f1378d;

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = i2;
        this.f1376b = i3;
        int i4 = (i2 + 31) / 32;
        this.f1377c = i4;
        this.f1378d = new int[i4 * i3];
    }

    public void a(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.f1377c);
        int[] iArr = this.f1378d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean b(int i2, int i3) {
        return ((this.f1378d[(i2 / 32) + (i3 * this.f1377c)] >>> (i2 & 31)) & 1) != 0;
    }

    public int[] c() {
        int length = this.f1378d.length - 1;
        while (length >= 0 && this.f1378d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f1377c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f1378d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public Object clone() {
        return new b(this.a, this.f1376b, this.f1377c, (int[]) this.f1378d.clone());
    }

    public a d(int i2, a aVar) {
        int i3 = aVar.f1375b;
        int i4 = this.a;
        if (i3 < i4) {
            aVar = new a(i4);
        } else {
            int length = aVar.a.length;
            for (int i5 = 0; i5 < length; i5++) {
                aVar.a[i5] = 0;
            }
        }
        int i6 = i2 * this.f1377c;
        for (int i7 = 0; i7 < this.f1377c; i7++) {
            aVar.a[(i7 << 5) / 32] = this.f1378d[i6 + i7];
        }
        return aVar;
    }

    public int[] e() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.f1378d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.f1377c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f1376b == bVar.f1376b && this.f1377c == bVar.f1377c && Arrays.equals(this.f1378d, bVar.f1378d);
    }

    public void f(int i2, int i3) {
        int i4 = (i2 / 32) + (i3 * this.f1377c);
        int[] iArr = this.f1378d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void g(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i7 > this.f1376b || i6 > this.a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i3 < i7) {
            int i8 = this.f1377c * i3;
            for (int i9 = i2; i9 < i6; i9++) {
                int[] iArr = this.f1378d;
                int i10 = (i9 / 32) + i8;
                iArr[i10] = iArr[i10] | (1 << (i9 & 31));
            }
            i3++;
        }
    }

    public int hashCode() {
        int i2 = this.a;
        return Arrays.hashCode(this.f1378d) + (((((((i2 * 31) + i2) * 31) + this.f1376b) * 31) + this.f1377c) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.a + 1) * this.f1376b);
        for (int i2 = 0; i2 < this.f1376b; i2++) {
            for (int i3 = 0; i3 < this.a; i3++) {
                sb.append(b(i3, i2) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public b(int i2, int i3, int i4, int[] iArr) {
        this.a = i2;
        this.f1376b = i3;
        this.f1377c = i4;
        this.f1378d = iArr;
    }
}
