package c.e.c.v;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: GlobalHistogramBinarizer.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends c.e.c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1391b = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f1393d;

    public h(c.e.c.i iVar) {
        super(iVar);
        this.f1392c = f1391b;
        this.f1393d = new int[32];
    }

    public static int d(int[] iArr) throws c.e.c.k {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 <= i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i4 - i6 <= length / 16) {
            throw c.e.c.k.getNotFoundInstance();
        }
        int i12 = i4 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = (i3 - iArr[i12]) * (i4 - i12) * i15 * i15;
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }

    @Override // c.e.c.b
    public c.e.c.b a(c.e.c.i iVar) {
        return new h(iVar);
    }

    @Override // c.e.c.b
    public b b() throws c.e.c.k {
        c.e.c.i iVar = this.a;
        int i2 = iVar.a;
        int i3 = iVar.f1345b;
        b bVar = new b(i2, i3);
        e(i2);
        int[] iArr = this.f1393d;
        for (int i4 = 1; i4 < 5; i4++) {
            byte[] bArrB = iVar.b((i3 * i4) / 5, this.f1392c);
            int i5 = (i2 << 2) / 5;
            for (int i6 = i2 / 5; i6 < i5; i6++) {
                int i7 = (bArrB[i6] & ExifInterface.MARKER) >> 3;
                iArr[i7] = iArr[i7] + 1;
            }
        }
        int iD = d(iArr);
        byte[] bArrA = iVar.a();
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 * i2;
            for (int i10 = 0; i10 < i2; i10++) {
                if ((bArrA[i9 + i10] & ExifInterface.MARKER) < iD) {
                    bVar.f(i10, i8);
                }
            }
        }
        return bVar;
    }

    @Override // c.e.c.b
    public a c(int i2, a aVar) throws c.e.c.k {
        int i3;
        c.e.c.i iVar = this.a;
        int i4 = iVar.a;
        if (aVar == null || aVar.f1375b < i4) {
            aVar = new a(i4);
        } else {
            int length = aVar.a.length;
            for (int i5 = 0; i5 < length; i5++) {
                aVar.a[i5] = 0;
            }
        }
        e(i4);
        byte[] bArrB = iVar.b(i2, this.f1392c);
        int[] iArr = this.f1393d;
        int i6 = 0;
        while (true) {
            i3 = 1;
            if (i6 >= i4) {
                break;
            }
            int i7 = (bArrB[i6] & ExifInterface.MARKER) >> 3;
            iArr[i7] = iArr[i7] + 1;
            i6++;
        }
        int iD = d(iArr);
        if (i4 < 3) {
            for (int i8 = 0; i8 < i4; i8++) {
                if ((bArrB[i8] & ExifInterface.MARKER) < iD) {
                    aVar.k(i8);
                }
            }
        } else {
            int i9 = bArrB[0] & ExifInterface.MARKER;
            int i10 = bArrB[1] & ExifInterface.MARKER;
            while (i3 < i4 - 1) {
                int i11 = i3 + 1;
                int i12 = bArrB[i11] & ExifInterface.MARKER;
                if ((((i10 << 2) - i9) - i12) / 2 < iD) {
                    aVar.k(i3);
                }
                i9 = i10;
                i3 = i11;
                i10 = i12;
            }
        }
        return aVar;
    }

    public final void e(int i2) {
        if (this.f1392c.length < i2) {
            this.f1392c = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f1393d[i3] = 0;
        }
    }
}
