package f.b0;

import f.c0.c.j;
import java.io.ByteArrayOutputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends ByteArrayOutputStream {
    public a(int i2) {
        super(i2);
    }

    @NotNull
    public final byte[] a() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        j.d(bArr, "buf");
        return bArr;
    }
}
