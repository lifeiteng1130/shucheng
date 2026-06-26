package c.b.a.m.r.c;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
public final class h implements c.b.a.m.n<ByteBuffer, Bitmap> {
    public final d a = new d();

    @Override // c.b.a.m.n
    public /* bridge */ /* synthetic */ boolean a(@NonNull ByteBuffer byteBuffer, @NonNull c.b.a.m.l lVar) {
        return true;
    }

    @Override // c.b.a.m.n
    @Nullable
    public c.b.a.m.q.w<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        return this.a.b(ImageDecoder.createSource(byteBuffer), i2, i3, lVar);
    }
}
