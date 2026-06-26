package c.b.a.s;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: MarkEnforcingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends FilterInputStream {
    public int a;

    public g(@NonNull InputStream inputStream) {
        super(inputStream);
        this.a = Integer.MIN_VALUE;
    }

    public final long a(long j2) {
        int i2 = this.a;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i2 = this.a;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    public final void b(long j2) {
        int i2 = this.a;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.a = (int) (((long) i2) - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        super.mark(i2);
        this.a = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i2 = super.read();
        b(1L);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jA = a(j2);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int iA = (int) a(i3);
        if (iA == -1) {
            return -1;
        }
        int i4 = super.read(bArr, i2, iA);
        b(i4);
        return i4;
    }
}
