package c.b.a.k;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Closeable {
    public final InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f270e;

    /* JADX INFO: compiled from: StrictLineReader.java */
    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.f267b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(c.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.f267b = charset;
        this.f268c = new byte[8192];
    }

    public final void a() throws IOException {
        InputStream inputStream = this.a;
        byte[] bArr = this.f268c;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 == -1) {
            throw new EOFException();
        }
        this.f269d = 0;
        this.f270e = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b() {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.a
            monitor-enter(r0)
            byte[] r1 = r7.f268c     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L83
            int r1 = r7.f269d     // Catch: java.lang.Throwable -> L8b
            int r2 = r7.f270e     // Catch: java.lang.Throwable -> L8b
            if (r1 < r2) goto L10
            r7.a()     // Catch: java.lang.Throwable -> L8b
        L10:
            int r1 = r7.f269d     // Catch: java.lang.Throwable -> L8b
        L12:
            int r2 = r7.f270e     // Catch: java.lang.Throwable -> L8b
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.f268c     // Catch: java.lang.Throwable -> L8b
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L8b
            if (r4 != r3) goto L42
            int r3 = r7.f269d     // Catch: java.lang.Throwable -> L8b
            if (r1 == r3) goto L2b
            int r3 = r1 + (-1)
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L8b
            r4 = 13
            if (r2 != r4) goto L2b
            goto L2c
        L2b:
            r3 = r1
        L2c:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L8b
            byte[] r4 = r7.f268c     // Catch: java.lang.Throwable -> L8b
            int r5 = r7.f269d     // Catch: java.lang.Throwable -> L8b
            int r3 = r3 - r5
            java.nio.charset.Charset r6 = r7.f267b     // Catch: java.lang.Throwable -> L8b
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L8b
            r2.<init>(r4, r5, r3, r6)     // Catch: java.lang.Throwable -> L8b
            int r1 = r1 + 1
            r7.f269d = r1     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return r2
        L42:
            int r1 = r1 + 1
            goto L12
        L45:
            c.b.a.k.b$a r1 = new c.b.a.k.b$a     // Catch: java.lang.Throwable -> L8b
            int r2 = r7.f270e     // Catch: java.lang.Throwable -> L8b
            int r4 = r7.f269d     // Catch: java.lang.Throwable -> L8b
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8b
        L51:
            byte[] r2 = r7.f268c     // Catch: java.lang.Throwable -> L8b
            int r4 = r7.f269d     // Catch: java.lang.Throwable -> L8b
            int r5 = r7.f270e     // Catch: java.lang.Throwable -> L8b
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L8b
            r2 = -1
            r7.f270e = r2     // Catch: java.lang.Throwable -> L8b
            r7.a()     // Catch: java.lang.Throwable -> L8b
            int r2 = r7.f269d     // Catch: java.lang.Throwable -> L8b
        L63:
            int r4 = r7.f270e     // Catch: java.lang.Throwable -> L8b
            if (r2 == r4) goto L51
            byte[] r4 = r7.f268c     // Catch: java.lang.Throwable -> L8b
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L8b
            if (r5 != r3) goto L80
            int r3 = r7.f269d     // Catch: java.lang.Throwable -> L8b
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L8b
        L76:
            int r2 = r2 + 1
            r7.f269d = r2     // Catch: java.lang.Throwable -> L8b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return r1
        L80:
            int r2 = r2 + 1
            goto L63
        L83:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8b
            throw r1     // Catch: java.lang.Throwable -> L8b
        L8b:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.k.b.b():java.lang.String");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (this.f268c != null) {
                this.f268c = null;
                this.a.close();
            }
        }
    }
}
