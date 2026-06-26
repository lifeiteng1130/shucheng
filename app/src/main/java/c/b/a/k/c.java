package c.b.a.k;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final Charset a = Charset.forName("US-ASCII");

    static {
        Charset.forName(DataUtil.defaultCharset);
    }

    public static void a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
