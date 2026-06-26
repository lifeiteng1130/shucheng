package c.c.a.i$b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f753b = 0;

    public b(InputStream inputStream) {
        this.a = inputStream;
    }

    public final int[] a(int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i2 > 0) {
            iArr[i3] = b();
            i2--;
            i3++;
        }
        return iArr;
    }

    public final int b() throws IOException {
        int i2 = 0;
        for (int i3 = 0; i3 != 32; i3 += 8) {
            int i4 = this.a.read();
            if (i4 == -1) {
                throw new EOFException();
            }
            this.f753b++;
            i2 |= i4 << i3;
        }
        return i2;
    }

    public final void c() throws IOException {
        long jSkip = this.a.skip(4L);
        this.f753b = (int) (((long) this.f753b) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }
}
