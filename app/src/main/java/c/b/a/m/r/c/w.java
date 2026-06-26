package c.b.a.m.r.c;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class w extends FilterInputStream {
    public volatile byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f557f;

    /* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
    public static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }

    public w(@NonNull InputStream inputStream, @NonNull c.b.a.m.q.c0.b bVar) {
        super(inputStream);
        this.f555d = -1;
        this.f557f = bVar;
        this.a = (byte[]) bVar.e(65536, byte[].class);
    }

    public static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f555d;
        if (i2 != -1) {
            int i3 = this.f556e - i2;
            int i4 = this.f554c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f553b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f557f.e(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                    this.f557f.d(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i5 = this.f556e - this.f555d;
                this.f556e = i5;
                this.f555d = 0;
                this.f553b = 0;
                int i6 = inputStream.read(bArr, i5, bArr.length - i5);
                int i7 = this.f556e;
                if (i6 > 0) {
                    i7 += i6;
                }
                this.f553b = i7;
                return i6;
            }
        }
        int i8 = inputStream.read(bArr);
        if (i8 > 0) {
            this.f555d = -1;
            this.f556e = 0;
            this.f553b = i8;
        }
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a == null || inputStream == null) {
            c();
            throw null;
        }
        return (this.f553b - this.f556e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.a != null) {
            this.f557f.d(this.a);
            this.a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a != null) {
            this.f557f.d(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f554c = Math.max(this.f554c, i2);
        this.f555d = this.f556e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            c();
            throw null;
        }
        if (this.f556e >= this.f553b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.a && (bArr = this.a) == null) {
            c();
            throw null;
        }
        int i2 = this.f553b;
        int i3 = this.f556e;
        if (i2 - i3 <= 0) {
            return -1;
        }
        this.f556e = i3 + 1;
        return bArr[i3] & ExifInterface.MARKER;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.a == null) {
            throw new IOException("Stream is closed");
        }
        int i2 = this.f555d;
        if (-1 == i2) {
            throw new a("Mark has been invalidated, pos: " + this.f556e + " markLimit: " + this.f554c);
        }
        this.f556e = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.a;
        if (bArr == null) {
            c();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            c();
            throw null;
        }
        int i2 = this.f553b;
        int i3 = this.f556e;
        if (i2 - i3 >= j2) {
            this.f556e = (int) (((long) i3) + j2);
            return j2;
        }
        long j3 = ((long) i2) - ((long) i3);
        this.f556e = i2;
        if (this.f555d == -1 || j2 > this.f554c) {
            long jSkip = inputStream.skip(j2 - j3);
            if (jSkip > 0) {
                this.f555d = -1;
            }
            return j3 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j3;
        }
        int i4 = this.f553b;
        int i5 = this.f556e;
        if (i4 - i5 >= j2 - j3) {
            this.f556e = (int) ((((long) i5) + j2) - j3);
            return j2;
        }
        long j4 = (j3 + ((long) i4)) - ((long) i5);
        this.f556e = i4;
        return j4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            c();
            throw null;
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i6 = this.f556e;
            int i7 = this.f553b;
            if (i6 < i7) {
                int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                System.arraycopy(bArr2, i6, bArr, i2, i8);
                this.f556e += i8;
                if (i8 == i3 || inputStream.available() == 0) {
                    return i8;
                }
                i2 += i8;
                i4 = i3 - i8;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f555d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.a && (bArr2 = this.a) == null) {
                        c();
                        throw null;
                    }
                    int i9 = this.f553b;
                    int i10 = this.f556e;
                    i5 = i9 - i10 >= i4 ? i4 : i9 - i10;
                    System.arraycopy(bArr2, i10, bArr, i2, i5);
                    this.f556e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            c();
            throw null;
        }
    }
}
