package c.b.a.m.r.d;

import androidx.annotation.NonNull;
import c.b.a.m.q.w;
import java.util.Objects;

/* JADX INFO: compiled from: BytesResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements w<byte[]> {
    public final byte[] a;

    public b(byte[] bArr) {
        Objects.requireNonNull(bArr, "Argument must not be null");
        this.a = bArr;
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // c.b.a.m.q.w
    @NonNull
    public byte[] get() {
        return this.a;
    }

    @Override // c.b.a.m.q.w
    public int getSize() {
        return this.a.length;
    }

    @Override // c.b.a.m.q.w
    public void recycle() {
    }
}
