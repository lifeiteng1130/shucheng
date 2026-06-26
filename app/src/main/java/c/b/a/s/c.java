package c.b.a.s;

import androidx.annotation.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionPassthroughInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends InputStream {

    @GuardedBy("POOL")
    public static final Queue<c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IOException f673c;

    static {
        char[] cArr = i.a;
        a = new ArrayDeque(0);
    }

    public void a() {
        this.f673c = null;
        this.f672b = null;
        Queue<c> queue = a;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f672b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f672b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f672b.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f672b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f672b.read();
        } catch (IOException e2) {
            this.f673c = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f672b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        try {
            return this.f672b.skip(j2);
        } catch (IOException e2) {
            this.f673c = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f672b.read(bArr);
        } catch (IOException e2) {
            this.f673c = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f672b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f673c = e2;
            throw e2;
        }
    }
}
