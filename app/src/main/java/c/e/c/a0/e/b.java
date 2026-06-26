package c.e.c.a0.e;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: ByteMatrix.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final byte[][] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1339c;

    public b(int i2, int i3) {
        this.a = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.f1338b = i2;
        this.f1339c = i3;
    }

    public byte a(int i2, int i3) {
        return this.a[i3][i2];
    }

    public void b(int i2, int i3, int i4) {
        this.a[i3][i2] = (byte) i4;
    }

    public void c(int i2, int i3, boolean z) {
        this.a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f1338b * 2 * this.f1339c) + 2);
        for (int i2 = 0; i2 < this.f1339c; i2++) {
            byte[] bArr = this.a[i2];
            for (int i3 = 0; i3 < this.f1338b; i3++) {
                byte b2 = bArr[i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
