package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import c.b.a.m.d;
import c.b.a.m.l;
import c.b.a.m.q.c0.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamEncoder implements d<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final b byteArrayPool;

    public StreamEncoder(b bVar) {
        this.byteArrayPool = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // c.b.a.m.d
    public boolean encode(@NonNull InputStream inputStream, @NonNull File file, @NonNull l lVar) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.byteArrayPool.e(65536, byte[].class);
        boolean z = false;
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
            }
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    r1 = -1;
                    if (i2 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                } catch (IOException unused3) {
                    r1 = fileOutputStream;
                    Log.isLoggable(TAG, 3);
                    if (r1 != 0) {
                        r1.close();
                        r1 = r1;
                    }
                    this.byteArrayPool.d(bArr);
                    return z;
                } catch (Throwable th) {
                    th = th;
                    r1 = fileOutputStream;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException unused4) {
                        }
                    }
                    this.byteArrayPool.d(bArr);
                    throw th;
                }
                this.byteArrayPool.d(bArr);
                return z;
            }
            fileOutputStream.close();
            z = true;
            fileOutputStream.close();
            this.byteArrayPool.d(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
