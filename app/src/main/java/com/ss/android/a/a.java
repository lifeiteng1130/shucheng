package com.ss.android.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FileRandomAccess.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private final RandomAccessFile a;

    public a(File file) {
        this.a = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.a.b
    public long a() {
        return this.a.length();
    }

    @Override // com.ss.android.a.b
    public void b() throws IOException {
        this.a.close();
    }

    @Override // com.ss.android.a.b
    public int a(byte[] bArr, int i2, int i3) {
        return this.a.read(bArr, i2, i3);
    }

    @Override // com.ss.android.a.b
    public void a(long j2, long j3) throws IOException {
        this.a.seek(j2);
    }
}
