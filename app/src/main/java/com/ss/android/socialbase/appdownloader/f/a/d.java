package com.ss.android.socialbase.appdownloader.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: IntReader.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3389c;

    public d() {
    }

    public final void a(InputStream inputStream, boolean z) {
        this.a = inputStream;
        this.f3388b = z;
        this.f3389c = 0;
    }

    public final int b() {
        return a(4);
    }

    public final void c(int i2) throws IOException {
        if (i2 > 0) {
            long j2 = i2;
            long jSkip = this.a.skip(j2);
            this.f3389c = (int) (((long) this.f3389c) + jSkip);
            if (jSkip != j2) {
                throw new EOFException();
            }
        }
    }

    public d(InputStream inputStream, boolean z) {
        a(inputStream, z);
    }

    public final int[] b(int i2) {
        int[] iArr = new int[i2];
        a(iArr, 0, i2);
        return iArr;
    }

    public final void a() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            a(null, false);
        }
    }

    public final void c() throws IOException {
        c(4);
    }

    public final int a(int i2) throws IOException {
        if (i2 >= 0 && i2 <= 4) {
            int i3 = 0;
            if (this.f3388b) {
                for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                    int i5 = this.a.read();
                    if (i5 == -1) {
                        throw new EOFException();
                    }
                    this.f3389c++;
                    i3 |= i5 << i4;
                }
                return i3;
            }
            int i6 = i2 * 8;
            int i7 = 0;
            while (i3 != i6) {
                int i8 = this.a.read();
                if (i8 == -1) {
                    throw new EOFException();
                }
                this.f3389c++;
                i7 |= i8 << i3;
                i3 += 8;
            }
            return i7;
        }
        throw new IllegalArgumentException();
    }

    public final void a(int[] iArr, int i2, int i3) {
        while (i3 > 0) {
            iArr[i2] = b();
            i3--;
            i2++;
        }
    }
}
