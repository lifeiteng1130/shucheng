package c.e.c;

/* JADX INFO: compiled from: PlanarYUVLuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f1347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1351g;

    public l(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f1347c = bArr;
        this.f1348d = i2;
        this.f1349e = i3;
        this.f1350f = i4;
        this.f1351g = i5;
        if (z) {
            int i8 = (i5 * i2) + i4;
            int i9 = 0;
            while (i9 < i7) {
                int i10 = (i6 / 2) + i8;
                int i11 = (i8 + i6) - 1;
                int i12 = i8;
                while (i12 < i10) {
                    byte b2 = bArr[i12];
                    bArr[i12] = bArr[i11];
                    bArr[i11] = b2;
                    i12++;
                    i11--;
                }
                i9++;
                i8 += this.f1348d;
            }
        }
    }

    @Override // c.e.c.i
    public byte[] a() {
        int i2 = this.a;
        int i3 = this.f1345b;
        int i4 = this.f1348d;
        if (i2 == i4 && i3 == this.f1349e) {
            return this.f1347c;
        }
        int i5 = i2 * i3;
        byte[] bArr = new byte[i5];
        int i6 = (this.f1351g * i4) + this.f1350f;
        if (i2 == i4) {
            System.arraycopy(this.f1347c, i6, bArr, 0, i5);
            return bArr;
        }
        for (int i7 = 0; i7 < i3; i7++) {
            System.arraycopy(this.f1347c, i6, bArr, i7 * i2, i2);
            i6 += this.f1348d;
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
        System.arraycopy(this.f1347c, ((i2 + this.f1351g) * this.f1348d) + this.f1350f, bArr, 0, i3);
        return bArr;
    }
}
