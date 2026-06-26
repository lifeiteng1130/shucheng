package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8818b;

    public c() {
        this.a = new byte[64];
    }

    public c(int i2) {
        this.a = new byte[i2];
    }

    public c a(int i2, int i3) {
        int i4 = this.f8818b;
        if (i4 + 2 > this.a.length) {
            b(2);
        }
        byte[] bArr = this.a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i2;
        bArr[i5] = (byte) i3;
        this.f8818b = i5 + 1;
        return this;
    }

    public final void b(int i2) {
        byte[] bArr = this.a;
        int length = bArr.length * 2;
        int i3 = this.f8818b;
        int i4 = i2 + i3;
        if (length <= i4) {
            length = i4;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        this.a = bArr2;
    }

    public c c(int i2, int i3) {
        int i4 = this.f8818b;
        if (i4 + 3 > this.a.length) {
            b(3);
        }
        byte[] bArr = this.a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i2;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >>> 8);
        bArr[i6] = (byte) i3;
        this.f8818b = i6 + 1;
        return this;
    }

    public c d(String str, int i2, int i3) {
        int i4;
        int length = str.length();
        int i5 = i2;
        int i6 = i5;
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            i6 = (cCharAt < 1 || cCharAt > 127) ? cCharAt > 2047 ? i6 + 3 : i6 + 2 : i6 + 1;
            i5++;
        }
        if (i6 > i3) {
            throw new IllegalArgumentException();
        }
        int i7 = this.f8818b;
        int i8 = (i7 - i2) - 2;
        if (i8 >= 0) {
            byte[] bArr = this.a;
            bArr[i8] = (byte) (i6 >>> 8);
            bArr[i8 + 1] = (byte) i6;
        }
        if ((i7 + i6) - i2 > this.a.length) {
            b(i6 - i2);
        }
        int i9 = this.f8818b;
        while (i2 < length) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 1 || cCharAt2 > 127) {
                byte[] bArr2 = this.a;
                int i10 = i9 + 1;
                if (cCharAt2 > 2047) {
                    bArr2[i9] = (byte) (((cCharAt2 >> '\f') & 15) | 224);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                    i4 = i11 + 1;
                    bArr2[i11] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    bArr2[i9] = (byte) (((cCharAt2 >> 6) & 31) | 192);
                    i9 = i10 + 1;
                    bArr2[i10] = (byte) ((cCharAt2 & '?') | 128);
                    i2++;
                }
            } else {
                i4 = i9 + 1;
                this.a[i9] = (byte) cCharAt2;
            }
            i9 = i4;
            i2++;
        }
        this.f8818b = i9;
        return this;
    }

    public c e(int i2) {
        int i3 = this.f8818b;
        int i4 = i3 + 1;
        if (i4 > this.a.length) {
            b(1);
        }
        this.a[i3] = (byte) i2;
        this.f8818b = i4;
        return this;
    }

    public c f(byte[] bArr, int i2, int i3) {
        if (this.f8818b + i3 > this.a.length) {
            b(i3);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i2, this.a, this.f8818b, i3);
        }
        this.f8818b += i3;
        return this;
    }

    public c g(int i2) {
        int i3 = this.f8818b;
        if (i3 + 4 > this.a.length) {
            b(4);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 24);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i2 >>> 8);
        bArr[i6] = (byte) i2;
        this.f8818b = i6 + 1;
        return this;
    }

    public c h(long j2) {
        int i2 = this.f8818b;
        if (i2 + 8 > this.a.length) {
            b(8);
        }
        byte[] bArr = this.a;
        int i3 = (int) (j2 >>> 32);
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >>> 24);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >>> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >>> 8);
        int i7 = i6 + 1;
        bArr[i6] = (byte) i3;
        int i8 = (int) j2;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >>> 24);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >>> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >>> 8);
        bArr[i11] = (byte) i8;
        this.f8818b = i11 + 1;
        return this;
    }

    public c i(int i2) {
        int i3 = this.f8818b;
        if (i3 + 2 > this.a.length) {
            b(2);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 8);
        bArr[i4] = (byte) i2;
        this.f8818b = i4 + 1;
        return this;
    }
}
