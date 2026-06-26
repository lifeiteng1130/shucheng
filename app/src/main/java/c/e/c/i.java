package c.e.c;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: LuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1345b;

    public i(int i2, int i3) {
        this.a = i2;
        this.f1345b = i3;
    }

    public abstract byte[] a();

    public abstract byte[] b(int i2, byte[] bArr);

    public boolean c() {
        return false;
    }

    public i d() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i2 = this.a;
        byte[] bArrB = new byte[i2];
        StringBuilder sb = new StringBuilder((i2 + 1) * this.f1345b);
        for (int i3 = 0; i3 < this.f1345b; i3++) {
            bArrB = b(i3, bArrB);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArrB[i4] & ExifInterface.MARKER;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
