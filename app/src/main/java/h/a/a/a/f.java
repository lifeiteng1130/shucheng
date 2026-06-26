package h.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: FileResourceProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements k {
    public String a;

    public f(String str) {
        this.a = str;
    }

    @Override // h.a.a.a.k
    public InputStream a(String str) {
        return new FileInputStream(new File(this.a, str));
    }
}
