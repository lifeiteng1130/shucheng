package c.b.a.m.r.c;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.b.a.s.a;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ByteBufferBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements c.b.a.m.n<ByteBuffer, Bitmap> {
    public final m a;

    public g(m mVar) {
        this.a = mVar;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull c.b.a.m.l lVar) {
        Objects.requireNonNull(this.a);
        return true;
    }

    @Override // c.b.a.m.n
    public c.b.a.m.q.w<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        AtomicReference<byte[]> atomicReference = c.b.a.s.a.a;
        return this.a.b(new a.C0027a(byteBuffer), i2, i3, lVar, m.f528f);
    }
}
