package c.e.c.z.d;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: PDF417CodewordDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final float[][] a = (float[][]) Array.newInstance((Class<?>) float.class, c.e.c.z.a.f1522b.length, 8);

    static {
        int i2;
        int i3 = 0;
        while (true) {
            int[] iArr = c.e.c.z.a.f1522b;
            if (i3 >= iArr.length) {
                return;
            }
            int i4 = iArr[i3];
            int i5 = i4 & 1;
            int i6 = 0;
            while (i6 < 8) {
                float f2 = 0.0f;
                while (true) {
                    i2 = i4 & 1;
                    if (i2 == i5) {
                        f2 += 1.0f;
                        i4 >>= 1;
                    }
                }
                a[i3][(8 - i6) - 1] = f2 / 17.0f;
                i6++;
                i5 = i2;
            }
            i3++;
        }
    }
}
