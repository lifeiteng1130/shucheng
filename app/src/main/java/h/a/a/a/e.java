package h.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: EpubResourceProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements k {
    public final String a;

    public e(String str) {
        this.a = str;
    }

    @Override // h.a.a.a.k
    public InputStream a(String str) throws IOException {
        ZipFile zipFile = new ZipFile(this.a);
        ZipEntry entry = zipFile.getEntry(str);
        if (entry != null) {
            return new q(zipFile.getInputStream(entry), zipFile);
        }
        zipFile.close();
        StringBuilder sbU = c.a.a.a.a.u("Cannot find entry ", str, " in epub file ");
        sbU.append(this.a);
        throw new IllegalStateException(sbU.toString());
    }
}
