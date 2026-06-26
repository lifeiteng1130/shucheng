package h.a.a.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ResourceInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends FilterInputStream {
    public final ZipFile a;

    public q(InputStream inputStream, ZipFile zipFile) {
        super(inputStream);
        this.a = zipFile;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.a.close();
    }
}
