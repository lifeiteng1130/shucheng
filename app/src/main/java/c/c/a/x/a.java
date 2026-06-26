package c.c.a.x;

import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        int length = bArr.length;
        if (length + 0 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = length * 2;
        char[] cArr = new char[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = bArr[i4 + 0] & ExifInterface.MARKER;
            int i6 = i3 + 1;
            char[] cArr2 = a;
            cArr[i3] = cArr2[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = cArr2[i5 & 15];
        }
        return new String(cArr, 0, i2);
    }
}
