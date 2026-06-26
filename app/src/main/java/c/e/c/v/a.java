package c.e.c.v;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: BitArray.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Cloneable {
    public int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1375b;

    public a() {
        this.f1375b = 0;
        this.a = new int[1];
    }

    public void a(boolean z) {
        d(this.f1375b + 1);
        if (z) {
            int[] iArr = this.a;
            int i2 = this.f1375b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f1375b++;
    }

    public void b(a aVar) {
        int i2 = aVar.f1375b;
        d(this.f1375b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.e(i3));
        }
    }

    public void c(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        d(this.f1375b + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i3--;
        }
    }

    public Object clone() {
        return new a((int[]) this.a.clone(), this.f1375b);
    }

    public final void d(int i2) {
        int[] iArr = this.a;
        if (i2 > (iArr.length << 5)) {
            int[] iArr2 = new int[(i2 + 31) / 32];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.a = iArr2;
        }
    }

    public boolean e(int i2) {
        return ((1 << (i2 & 31)) & this.a[i2 / 32]) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1375b == aVar.f1375b && Arrays.equals(this.a, aVar.a);
    }

    public int f(int i2) {
        int i3 = this.f1375b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.a;
            if (i4 == iArr.length) {
                return this.f1375b;
            }
            i5 = iArr[i4];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5) + (i4 << 5);
        int i6 = this.f1375b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int g(int i2) {
        int i3 = this.f1375b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.a;
            if (i4 == iArr.length) {
                return this.f1375b;
            }
            i5 = ~iArr[i4];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5) + (i4 << 5);
        int i6 = this.f1375b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int h() {
        return (this.f1375b + 7) / 8;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a) + (this.f1375b * 31);
    }

    public boolean i(int i2, int i3, boolean z) {
        if (i3 < i2 || i2 < 0 || i3 > this.f1375b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.a[i7] & i8;
            if (!z) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void j() {
        int[] iArr = new int[this.a.length];
        int i2 = (this.f1375b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i5 = this.f1375b;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.a = iArr;
    }

    public void k(int i2) {
        int[] iArr = this.a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public String toString() {
        int i2 = this.f1375b;
        StringBuilder sb = new StringBuilder((i2 / 8) + i2 + 1);
        for (int i3 = 0; i3 < this.f1375b; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(e(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    public a(int i2) {
        this.f1375b = i2;
        this.a = new int[(i2 + 31) / 32];
    }

    public a(int[] iArr, int i2) {
        this.a = iArr;
        this.f1375b = i2;
    }
}
