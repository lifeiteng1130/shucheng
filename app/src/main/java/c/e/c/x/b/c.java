package c.e.c.x.b;

import androidx.exifinterface.media.ExifInterface;
import c.e.c.d;
import c.e.c.v.m.e;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final c.e.c.v.m.c a = new c.e.c.v.m.c(c.e.c.v.m.a.f1416h);

    public final void a(byte[] bArr, int i2, int i3, int i4, int i5) throws d {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & ExifInterface.MARKER;
            }
        }
        try {
            this.a.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (e unused) {
            throw d.getChecksumInstance();
        }
    }
}
