package c.e.c;

/* JADX INFO: compiled from: RGBLuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f1352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1354e;

    public m(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f1353d = i2;
        this.f1354e = i3;
        int i4 = i2 * i3;
        this.f1352c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.f1352c[i5] = (byte) (((((i6 >> 16) & 255) + ((i6 >> 7) & 510)) + (i6 & 255)) / 4);
        }
    }

    @Override // c.e.c.i
    public byte[] a() {
        int i2 = this.a;
        int i3 = this.f1345b;
        int i4 = this.f1353d;
        if (i2 == i4 && i3 == this.f1354e) {
            return this.f1352c;
        }
        int i5 = i2 * i3;
        byte[] bArr = new byte[i5];
        int i6 = (0 * i4) + 0;
        if (i2 == i4) {
            System.arraycopy(this.f1352c, i6, bArr, 0, i5);
            return bArr;
        }
        for (int i7 = 0; i7 < i3; i7++) {
            System.arraycopy(this.f1352c, i6, bArr, i7 * i2, i2);
            i6 += this.f1353d;
        }
        return bArr;
    }

    @Override // c.e.c.i
    public byte[] b(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= this.f1345b) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
        }
        int i3 = this.a;
        if (bArr == null || bArr.length < i3) {
            bArr = new byte[i3];
        }
        System.arraycopy(this.f1352c, ((i2 + 0) * this.f1353d) + 0, bArr, 0, i3);
        return bArr;
    }
}
