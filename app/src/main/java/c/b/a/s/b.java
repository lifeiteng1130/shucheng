package c.b.a.s;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends FilterInputStream {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f671b;

    public b(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        this.a = j2;
    }

    public final int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f671b += i2;
        } else if (this.a - ((long) this.f671b) > 0) {
            StringBuilder sbR = c.a.a.a.a.r("Failed to read all expected data, expected: ");
            sbR.append(this.a);
            sbR.append(", but read: ");
            sbR.append(this.f671b);
            throw new IOException(sbR.toString());
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.a - ((long) this.f671b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) {
        int i4;
        i4 = super.read(bArr, i2, i3);
        a(i4);
        return i4;
    }
}
