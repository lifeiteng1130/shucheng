package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
public final class t implements c.b.a.m.n<InputStream, Bitmap> {
    public final d a = new d();

    @Override // c.b.a.m.n
    public /* bridge */ /* synthetic */ boolean a(@NonNull InputStream inputStream, @NonNull c.b.a.m.l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    @Nullable
    public c.b.a.m.q.w<Bitmap> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull c.b.a.m.l lVar) throws IOException {
        InputStream inputStream2 = inputStream;
        AtomicReference<byte[]> atomicReference = c.b.a.s.a.a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = c.b.a.s.a.a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i4 = inputStream2.read(andSet);
            if (i4 < 0) {
                c.b.a.s.a.a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return this.a.b(ImageDecoder.createSource((ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0)), i2, i3, lVar);
            }
            byteArrayOutputStream.write(andSet, 0, i4);
        }
    }
}
