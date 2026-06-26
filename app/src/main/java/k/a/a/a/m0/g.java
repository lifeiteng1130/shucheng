package k.a.a.a.m0;

import java.util.Arrays;

/* JADX INFO: compiled from: IntegerStack.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends f {
    public final int a() {
        int i2 = this.f8509c;
        int i3 = i2 - 1;
        if (i3 < 0 || i3 >= i2) {
            throw new IndexOutOfBoundsException();
        }
        int[] iArr = this.f8508b;
        int i4 = iArr[i3];
        System.arraycopy(iArr, i3 + 1, iArr, i3, (i2 - i3) - 1);
        int[] iArr2 = this.f8508b;
        int i5 = this.f8509c - 1;
        iArr2[i5] = 0;
        this.f8509c = i5;
        return i4;
    }

    public final void b(int i2) {
        int[] iArr = this.f8508b;
        int length = iArr.length;
        int i3 = this.f8509c;
        if (length == i3) {
            int i4 = i3 + 1;
            if (i4 < 0 || i4 > 2147483639) {
                throw new OutOfMemoryError();
            }
            int length2 = iArr.length == 0 ? 4 : iArr.length;
            while (length2 < i4) {
                length2 *= 2;
                if (length2 < 0 || length2 > 2147483639) {
                    length2 = 2147483639;
                }
            }
            this.f8508b = Arrays.copyOf(this.f8508b, length2);
        }
        int[] iArr2 = this.f8508b;
        int i5 = this.f8509c;
        iArr2[i5] = i2;
        this.f8509c = i5 + 1;
    }
}
