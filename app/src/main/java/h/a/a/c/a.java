package h.a.a.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: IOUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        if (inputStream == null) {
            return;
        }
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }
}
