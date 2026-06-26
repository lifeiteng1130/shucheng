package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

/* JADX INFO: compiled from: RandomAccessOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Closeable {
    private BufferedOutputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileDescriptor f3861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RandomAccessFile f3862c;

    public e(File file, int i2) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f3862c = randomAccessFile;
            this.f3861b = randomAccessFile.getFD();
            if (i2 <= 0) {
                this.a = new BufferedOutputStream(new FileOutputStream(this.f3862c.getFD()));
                return;
            }
            if (i2 < 8192) {
                i2 = 8192;
            } else if (i2 > 131072) {
                i2 = 131072;
            }
            this.a = new BufferedOutputStream(new FileOutputStream(this.f3862c.getFD()), i2);
        } catch (IOException e2) {
            throw new BaseException(1039, e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        this.a.write(bArr, i2, i3);
    }

    public void b() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void c() throws SyncFailedException {
        FileDescriptor fileDescriptor = this.f3861b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        f.a(this.f3862c, this.a);
    }

    public void a() {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f3861b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void b(long j2) throws IOException {
        this.f3862c.setLength(j2);
    }

    public void a(long j2) throws IOException {
        this.f3862c.seek(j2);
    }
}
